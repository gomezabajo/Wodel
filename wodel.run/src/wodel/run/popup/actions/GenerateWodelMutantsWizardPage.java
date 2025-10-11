package wodel.run.popup.actions;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
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
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.Bundle;

import wodel.utils.exceptions.MetaModelNotFoundException;
import wodel.utils.exceptions.ModelNotFoundException;
import wodel.utils.manager.ModelManager;
import wodel.utils.manager.ProjectUtils;

public class GenerateWodelMutantsWizardPage extends WizardPage {

	public String inputFolder = null;
	public String outputFolder = null;
	public List<String> selectedWodelPrograms = new ArrayList<String>();
	public List<List<String>> selectedMutationOperators = new ArrayList<List<String>>();

	public boolean valid = false;
	
	private List<Integer> selectedIndices = new ArrayList<Integer>();
	private List<List<Integer>> selectedIndicesIndices = new ArrayList<List<Integer>>();

	private ISelection selection;
	
	private boolean all = false;
	
	private ScrolledComposite scrolledComposite;
	
	private Composite container;
	
	private int height;

	protected GenerateWodelMutantsWizardPage(ISelection selection) {
		super("wodelPage");
		setTitle("Generate Wodel Mutants Wizard Parameters");
		setDescription("Generate Wodel Mutants Wizard Parameters");
		this.selection = selection;
	}
	
	/**
	 * Tests if the current workbench selection is a suitable container to use.
	 */
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
	
