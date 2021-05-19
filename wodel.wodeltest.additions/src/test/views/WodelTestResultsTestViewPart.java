package test.views;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableColorProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.ViewPart;

import manager.ModelManager;
import manager.ViewUtils;
import utils.MutatorHelper;
import manager.IWodelTest;
import manager.WodelTestClass;
import manager.WodelTestResultTest;
import manager.WodelTestResultTestInfo;
import manager.WodelTestTest;
import manager.WodelTestUtils;

public class WodelTestResultsTestViewPart extends ViewPart {
	
	public static final String ID = "test.views.WodelTestResultsTestViewPart"; //$NON-NLS-1$
	
	private static List<WodelTestTest> tests = null;
	
	private TreeViewer m_treeViewer;
	
	private static final Color RED = new Color(Display.getCurrent(), 255, 102, 102);

	private static final Color GREEN = new Color(Display.getCurrent(), 102, 255, 102);
	
	private static final Color BLUE = new Color(Display.getCurrent(), 102, 102, 255);

	
	private static int filterIndex = -1;
	
	private static IProject sourceProject = null;
	private static String testSuiteName = null;

	
	private static void openFileInEditor(String path) {
		File fileToOpen = new File(path);
		 
		if (fileToOpen.exists() && fileToOpen.isFile()) {
		    IFileStore fileStore = EFS.getLocalFileSystem().getStore(fileToOpen.toURI());
		    IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getPages()[0];
		 
		    try {
		        IDE.openEditorOnFileStore( page, fileStore );
		    } catch ( PartInitException e ) {
		        //Put your exception handler here if you wish to
		    }
		} else {
		    //Do something if the file does not exist
		}
	}
	
	private class DataFilter extends ViewerFilter {

		@Override
		public boolean select(Viewer viewer, Object parentElement, Object element) {
			if (filterIndex == -1 || filterIndex == 0) {
				return true;
			}
			if (filterIndex == 1) {
				if (element instanceof WodelTestTest) {
					return true;
				}
				if (element instanceof WodelTestResultTest) {
					WodelTestResultTest result = (WodelTestResultTest) element;
					boolean killed = false;
					for (WodelTestResultTestInfo info : result.getMutants()) {
						if (info.getValue() == true) {
							killed = true;
							break;
						}
					}
					return killed && result.getFailures() == 0;
				}
				if (element instanceof WodelTestResultTestInfo) {
					WodelTestResultTestInfo result = (WodelTestResultTestInfo) element;
					return result.getValue() && result.getFailure() == false; 
				}
			}
			if (filterIndex == 2) {
				if (element instanceof WodelTestTest) {
					return true;
				}
				if (element instanceof WodelTestResultTest) {
					WodelTestResultTest result = (WodelTestResultTest) element;
					boolean alive = false;
					for (WodelTestResultTestInfo info : result.getMutants()) {
						if (info.getValue() == false) {
							alive = true;
							break;
						}
					}
					return alive && result.getFailures() == 0; 
				}
				if (element instanceof WodelTestResultTestInfo) {
					WodelTestResultTestInfo result = (WodelTestResultTestInfo) element;
					return !result.getValue() && result.getFailure() == false; 
				}
			}
			if (filterIndex == 3) {
				if (element instanceof WodelTestTest) {
					return true;
				}
				if (element instanceof WodelTestResultTest) {
					WodelTestResultTest result = (WodelTestResultTest) element;
					return result.getFailures() > 0; 
				}
				if (element instanceof WodelTestResultTestInfo) {
					WodelTestResultTestInfo result = (WodelTestResultTestInfo) element;
					return result.getFailure();
				}
			}
			return false;
		}
	}

