package wodel.metrics.fixed.views;


import java.io.File;
import java.io.IOException;
//import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import manager.ModelManager;
import wodel.metrics.fixed.MetaModelMutatorMetrics;
import manager.WodelContext;
import manager.StaticMutatorMetrics.WodelMetric;
import manager.StaticMutatorMetrics.WodelMetricAttribute;
import manager.StaticMutatorMetrics.WodelMetricClass;
import manager.StaticMutatorMetrics.WodelMetricFeature;
import manager.StaticMutatorMetrics.WodelMetricReference;

import org.eclipse.sirius.business.api.dialect.DialectManager;
import org.eclipse.sirius.business.api.dialect.command.CreateRepresentationCommand;
import org.eclipse.sirius.business.api.dialect.command.RefreshRepresentationsCommand;
import org.eclipse.sirius.business.api.helper.SiriusResourceHelper;
import org.eclipse.sirius.business.api.session.DefaultLocalSessionCreationOperation;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionCreationOperation;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.diagram.ArrangeConstraint;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.DEdge;
import org.eclipse.sirius.diagram.DNodeList;
import org.eclipse.sirius.diagram.DNodeListElement;
import org.eclipse.sirius.diagram.DragAndDropTarget;
import org.eclipse.sirius.diagram.EdgeStyle;
import org.eclipse.sirius.diagram.business.internal.metamodel.spec.DSemanticDiagramSpec;
import org.eclipse.sirius.diagram.description.AbstractNodeMapping;
import org.eclipse.sirius.diagram.description.ContainerMapping;
import org.eclipse.sirius.diagram.description.DiagramDescription;
import org.eclipse.sirius.diagram.tools.api.command.view.CreateDDiagramElementCommand;
import org.eclipse.sirius.tools.api.command.semantic.AddSemanticResourceCommand;
import org.eclipse.sirius.ui.business.api.dialect.DialectUIManager;
import org.eclipse.sirius.ui.business.api.viewpoint.ViewpointSelection;
import org.eclipse.sirius.ui.business.api.viewpoint.ViewpointSelectionCallbackWithConfimation;
import org.eclipse.sirius.ui.business.internal.commands.ChangeViewpointSelectionCommand;
import org.eclipse.sirius.viewpoint.DAnalysis;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.DRepresentationDescriptor;
import org.eclipse.sirius.viewpoint.DView;
import org.eclipse.sirius.viewpoint.RGBValues;
import org.eclipse.sirius.viewpoint.description.RepresentationDescription;
import org.eclipse.sirius.viewpoint.description.Viewpoint;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.part.*;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.diagram.ui.requests.ArrangeRequest;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.LayoutConstraint;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.*;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.jface.action.*;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.*;
import org.eclipse.swt.SWT;
import org.osgi.framework.Bundle;

import wodel.metrics.fixed.wizards.WodelMetricsFixedWizardAttribute;
import wodel.metrics.fixed.wizards.WodelMetricsFixedWizardClass;
import wodel.metrics.fixed.wizards.WodelMetricsFixedWizardCreationClass;
import wodel.metrics.fixed.wizards.WodelMetricsFixedWizardDeletionClass;
import wodel.metrics.fixed.wizards.WodelMetricsFixedWizardModificationAttribute;
import wodel.metrics.fixed.wizards.WodelMetricsFixedWizardModificationClass;
import wodel.metrics.fixed.wizards.WodelMetricsFixedWizardModificationReference;
import wodel.metrics.fixed.wizards.WodelMetricsFixedWizardReference;
import exceptions.MetaModelNotFoundException;


/**
 * @author Pablo Gomez-Abajo - Wodel meta-model static footprints view
 * 
 */

public class WodelMetricsFixedView extends ViewPart implements ISelectionChangedListener, IEditorActionDelegate {

	public static final String ID = "wodel.metrics.fixed.views.WodelMetricsFixedView";
	
	private TreeViewer m_treeViewer;

	private Action showFixedVisualMetrics;
	
	private static final String aird = "aird";

	private static final Color RED = new Color(Display.getCurrent(), 178, 34, 34);
	
	private static final Color AMBAR = new Color(Display.getCurrent(), 207, 179, 55);
	
	private static final Color GREEN = new Color(Display.getCurrent(), 0, 128, 0);
	
	private static final Color GRAY = new Color(Display.getCurrent(), 225, 225, 225);
	
	private static final Color PURPLE = new Color(Display.getCurrent(), 224, 96, 224);
	
	private static final Color BROWN = new Color(Display.getCurrent(), 171, 101, 53);
	
	private static final Color BLUE = new Color(Display.getCurrent(), 66, 134, 244);
	
