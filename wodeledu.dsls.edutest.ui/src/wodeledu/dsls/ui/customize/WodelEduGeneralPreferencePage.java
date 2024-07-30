package wodeledu.dsls.ui.customize;

import wodel.utils.manager.ModelManager;
import wodel.utils.manager.ProjectUtils;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
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
import org.eclipse.xtext.generator.InMemoryFileSystemAccess;
import org.eclipse.xtext.ui.editor.preferences.LanguageRootPreferencePage;
import org.eclipse.xtext.ui.editor.preferences.fields.LabelFieldEditor;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

import wodel.utils.exceptions.MetaModelNotFoundException;
import wodel.utils.exceptions.ModelNotFoundException;
import wodeledu.dsls.EduTestStandaloneSetup;
import wodeledu.dsls.ModelDrawStandaloneSetup;
import wodeledu.dsls.generator.edutest.EduTestAndroidAppGenerator;
import wodeledu.dsls.generator.edutest.EduTestGenerator;
import wodeledu.dsls.generator.edutest.EduTestMoodleGenerator;
import wodeledu.dsls.generator.edutest.EduTestWebGenerator;
import wodeledu.dsls.generator.edutest.EduTestiOSAppGenerator;
import wodeledu.dsls.generator.modeldraw.ModelDrawCircuitGenerator;
import wodeledu.dsls.generator.modeldraw.ModelDrawDotGenerator;
import wodeledu.dsls.generator.modeldraw.ModelDrawGenerator;
import wodeledu.dsls.generator.modeldraw.ModelDrawPlantUMLGenerator;

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
		if (folder != null && folder.isEmpty()) {
			folder = null;
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
    	getPreferenceStore().setDefault("Wodel-Edu mode", "Moodle");
    	getPreferenceStore().setDefault("Model-Draw mode", "Dot");
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
