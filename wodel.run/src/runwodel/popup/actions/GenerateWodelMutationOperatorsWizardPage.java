package runwodel.popup.actions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

public class GenerateWodelMutationOperatorsWizardPage extends WizardPage {

	private ISelection selection;

	private List<EPackage> mutatorPackages = null;
	
	private List<EPackage> packages = null;

	public String strategyClass = "random";
	
	private boolean all = false;
	
	private ScrolledComposite scrolledComposite;
	
	private Composite container;
	
	private int height;
	
	public boolean valid = false;

	public List<String> selectedWodelOperators = new ArrayList<String>();
	private List<Integer> selectedIndices = new ArrayList<Integer>();


	protected GenerateWodelMutationOperatorsWizardPage(ISelection selection, List<EPackage> mutatorPackages, Resource model, List<EPackage> packages) {
		super("wodelPage");
		setTitle("Generate Wodel Mutation Operators Wizard Parameters");
		setDescription("Generate Wodel Mutation Operators Wizard Parameters");
		this.selection = selection;
		this.mutatorPackages = mutatorPackages;
		this.packages = packages;
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

		List<String> wodelOperatorsNames = new ArrayList<String>();
		
		wodelOperatorsNames.add("create");
		wodelOperatorsNames.add("clone");
		wodelOperatorsNames.add("modify");
		wodelOperatorsNames.add("remove");
		wodelOperatorsNames.add("select");
		wodelOperatorsNames.add("retype");

		final List<String> finalWodelOperatorsNames = wodelOperatorsNames;

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
	        	selectedWodelOperators.clear();
		        if (all == true) {
		        	for (int i = 0; i < finalWodelOperatorsNames.size(); i++) {
		        		selectedIndices.add(i);
		        	}
	        		selectedWodelOperators.addAll(finalWodelOperatorsNames);
		        }
    			if (selectedIndices.size() > 0) {
    				valid = true;
    			}
    			else {
    				valid = false;
    			}
		        dialogChanged();
				setControls();
		    }
		});
		selectAll.setParent(settings);
		
		Label separator = new Label(settings, SWT.HORIZONTAL);
		separator.setLayoutData(new GridData(SWT.PUSH | SWT.FILL, SWT.CENTER, true, false, 2, 1));
		separator = new Label(settings, SWT.HORIZONTAL);
		separator.setLayoutData(new GridData(SWT.PUSH | SWT.FILL, SWT.CENTER, true, false, 2, 1));
		Label label = new Label(settings, SWT.NULL);
		label = new Label(settings, SWT.NULL);
		label.setText("Select &wodel mutation operator(s):");
		org.eclipse.swt.widgets.List wodelOperatorSelector = new org.eclipse.swt.widgets.List(settings, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
		for (String wodelOperator : finalWodelOperatorsNames) {
			wodelOperatorSelector.add(wodelOperator);
		}
		for (int selectedIndex : selectedIndices) {
			wodelOperatorSelector.select(selectedIndex);
		}
		
		wodelOperatorSelector.addSelectionListener(new SelectionAdapter() {
    		@Override
		    public void widgetSelected(SelectionEvent e)
		    {
    			selectedWodelOperators.clear();
    			selectedIndices.clear();
    			org.eclipse.swt.widgets.List list = (org.eclipse.swt.widgets.List) e.widget;
    			int[] selectionIndices = list.getSelectionIndices();
    			if (selectionIndices.length > 0) {
    				valid = true;
    			}
    			else {
    				valid = false;
    			}
   				for (int i = 0; i < selectionIndices.length; i++) {
   					selectedWodelOperators.add(finalWodelOperatorsNames.get(selectionIndices[i]));
   					selectedIndices.add(selectionIndices[i]);
    			}
   				dialogChanged();
   				setControls();
		    }
    	});
		
		separator = new Label(settings, SWT.HORIZONTAL);
		separator.setLayoutData(new GridData(SWT.PUSH | SWT.FILL, SWT.CENTER, true, false, 2, 1));
		
		label = new Label(settings, SWT.NULL);
		label = new Label(settings, SWT.NULL);
		label.setText("Select mutation operator(s) &strategy:");
		
		Button[] radios = new Button[2];

	    radios[0] = new Button(settings, SWT.RADIO);
	    radios[0].setSelection(true);
	    radios[0].setText("Random");

	    radios[1] = new Button(settings, SWT.RADIO);
	    radios[1].setText("Complete");
		
	    radios[0].addSelectionListener(new SelectionAdapter() {
			@Override
		    public void widgetSelected(SelectionEvent e)
		    {
		        Button button = (Button) e.widget;
		        strategyClass = button.getText().toLowerCase();
		        dialogChanged();
				setControls();
		    }
		});
		radios[0].setParent(settings);
	    radios[1].addSelectionListener(new SelectionAdapter() {
			@Override
		    public void widgetSelected(SelectionEvent e)
		    {
		        Button button = (Button) e.widget;
		        strategyClass = button.getText().toLowerCase();
		        dialogChanged();
				setControls();
		    }
		});
		radios[1].setParent(settings);

		separator = new Label(settings, SWT.HORIZONTAL);
		separator.setLayoutData(new GridData(SWT.PUSH | SWT.FILL, SWT.CENTER, true, false, 2, 1));
		
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
}
