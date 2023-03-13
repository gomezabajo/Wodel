package wodeltest.extension.run;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.JavaModelException;

import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;

import wodel.extension.generator.IGenerator;
import wodeltest.extension.builder.WodelTestNature;

public class Generator implements IGenerator {
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Wodel-Test: Generation of a model-based software testing framework";
	}
	
	private void addTextToFile(IFolder path, String fileName, String text, IProgressMonitor monitor) {
		IFile file = path.getFile(new Path(fileName));
		try {
			InputStream stream = file.getContents();
			if (file.exists()) {
				String content = CharStreams.toString(new InputStreamReader(stream, Charsets.UTF_8));
				content += text;
				stream = new ByteArrayInputStream(content.getBytes(Charsets.UTF_8));
				file.setContents(stream, true, true, monitor);
			}
			else {
				file.create(stream, true, monitor);
			}
			stream.close();
		} catch (CoreException e) {
		} catch (IOException e) {
		}
	}
	
	@Override
	public boolean doGenerate(String fileName, String metamodel, String project, String outputPath, IProject mutProject, IFolder srcPath, IFolder configPath, 
			IProgressMonitor monitor) {
		try {
			
			final IFolder mutFolder = srcPath.getFolder(new Path("mutator"));
			try {
				mutFolder.create(true, true, monitor);
			} catch (CoreException e) {
			}
			final IFolder wodeltestFolder = mutFolder.getFolder(new Path("wodeltest"));
			try {
				wodeltestFolder.create(true, true, monitor);
			} catch (CoreException e) {
			}
			final IFolder wodeltestPackage = wodeltestFolder.getFolder(new Path(mutProject.getName()));
			try {
				wodeltestPackage.create(true, true, monitor);
			} catch (CoreException e) {
			}
			List<String> mutFiles = new ArrayList<String>();
			for (IResource mutResource : srcPath.members()) {
				if (mutResource instanceof IFile) {
					IFile mutFile = (IFile) mutResource;
					if (mutFile.getName().endsWith(".mutator")) {
						mutFiles.add(mutFile.getName().replace(".mutator", ""));
					}
				}
			}
			final IFile file = wodeltestPackage.getFile(new Path("WodelTest.java"));
			try {
				InputStream stream = openContentStream();
				String code = "package mutator.wodeltest." + mutProject.getName() + ";\n\n" +
						"import wodel.utils.manager.IWodelTest;\n" +
						"import wodel.utils.manager.WodelTestGlobalResult;\n" +
						"import java.io.File;\n" +
						"import java.util.List;\n" +
						"import org.eclipse.core.resources.IProject;\n" +
						"import org.eclipse.emf.ecore.EObject;\n" +
						"import org.eclipse.emf.ecore.EPackage;\n\n" +
						"import org.eclipse.emf.ecore.resource.Resource;\n\n" +
						"public class WodelTest implements IWodelTest {\n\n\t@Override\n" +
						"\tpublic String getProjectName() {\n\t\treturn \"" + mutProject.getName() + "\";\n\t}\n\n\t@Override\n" +
						"\tpublic String getNatureId() {\n\t\treturn \"\";\n\t}\n\n\t@Override\n" +
						"\tpublic void compile(IProject project) {\n\t}\n\n\t@Override\n" +
						"\tpublic List<String> artifactPaths(IProject project, String projectPath, File outputFolder, List<String> blockNames) {\n\t\treturn null;\n\t}\n\n\t@Override\n" +
						"\tpublic WodelTestGlobalResult run(IProject project, IProject testSuiteProject, String artifactPath) {\n\t\treturn null;\n\t}\n\n\t@Override\n" +
						"\tpublic void projectToModel(String projectName, Class<?> cls) {\n\t}\n\n\t@Override\n" +
						"\tpublic boolean modelToProject(String className, Resource model, String folderName, String modelName, String projectName, Class<?> cls) {\n\t\treturn false;\n\t}\n\n\t@Override\n" +
						"\tpublic String getContainerEClassName() {\n\t\treturn \"\";\n\t}\n\n\t@Override\n" +
						"\tpublic boolean annotateMutation(Resource model, EObject container, String annotation) {\n\t\treturn false;\n\t}\n" +
						"}";
				if (file.exists()) {
					String content = CharStreams.toString(new InputStreamReader(stream, Charsets.UTF_8));
					content += code;
					stream = new ByteArrayInputStream(content.getBytes(Charsets.UTF_8));
					file.setContents(stream, true, true, monitor);
				} else {
					stream = new ByteArrayInputStream(code.getBytes(Charsets.UTF_8));
					file.create(stream, true, monitor);
				}
				stream.close();
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			addTextToFile(configPath, "config.txt", "\n" + this.getName(), monitor);
			
			IProjectDescription description = mutProject.getDescription();

			String[] natures = description.getNatureIds();
			String[] newNatures = new String[natures.length + 1];
			System.arraycopy(natures, 0, newNatures, 0, natures.length);
			newNatures[natures.length] = WodelTestNature.NATURE_ID;

			// validate the natures
			IWorkspace workspace = ResourcesPlugin.getWorkspace();
			IStatus status = workspace.validateNatureSet(newNatures);

			// only apply new nature, if the status is ok
			if (status.getCode() == IStatus.OK) {
				description.setNatureIds(newNatures);
				mutProject.setDescription(description, null);
			}
			
			//final IFolder metaInf = mutProject.getFolder("META-INF");
			//addTextToFile(metaInf, "MANIFEST.MF", "Export-Package: mutator." + mutProject.getName() + ",\n mutator.wodeltest." + mutProject.getName() + "\n", monitor);
			createPlugin(monitor, mutProject);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JavaModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public void doRun(IFile file) {
		
	}

	@Override
	public void setInitializationData(IConfigurationElement config,
			String propertyName, Object data) throws CoreException {
		// TODO Auto-generated method stub
	}
	
	/**
	 * We will initialize file contents with a sample text.
	 */

	private InputStream openContentStream() {
		String contents = "";
		return new ByteArrayInputStream(contents.getBytes());
	}
	
	/**
	 * @param name
	 *            of the destination file
	 * @param container
	 *            directory containing the the destination file
	 * @param contentUrl
	 *            Url pointing to the src of the content
	 * @param progressMonitor
	 *            used to interact with and show the user the current operation
	 *            status
	 * @return
	 */
	public static IFile createFile(final String name, final IContainer container, final URL contentUrl,
			final IProgressMonitor progressMonitor) {

		final IFile file = container.getFile(new Path(name));
		InputStream inputStream = null;
		try {
			inputStream = contentUrl.openStream();
			if (file.exists()) {
				file.setContents(inputStream, true, true, progressMonitor);
			}
			else {
				file.create(inputStream, true, progressMonitor);
			}
			inputStream.close();
		}
		catch (final Exception e) {
			//OawLog.logError(e);
		}
		finally {
			if (null != inputStream) {
				try {
					inputStream.close();
				}
				catch (final IOException e) {
					//OawLog.logError(e);
				}
			}
		}
		progressMonitor.worked(1);

		return file;
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
		pContent.append("<?eclipse version=\"3.4\"?>");
		pContent.append("<plugin>");
		pContent.append("\t<extension");
		pContent.append("\t\tpoint=\"wodeltest.extension.MutTesting\">");
		pContent.append("\t\t<wodeltest");
		pContent.append("\t\t\tclass=\"mutator.wodeltest." + project.getName() + ".WodelTest\">");
		pContent.append("\t\t</wodeltest>");
		pContent.append("\t</extension>");
		pContent.append("</plugin>");
		createFile("plugin.xml", project, pContent.toString(), progressMonitor);
	}

	@Override
	public List<String> requiredBundles() {
		List<String> requiredBundles = new ArrayList<String>();
		requiredBundles.add("wodeltest.extension");
		requiredBundles.add("org.eclipse.jdt.core");
		requiredBundles.add("org.eclipse.ui.ide");
		return requiredBundles;
	}
}