	@Override
	public void createPartControl(Composite parent) {
		if (!ViewUtils.isReady()) {
			return;
		}
		IProject project = ViewUtils.getProject();
	    
	    String path = ModelManager.getWorkspaceAbsolutePath() + "/" + project.getFullPath().toFile().getPath().toString();
	    String classespath = path + "/data/classes.txt";
	    String infopath = path + "/data/classes.results.txt";
	    IWodelTest test = MutatorHelper.getTest(project);
	    Map<String, List<WodelTestClass>> packageClasses = WodelTestUtils.getPackageClasses(test, project.getName(), classespath, infopath);
	    tests = WodelTestUtils.getTests(test, packageClasses, project.getName(), classespath, infopath);
	    boolean withErrors = false;
	    for (WodelTestTest t : tests) {
	    	for (WodelTestResultTest result : t.getResults()) {
	    		if (result.getFailures() > 0) {
	    			withErrors = true;
	    			break;
	    		}
	    	}
	    }
	    
		Composite contents = new Group(parent, SWT.FILL);
	    GridLayout layout = new GridLayout();
		contents.setLayout(layout);
		layout.numColumns = 2;
		layout.verticalSpacing = 9;
	    GridData gd = new GridData(GridData.FILL_HORIZONTAL | GridData.FILL_VERTICAL);
	    gd.horizontalAlignment = SWT.FILL;
	    contents.setLayoutData(gd);
	    
	    Group filter = new Group(contents, SWT.FILL);
	    layout = new GridLayout();
		filter.setLayout(layout);
		layout.numColumns = 1;
		layout.verticalSpacing = 9;
	    filter.setText("Filter");
	    gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalAlignment = SWT.FILL;
		gd.verticalAlignment = SWT.ON_TOP;
		gd.widthHint = 100;
	    filter.setLayoutData(gd);
        final Combo filterCombo = new Combo(filter, SWT.NONE);
        filterCombo.add("All");
        filterCombo.add("Killed");
        filterCombo.add("Alive");
        if (withErrors == true) {
        	filterCombo.add("Error");
        }
		filterCombo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				filterIndex = filterCombo.getSelectionIndex();
				m_treeViewer.collapseAll();
				m_treeViewer.refresh();
			}
		});
		
		Group data = new Group(contents, SWT.FILL);
		FillLayout fill = new FillLayout(SWT.VERTICAL);
		data.setLayout(fill);
		layout.numColumns = 1;
		layout.verticalSpacing = 9;
	    data.setText("Results");
		gd = new GridData(GridData.FILL_HORIZONTAL | GridData.FILL_VERTICAL);
		gd.horizontalAlignment = SWT.FILL;
	    data.setLayoutData(gd);

	    Tree addressTree = new Tree(data, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION);
		addressTree.setHeaderVisible(true);
		addressTree.setLinesVisible(true);
		sourceProject = project;
		testSuiteName = WodelTestUtils.getTestSuiteName(project);
		addressTree.addListener(SWT.MouseDoubleClick, new Listener() {
			@Override
			public void handleEvent(Event event) {
				Point point = new Point(event.x, event.y);
				TreeItem item = addressTree.getItem(point);
		        if (item != null) {
                    Rectangle rect = item.getBounds(0);
	                if (rect.contains(point)) {
                		String path = item.getText(0);
                		if (path.indexOf("/" + sourceProject.getName()) > 0) {
                			path = path.substring(path.indexOf("/" + sourceProject.getName()), path.length());
                		}
                		if (path.indexOf("/" + testSuiteName) > 0) {
							path = path.substring(path.indexOf("/" + testSuiteName), path.length());
						}
                   		openFileInEditor( ModelManager.getWorkspaceAbsolutePath() + path);
		        	}
		        }
			}
		});
	
		m_treeViewer = new TreeViewer(addressTree);
		TreeColumn column1 = new TreeColumn(addressTree, SWT.LEFT);
		column1.setAlignment(SWT.LEFT);
		column1.setText("Test suite/Test case");
		column1.setWidth(400);
		
		TreeColumn column2 = new TreeColumn(addressTree, SWT.LEFT);
		column2.setAlignment(SWT.LEFT);
		column2.setText("#Killed mutants/Message");
		column2.setWidth(400);
		
		TreeColumn column3 = new TreeColumn(addressTree, SWT.LEFT);
		column3.setAlignment(SWT.LEFT);
		column3.setText("Applied mutations");
		column3.setWidth(400);

		m_treeViewer.setContentProvider(new WodelTestClassResultsContentProvider());
		m_treeViewer.setLabelProvider(new TableLabelProvider());
		m_treeViewer.setInput(tests);
		m_treeViewer.addFilter(new DataFilter());
		m_treeViewer.collapseAll();
	}
	
	private class WodelTestClassResultsContentProvider implements ITreeContentProvider {

		@Override
		public Object[] getElements(Object inputElement) {
			return getChildren(inputElement);
		}

		@Override
		public Object[] getChildren(Object parentElement) {
			if (parentElement instanceof List<?>) {
				return ((List<?>) parentElement).toArray();
			}
			if (parentElement instanceof WodelTestTest) {
				return ((WodelTestTest) parentElement).getResults().toArray();
			}
			if (parentElement instanceof WodelTestResultTest) {
				return ((WodelTestResultTest) parentElement).getMutants().toArray();
			}
			return new Object[0]; 
		}

		@Override
		public Object getParent(Object element) {
			if (element instanceof String) {
				return (String) element;
			}
			if (element instanceof WodelTestTest) {
				return ((WodelTestTest) element).getName();
			}
			if (element instanceof WodelTestResultTest) {
				return ((WodelTestResultTest) element).getName();
			}
			if (element instanceof WodelTestResultTestInfo) {
				return ((WodelTestResultTestInfo) element).getName();
			}
			return null;
		}

		@Override
		public boolean hasChildren(Object element) {
			if (element instanceof List<?>) {
				return ((List<?>) element).size() > 0;
			}
			if (element instanceof WodelTestTest) {
				return ((WodelTestTest) element).getResults().size() > 0;
			}
			if (element instanceof WodelTestResultTest) {
				return ((WodelTestResultTest) element).getMutants().size() > 0;
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
		
		private Color getBackground(Object element) {
			if (element instanceof WodelTestTest) {
				WodelTestTest wodelTest = (WodelTestTest) element;
				boolean error = false;
				for (WodelTestResultTest result : wodelTest.getResults()) {
					if (result.getFailures() > 0) {
						error = true;
						break;
					}
				}
				if (wodelTest.getKilledMutants() > 0) { 
					return GREEN;
				}
				else return error ? BLUE : RED;
			}
			if (element instanceof WodelTestResultTest) {
				WodelTestResultTest result = (WodelTestResultTest) element;
				if (result.getFailures() == 0) {
					return result.getDetectedMutants() > 0 ? GREEN : RED;
				}
				else return BLUE;
			}
			if (element instanceof WodelTestResultTestInfo) {
				WodelTestResultTestInfo result = (WodelTestResultTestInfo) element;
				if (result.getFailure() == false) {
					return result.getValue() ? GREEN : RED;
				}
				else {
					return BLUE;
				}
			}
			return null;
		}

		@Override
		public Color getBackground(Object element, int columnIndex) {
			return getBackground(element);
		}

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			String text = null;
			if (element instanceof String) {
				String result = (String) element;
				switch (columnIndex) {
				case 0:
					text = result;
					break;
				}
			}
			if (element instanceof WodelTestTest) {
				WodelTestTest wodelTest = (WodelTestTest) element;
				switch(columnIndex) {
				case 0:
					text = wodelTest.getName();
					break;
				case 1:
					text = String.format("%d", wodelTest.getKilledMutants());
					break;
				}
			}
			if (element instanceof WodelTestResultTest) {
				WodelTestResultTest result = (WodelTestResultTest) element;
				switch (columnIndex) {
				case 0:
					text = result.getName();
					if (text.indexOf("/" + sourceProject.getName()) > 0) {
            			text = text.substring(text.indexOf("/" + sourceProject.getName()), text.length());
            		}
            		if (text.indexOf("/" + testSuiteName) > 0) {
						text = text.substring(text.indexOf("/" + testSuiteName), text.length());
					}
					break;
				case 1:
					if (result.getDetectedMutants() > 0) {
						text = String.format("%d", result.getDetectedMutants());
					}
					break;
				}
			}
			if (element instanceof WodelTestResultTestInfo) {
				WodelTestResultTestInfo result = (WodelTestResultTestInfo) element;
				String mutationText = "";
				List<String> mutation = result.getMutation();
				if (mutation != null) {
					for (String mtext : mutation) {
						mutationText += mtext + "; ";
					}
					if (mutationText.length() > 0) {
						mutationText = mutationText.substring(0, mutationText.lastIndexOf(";"));
					}
				}
				switch (columnIndex) {
				case 0:
					text = result.getName();
					if (text.indexOf("/" + sourceProject.getName()) > 0) {
            			text = text.substring(text.indexOf("/" + sourceProject.getName()), text.length());
            		}
            		if (text.indexOf("/" + testSuiteName) > 0) {
						text = text.substring(text.indexOf("/" + testSuiteName), text.length());
					}
					break;
				case 1:
					text = result.getMessage();
					break;
				case 2:
					text = mutationText;
					break;
				}
			}
			return text;
		}
	}


	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}
}
