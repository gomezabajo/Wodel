package mutator.wodeltest.WodelTest4ATL.properties;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.PropertyPage;

import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.m2m.atl.adt.AtlNature;

import mutator.wodeltest.WodelTest4ATL.WodelTest;
import wodel.utils.manager.ModelManager;
import java.io.File;

public class WodelTestPropertiesPage extends PropertyPage {
	
	private static final String WODEL_TEST_PROJECT_TITLE = "Wodel-Test project:";
	private static final String WODEL_TEST_PROJECT_PATH = "Wodel-Test project path:";

	private static final String SUT_PROJECT_TITLE = "SuT project:";
	private static final String SUT_PROJECT_PATH = "SuT project path:";
	private static final String SUT_NATURE_TITLE = "Nature:";
	private static final String TEST_SUITE_PROJECT_TITLE = "Test suite project:";
	private static final String TEST_SUITE_PROJECT_PATH = "Test suite project path:";

	private static final int TEXT_FIELD_WIDTH = 50;

	public static final String WODEL_TEST_PROJECT_TITLE_PROPERTY = "WODELTEST_PROJECT_TITLE";
	public static final String WODEL_TEST_PROJECT_PATH_PROPERTY = "WODELTEST_PROJECT_PATH";
	public static final String SUT_PROJECT_TITLE_PROPERTY = "SUT_PROJECT_TITLE";
	public static final String SUT_PROJECT_PATH_PROPERTY = "SUT_PROJECT_PATH";
	public static final String SUT_NATURE_PROPERTY = "SUT_NATURE";
	public static final String TEST_SUITE_PROJECT_TITLE_PROPERTY = "TESTSUITE_PROJECT_TITLE";
	public static final String TEST_SUITE_PROJECT_PATH_PROPERTY = "TESTSUITE_PROJECT_PATH";

	public static final String DEFAULT_SUT_NATURE = AtlNature.ATL_NATURE_ID;
	public static final String DEFAULT_SUT_PROJECT = "Families2Persons";
	public static final String DEFAULT_TEST_SUITE_PROJECT = "ATLCheck";
	
	private static final String NATURE_ID = "wodeltest.extension.wodelTestSUTNature";

	private Text sutProjectTitleText;
	private Text sutProjectPathText;
	private Text sutNatureText;
	private Text testSuiteProjectTitleText;
	private Text testSuiteProjectPathText;

	private IProject project;

	/**
	 * Constructor for SamplePropertyPage.
	 */
	public WodelTestPropertiesPage() {
		super();
	}

	public void setProjectTitle(String projectTitle) {
		sutProjectTitleText.setText(projectTitle);
	}
	
	public void setProjectPath(String projectPath) {
		sutProjectPathText.setText(projectPath);
	}

	public void setSuTNature(String sutNature) {
		sutNatureText.setText(sutNature);
	}

	public void setTestSuiteProjectTitle(String testSuiteProjectTitle) {
		testSuiteProjectTitleText.setText(testSuiteProjectTitle);
	}
	
	public void setTestSuiteProjectPath(String testSuiteProjectTitle) {
		testSuiteProjectPathText.setText(testSuiteProjectTitle);
	}

	private void addFirstSection(Composite parent) {
		Composite composite = createDefaultComposite(parent);

		//Label for title field
		Label wodelTestProjectTitleLabel = new Label(composite, SWT.NONE);
		wodelTestProjectTitleLabel.setText(WODEL_TEST_PROJECT_TITLE);
		
		// Path wodel-test project field
		Text wodelTestProjectTitleText = new Text(composite, SWT.WRAP | SWT.READ_ONLY);
				
		//Label for path field
		Label wodelTestProjectPathLabel = new Label(composite, SWT.NONE);
		wodelTestProjectPathLabel.setText(WODEL_TEST_PROJECT_PATH);
		
		// Path wodel-test path field
		Text wodelTestProjectPathText = new Text(composite, SWT.WRAP | SWT.READ_ONLY);

		WodelTest wodelTest = new WodelTest();
		if (wodelTest != null) {
			wodelTestProjectTitleText.setText(wodelTest.getProjectName());
			wodelTestProjectPathText.setText(ModelManager.getWorkspaceAbsolutePath());
		}
	
		if (getElement() instanceof IJavaProject) {
			project = ((IJavaProject) getElement()).getProject();
		}
		if (getElement() instanceof IProject) {
			project = (IProject) getElement();
		}
		if (getElement() instanceof IFile) {
			project = ((IFile) getElement()).getProject();
		}
	}
		
