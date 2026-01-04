package wodel.metrics.command.views;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import wodel.metrics.command.CommandMutatorMetrics;
import wodel.utils.manager.StaticMutatorMetrics.WodelMetric;
import wodel.utils.manager.StaticMutatorMetrics.WodelMetricAttribute;
import wodel.utils.manager.StaticMutatorMetrics.WodelMetricClass;
import wodel.utils.manager.StaticMutatorMetrics.WodelMetricFeature;
import wodel.utils.manager.StaticMutatorMetrics.WodelMetricReference;
import wodel.metrics.command.CommandMutatorMetrics.WodelMetricCommand;
import wodel.utils.manager.ModelManager;
import wodel.utils.manager.ProjectUtils;

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
 * @author Pablo Gomez-Abajo - Wodel operator static footprints view
 * 
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
		if (ProjectUtils.getProject() == null) {
			return;
		}
		String metamodel = ModelManager.getMetaModel();
		String project = ProjectUtils.getProject().getName();
		List<WodelMetricCommand> metrics = new ArrayList<WodelMetricCommand>();
		metrics.addAll(Arrays.asList(CommandMutatorMetrics.createWodelCommandMetrics(project, metamodel)));

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
		
		private Color getColumnBackground(Object element, int cmd) {
			if (element instanceof WodelMetricCommand ||
					element instanceof WodelMetricClass ||
					element instanceof WodelMetricAttribute ||
					element instanceof WodelMetricReference) {
				WodelMetric item = (WodelMetric) element;
				if (cmd == 0) {
					if (item.creation == 0 && item.ccreation == 0) {
						return GRAY;
					}
					else {
						return GREEN;
					}
				}
				if (cmd == 1) {
					if (item.modification == 0 && item.mmodification == 0) {
						return GRAY;
					}
					else {
						return AMBAR;
					}
				}
				if (cmd == 2) {
					if (item.deletion == 0 && item.ddeletion == 0) {
						return GRAY;
					}
					else {
						return RED;
					}
				}
				if (cmd == 3) {
					if (item.icreation == 0 && item.iccreation == 0) {
						return GRAY;
					}
					else {
						return PURPLE;
					}
				}
				if (cmd == 4) {
					if (item.imodification == 0 && item.immodification == 0) {
						return GRAY;
					}
					else {
						return BROWN;
					}
				}
				if (cmd == 5) {
					if (item.ideletion == 0 && item.iddeletion == 0) {
						return GRAY;
					}
					else {
						return BLUE;
					}
				}
			}
			if (element instanceof WodelMetricFeature) {
				WodelMetricFeature feature = (WodelMetricFeature) element;
				if (feature.getName().equals("Attributes")) {
					if (cmd == 0) {
						if (feature.getAttributesCreation() == 0) {
							return GRAY;
						}
						else {
							return GREEN;
						}
					}
					if (cmd == 1) {
						if (feature.getAttributesModification() == 0) {
							return GRAY;
						}
						else {
							return AMBAR;
						}
					}
					if (cmd == 2) {
						if (feature.getAttributesDeletion() == 0) {
							return GRAY;
						}
						else {
							return RED;
						}
					}
					if (cmd == 3) {
						if (feature.getAttributesImplicitCreation() == 0) {
							return GRAY;
						}
						else {
							return PURPLE;
						}
					}
					if (cmd == 4) {
						if (feature.getAttributesImplicitModification() == 0) {
							return GRAY;
						}
						else {
							return BROWN;
						}
					}
					if (cmd == 5) {
						if (feature.getAttributesImplicitDeletion() == 0) {
							return GRAY;
						}
						else {
							return BLUE;
						}
					}
				}
				if (feature.getName().equals("References")) {
					if (cmd == 0) {
						if (feature.getReferencesCreation() == 0) {
							return GRAY;
						}
						else {
							return GREEN;
						}
					}
					if (cmd == 1) {
						if (feature.getReferencesModification() == 0) {
							return GRAY;
						}
						else {
							return AMBAR;
						}
					}
					if (cmd == 2) {
						if (feature.getReferencesDeletion() == 0) {
							return GRAY;
						}
						else {
							return RED;
						}
					}
					if (cmd == 3) {
						if (feature.getReferencesImplicitCreation() == 0) {
							return GRAY;
						}
						else {
							return PURPLE;
						}
					}
					if (cmd == 4) {
						if (feature.getReferencesImplicitModification() == 0) {
							return GRAY;
						}
						else {
							return BROWN;
						}
					}
					if (cmd == 5) {
						if (feature.getReferencesImplicitDeletion() == 0) {
							return GRAY;
						}
						else {
							return BLUE;
						}
					}
				}
			}
			return null;
		}
		
		@Override
		public Color getBackground(Object element, int columnIndex) {
			switch (columnIndex) {
			case 0:
				break;
			default:
				return getColumnBackground(element, columnIndex - 1);
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
				if (element instanceof WodelMetric) {
					return ((WodelMetric) element).getName();
				}
				if (element instanceof WodelMetricFeature) {
					return ((WodelMetricFeature) element).getName();
				}
				break;
			case 1:
				if (element instanceof WodelMetricCommand || element instanceof WodelMetricClass) {
					int creation = ((WodelMetric) element).creation;
					int ccreation = ((WodelMetric) element).ccreation;
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
				if (element instanceof WodelMetricCommand || element instanceof WodelMetricClass) {
					int modification = ((WodelMetric) element).modification;
					int mmodification = ((WodelMetric) element).mmodification;
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
				if (element instanceof WodelMetricAttribute || element instanceof WodelMetricReference) {
					int modification = ((WodelMetric) element).modification;
					if (modification > 0) {
						return String.format("%1$d", modification);
					}
				}
				break;
			case 3:
				if (element instanceof WodelMetricCommand || element instanceof WodelMetricClass) {
					int deletion = ((WodelMetric) element).deletion;
					int ddeletion = ((WodelMetric) element).ddeletion;
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
				if (element instanceof WodelMetricAttribute || element instanceof WodelMetricReference) {
					int deletion = ((WodelMetric) element).deletion;
					if (deletion > 0) {
						return String.format("%1$d", deletion);
					}
				}
				break;
			case 4:
				if (element instanceof WodelMetricCommand || element instanceof WodelMetricClass) {
					int icreation = ((WodelMetric) element).icreation;
					int iccreation = ((WodelMetric) element).iccreation;
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
				if (element instanceof WodelMetricAttribute || element instanceof WodelMetricReference) {
					int icreation = ((WodelMetric) element).icreation;
					if (icreation > 0) {
						return String.format("%1$d", icreation);
					}
				}
				break;
			case 5:
				if (element instanceof WodelMetricCommand || element instanceof WodelMetricClass) {
					int imodification = ((WodelMetric) element).imodification;
					int immodification = ((WodelMetric) element).immodification;
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
				if (element instanceof WodelMetricAttribute || element instanceof WodelMetricReference) {
					int imodification = ((WodelMetric) element).imodification;
					if (imodification > 0) {
						return String.format("%1$d", imodification);
					}
				}
				break;
			case 6:
				if (element instanceof WodelMetricCommand || element instanceof WodelMetricClass) {
					int ideletion = ((WodelMetric) element).ideletion;
					int iddeletion = ((WodelMetric) element).iddeletion;
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
				if (element instanceof WodelMetricAttribute || element instanceof WodelMetricReference) {
					int ideletion = ((WodelMetric) element).ideletion;
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
		if (m_treeViewer.getControl() != null) {
			m_treeViewer.getControl().setFocus();
		}
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