	private static List<WodelMetricClass> metrics = null;
	
	//private static PrintWriter writer = null;
	
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
		WodelContext.setProject(null);
		String output = ModelManager.getOutputPath();
		String metamodel = ModelManager.getMetaModel();
		String fileName = manager.WodelContext.getFileName();
		if (fileName.endsWith(".mutator") == false) {
			//MessageBox msgbox = new MessageBox(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());
			//msgbox.setMessage("To show this view you have to right-click on the file .mutator opened in the editor");
			//msgbox.open();
			return;
		}
		String xmiFileName = "file:/" + output +  "/" + fileName.replace(".mutator", ".model");
		metrics = new ArrayList<WodelMetricClass>();
		metrics.addAll(Arrays.asList(MetaModelMutatorMetrics.createWodelStaticMetrics(xmiFileName, metamodel)));

		Tree addressTree = new Tree(parent, SWT.BORDER | SWT.H_SCROLL
				| SWT.V_SCROLL | SWT.FULL_SELECTION);
		addressTree.setHeaderVisible(true);
		addressTree.setLinesVisible(true);
		addressTree.addListener(SWT.MouseDoubleClick, new Listener() {
			@Override
			public void handleEvent(Event event) {
				Point point = new Point(event.x, event.y);
				TreeItem item = addressTree.getItem(point);
		        if (item != null) {
		        	for (int col = 0; col < addressTree.getColumnCount(); col++) {
	                    Rectangle rect = item.getBounds(col);
	                    if (rect.contains(point)) {
	                    	// class wizard
	                    	if (item.getParentItem() == null) {
                    			String className = item.getText();
	                    		// first column / main wizard
	                    		if (col == 0) {
	                    			WodelMetricsFixedWizardClass wizard = new WodelMetricsFixedWizardClass(className);
	                    			// init wizard
	                    			wizard.init(PlatformUI.getWorkbench(), new StructuredSelection());
                   					WizardDialog dialog = new WizardDialog(wizard.getShell(), wizard);
                   					dialog.open();
	                    		}
	                    		// second column / creation wizard
	                    		if (col == 1) {
	                    			WodelMetricsFixedWizardCreationClass wizard = new WodelMetricsFixedWizardCreationClass(className);
	                    			// init wizard
	                    			wizard.init(PlatformUI.getWorkbench(), new StructuredSelection());
                   					WizardDialog dialog = new WizardDialog(wizard.getShell(), wizard);
                   					dialog.open();
	                    		}
	                    		// third column / modification wizard
	                    		if (col == 2) {
	                    			WodelMetricsFixedWizardModificationClass wizard = new WodelMetricsFixedWizardModificationClass(className);
	                    			// init wizard
	                    			wizard.init(PlatformUI.getWorkbench(), new StructuredSelection());
	                    			WizardDialog dialog = new WizardDialog(wizard.getShell(), wizard);
	                    			dialog.open();
	                    		}
	                    		// fourth column / deletion wizard
	                    		if (col == 3) {
	                    			WodelMetricsFixedWizardDeletionClass wizard = new WodelMetricsFixedWizardDeletionClass(className);
	                    			// init wizard
	                    			wizard.init(PlatformUI.getWorkbench(), new StructuredSelection());
	                    			WizardDialog dialog = new WizardDialog(wizard.getShell(), wizard);
	                    			dialog.open();
	                    		}
	                    	}
	                    	if (item.getParentItem() != null) {
	                    		TreeItem parent = item.getParentItem();
	                    		if (parent.getParentItem() != null) {
                    				String className = parent.getParentItem().getText();
	                    			if (parent.getText().equals("Attributes")) {
	                    				String attributeName = item.getText();
	                    				// first column / main attribute wizard
	                    				if (col == 0) {
	                    					WodelMetricsFixedWizardAttribute wizard = new WodelMetricsFixedWizardAttribute(className, attributeName);
	                    					// init wizard
	                    					wizard.init(PlatformUI.getWorkbench(), new StructuredSelection());
	                    					WizardDialog dialog = new WizardDialog(wizard.getShell(), wizard);
	                    					dialog.open();
	                    				}
	                    				// second column / creation attribute wizard / shows message
	                    				if (col == 1) {
	                    					MessageDialog.openInformation(m_treeViewer.getControl().getShell(), "Wodel Static Metrics Creation Attribute Wizard", "Try to click on the modification field");
	                    				}
	                    				// third column / modification attribute wizard
	                    				if (col == 2) {
	                    					WodelMetricsFixedWizardModificationAttribute wizard = new WodelMetricsFixedWizardModificationAttribute(className, attributeName);
	                    					// init wizard
	                    					wizard.init(PlatformUI.getWorkbench(), new StructuredSelection());
	                    					WizardDialog dialog = new WizardDialog(wizard.getShell(), wizard);
	                    					dialog.open();
	                    				}
	                    				// fourth column / deletion attribute wizard / shows message
	                    				if (col == 3) {
	                    					MessageDialog.openInformation(m_treeViewer.getControl().getShell(), "Wodel Static Metrics Deletion Attribute Wizard", "Try to click on the modification field");
	                    				}
	                    			}
	                    			if (parent.getText().equals("References")) {
	                    				String referenceName = item.getText();
	                    				// first column / main reference wizard
	                    				if (col == 0) {
	                    					WodelMetricsFixedWizardReference wizard = new WodelMetricsFixedWizardReference(className, referenceName);
	                    					// init wizard
	                    					wizard.init(PlatformUI.getWorkbench(), new StructuredSelection());
	                    					WizardDialog dialog = new WizardDialog(wizard.getShell(), wizard);
	                    					dialog.open();
	                    				}
	                    				// second column / creation reference wizard / shows message
	                    				if (col == 1) {
	                    					MessageDialog.openInformation(m_treeViewer.getControl().getShell(), "Wodel Static Metrics Creation Reference Wizard", "Try to click on the modification field");
	                    				}
	                    				// third column / modification reference wizard
	                    				if (col == 2) {
	                    					WodelMetricsFixedWizardModificationReference wizard = new WodelMetricsFixedWizardModificationReference(className, referenceName);
	                    					// init wizard
	                    					wizard.init(PlatformUI.getWorkbench(), new StructuredSelection());
	                    					WizardDialog dialog = new WizardDialog(wizard.getShell(), wizard);
	                    					dialog.open();
	                    				}
	                    				// fourth column / deletion reference wizard / shows message
	                    				if (col == 3) {
	                    					MessageDialog.openInformation(m_treeViewer.getControl().getShell(), "Wodel Static Metrics Deletion Reference Wizard", "Try to click on the modification field");
	                    				}
	                    			}
	                    		}
	                    	}
	                    }
	                }
	            }
			}
		});
		m_treeViewer = new TreeViewer(addressTree);
		TreeColumn column1 = new TreeColumn(addressTree, SWT.LEFT);
		column1.setAlignment(SWT.LEFT);
		column1.setText("Class/Attributes/References");
		column1.setWidth(170);
		TreeColumn column2 = new TreeColumn(addressTree, SWT.RIGHT | SWT.FULL_SELECTION);
		column2.setAlignment(SWT.LEFT);
		int creation = 0;
		int modification = 0;
		int deletion = 0;
		int icreation = 0;
		int imodification = 0;
		int ideletion = 0;
		for (WodelMetricClass metric : metrics) {
			if (metric.ccreation > 0 || metric.creation > 0) {
				creation++;
			}
			if (metric.mmodification > 0) {
				modification++;
			}
			if (metric.ddeletion > 0) {
				deletion++;
			}
			if (metric.iccreation > 0) {
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
		createToolbar();
		//m_treeViewer.expandAll();
//		try {
//			writer = new PrintWriter( output +  "/" + manager.WodelContext.getProject() + "_metrics.txt");
//			writer.println("Class/Attributes/References;" + 
//					String.format("C.: %1$d%%", (creation*100/metrics.size())) + ";" +
//					String.format("M.: %1$d%%", (modification*100/metrics.size())) + ";" +
//					String.format("D.: %1$d%%", (deletion*100/metrics.size())) + ";" +
//					String.format("IC.: %1$d%%", (icreation*100/metrics.size())) + ";" +
//					String.format("IM.: %1$d%%", (imodification*100/metrics.size())) + ";" +
//					String.format("ID.: %1$d%%", (ideletion*100/metrics.size())) + ";");
//			for (TreeItem item : addressTree.getItems()) {
//				String text = item.getText(0);
//				for (int col = 1; col < addressTree.getColumnCount(); col++) {
//					text += ";" + item.getText(col);
//				}
//				writer.println(text);
//				if (item.getData() instanceof WodelMetricClass) {
//					WodelMetricClass metricClass = (WodelMetricClass) item.getData();
//					WodelMetricFeature[] metricFeatures = metricClass.getFeatures();
//					for (WodelMetricFeature metricFeature : metricFeatures) {
//						String subText = "";
//						if (metricFeature.getName().equals("Attributes")) {
//							if (metricFeature.getAttributes().length > 0) {
//								subText += "Attributes;";
//								if (metricFeature.getAttributesCreation() != 0) {
//									subText += metricFeature.getAttributesCreation();
//								}
//								subText += ";";
//								if (metricFeature.getAttributesModification() != 0) {
//									subText += metricFeature.getAttributesModification();
//								}
//								subText += ";";
//								if (metricFeature.getAttributesDeletion() != 0) {
//									subText += metricFeature.getAttributesDeletion();
//								}
//								subText += ";";
//								if (metricFeature.getAttributesImplicitCreation() != 0) {
//									subText += metricFeature.getAttributesImplicitCreation();
//								}
//								subText += ";";
//								if (metricFeature.getAttributesImplicitModification() != 0) {
//									subText += metricFeature.getAttributesImplicitModification();
//								}
//								subText += ";";
//								if (metricFeature.getAttributesImplicitDeletion() != 0) {
//									subText += metricFeature.getAttributesImplicitDeletion();
//								}
//								writer.println(subText);
//								for (WodelMetricAttribute metricAttribute : metricFeature.getAttributes()) {
//									String attText = metricAttribute.getName() + ";";
//									if (metricAttribute.creation != 0) {
//										attText += metricAttribute.creation;
//									}
//									attText += ";";
//									if (metricAttribute.modification != 0) {
//										attText += metricAttribute.modification;
//									}
//									attText += ";";
//									if (metricAttribute.deletion != 0) {
//										attText += metricAttribute.deletion;
//									}
//									attText += ";";
//									if (metricAttribute.icreation != 0) {
//										attText += metricAttribute.icreation;
//									}
//									attText += ";";
//									if (metricAttribute.imodification != 0) {
//										attText += metricAttribute.imodification;
//									}
//									attText += ";";
//									if (metricAttribute.ideletion != 0) {
//										attText += metricAttribute.ideletion;
//									}
//									writer.println(attText);
//								}
//							}
//						}
//						subText = "";
//						if (metricFeature.getName().equals("References")) {
//							if (metricFeature.getReferences().length > 0) {
//								subText += "References;";
//								if (metricFeature.getReferencesCreation() != 0) {
//									subText += metricFeature.getReferencesCreation();
//								}
//								subText += ";";
//								if (metricFeature.getReferencesModification() != 0) {
//									subText += metricFeature.getReferencesModification();
//								}
//								subText += ";";
//								if (metricFeature.getReferencesDeletion() != 0) {
//									subText += metricFeature.getReferencesDeletion();
//								}
//								subText += ";";
//								if (metricFeature.getReferencesImplicitCreation() != 0) {
//									subText += metricFeature.getReferencesImplicitCreation();
//								}								
//								subText += ";";
//								if (metricFeature.getReferencesImplicitModification() != 0) {
//									subText += metricFeature.getReferencesImplicitModification();
//								}
//								subText += ";";
//								if (metricFeature.getReferencesImplicitDeletion() != 0) {
//									subText += metricFeature.getReferencesImplicitDeletion();
//								}
//								writer.println(subText);
//								for (WodelMetricReference metricReference : metricFeature.getReferences()) {
//									String refText = metricReference.getName() + ";";
//									if (metricReference.creation != 0) {
//										refText += metricReference.creation;
//									}
//									refText += ";";
//									if (metricReference.modification != 0) {
//										refText += metricReference.modification;
//									}
//									refText += ";";
//									if (metricReference.deletion != 0) {
//										refText += metricReference.deletion;
//									}
//									refText += ";";
//									if (metricReference.icreation != 0) {
//										refText += metricReference.icreation;
//									}
//									refText += ";";
//									if (metricReference.imodification != 0) {
//										refText += metricReference.imodification;
//									}
//									refText += ";";
//									if (metricReference.ideletion != 0) {
//										refText += metricReference.ideletion;
//									}
//									writer.println(refText);
//								}
//							}
//						}
//					}
//				}
//			}
//			writer.close();
//		}
//		catch (IOException e) {
//			
//		}
	}

	public void setFocus() {
		if (m_treeViewer.getControl() != null) {
			m_treeViewer.getControl().setFocus();
		}
	}
	
	/**
     * Returns the image descriptor with the given relative path.
     */
    private ImageDescriptor getImageDescriptor(String relativePath) {
    	String iconPath = "icons/";
        try {
        	@SuppressWarnings("restriction")
        	Bundle bundle = Platform.getBundle("wodel.metrics.fixed");
        	URL installURL = bundle.getEntry("/");
			URL url = new URL(installURL, iconPath + relativePath);
            return ImageDescriptor.createFromURL(url);
        }
        catch (MalformedURLException e) {
        	// should not happen
        	return ImageDescriptor.getMissingImageDescriptor();
        }
    }

	public void createActions(File file) {
		showFixedVisualMetrics = new Action("Show static visual metrics") {
        	public void run() { 
        		// TODO Auto-generated method stub
        		//Convert File URI to platform URI
        		URIConverter converter = new ExtensibleURIConverterImpl();
        		URI fileUri = URI.createFileURI(ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString() + File.separator);
        		URI platformURI = URI.createPlatformResourceURI("/", false);
        		converter.getURIMap().put(fileUri, platformURI);
        		URI anfileURI = converter.normalize(URI.createFileURI(file.getAbsolutePath()));
        		String metamodel = file.getPath();
        		ExecuteAndInitializeAfterCreateFile(anfileURI, metamodel);
        	}
        };
        showFixedVisualMetrics.setImageDescriptor(getImageDescriptor("wodel4.jpg"));
        
        // Add selection listener.
        m_treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
        	public void selectionChanged(SelectionChangedEvent event) {
        		//updateActionEnablement();
        	}
        });
	}
	
    /**
     * Create toolbar.
     */
	private void createToolbar() {
        IToolBarManager mgr = getViewSite().getActionBars().getToolBarManager();
    	mgr.add(showFixedVisualMetrics);
    }

	class WodelMetricsContentProvider implements ITreeContentProvider {
		public Object[] getChildren(Object parentElement) {
			if (parentElement instanceof List) {
				return ((List<?>) parentElement).toArray();
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

		public Object getParent(Object element) {
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
				if (element instanceof WodelMetric) {
					return ((WodelMetric) element).getName();
				}
				if (element instanceof WodelMetricFeature) {
					return ((WodelMetricFeature) element).getName();
				}
				break;
			case 1:
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
				if (element instanceof WodelMetricAttribute || element instanceof WodelMetricReference) {
					int modification = ((WodelMetric) element).modification;
					if (modification > 0) {
						return String.format("%1$d", modification);
					}
				}
				break;
			case 3:
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
				if (element instanceof WodelMetricAttribute || element instanceof WodelMetricReference) {
					int deletion = ((WodelMetric) element).deletion;
					if (deletion > 0) {
						return String.format("%1$d", deletion);
					}
				}
				break;
			case 4:
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
				if (element instanceof WodelMetricAttribute || element instanceof WodelMetricReference) {
					int icreation = ((WodelMetric) element).icreation;
					if (icreation > 0) {
						return String.format("%1$d", icreation);
					}
				}
				break;
			case 5:
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
				if (element instanceof WodelMetricAttribute || element instanceof WodelMetricReference) {
					int imodification = ((WodelMetric) element).imodification;
					if (imodification > 0) {
						return String.format("%1$d", imodification);
					}
				}
				break;
			case 6:
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
				if (element instanceof WodelMetricAttribute || element instanceof WodelMetricReference) {
					int ideletion = ((WodelMetric) element).ideletion;
					if (ideletion > 0) {
						return String.format("%1$d", ideletion);
					}
				}
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

		private Color getColumnBackground(Object element, int cmd) {
			if (element instanceof WodelMetricClass ||
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
	}

	@Override
	public void run(IAction action) {
		try { 
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(WodelMetricsFixedView.ID);
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
	
	private static void PinnedElement(DNodeList element) {
		// TODO Auto-generated method stub
		((DNodeList) element).getArrangeConstraints().add(ArrangeConstraint.KEEP_LOCATION);
		((DNodeList) element).getArrangeConstraints().add(ArrangeConstraint.KEEP_SIZE);
		((DNodeList) element).getArrangeConstraints().add(ArrangeConstraint.KEEP_RATIO);
	}
	
	private static void ExecuteAndInitializeAfterCreateFile(URI anfileURI, String metamodel) {
		// TODO Auto-generated method stub
		//Create *.aird if it doesn't exist
		IProgressMonitor monitor = new NullProgressMonitor();
		URI sessionResourceURI = URI.createURI(anfileURI.toString().substring(0,
										anfileURI.toString().length()-anfileURI.fileExtension().length()).concat(aird),true);
		try {
			Files.deleteIfExists(Paths.get(sessionResourceURI.path()));
		
		//Create Session Operation
			SessionCreationOperation oper = new DefaultLocalSessionCreationOperation(sessionResourceURI, monitor);
		//Create Session
			oper.execute();
			Session createdSession = oper.getCreatedSession();

		//Add Default Representation
			//Adding the resource also to Sirius session
			AddSemanticResourceCommand addCommandToSession = new AddSemanticResourceCommand(createdSession,anfileURI,monitor);
			createdSession.getTransactionalEditingDomain().getCommandStack().execute(addCommandToSession);
			createdSession.save(monitor); 	
			//END
			//Add View
			TransactionalEditingDomain domain = createdSession.getTransactionalEditingDomain();
			final Set<Viewpoint> newSelectedViewpoints = ViewpointSelection.getViewpoints(anfileURI.fileExtension());
			Set<Viewpoint> viewpoints = new HashSet<Viewpoint>();
			final ViewpointSelection.Callback callback = new ViewpointSelectionCallbackWithConfimation();
				
			String name = null;					
			for(Viewpoint p : newSelectedViewpoints){
				viewpoints.add(SiriusResourceHelper.getCorrespondingViewpoint(createdSession, p));
				name = p.getName();
			}
			@SuppressWarnings("restriction")
			Command command = new ChangeViewpointSelectionCommand(createdSession, 
					callback, viewpoints , new HashSet<Viewpoint>(), true,
					monitor);
			domain.getCommandStack().execute(command);
			createdSession.save(monitor); 
			//END		
				
		//Create Representation
			EObject rootObject = createdSession.getSemanticResources().iterator().next().getContents().get(0);
			Collection<RepresentationDescription> descriptions = DialectManager.INSTANCE.getAvailableRepresentationDescriptions(createdSession.getSelectedViewpoints(false),  rootObject );
			if(descriptions.isEmpty())
				throw new Exception("Could not found representation description for object: " + rootObject);
					
			RepresentationDescription description = descriptions.iterator().next();
			
			//DialectManager viewpointDialectManager = DialectManager.INSTANCE;
			Command createViewCommand = new CreateRepresentationCommand(createdSession,
					  description, rootObject, "Default "+ name + " Diagram", monitor);
			createdSession.getTransactionalEditingDomain().getCommandStack().execute(createViewCommand);
			
		//Initialize Representation
			//Get the DRepresentation
			DAnalysis root = (DAnalysis) createdSession.getSessionResource().getContents().get(0);
			List<DView> dViews = root.getOwnedViews();
			DView dView = null;
			for (DView dv : dViews) {
				if(dv.getViewpoint().getName().equals("Design") == true) {
					dView = dv;
					break;
				}
			}
			if (dView == null) {
				return;
			}
			//DRepresentation dRepresentation = dView.getOwnedRepresentationDescriptors().get(0); <-- Works on Sirius 3.1.7
			DRepresentationDescriptor dRepresentationDescriptor = dView.getOwnedRepresentationDescriptors().get(0);
			DRepresentation dRepresentation = dRepresentationDescriptor.getRepresentation();
			
			IEditorPart editorPart = DialectUIManager.INSTANCE.openEditor(createdSession, dRepresentation, monitor);
				
			List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
			ArrayList<EClass> listEClasses = ModelManager.getEClasses(packages);
			DSemanticDiagramSpec semanticDiagram = (DSemanticDiagramSpec) dRepresentation;
			Iterator<EClass> itEClass = listEClasses.iterator();
				
			DiagramDescription diagramDescription = getDiagramDescription(dView);
				
			AbstractNodeMapping nodeMapping = getNodeMapping(diagramDescription);

			DragAndDropTarget dragAndDropTarget = null;
			if(semanticDiagram.getOwnedDiagramElements().get(0) instanceof DDiagramElement)
				dragAndDropTarget = ((DDiagramElement)semanticDiagram.getOwnedDiagramElements().get(0)).getParentDiagram();
			
			HashMap<EClass, DNodeList> eClassNodes = new HashMap<EClass, DNodeList>();
			while (itEClass.hasNext()){
				EClass eClass = itEClass.next();
				
				CreateDDiagramElementCommand createNode = new CreateDDiagramElementCommand(domain, eClass, nodeMapping, dragAndDropTarget);
				domain.getCommandStack().execute(createNode);
				DNodeList nodeList = (DNodeList) semanticDiagram.getOwnedDiagramElements().get(semanticDiagram.getOwnedDiagramElements().size() - 1);
				eClassNodes.put(eClass, nodeList);
			}
			

			List<DRepresentation> dRepresentationList = new ArrayList<DRepresentation>();
			dRepresentationList.add(dRepresentation);
			
			RefreshRepresentationsCommand refreshCommand = new RefreshRepresentationsCommand(domain, true, monitor, dRepresentationList);
			domain.getCommandStack().execute(refreshCommand);
			
			List<DEdge> edgeList = new ArrayList<DEdge>();
			for (DDiagramElement dDiagramElement : semanticDiagram.getOwnedDiagramElements()) {
				if (dDiagramElement instanceof DEdge) {
					edgeList.add((DEdge) dDiagramElement);
				}
			}
			
			// trigger 'Arrange All' on the whole diagram
			DiagramEditPart diagramEditPart = null;
			IEditorPart editor = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage()
				.getActiveEditor();

			if (editor instanceof DiagramEditor) {
				DiagramEditor diagramEditor = (DiagramEditor) editor;
				diagramEditPart = diagramEditor.getDiagramEditPart();
			}
			
			ArrangeRequest arrangeRequest = new ArrangeRequest(ActionIds.ACTION_ARRANGE_ALL);
			List<Object> partsToArrange = new ArrayList<Object>(1);
			partsToArrange.add(diagramEditPart);
			arrangeRequest.setPartsToArrange(partsToArrange);
			diagramEditPart.performRequest(arrangeRequest);

			RecordingCommand updatePosition = new RecordingCommand(domain) {
				@Override
				protected void doExecute() {
					@SuppressWarnings("unchecked")
					DiagramEditor diagramEditor = (DiagramEditor) PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getActivePage()
						.getActiveEditor();
					DiagramEditPart graphicalPart = diagramEditor.getDiagramEditPart();
					Iterator<EditPart> children = graphicalPart.getChildren().iterator();
					while (children.hasNext()) {
						EditPart editPart = (EditPart) children.next();
						//org.eclipse.gmf.runtime.notation.impl.NodeImpl
						Object editModel = editPart.getModel();
						if(editModel instanceof org.eclipse.gmf.runtime.notation.impl.NodeImpl)
						{
							org.eclipse.gmf.runtime.notation.impl.NodeImpl node = ((org.eclipse.gmf.runtime.notation.impl.NodeImpl) editModel);
							final LayoutConstraint layoutConstraint = node.getLayoutConstraint();
							EObject element = node.getElement();
							if (layoutConstraint instanceof Bounds) {
								final Bounds bounds = (Bounds) layoutConstraint;
								if(element instanceof DNodeList)
								{
									PinnedElement((DNodeList) element);
								}
							}
						}
						graphicalPart.refresh();
					}
				}
			};
			createdSession.getTransactionalEditingDomain().getCommandStack().execute(updatePosition);

		//Save session and Refresh workspace		
			//Includes the mutation metrics
			//Generate metrics model
			final String base = "/wodel.project/icons/metrics";
		   	final String creationIconPath = base + "/creation.jpg";
		   	final String modificationIconPath = base + "/modification.jpg";
		   	final String deletionIconPath = base + "/deletion.jpg";
		   	final String creationModificationIconPath = base + "/creation_modification.jpg";
		   	final String creationDeletionIconPath = base + "/creation_deletion.jpg";
		   	final String creationModificationDeletionIconPath = base + "/creation_modification_deletion.jpg";
		   	final String attCreationIconPath = base + "/attcreation.jpg";
		   	final String attModificationIconPath = base + "/attmodification.jpg";
		   	final String attDeletionIconPath = base + "/attdeletion.jpg";
		   	final String attCreationModificationIconPath = base + "/attcreation_modification.jpg";
		   	final String attCreationDeletionIconPath = base + "/attcreation_deletion.jpg";
		   	final String attCreationModificationDeletionIconPath = base + "/attcreation_modification_deletion.jpg";

			RecordingCommand includeMetricsCommand = new RecordingCommand(domain) {
				@Override
				protected void doExecute() {
					for (EClass eClass : eClassNodes.keySet()) {
						for (WodelMetricClass metricClass : metrics) {
							if (metricClass.getEClass().getName().equals(eClass.getName())) {
								DNodeList nodeList = eClassNodes.get(eClass);
								if (metricClass.ccreation > 0 && metricClass.mmodification == 0 && metricClass.ddeletion == 0) {
									nodeList.getOwnedStyle().setIconPath(creationIconPath);
								}
								if (metricClass.ccreation == 0 && metricClass.mmodification > 0 && metricClass.ddeletion == 0) {
									nodeList.getOwnedStyle().setIconPath(modificationIconPath);
								}
								if (metricClass.ccreation == 0 && metricClass.mmodification == 0 && metricClass.ddeletion > 0) {
									nodeList.getOwnedStyle().setIconPath(deletionIconPath);
								}
								if (metricClass.ccreation > 0 && metricClass.mmodification > 0 && metricClass.ddeletion == 0) {
									nodeList.getOwnedStyle().setIconPath(creationModificationIconPath);
								}
								if (metricClass.ccreation > 0 && metricClass.mmodification == 0 && metricClass.ddeletion > 0) {
									nodeList.getOwnedStyle().setIconPath(creationDeletionIconPath);
								}
								if (metricClass.ccreation > 0 && metricClass.mmodification > 0 && metricClass.ddeletion > 0) {
									nodeList.getOwnedStyle().setIconPath(creationModificationDeletionIconPath);
								}
								List<DNodeListElement> nodeListElements = nodeList.getOwnedElements();
								for (DNodeListElement nodeListElement : nodeListElements) {
									EObject target = nodeListElement.getTarget();
									if (target instanceof EAttribute) {
										EAttribute targetAttribute = (EAttribute) target;
										for (WodelMetricAttribute metricAttribute : metricClass.getAttributes()) {
											if (targetAttribute.getName().equals(metricAttribute.getName())) {
												if (metricAttribute.creation > 0 && metricAttribute.modification == 0 && metricAttribute.deletion == 0) {
													nodeListElement.getOwnedStyle().setIconPath(attCreationIconPath);
												}
												if (metricAttribute.creation == 0 && metricAttribute.modification > 0 && metricAttribute.deletion == 0) {
													nodeListElement.getOwnedStyle().setIconPath(attModificationIconPath);
												}
												if (metricAttribute.creation == 0 && metricAttribute.modification == 0 && metricAttribute.deletion > 0) {
													nodeListElement.getOwnedStyle().setIconPath(attDeletionIconPath);
												}
												if (metricAttribute.creation > 0 && metricAttribute.modification > 0 && metricAttribute.deletion == 0) {
													nodeListElement.getOwnedStyle().setIconPath(attCreationModificationIconPath);
												}
												if (metricAttribute.creation > 0 && metricAttribute.modification == 0 && metricAttribute.deletion > 0) {
													nodeListElement.getOwnedStyle().setIconPath(attCreationDeletionIconPath);
												}
												if (metricAttribute.creation > 0 && metricAttribute.modification > 0 && metricAttribute.deletion > 0) {
													nodeListElement.getOwnedStyle().setIconPath(attCreationModificationDeletionIconPath);
												}
												break;
											}
										}
									}
								}
								for (DEdge dEdge : edgeList) {
									DNodeList edgeTarget = (DNodeList) dEdge.getSourceNode();
									if (edgeTarget.getName().equals(eClass.getName())) {
										for (WodelMetricReference metricReference : metricClass.getReferences()) {
											if (dEdge.getName().endsWith(metricReference.getName())) {
												EdgeStyle edgeStyle = dEdge.getOwnedStyle();
												if (metricReference.creation > 0 && metricReference.modification == 0 && metricReference.deletion == 0) {
													edgeStyle.setStrokeColor(RGBValues.create(0, 128, 0));
												}
												if (metricReference.creation == 0 && metricReference.modification > 0 && metricReference.deletion == 0) {
													edgeStyle.setStrokeColor(RGBValues.create(207, 179, 55));
												}
												if (metricReference.creation == 0 && metricReference.modification == 0 && metricReference.deletion > 0) {
													edgeStyle.setStrokeColor(RGBValues.create(178, 34, 34));
												}
												if (metricReference.creation > 0 && metricReference.modification > 0 && metricReference.deletion == 0) {
													edgeStyle.setStrokeColor(RGBValues.create(255, 69, 0));
												}
												if (metricReference.creation > 0 && metricReference.modification == 0 && metricReference.deletion > 0) {
													edgeStyle.setStrokeColor(RGBValues.create(255, 69, 0));
												}
												if (metricReference.creation > 0 && metricReference.modification > 0 && metricReference.deletion > 0) {
													edgeStyle.setStrokeColor(RGBValues.create(255, 69, 0));
												}
												//if (metricReference.icreation > 0 || metricReference.imodification > 0 || metricReference.ideletion > 0) {
												//	edgeStyle.setStrokeColor(RGBValues.create(255, 69, 0));
												//}
												dEdge.setOwnedStyle(edgeStyle);
												break;
											}
										}
									}
								}
							}
						}
					}
				}
			};
			domain.getCommandStack().execute(includeMetricsCommand);

			SessionManager.INSTANCE.notifyRepresentationCreated(createdSession);
			createdSession.save(monitor);
			
		} catch (MetaModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	}
	
	private static DiagramDescription getDiagramDescription(DView dView) {

		Iterator<RepresentationDescription> itRepresentations = dView.getViewpoint().getOwnedRepresentations().iterator();
		while (itRepresentations.hasNext()) {
			RepresentationDescription representationDescription = (RepresentationDescription) itRepresentations
					.next();
			if(representationDescription instanceof DiagramDescription)
				return (DiagramDescription) representationDescription;
			
		}		
		return null;
	}
	
	private static AbstractNodeMapping getNodeMapping(DiagramDescription diagramDescription) {
		
		Iterator<ContainerMapping> itContainers = diagramDescription.getDefaultLayer().getContainerMappings().iterator();
		while (itContainers.hasNext()) {
			ContainerMapping containerMapping = (ContainerMapping) itContainers
					.next();
			if(containerMapping.getName().equals("EC EClass"))
				return containerMapping;
		}
		
		return null;
	}
}