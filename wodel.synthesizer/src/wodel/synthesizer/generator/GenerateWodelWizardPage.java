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

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
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

import wodel.synthesizer.utils.MultiLineStringFieldEditor;
import exceptions.MetaModelNotFoundException;
import exceptions.ModelNotFoundException;


public class GenerateWodelWizardPage extends WizardPage {

	private String[] extensions;
	public String file;
	private Label label;
	private Label fileLabel;
	private Label descriptionLabel;
	private Button button;
	private StringFieldEditor numberOfSeedsFieldEditor;
	private MultiLineStringFieldEditor customOCLFieldEditor;
	private Label separator;
	private Composite container;
	private ScrolledComposite scrolledComposite;
	private int height;

	private ISelection selection;
	private String metamodel;

	/**
	 * Constructor for WodelWizardPage.
	 * 
	 * @param pageName
	 */
	public GenerateWodelWizardPage(ISelection selection) {
		super("wizardPage");
		setTitle("Seed Models Generator");
		setDescription("This wizard generates seed models.");
		this.selection = selection;
		this.metamodel = ModelManager.getMetaModel();
	}
	
	public boolean valid = false;
	
	public int numSeeds = 5;
	
	public String customOCL = "";

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
		separator = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
		separator.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));

		customOCLFieldEditor = new MultiLineStringFieldEditor("Add OCL constraint", "Add OCL constraint", 20, container);
		customOCLFieldEditor.setStringValue(customOCL);
		customOCLFieldEditor.setPropertyChangeListener(new IPropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent event) {
				// TODO Auto-generated method stub
				customOCL = event.getNewValue().toString();
				System.out.println(customOCL);
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
			}
			if (valid != true) {
				updateStatus("The model is not valid.");
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
