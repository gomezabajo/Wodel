package wodeltest.run.views;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.ILabelProviderListener;
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
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.ViewPart;
import org.osgi.framework.Bundle;

import wodel.utils.exceptions.MetaModelNotFoundException;
import wodel.utils.exceptions.ModelNotFoundException;
import wodel.utils.manager.ModelManager;
import wodel.utils.manager.MutatorUtils;
import wodeltest.run.utils.MutatorHelper;
import wodeltest.run.utils.JUnitProgressBar.Failure;
import wodeltest.run.utils.JUnitProgressBar.Ok;
import wodeltest.run.utils.JUnitProgressBar.Stopped;
import wodel.utils.manager.IWodelTest;
import wodel.utils.manager.WodelTestClass;
import wodel.utils.manager.WodelTestClassInfo;
import wodeltest.extension.utils.WodelTestMutatorGroup;
import wodeltest.extension.utils.WodelTestMutatorResult;
import wodel.utils.manager.WodelTestUtils;

public class WodelTestMutatorResultsViewPart extends ViewPart implements IPartListener {

	public static final String ID = "wodeltest.run.views.WodelTestMutatorResultsViewPart"; //$NON-NLS-1$

	private static Map<String, Map<String, List<WodelTestMutatorGroup>>> mutatorData = null;

	private static IProject sourceProject = null;

	private static List<String> testSuiteNames = null;

	private static String currentTestSuiteName = null;

	private Map<String, TreeViewer> m_treeViewer = new TreeMap<String, TreeViewer>();
	
	//private static final Color RED = new Color(Display.getCurrent(), 255, 102, 102);
	private static final Color RED = new Failure(Display.getCurrent()).getColor();

	//private static final Color GREEN = new Color(Display.getCurrent(), 102, 255, 102);
	private static final Color GREEN = new Ok(Display.getCurrent()).getColor();
	
	//private static final Color BLUE = new Color(Display.getCurrent(), 102, 102, 255);
	private static final Color GREY = new Stopped(Display.getCurrent()).getColor();

	private static Map<String, Composite> contents = new TreeMap<String, Composite>();

	private TabFolder m_tabFolder = null;

	private static TabItem currentTab = null;
	
	private static boolean partDeactivated = false;

	private static Map<String, Integer> filterIndex = new TreeMap<String, Integer>();
	
	private static Map<String, Integer> totalNumberOfMutants = null;

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

	public class DataFilter extends ViewerFilter {

		final private String testSuiteNameDataFilter;
		
		public DataFilter(String testSuiteNameDataFilter) {
			this.testSuiteNameDataFilter = testSuiteNameDataFilter;
		}

		@Override
		public boolean select(Viewer viewer, Object parentElement, Object element) {
			if (WodelTestUtils.projectsAreReady() == null) {
				return true;
			}
			if (filterIndex.get(this.testSuiteNameDataFilter) == -1 || filterIndex.get(this.testSuiteNameDataFilter) == 0) {
				return true;
			}
			if (filterIndex.get(this.testSuiteNameDataFilter) == 1) {
				// TODO Auto-generated method stub
				if (element instanceof String) {
					if (mutatorData.containsKey(testSuiteNameDataFilter)) {
						return mutatorData.get(testSuiteNameDataFilter).size() > 0;
					}
					return true;
				}
				if (element instanceof WodelTestMutatorGroup) {
					WodelTestMutatorGroup wtmg = (WodelTestMutatorGroup) element;
					return wtmg.getNumberOfMutants() > 0;
				}
				if (element instanceof WodelTestMutatorResult) {
					WodelTestMutatorResult wtmr = (WodelTestMutatorResult) element;
					return wtmr.getNumberOfMutants() > 0;
				}
				if (element instanceof String && parentElement instanceof WodelTestMutatorResult) {
					WodelTestMutatorResult wtmr = (WodelTestMutatorResult) parentElement;
					return wtmr.getNumberOfMutants() > 0;
				}
			
			}
			if (filterIndex.get(this.testSuiteNameDataFilter) == 2) {
				// TODO Auto-generated method stub
				if (element instanceof String) {
					if (mutatorData.containsKey(testSuiteNameDataFilter)) {
						return mutatorData.get(testSuiteNameDataFilter).size() > 0;
					}
					return true;
				}
				if (element instanceof WodelTestMutatorGroup) {
					WodelTestMutatorGroup wtmg = (WodelTestMutatorGroup) element;
					return wtmg.getNumberOfMutants() == 0 && wtmg.getFailures() == 0;
				}
				if (element instanceof WodelTestMutatorResult) {
					WodelTestMutatorResult wtmr = (WodelTestMutatorResult) element;
					return wtmr.getNumberOfMutants() == 0 && wtmr.getFailures() == 0;
				}
				if (element instanceof String && parentElement instanceof WodelTestMutatorResult) {
					WodelTestMutatorResult wtmr = (WodelTestMutatorResult) parentElement;
					return wtmr.getNumberOfMutants() == 0 && wtmr.getFailures() == 0;
				}
			}
			if (filterIndex.get(this.testSuiteNameDataFilter) == 3) {
				// TODO Auto-generated method stub
				if (element instanceof String) {
					if (mutatorData.containsKey(testSuiteNameDataFilter)) {
						return mutatorData.get(testSuiteNameDataFilter).size() > 0;
					}
					return true;
				}
				if (element instanceof WodelTestMutatorGroup) {
					WodelTestMutatorGroup wtmg = (WodelTestMutatorGroup) element;
					return wtmg.getFailures() > 0;
				}
				if (element instanceof WodelTestMutatorResult) {
					WodelTestMutatorResult wtmr = (WodelTestMutatorResult) element;
					return wtmr.getFailures() > 0;
				}
				if (element instanceof String && parentElement instanceof WodelTestMutatorResult) {
					WodelTestMutatorResult wtmr = (WodelTestMutatorResult) parentElement;
					return wtmr.getFailures() > 0;
				}
			}
			return false;
		}
	}