	/**
	 * @see IDialogPage#createControl(Composite)
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
		
		String wodelPath = Platform.getLocation().toFile().getPath() + "/" + ProjectUtils.getProject().getName() + "/src";
		List<String> wodelPrograms = new ArrayList<String>();
		File wodelFolder = new File(wodelPath);
		for (File file : wodelFolder.listFiles()) {
			if (file.getName().endsWith(".mutator")) {
				String wodelProgram = file.getName();
				wodelPrograms.add(wodelProgram);
			}
		}
		
		List<List<String>> mutationOperators = new ArrayList<List<String>>();
		for (String wodelProgram : wodelPrograms) {
			String filename = wodelProgram;
			String xmiFilename = ModelManager.getOutputPath() + "/" + filename.replaceAll(".mutator", ".model");
			Bundle bundle = Platform.getBundle("wodel.models");
			List<EPackage> wodelpackages = null;
			URL fileURL = bundle.getEntry("/model/MutatorEnvironment.ecore");
			try {
				String ecore = FileLocator.resolve(fileURL).getFile();
				wodelpackages = ModelManager.loadMetaModel(ecore);
			} catch (MetaModelNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Resource wodelLocal = null;
			if (wodelpackages != null) {
				try {
					wodelLocal = ModelManager.loadModel(wodelpackages, xmiFilename);
				} catch (ModelNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			List<EObject> mutatorBlocks = ModelManager.getObjectsOfType("Block", wodelLocal);
			List<String> mutatorNames = new ArrayList<String>();
			for (EObject mutatorBlock : mutatorBlocks) {
				Object oName = ModelManager.getAttribute("name", mutatorBlock);
				if (oName != null && oName instanceof String) {
					String name = (String) oName;
					if (!name.isEmpty()) {
						mutatorNames.add(name);
					}
				}
			}
			mutationOperators.add(mutatorNames);
		}
		List<String> wodelProgramNames = new ArrayList<String>();
		for (String wodelProgram : wodelPrograms) {
			wodelProgramNames.add(wodelProgram.replace(".mutator", ""));
		}
		if (selectedMutationOperators.size() == 0) {
			for (int i = 0; i < wodelProgramNames.size(); i++) {
				selectedMutationOperators.add(new ArrayList<String>());
			}
		}
		if (selectedIndicesIndices.size() == 0) {
			for (int i = 0; i < wodelProgramNames.size(); i++) {
				selectedIndicesIndices.add(new ArrayList<Integer>());
			}
		}
		final List<String> finalWodelProgramNames = wodelProgramNames;
		final List<List<String>> finalMutationOperators = mutationOperators;

		final Composite contents = new Group(container, SWT.FILL);
		contents.setLayout(new GridLayout(1, false));
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalAlignment = SWT.FILL;
		contents.setLayoutData(gd);
		    
		Group settings = new Group(contents, SWT.FILL);
		GridLayout layout = new GridLayout();
		settings.setLayout(layout);
		layout.numColumns = 2;
		layout.verticalSpacing = 9;
		settings.setText("&Settings");
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalAlignment = SWT.FILL;
		settings.setLayoutData(gd);
		
		valid = false;
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		Button selectAll = new Button(shell, SWT.CHECK);
		selectAll.setText("Select &all:");
		selectAll.setSelection(all);
		selectAll.addSelectionListener(new SelectionAdapter() {
			@Override
		    public void widgetSelected(SelectionEvent e)
		    {
		        Button button = (Button) e.widget;
		        all = button.getSelection();
	        	selectedIndices.clear();
	        	selectedWodelPrograms.clear();
	        	for (int i = 0; i < selectedIndicesIndices.size(); i++) {
	        		selectedIndicesIndices.get(i).clear();
	        		selectedMutationOperators.get(i).clear();
	        	}
		        if (all == true) {
		        	for (int i = 0; i < finalWodelProgramNames.size(); i++) {
		        		selectedIndices.add(i);
		        	}
	        		selectedWodelPrograms.addAll(finalWodelProgramNames);
		        	int i = 0;
		        	for (List<String> mutationOps : finalMutationOperators) {
		        		List<Integer> selectedIndexIndices = new ArrayList<Integer>();
		        		for (int j = 0; j < mutationOps.size(); j++) {
		        			selectedIndexIndices.add(j);
		        		}
		        		selectedIndicesIndices.set(i, selectedIndexIndices);
		        		selectedMutationOperators.get(i).addAll(mutationOps);
			        	i++;
		        	}
		        }
		        dialogChanged();
				setControls();
		    }
		});
		selectAll.setParent(settings);
		
		Label separator = new Label(settings, SWT.HORIZONTAL);
		separator.setLayoutData(new GridData(SWT.PUSH | SWT.FILL, SWT.CENTER, true, false, 2, 1));
		Label label = new Label(settings, SWT.NULL);
		label.setText("&Input folder:");
		if (inputFolder != null) {
			label = new Label(settings, SWT.NONE);
			label.setText(inputFolder.replace("\\", "/"));
			label.addMouseTrackListener((MouseTrackListener) new MyMouseTrackAdapter());
		}
		Button button = new Button(settings, SWT.NONE);
		button.setText("Select...");
		button.addSelectionListener(new FolderSelectionAdapter(false));
		button.addMouseTrackListener((MouseTrackListener) new MyMouseTrackAdapter());
		separator = new Label(settings, SWT.HORIZONTAL);
		separator.setLayoutData(new GridData(SWT.PUSH | SWT.FILL, SWT.CENTER, true, false, 2, 1));
		label = new Label(settings, SWT.NULL);
		label.setText("&Output folder:");
		if (outputFolder != null) {
			label = new Label(settings, SWT.NONE);
			label.setText(outputFolder.replace("\\", "/"));
			label.addMouseTrackListener((MouseTrackListener) new MyMouseTrackAdapter());
		}
		button = new Button(settings, SWT.NONE);
		button.setText("Select...");
		button.addSelectionListener(new FolderSelectionAdapter(true));
		button.addMouseTrackListener((MouseTrackListener) new MyMouseTrackAdapter());
		
		separator = new Label(settings, SWT.HORIZONTAL);
		separator.setLayoutData(new GridData(SWT.PUSH | SWT.FILL, SWT.CENTER, true, false, 2, 1));
		label = new Label(settings, SWT.NULL);
		label.setText("Select &wodel program(s):");
		org.eclipse.swt.widgets.List wodelProgramSelector = new org.eclipse.swt.widgets.List(settings, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
		for (String wodelProgram : finalWodelProgramNames) {
			wodelProgramSelector.add(wodelProgram);
		}
		for (int selectedIndex : selectedIndices) {
			wodelProgramSelector.select(selectedIndex);
		}
		
		wodelProgramSelector.addSelectionListener(new SelectionAdapter() {
    		@Override
		    public void widgetSelected(SelectionEvent e)
		    {
    			selectedWodelPrograms.clear();
    			selectedIndices.clear();
    			org.eclipse.swt.widgets.List list = (org.eclipse.swt.widgets.List) e.widget;
    			int[] selectionIndices = list.getSelectionIndices();
   				for (int i = 0; i < selectionIndices.length; i++) {
   					selectedWodelPrograms.add(finalWodelProgramNames.get(selectionIndices[i]));
   					selectedIndices.add(selectionIndices[i]);
    			}
   				dialogChanged();
   				setControls();
		    }
    	});
		
		separator = new Label(settings, SWT.HORIZONTAL);
		separator.setLayoutData(new GridData(SWT.PUSH | SWT.FILL, SWT.CENTER, true, false, 2, 1));
		
		List<org.eclipse.swt.widgets.List> mutationOperatorSelectors = new ArrayList<org.eclipse.swt.widgets.List>();
		for (int i = 0; i < selectedIndices.size(); i++) {
			separator = new Label(settings, SWT.HORIZONTAL);
			separator.setLayoutData(new GridData(SWT.PUSH | SWT.FILL, SWT.CENTER, true, false, 2, 1));
			label = new Label(settings, SWT.NULL);
			label.setText("Select " + finalWodelProgramNames.get(selectedIndices.get(i)) + " mutation operator(s):");
			org.eclipse.swt.widgets.List mutationOperatorSelector = new org.eclipse.swt.widgets.List(settings, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
			for (String mutationOperator : finalMutationOperators.get(selectedIndices.get(i))) {
				mutationOperatorSelector.add(mutationOperator);
			}
			mutationOperatorSelectors.add(mutationOperatorSelector);
		}
		for (int i = 0; i < selectedIndices.size(); i++) {
			for (int j = 0; j < selectedIndicesIndices.get(i).size(); j++) {
				mutationOperatorSelectors.get(i).select(selectedIndicesIndices.get(i).get(j));
			}
		}
		for (int i = 0; i < mutationOperatorSelectors.size(); i++) {
			final int j = i;
			final int index = selectedIndices.get(j);
			mutationOperatorSelectors.get(j).addSelectionListener(new SelectionAdapter() {
				@Override
			    public void widgetSelected(SelectionEvent e)
			    {
	    			selectedMutationOperators.get(j).clear();
					selectedIndicesIndices.get(j).clear();
	    			org.eclipse.swt.widgets.List list = (org.eclipse.swt.widgets.List) e.widget;
	    			int[] selectionIndices = list.getSelectionIndices();
	   				for (int k = 0; k < selectionIndices.length; k++) {
	   					selectedMutationOperators.get(j).add(finalMutationOperators.get(index).get(selectionIndices[k]));
	   					selectedIndicesIndices.get(j).add(selectionIndices[k]);
	    			}
	   				dialogChanged();
	   				setControls();
			    }
			});
		}
		
		if (inputFolder != null && outputFolder != null) {
			for (int i = 0; i < selectedMutationOperators.size(); i++) {
				if (selectedMutationOperators.get(i).size() > 0) {
					valid = true;
					break;
				}
			}
		}
		if (valid == true) {
			updateStatus(null);
		}

		contents.layout();
		scrolledComposite.setContent(container);
		scrolledComposite.setMinSize(container.computeSize(SWT.DEFAULT,	SWT.DEFAULT));
	}
	
	/**
	 * Ensures that both text fields are set.
	 */
	private void dialogChanged() {
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

	private class FolderSelectionAdapter extends SelectionAdapter {
		
		public String folder = null;
		private boolean io = false;

		FolderSelectionAdapter(boolean io) {
			this.io = io;
		}

		@Override
		public void widgetSelected(SelectionEvent e) {
			folder = null;
			DirectoryDialog dlg = new DirectoryDialog(getShell(), SWT.OPEN);
			folder = dlg.open();
			if (folder != null) {
				File folderFile = new File(folder);
				boolean validFolder = folderFile.exists() && folderFile.isDirectory();
				if (validFolder == true) {
					if (this.io == false) {
						inputFolder = folder;
					}
					if (this.io == true) {
						outputFolder = folder;
					}
				}
				if (inputFolder != null && outputFolder != null) {
					for (int i = 0; i < selectedMutationOperators.size(); i++) {
						if (selectedMutationOperators.get(i).size() > 0) {
							valid = true;
							break;
						}
					}
				}
			}
			if (valid == true) {
				updateStatus(null);
			}
			setControls();
			IWizardContainer container = getContainer();
			container.updateButtons();
		}
	}
}
