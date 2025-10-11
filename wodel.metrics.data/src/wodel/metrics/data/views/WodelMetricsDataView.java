package wodel.metrics.data.views;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import wodel.utils.manager.ModelManager;
import wodel.utils.manager.MutatorUtils;
import wodel.utils.manager.ProjectUtils;
import mutatorenvironment.MutatorEnvironment;
import wodel.metrics.data.MutatorData;
import wodel.metrics.data.MutatorData.MutatorDataClass;
import wodel.metrics.data.MutatorData.MutatorDataFeature;
import wodel.metrics.data.MutatorData.MutatorDataMutant;
import wodel.metrics.data.MutatorData.MutatorDataSeed;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.part.*;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.*;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.jface.action.*;
import org.eclipse.ui.*;
import org.eclipse.swt.SWT;
import org.osgi.framework.Bundle;

import wodel.utils.exceptions.MetaModelNotFoundException;
import wodel.utils.exceptions.ModelNotFoundException;

/**
 * @author Pablo Gomez-Abajo - Wodel applied mutations information view
 * 
 */

public class WodelMetricsDataView extends ViewPart implements ISelectionChangedListener, IEditorActionDelegate {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "wodel.metrics.data.views.WodelMetricsDataView";

	private TreeViewer m_treeViewer;

	private static List<MutatorDataClass> metrics = null;
	
	private static int numberOfSeedModels = 0;


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

	private String getRelativePath(String path, String project) {
		return path.substring(path.indexOf(project) + project.length(), path.length());
	}

