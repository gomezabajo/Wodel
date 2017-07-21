package wodel.metrics.command.views;


import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import metrics.CommandMutatorMetrics;
import manager.WodelContext;
import metrics.CommandMutatorMetrics.WodelMetricClass;
import metrics.CommandMutatorMetrics.WodelMetricCommand;
import metrics.CommandMutatorMetrics.WodelMetricFeature;
import metrics.CommandMutatorMetrics.WodelMetricAttribute;
import metrics.CommandMutatorMetrics.WodelMetricReference;
import manager.ModelManager;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.part.*;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.*;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.*;
import org.eclipse.swt.SWT;


/**
 * This sample class demonstrates how to plug-in a new
 * workbench view. The view shows data obtained from the
 * model. The sample creates a dummy model on the fly,
 * but a real implementation would connect to the model
 * available either in this or another plug-in (e.g. the workspace).
 * The view is connected to the model using a content provider.
 * <p>
 * The view uses a label provider to define how model
 * objects should be presented in the view. Each
 * view can present the same model objects using
 * different labels and icons, if needed. Alternatively,
 * a single label provider can be shared between views
 * in order to ensure that objects of the same type are
 * presented in the same way everywhere.
 * <p>
 */

public class WodelMetricsCommandView extends ViewPart implements IEditorActionDelegate {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "wodel.metrics.command.views.WodelMetricsCommandView";
	
	private TreeViewer m_treeViewer;

	private static final Color RED = new Color(Display.getCurrent(), 178, 34, 34);
	
	private static final Color AMBAR = new Color(Display.getCurrent(), 207, 179, 55);
	
	private static final Color GREEN = new Color(Display.getCurrent(), 0, 128, 0);
	
	private static final Color GRAY = new Color(Display.getCurrent(), 225, 225, 225);
	
	private static final Color PURPLE = new Color(Display.getCurrent(), 224, 96, 224);
	
	private static final Color BROWN = new Color(Display.getCurrent(), 171, 101, 53);
	
	private static final Color BLUE = new Color(Display.getCurrent(), 66, 134, 244);
		
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
	
	@Override
	public void createPartControl(Composite parent) {
		WodelContext.setProject(null);
		String output = ModelManager.getOutputPath();
		String metamodel = ModelManager.getMetaModel();
		String xmiFileName = "file:/" + output +  "/" + manager.WodelContext.getProject() + ".model";
		List<WodelMetricCommand> metrics = new ArrayList<WodelMetricCommand>();
		metrics.addAll(Arrays.asList(CommandMutatorMetrics.createWodelCommandMetrics(xmiFileName, metamodel)));

		Tree addressTree = new Tree(parent, SWT.BORDER | SWT.H_SCROLL
				| SWT.V_SCROLL);
		addressTree.setHeaderVisible(true);
		m_treeViewer = new TreeViewer(addressTree);
		TreeColumn column1 = new TreeColumn(addressTree, SWT.LEFT);
		addressTree.setLinesVisible(true);
		column1.setAlignment(SWT.LEFT);
		column1.setText("Blocks/Commands|Class/Attributes/References");
		column1.setWidth(320);
		TreeColumn column2 = new TreeColumn(addressTree, SWT.RIGHT);
		column2.setAlignment(SWT.LEFT);
		int creation = 0;
		int modification = 0;
		int deletion = 0;
		int icreation = 0;
		int imodification = 0;
		int ideletion = 0;
		for (WodelMetricCommand metric : metrics) {
			if (metric.ccreation > 0) {
				creation++;
			}
			if (metric.mmodification > 0) {
				modification++;
			}
			if (metric.ddeletion > 0) {
				deletion++;
			}
			if (metric.iccreation > 0 ) {
				icreation++;
			}
			if (metric.immodification > 0) {
				imodification++;
			}
			if (metric.iddeletion > 0) {
				ideletion++;
			}
		}
		column2.setText(String.format("C.: %1$d%%", (creation*100/metrics.size())));
		column2.setWidth(60);
		TreeColumn column3 = new TreeColumn(addressTree, SWT.RIGHT);
		column3.setAlignment(SWT.LEFT);
		column3.setText(String.format("M.: %1$d%%", (modification*100/metrics.size())));
		column3.setWidth(60);
		TreeColumn column4 = new TreeColumn(addressTree, SWT.RIGHT);
		column4.setAlignment(SWT.LEFT);
		column4.setText(String.format("D.: %1$d%%", (deletion*100/metrics.size())));
		column4.setWidth(60);
		TreeColumn column5 = new TreeColumn(addressTree, SWT.RIGHT);
		column5.setAlignment(SWT.LEFT);
		column5.setText(String.format("IC.: %1$d%%", (icreation*100/metrics.size())));
		column5.setWidth(60);
		TreeColumn column6 = new TreeColumn(addressTree, SWT.RIGHT);
		column6.setAlignment(SWT.LEFT);
		column6.setText(String.format("IM.: %1$d%%", (imodification*100/metrics.size())));
		column6.setWidth(60);
		TreeColumn column7 = new TreeColumn(addressTree, SWT.RIGHT);
		column7.setAlignment(SWT.LEFT);
		column7.setText(String.format("ID.: %1$d%%", (ideletion*100/metrics.size())));
		column7.setWidth(60);

		m_treeViewer.setContentProvider(new WodelMetricsContentProvider());
		m_treeViewer.setLabelProvider(new TableLabelProvider());
		m_treeViewer.setInput(metrics);
		m_treeViewer.collapseAll();
		createActions(new File(metamodel));
		//createToolbar();
		//m_treeViewer.expandAll();
		
	}
	