	private void addSeparator(Composite parent) {
		Label separator = new Label(parent, SWT.SEPARATOR | SWT.HORIZONTAL);
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		separator.setLayoutData(gridData);
	}

	private void addSecondSection(Composite parent) {
		if (project == null) {
			return;
		}
		
		Composite composite = createDefaultComposite(parent);
		
		// Label for sut project title field
		Label sutProjectTitleLabel = new Label(composite, SWT.NONE);
		sutProjectTitleLabel.setText(SUT_PROJECT_TITLE);

		// Sut project title field
		sutProjectTitleText = new Text(composite, SWT.WRAP | SWT.READ_ONLY);
		GridData gd = new GridData();
		gd.widthHint = convertWidthInCharsToPixels(TEXT_FIELD_WIDTH);
		sutProjectTitleText.setLayoutData(gd);

		// Label for sut project path field
		Label sutProjectPathLabel = new Label(composite, SWT.NONE);
		sutProjectPathLabel.setText(SUT_PROJECT_PATH);

		// Sut project path field
		sutProjectPathText = new Text(composite, SWT.WRAP | SWT.READ_ONLY);
		gd = new GridData();
		gd.widthHint = convertWidthInCharsToPixels(TEXT_FIELD_WIDTH);
		sutProjectPathText.setLayoutData(gd);

		// Populate sut project text field
		try {
			String sutTitle = 
				((IResource) project).getPersistentProperty(
					new QualifiedName(Platform.getBundle("WodelTest4ATL").getSymbolicName(), SUT_PROJECT_TITLE_PROPERTY));
			String sutPath = 
					((IResource) project).getPersistentProperty(
						new QualifiedName(Platform.getBundle("WodelTest4ATL").getSymbolicName(), SUT_PROJECT_PATH_PROPERTY));
			String sutProjectTitle = null;
			String sutProjectPath = null;
			IProject sutIProject = null;
			if (sutTitle == null || sutPath == null) {
				IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
	            String workspacePath = workspaceRoot.getLocation().toFile().getPath();
	            workspaceRoot.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
	            File workspaceFolder = new File(workspacePath);
	            if (workspaceFolder.listFiles() != null) {
		            for (File workspaceProjectFolder : workspaceFolder.listFiles()) {
		                if (workspaceProjectFolder.isDirectory()) {
		                    IProject workspaceProject = workspaceRoot.getProject(workspaceProjectFolder.getName());
		                    if (workspaceProject.exists() && workspaceProject.isOpen() && workspaceProject.hasNature(JavaCore.NATURE_ID) && workspaceProject.hasNature(NATURE_ID)) {
		                        sutIProject = workspaceProject;
		                        break;
		                    }
		                }
		            }
	            }
				if (sutIProject != null) {
					sutProjectTitle = sutIProject.getName();
					sutProjectPath = sutIProject.getLocation().toFile().getPath().replace("\\", "/");
				}
			}
			else {
				sutProjectTitle = ResourcesPlugin.getWorkspace().getRoot().getProject(sutTitle).getName();
				sutProjectPath = ResourcesPlugin.getWorkspace().getRoot().getProject(sutTitle).getLocation().toFile().getPath().replace("\\", "/");
			}
			sutProjectTitleText.setText((sutProjectTitle != null) ? sutProjectTitle : DEFAULT_SUT_PROJECT);
			sutProjectPathText.setText((sutProjectPath != null) ? sutProjectPath : DEFAULT_SUT_PROJECT);
		} catch (CoreException e) {
			sutProjectTitleText.setText(DEFAULT_SUT_PROJECT);
			sutProjectPathText.setText(DEFAULT_SUT_PROJECT);
		}

		// Label for sut nature field
		Label sutNatureLabel = new Label(composite, SWT.NONE);
		sutNatureLabel.setText(SUT_NATURE_TITLE);

		// SuT nature text field
		sutNatureText = new Text(composite, SWT.WRAP | SWT.READ_ONLY);
		gd = new GridData();
		gd.widthHint = convertWidthInCharsToPixels(TEXT_FIELD_WIDTH);
		sutNatureText.setLayoutData(gd);

		// Populate sut nature text field
		try {
			String sutNature =
				((IResource) project).getPersistentProperty(
					new QualifiedName(Platform.getBundle("WodelTest4ATL").getSymbolicName(), SUT_NATURE_PROPERTY));
			sutNatureText.setText((sutNature != null) ? sutNature : DEFAULT_SUT_NATURE);
		} catch (CoreException e) {
			sutNatureText.setText(DEFAULT_SUT_NATURE);
		}
	}
	
