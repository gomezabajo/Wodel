/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package wodel.synthesizer.generator;

import manager.ModelManager;
import manager.MutatorUtils;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardContainer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.Bundle;

import wodel.synthesizer.utils.MultiLineStringFieldEditor;
import exceptions.MetaModelNotFoundException;
import exceptions.ModelNotFoundException;

/**
 * @author Pablo Gomez-Abajo - Wodel seed models synthesizer Wizard page.
 * 
 */

public class GenerateWodelWizardPage extends WizardPage {
	
	private String[] extensions;
	public String file;
	private Label label;
	private Label fileLabel;
	private Label descriptionLabel;
	private Button button;
	private StringFieldEditor numberOfSeedsFieldEditor;
	private MultiLineStringFieldEditor customOCLFieldEditor;
	private Button forceSeedRoot;
	private org.eclipse.swt.widgets.List mutatorBlockSelector;
	private Label separator;
	private Composite container;
	private ScrolledComposite scrolledComposite;
	private int height;

	private ISelection selection;
	private String metamodel;

	/**
	 * Constructor for GenerateWodelWizardPage.
	 * 
	 * @param selection
	 */
	public GenerateWodelWizardPage(ISelection selection) {
		super("wizardPage");
		setTitle("Seed Models Generator");
		setDescription("This wizard generates seed models.");
		this.selection = selection;
		this.metamodel = ModelManager.getMetaModel();
		IFile mutatorFile = GenerateWodelWizard.file;
		Bundle bundle = Platform.getBundle("wodel.models");
		URL mutatorURL = bundle.getEntry("/models/MutatorEnvironment.ecore");
		blockNames.add("*");
		try {
			String mutatorecore = FileLocator.resolve(mutatorURL).getFile();
			List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
			Resource model = ModelManager.loadModel(mutatorpackages, ModelManager.getOutputPath() + "/" + mutatorFile.getName().replace(".mutator", ".model"));
			List<EObject> blocks = MutatorUtils.getBlocks(model);
			for (EObject block : blocks) {
				String name = ModelManager.getStringAttribute("name", block);
				blockNames.add(name);
			}
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
	
	public boolean valid = false;
	
	public int numSeeds = 3;
	
	public String customOCL = "";
	
	public boolean forceRoot = true;
	
	private List<String> blockNames = new ArrayList<String>();
	
	public List<String> selectedBlockNames = new ArrayList<String>();

	/**
	 * Create contents of the wizard.
	 * 
	 * @param parent
	 */
	@Override
	public void createControl(Composite parent) {
		scrolledComposite = new ScrolledComposite(parent, SWT.BORDER
				| SWT.V_SCROLL);
		setControl(scrolledComposite);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		Composite container = new Composite(scrolledComposite, SWT.NONE);
		container.setLayout(new GridLayout(2, false));
		scrolledComposite.setContent(container);
		scrolledComposite.setMinSize(container.computeSize(SWT.DEFAULT,
				SWT.DEFAULT));

		this.container = container;
		
		initialize();
		dialogChanged();
		setControls();
	}

	public void setControls() {
		for (Control c : container.getChildren())
			c.dispose();

		numberOfSeedsFieldEditor = new StringFieldEditor("Number of seed models", "Number of seed models", 8, container);
		numberOfSeedsFieldEditor.setStringValue(String.format("%d", numSeeds));
		numberOfSeedsFieldEditor.setPropertyChangeListener(new IPropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent event) {
				numSeeds = Integer.parseInt(event.getNewValue().toString()); 
			}
		});
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		forceSeedRoot = new Button(shell, SWT.CHECK);
		forceSeedRoot.setText("Force the root object");
		forceSeedRoot.setSelection(true);
		forceSeedRoot.addSelectionListener(new SelectionAdapter() {
			@Override
		    public void widgetSelected(SelectionEvent e)
		    {
		        Button button = (Button) e.widget;
		        forceRoot = button.getSelection();
		    }
		});
    	
		Label mutatorBlockSelectorLabel = new Label(container, SWT.NONE);
		mutatorBlockSelectorLabel.setText("Select mutation operator(s)");
    	mutatorBlockSelector = new org.eclipse.swt.widgets.List(container, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
    	for (String blockName : blockNames) {
    		mutatorBlockSelector.add(blockName);
    	}
    	mutatorBlockSelector.addSelectionListener(new SelectionAdapter() {
    		@Override
		    public void widgetSelected(SelectionEvent e)
		    {
    			org.eclipse.swt.widgets.List list = (org.eclipse.swt.widgets.List) e.widget;
    			int[] selectionIndices = list.getSelectionIndices();
    			if (selectionIndices[0] == 0) {
    				selectedBlockNames.add(blockNames.get(0));
    			}
    			else {
    				for (int i = 0; i < selectionIndices.length; i++) {
    					selectedBlockNames.add(blockNames.get(selectionIndices[i]));
    				}
    			}
		    }
    	});

		forceSeedRoot.setParent(container);
		
		separator = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
		separator.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));

