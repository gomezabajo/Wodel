package wodel.metrics.dynamic.views;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import wodel.utils.manager.ModelManager;
import wodel.utils.manager.ProjectUtils;
import wodel.utils.manager.DynamicMutatorMetrics.WodelMetric;
import wodel.utils.manager.DynamicMutatorMetrics.WodelMetricAttribute;
import wodel.utils.manager.DynamicMutatorMetrics.WodelMetricBlock;
import wodel.utils.manager.DynamicMutatorMetrics.WodelMetricClass;
import wodel.utils.manager.DynamicMutatorMetrics.WodelMetricClassifier;
import wodel.utils.manager.DynamicMutatorMetrics.WodelMetricFeature;
import wodel.utils.manager.DynamicMutatorMetrics.WodelMetricItem;
import wodel.utils.manager.DynamicMutatorMetrics.WodelMetricModel;
import wodel.utils.manager.DynamicMutatorMetrics.WodelMetricMutant;
import wodel.utils.manager.DynamicMutatorMetrics.WodelMetricMutantsBlock;
import wodel.utils.manager.DynamicMutatorMetrics.WodelMetricReference;
import wodel.metrics.dynamic.NetMutatorMetrics;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.*;
import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.viewers.*;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.jface.action.*;
import org.eclipse.ui.*;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.SWT;
import org.osgi.framework.Bundle;

import wodel.utils.exceptions.MetaModelNotFoundException;

/**
 * @author Pablo Gomez-Abajo - Wodel net dynamic footprints view
 * 
 */

public class WodelMetricsDynamicView extends ViewPart implements ISelectionChangedListener, IEditorActionDelegate {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "wodel.metrics.dynamic.views.WodelMetricsDynamicView";

	private TreeViewer m_treeViewer;
	
	private Action doubleClickAction;
	
	private static final Color RED = new Color(Display.getCurrent(), 178, 34, 34);
	
	private static final Color AMBAR = new Color(Display.getCurrent(), 207, 179, 55);
	
	private static final Color GREEN = new Color(Display.getCurrent(), 0, 128, 0);
	
	private static final Color GRAY = new Color(Display.getCurrent(), 225, 225, 225);
	
	class ViewLabelProvider extends LabelProvider implements ILabelProvider {
		public String getColumnText(Object obj, int index) {
			return getText(obj);
		}

		public Image getColumnImage(Object obj, int index) {
			return getImage(obj);
		}

		public Image getImage(Object obj) {
			return PlatformUI.getWorkbench().getSharedImages()
					.getImage(ISharedImages.IMG_OBJ_ELEMENT);
		}
	}

