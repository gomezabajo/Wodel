package wodeltest.extension.run;

import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.AbstractMap.SimpleEntry;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

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

import wodel.extension.generator.IGenerator;
import wodel.utils.manager.IOUtils;
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
						"import java.util.Map;\n\n" +
						"import org.eclipse.core.resources.IProject;\n" +
						"import org.eclipse.emf.ecore.EObject;\n" +
						"import org.eclipse.emf.ecore.EPackage;\n\n" +
						"import org.eclipse.emf.ecore.resource.Resource;\n\n" +
						"import org.eclipse.core.runtime.IProgressMonitor;\n\n" +
						"public class WodelTest implements IWodelTest {\n\n\t@Override\n" +
						"\tpublic String getProjectName() {\n\t\treturn \"" + mutProject.getName() + "\";\n\t}\n\n\t@Override\n" +
						"\tpublic String getNatureId() {\n\t\treturn \"\";\n\t}\n\n\t@Override\n" +
						"\tpublic void compile(IProject project) {\n\t}\n\n\t@Override\n" +
						"\tpublic List<String> artifactPaths(IProject project, String projectPath, File outputFolder, List<String> blockNames) {\n\t\treturn null;\n\t}\n\n\t@Override\n" +
						"\tpublic WodelTestGlobalResult run(IProject project, IProject testSuiteProject, String artifactPath, IProgressMonitor monitor) {\n\t\treturn null;\n\t}\n\n\t@Override\n" +
						"\tpublic void projectToModel(String projectName, Class<?> cls) {\n\t}\n\n\t@Override\n" +
						"\tpublic void projectToModel(IProject project, Class<?> cls) {\n\t}\n\n\t@Override\n" +
						"\tpublic boolean modelToProject(String className, Resource model, String folderName, String modelName, String projectName, Class<?> cls) {\n\t\treturn false;\n\t}\n\n\t@Override\n" +
						"\tpublic boolean modelToProject(String className, Resource model, String folderName, String modelName, IProject project, Class<?> cls) {\n\t\treturn false;\n\t}\n\n\t@Override\n" +
						"\tpublic String getContainerEClassName() {\n\t\treturn \"\";\n\t}\n\n\t@Override\n" +
						"\tpublic boolean annotateMutation(Resource model, EObject container, String annotation) {\n\t\treturn false;\n\t}\n\t@Override\n" +
						"\tpublic WodelTestGlobalResult run(IProject project, IProject testSuiteProject, String artifactPath, int port, IProgressMonitor monitor) {\n\treturn null;\n\t}\n\n\t@Override\n" +
						"\tpublic WodelTestGlobalResult run(IProject project, IProject testSuiteProject, String artifactPath, List<Thread> threads, IProgressMonitor monitor) {\n\t\treturn null;\n\t}\n\n\t@Override\n" +
						"\tpublic Map<IProject, WodelTestGlobalResult> run(IProject project, List<IProject> testSuitesProjects, String artifactPath, IProgressMonitor monitor) {\n\t\treturn null;\n\t}\n\n\t@Override\n" +
						"\tpublic Map<IProject, WodelTestGlobalResult> run(IProject project, List<IProject> testSuitesProjects, String artifactPath, int port, IProgressMonitor monitor) {\n\t\treturn null;\n\t}\n\n\t@Override\n" +
						"\tpublic Map<IProject, WodelTestGlobalResult> run(IProject project, List<IProject> testSuitesProjects, String artifactPath, List<Thread> threads, IProgressMonitor monitor) {\n\t\treturn null;\n\t}\n" +
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
			
			SimpleEntry<String, String> replacement = new SimpleEntry<String, String>("[@**@]", mutProject.getName());
			List<SimpleEntry<String, String>> replacements = new ArrayList<SimpleEntry<String, String>>();
			replacements.add(replacement);
			
			try {
			//Bundle bundle = Platform.getBundle("wodel.wodeledu");
			//URL fileURL = bundle.getEntry("content");
			final File jarFile = new File(Generator.class.getProtectionDomain().getCodeSource().getLocation().getPath());
			String srcName = "";
			if (jarFile.isFile()) {
				final JarFile jar = new JarFile(jarFile);
				final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
			    while(entries.hasMoreElements()) {
			    	JarEntry entry = entries.nextElement();
					if (! entry.isDirectory()) {
						if (entry.getName().startsWith("wodeltest/default")) {
							final String name = entry.getName();
							final File f = wodeltestPackage.getRawLocation().makeAbsolute().toFile();
							File dest = new File(f.getPath() + '/' + entry.getName().replace("wodeltest/default", ""));
							if (!dest.exists()) {
								dest.getParentFile().mkdirs();
							}
							InputStream input = jar.getInputStream(entry);
							InputStreamReader isr = new InputStreamReader(input);
							BufferedReader br = new BufferedReader(isr);
							FileOutputStream output = new FileOutputStream(dest);
							OutputStreamWriter osw = new OutputStreamWriter(output); 
							for (SimpleEntry<String, String> rep: replacements) {
								String line = null;
								while ((line = br.readLine()) != null) {
									if (line.indexOf(rep.getKey()) != -1) {
										line = line.replace(rep.getKey(), rep.getValue());
									}
									osw.write(line + "\n");
								}
							}
							osw.close();
							output.close();
							br.close();
							isr.close();
							input.close();
						}
		    		}
			    }
			    jar.close();
			}
			else {
				srcName = Generator.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "wodeltest/default";
				final File src = new Path(srcName).toFile();
				final File dest = wodeltestPackage.getRawLocation().makeAbsolute().toFile();
				if ((src != null) && (dest != null)) {
					IOUtils.copyFolderWithReplacements(src, dest, replacements);
				}
			}
			} catch (IOException e) {
			}

			monitor.beginTask("Creating data folder", 9);
			final IFolder dataFolder = mutProject.getFolder(new Path("data"));
			if (!dataFolder.exists()) {
				dataFolder.create(true, true, monitor);
			}
			
			monitor.beginTask("Creating config folder", 8);
			final IFolder configFolder = dataFolder.getFolder(new Path("config"));
			if (!configFolder.exists()) {
				configFolder.create(true, true, monitor);
			}
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
			
			final IFolder iconsFolder = mutProject.getFolder(new Path("icons"));
			iconsFolder.create(true, true, monitor);
			
			try {
				final File jarFile = new File(Generator.class.getProtectionDomain().getCodeSource().getLocation().getPath());
				String srcName = "";
				if (jarFile.isFile()) {
					final JarFile jar = new JarFile(jarFile);
					final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
					while(entries.hasMoreElements()) {
						JarEntry entry = entries.nextElement();
						if (! entry.isDirectory()) {
							if (entry.getName().startsWith("icons")) {
								final File f = iconsFolder.getRawLocation().makeAbsolute().toFile();
								File path = new File(f.getPath() + '/' + entry.getName().replace("icons", "").split("/")[0]);
								if (!path.exists()) {
									path.mkdir();
								}
								File dest = new File(f.getPath() + '/' + entry.getName().replace("icons", ""));
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
					srcName = Generator.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "icons";
					final File src = new Path(srcName).toFile();
					final File dest = iconsFolder.getRawLocation().makeAbsolute().toFile();
					if ((src != null) && (dest != null)) {
						IOUtils.copyFolder(src, dest);
					}
				}
			} catch (IOException e) {
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
	
	/**
	 * We will initialize file contents with the name of the model folder and
	 * the name of the mutants folder.
	 */

	private InputStream openConfigStream(String modelName, String mutantName, IProject project) {
		String contents = modelName + "\n" + mutantName + "\n" + project.getName() + ".mutator\nWodel-Test: Generation of a model-based software testing framework\n";
		return new ByteArrayInputStream(contents.getBytes());
	}

	/**
	 * We will initialize file contents with a sample text.
	 */

	private InputStream openTestStream() {
		String contents = "";
		return new ByteArrayInputStream(contents.getBytes());
	}
	
	
	private static void createPlugin(final IProgressMonitor progressMonitor, final IProject project) {
		final StringBuilder pContent = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		pContent.append("\n");
		pContent.append("<?eclipse version=\"3.4\"?>");
		pContent.append("\n");
		pContent.append("<plugin>");
		pContent.append("\n");
		pContent.append("\t<extension");
		pContent.append("\n");
		pContent.append("\t\tpoint=\"wodeltest.extension.MutTesting\">");
		pContent.append("\n");
		pContent.append("\t\t<wodeltest");
		pContent.append("\n");
		pContent.append("\t\t\tclass=\"mutator.wodeltest." + project.getName() + ".WodelTest\">");
		pContent.append("\n");
		pContent.append("\t\t</wodeltest>");
		pContent.append("\n");
		pContent.append("\t</extension>");
		pContent.append("\n");
		pContent.append("\t<extension");
		pContent.append("\n");
		pContent.append("\tid=\"wodeltest.extension.wodelTestSUTNature\"");
		pContent.append("\n");
		pContent.append("\tname=\"Wodel-Test SUT Project Nature\"");
		pContent.append("\n");
		pContent.append("\tpoint=\"org.eclipse.core.resources.natures\">");
		pContent.append("\n");
		pContent.append("\t<runtime>");
		pContent.append("\n");
		pContent.append("\t<run");
		pContent.append("\n");
		pContent.append("\tclass=\"mutator.wodeltest." + project.getName() + ".builder.WodelTestSUTNature\">");
		pContent.append("\n");
		pContent.append("\t</run>");
		pContent.append("\n");
		pContent.append("\t</runtime>");
		pContent.append("\n");
		pContent.append("\t<builder");
		pContent.append("\n");
		pContent.append("\tid=\"wodeltest.extension.wodelTestSUTBuilder\">");
		pContent.append("\n");
		pContent.append("\t</builder>");
		pContent.append("\n");
		pContent.append("\t</extension>");
		pContent.append("\n");
		pContent.append("\t<extension");
		pContent.append("\n");
		pContent.append("\tid=\"wodeltest.extension.wodelTestSUTBuilder\"");
		pContent.append("\n");
		pContent.append("\tname=\"Wodel-Test SUT Project Builder\"");
		pContent.append("\n");
		pContent.append("\tpoint=\"org.eclipse.core.resources.builders\">");
		pContent.append("\n");
		pContent.append("\t<builder");
		pContent.append("\n");
		pContent.append("\thasNature=\"true\">");
		pContent.append("\n");
		pContent.append("\t<run");
		pContent.append("\n");
		pContent.append("\tclass=\"mutator.wodeltest." + project.getName() + ".builder.WodelTestSUTBuilder\">");
		pContent.append("\n");
		pContent.append("\t</run>");
		pContent.append("\n");
		pContent.append("\t</builder>");
		pContent.append("\n");
  		pContent.append("\t</extension>");
		pContent.append("\n");
		pContent.append("\t<extension");
		pContent.append("\n");
		pContent.append("\tpoint=\"org.eclipse.ui.commands\">");
		pContent.append("\n");
		pContent.append("\t<category");
		pContent.append("\n");
		pContent.append("\tname=\"Wodel-Test SUT Project Nature commands\"");
		pContent.append("\n");
		pContent.append("\tid=\"wodeltest.extension.wodelTestSUTNature.category\">");
		pContent.append("\n");
		pContent.append("\t</category>");
		pContent.append("\n");
		pContent.append("\t<command");
		pContent.append("\n");
		pContent.append("\tname=\"Add/Remove Wodel-Test SUT Project Nature\"");
		pContent.append("\n");
		pContent.append("\tdefaultHandler=\"mutator.wodeltest." + project.getName() + ".builder.AddRemoveWodelTestSUTNatureHandler\"");
		pContent.append("\n");
		pContent.append("\tcategoryId=\"wodeltest.extension.wodelTestSUTNature.category\"");
		pContent.append("\n");
		pContent.append("\tid=\"wodeltest.extension.addRemoveWodelTestSUTNature\">");
		pContent.append("\n");
		pContent.append("\t</command>");
		pContent.append("\n");
		pContent.append("\t</extension>");
		pContent.append("\n");
		pContent.append("\t<extension");
		pContent.append("\n");
		pContent.append("\tpoint=\"org.eclipse.ui.menus\">");
		pContent.append("\n");
		pContent.append("\t<menuContribution");
		pContent.append("\n");
		pContent.append("\tlocationURI=\"popup:org.eclipse.ui.projectConfigure?after=additions\">");
		pContent.append("\n");
		pContent.append("\t<command");
		pContent.append("\n");
		pContent.append("\tcommandId=\"wodeltest.extension.addRemoveWodelTestSUTNature\"");
		pContent.append("\n");
		pContent.append("\ticon=\"icons/wodel4.jpg\"");
		pContent.append("\n");
		pContent.append("\tlabel=\"Disable Wodel-Test SUT Nature\"");
		pContent.append("\n");
		pContent.append("\tstyle=\"push\">");
		pContent.append("\n");
		pContent.append("\t<visibleWhen");
		pContent.append("\n");
		pContent.append("\tcheckEnabled=\"false\">");
		pContent.append("\n");
		pContent.append("\t<with");
		pContent.append("\n");
		pContent.append("\tvariable=\"selection\">");
		pContent.append("\n");
		pContent.append("\t<count");
		pContent.append("\n");
		pContent.append("\tvalue=\"1\">");
		pContent.append("\n");
		pContent.append("\t</count>");
		pContent.append("\n");
		pContent.append("\t<iterate>");
		pContent.append("\n");
		pContent.append("\t<adapt");
		pContent.append("\n");
		pContent.append("\ttype=\"org.eclipse.core.resources.IProject\">");
		pContent.append("\n");
		pContent.append("\t<test");
		pContent.append("\n");
		pContent.append("\tvalue=\"wodeltest.extension.wodelTestSUTNature\"");
		pContent.append("\n");
		pContent.append("\tproperty=\"org.eclipse.core.resources.projectNature\">");
		pContent.append("\n");
		pContent.append("\t</test>");
		pContent.append("\n");
		pContent.append("\t</adapt>");
		pContent.append("\n");
		pContent.append("\t</iterate>");
		pContent.append("\n");
		pContent.append("\t</with>");
		pContent.append("\n");
		pContent.append("\t</visibleWhen>");
		pContent.append("\n");
		pContent.append("\t</command>");
		pContent.append("\n");
		pContent.append("\t<command");
		pContent.append("\n");
		pContent.append("\tcommandId=\"wodeltest.extension.addRemoveWodelTestSUTNature\"");
		pContent.append("\n");
		pContent.append("\ticon=\"icons/wodel4.jpg\"");
		pContent.append("\n");
		pContent.append("\tlabel=\"Enable Wodel-Test SUT Nature\"");
		pContent.append("\n");
		pContent.append("\tstyle=\"push\">");
		pContent.append("\n");
		pContent.append("\t<visibleWhen");
		pContent.append("\n");
		pContent.append("\tcheckEnabled=\"false\">");
		pContent.append("\n");
		pContent.append("\t<with");
		pContent.append("\n");
		pContent.append("\tvariable=\"selection\">");
		pContent.append("\n");
		pContent.append("\t<count");
		pContent.append("\n");
		pContent.append("\tvalue=\"1\">");
		pContent.append("\n");
		pContent.append("\t</count>");
		pContent.append("\n");
		pContent.append("\t<iterate>");
		pContent.append("\n");
		pContent.append("\t<adapt");
		pContent.append("\n");
		pContent.append("\ttype=\"org.eclipse.core.resources.IProject\">");
		pContent.append("\n");
		pContent.append("\t<not>");
		pContent.append("\n");
		pContent.append("\t<test");
		pContent.append("\n");
		pContent.append("\tvalue=\"wodeltest.extension.wodelTestSUTNature\"");
		pContent.append("\n");
		pContent.append("\tproperty=\"org.eclipse.core.resources.projectNature\">");
		pContent.append("\n");
		pContent.append("\t</test>");
		pContent.append("\n");
		pContent.append("\t</not>");
		pContent.append("\n");
		pContent.append("\t</adapt>");
		pContent.append("\n");
		pContent.append("\t</iterate>");
		pContent.append("\n");
		pContent.append("\t</with>");
		pContent.append("\n");
		pContent.append("\t</visibleWhen>");
		pContent.append("\n");
		pContent.append("\t</command>");
		pContent.append("\n");
		pContent.append("\t</menuContribution>");
		pContent.append("\n");
		pContent.append("\t</extension>");
		pContent.append("\n");
		pContent.append("\t<extension");
		pContent.append("\n");
		pContent.append("\tid=\"xmlProblem\"");
		pContent.append("\n");
		pContent.append("\tname=\"XML Problem\"");
		pContent.append("\n");
		pContent.append("\tpoint=\"org.eclipse.core.resources.markers\">");
		pContent.append("\n");
		pContent.append("\t<super");
		pContent.append("\n");
		pContent.append("\ttype=\"org.eclipse.core.resources.problemmarker\">");
		pContent.append("\n");
		pContent.append("\t</super>");
		pContent.append("\n");
		pContent.append("\t<persistent");
		pContent.append("\n");
		pContent.append("\tvalue=\"true\">");
		pContent.append("\n");
		pContent.append("\t</persistent>");
		pContent.append("\n");
		pContent.append("\t</extension>");
		pContent.append("\n");
		pContent.append("\t<extension");
		pContent.append("\n");
		pContent.append("\tpoint=\"org.eclipse.ui.ide.projectNatureImages\">");
		pContent.append("\n");
		pContent.append("\t<image");
		pContent.append("\n");
		pContent.append("\ticon=\"icons/wodel4.jpg\"");
		pContent.append("\n");
		pContent.append("\tid=\"wodeltest.extension.wodelTestSUTProjectNature\"");
		pContent.append("\n");
		pContent.append("\tnatureId=\"wodeltest.extension.wodelTestSUTNature\">");
		pContent.append("\n");
		pContent.append("\t</image>");
		pContent.append("\n");
		pContent.append("\t</extension>");
		pContent.append("\n");
		pContent.append("\t<extension");
		pContent.append("\n");
		pContent.append("\tpoint=\"org.eclipse.ui.propertyPages\">");
		pContent.append("\n");
		pContent.append("\t<page");
		pContent.append("\n");
		pContent.append("\ticon=\"icons/wodel4.jpg\"");
		pContent.append("\n");
		pContent.append("\tclass=\"mutator.wodeltest." + project.getName() + ".properties.WodelTestPropertiesPage\"");
		pContent.append("\n");
		pContent.append("\tid=\"mutator.wodeltest." + project.getName() + ".properties.WodelTestPropertiesPage\"");
		pContent.append("\n");
		pContent.append("\tname=\"Wodel-Test for " + project.getName() + "\">");
		pContent.append("\n");
		pContent.append("\t<enabledWhen>");
		pContent.append("\n");
		pContent.append("\t<adapt");
		pContent.append("\n");
		pContent.append("\ttype=\"org.eclipse.jdt.core.IJavaProject\">");
		pContent.append("\n");
		pContent.append("\t<and>");
		pContent.append("\n");
		pContent.append("\t<test");
		pContent.append("\n");
		pContent.append("\tvalue=\"org.eclipse.jdt.core.javanature\"");
		pContent.append("\n");
		pContent.append("\tproperty=\"org.eclipse.core.resources.projectNature\">");
		pContent.append("\n");
		pContent.append("\t</test>");
		pContent.append("\t<test");
		pContent.append("\n");
		pContent.append("\tvalue=\"wodeltest.extension.wodelTestSUTNature\"");
		pContent.append("\n");
		pContent.append("\tproperty=\"org.eclipse.core.resources.projectNature\">");
		pContent.append("\n");
		pContent.append("\t</test>");
		pContent.append("\n");
		pContent.append("\n");
		pContent.append("\t</and>");
		pContent.append("\n");
		pContent.append("\t</adapt>");
		pContent.append("\n");
		pContent.append("\t</enabledWhen>");
		pContent.append("\n");
		pContent.append("\t</page>");
		pContent.append("\n");
		pContent.append("\t</extension>");
		pContent.append("\n");
		pContent.append("</plugin>");
		pContent.append("\n");
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
	
	@Override
	public List<String> importPackages() {
		List<String> importPackages = new ArrayList<String>();
		return importPackages;
	}

	@Override
	public List<String> bundleClasspath() {
		List<String> bundleClasspath = new ArrayList<String>();
		return bundleClasspath;
	}
}