		customOCLFieldEditor = new MultiLineStringFieldEditor("Add OCL constraint", "Add OCL constraint", 20, container);
		customOCLFieldEditor.setStringValue(customOCL);
		customOCLFieldEditor.setPropertyChangeListener(new IPropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent event) {
				// TODO Auto-generated method stub
				customOCL = event.getNewValue().toString();
			}
		});
		separator = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
		separator.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));

		if (file != null) {
			label = new Label(container, SWT.NONE);
			label.setText(file.substring(file.lastIndexOf("\\") + 1));
			label.addMouseTrackListener((MouseTrackListener) new MyMouseTrackAdapter());
		}
		button = new Button(container, SWT.NONE);
		button.setText("Load file");
		button.addSelectionListener(new FileSelectionAdapter());
		button.addMouseTrackListener((MouseTrackListener) new MyMouseTrackAdapter());
		if (file == null) {
			descriptionLabel = new Label(container, SWT.WRAP);
			descriptionLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
					false, 2, 1));
			descriptionLabel.setText("Select the initial model file.");
			fileLabel = new Label(container, SWT.NONE);
			fileLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
			fileLabel.setText("");
		}
		separator = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
		separator.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));

		container.layout();
		scrolledComposite.setContent(container);
		scrolledComposite.setMinSize(container.computeSize(SWT.DEFAULT,	SWT.DEFAULT));
	}

	protected void setFileExtensions(String[] extensions) {
		this.extensions = extensions;
	}

	protected String getFile() {

		return file;
	}
	
	/**
	 * Ensures that both text fields are set.
	 */

	private void dialogChanged() {
		updateStatus(null);
	}
	
	private void updateStatus(String message) {
		setErrorMessage(message);
		setPageComplete(message == null);
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

	private class FileSelectionAdapter extends SelectionAdapter {

		FileSelectionAdapter() {
		}

		@Override
		public void widgetSelected(SelectionEvent e) {
			file = null;
			FileDialog dlg = new FileDialog(getShell(), SWT.OPEN);
			dlg.setFilterNames(extensions);
			dlg.setFilterExtensions(extensions);
			file = dlg.open();
			if (file != null) {
				try {
					valid = ModelManager.validateModel(metamodel, file);
				} catch (MetaModelNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ModelNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (valid != true) {
					updateStatus("The model is not valid.");
				}
			}
			else {
				updateStatus(null);
			}
			setControls();
			IWizardContainer container = getContainer();
			container.updateButtons();
		}
	}
	
	private void initialize() {
		if (selection != null && selection.isEmpty() == false
				&& selection instanceof IStructuredSelection) {
			IStructuredSelection ssel = (IStructuredSelection) selection;
			if (ssel.size() > 1)
				return;
			Object obj = ssel.getFirstElement();
			if (obj instanceof IResource) {
				IContainer container;
				if (obj instanceof IContainer)
					container = (IContainer) obj;
				else
					container = ((IResource) obj).getParent();
			}
		}
	}
}