	public void createPartControl(Composite parent) {
		if (ProjectUtils.isReadyProject() != true) {
			return;
		}
		try {
			String output = ModelManager.getOutputPath();
			String fileName = ProjectUtils.getFileName();
			if (fileName.endsWith(".mutator") == false) {
				//MessageBox msgbox = new MessageBox(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());
				//msgbox.setMessage("To show this view you have to right-click on the file .mutator opened in the editor");
				//msgbox.open();
				return;
			}
			Bundle bundle = Platform.getBundle("wodel.models");
	   		URL fileURL = bundle.getEntry("/model/MutatorMetrics.ecore");
	   		String metricsmetamodel = FileLocator.resolve(fileURL).getFile();
			//String metricsmetamodel = ModelManager.getWorkspaceAbsolutePath() + "/" + project + "/resources/MutatorMetrics.ecore";
			List<EPackage> metricspackages = ModelManager.loadMetaModel(metricsmetamodel);
			String metamodel = ModelManager.getMetaModel();
			List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
			File outputFolder = new File(output);
			List<String> models = new ArrayList<String>();
			for (File f : outputFolder.listFiles()) {
				if (f.isFile() && f.getName().endsWith("_metrics.model")) {
					String model = output +  "/" + f.getName();
					models.add(model);
				}
			}
			//String model = "file:/" + output +  "/" + fileName.replace(".mutator", "") + "_metrics.model";
			//if (new File(output +  "/" + fileName.replace(".mutator", "") + "_metrics.model").exists() == false) {
			if (models.size() == 0) {
				MessageBox msgbox = new MessageBox(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());
				msgbox.setMessage("The net footprint model has not been generated. Check Wodel Footprints Preferences page");
				msgbox.open();
				return;
			}
			List<WodelMetricClassifier> classifiers = new ArrayList<WodelMetricClassifier>();
			classifiers.addAll(Arrays.asList(NetMutatorMetrics.createWodelDynamicMetrics(models, metricspackages, packages)));
			
			Tree addressTree = new Tree(parent, SWT.BORDER | SWT.H_SCROLL
				| SWT.V_SCROLL);
			addressTree.setHeaderVisible(true);
			m_treeViewer = new TreeViewer(addressTree);
			TreeColumn column1 = new TreeColumn(addressTree, SWT.LEFT);
			addressTree.setLinesVisible(true);
			column1.setAlignment(SWT.LEFT);
			column1.setText("Models/Blocks/Mutants|Classes/Attributes/References");
			column1.setWidth(320);
			TreeColumn column2 = new TreeColumn(addressTree, SWT.RIGHT);
			column2.setAlignment(SWT.LEFT);
			int creation = 0;
			int modification = 0;
			int deletion = 0;
			int total = 0;
			for (WodelMetricClassifier classifier : classifiers) {
				for (WodelMetricItem item : classifier.getChildren()) {
					for (WodelMetricItem block : item.getChildren()) {
						if (block.getChildren().length > 0) {
							for (WodelMetricItem mutant : block.getChildren()) {
								if (mutant.ccreation > 0) {
									creation++;
								}
								if (mutant.cmodification > 0) {
									modification++;
								}
								if (mutant.cdeletion > 0) {
									deletion++;
								}
								total++;
							}
						}
						else {
							if (block instanceof WodelMetricBlock == false) {
								if (block.ccreation > 0) {
									creation++;
								}
								if (block.cmodification > 0) {
									modification++;
								}
								if (block.cdeletion > 0) {
									deletion++;
								}
								total++;
							}
						}
					}
				}
			}
			if (total != 0) {
				column2.setText(String.format("C.: %1$d%%", (creation*100/total)));
			}
			else {
				column2.setText(String.format("C.: %1$d%%", 0));
			}
			column2.setWidth(60);
			TreeColumn column3 = new TreeColumn(addressTree, SWT.RIGHT);
			column3.setAlignment(SWT.LEFT);
			if (total != 0) {
				column3.setText(String.format("M.: %1$d%%", (modification*100/total)));
			}
			else {
				column3.setText(String.format("M.: %1$d%%", 0));
			}
			column3.setWidth(60);
			TreeColumn column4 = new TreeColumn(addressTree, SWT.RIGHT);
			column4.setAlignment(SWT.LEFT);
			if (total != 0) {
				column4.setText(String.format("D.: %1$d%%", (deletion*100/total)));
			}
			else {
				column4.setText(String.format("D.: %1$d%%", 0));
			}
			column4.setWidth(60);
		
			m_treeViewer.setContentProvider(new WodelMetricsContentProvider());
			m_treeViewer.setLabelProvider(new TableLabelProvider());
			m_treeViewer.setInput(classifiers);
			m_treeViewer.collapseAll();
			createActions(new File(metamodel));
			//m_treeViewer.expandAll();
		} catch (MetaModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setFocus() {
		if (m_treeViewer.getControl() != null) {
			m_treeViewer.getControl().setFocus();
		}
	}
	
	public void createActions(File file) {
        
        doubleClickAction = new Action() {
			public void run() {
				ISelection selection = m_treeViewer.getSelection();
				Object obj = ((IStructuredSelection)selection).getFirstElement();
				if (obj instanceof WodelMetricMutantsBlock ||
						obj instanceof WodelMetricBlock ||
						obj instanceof WodelMetricModel ||
						obj instanceof WodelMetricMutant) {
					WodelMetricItem item = (WodelMetricItem) obj;
					File itemToShow = new File(item.getPath());
        		 
					if (itemToShow.exists()) {
						IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
						IViewPart view = page.findView(IPageLayout.ID_PROJECT_EXPLORER);
						IProject project = ProjectUtils.getProject();
						String path = itemToShow.getPath();
						String projectName = project.getName();
						String substringPath = path.substring(path.indexOf(projectName) + projectName.length() + 1);
						IResource resource = null;
						if (itemToShow.isFile()) {
							resource = project.getFile(substringPath);
						}
						else {
							resource = project.getFolder(substringPath);
						}
						((ISetSelectionTarget)view).selectReveal(new StructuredSelection(resource));
					}
				}
				if (obj instanceof WodelMetricMutant) {
					WodelMetricMutant mutant = (WodelMetricMutant) obj;
					if (mutant.getName().endsWith(".model")) {
						File fileToOpen = new File(mutant.getPath());
	        		 
						if (fileToOpen.exists() && fileToOpen.isFile()) {
							IFileStore fileStore = EFS.getLocalFileSystem().getStore(fileToOpen.toURI());
							IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
	        		 
							try {
								IDE.openEditorOnFileStore( page, fileStore );
							} catch ( PartInitException e ) {
	        		        //Put your exception handler here if you wish to
							}
						}
					}
				}
			}
		};
        
        // Add selection listener.
		m_treeViewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				doubleClickAction.run();
			}
		});
	}
	
	class WodelMetricsContentProvider implements ITreeContentProvider {
		public Object[] getChildren(Object parentElement) {
			if (parentElement instanceof List) {
				return ((List<?>) parentElement).toArray();
			}
			if (parentElement instanceof WodelMetricModel
					|| parentElement instanceof WodelMetricBlock
					|| parentElement instanceof WodelMetricMutantsBlock
					|| parentElement instanceof WodelMetricMutant) {
				ArrayList<Object> object = new ArrayList<Object>();
				WodelMetricItem metric = (WodelMetricItem) parentElement;
				WodelMetricClassifier[] classifiers = metric.getClassifiers();
				ArrayList<WodelMetricClassifier> classList = new ArrayList<WodelMetricClassifier>();
				for (WodelMetricClassifier cl : classifiers) {
					if (!cl.getName().equals("Classes")) {
						if (cl.getChildren().length > 0) {
							classList.add(cl);
						}
					}
					if (cl.getName().equals("Classes")) {
						if (cl.getClasses().length > 0) {
							classList.add(cl);
						}
					}
				}
				object.addAll(classList);
				Object[] ret = new Object[object.size()];
				object.toArray(ret);
				return ret;
			}
			if (parentElement instanceof WodelMetricClassifier) {
				WodelMetricClassifier classifier = (WodelMetricClassifier) parentElement;
				if (!classifier.getName().equals("Classes")) {
					return classifier.getChildren();
				}
				if (classifier.getName().equals("Classes")) {
					return classifier.getClasses();
				}
			}
			if (parentElement instanceof WodelMetricClass) {
				ArrayList<Object> object = new ArrayList<Object>();
				WodelMetricClass metric = (WodelMetricClass) parentElement;
				WodelMetricFeature[] features = metric.getFeatures();
				ArrayList<WodelMetricFeature> feats = new ArrayList<WodelMetricFeature>();
				for (WodelMetricFeature feat : features) {
					if (feat.getName().equals("Attributes")) {
						if (feat.getAttributes().length > 0) {
							feats.add(feat);
						}
					}
					if (feat.getName().equals("References")) {
						if (feat.getReferences().length > 0) {
							feats.add(feat);
						}
					}
				}
				object.addAll(feats);
				Object[] ret = new Object[object.size()];
				object.toArray(ret);
				return ret;
			}
			if (parentElement instanceof WodelMetricFeature) {
				WodelMetricFeature feature = (WodelMetricFeature) parentElement;
				if (feature.getName().equals("References")) {
					return feature.getReferences();
				}
				if (feature.getName().equals("Attributes")) {
					return feature.getAttributes();
				}
			}
			return new Object[0];
		}

		public Object getParent(Object element) {
			if (element instanceof WodelMetricModel
					|| element instanceof WodelMetricBlock
					|| element instanceof WodelMetricMutantsBlock
					|| element instanceof WodelMetricMutant) {
				return ((WodelMetricItem) element).getName();
			}
			if (element instanceof WodelMetricClassifier) {
				return ((WodelMetricClassifier) element).getName();
			}
			if (element instanceof WodelMetricClass) {
				return ((WodelMetricClass) element).getName();
			}
			if (element instanceof WodelMetricFeature) {
				return ((WodelMetricFeature) element).getName();
			}
			if (element instanceof WodelMetricReference) {
				return ((WodelMetricReference) element).getName();
			}
			if (element instanceof WodelMetricAttribute) {
				return ((WodelMetricAttribute) element).getName();
			}
			return null;
		}

		public boolean hasChildren(Object element) {
			if (element instanceof List) {
				return ((List<?>) element).size() > 0;
			}
			if (element instanceof WodelMetricModel
					|| element instanceof WodelMetricBlock
					|| element instanceof WodelMetricMutantsBlock
					|| element instanceof WodelMetricMutant) {
				return ((WodelMetricItem) element).getClassifiers().length > 0;
			}
			if (element instanceof WodelMetricClassifier) {
				WodelMetricClassifier classifier = (WodelMetricClassifier) element;
				if (!classifier.getName().equals("Classes")) {
					return classifier.getChildren().length > 0;
				}
				if (classifier.getName().equals("Classes")) {
					return classifier.getClasses().length > 0;
				}
			}
			if (element instanceof WodelMetricClass) {
				return ((WodelMetricClass) element).getFeatures().length > 0;
			}
			if (element instanceof WodelMetricFeature) {
				WodelMetricFeature feature = (WodelMetricFeature) element;
				if (feature.getName().equals("Attributes")) {
					return feature.getAttributes().length > 0;
				}
				if (feature.getName().equals("References")) {
					return feature.getReferences().length > 0;
				}
			}
			return false;
		}

		public Object[] getElements(Object metrics) {
			// cities ist das, was oben in setInput(..) gesetzt wurde.
			return getChildren(metrics);
		}

		public void dispose() {
		}
		
		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}
	}

	class TableLabelProvider implements ITableLabelProvider, ITableColorProvider {

		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		public String getColumnText(Object element, int columnIndex) {
			switch (columnIndex) {
			case 0:
				if (element instanceof WodelMetricModel
						|| element instanceof WodelMetricBlock
						|| element instanceof WodelMetricMutantsBlock
						|| element instanceof WodelMetricMutant) {
					return ((WodelMetricItem) element).getName();
				}
				if (element instanceof WodelMetricClassifier) {
					return ((WodelMetricClassifier) element).getName();
				}
				if (element instanceof WodelMetricClass) {
					return ((WodelMetricClass) element).getName();
				}
				if (element instanceof WodelMetricFeature) {
					return ((WodelMetricFeature) element).getName();
				}
				if (element instanceof WodelMetricAttribute || element instanceof WodelMetricReference) {
					return ((WodelMetric) element).getName();
				}
				break;
			case 1:
				if (element instanceof WodelMetricModel
						|| element instanceof WodelMetricBlock
						|| element instanceof WodelMetricMutantsBlock
						|| element instanceof WodelMetricMutant) {
					int creation = ((WodelMetricItem) element).creation;
					int ccreation = ((WodelMetricItem) element).ccreation;
					if (creation > 0 || ccreation > 0) {
						return String.format("%1$d", ccreation) + "c " + String.format("%1$d", creation) + "f";
					}
				}
				if (element instanceof WodelMetricClassifier) {
					WodelMetricClassifier classifier = (WodelMetricClassifier) element;
					int creation = classifier.getCreation();
					int ccreation = classifier.getClassCreation();
					if (creation > 0 || ccreation > 0) {
						return String.format("%1$d", ccreation) + "c " + String.format("%1$d", creation) + "f";
					}
				}
				if (element instanceof WodelMetricClass) {
					int creation = ((WodelMetricClass) element).creation;
					int ccreation = ((WodelMetricClass) element).ccreation;
					if (creation > 0 || ccreation > 0) {
						return String.format("%1$d", ccreation) + "c " + String.format("%1$d", creation) + "f";
					}
				}
				if (element instanceof WodelMetricFeature) {
					WodelMetricFeature feature = (WodelMetricFeature) element;
					if (feature.getName().equals("Attributes")) {
						int creation = feature.getAttributesCreation();
						if (creation > 0) {
							return String.format("%1$d", creation);
						}
					}
					if (feature.getName().equals("References")) {
						int creation = feature.getReferencesCreation();
						if (creation > 0) {
							return String.format("%1$d", creation);
						}
					}
				}
				if (element instanceof WodelMetricAttribute || element instanceof WodelMetricReference) {
					int creation = ((WodelMetric) element).creation;
					if (creation > 0) {
						return String.format("%1$d", creation);
					}
				}
				break;
			case 2:
				if (element instanceof WodelMetricModel
						|| element instanceof WodelMetricBlock
						|| element instanceof WodelMetricMutantsBlock
						|| element instanceof WodelMetricMutant) {
					int modification = ((WodelMetricItem) element).modification;
					int cmodification = ((WodelMetricItem) element).cmodification;
					if (modification > 0 || cmodification > 0) {
						return String.format("%1$d", cmodification) + "c " + String.format("%1$d", modification) + "f";
					}
				}
				if (element instanceof WodelMetricClassifier) {
					WodelMetricClassifier classifier = (WodelMetricClassifier) element;
					int modification = classifier.getModification();
					int cmodification = classifier.getClassModification();
					if (modification > 0 || cmodification > 0) {
						return String.format("%1$d", cmodification) + "c " + String.format("%1$d", modification) + "f";
					}
				}
				if (element instanceof WodelMetricClass) {
					int modification = ((WodelMetricClass) element).modification;
					int cmodification = ((WodelMetricClass) element).cmodification;
					if (modification > 0 || cmodification > 0) {
						return String.format("%1$d", cmodification) + "c " + String.format("%1$d", modification) + "f";
					}
				}
				if (element instanceof WodelMetricFeature) {
					WodelMetricFeature feature = (WodelMetricFeature) element;
					if (feature.getName().equals("Attributes")) {
						int modification = feature.getAttributesModification();
						if (modification > 0) {
							return String.format("%1$d", modification);
						}
					}
					if (feature.getName().equals("References")) {
						int modification = feature.getReferencesModification();
						if (modification > 0) {
							return String.format("%1$d", modification);
						}
					}
				}
				if (element instanceof WodelMetricAttribute || element instanceof WodelMetricReference) {
					int modification = ((WodelMetric) element).modification;
					if (modification > 0) {
						return String.format("%1$d", modification);
					}
				}
				break;
			case 3:
				if (element instanceof WodelMetricModel
						|| element instanceof WodelMetricBlock
						|| element instanceof WodelMetricMutantsBlock
						|| element instanceof WodelMetricMutant) {
					int deletion = ((WodelMetricItem) element).deletion;
					int cdeletion = ((WodelMetricItem) element).cdeletion;
					if (deletion > 0 || cdeletion > 0) {
						return String.format("%1$d", cdeletion) + "c " + String.format("%1$d", deletion) + "f";
					}
				}
				if (element instanceof WodelMetricClassifier) {
					WodelMetricClassifier classifier = (WodelMetricClassifier) element;
					int deletion = classifier.getDeletion();
					int cdeletion = classifier.getClassDeletion();
					if (deletion > 0 || cdeletion > 0) {
						return String.format("%1$d", cdeletion) + "c " + String.format("%1$d", deletion) + "f";
					}
				}
				if (element instanceof WodelMetricClass) {
					int deletion = ((WodelMetricClass) element).deletion;
					int cdeletion = ((WodelMetricClass) element).cdeletion;
					if (deletion > 0 || cdeletion > 0) {
						return String.format("%1$d", cdeletion) + "c " + String.format("%1$d", deletion) + "f";
					}
				}
				if (element instanceof WodelMetricFeature) {
					WodelMetricFeature feature = (WodelMetricFeature) element;
					if (feature.getName().equals("Attributes")) {
						int deletion = feature.getAttributesDeletion();
						if (deletion > 0) {
							return String.format("%1$d", deletion);
						}
					}
					if (feature.getName().equals("References")) {
						int deletion = feature.getReferencesDeletion();
						if (deletion > 0) {
							return String.format("%1$d", deletion);
						}
					}
				}
				if (element instanceof WodelMetricAttribute || element instanceof WodelMetricReference) {
					int deletion = ((WodelMetric) element).deletion;
					if (deletion > 0) {
						return String.format("%1$d", deletion);
					}
				}
				break;
			}
			return null;
		}

		@Override
		public void addListener(ILabelProviderListener listener) {
		}

		public void dispose() {
		}

		public boolean isLabelProperty(Object element, String property) {
			return false;
		}

		@Override
		public void removeListener(ILabelProviderListener listener) {
		}

		@Override
		public Color getForeground(Object element, int columnIndex) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Color getBackground(Object element, int columnIndex) {
			switch (columnIndex) {
			case 0:
				break;
			case 1:
				if (element instanceof WodelMetricModel
						|| element instanceof WodelMetricBlock
						|| element instanceof WodelMetricMutantsBlock
						|| element instanceof WodelMetricMutant) {
					WodelMetricItem item = (WodelMetricItem) element;
					if (item.creation == 0 && item.ccreation == 0) {
						return GRAY;
					}
					else {
						return GREEN;
					}
				}
				if (element instanceof WodelMetricClassifier) {
					WodelMetricClassifier classifier = (WodelMetricClassifier) element;
					if (classifier.getCreation() == 0 && classifier.getClassCreation() == 0) {
						return GRAY;
					}
					else {
						return GREEN;
					}
				}
				if (element instanceof WodelMetricClass) {
					WodelMetricClass cl = (WodelMetricClass) element;
					if (cl.creation == 0 && cl.ccreation == 0) {
						return GRAY;
					}
					else {
						return GREEN;
					}
				}
				if (element instanceof WodelMetricFeature) {
					WodelMetricFeature feature = (WodelMetricFeature) element;
					if (feature.getName().equals("Attributes")) {
						if (feature.getAttributesCreation() == 0){
							return GRAY;
						}
						else {
							return GREEN;
						}
					}
					if (feature.getName().equals("References")) {
						if (feature.getReferencesCreation() == 0) {
							return GRAY;
						}
						else {
							return GREEN;
						}
					}
				}
				if (element instanceof WodelMetricAttribute || element instanceof WodelMetricReference) {
					WodelMetric feature = (WodelMetric) element;
					if (feature.creation == 0) {
						return GRAY;
					}
					else {
						return GREEN;
					}
				}
				break;
			case 2:
				if (element instanceof WodelMetricModel
						|| element instanceof WodelMetricBlock
						|| element instanceof WodelMetricMutantsBlock
						|| element instanceof WodelMetricMutant) {
					WodelMetricItem item = (WodelMetricItem) element;
					if (item.modification == 0 && item.cmodification == 0) {
						return GRAY;
					}
					else {
						return AMBAR;
					}
				}
				if (element instanceof WodelMetricClassifier) {
					WodelMetricClassifier classifier = (WodelMetricClassifier) element;
					if (classifier.getModification() == 0 && classifier.getClassModification() == 0) {
						return GRAY;
					}
					else {
						return AMBAR;
					}
				}
				if (element instanceof WodelMetricClass) {
					WodelMetricClass cl = (WodelMetricClass) element;
					if (cl.modification == 0 && cl.cmodification == 0) {
						return GRAY;
					}
					else {
						return AMBAR;
					}
				}
				if (element instanceof WodelMetricFeature) {
					WodelMetricFeature feature = (WodelMetricFeature) element;
					if (feature.getName().equals("Attributes")) {
						if (feature.getAttributesModification() == 0){
							return GRAY;
						}
						else {
							return AMBAR;
						}
					}
					if (feature.getName().equals("References")) {
						if (feature.getReferencesModification() == 0) {
							return GRAY;
						}
						else {
							return AMBAR;
						}
					}
				}
				if (element instanceof WodelMetricAttribute || element instanceof WodelMetricReference) {
					WodelMetric feature = (WodelMetric) element;
					if (feature.modification == 0) {
						return GRAY;
					}
					else {
						return AMBAR;
					}
				}
				break;
			case 3:
				if (element instanceof WodelMetricModel
						|| element instanceof WodelMetricBlock
						|| element instanceof WodelMetricMutantsBlock
						|| element instanceof WodelMetricMutant) {
					WodelMetricItem item = (WodelMetricItem) element;
					if (item.deletion == 0 && item.cdeletion == 0) {
						return GRAY;
					}
					else {
						return RED;
					}
				}
				if (element instanceof WodelMetricClassifier) {
					WodelMetricClassifier classifier = (WodelMetricClassifier) element;
					if (classifier.getDeletion() == 0 && classifier.getClassDeletion() == 0) {
						return GRAY;
					}
					else {
						return RED;
					}
				}
				if (element instanceof WodelMetricClass) {
					WodelMetricClass cl = (WodelMetricClass) element;
					if (cl.deletion == 0 && cl.cdeletion == 0) {
						return GRAY;
					}
					else {
						return RED;
					}
				}
				if (element instanceof WodelMetricFeature) {
					WodelMetricFeature feature = (WodelMetricFeature) element;
					if (feature.getName().equals("Attributes")) {
						if (feature.getAttributesDeletion() == 0){
							return GRAY;
						}
						else {
							return RED;
						}
					}
					if (feature.getName().equals("References")) {
						if (feature.getReferencesDeletion() == 0) {
							return GRAY;
						}
						else {
							return RED;
						}
					}
				}
				if (element instanceof WodelMetricAttribute || element instanceof WodelMetricReference) {
					WodelMetric feature = (WodelMetric) element;
					if (feature.deletion == 0) {
						return GRAY;
					}
					else {
						return RED;
					}
				}
				break;
			}
			return null;
		}
	}

	@Override
	public void run(IAction action) {
		try { 
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(WodelMetricsDynamicView.ID);
		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setActiveEditor(IAction action, IEditorPart targetEditor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectionChanged(SelectionChangedEvent event) {
		// TODO Auto-generated method stub
		
	}
}