	public void createPartControl(Composite parent) {
		if (ProjectUtils.projectsAreReady() == null) {
			return;
		}
		try {
			String output = ModelManager.getOutputPath();
			String metamodel = ModelManager.getMetaModel();
			String fileName = ProjectUtils.getFileName();
			if (fileName.endsWith(".mutator") == false) {
				//MessageBox msgbox = new MessageBox(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());
				//msgbox.setMessage("To show this view you have to right-click on the file .mutator opened in the editor");
				//msgbox.open();
				return;
			}
			String xmiFileName = "file:/" + output +  "/" + fileName.replace(".mutator", ".model");
			metrics = new ArrayList<MutatorDataClass>();
			metrics.addAll(Arrays.asList(MutatorData.createMutatorInfoMetrics(xmiFileName, metamodel)));

			Bundle bundle = Platform.getBundle("wodel.models");
			URL fileURL = bundle.getEntry("/model/MutatorEnvironment.ecore");
			String mutatorecore = FileLocator.resolve(fileURL).getFile();
			List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
			Resource program = ModelManager.loadModel(mutatorpackages, URI.createURI(xmiFileName).toFileString());
			String path = Platform.getLocation().toFile().getPath() + '/' + ProjectUtils.getProject().getName();
			numberOfSeedModels = MutatorUtils.getNumberOfSeedModels((MutatorEnvironment) ModelManager.getRoot(program), path);

			Tree addressTree = new Tree(parent, SWT.BORDER | SWT.H_SCROLL
					| SWT.V_SCROLL | SWT.FULL_SELECTION);
			addressTree.setHeaderVisible(true);
			addressTree.setLinesVisible(true);
			addressTree.addListener(SWT.MouseDoubleClick, new Listener() {
				@Override
				public void handleEvent(Event event) {
				}
			});
			m_treeViewer = new TreeViewer(addressTree);
			TreeColumn column1 = new TreeColumn(addressTree, SWT.LEFT);
			column1.setAlignment(SWT.LEFT);
			column1.setText("Operator/Seed");
			column1.setWidth(300);
			TreeColumn column2 = new TreeColumn(addressTree, SWT.RIGHT | SWT.FULL_SELECTION);
			column2.setAlignment(SWT.LEFT);
			column2.setText("Mutants");
			column2.setWidth(300);

			m_treeViewer.setContentProvider(new WodelMetricsContentProvider());
			m_treeViewer.setLabelProvider(new TableLabelProvider());
			m_treeViewer.setInput(metrics);
			m_treeViewer.collapseAll();
			createActions(new File(metamodel));
			//m_treeViewer.expandAll();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MetaModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ModelNotFoundException e) {
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
        // Add selection listener.
        m_treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
        	public void selectionChanged(SelectionChangedEvent event) {
        		//updateActionEnablement();
        	}
        });
	}
	
	class WodelMetricsContentProvider implements ITreeContentProvider {
		public Object[] getChildren(Object parentElement) {
			if (parentElement instanceof List) {
				return ((List<?>) parentElement).toArray();
			}
			if (parentElement instanceof MutatorDataClass) {
				MutatorDataFeature[] features = ((MutatorDataClass) parentElement).getFeatures();
				ArrayList<MutatorDataFeature> feats = new ArrayList<MutatorDataFeature>();
				for (MutatorDataFeature feat : features) {
					if (feat.getName().equals("Seeds")) {
						if (feat.getSeeds().length > 0) {
							feats.add(feat);
						}
					}
				}
				MutatorDataFeature[] ret = new MutatorDataFeature[feats.size()];
				feats.toArray(ret);
				return ret;
			}
			if (parentElement instanceof MutatorDataFeature) {
				MutatorDataFeature feature = (MutatorDataFeature) parentElement;
				if (feature.getName().equals("Seeds")) {
					return feature.getSeeds();
				}
			}
			if (parentElement instanceof MutatorDataSeed) {
				MutatorDataSeed seed = (MutatorDataSeed) parentElement;
				return seed.getMutants();
			}
			return new Object[0];
		}

		public Object getParent(Object element) {
			if (element instanceof MutatorDataClass) {
				return ((MutatorDataClass) element).getName();
			}
			if (element instanceof MutatorDataFeature) {
				return ((MutatorDataFeature) element).getName();
			}
			if (element instanceof MutatorDataSeed) {
				return ((MutatorDataSeed) element).getPath();
			}
			if (element instanceof MutatorDataMutant) {
				return ((MutatorDataMutant) element).getPath();
			}
			return null;
		}

		public boolean hasChildren(Object element) {
			if (element instanceof List) {
				return ((List<?>) element).size() > 0;
			}
			if (element instanceof MutatorDataClass) {
				return ((MutatorDataClass) element).getFeatures().length > 0;
			}
			if (element instanceof MutatorDataFeature) {
				MutatorDataFeature feature = (MutatorDataFeature) element;
				if (feature.getName().equals("Seeds")) {
					return feature.getSeeds().length > 0;
				}
			}
			if (element instanceof MutatorDataSeed) {
				return ((MutatorDataSeed) element).getMutants().length > 0;
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
	
	/**
     * Returns the image descriptor with the given relative path.
     */
    private ImageDescriptor getImageDescriptor(String relativePath) {
    	String iconPath = "icons/";
        try {
        	Bundle bundle = Platform.getBundle("wodel.metrics.data");
        	URL installURL = bundle.getEntry("/");
			URL url = new URL(installURL, iconPath + relativePath);
            return ImageDescriptor.createFromURL(url);
        }
        catch (MalformedURLException e) {
        	// should not happen
        	return ImageDescriptor.getMissingImageDescriptor();
        }
    }

	class TableLabelProvider implements ITableLabelProvider, ITableColorProvider {

		private final ImageDescriptor ok = getImageDescriptor("ok.jpg");		
		private final ImageDescriptor incomplete = getImageDescriptor("incomplete.jpg");		
		private final ImageDescriptor wrong = getImageDescriptor("wrong.jpg");		

		public Image getImage(Object obj) {
			// TODO Auto-generated method stub
			if (obj instanceof MutatorDataClass) {
				MutatorDataClass infoClass = (MutatorDataClass) obj;
				int length = infoClass.getSeeds().length;
				if (length == numberOfSeedModels) {
					return ok.createImage();
				}
				else if (length > 0) {
					return incomplete.createImage();
				}
				else {
					return wrong.createImage();
				}
			}
			return null;
		}
		/* (non-Javadoc)
		* @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnImage(java.lang.Object, int)
		*/
		public Image getColumnImage(Object element, int columnIndex) {
			if (columnIndex == 0) {
				return getImage(element);
			}
			return null;
		}
		 
		public String getColumnText(Object element, int columnIndex) {
			IProject iProject = ProjectUtils.getProject();
			switch (columnIndex) {
			case 0:
				if (element instanceof MutatorDataClass) {
					return ((MutatorDataClass) element).getName();
				}
				if (element instanceof MutatorDataFeature) {
					int count = 0;
					for (MutatorDataSeed infoSeed : ((MutatorDataFeature) element).getSeeds()) {
						count += infoSeed.getMutants().length;
					}
					return ((MutatorDataFeature) element).getName() + " (" + ((MutatorDataFeature) element).getSeeds().length + " s./" + count + " m.)";
				}
				if (element instanceof MutatorDataSeed) {
					return getRelativePath(((MutatorDataSeed) element).getPath(), iProject.getName()) + " (" + ((MutatorDataSeed) element).getMutants().length + "m.)";
				}
				break;
			case 1:
				if (element instanceof MutatorDataMutant) {
					return getRelativePath(((MutatorDataMutant) element).getPath(), iProject.getName());
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
			// TODO Auto-generated method stub
			return null;
		}
	}

	@Override
	public void run(IAction action) {
		try { 
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(WodelMetricsDataView.ID);
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