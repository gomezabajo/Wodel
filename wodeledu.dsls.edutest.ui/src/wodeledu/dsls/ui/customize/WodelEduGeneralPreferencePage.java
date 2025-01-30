package wodeledu.dsls.ui.customize;

import wodel.utils.exceptions.MetaModelNotFoundException;
import wodel.utils.manager.ModelManager;
import wodel.utils.manager.ProjectUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.ui.IWorkbench;
import org.eclipse.xtext.ui.editor.preferences.LanguageRootPreferencePage;
import org.eclipse.xtext.ui.editor.preferences.fields.LabelFieldEditor;

import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;
import wodeledu.utils.manager.WodelEduUtils;

/**
 * @author Pablo Gomez-Abajo - Wodel-Edu General preferences page
 *
 */

public class WodelEduGeneralPreferencePage extends LanguageRootPreferencePage {
	
	private static String folder = null;
	private LabelFieldEditor label = null;
	private int height = 0;
	private Button button = null;
	private Composite composite = null;
	private WodelEduExtension extension = WodelEduExtension.DFA;
	

	private void compile(IProject project) {
		try {
			project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
			project.build(IncrementalProjectBuilder.INCREMENTAL_BUILD, new NullProgressMonitor());
			Job.getJobManager().join(ResourcesPlugin.FAMILY_MANUAL_BUILD, new NullProgressMonitor());
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (OperationCanceledException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    @Override
    protected void createFieldEditors() {
    	
    	IProject project = null;
    	if (ProjectUtils.getProject() != null) {
    		project = ProjectUtils.getProject();
    	}
    	
    	if (project == null) {
    		return;
    	}
    	
    	composite = getFieldEditorParent();
		String[][] values = new String[5][2];
		values[0][0] = "";
		values[0][1] = "";
		values[1][0] = "Web";
		values[1][1] = "Web";
		values[2][0] = "Moodle";
		values[2][1] = "Moodle";
		values[3][0] = "AndroidApp";
		values[3][1] = "AndroidApp";
		values[4][0] = "iOSApp";
		values[4][1] = "iOSApp";
	    	
    	new LabelFieldEditor("Wodel-Edu mode", composite);
    	ComboFieldEditor combo = new ComboFieldEditor("Wodel-Edu mode", "", values, composite);
    	addField(combo);
    	
    	composite = getFieldEditorParent();
		values = new String[4][2];
		values[0][0] = "";
		values[0][1] = "";
		values[1][0] = "Dot";
		values[1][1] = "Dot";
		values[2][0] = "Circuit";
		values[2][1] = "Circuit";
		values[3][0] = "PlantUML";
		values[3][1] = "PlantUML";

    	new LabelFieldEditor(" \n\n", composite);
		new LabelFieldEditor("\n\nModel-Draw mode", composite);
    	combo = new ComboFieldEditor("Model-Draw mode", "", values, composite);
    	addField(combo);

    	new LabelFieldEditor(" \n\n", composite);
		new LabelFieldEditor("\n\nModel-Draw renderer path", composite);
		
		IPreferenceStore preferenceStore = doGetPreferenceStore();
		folder = preferenceStore.getDefaultString("Model-Draw renderer path");
		if (folder == null || folder.isEmpty()) {
			folder = project.getFolder("dpic").getLocation().toFile().getPath();
		}
		
		String metamodelPath = ModelManager.getMetaModel();
		List<EPackage> metamodel = null;
		try {
			metamodel = ModelManager.loadMetaModel(metamodelPath);
		} catch (MetaModelNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String uri = metamodel.get(0).getNsURI();
		
		switch(uri) {
			case "http://dfaAutomaton/1.0":
				extension = WodelEduExtension.DFA;
				preferenceStore.setDefault("Model-Draw mode", "Dot");
				break;
			case "http://lc/1.0":
				extension = WodelEduExtension.LC;
				preferenceStore.setDefault("Model-Draw mode", "Circuit");
				break;
			case "http://UMLDiagram/1.0":
				extension = WodelEduExtension.UML;
				preferenceStore.setDefault("Model-Draw mode", "PlantUML");
				break;
			default:
				return;
		}
		
		String projectName = project.getName();
		String filename = projectName + ".draw";

		IFile generatedCodeFile = project.getFile(new Path("/src-gen/mutator/" + project.getName() + "/" + filename.replace(".draw", "Draw.java")));

		try {
			if (generatedCodeFile.exists() == true) {
				generatedCodeFile.delete(true, new NullProgressMonitor());
			}
			final IFolder src = project.getFolder(new Path("src"));
			if (src.exists() == false) {
				return;
			}
			final IFile dslFile = src.getFile(new Path(filename));
			InputStream stream = dslFile.getContents();
			if (dslFile.exists()) {
				String content = CharStreams.toString(new InputStreamReader(stream, Charsets.UTF_8));
				stream = new ByteArrayInputStream(content.getBytes(Charsets.UTF_8));
				dslFile.setContents(stream, true, true, null);
			}
			else {
				dslFile.create(stream, true, null);
			}
			stream.close();

			/*
			String path = project.getLocation().toFile().getPath().replace("\\", "/");
			String modelname = projectName + "_draw.model";
			String xmiFileName = path + "/" + ModelManager.getOutputFolder() + "/" + modelname;
			Bundle bundle = Platform.getBundle("wodeledu.models");
	   		URL fileURL = bundle.getEntry("/model/ModelDraw.ecore");
	   		String drawecore = FileLocator.resolve(fileURL).getFile();
			List<EPackage> drawpackages = ModelManager.loadMetaModel(drawecore);
			Resource drawmodel = ModelManager.loadModel(drawpackages, xmiFileName);
			String stringURI = "/resource/" + projectName;
			stringURI = stringURI + "/src/" + filename;
			if (drawmodel != null) {
				drawmodel.setURI(URI.createURI(stringURI));
				//ModelDrawGenerator generator = new ModelDrawGenerator();
				Injector injector = new ModelDrawStandaloneSetup().createInjectorAndDoEMFRegistration();
				InMemoryFileSystemAccess fsa = injector.getInstance(InMemoryFileSystemAccess.class);
				String modelDrawMode = Platform.getPreferencesService().getString("wodeledu.dsls.EduTest", "Model-Draw mode", "Dot", null);
				ModelDrawCircuitGenerator circuitGenerator = new ModelDrawCircuitGenerator();
				ModelDrawPlantUMLGenerator plantUMLGenerator = new ModelDrawPlantUMLGenerator();
				ModelDrawDotGenerator dotGenerator = new ModelDrawDotGenerator();
				if (modelDrawMode.equals("Dot")) {
					dotGenerator.doGenerate(drawmodel, fsa, null);
				}
				if (modelDrawMode.equals("Circuit")) {
					circuitGenerator.doGenerate(drawmodel, fsa, null);
				}
				if (modelDrawMode.equals("PlantUML")) {
					plantUMLGenerator.doGenerate(drawmodel, fsa, null);
				}
				//generator.doGenerate(drawmodel, fsa, null);
			}
			*/
		} catch (CoreException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String generatedCode = generatedCodeFile.getLocation().toFile().getPath().replace("\\", "/");
		
		try {
			WodelEduUtils.awaitFile(generatedCode, 10000);
		} catch (IOException | InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		new LabelFieldEditor(" \n\n", composite);
		button = new Button(composite, SWT.NONE);
		button.setText("\n\nLoad folder");
		button.addSelectionListener(new DirectorySelectionAdapter());
		button.addMouseTrackListener((MouseTrackListener) new MyMouseTrackAdapter());
		label = new LabelFieldEditor(folder != null ? folder : "", composite);
    }

    @Override
    public void init(IWorkbench workbench) {
		IPreferenceStore preferenceStore = doGetPreferenceStore();
    	preferenceStore.setDefault("Wodel-Edu mode", "Moodle");
    	switch (extension) {
    	case DFA:
    		preferenceStore.setDefault("Model-Draw mode", "Dot");
    		break;
    	case LC:
    		preferenceStore.setDefault("Model-Draw mode", "Circuit");
    		break;
    	case UML:
    		preferenceStore.setDefault("Model-Draw mode", "PlantUML");
    		break;
    	default:
    		return;
    	}
    }
    
	private class MyMouseTrackAdapter extends MouseTrackAdapter {

		public MyMouseTrackAdapter() {
		}

		@Override
		public void mouseEnter(MouseEvent e) {
			Point size = getShell().computeSize(getShell().getSize().x,
					SWT.DEFAULT);
			size.x = getShell().getSize().x;
			if (size.y > height)
				getShell().setSize(size);
			height = getShell().getSize().y;
		}

		@Override
		public void mouseExit(MouseEvent e) {
		}
	}
	
	private class DirectorySelectionAdapter extends SelectionAdapter {
		@Override
		public void widgetSelected(SelectionEvent e) {
			folder = null;
			DirectoryDialog folderDialog = new DirectoryDialog(getShell(), SWT.OPEN);
			folder = folderDialog.open();
			label = new LabelFieldEditor(folder != null ? folder : "", composite);
			IPreferenceStore preferenceStore = doGetPreferenceStore();
	    	preferenceStore.setDefault("Model-Draw renderer path", folder != null ? folder : null);

	    	IProject project = null;
	    	if (ProjectUtils.getProject() != null) {
	    		project = ProjectUtils.getProject();
	    	}
	    	
	    	if (project == null) {
	    		return;
	    	}
	    	
			String projectName = project.getName();
			String filename = projectName + ".draw";

			IFile generatedCodeFile = project.getFile(new Path("/src-gen/mutator/" + project.getName() + "/" + filename.replace(".draw", "Draw.java")));

			try {
				if (generatedCodeFile.exists() == true) {
					generatedCodeFile.delete(true, new NullProgressMonitor());
				}
				final IFolder src = project.getFolder(new Path("src"));
				if (src.exists() == false) {
					return;
				}
				final IFile dslFile = src.getFile(new Path(filename));
				InputStream stream = dslFile.getContents();
				if (dslFile.exists()) {
					String content = CharStreams.toString(new InputStreamReader(stream, Charsets.UTF_8));
					stream = new ByteArrayInputStream(content.getBytes(Charsets.UTF_8));
					dslFile.setContents(stream, true, true, null);
				}
				else {
					dslFile.create(stream, true, null);
				}
				stream.close();

				/*
				String path = project.getLocation().toFile().getPath().replace("\\", "/");
				String modelname = projectName + "_draw.model";
				String xmiFileName = path + "/" + ModelManager.getOutputFolder() + "/" + modelname;
				Bundle bundle = Platform.getBundle("wodeledu.models");
		   		URL fileURL = bundle.getEntry("/model/ModelDraw.ecore");
		   		String drawecore = FileLocator.resolve(fileURL).getFile();
				List<EPackage> drawpackages = ModelManager.loadMetaModel(drawecore);
				Resource drawmodel = ModelManager.loadModel(drawpackages, xmiFileName);
				String stringURI = "/resource/" + projectName;
				stringURI = stringURI + "/src/" + filename;
				if (drawmodel != null) {
					drawmodel.setURI(URI.createURI(stringURI));
					//ModelDrawGenerator generator = new ModelDrawGenerator();
					Injector injector = new ModelDrawStandaloneSetup().createInjectorAndDoEMFRegistration();
					InMemoryFileSystemAccess fsa = injector.getInstance(InMemoryFileSystemAccess.class);
					String modelDrawMode = Platform.getPreferencesService().getString("wodeledu.dsls.EduTest", "Model-Draw mode", "Dot", null);
					ModelDrawCircuitGenerator circuitGenerator = new ModelDrawCircuitGenerator();
					ModelDrawPlantUMLGenerator plantUMLGenerator = new ModelDrawPlantUMLGenerator();
					ModelDrawDotGenerator dotGenerator = new ModelDrawDotGenerator();
					if (modelDrawMode.equals("Dot")) {
						dotGenerator.doGenerate(drawmodel, fsa, null);
					}
					if (modelDrawMode.equals("Circuit")) {
						circuitGenerator.doGenerate(drawmodel, fsa, null);
					}
					if (modelDrawMode.equals("PlantUML")) {
						plantUMLGenerator.doGenerate(drawmodel, fsa, null);
					}
					//generator.doGenerate(drawmodel, fsa, null);
				}
				*/
			} catch (CoreException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			String generatedCode = generatedCodeFile.getLocation().toFile().getPath().replace("\\", "/");
			
			try {
				WodelEduUtils.awaitFile(generatedCode, 10000);
			} catch (IOException | InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			String metamodelPath = ModelManager.getMetaModel();
			List<EPackage> metamodel = null;
			try {
				metamodel = ModelManager.loadMetaModel(metamodelPath);
			} catch (MetaModelNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String uri = metamodel.get(0).getNsURI();
			System.out.println("URI: " + uri);
			
			
			switch(uri) {
				case "http://dfaAutomaton/1.0":
					extension = WodelEduExtension.DFA;
					break;
				case "http://lc/1.0":
					extension = WodelEduExtension.LC;
					break;
				case "http://UMLDiagram/1.0":
					extension = WodelEduExtension.UML;
					break;
				default:
					return;
			}

/*			
	    	String outputPath = ModelManager.getOutputPath();
			Bundle bundle = Platform.getBundle("wodeledu.models");
			URL wodelURL = bundle.getEntry("/model/ModelDraw.ecore");
			Resource program = null;
			String wodelecore;
			List<EPackage> wodelpackages = null;
			try {
				wodelecore = FileLocator.resolve(wodelURL).getFile();
				wodelpackages = ModelManager.loadMetaModel(wodelecore);
				program = ModelManager.loadModel(wodelpackages, outputPath + "/" + project.getName() + "_draw.model");
			} catch (ModelNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (MetaModelNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Injector injector = new ModelDrawStandaloneSetup().createInjectorAndDoEMFRegistration();
			InMemoryFileSystemAccess fsa = injector.getInstance(InMemoryFileSystemAccess.class);
			ModelDrawGenerator modelDrawGenerator = new ModelDrawGenerator();
			modelDrawGenerator.circuitGenerator = new ModelDrawCircuitGenerator();
			modelDrawGenerator.plantUMLGenerator = new ModelDrawPlantUMLGenerator();
			modelDrawGenerator.dotGenerator = new ModelDrawDotGenerator();
			modelDrawGenerator.doGenerate(program, fsa, null);
*/			
/*
			bundle = Platform.getBundle("wodeledu.models");
			wodelURL = bundle.getEntry("/model/EduTest.ecore");
			program = null;
			try {
				program = ModelManager.loadModel(wodelpackages, outputPath + "/" + project.getName() + "_test.model");
			} catch (ModelNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			injector = new EduTestStandaloneSetup().createInjectorAndDoEMFRegistration();
			fsa = injector.getInstance(InMemoryFileSystemAccess.class);
			EduTestGenerator eduTestGenerator = new EduTestGenerator();
			eduTestGenerator.webGenerator = new EduTestWebGenerator();
			eduTestGenerator.moodleGenerator = new EduTestMoodleGenerator();
			eduTestGenerator.androidAppGenerator = new EduTestAndroidAppGenerator();
			eduTestGenerator.iOSAppGenerator = new EduTestiOSAppGenerator();
			eduTestGenerator.doGenerate(program, fsa, null);

			compile(project);
*/
		}
	}
}
