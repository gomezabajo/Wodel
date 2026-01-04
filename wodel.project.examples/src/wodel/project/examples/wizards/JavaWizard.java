package wodel.project.examples.wizards;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

import com.google.common.io.CharStreams;

import wodel.utils.manager.IOUtils;
import wodel.utils.manager.ProjectUtils;
import wodel.project.examples.utils.EclipseHelper;
import wodel.dsls.WodelUtils;

/**
 * @author Pablo Gomez-Abajo - Wodel new Java example project Wizard.
 * 
 * Wodel new Java example project Wizard.
 *  
 */

public class JavaWizard extends Wizard implements INewWizard {

	private ISelection selection;

	public JavaWizardPage _pageOne;

	private static final String WIZARD_NAME = "Java Language Example";

	public JavaWizard() {
		// TODO Auto-generated constructor stub
		super();
		setWindowTitle(WIZARD_NAME);
		setNeedsProgressMonitor(true);
	}
	
	public void addPages() {
		super.addPages();
		_pageOne = new JavaWizardPage(selection);
		_pageOne.setTitle("Wodel Java Language Example");
		_pageOne.setDescription("Create a Wodel Java Language Example");
		addPage(_pageOne);
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// TODO Auto-generated method stub
		this.selection = selection;

	}

	/**
	 * This method is called when 'Finish' button is pressed in the wizard. We
	 * will create an operation and run it using wizard as execution context.
	 */
	@Override
	public boolean performFinish() {
		final String fileName = _pageOne.getFileName();
		final String projectName = _pageOne.getProjectName();
		final String modelName = _pageOne.getModelName();
		final String mutantName = _pageOne.getMutantName();
		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor)
					throws InvocationTargetException {
				try {
					doFinish(fileName, projectName, modelName, mutantName, monitor);
				} catch (CoreException e) {
					throw new InvocationTargetException(e);
				} finally {
					monitor.done();
				}
			}
		};
		try {
			getContainer().run(true, false, op);
		} catch (InterruptedException e) {
			return false;
		} catch (InvocationTargetException e) {
			Throwable realException = e.getTargetException();
			MessageDialog.openError(getShell(), "Error",
					realException.getMessage());
			return false;
		}
		return true;
	}

	/**
	 * The worker method. It will find the container, create the file if missing
	 * or just replace its contents, and open the editor on the newly created
	 * file.
	 */

	private void doFinish(String fileName, String projectName,
			String modelName, String mutantName, IProgressMonitor monitor) throws CoreException {

		List<String> folders = new ArrayList<String>();
		folders.add("src");
		folders.add("src-gen");

		Set<IProject> referencedProjects = new LinkedHashSet<IProject>();
		Set<String> requiredBundles = new LinkedHashSet<String>();
		Set<String> importPackages = new LinkedHashSet<String>();
		Set<String> exportedPackages = new LinkedHashSet<String>();
		Set<String> bundleClasspath = new LinkedHashSet<String>();

		requiredBundles.add("wodel.utils");
		requiredBundles.add("wodel.models");
		requiredBundles.add("org.eclipse.emf.ecore.xmi");
		requiredBundles.add("org.eclipse.emf.ecore");
		requiredBundles.add("org.eclipse.emf.compare");
		requiredBundles.add("com.google.guava");
		requiredBundles.add("org.apache.log4j");
		requiredBundles.add("org.eclipse.ocl");
		requiredBundles.add("org.eclipse.ocl.ecore");
		requiredBundles.add("org.eclipse.emf.common");
		requiredBundles.add("org.eclipse.core.runtime");
		requiredBundles.add("org.eclipse.core.resources");
		requiredBundles.add("org.eclipse.text");
		requiredBundles.add("org.eclipse.ui");
		requiredBundles.add("org.eclipse.e4.ui.workbench");
		requiredBundles.add("org.eclipse.e4.ui.model.workbench");
		requiredBundles.add("org.eclipse.e4.core.di");
		
		bundleClasspath.add(".");
		bundleClasspath.add("lib/use.jar");
		bundleClasspath.add("lib/use-runtime.jar");
		bundleClasspath.add("lib/use-gui.jar");
		bundleClasspath.add("lib/antlr-3.4-complete.jar");
		bundleClasspath.add("lib/combinatoricslib-0.2.jar");
		bundleClasspath.add("lib/gsbase.jar");
		bundleClasspath.add("lib/guava-20.0.jar");
		bundleClasspath.add("lib/itextpdf-5.5.2.jar");
		bundleClasspath.add("lib/jruby-1.7.2.jar");
		bundleClasspath.add("lib/junit.jar");
		bundleClasspath.add("lib/vtd-xml.jar");
		bundleClasspath.add("lib/ModelValidatorPlugin-5.2.0-r1.jar");

		IProject project = EclipseHelper.createWodelProject(projectName,
				folders, referencedProjects, requiredBundles, importPackages,
				exportedPackages, bundleClasspath, monitor, this.getShell());
		
		ProjectUtils.setProject(project);

		monitor.beginTask("Creating data folder", 9);
		final IFolder dataFolder = project.getFolder(new Path("data"));
		dataFolder.create(true, true, monitor);
		
		monitor.beginTask("Creating config folder", 8);
		final IFolder configFolder = dataFolder.getFolder(new Path("config"));
		configFolder.create(true, true, monitor);

		final IFile config = configFolder.getFile(new Path("config.txt"));
		try {
			InputStream stream = openConfigStream(modelName, mutantName);
			if (config.exists()) {
				config.setContents(stream, true, true, monitor);
			} else {
				config.create(stream, true, monitor);
			}
			stream.close();
		} catch (IOException e) {
		}
		
		monitor.beginTask("Creating model folder", 8);
		final IFolder modelFolder = project.getFolder(new Path(modelName));
		modelFolder.create(true, true, monitor);
		String srcMetamodel = "";
		try {
			final File jarFile = new File(JavaWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath());
			String srcName = "";
			if (jarFile.isFile()) {
				final JarFile jar = new JarFile(jarFile);
				final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
				while(entries.hasMoreElements()) {
					JarEntry entry = entries.nextElement();
					if (! entry.isDirectory()) {
						if (entry.getName().startsWith("models/java")) {
							final File f = modelFolder.getRawLocation().makeAbsolute().toFile();
							File path = new File(f.getPath() + '/' + entry.getName().replace("models/java", "").split("/")[0]);
							if (!path.exists()) {
								path.mkdir();
							}
							File dest = new File(f.getPath() + '/' + entry.getName().replace("models/java", ""));
							if (entry.getName().endsWith(".ecore")) {
								srcMetamodel = dest.getPath();
							}
							InputStream input = jar.getInputStream(entry);
							FileOutputStream output = new FileOutputStream(dest);
							while (input.available() > 0) {
								output.write(input.read());
							}
							output.close();
							input.close();
						}
					}
				}
				jar.close();
			}
			else {
				srcName = JavaWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "models/java";
				final File src = new Path(srcName).toFile();
				final File dest = modelFolder.getRawLocation().makeAbsolute().toFile();
				if ((src != null) && (dest != null)) {
					IOUtils.copyFolder(src, dest);
				}
				for (File f: src.listFiles()) {
					if (f.getName().endsWith(".ecore")) {
						srcMetamodel = f.getPath();
						break;
					}
				}
			}
		} catch (IOException e) {
		}

		String metamodel = srcMetamodel.substring(srcMetamodel.lastIndexOf(File.separator) + 1);
		final IFile metamodelFile = modelFolder.getFile(new Path(metamodel));
		try {
			FileReader fr = new FileReader(metamodel);
			BufferedReader br = new BufferedReader(fr);
			
			String line = null;
			String def = "";
			while ((line = br.readLine()) != null) {
				def += line + "\n";
			}
			br.close();
			InputStream stream = openContentStream();
			String content = CharStreams.toString(new InputStreamReader(stream, StandardCharsets.UTF_8));
			content += def;
			stream = new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8));
			metamodelFile.create(stream, true, monitor);
			stream.close();
		} catch (IOException e) {
		}

		monitor.beginTask("Creating mutant folder", 8);
		final IFolder mutantFolder = project.getFolder(new Path(mutantName));
		mutantFolder.create(true, true, monitor);
		// create a sample file
		monitor.beginTask("Creating " + fileName, 7);

		final IFolder srcFolder = project.getFolder(new Path("src"));

		final IFile file = srcFolder.getFile(new Path(fileName));
		try {
			InputStream stream = openContentStream();
			String def = "generate exhaustive mutants\n"
					+ "in \"" + mutantName + "/\"\n"
					+ "from \"" + modelName + "/\"\n";
			def += "metamodel \"/" + projectName + "/" + modelName + "/" + metamodel + "\"\n\n";
			def += "with blocks {\n";
			def += "\taorbp \"Addition\" {\n";
			def += "\t\tmodify one InfixExpression where {operator in ['-', '*', '/', '%'] and leftOperand <> null and rightOperand <> null}\n";
			def += "\t\twith {operator = '+'}\n";
			def += "\t}\n";
			def += "\taorbm \"Subtraction\" {\n";
			def += "\t\tmodify one InfixExpression where {operator in ['+', '*', '/', '%'] and leftOperand <> null and rightOperand <> null\n";
			def += "\t\t\tand leftOperand not typed StringLiteral and rightOperand not typed StringLiteral}\n";
			def += "\t\twith {operator = '-'}\n";
			def += "\t}\n";
			def += "\taorbt \"Times\" {\n";
			def += "\t\tmodify one InfixExpression where {operator in ['+', '-', '/', '%'] and leftOperand <> null and rightOperand <> null\n";
			def += "\t\t\tand leftOperand not typed StringLiteral and rightOperand not typed StringLiteral}\n";
			def += "\t\twith {operator = '*'}\n";
			def += "\t}\n";
			def += "\taorbd \"Division\" {\n";
			def += "\t\tmodify one InfixExpression where {operator in ['+', '-', '*', '%'] and leftOperand <> null and rightOperand <> null\n";
			def += "\t\t\tand leftOperand not typed StringLiteral and rightOperand not typed StringLiteral}\n";
			def += "\t\twith {operator = '/'}\n";
			def += "\t}\n";
			def += "\taorbr \"Modulus\" {\n";
			def += "\t\tmodify one InfixExpression where {operator in ['+', '-', '*', '/'] and leftOperand <> null and rightOperand <> null\n";
			def += "\t\t\tand leftOperand not typed StringLiteral and rightOperand not typed StringLiteral}\n";
			def += "\t\twith {operator = '%'}\n";
			def += "\t}\n";
			def += "\taorsi \"Postfix increment by decrement\" {\n";
			def += "\t\tmodify one PostfixExpression where {operator = '++' and operand <> null}\n";
			def += "\t\twith {operator = '--'}\n";
			def += "\t}\n";
			def += "\taorsd \"Postfix decrement by increment\" {\n";
			def += "\t\tmodify one PostfixExpression where {operator = '--' and operand <> null}\n";
			def += "\t\twith {operator = '++'}\n";
			def += "\t}\n";
			def += "\taorspi \"Prefix increment by decrement\" {\n";
			def += "\t\tmodify one PrefixExpression where {operator = '++' and operand <> null}\n";
			def += "\t\twith {operator = '--'}\n";
			def += "\t}\n";
			def += "\taorspd \"Prefix decrement by increment\" {\n";
			def += "\t\tmodify one PrefixExpression where {operator = '--' and operand <> null}\n";
			def += "\t\twith {operator = '++'}\n";
			def += "\t}\n";
			def += "\taoium \"Positive to negative\" {\n";
			def += "\t\tmodify one PrefixExpression where {operator = '+' and operand <> null}\n";
			def += "\t\twith {operator = '-'} \n";
			def += "\t}\n";
			def += "\taoiup \"Negative to positive\" {\n";
			def += "\t\tmodify one PrefixExpression where {operator = '-' and operand <> null}\n";
			def += "\t\twith {operator = '+'}\n";
			def += "\t}\n";
			def += "\taoisd \"Positive or negative to prefix decrement\" {\n";
			def += "\t\tmodify one PrefixExpression where {operator in ['+', '-'] and operand <> null and operand not typed NumberLiteral}\n";
			def += "\t\twith {operator = '--'}\n";
			def += "\t}\n";
			def += "\taoisi \"Positive or negative to prefix increment\" {\n";
			def += "\t\tmodify one PrefixExpression where {operator in ['+', '-'] and operand <> null and operand not typed NumberLiteral}\n";
			def += "\t\twith {operator = '++'}\n";
			def += "\t}\n";
			def += "\taods \"Prefix increment or decrement deletion\" {\n";
			def += "\t\tmodify one PrefixExpression where {operator in ['++', '--'] and operand <> null}\n";
			def += "\t\twith {operator = '+'}\n";
			def += "\t}\n";
			def += "\tapmrt \"Argument propagation\" {\n";
			def += "\t\tstmt = select one ReturnStatement where {expression is typed MethodInvocation}\n";
			def += "\t\tmethod = select one MethodInvocation in stmt->expression\n";
			def += "\t\tparam = select one SingleVariableAccess in method->arguments\n";
			def += "\t\tmodify stmt with {expression = param}\n";
			def += "\t}\n";
			def += "\tapmir \"Argument propagation InfixExpression rightOperand\" {\n";
			def += "\t\texp0 = select one InfixExpression where {rightOperand is typed MethodInvocation}\n";
			def += "\t\tmethod = select one MethodInvocation in exp0->rightOperand\n";
			def += "\t\tparam = select one SingleVariableAccess in method->arguments\n";
			def += "\t\tmodify exp0 with {rightOperand = param}\n";
			def += "\t}\n";
			def += "\tapmil \"Argument propagation InfixExpression leftOperand\" {\n";
			def += "\t\texp1 = select one InfixExpression where {leftOperand is typed MethodInvocation}\n";
			def += "\t\tmethod = select one MethodInvocation in exp1->leftOperand\n";
			def += "\t\tparam = select one SingleVariableAccess in method->arguments\n";
			def += "\t\tmodify exp1 with {leftOperand = param}\n";
			def += "\t}\n";
			def += "\tapmas \"Argument propagation Assignment\" {\n";
			def += "\t\ta = select one Assignment where {rightHandSide is typed MethodInvocation}\n";
			def += "\t\tmethod = select one MethodInvocation in a->rightHandSide\n";
			def += "\t\tparam = select one SingleVariableAccess in method->arguments\n";
			def += "\t\tmodify a with {rightHandSide = param}\n";
			def += "\t}\n";
			def += "\tasrsp \"Addition assignment\" {\n";
			def += "\t\tmodify one Assignment where {operator in ['-=', '*=', '/=', '%=']\n";
			def += "\t\t\tand leftHandSide <> null and rightHandSide <> null\n";
			def += "\t\t}\n";
			def += "\t\twith {operator = '+='}\n";
			def += "\t}\n";
			def += "\tasrsm \"Subtraction assignment\" {\n";
			def += "\t\tmodify one Assignment where {operator in ['+=', '*=', '/=', '%=']\n";
			def += "\t\t\tand leftHandSide <> null and rightHandSide <> null\n";
			def += "\t\t}\n";
			def += "\t\twith {operator = '-='}\n";
			def += "\t}\n";
			def += "\tasrst \"Times assignment\" {\n";
			def += "\t\tmodify one Assignment where {operator in ['+=', '-=', '/=', '%=']\n";
			def += "\t\t\tand leftHandSide <> null and rightHandSide <> null\n";
			def += "\t\t}\n";
			def += "\t\twith {operator = '*='}\n";
			def += "\t}\n";
			def += "\tasrsd \"Division assignment\" {\n";
			def += "\t\tmodify one Assignment where {operator in ['+=', '-=', '*=', '%=']\n";
			def += "\t\t\tand leftHandSide <> null and rightHandSide <> null\n";
			def += "\t\t}\n";
			def += "\t\twith {operator = '/='}\n";
			def += "\t}\n";
			def += "\tasrsr \"Modulus assignment\" {\n";
			def += "\t\tmodify one Assignment where {operator in ['+=', '-=', '*=', '/=']\n";
			def += "\t\t\tand leftHandSide <> null and rightHandSide <> null\n";
			def += "\t\t}\n";
			def += "\t\twith {operator = '%='}\n";
			def += "\t}\n";
			def += "\tasrsa \"And assignment\" {\n";
			def += "\t\tmodify one Assignment where {operator in ['|=', '^=']\n";
			def += "\t\t\tand leftHandSide <> null and rightHandSide <> null\n";
			def += "\t\t}\n";
			def += "\t\twith {operator = '&='}\n";
			def += "\t}\n";
			def += "\tasrso \"Or assignment\" {\n";
			def += "\t\tmodify one Assignment where {operator in ['&=', '^=']\n";
			def += "\t\t\tand leftHandSide <> null and rightHandSide <> null\n";
			def += "\t\t}\n";
			def += "\t\twith {operator = '|='}\n";
			def += "\t}\n";
			def += "\tasrsx \"Xor assignment\" {\n";
			def += "\t\tmodify one Assignment where {operator in ['&=', '|=']\n";
			def += "\t\t\tand leftHandSide <> null and rightHandSide <> null\n";
			def += "\t\t}\n";
			def += "\t\twith {operator = '^='}\n";
			def += "\t}\n";
			def += "\tasrssr \"Right shift assignment\" {\n";
			def += "\t\tmodify one Assignment where {operator in ['>>>=', '<<=']\n";
			def += "\t\t\tand leftHandSide <> null and rightHandSide <> null\n";
			def += "\t\t}\n";
			def += "\t\twith {operator = '>>='}\n";
			def += "\t}\n";
			def += "\tasrssrr \"Unsigned right shift assignment\" {\n";
			def += "\t\tmodify one Assignment where {operator in ['>>=', '<<=']\n";
			def += "\t\t\tand leftHandSide <> null and rightHandSide <> null\n";
			def += "\t\t}\n";
			def += "\t\twith {operator = '>>>='}\n";
			def += "\t}\n";
			def += "\tasrssl \"Left shift assignment\" {\n";
			def += "\t\tmodify one Assignment where {operator in ['>>=', '>>>=']\n";
			def += "\t\t\tand leftHandSide <> null and rightHandSide <> null\n";
			def += "\t\t}\n";
			def += "\t\twith {operator = '<<='}\n";
			def += "\t}\n";
			def += "\tcora \"And\" {\n";
			def += "\t\tmodify one InfixExpression where {operator in ['||', '^'] and leftOperand <> null and rightOperand <> null}\n";
			def += "\t\twith {operator = '&&'}\n";
			def += "\t}\n";
			def += "\tcoro \"Or\" {\n";
			def += "\t\tmodify one InfixExpression where {operator in ['&&', '^'] and leftOperand <> null and rightOperand <> null}\n";
			def += "\t\twith {operator = '||'}\n";
			def += "\t}\n";
			def += "\tcorx \"Xor\" {\n";
			def += "\t\tmodify one InfixExpression where {operator in ['&&', '||'] and leftOperand <> null and rightOperand <> null}\n";
			def += "\t\twith {operator = '^'}\n";
			def += "\t}\n";
			def += "\tcn1 \"Conditional Negation\" {\n";
			def += "\t\tifstmt = select one IfStatement\n";
			def += "\t\texp1 = select one InfixExpression in ifstmt->expression\n";
			def += "\t\tneg = create PrefixExpression in ifstmt->expression with {operator = '!'}\n";
			def += "\t\tpar = create ParenthesizedExpression in neg->operand with {expression = exp1}\n";
			def += "\t}\n";
			def += "\tcn2 \"Conditional Negation\" {\n";
			def += "\t\trtstmt = select one ReturnStatement\n";
			def += "\t\texp1 = select one InfixExpression in rtstmt->expression\n";
			def += "\t\tneg = create PrefixExpression in rtstmt->expression with {operator = '!'}\n";
			def += "\t\tpar = create ParenthesizedExpression in neg->operand with {expression = exp1}\n";
			def += "\t}\n";
			def += "\tcn3 \"Conditional Negation\" {\n";
			def += "\t\texp0 = select one InfixExpression\n";
			def += "\t\texp1 = select one InfixExpression in exp0->leftOperand\n";
			def += "\t\tneg = create PrefixExpression in exp0->leftOperand with {operator = '!'}\n";
			def += "\t\tpar = create ParenthesizedExpression in neg->operand with {expression = exp1}\n";
			def += "\t}\n";
			def += "\tcn4 \"Conditional Negation\" {\n";
			def += "\t\texp0 = select one InfixExpression\n";
			def += "\t\texp1 = select one InfixExpression in exp0->rightOperand\n";
			def += "\t\tneg = create PrefixExpression in exp0->rightOperand with {operator = '!'}\n";
			def += "\t\tpar = create ParenthesizedExpression in neg->operand with {expression = exp1}\n";
			def += "\t}\n";
			def += "\trc \"Removes a conditional statement\" {\n";
			def += "\t\tmain = select one Block where {statements is typed IfStatement}\n";
			def += "\t\tif0 = select one IfStatement in main->statements\n";
			def += "\t\tb2 = select one Block in if0->thenStatement\n";
			def += "\t\tmodify main with {statements += b2}\n";
			def += "\t\tremove if0\n";
			def += "\t}\n";
			def += "\tbt \"Changes the boolean value to true\" {\n";
			def += "\t\tmodify one BooleanLiteral where {value = false} with {value = true}\n";
			def += "\t}\n";
			def += "\tbf \"Changes the boolean value to false\" {\n";
			def += "\t\tmodify one BooleanLiteral where {value = true} with {value = false}\n";
			def += "\t}\n";
			def += "\trnl \"Replaces a NumberLiteral by 1\" {\n";
			def += "\t\tmodify one NumberLiteral where {tokenValue <> '1'} with {tokenValue = '1'}\n";
			def += "\t}\n";
			def += "\tnrst \"Null ReturnStatment\" {\n";
			def += "\t\trtstmt = select one ReturnStatement\n";
			def += "\t\tcreate NullLiteral in rtstmt->expression\n";
			def += "\t}\n";
			def += "\trn0 \"Replaces a NumberLiteral value with 0\" {\n";
			def += "\t\tmodify one NumberLiteral where {tokenValue <> '0'} with {tokenValue = '0'}\n";
			def += "\t}\n";
			def += "\trnn0 \"Replaces a NumberLiteral value with -1\" {\n";
			def += "\t\texp = select one InfixExpression where {leftOperand is typed NumberLiteral}\n";
			def += "\t\tmodify exp with {leftOperand.tokenValue = '1'}\n";
			def += "\t\tp = create PrefixExpression with {operator = '-', operand = exp->leftOperand}\n";
			def += "\t\tmodify exp with {leftOperand = p}\n";
			def += "\t}\n";
			def += "\trnn1 \"Replaces a NumberLiteral value with -1\" {\n";
			def += "\t\texp = select one InfixExpression where {rightOperand is typed NumberLiteral}\n";
			def += "\t\tmodify exp with {rightOperand.tokenValue = '1'}\n";
			def += "\t\tp = create PrefixExpression with {operator = '-', operand = exp->rightOperand}\n";
			def += "\t\tmodify exp with {rightOperand = p}\n";
			def += "\t\t\n";
			def += "\t}\n";
			def += "\trnn2 \"Replaces a NumberLiteral value with -1\" {\n";
			def += "\t\trt = select one ReturnStatement where {expression is typed NumberLiteral}\n";
			def += "\t\tmodify rt with {expression.tokenValue = '1'}\n";
			def += "\t\tp = create PrefixExpression with {operator = '-', operand = rt->expression}\n";
			def += "\t\tmodify rt with {expression = p}\n";
			def += "\t\t\n";
			def += "\t}\n";
			def += "\trnn3 \"Replaces a NumberLiteral value with -1\" {\n";
			def += "\t\ta = select one Assignment where {rightHandSide is typed NumberLiteral}\n";
			def += "\t\tmodify a with {rightHandSide.tokenValue = '1'}\n";
			def += "\t\tp = create PrefixExpression with {operator = '-', operand = a->rightHandSide}\n";
			def += "\t\tmodify a with {rightHandSide = p}\n";
			def += "\t}\n";
			def += "\trsl \"Replaces a StringLiteral return value with ''\" {\n";
			def += "\t\tmodify one StringLiteral where {escapedValue <> ''} with {escapedValue = ''}\n";
			def += "\t}\n";
			def += "\tinr \"Adds 1 to a NumberLiteral\" {\n";
			def += "\t\texp0 = select one InfixExpression where {rightOperand is typed NumberLiteral}\n";
			def += "\t\tn1 = select one NumberLiteral in exp0->rightOperand\n";
			def += "\t\tinc = deep clone n1 with {tokenValue = '1'}\n";
			def += "\t\tcreate InfixExpression in exp0->rightOperand with {leftOperand = n1, operator = '+', rightOperand = inc}\n";
			def += "\t}\n";
			def += "\tinl \"Adds 1 to a NumberLiteral\" {\n";
			def += "\t\texp0 = select one InfixExpression where {leftOperand is typed NumberLiteral}\n";
			def += "\t\tn1 = select one NumberLiteral in exp0->leftOperand\n";
			def += "\t\tinc = deep clone n1 with {tokenValue = '1'}\n";
			def += "\t\tcreate InfixExpression in exp0->leftOperand with {leftOperand = n1, operator = '+', rightOperand = inc}\n";
			def += "\t}\n";
			def += "\tinst \"Adds 1 to a NumberLiteral\" {\n";
			def += "\t\texp0 = select one ReturnStatement where {expression is typed NumberLiteral}\n";
			def += "\t\tn1 = select one NumberLiteral in exp0->expression\n";
			def += "\t\tinc = deep clone n1 with {tokenValue = '1'}\n";
			def += "\t\tcreate InfixExpression in exp0->expression with {leftOperand = n1, operator = '+', rightOperand = inc}\n";
			def += "\t}\n";
			def += "\tina \"Adds 1 to a NumberLiteral\" {\n";
			def += "\t\texp0 = select one Assignment where {rightHandSide is typed NumberLiteral}\n";
			def += "\t\tn1 = select one NumberLiteral in exp0->rightHandSide\n";
			def += "\t\tinc = deep clone n1 with {tokenValue = '1'}\n";
			def += "\t\tcreate InfixExpression in exp0->rightHandSide with {leftOperand = n1, operator = '+', rightOperand = inc}\n";
			def += "\t}\n";
			def += "\tlora \"And\" {\n";
			def += "\t\tmodify one InfixExpression where {operator in ['|', '^'] and leftOperand <> null and rightOperand <> null}\n";
			def += "\t\twith {operator = '&'}\n";
			def += "\t}\n";
			def += "\tloro \"Or\" {\n";
			def += "\t\tmodify one InfixExpression where {operator in ['&', '^'] and leftOperand <> null and rightOperand <> null}\n";
			def += "\t\twith {operator = '|'}\n";
			def += "\t}\n";
			def += "\tlorx \"Xor\" {\n";
			def += "\t\tmodify one InfixExpression where {operator in ['&', '|'] and leftOperand <> null and rightOperand <> null}\n";
			def += "\t\twith {operator = '^'}\n";
			def += "\t}\n";
			def += "\tdnl \"Subtract 1 to a NumberLiteral leftOperand InfixExpression\" {\n";
			def += "\t\texp2 = select one InfixExpression where {leftOperand is typed NumberLiteral}\n";
			def += "\t\tn3 = select one NumberLiteral in exp2->leftOperand\n";
			def += "\t\tdec = deep clone n3 with {tokenValue = '1'}\n";
			def += "\t\tcreate InfixExpression in exp2->leftOperand with {leftOperand = n3, operator = '-', rightOperand = dec}\n";
			def += "\t}\t\n";
			def += "\tdnr \"Subtract 1 to a NumberLiteral rightOperand InfixExpression\" {\n";
			def += "\t\texp2 = select one InfixExpression where {rightOperand is typed NumberLiteral}\n";
			def += "\t\tn3 = select one NumberLiteral in exp2->rightOperand\n";
			def += "\t\tdec = deep clone n3 with {tokenValue = '1'}\n";
			def += "\t\tcreate InfixExpression in exp2->rightOperand with {leftOperand = n3, operator = '-', rightOperand = dec}\n";
			def += "\t}\t\n";
			def += "\tdnrst \"Subtract 1 to a NumberLiteral ReturnStatement\" {\n";
			def += "\t\texp2 = select one ReturnStatement where {expression is typed NumberLiteral}\n";
			def += "\t\tn3 = select one NumberLiteral in exp2->expression\n";
			def += "\t\tdec = deep clone n3 with {tokenValue = '1'}\n";
			def += "\t\tcreate InfixExpression in exp2->expression with {leftOperand = n3, operator = '-', rightOperand = dec}\n";
			def += "\t}\t\n";
			def += "\tdna \"Subtract 1 to a NumberLiteral Assignment\" {\n";
			def += "\t\texp2 = select one Assignment where {rightHandSide is typed NumberLiteral}\n";
			def += "\t\tn3 = select one NumberLiteral in exp2->rightHandSide\n";
			def += "\t\tdec = deep clone n3 with {tokenValue = '1'}\n";
			def += "\t\tcreate InfixExpression in exp2->rightHandSide with {leftOperand = n3, operator = '-', rightOperand = dec}\n";
			def += "\t}\t\n";
			def += "\trtr \"Transforms a NumberLiteral to a random number\" {\n";
			def += "\t\tmodify one NumberLiteral with {tokenValue = random-int-string(0, 9)}\n";
			def += "\t}\n";
			def += "\tvmr \"Deletes a call to a void method\" {\n";
			def += "\t\tremove one MethodInvocation\n";
			def += "\t\t\twhere {method->returnType->type is typed PrimitiveTypeVoid}\n";
			def += "\t}\n";
			def += "\tnvmr \"Deletes a call to a non-void method\" {\n";
			def += "\t\tremove one MethodInvocation\n";
			def += "\t\t\twhere {method->returnType->type not typed PrimitiveTypeVoid}\n";
			def += "\t}\n";
			def += "\tcir \"Replaces a call to a constructor by null\" {\n";
			def += "\t\ta = select one Assignment where {rightHandSide is typed ClassInstanceCreation}\n";
			def += "\t\tcreate NullLiteral in a->rightHandSide\n";
			def += "\t}\n";
			def += "\tvra \"Replace an assignment to a variable by the Java default values\" {\n";
			def += "\t\tremove one Assignment where {rightHandSide is typed NumberLiteral}\n";
			def += "\t}\n";
			def += "\trst \"Removes one Statement\" {\n";
			def += "\t\tremove one Statement where {self not typed VariableDeclarationStatement}\n";
			def += "\t}\n";
			def += "\trorgt \"Greater than\"{\n";
			def += "\t\tmodify one InfixExpression where {operator in ['>=', '<', '<=', '==', '!='] and leftOperand <> null and rightOperand <> null}\n";
			def += "\t\twith {operator = '>'}\n";
			def += "\t}\n";
			def += "\trorget \"Greater or equals\" {\n";
			def += "\t\tmodify one InfixExpression where {operator in ['>', '<', '<=', '==', '!='] and leftOperand <> null and rightOperand <> null}\n";
			def += "\t\twith {operator = '>='}\n";
			def += "\t}\n";
			def += "\trorlt \"Lower than\" {\n";
			def += "\t\tmodify one InfixExpression where {operator in ['>', '>=', '<=', '==', '!='] and leftOperand <> null and rightOperand <> null}\n";
			def += "\t\twith {operator = '<'}\n";
			def += "\t}\n";
			def += "\trorlet \"Lower or equals\" {\n";
			def += "\t\tmodify one InfixExpression where {operator in ['>', '>=', '<', '==', '!='] and leftOperand <> null and rightOperand <> null}\n";
			def += "\t\twith {operator = '<='}\n";
			def += "\t}\n";
			def += "\trore \"Equals\" {\n";
			def += "\t\tmodify one InfixExpression where {operator in ['>', '>=', '<', '<=', '!='] and leftOperand <> null and rightOperand <> null}\n";
			def += "\t\twith {operator = '=='}\n";
			def += "\t}\n";
			def += "\trord \"Distinct\" {\n";
			def += "\t\tmodify one InfixExpression where {operator in ['>', '>=', '<', '<=', '=='] and leftOperand <> null and rightOperand <> null}\n";
			def += "\t\twith {operator = '!='}\n";
			def += "\t}\n";
			def += "\tsor \"Right shift\" {\n";
			def += "\t\tmodify one InfixExpression where {operator in ['>>>', '<<'] and leftOperand <> null and rightOperand <> null}\n";
			def += "\t\twith {operator = '>>'}\n";
			def += "\t}\n";
			def += "\tsorr \"Unsigned right shift\" {\n";
			def += "\t\tmodify one InfixExpression where {operator in ['>>', '<<'] and leftOperand <> null and rightOperand <> null}\n";
			def += "\t\twith {operator = '>>>'}\n";
			def += "\t}\n";
			def += "\tsol \"Left shift\" {\n";
			def += "\t\tmodify one InfixExpression where {operator in ['>>', '>>>'] and leftOperand <> null and rightOperand <> null}\n";
			def += "\t\twith {operator = '<<'}\n";
			def += "\t}\n";
			def += "\tcod1 \"Removes a unary conditional operator\" {\n";
			def += "\t\tif1 = select one IfStatement where {expression is typed PrefixExpression}\n";
			def += "\t\tpre = select one PrefixExpression in if1->expression where {operator = '!'}\n";
			def += "\t\texp2 = select one Expression in pre->operand\n";
			def += "\t\tmodify if1 with {expression = exp2}\n";
			def += "\t}\n";
			def += "\tcod2 \"Removes a unary conditional operator\" {\n";
			def += "\t\trt1 = select one ReturnStatement where {expression is typed PrefixExpression}\n";
			def += "\t\tpre = select one PrefixExpression in rt1->expression where {operator = '!'}\n";
			def += "\t\texp2 = select one Expression in pre->operand\n";
			def += "\t\tmodify rt1 with {expression = exp2}\n";
			def += "\t}\n";
			def += "\n";
			def += "\tcod3 \"Removes a unary conditional operator\" {\n";
			def += "\t\tinf = select one InfixExpression where {rightOperand is typed PrefixExpression}\n";
			def += "\t\tpre = select one PrefixExpression in inf->rightOperand where {operator = '!'}\n";
			def += "\t\texp2 = select one Expression in pre->operand\n";
			def += "\t\tmodify inf with {rightOperand = exp2}\n";
			def += "\t}\n";
			def += "\n";
			def += "\tcod4 \"Removes a unary conditional operator\" {\n";
			def += "\t\tinf = select one InfixExpression where {leftOperand is typed PrefixExpression}\n";
			def += "\t\tpre = select one PrefixExpression in inf->leftOperand where {operator = '!'}\n";
			def += "\t\texp2 = select one Expression in pre->operand\n";
			def += "\t\tmodify inf with {leftOperand = exp2}\n";
			def += "\t}\n";
			def += "}";
			if (file.exists()) {
				String content = CharStreams.toString(new InputStreamReader(stream, StandardCharsets.UTF_8));
				content += def;
				stream = new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8));
				file.setContents(stream, true, true, monitor);
			} else {
				stream = new ByteArrayInputStream(def.getBytes(StandardCharsets.UTF_8));
				file.create(stream, true, monitor);
			}
			stream.close();
		} catch (IOException e) {
		}
			
		String xTextFileName = "file:/" + project.getLocation().toFile().getPath() + "/src/" + fileName;
		String xmiFileName = "file:/" + project.getLocation().toFile().getPath() + "/" + mutantName + '/' + fileName.replaceAll("mutator", "model");
		WodelUtils.serialize(xTextFileName, xmiFileName);

		try {
			
			final IFolder libFolder = project.getFolder(new Path("lib"));
			if (!libFolder.exists()) {
				libFolder.create(true, true, monitor);
			}

			//Bundle bundle = Platform.getBundle("wodel.wodeledu");
			//URL fileURL = bundle.getEntry("content");
			File jarFile = new File(JavaWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath());
			String srcName = "";
			if (jarFile.isFile()) {
				final JarFile jar = new JarFile(jarFile);
				final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
			    while(entries.hasMoreElements()) {
			    	JarEntry entry = entries.nextElement();
					if (! entry.isDirectory()) {
						if (entry.getName().startsWith("lib/")) {
							final String name = entry.getName();
							final File f = libFolder.getRawLocation().makeAbsolute().toFile();
							File dest = new File(f.getPath() + '/' + entry.getName().substring("lib".length(), entry.getName().length()).split("/")[1]);
							InputStream input = jar.getInputStream(entry);
							final IFile output = libFolder.getFile(new Path(dest.getName()
									.substring(dest.getName().lastIndexOf("/") + 1, dest.getName().length())));
							output.create(input, true, monitor);
							output.refreshLocal(IResource.DEPTH_ZERO, monitor);
							input.close();
						}
					}
			    }
			    jar.close();
			}
			else {
				srcName = JavaWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "lib";
				final File src = new Path(srcName).toFile();
				for (File f : src.listFiles()) {
					if (!f.isDirectory()) {
						final IFile dest = libFolder.getFile(new Path(f.getName()));
						dest.create(new FileInputStream(f), true, monitor);
						dest.refreshLocal(IResource.DEPTH_ZERO, monitor);
					}
				}
			}
			
			final IFolder modelValidatorPluginFolder = libFolder.getFolder(new Path("modelValidatorPlugin"));
			if (!modelValidatorPluginFolder.exists()) {
				modelValidatorPluginFolder.create(true, true, monitor);
			}
			final IFolder modelValidatorPluginx86Folder = modelValidatorPluginFolder.getFolder(new Path("x86"));
			if (!modelValidatorPluginx86Folder.exists()) {
				modelValidatorPluginx86Folder.create(true, true, monitor);
			}

			//Bundle bundle = Platform.getBundle("wodel.wodeledu");
			//URL fileURL = bundle.getEntry("content");
			jarFile = new File(JavaWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath());
			srcName = "";
			if (jarFile.isFile()) {
				final JarFile jar = new JarFile(jarFile);
				final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
			    while(entries.hasMoreElements()) {
			    	JarEntry entry = entries.nextElement();
					if (! entry.isDirectory()) {
						if (entry.getName().startsWith("lib/modelValidatorPlugin/x86/")) {
							final String name = entry.getName();
							final File f = modelValidatorPluginx86Folder.getRawLocation().makeAbsolute().toFile();
							File dest = new File(f.getPath() + '/' + entry.getName().substring("lib/modelValidatorPlugin/x86".length(), entry.getName().length()).split("/")[1]);
							InputStream input = jar.getInputStream(entry);
							final IFile output = modelValidatorPluginx86Folder.getFile(new Path(dest.getName()
									.substring(dest.getName().lastIndexOf("/") + 1, dest.getName().length())));
							output.create(input, true, monitor);
							output.refreshLocal(IResource.DEPTH_ZERO, monitor);
							input.close();
						}
					}
			    }
			    jar.close();
			}
			else {
				srcName = JavaWizard.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "lib/modelValidatorPlugin/x86";
				final File src = new Path(srcName).toFile();
				for (File f : src.listFiles()) {
					if (!f.isDirectory()) {
						final IFile dest = modelValidatorPluginx86Folder.getFile(new Path(f.getName()));
						dest.create(new FileInputStream(f), true, monitor);
						dest.refreshLocal(IResource.DEPTH_ZERO, monitor);
					}
				}
			}
			
		} catch (IOException e) {
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		monitor.beginTask("Creating tests folder", 8);
		final IFile test = configFolder.getFile(new Path("test.txt"));
		try {
			InputStream stream = openTestStream();
			if (test.exists()) {
				test.setContents(stream, true, true, monitor);
			} else {
				test.create(stream, true, monitor);
			}
			stream.close();
		} catch (IOException e) {
		}
		monitor.worked(1);
		monitor.setTaskName("Opening file for editing...");
		getShell().getDisplay().asyncExec(new Runnable() {
			public void run() {
				IWorkbenchPage page = PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getActivePage();
				try {
					IDE.openEditor(page, file, true);
				} catch (PartInitException e) {
				}
			}
		});
		monitor.worked(1);
		
		try {
			project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		} catch (CoreException ex) {
			ex.printStackTrace();
		}
		
		createPlugin(monitor, project);

	}
	
	/**
	 * Toggles the finish button
	 */
	public boolean canFinish()
	{
		if(getContainer().getCurrentPage() == _pageOne) {
			if (_pageOne.valid == true) {
				return true;
			}
		}
		return false;
	}

	/**
	 * We will initialize file contents with a sample text.
	 */

	private InputStream openContentStream() {
		String contents = "";
		return new ByteArrayInputStream(contents.getBytes());
	}

	/**
	 * We will initialize file contents with the name of the model folder and
	 * the name of the mutants folder.
	 */

	private InputStream openConfigStream(String modelName, String mutantName) {
		String contents = modelName + "\n" + mutantName;
		return new ByteArrayInputStream(contents.getBytes());
	}

	/**
	 * We will initialize file contents with a sample text.
	 */

	private InputStream openTestStream() {
		String contents = "";
		return new ByteArrayInputStream(contents.getBytes());
	}
	
	private static void assertExist(final IContainer c) {
		if (!c.exists()) {
			if (!c.getParent().exists()) {
				assertExist(c.getParent());
			}
			if (c instanceof IFolder) {
				try {
					((IFolder) c).create(false, true, new NullProgressMonitor());
				}
				catch (final CoreException e) {
					//OawLog.logError(e);
				}
			}

		}

	}
	
	public static IFile createFile(final String name, final IContainer container, final String content,
			final IProgressMonitor progressMonitor) {
		final IFile file = container.getFile(new Path(name));
		assertExist(file.getParent());
		try {
			final InputStream stream = new ByteArrayInputStream(content.getBytes(file.getCharset()));
			if (file.exists()) {
				file.setContents(stream, true, true, progressMonitor);
			}
			else {
				file.create(stream, true, progressMonitor);
			}
			stream.close();
		}
		catch (final Exception e) {
			// TO-DO: Something
		}
		progressMonitor.worked(1);

		return file;
	}

	
	public static IFile createFile(final String name, final IContainer container, final String content,
			final String charSet, final IProgressMonitor progressMonitor) throws CoreException {
		final IFile file = createFile(name, container, content, progressMonitor);
		if (file != null && charSet != null) {
			file.setCharset(charSet, progressMonitor);
		}

		return file;
	}
	
	
	private static void createPlugin(final IProgressMonitor progressMonitor, final IProject project) {
		final StringBuilder pContent = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		pContent.append("\n");
		pContent.append("<?eclipse version=\"3.4\"?>");
		pContent.append("\n");
		pContent.append("<plugin>");
		pContent.append("\n");
		pContent.append("</plugin>");
		pContent.append("\n");
		createFile("plugin.xml", project, pContent.toString(), progressMonitor);
	}

}
