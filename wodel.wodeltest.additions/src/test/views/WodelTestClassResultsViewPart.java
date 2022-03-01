package test.views;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableColorProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TreeEditor;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
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
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.ViewPart;

import manager.ModelManager;
import utils.MutatorHelper;
import manager.WodelTestUtils;
import manager.IWodelTest;
import manager.WodelTestClass;
import manager.WodelTestClassInfo;
import manager.WodelTestResultInfo;

public class WodelTestClassResultsViewPart extends ViewPart {
	
	public static final String ID = "test.views.WodelTestClassResultsViewPart"; //$NON-NLS-1$
	
	private static Map<String, List<WodelTestClass>> classes = null;
	
	private static Map<String, List<WodelTestClass>> packageClasses = null;
	private static String[] equivalentMutants = new String[0];
	private static List<Button> buttons = new ArrayList<Button>();
	private static IProject sourceProject = null;
	private static String testSuiteName = null;
	
	private TreeViewer m_treeViewer;
	
	private static final Color RED = new Color(Display.getCurrent(), 255, 102, 102);

	private static final Color GREEN = new Color(Display.getCurrent(), 102, 255, 102);
	
	private static final Color BLUE = new Color(Display.getCurrent(), 102, 102, 255);

	private static int filterIndex = -1;
	
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
				// TODO Auto-generated method stub
				if (element instanceof String) {
					List<WodelTestClass> clss = classes.get((String) element);
					for (WodelTestClass cls : clss) {
						for (WodelTestClassInfo info : cls.info) {
							if (info.getNumFailedTests() > 0) {
								return true;
							}
						}
					}
				}
				if (element instanceof WodelTestClass) {
					WodelTestClass cls = (WodelTestClass) element;
					for (WodelTestClassInfo info : cls.info) {
						if (info.getNumFailedTests() > 0) {
							return true;
						}
					}
				}
				if (element instanceof WodelTestClassInfo) {
					WodelTestClassInfo info = (WodelTestClassInfo) element;
					return info.getNumFailedTests() > 0;
				}
				if (element instanceof WodelTestResultInfo) {
					WodelTestResultInfo result = (WodelTestResultInfo) element;
					return result.value && result.failure == false; 
				}
			}
			if (filterIndex == 2) {
				// TODO Auto-generated method stub
				if (element instanceof String) {
					List<WodelTestClass> clss = classes.get((String) element);
					for (WodelTestClass cls : clss) {
						for (WodelTestClassInfo info : cls.info) {
							if (info.getNumFailedTests() == 0 && info.numFailures == 0) {
								return true;
							}
						}
					}
					return false;
				}
				if (element instanceof WodelTestClass) {
					WodelTestClass cls = (WodelTestClass) element;
					for (WodelTestClassInfo info : cls.info) {
						if (info.getNumFailedTests() == 0 && info.numFailures == 0) {
							return true;
						}
					}
					return true;
				}
				if (element instanceof WodelTestClassInfo) {
					WodelTestClassInfo info = (WodelTestClassInfo) element;
					return info.getNumFailedTests() == 0 && info.numFailures == 0;
				}
				if (element instanceof WodelTestResultInfo) {
					WodelTestResultInfo result = (WodelTestResultInfo) element;
					return !result.value && result.failure == false; 
				}
			}
			if (filterIndex == 3) {
				// TODO Auto-generated method stub
				if (element instanceof String) {
					List<WodelTestClass> clss = classes.get((String) element);
					for (WodelTestClass cls : clss) {
						for (WodelTestClassInfo info : cls.info) {
							if (info.numFailures > 0) {
								return true;
							}
						}
					}
					return false;
				}
				if (element instanceof WodelTestClass) {
					WodelTestClass cls = (WodelTestClass) element;
					for (WodelTestClassInfo info : cls.info) {
						if (info.numFailures > 0) {
							return true;
						}
					}
					return false;
				}
				if (element instanceof WodelTestClassInfo) {
					WodelTestClassInfo info = (WodelTestClassInfo) element;
					return info.numFailures > 0;
				}
				if (element instanceof WodelTestResultInfo) {
					WodelTestResultInfo result = (WodelTestResultInfo) element;
					return result.failure; 
				}
			}
			return false;
		}
		
	}

	@Override
	public void createPartControl(Composite parent) {
		if (WodelTestUtils.isReadyProject() != true) {
			return;
		}
		IProject project = WodelTestUtils.getProject();
	    
	    String path = ModelManager.getWorkspaceAbsolutePath() + "/" + project.getFullPath().toFile().getPath().toString();
	    String classespath = path + "/data/classes.txt";
	    String infopath = ModelManager.getWorkspaceAbsolutePath() + "/" + project.getFullPath().toFile().getPath().toString() + "/data/classes.results.txt";
	    IWodelTest test = MutatorHelper.getTest(project);
	    packageClasses = WodelTestUtils.getPackageClasses(test, project.getName(), classespath, infopath);
	    classes = new HashMap<String, List<WodelTestClass>>();
	    for (String pckName : packageClasses.keySet()) {
	    	List<WodelTestClass> pckclasses = WodelTestUtils.getClasses(test, packageClasses, pckName, project.getName(), classespath, infopath);
	    	classes.put(pckName, pckclasses);
	    }
	    boolean withErrors = false;
	    for (List<WodelTestClass> l : classes.values()) {
	    	for (WodelTestClass tc : l) {
	    		for (WodelTestClassInfo info : tc.info) {
	    			if (info.numFailures > 0) {
	    				withErrors = true;
	    				break;
	    			}
	    		}
	    	}
	    }

	    String equivalentpath = ModelManager.getWorkspaceAbsolutePath() + "/" + project.getFullPath().toFile().getPath().toString() + "/data/classes.equivalent.txt";
	    String[] equivalent = WodelTestUtils.loadFile(equivalentpath);
	    if (equivalent.length > 0) {
		    equivalentMutants = equivalent[0].split("[|]");
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
        filterCombo.add("Failed");
        filterCombo.add("Passed");
        if (withErrors == true) {
        	filterCombo.add("Error");
        }
        filterCombo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				filterIndex = filterCombo.getSelectionIndex();
				for (Button button : buttons) {
					button.dispose();
				}
				buttons.clear();
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
	    
		final Tree addressTree = new Tree(data, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION);
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
                    Rectangle rect = item.getBounds(1);
	                if (rect.contains(point)) {
	                	if (item.getParentItem() != null) {
	                		String path = item.getText(1);
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
			}
		});
		addressTree.addListener(SWT.Expand, new Listener() {
			@Override
			public void handleEvent(Event event) {
				Point point = new Point(event.x, event.y);
				TreeItem item = addressTree.getItem(point);
				if (item != null) {
					if (item.getData() instanceof String) {
						for (TreeItem it : item.getItems()) {
							if (it.getData() instanceof WodelTestClass) {
								for (TreeItem ti : it.getItems()) {
									if (ti.getData() instanceof WodelTestClassInfo) {
										WodelTestClassInfo info = (WodelTestClassInfo) ti.getData();
										if (info.getNumFailedTests() == 0) {
											TreeEditor editor = new TreeEditor(addressTree); 
											Button button = new Button(addressTree, SWT.CHECK);
											for (String equivalent : equivalentMutants) {
												if (info.path.startsWith(equivalent)) {
													button.setSelection(true);
													break;
												}
											}
											button.addSelectionListener(new SelectionAdapter() {
												@Override
												public void widgetSelected(SelectionEvent e)
											    {
											        Button button = (Button) e.widget;
											        if (button.getSelection()) {
											        	String[] newEquivalent = Arrays.copyOf(equivalentMutants, equivalentMutants.length + 1);
											        	if (info.path.indexOf("src/") != -1) {
											        		newEquivalent[equivalentMutants.length] = info.path.substring(0, info.path.indexOf("src/") + "src/".length());
											        	}
											        	else {
											        		newEquivalent[equivalentMutants.length] = info.path;
											        	}
											        	equivalentMutants = newEquivalent;
											        }
											        else {
											        	String[] newEquivalent = new String[equivalentMutants.length - 1];
											        	String removedEquivalent = null;
											        	if (info.path.indexOf("src/") != -1) {
											        		removedEquivalent = info.path.substring(0, info.path.indexOf("src/") + "src/".length());
											        	}
											        	else {
											        		removedEquivalent = info.path;
											        	}
											        	boolean found = false;
											        	for (int i = 0; i < equivalentMutants.length; i++) {
											        		if (removedEquivalent.equals(equivalentMutants[i])) {
											        			found = true;
											        		}
											        		else {
											        			newEquivalent[i - (found ? 1 : 0)] = equivalentMutants[i];
											        		}
											        	}
											        	equivalentMutants = newEquivalent;
											        }
											        String equivalentPaths = "";
											        for (String equivalentPath : equivalentMutants) {
											        	equivalentPaths += equivalentPath + "|";
											        }
											        if (equivalentPaths.length() > 0) {
														equivalentPaths = equivalentPaths.substring(0, equivalentPaths.length() - 1);
													}
											        WodelTestUtils.storeFile(equivalentpath, equivalentPaths);
											    }
											});
											button.pack();
											editor.minimumWidth = button.getSize().x;
											editor.horizontalAlignment = SWT.LEFT;
											editor.setEditor(button, ti, 0);
											buttons.add(button);
										}
									}
								}
							}
						}
					}
				}
			}
		});
		addressTree.addListener(SWT.Collapse, new Listener() {
			@Override
			public void handleEvent(Event event) {
				Point point = new Point(event.x, event.y);
				TreeItem item = addressTree.getItem(point);
				boolean clear = false;
				if (item != null) {
					if (item.getData() instanceof String) {
						if (item.getItems().length == 0) {
							clear = true;
						}
						else {
							for (TreeItem it : item.getItems()) {
								if (it.getItems().length == 0) {
									clear = true;
									break;
								}
							}
						}
					}
				}
				if (clear == true) {
					for (Button button : buttons) {
						button.dispose();
					}
					buttons.clear();
				}
			}
		});
		m_treeViewer = new TreeViewer(addressTree);
		TreeColumn column0 = new TreeColumn(addressTree, SWT.LEFT);
		column0.setAlignment(SWT.LEFT);
		column0.setText("Equivalent");
		column0.setWidth(100);
		
		TreeColumn column1 = new TreeColumn(addressTree, SWT.LEFT);
		column1.setAlignment(SWT.LEFT);
		column1.setText("Package/class/mutant");
		column1.setWidth(400);
		
		TreeColumn column2 = new TreeColumn(addressTree, SWT.LEFT);
		column2.setAlignment(SWT.LEFT);
		column2.setText("#Executed tests");
		column2.setWidth(100);

		TreeColumn column3 = new TreeColumn(addressTree, SWT.LEFT);
		column3.setAlignment(SWT.LEFT);
		column3.setText("#Failed tests");
		column3.setWidth(100);

		TreeColumn column4 = new TreeColumn(addressTree, SWT.LEFT);
		column4.setAlignment(SWT.LEFT);
		column4.setText("#Passed tests");
		column4.setWidth(100);
		
		TreeColumn column5 = new TreeColumn(addressTree, SWT.LEFT);
		column5.setAlignment(SWT.LEFT);
		column5.setText("Applied mutations/Failed test message");
		column5.setWidth(400);

		m_treeViewer.setContentProvider(new WodelTestClassResultsContentProvider());
		m_treeViewer.setLabelProvider(new TableLabelProvider());
		m_treeViewer.setInput(classes);
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
			if (parentElement instanceof Map<?, ?>) {
				return ((Map<?, ?>) parentElement).keySet().toArray();
			}
			if (parentElement instanceof String) {
				List<WodelTestClass> ret = classes.get((String) parentElement);
				if (ret != null) { 
					return ret.toArray();
				}
			}
			if (parentElement instanceof List<?>) {
				return ((List<?>) parentElement).toArray();
			}
			if (parentElement instanceof WodelTestClass) {
				return ((WodelTestClass) parentElement).info.toArray();
			}
			if (parentElement instanceof WodelTestClassInfo) {
				return ((WodelTestClassInfo) parentElement).tests.toArray();
			}
			return new Object[0]; 
		}

		@Override
		public Object getParent(Object element) {
			if (element instanceof String) {
				return (String) element;
			}
			if (element instanceof WodelTestClass) {
				return ((WodelTestClass) element).classname;
			}
			if (element instanceof WodelTestClassInfo) {
				return ((WodelTestClassInfo) element).path;
			}
			if (element instanceof WodelTestResultInfo) {
				return ((WodelTestResultInfo) element).name;  
			}
			return null;
		}

		@Override
		public boolean hasChildren(Object element) {
			if (element instanceof String) {
				List<WodelTestClass> ret = classes.get((String) element);
				if (ret != null) { 
					return ret.size() > 0;
				}
			}
			if (element instanceof List<?>) {
				return ((List<?>) element).size() > 0;
			}
			if (element instanceof WodelTestClass) {
				return ((WodelTestClass) element).info.size() > 0;
			}
			if (element instanceof WodelTestClassInfo) {
				if (((WodelTestClassInfo) element).tests != null) {
					return ((WodelTestClassInfo) element).tests.size() > 0;
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

		private Color getBackground(Object element) {
			if (element instanceof String) {
				List<WodelTestClass> clss = classes.get((String) element);
				boolean detected = false;
				boolean error = false;
				for (WodelTestClass cls : clss) {
					for (WodelTestClassInfo info : cls.info) {
						if (info.numFailures > 0) {
							error = true;
						}
						if (info.getNumFailedTests() > 0) {
							detected = true;
							break;
						}
					}
					if (detected == true) {
						break;
					}
				}
				if (detected) {
					return GREEN;
				}
				else return error ? BLUE : RED;
			}
			if (element instanceof WodelTestClass) {
				WodelTestClass cls = (WodelTestClass) element;
				boolean detected = false;
				boolean error = false;
				for (WodelTestClassInfo info : cls.info) {
					if (info.numFailures > 0) {
						error = true;
					}
					if (info.getNumFailedTests() > 0) {
						detected = true;
						break;
					}
				}
				if (detected) {
					return GREEN;
				}
				else return error ? BLUE : RED;
			}
			if (element instanceof WodelTestClassInfo) {
				WodelTestClassInfo info = (WodelTestClassInfo) element;
				if (info.getNumFailedTests() > 0) {
					return GREEN;
				}
				else return info.numFailures > 0 ? BLUE : RED;
			}
			if (element instanceof WodelTestResultInfo) {
				WodelTestResultInfo result = (WodelTestResultInfo) element;
				if (result.value) {
					return GREEN;
				}
				else return result.failure ? BLUE : RED;
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
				List<WodelTestClass> clss = classes.get((String) element);
				int numExecutedTests = clss != null ? 0 : -1;
				int numFailedTests = clss != null ? 0 : -1;
				for (WodelTestClass cls : clss) {
					for (WodelTestClassInfo info : cls.info) {
						numExecutedTests += info.getNumExecutedTests();
						numFailedTests += info.getNumFailedTests();
					}
				}
				switch (columnIndex) {
				case 0:
					break;
				case 1:
					text = result;
					break;
				case 2:
					if (numExecutedTests > 0) {
						text = String.format("%d", numExecutedTests);
					}
					break;
				case 3:
					if (numFailedTests > 0) {
						text = String.format("%d", numFailedTests);
					}
					break;
				case 4:
					if (numExecutedTests - numFailedTests > 0) {
						text = String.format("%d", numExecutedTests - numFailedTests);
					}
					break;
				}
			}
			if (element instanceof WodelTestClass) {
				WodelTestClass wodelTestClass = (WodelTestClass) element;
				int numExecutedTests = 0;
				int numFailedTests = 0;
				for (WodelTestClassInfo info : wodelTestClass.info) {
					numExecutedTests += info.getNumExecutedTests();
					numFailedTests += info.getNumFailedTests();
				}
				int numPassedTests = numExecutedTests - numFailedTests;
				switch(columnIndex) {
				case 0:
					break;
				case 1:
					text = wodelTestClass.classname;
					break;
				case 2:
					if (numExecutedTests > 0) {
						text = String.format("%d", numExecutedTests);
					}
					break;
				case 3:
					if (numFailedTests > 0) {
						text = String.format("%d", numFailedTests);
					}
					break;
				case 4:
					if (numPassedTests > 0) {
						text = String.format("%d", numPassedTests);
					}
					break;
				}
			}
			if (element instanceof WodelTestClassInfo) {
				WodelTestClassInfo info = (WodelTestClassInfo) element;
				String mutationText = "";
				for (String mtext : info.mutationText) {
					mutationText += mtext + "; ";
				}
				if (mutationText.length() > 0) {
					mutationText = mutationText.substring(0, mutationText.lastIndexOf(";"));
				}
				switch (columnIndex) {
				case 0:
					break;
				case 1:
					text = info.path;
					if (text.indexOf("/" + sourceProject.getName()) > 0) {
						text = text.substring(text.indexOf("/" + sourceProject.getName()), text.length());
					}
					if (text.indexOf("/" + testSuiteName) > 0) {
						text = text.substring(text.indexOf("/" + testSuiteName), text.length());
					}
					break;
				case 2:
					if (info.getNumExecutedTests() > 0) {
						text = String.format("%d", info.getNumExecutedTests());
					}
					break;
				case 3:
					if (info.getNumFailedTests() > 0) {
						text = String.format("%d", info.getNumFailedTests());
					}
					break;
				case 4:
					if (info.getNumExecutedTests() - info.getNumFailedTests() > 0) {
						text = String.format("%d", info.getNumExecutedTests() - info.getNumFailedTests());
					}
					break;
				case 5:
					text = mutationText;
					break;
				}
			}
			if (element instanceof WodelTestResultInfo) {
				WodelTestResultInfo info = (WodelTestResultInfo) element;
				switch (columnIndex) {
				case 0:
					break;
				case 1:
					text = info.name;
					if (text.indexOf("/" + sourceProject.getName()) > 0) {
						text = text.substring(text.indexOf("/" + sourceProject.getName()), text.length());
					}
					if (text.indexOf("/" + testSuiteName) > 0) {
						text = text.substring(text.indexOf("/" + testSuiteName), text.length());
					}
					break;
				case 2:
					text = info.numExecutions == 0 ? "" : String.format("%d", info.numExecutions);
					break;
				case 3:
					text = info.value ? String.format("%d", info.numFailed) : "";
					break;
				case 4:
					text = info.value ? "" : String.format("%d", info.numExecutions - info.numFailed);
					break;
				case 5:
					text = info.message;
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