	private void addThirdSection(Composite parent) {
		if (project == null) {
			return;
		}
		Composite composite = createDefaultComposite(parent);

		// Label for test suite project title field
		Label testSuiteProjectLabel = new Label(composite, SWT.NONE);
		testSuiteProjectLabel.setText(TEST_SUITE_PROJECT_TITLE);

		// Test suite project title field
		testSuiteProjectTitleText = new Text(composite, SWT.WRAP | SWT.READ_ONLY);
		GridData gd = new GridData();
		gd.widthHint = convertWidthInCharsToPixels(TEXT_FIELD_WIDTH);
		testSuiteProjectTitleText.setLayoutData(gd);

		// Label for test suite project path field
		Label testSuiteProjectPathLabel = new Label(composite, SWT.NONE);
		testSuiteProjectPathLabel.setText(TEST_SUITE_PROJECT_PATH);

		// Test suite project path field
		testSuiteProjectPathText = new Text(composite, SWT.WRAP | SWT.READ_ONLY);
		gd = new GridData();
		gd.widthHint = convertWidthInCharsToPixels(TEXT_FIELD_WIDTH);
		testSuiteProjectPathText.setLayoutData(gd);

		// Populate sut project text field
		try {
			String testSuiteTitle =
				((IResource) project).getPersistentProperty(
					new QualifiedName(Platform.getBundle("WodelTest4ATL").getSymbolicName(), TEST_SUITE_PROJECT_TITLE_PROPERTY));
			String testSuitePath =
					((IResource) project).getPersistentProperty(
						new QualifiedName(Platform.getBundle("WodelTest4ATL").getSymbolicName(), TEST_SUITE_PROJECT_PATH_PROPERTY));
			String testSuiteProjectTitle = null;
			String testSuiteProjectPath = null;
			IProject testSuiteIProject = null;
			if (testSuiteTitle == null || testSuitePath == null) {
				IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
	            String workspacePath = workspaceRoot.getLocation().toFile().getPath();
	            workspaceRoot.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
	            File workspaceFolder = new File(workspacePath);
	            if (workspaceFolder.listFiles() != null) {
		            for (File workspaceProjectFolder : workspaceFolder.listFiles()) {
		                if (workspaceProjectFolder.isDirectory()) {
		                    IProject workspaceProject = workspaceRoot.getProject(workspaceProjectFolder.getName());
		                    if (workspaceProject.exists() && workspaceProject.isOpen() && workspaceProject.hasNature(JavaCore.NATURE_ID) && !workspaceProject.hasNature(NATURE_ID)) {
		                        testSuiteIProject = workspaceProject;
		                        break;
		                    }
		                }
		            }
	            }
				if (testSuiteIProject != null) {
					testSuiteProjectTitle = testSuiteIProject.getName();
					testSuiteProjectPath = testSuiteIProject.getLocation().toFile().getPath().replace("\\", "/");
				}
			}
			else {
				testSuiteProjectTitle = ResourcesPlugin.getWorkspace().getRoot().getProject(testSuiteTitle).getName();
				testSuiteProjectPath = ResourcesPlugin.getWorkspace().getRoot().getProject(testSuiteTitle).getLocation().toFile().getPath().replace("\\", "/");
			}
			testSuiteProjectTitleText.setText((testSuiteProjectTitle != null) ? testSuiteProjectTitle : DEFAULT_TEST_SUITE_PROJECT);
			testSuiteProjectPathText.setText((testSuiteProjectPath != null) ? testSuiteProjectPath : DEFAULT_TEST_SUITE_PROJECT);
		} catch (CoreException e) {
			testSuiteProjectTitleText.setText(DEFAULT_TEST_SUITE_PROJECT);
			testSuiteProjectPathText.setText(DEFAULT_TEST_SUITE_PROJECT);
		}
	}
	
