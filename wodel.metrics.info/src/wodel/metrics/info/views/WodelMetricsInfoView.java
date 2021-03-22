package wodel.metrics.info.views;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import manager.ModelManager;
import manager.MutatorUtils;
import manager.WodelContext;
import mutatorenvironment.MutatorEnvironment;
import wodel.metrics.info.MutatorInfo;
import wodel.metrics.info.MutatorInfo.MutatorInfoClass;
import wodel.metrics.info.MutatorInfo.MutatorInfoFeature;
import wodel.metrics.info.MutatorInfo.MutatorInfoMutant;
import wodel.metrics.info.MutatorInfo.MutatorInfoSeed;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.part.*;
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

import exceptions.MetaModelNotFoundException;
import exceptions.ModelNotFoundException;

/**
 * @author Pablo Gomez-Abajo - Wodel applied mutations information view
 * 
 */

public class WodelMetricsInfoView extends ViewPart implements ISelectionChangedListener, IEditorActionDelegate {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "wodel.metrics.info.views.WodelMetricsInfoView";

	private TreeViewer m_treeViewer;

	private static List<MutatorInfoClass> metrics = null;
	
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
		try {
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
			metrics = new ArrayList<MutatorInfoClass>();
			metrics.addAll(Arrays.asList(MutatorInfo.createMutatorInfoMetrics(xmiFileName, metamodel)));

			Bundle bundle = Platform.getBundle("wodel.models");
			URL fileURL = bundle.getEntry("/models/MutatorEnvironment.ecore");
			String mutatorecore = FileLocator.resolve(fileURL).getFile();
			List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
			Resource program = ModelManager.loadModel(mutatorpackages, URI.createURI(xmiFileName).toFileString());
			String path = ModelManager.getWorkspaceAbsolutePath() + '/' + manager.WodelContext.getProject();
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
			if (parentElement instanceof MutatorInfoClass) {
				MutatorInfoFeature[] features = ((MutatorInfoClass) parentElement).getFeatures();
				ArrayList<MutatorInfoFeature> feats = new ArrayList<MutatorInfoFeature>();
				for (MutatorInfoFeature feat : features) {
					if (feat.getName().equals("Seeds")) {
						if (feat.getSeeds().length > 0) {
							feats.add(feat);
						}
					}
				}
				MutatorInfoFeature[] ret = new MutatorInfoFeature[feats.size()];
				feats.toArray(ret);
				return ret;
			}
			if (parentElement instanceof MutatorInfoFeature) {
				MutatorInfoFeature feature = (MutatorInfoFeature) parentElement;
				if (feature.getName().equals("Seeds")) {
					return feature.getSeeds();
				}
			}
			if (parentElement instanceof MutatorInfoSeed) {
				MutatorInfoSeed seed = (MutatorInfoSeed) parentElement;
				return seed.getMutants();
			}
			return new Object[0];
		}

		public Object getParent(Object element) {
			if (element instanceof MutatorInfoClass) {
				return ((MutatorInfoClass) element).getName();
			}
			if (element instanceof MutatorInfoFeature) {
				return ((MutatorInfoFeature) element).getName();
			}
			if (element instanceof MutatorInfoSeed) {
				return ((MutatorInfoSeed) element).getPath();
			}
			if (element instanceof MutatorInfoMutant) {
				return ((MutatorInfoMutant) element).getPath();
			}
			return null;
		}

		public boolean hasChildren(Object element) {
			if (element instanceof List) {
				return ((List<?>) element).size() > 0;
			}
			if (element instanceof MutatorInfoClass) {
				return ((MutatorInfoClass) element).getFeatures().length > 0;
			}
			if (element instanceof MutatorInfoFeature) {
				MutatorInfoFeature feature = (MutatorInfoFeature) element;
				if (feature.getName().equals("Seeds")) {
					return feature.getSeeds().length > 0;
				}
			}
			if (element instanceof MutatorInfoSeed) {
				return ((MutatorInfoSeed) element).getMutants().length > 0;
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
        	Bundle bundle = Platform.getBundle("wodel.metrics.info");
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
			if (obj instanceof MutatorInfoClass) {
				MutatorInfoClass infoClass = (MutatorInfoClass) obj;
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
			switch (columnIndex) {
			case 0:
				if (element instanceof MutatorInfoClass) {
					return ((MutatorInfoClass) element).getName();
				}
				if (element instanceof MutatorInfoFeature) {
					int count = 0;
					for (MutatorInfoSeed infoSeed : ((MutatorInfoFeature) element).getSeeds()) {
						count += infoSeed.getMutants().length;
					}
					return ((MutatorInfoFeature) element).getName() + " (" + ((MutatorInfoFeature) element).getSeeds().length + " s./" + count + " m.)";
				}
				if (element instanceof MutatorInfoSeed) {
					return getRelativePath(((MutatorInfoSeed) element).getPath(), WodelContext.getProject()) + " (" + ((MutatorInfoSeed) element).getMutants().length + "m.)";
				}
				break;
			case 1:
				if (element instanceof MutatorInfoMutant) {
					return getRelativePath(((MutatorInfoMutant) element).getPath(), WodelContext.getProject());
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
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(WodelMetricsInfoView.ID);
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