	public void createActions(File file) {
		
	}
	
	class WodelMetricsContentProvider implements ITreeContentProvider {

		@Override
		public void dispose() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Object[] getElements(Object metrics) {
			return getChildren(metrics);
		}

		@Override
		public Object[] getChildren(Object parentElement) {
			if (parentElement instanceof List) {
				return ((List<?>) parentElement).toArray();
			}
			if (parentElement instanceof WodelMetricCommand) {
				WodelMetricCommand metricCommand = (WodelMetricCommand) parentElement;
				if (metricCommand.getChildren().length > 0) {
					return metricCommand.getChildren();
				}
				if (metricCommand.getClasses().length > 0) {
					return metricCommand.getClasses();
				}
			}
			if (parentElement instanceof WodelMetricClass) {
				WodelMetricFeature[] features = ((WodelMetricClass) parentElement).getFeatures();
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
				WodelMetricFeature[] ret = new WodelMetricFeature[feats.size()];
				feats.toArray(ret);
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

		@Override
		public Object getParent(Object element) {
			if (element instanceof WodelMetricCommand) {
				return ((WodelMetricCommand) element).getName();
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

		@Override
		public boolean hasChildren(Object element) {
			if (element instanceof List) {
				return ((List<?>) element).size() > 0;
			}
			if (element instanceof WodelMetricCommand) {
				return (((WodelMetricCommand) element).getChildren().length > 0 || ((WodelMetricCommand) element).getClasses().length > 0);
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
	}
	
	class TableLabelProvider implements ITableLabelProvider, ITableColorProvider {

		@Override
		public void addListener(ILabelProviderListener listener) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void dispose() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean isLabelProperty(Object element, String property) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void removeListener(ILabelProviderListener listener) {
			// TODO Auto-generated method stub
			
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
				if (element instanceof WodelMetricCommand) {
					WodelMetricCommand item = (WodelMetricCommand) element;
					if (item.creation == 0 && item.ccreation == 0) {
						return GRAY;
					}
					else {
						return GREEN;
					}
				}
				if (element instanceof WodelMetricClass) {
					WodelMetricClass item = (WodelMetricClass) element;
					if (item.creation == 0 && item.ccreation == 0) {
						return GRAY;
					}
					else {
						return GREEN;
					}
				}
				if (element instanceof WodelMetricFeature) {
					WodelMetricFeature feature = (WodelMetricFeature) element;
					if (feature.getName().equals("Attributes")) {
						if (feature.getAttributesCreation() == 0) {
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
				if (element instanceof WodelMetricAttribute) {
					WodelMetricAttribute attribute = (WodelMetricAttribute) element;
					if (attribute.creation == 0) {
						return GRAY;
					}
					else {
						return GREEN;
					}
				}
				if (element instanceof WodelMetricReference) {
					WodelMetricReference reference = (WodelMetricReference) element;
					if (reference.creation == 0) {
						return GRAY;
					}
					else {
						return GREEN;
					}
				}
				break;
			case 2:
				if (element instanceof WodelMetricCommand) {
					WodelMetricCommand item = (WodelMetricCommand) element;
					if (item.modification == 0 && item.mmodification == 0) {
						return GRAY;
					}
					else {
						return AMBAR;
					}
				}
				if (element instanceof WodelMetricClass) {
					WodelMetricClass item = (WodelMetricClass) element;
					if (item.modification == 0 && item.mmodification == 0) {
						return GRAY;
					}
					else {
						return AMBAR;
					}
				}
				if (element instanceof WodelMetricFeature) {
					WodelMetricFeature feature = (WodelMetricFeature) element;
					if (feature.getName().equals("Attributes")) {
						if (feature.getAttributesModification() == 0) {
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
				if (element instanceof WodelMetricAttribute) {
					WodelMetricAttribute attribute = (WodelMetricAttribute) element;
					if (attribute.modification == 0) {
						return GRAY;
					}
					else {
						return AMBAR;
					}
				}
				if (element instanceof WodelMetricReference) {
					WodelMetricReference reference = (WodelMetricReference) element;
					if (reference.modification == 0) {
						return GRAY;
					}
					else {
						return AMBAR;
					}
				}
				break;
			case 3:
				if (element instanceof WodelMetricCommand) {
					WodelMetricCommand item = (WodelMetricCommand) element;
					if (item.deletion == 0 && item.ddeletion == 0) {
						return GRAY;
					}
					else {
						return RED;
					}
				}
				if (element instanceof WodelMetricClass) {
					WodelMetricClass item = (WodelMetricClass) element;
					if (item.deletion == 0 && item.ddeletion == 0) {
						return GRAY;
					}
					else {
						return RED;
					}
				}
				if (element instanceof WodelMetricFeature) {
					WodelMetricFeature feature = (WodelMetricFeature) element;
					if (feature.getName().equals("Attributes")) {
						if (feature.getAttributesDeletion() == 0) {
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
				if (element instanceof WodelMetricAttribute) {
					WodelMetricAttribute attribute = (WodelMetricAttribute) element;
					if (attribute.deletion == 0) {
						return GRAY;
					}
					else {
						return RED;
					}
				}
				if (element instanceof WodelMetricReference) {
					WodelMetricReference reference = (WodelMetricReference) element;
					if (reference.deletion == 0) {
						return GRAY;
					}
					else {
						return RED;
					}
				}
				break;
			case 4:
				if (element instanceof WodelMetricCommand) {
					WodelMetricCommand item = (WodelMetricCommand) element;
					if (item.icreation == 0 && item.iccreation == 0) {
						return GRAY;
					}
					else {
						return PURPLE;
					}
				}
				if (element instanceof WodelMetricClass) {
					WodelMetricClass item = (WodelMetricClass) element;
					if (item.icreation == 0 && item.iccreation == 0) {
						return GRAY;
					}
					else {
						return PURPLE;
					}
				}
				if (element instanceof WodelMetricFeature) {
					WodelMetricFeature feature = (WodelMetricFeature) element;
					if (feature.getName().equals("Attributes")) {
						if (feature.getAttributesImplicitCreation() == 0) {
							return GRAY;
						}
						else {
							return PURPLE;
						}
					}
					if (feature.getName().equals("References")) {
						if (feature.getReferencesImplicitCreation() == 0) {
							return GRAY;
						}
						else {
							return PURPLE;
						}
					}
				}
				if (element instanceof WodelMetricAttribute) {
					WodelMetricAttribute attribute = (WodelMetricAttribute) element;
					if (attribute.icreation == 0) {
						return GRAY;
					}
					else {
						return PURPLE;
					}
				}
				if (element instanceof WodelMetricReference) {
					WodelMetricReference reference = (WodelMetricReference) element;
					if (reference.icreation == 0) {
						return GRAY;
					}
					else {
						return PURPLE;
					}
				}
				break;
			case 5:
				if (element instanceof WodelMetricCommand) {
					WodelMetricCommand item = (WodelMetricCommand) element;
					if (item.imodification == 0 && item.immodification == 0) {
						return GRAY;
					}
					else {
						return BROWN;
					}
				}
				if (element instanceof WodelMetricClass) {
					WodelMetricClass item = (WodelMetricClass) element;
					if (item.imodification == 0 && item.immodification == 0) {
						return GRAY;
					}
					else {
						return BROWN;
					}
				}
				if (element instanceof WodelMetricFeature) {
					WodelMetricFeature feature = (WodelMetricFeature) element;
					if (feature.getName().equals("Attributes")) {
						if (feature.getAttributesImplicitModification() == 0) {
							return GRAY;
						}
						else {
							return BROWN;
						}
					}
					if (feature.getName().equals("References")) {
						if (feature.getReferencesImplicitModification() == 0) {
							return GRAY;
						}
						else {
							return BROWN;
						}
					}
				}
				if (element instanceof WodelMetricAttribute) {
					WodelMetricAttribute attribute = (WodelMetricAttribute) element;
					if (attribute.imodification == 0) {
						return GRAY;
					}
					else {
						return BROWN;
					}
				}
				if (element instanceof WodelMetricReference) {
					WodelMetricReference reference = (WodelMetricReference) element;
					if (reference.imodification == 0) {
						return GRAY;
					}
					else {
						return BROWN;
					}
				}
				break;
			case 6:
				if (element instanceof WodelMetricCommand) {
					WodelMetricCommand item = (WodelMetricCommand) element;
					if (item.ideletion == 0 && item.iddeletion == 0) {
						return GRAY;
					}
					else {
						return BLUE;
					}
				}
				if (element instanceof WodelMetricClass) {
					WodelMetricClass item = (WodelMetricClass) element;
					if (item.ideletion == 0 && item.iddeletion == 0) {
						return GRAY;
					}
					else {
						return BLUE;
					}
				}
				if (element instanceof WodelMetricFeature) {
					WodelMetricFeature feature = (WodelMetricFeature) element;
					if (feature.getName().equals("Attributes")) {
						if (feature.getAttributesImplicitDeletion() == 0) {
							return GRAY;
						}
						else {
							return BLUE;
						}
					}
					if (feature.getName().equals("References")) {
						if (feature.getReferencesImplicitDeletion() == 0) {
							return GRAY;
						}
						else {
							return BLUE;
						}
					}
				}
				if (element instanceof WodelMetricAttribute) {
					WodelMetricAttribute attribute = (WodelMetricAttribute) element;
					if (attribute.ideletion == 0) {
						return GRAY;
					}
					else {
						return BLUE;
					}
				}
				if (element instanceof WodelMetricReference) {
					WodelMetricReference reference = (WodelMetricReference) element;
					if (reference.ideletion == 0) {
						return GRAY;
					}
					else {
						return BLUE;
					}
				}
			}
			return null;
		}

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			switch (columnIndex) {
			case 0:
				if (element instanceof WodelMetricCommand) {
					return ((WodelMetricCommand) element).getName();
				}
				if (element instanceof WodelMetricClass) {
					return ((WodelMetricClass) element).getName();
				}
				if (element instanceof WodelMetricFeature) {
					return ((WodelMetricFeature) element).getName();
				}
				if (element instanceof WodelMetricAttribute) {
					return ((WodelMetricAttribute) element).getName();
				}
				if (element instanceof WodelMetricReference) {
					return ((WodelMetricReference) element).getName();
				}
				break;
			case 1:
				if (element instanceof WodelMetricCommand) {
					int creation = ((WodelMetricCommand) element).creation;
					int ccreation = ((WodelMetricCommand) element).ccreation;
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
				if (element instanceof WodelMetricAttribute) {
					int creation = ((WodelMetricAttribute) element).creation;
					if (creation > 0) {
						return String.format("%1$d", creation);
					}
				}
				if (element instanceof WodelMetricReference) {
					int creation = ((WodelMetricReference) element).creation;
					if (creation > 0) {
						return String.format("%1$d", creation);
					}
				}
				break;
			case 2:
				if (element instanceof WodelMetricCommand) {
					int modification = ((WodelMetricCommand) element).modification;
					int mmodification = ((WodelMetricCommand) element).mmodification;
					if (modification > 0 || mmodification > 0) {
						return String.format("%1$d", mmodification) + "c " + String.format("%1$d", modification) + "f";
					}
				}
				if (element instanceof WodelMetricClass) {
					int modification = ((WodelMetricClass) element).modification;
					int mmodification = ((WodelMetricClass) element).mmodification;
					if (modification > 0 || mmodification > 0) {
						return String.format("%1$d", mmodification) + "c " + String.format("%1$d", modification) + "f";
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
				if (element instanceof WodelMetricAttribute) {
					int modification = ((WodelMetricAttribute) element).modification;
					if (modification > 0) {
						return String.format("%1$d", modification);
					}
				}
				if (element instanceof WodelMetricReference) {
					int modification = ((WodelMetricReference) element).modification;
					if (modification > 0) {
						return String.format("%1$d", modification);
					}
				}
				break;
			case 3:
				if (element instanceof WodelMetricCommand) {
					int deletion = ((WodelMetricCommand) element).deletion;
					int ddeletion = ((WodelMetricCommand) element).ddeletion;
					if (deletion > 0 || ddeletion > 0) {
						return String.format("%1$d", ddeletion) + "c " + String.format("%1$d", deletion) + "f";
					}
				}
				if (element instanceof WodelMetricClass) {
					int deletion = ((WodelMetricClass) element).deletion;
					int ddeletion = ((WodelMetricClass) element).ddeletion;
					if (deletion > 0 || ddeletion > 0) {
						return String.format("%1$d", ddeletion) + "c " + String.format("%1$d", deletion) + "f";
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
				if (element instanceof WodelMetricAttribute) {
					int deletion = ((WodelMetricAttribute) element).deletion;
					if (deletion > 0) {
						return String.format("%1$d", deletion);
					}
				}
				if (element instanceof WodelMetricReference) {
					int deletion = ((WodelMetricReference) element).deletion;
					if (deletion > 0) {
						return String.format("%1$d", deletion);
					}
				}
				break;
			case 4:
				if (element instanceof WodelMetricCommand) {
					int icreation = ((WodelMetricCommand) element).icreation;
					int iccreation = ((WodelMetricCommand) element).iccreation;
					if (icreation > 0 || iccreation > 0) {
						return String.format("%1$d", iccreation) + "c " + String.format("%1$d", icreation) + "f";
					}
				}
				if (element instanceof WodelMetricClass) {
					int icreation = ((WodelMetricClass) element).icreation;
					int iccreation = ((WodelMetricClass) element).iccreation;
					if (icreation > 0 || iccreation > 0) {
						return String.format("%1$d", iccreation) + "c " + String.format("%1$d", icreation) + "f";
					}
				}
				if (element instanceof WodelMetricFeature) {
					WodelMetricFeature feature = (WodelMetricFeature) element;
					if (feature.getName().equals("Attributes")) {
						int icreation = feature.getAttributesImplicitCreation();
						if (icreation > 0) {
							return String.format("%1$d", icreation);
						}
					}
					if (feature.getName().equals("References")) {
						int icreation = feature.getReferencesImplicitCreation();
						if (icreation > 0) {
							return String.format("%1$d", icreation);
						}
					}
				}
				if (element instanceof WodelMetricAttribute) {
					int icreation = ((WodelMetricAttribute) element).icreation;
					if (icreation > 0) {
						return String.format("%1$d", icreation);
					}
				}
				if (element instanceof WodelMetricReference) {
					int icreation = ((WodelMetricReference) element).icreation;
					if (icreation > 0) {
						return String.format("%1$d", icreation);
					}
				}
				break;
			case 5:
				if (element instanceof WodelMetricCommand) {
					int imodification = ((WodelMetricCommand) element).imodification;
					int immodification = ((WodelMetricCommand) element).immodification;
					if (imodification > 0 || immodification > 0) {
						return String.format("%1$d", immodification) + "c " + String.format("%1$d", imodification) + "f";
					}
				}
				if (element instanceof WodelMetricClass) {
					int imodification = ((WodelMetricClass) element).imodification;
					int immodification = ((WodelMetricClass) element).immodification;
					if (imodification > 0 || immodification > 0) {
						return String.format("%1$d", immodification) + "c " + String.format("%1$d", imodification) + "f";
					}
				}
				if (element instanceof WodelMetricFeature) {
					WodelMetricFeature feature = (WodelMetricFeature) element;
					if (feature.getName().equals("Attributes")) {
						int imodification = feature.getAttributesImplicitModification();
						if (imodification > 0) {
							return String.format("%1$d", imodification);
						}
					}
					if (feature.getName().equals("References")) {
						int imodification = feature.getReferencesImplicitModification();
						if (imodification > 0) {
							return String.format("%1$d", imodification);
						}
					}
				}
				if (element instanceof WodelMetricAttribute) {
					int imodification = ((WodelMetricAttribute) element).imodification;
					if (imodification > 0) {
						return String.format("%1$d", imodification);
					}
				}
				if (element instanceof WodelMetricReference) {
					int imodification = ((WodelMetricReference) element).imodification;
					if (imodification > 0) {
						return String.format("%1$d", imodification);
					}
				}
				break;
			case 6:
				if (element instanceof WodelMetricCommand) {
					int ideletion = ((WodelMetricCommand) element).ideletion;
					int iddeletion = ((WodelMetricCommand) element).iddeletion;
					if (ideletion > 0 || iddeletion > 0) {
						return String.format("%1$d", iddeletion) + "c " + String.format("%1$d", ideletion) + "f";
					}
				}
				if (element instanceof WodelMetricClass) {
					int ideletion = ((WodelMetricClass) element).ideletion;
					int iddeletion = ((WodelMetricClass) element).iddeletion;
					if (ideletion > 0 || iddeletion > 0) {
						return String.format("%1$d", iddeletion) + "c " + String.format("%1$d", ideletion) + "f";
					}
				}
				if (element instanceof WodelMetricFeature) {
					WodelMetricFeature feature = (WodelMetricFeature) element;
					if (feature.getName().equals("Attributes")) {
						int ideletion = feature.getAttributesImplicitDeletion();
						if (ideletion > 0) {
							return String.format("%1$d", ideletion);
						}
					}
					if (feature.getName().equals("References")) {
						int ideletion = feature.getReferencesImplicitDeletion();
						if (ideletion > 0) {
							return String.format("%1$d", ideletion);
						}
					}
				}
				if (element instanceof WodelMetricAttribute) {
					int ideletion = ((WodelMetricAttribute) element).ideletion;
					if (ideletion > 0) {
						return String.format("%1$d", ideletion);
					}
				}
				if (element instanceof WodelMetricReference) {
					int ideletion = ((WodelMetricReference) element).ideletion;
					if (ideletion > 0) {
						return String.format("%1$d", ideletion);
					}
				}
			}
			return null;
		}
		
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void run(IAction action) {
		try { 
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(WodelMetricsCommandView.ID);
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


}