	/**
	 * @see PreferencePage#createContents(Composite)
	 */
	protected Control createContents(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		composite.setLayout(layout);
		GridData data = new GridData(GridData.FILL);
		data.grabExcessHorizontalSpace = true;
		composite.setLayoutData(data);

		addFirstSection(composite);
		addSeparator(composite);
		addSecondSection(composite);
		addSeparator(composite);
		addThirdSection(composite);
		return composite;
	}

	private Composite createDefaultComposite(Composite parent) {
		Composite composite = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		composite.setLayout(layout);

		GridData data = new GridData();
		data.verticalAlignment = GridData.FILL;
		data.horizontalAlignment = GridData.FILL;
		composite.setLayoutData(data);

		return composite;
	}

	protected void performDefaults() {
		super.performDefaults();
		// Populate the text fields with the default values
		sutProjectTitleText.setText(DEFAULT_SUT_PROJECT);
		sutProjectPathText.setText(DEFAULT_SUT_PROJECT);
		sutNatureText.setText(DEFAULT_SUT_NATURE);
		testSuiteProjectTitleText.setText(DEFAULT_TEST_SUITE_PROJECT);
		testSuiteProjectPathText.setText(DEFAULT_TEST_SUITE_PROJECT);
	}
	
	public boolean performOk() {
		if (project == null) {
			return false;
		}
		// store the values in the text fields
		try {
			((IResource) project).setPersistentProperty(
				new QualifiedName(Platform.getBundle("WodelTest4ATL").getSymbolicName(), SUT_PROJECT_TITLE_PROPERTY),
				sutProjectTitleText.getText());
		} catch (CoreException e) {
			return false;
		}
		try {
			((IResource) project).setPersistentProperty(
				new QualifiedName(Platform.getBundle("WodelTest4ATL").getSymbolicName(), SUT_PROJECT_PATH_PROPERTY),
				sutProjectPathText.getText());
		} catch (CoreException e) {
			return false;
		}
		try {
			((IResource) project).setPersistentProperty(
				new QualifiedName(Platform.getBundle("WodelTest4ATL").getSymbolicName(), SUT_NATURE_PROPERTY),
				sutNatureText.getText());
		} catch (CoreException e) {
			return false;
		}
		try {
			((IResource) project).setPersistentProperty(
				new QualifiedName(Platform.getBundle("WodelTest4ATL").getSymbolicName(), TEST_SUITE_PROJECT_TITLE_PROPERTY),
				testSuiteProjectTitleText.getText());
		} catch (CoreException e) {
			return false;
		}
		try {
			((IResource) project).setPersistentProperty(
				new QualifiedName(Platform.getBundle("WodelTest4ATL").getSymbolicName(), TEST_SUITE_PROJECT_PATH_PROPERTY),
				testSuiteProjectPathText.getText());
		} catch (CoreException e) {
			return false;
		}
		return true;
	}
}