	@Override
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
		if (WodelTestUtils.projectsAreReady() == null) {
			return;
		}
		IProject project = WodelTestUtils.getProject();
	    
	    String path = project.getLocation().toFile().getPath().replace("\\", "/");
	    String workspacePath = path.substring(0, path.lastIndexOf("/" + project.getName()));
	    String classespath = path + "/data/classes.txt";
		//String testSuiteName = Platform.getPreferencesService().getString("WodelTest", "Current test-suite", WodelTestUtils.getTestSuiteName(project), null);
	    testSuiteNames = WodelTestUtils.getTestSuitesNames(project);
	    IWodelTest test = MutatorHelper.getTest(project);
		MutatorHelper mutatorHelper = new MutatorHelper(test);
		Map<String, Class<?>> mutators = mutatorHelper.getMutators();
		Bundle bundle = Platform.getBundle("wodel.models");
		URL fileURL = bundle.getEntry("/model/MutatorEnvironment.ecore");
		Map<String, Boolean> withErrors = new TreeMap<String, Boolean>();
		totalNumberOfMutants = new TreeMap<String, Integer>();
		mutatorData = new TreeMap<String, Map<String, List<WodelTestMutatorGroup>>>();
		try {
			String ecore = FileLocator.resolve(fileURL).getFile();
			List<EPackage> mutatorpackages = ModelManager.loadMetaModel(ecore);
		    for (String testSuiteName : testSuiteNames) {
		    	String infopath = project.getLocation().toFile().getPath() + "/data/" + testSuiteName + "/classes.results.txt";
			    Map<String, List<WodelTestClass>> packageClasses = WodelTestUtils.getPackageClasses(test, project.getName(), classespath, infopath);
			    Map<String, List<WodelTestClass>> classes =  new LinkedHashMap<String, List<WodelTestClass>>();
			    for (String pckName : packageClasses.keySet()) {
			    	List<WodelTestClass> pckclasses = WodelTestUtils.getClasses(packageClasses, pckName, project.getName(), classespath, infopath);
			    	classes.put(pckName, pckclasses);
			    }
				List<WodelTestMutatorGroup> mutatorList = new ArrayList<WodelTestMutatorGroup>();
				List<String> pathsToProcess = new ArrayList<String>();
				for (String key : classes.keySet()) {
					List<WodelTestClass> wtcl = classes.get(key);
					for (WodelTestClass wtc : wtcl) {
						for (WodelTestClassInfo info : wtc.info) {
							if (!pathsToProcess.contains(info.path)) {
								pathsToProcess.add(info.path);
							}
						}
					}
				}
				withErrors.put(testSuiteName, false);
				List<WodelTestMutatorGroup> lwtmg = new ArrayList<WodelTestMutatorGroup>();
				for (String projectName : mutators.keySet()) {
					List<WodelTestMutatorResult> lwtmr = new ArrayList<WodelTestMutatorResult>();
					Class<?> mutator = mutators.get(projectName);
					Resource model = ModelManager.loadModel(mutatorpackages, ModelManager.getOutputPath(mutator) + "/" + mutator.getSimpleName().replace("Dynamic", "") + ".model");
					List<EObject> blocks = MutatorUtils.getBlocks(model);
					EObject program = ModelManager.getObjectsOfType("Program", model).get(0);
					String description = ModelManager.getStringAttribute("description", program);
					WodelTestMutatorGroup wtmg = new WodelTestMutatorGroup(projectName, description, lwtmr);
					lwtmg.add(wtmg);
					for (EObject block : blocks) {
						String name = ModelManager.getStringAttribute("name", block);
						description = ModelManager.getStringAttribute("description", block);
						WodelTestMutatorResult wtmr = new WodelTestMutatorResult(name, description, 0, 0, new ArrayList<String>());
						lwtmr.add(wtmr);
					}
				}
				for (String key : classes.keySet()) {
					List<WodelTestClass> wtcl = classes.get(key);
					for (WodelTestClass wtc : wtcl) {
						for (WodelTestClassInfo info : wtc.info) { 
							for (WodelTestMutatorGroup wtmg : lwtmg) {
								List<WodelTestMutatorResult> lwtmr = wtmg.getResults();
								for (WodelTestMutatorResult wtmr : lwtmr) {
									if (info.path.contains("/" + wtmr.getMutatorName() + "/") || info.path.contains("\\" + wtmr.getMutatorName() + "\\")) {
										wtmr.setNumberOfMutants(wtmr.getNumberOfMutants() + 1);
										wtmr.getPaths().add(info.path);
										wtmr.setFailures(wtmr.getFailures() + info.numFailures);
									}
								}
							}
						}
					}
				}
				int numTotalOfMutants = 0;
				for (WodelTestMutatorGroup wtmg : lwtmg) {
					mutatorList.add(wtmg);
					numTotalOfMutants += wtmg.getNumberOfMutants();
				}
				totalNumberOfMutants.put(testSuiteName, numTotalOfMutants);
				Map<String, List<WodelTestMutatorGroup>> mutData = new TreeMap<String, List<WodelTestMutatorGroup>>();
				mutData.put(test.getProjectName(), mutatorList);
				mutatorData.put(testSuiteName, mutData);

				String nonProcessedPaths = "";
				for (String pth : pathsToProcess) {
					nonProcessedPaths += pth + "\n";
				}
				WodelTestUtils.storeFile(path + "/data/" + testSuiteName + "/non.processed.paths.txt", nonProcessedPaths);
		    }
		
//			for (String projectName : mutators.keySet()) {
//				List<WodelTestMutatorResult> lwtmr = new ArrayList<WodelTestMutatorResult>();
//				Class<?> mutator = mutators.get(projectName);
//				Resource model = ModelManager.loadModel(mutatorpackages, ModelManager.getOutputPath(mutator) + "/" + mutator.getSimpleName() + ".model");
//				List<EObject> blocks = MutatorUtils.getBlocks(model);
//				EObject program = ModelManager.getObjectsOfType("Program", model).get(0);
//				String description = ModelManager.getStringAttribute("description", program);
//				WodelTestMutatorGroup wtmg = new WodelTestMutatorGroup(projectName, description, lwtmr);
//				for (EObject block : blocks) {
//					String name = ModelManager.getStringAttribute("name", block);
//					description = ModelManager.getStringAttribute("description", block);
//					int numberOfMutants = 0;
//					int failures = 0;
//					List<String> paths = new ArrayList<String>();
//					for (String key : packageClasses.keySet()) {
//						List<WodelTestClass> wtcl = packageClasses.get(key);
//						for (WodelTestClass wtc : wtcl) {
//							for (WodelTestClassInfo info : wtc.info) {
//								if (info.path.contains("/" + name + "/")) {
//									failures += info.numFailures;
//									numberOfMutants++;
//									paths.add(info.path);
//									pathsToProcess.remove(info.path);
//								}
//							}
//						}
//					}
//					if (failures > 0) {
//						withErrors = true;
//					}
//					WodelTestMutatorResult wtmr = new WodelTestMutatorResult(name, description, numberOfMutants, failures, paths);
//					lwtmr.add(wtmr);
//				}
//				mutatorData.add(wtmg);
//			}
		} catch (MetaModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    m_tabFolder = new TabFolder(parent, SWT.FILL);
		m_tabFolder.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				TabFolder tabFolder = (TabFolder) event.getSource();
				currentTab = tabFolder.getItem(tabFolder.getSelectionIndex());
				currentTestSuiteName = currentTab.getText();
				String testSuiteName = currentTestSuiteName;
				if (currentTab != null && contents != null && contents.get(testSuiteName) != null) {
					m_treeViewer.get(testSuiteName).setContentProvider(new WodelTestMutatorResultsContentProvider());
					m_treeViewer.get(testSuiteName).setLabelProvider(new TableLabelProvider());
					m_treeViewer.get(testSuiteName).setInput(mutatorData.get(testSuiteName));
					m_treeViewer.get(testSuiteName).addFilter(new DataFilter(testSuiteName));
					m_treeViewer.get(testSuiteName).collapseAll();
					contents.get(testSuiteName).layout();
					contents.get(testSuiteName).redraw();
				}
			}
		});
		
		for (String testSuiteName : testSuiteNames) {
			Composite currentContents = new Group(m_tabFolder, SWT.FILL);
    		contents.put(testSuiteName, currentContents);

    		final TabItem tabItem = new TabItem(m_tabFolder, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION);
    		tabItem.setText(testSuiteName);
    		tabItem.setControl(currentContents);
    		
    		GridLayout layout = new GridLayout();
		    currentContents.setLayout(layout);
			layout.numColumns = 2;
			layout.verticalSpacing = 9;

			GridData gd = new GridData(GridData.FILL_HORIZONTAL | GridData.FILL_VERTICAL);
		    gd.horizontalAlignment = SWT.FILL;
		    currentContents.setLayoutData(gd);

		    Group filter = new Group(currentContents, SWT.FILL);
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
	        filterCombo.add("Applied");
	        filterCombo.add("Not applied");
	        if (withErrors.get(testSuiteName) == true) {
	        	filterCombo.add("Error");
	        }
	        filterCombo.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					filterIndex.put(testSuiteName, filterCombo.getSelectionIndex());
					m_treeViewer.get(testSuiteName).collapseAll();
					m_treeViewer.get(testSuiteName).refresh();
				}
			});		
			Group data = new Group(currentContents, SWT.FILL);
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
			addressTree.addListener(SWT.MouseDoubleClick, new Listener() {
				@Override
				public void handleEvent(Event event) {
					Point point = new Point(event.x, event.y);
					TreeItem item = addressTree.getItem(point);
			        if (item != null) {
	                    Rectangle rect = item.getBounds(2);
		                if (rect.contains(point)) {
		                	if (item.getParentItem() != null) {
		                		String path = item.getText(2);
		                		if (path.indexOf("/" + sourceProject.getName()) > 0) {
		                			path = path.substring(path.indexOf("/" + sourceProject.getName()), path.length());
		                		}
	                    		openFileInEditor( workspacePath + "/" + path);
		                    }
			        	}
			        }
				}
			});

			TreeViewer treeViewer = new TreeViewer(addressTree);
    		m_treeViewer.put(testSuiteName, treeViewer);

    		TreeColumn column0 = new TreeColumn(addressTree, SWT.LEFT);
			column0.setAlignment(SWT.LEFT);
			column0.setWidth(100);

			TreeColumn column1 = new TreeColumn(addressTree, SWT.LEFT);
			column1.setAlignment(SWT.LEFT);
			column1.setText("Mutation operator/description");
			column1.setWidth(400);

			TreeColumn column2 = new TreeColumn(addressTree, SWT.LEFT);
			column2.setAlignment(SWT.LEFT);
			column2.setText("Generated mutants/paths");
			column2.setWidth(200);

			if (filterIndex.get(testSuiteName) == null) {
				filterIndex.put(testSuiteName, -1);
			}
			
			m_treeViewer.get(testSuiteName).setContentProvider(new WodelTestMutatorResultsContentProvider());
			m_treeViewer.get(testSuiteName).setLabelProvider(new TableLabelProvider());
			m_treeViewer.get(testSuiteName).setInput(mutatorData.get(testSuiteName));
			m_treeViewer.get(testSuiteName).addFilter(new DataFilter(testSuiteName));
			m_treeViewer.get(testSuiteName).collapseAll();
		}
		getSite().getPage().addPartListener(this);
	}

	private class WodelTestMutatorResultsContentProvider implements ITreeContentProvider {
		@Override
		public Object[] getElements(Object inputElement) {
			return getChildren(inputElement);
		}

		@Override
		public Object[] getChildren(Object parentElement) {
			if (WodelTestUtils.projectsAreReady() == null) {
				return new Object[0];
			}
			IProject project = WodelTestUtils.getProject();
			testSuiteNames = WodelTestUtils.getTestSuitesNames(project);
			String testSuiteName = null;
			if (testSuiteNames.size() > 0) {
				testSuiteName = testSuiteNames.get(0);
			}
			if (currentTab != null && currentTab.isDisposed() == false) {
				testSuiteName = currentTab.getText();
			}
			if (currentTestSuiteName != null && currentTestSuiteName.length() > 0) {
				testSuiteName = currentTestSuiteName;
			}
			if (parentElement instanceof Map<?, ?>) {
				return ((Map<?, ?>) parentElement).keySet().toArray();
			}
			if (parentElement instanceof String) {
				String element = (String) parentElement;
				if (mutatorData.containsKey(testSuiteName)) {
					if (mutatorData.get(testSuiteName).containsKey(element)) {
						return mutatorData.get(testSuiteName).get(element).toArray();
					}
				}
			}
			if (parentElement instanceof List<?>) {
				return ((List<?>) parentElement).toArray();
			}
			if (parentElement instanceof WodelTestMutatorGroup) {
				return ((WodelTestMutatorGroup) parentElement).getResults().toArray();
			}
			if (parentElement instanceof WodelTestMutatorResult) {
				return ((WodelTestMutatorResult) parentElement).getPaths().toArray();
			}
			return new Object[0]; 
		}

		@Override
		public Object getParent(Object element) {
			if (element instanceof String) {
				return (String) element;
			}
			if (element instanceof WodelTestMutatorGroup) {
				return (WodelTestMutatorGroup) element;
			}
			if (element instanceof WodelTestMutatorResult) {
				return (WodelTestMutatorResult) element;
			}
			return null;
		}

		@Override
		public boolean hasChildren(Object element) {
			if (WodelTestUtils.projectsAreReady() == null) {
				return false;
			}
			IProject project = WodelTestUtils.getProject();
			testSuiteNames = WodelTestUtils.getTestSuitesNames(project);
			String testSuiteName = null;
			if (testSuiteNames.size() > 0) {
				testSuiteName = testSuiteNames.get(0);
			}
			if (currentTab != null && currentTab.isDisposed() == false) {
				testSuiteName = currentTab.getText();
			}
			if (currentTestSuiteName != null && currentTestSuiteName.length() > 0) {
				testSuiteName = currentTestSuiteName;
			}
			if (element instanceof String) {
				String item = (String) element;
				if (mutatorData.containsKey(testSuiteName)) {
					if (mutatorData.get(testSuiteName).containsKey(item)) {
						return mutatorData.get(testSuiteName).get(item).size() > 0;
					}
				}
			}
			if (element instanceof List<?>) {
				return ((List<?>) element).size() > 0;
			}
			if (element instanceof WodelTestMutatorGroup) {
				WodelTestMutatorGroup wtmg = (WodelTestMutatorGroup) element;
				return wtmg.getResults().size() > 0;
			}
			if (element instanceof WodelTestMutatorResult) {
				WodelTestMutatorResult wtmr = (WodelTestMutatorResult) element;
				return wtmr.getPaths().size() > 0;
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
			if (WodelTestUtils.projectsAreReady() == null) {
				return null;
			}
			IProject project = WodelTestUtils.getProject();
			testSuiteNames = WodelTestUtils.getTestSuitesNames(project);
			String testSuiteName = null;
			if (testSuiteNames.size() > 0) {
				testSuiteName = testSuiteNames.get(0);
			}
			if (currentTab != null && currentTab.isDisposed() == false) {
				testSuiteName = currentTab.getText();
			}
			if (currentTestSuiteName != null && currentTestSuiteName.length() > 0) {
				testSuiteName = currentTestSuiteName;
			}
			if (element instanceof String) {
				List<WodelTestMutatorGroup> mutatorList = mutatorData.get(testSuiteName).get((String) element);
				if (mutatorList != null) {
					boolean failures = false;
					for (WodelTestMutatorGroup data : mutatorList) {
						if (data != null) {
							if (data.getNumberOfMutants() > 0) {
								return GREEN;
							}
							if (data.getFailures() > 0) {
								failures = true;
								break;
							}
						}
					}
					if (failures == false) {
						return RED;
					}
					else {
						return GREY;
					}
				}
			}
			if (element instanceof WodelTestMutatorGroup) {
				WodelTestMutatorGroup data = (WodelTestMutatorGroup) element;
				if (data != null) {
					if (data.getNumberOfMutants() > 0) {
						return GREEN;
					}
					else {
						if (data.getFailures() == 0) {
							return RED;
						}
						else {
							return GREY;
						}
					}
				}
			}
			if (element instanceof WodelTestMutatorResult) {
				WodelTestMutatorResult data = (WodelTestMutatorResult) element;
				if (data != null) {
					if (data.getFailures() == 0) {
						return data.getNumberOfMutants() > 0 ? GREEN : RED;
					}
					else {
						return GREY;
					}
				}
			}
			if (element instanceof String) {
				return GREEN;
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
			if (WodelTestUtils.projectsAreReady() == null) {
				return null;
			}
			IProject project = WodelTestUtils.getProject();
			testSuiteNames = WodelTestUtils.getTestSuitesNames(project);
			String testSuiteName = null;
			if (testSuiteNames.size() > 0) {
				testSuiteName = testSuiteNames.get(0);
			}
			if (currentTab != null && currentTab.isDisposed() == false) {
				testSuiteName = currentTab.getText();
			}
			if (currentTestSuiteName != null && currentTestSuiteName.length() > 0) {
				testSuiteName = currentTestSuiteName;
			}
			String text = null;
			if (element instanceof String) {
				switch (columnIndex) {
				case 0:
					break;
				case 1:
					text = (String) element;
					break;
				case 2:
					text = String.format("%d", (new File((String) element)).exists() ? 1 : totalNumberOfMutants.get(testSuiteName));
					break;
				}
			}
			if (element instanceof WodelTestMutatorGroup) {
				WodelTestMutatorGroup data = (WodelTestMutatorGroup) element;
				if (data != null) {
					switch (columnIndex) {
					case 0:
						break;
					case 1:
						text = data.getGroupName() + (data.getGroupDescription() != null ? "/" + data.getGroupDescription() : "");
						break;
					case 2:
						text = String.format("%d", data.getNumberOfMutants());
						break;
					}
				}
			}
			if (element instanceof WodelTestMutatorResult) {
				WodelTestMutatorResult data = (WodelTestMutatorResult) element;
				if (data != null) {
					switch (columnIndex) {
					case 0:
						break;
					case 1:
						text = data.getMutatorName() + (data.getMutatorDescription() != null ? "/" + data.getMutatorDescription() : "");
						break;
					case 2:
						text = String.format("%d", data.getNumberOfMutants());
						break;
					}
				}
			}
			return text;
		}
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void partActivated(IWorkbenchPart part) {
		if (WodelTestUtils.projectsAreReady() == null) {
			return;
		}
		IProject project = WodelTestUtils.getProject();
		testSuiteNames = WodelTestUtils.getTestSuitesNames(project);
		// TODO Auto-generated method stub
		if (partDeactivated == false) {
			if (contents != null && m_treeViewer != null) {
				for (String testSuiteName : testSuiteNames) {
					if (m_treeViewer.get(testSuiteName) != null) {
						m_treeViewer.get(testSuiteName).setContentProvider(new WodelTestMutatorResultsContentProvider());
						m_treeViewer.get(testSuiteName).setLabelProvider(new TableLabelProvider());
						m_treeViewer.get(testSuiteName).setInput(mutatorData.get(testSuiteName));
						m_treeViewer.get(testSuiteName).addFilter(new DataFilter(testSuiteName));
						m_treeViewer.get(testSuiteName).collapseAll();
					}
					if (contents.get(testSuiteName) != null) {
						contents.get(testSuiteName).layout();
						contents.get(testSuiteName).redraw();
					}
					if (filterIndex.get(testSuiteName) != null) {
						filterIndex.put(testSuiteName, -1);
					}
				}
			}
	    }
		partDeactivated = false;
	}

	@Override
	public void partBroughtToTop(IWorkbenchPart part) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void partClosed(IWorkbenchPart part) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void partDeactivated(IWorkbenchPart part) {
		// TODO Auto-generated method stub
		partDeactivated = true;
	}

	@Override
	public void partOpened(IWorkbenchPart part) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		getSite().getPage().removePartListener(this);
	}
}
