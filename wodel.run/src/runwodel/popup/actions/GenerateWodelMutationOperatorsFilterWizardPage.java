package runwodel.popup.actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;

import exceptions.ModelNotFoundException;
import manager.EMFComparison;
import manager.ModelManager;

public class GenerateWodelMutationOperatorsFilterWizardPage extends WizardPage {
	
	private IFile file = null;
	
	private String metamodel = null;

	private ISelection selection;

	private List<EPackage> mutatorPackages = null;
	
	private List<EPackage> packages = null;

	private boolean all = false;
	
	private ScrolledComposite scrolledComposite;
	
	private Composite container;
	
	private int height;
	
	public boolean valid = false;

	public List<String> selectedElements = new ArrayList<String>();
	public List<List<String>> selectedWithClassElements = new ArrayList<List<String>>();
	public List<List<Object>> selectedWithClassValues = new ArrayList<List<Object>>();
	public List<List<String>> selectedWhereClassElements = new ArrayList<List<String>>();
	public List<List<Object>> selectedWhereClassValues = new ArrayList<List<Object>>();

	private List<Integer> selectedIndices = new ArrayList<Integer>();
	private List<List<Integer>> selectedWithIndicesIndices = new ArrayList<List<Integer>>();
	private List<List<Integer>> selectedWhereIndicesIndices = new ArrayList<List<Integer>>();

	private List<Control> controls = new ArrayList<Control>();


	protected GenerateWodelMutationOperatorsFilterWizardPage(ISelection selection, String metamodel, List<EPackage> mutatorPackages, Resource model, List<EPackage> packages) {
		super("wodelPage");
		setTitle("Generate Wodel Mutation Operators Wizard Elements");
		setDescription("Generate Wodel Mutation Operators Wizard Elements");
		this.selection = selection;
		if (selection instanceof IStructuredSelection && ((IStructuredSelection) selection).getFirstElement() instanceof IFile) {
			this.file = (IFile) ((IStructuredSelection) selection).getFirstElement();
		}
		this.metamodel = metamodel;
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
		
		for (Control c : controls) {
			c.dispose();
		}
		controls.clear();
		
		if (file == null) {
			return;
		}
		String xmiWodelFilename = ModelManager.getOutputPath() + "/" + file.getName().replaceAll(".mutator", ".model");
		Resource wodel = null;
		try {
			if (mutatorPackages != null) {
				wodel = ModelManager.loadModel(mutatorPackages, xmiWodelFilename);
			}
		} catch (ModelNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<Resource> wodelModels = new ArrayList<Resource>();
		if (wodel != null) {
			wodelModels.addAll(ModelManager.getModels(metamodel, wodel));
		}

		List<String> wodelElementsNames = new ArrayList<String>();
		
		List<EClass> classes = ModelManager.getEClasses(packages);
		
		for (EClass cl : classes) {
			wodelElementsNames.add(cl.getName());
		}
		
		List<List<EStructuralFeature>> wodelClassElementsValues = new ArrayList<List<EStructuralFeature>>();

		List<List<String>> wodelClassElementsNames = new ArrayList<List<String>>();
		
		List<List<List<Object>>> wodelClassObjectsValues = new ArrayList<List<List<Object>>>();
		
		for (EClass cl : classes) {
			List<String> wodelClassElements = new ArrayList<String>();
			List<EObject> allEObjects = new ArrayList<EObject>();
			for (Resource wodelModel : wodelModels) {
				List<EObject> classEObjects = ModelManager.getObjectsOfType(cl.getName(), wodelModel);
				for (EObject clEObject : classEObjects) {
					boolean found = false;
					for (EObject eObject : allEObjects) {
						if (EMFComparison.equals(clEObject, eObject)) {
							found = true;
							break;
						}
					}
					if (found == false) {
						allEObjects.add(clEObject);
					}
				}
			}
			List<EStructuralFeature> wodelClassFeatures = new ArrayList<EStructuralFeature>();
			List<List<Object>> wodelClassObjectValues = new ArrayList<List<Object>>();
			for (EStructuralFeature sf : cl.getEAllStructuralFeatures()) {
				wodelClassElements.add(sf.getName());
				wodelClassFeatures.add(sf);
				List<Object> wodelObjectValues = new ArrayList<Object>();
				for (EObject eObject : allEObjects) {
					EStructuralFeature currentsf = eObject.eClass().getEStructuralFeature(sf.getName());
					if (currentsf != null) {
						Object value = eObject.eGet(currentsf, true);
						if (value != null && !((value instanceof EObject) || (value instanceof List<?>))) {
							boolean found = false;
							for (Object clObjectValue : wodelObjectValues) {
								if (value.equals(clObjectValue)) {
									found = true;
									break;
								}
							}
							if (found == false) {
								wodelObjectValues.add(value);
							}
						}
					}
				}
				Collections.sort(wodelObjectValues, new Comparator<Object>() {

					@Override
					public int compare(Object o1, Object o2) {
						return o1.toString().compareTo(o2.toString());
					}
					
				});
				wodelClassObjectValues.add(wodelObjectValues);
			}
			wodelClassObjectsValues.add(wodelClassObjectValues);
			wodelClassElementsNames.add(wodelClassElements);
			wodelClassElementsValues.add(wodelClassFeatures);
		}
		
		final List<String> finalWodelElementsNames = wodelElementsNames;

		final List<List<String>> finalWodelClassElementsNames = wodelClassElementsNames;
		
		final List<List<List<Object>>> finalWodelClassObjectsValues = wodelClassObjectsValues;

		if (selectedWithClassElements.size() == 0) {
			for (int i = 0; i < wodelElementsNames.size(); i++) {
				selectedWithClassElements.add(new ArrayList<String>());
			}
		}
		if (selectedWithClassValues.size() == 0) {
			for (int i = 0; i < wodelElementsNames.size(); i++) {
				selectedWithClassValues.add(new ArrayList<Object>());
			}
		}
		if (selectedWithIndicesIndices.size() == 0) {
			for (int i = 0; i < wodelElementsNames.size(); i++) {
				selectedWithIndicesIndices.add(new ArrayList<Integer>());
			}
		}
		if (selectedWhereClassElements.size() == 0) {
			for (int i = 0; i < wodelElementsNames.size(); i++) {
				selectedWhereClassElements.add(new ArrayList<String>());
			}
		}
		if (selectedWhereClassValues.size() == 0) {
			for (int i = 0; i < wodelElementsNames.size(); i++) {
				selectedWhereClassValues.add(new ArrayList<Object>());
			}
		}
		if (selectedWhereIndicesIndices.size() == 0) {
			for (int i = 0; i < wodelElementsNames.size(); i++) {
				selectedWhereIndicesIndices.add(new ArrayList<Integer>());
			}
		}

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
	        	selectedElements.clear();
	        	for (int i = 0; i < selectedWithIndicesIndices.size(); i++) {
	        		selectedWithIndicesIndices.get(i).clear();
	        		selectedWithClassElements.get(i).clear();
	        	}
	        	for (int i = 0; i < selectedWhereIndicesIndices.size(); i++) {
	        		selectedWhereIndicesIndices.get(i).clear();
	        		selectedWhereClassElements.get(i).clear();
	        	}
		        if (all == true) {
		        	for (int i = 0; i < finalWodelElementsNames.size(); i++) {
		        		selectedIndices.add(i);
		        	}
	        		selectedElements.addAll(finalWodelElementsNames);
		        	int i = 0;
		        	for (List<String> featuresNames : finalWodelClassElementsNames) {
		        		List<Integer> selectedWithIndexIndices = new ArrayList<Integer>();
		        		for (int j = 0; j < featuresNames.size(); j++) {
		        			selectedWithIndexIndices.add(j);
		        		}
		        		selectedWithIndicesIndices.set(i, selectedWithIndexIndices);
		        		List<Integer> selectedWhereIndexIndices = new ArrayList<Integer>();
		        		for (int j = 0; j < featuresNames.size(); j++) {
		        			selectedWhereIndexIndices.add(j);
		        		}
		        		selectedWhereIndicesIndices.set(i, selectedWhereIndexIndices);
		        		selectedWithClassElements.get(i).addAll(featuresNames);
		        		selectedWhereClassElements.get(i).addAll(featuresNames);
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
		separator = new Label(settings, SWT.HORIZONTAL);
		separator.setLayoutData(new GridData(SWT.PUSH | SWT.FILL, SWT.CENTER, true, false, 2, 1));
		Label label = new Label(settings, SWT.NULL);
		label.setText("Select &class(es):");
		org.eclipse.swt.widgets.List wodelElementsSelector = new org.eclipse.swt.widgets.List(settings, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
		for (String wodelElement : finalWodelElementsNames) {
			wodelElementsSelector.add(wodelElement);
		}
		for (int selectedIndex : selectedIndices) {
			wodelElementsSelector.select(selectedIndex);
		}
		
		wodelElementsSelector.addSelectionListener(new SelectionAdapter() {
    		@Override
		    public void widgetSelected(SelectionEvent e)
		    {
    			selectedElements.clear();
    			selectedIndices.clear();
    			org.eclipse.swt.widgets.List list = (org.eclipse.swt.widgets.List) e.widget;
    			int[] selectionIndices = list.getSelectionIndices();
   				for (int i = 0; i < selectionIndices.length; i++) {
   					selectedElements.add(finalWodelElementsNames.get(selectionIndices[i]));
   					selectedIndices.add(selectionIndices[i]);
    			}
   				dialogChanged();
   				setControls();
		    }
    	});
		
		separator = new Label(settings, SWT.HORIZONTAL);
		separator.setLayoutData(new GridData(SWT.PUSH | SWT.FILL, SWT.CENTER, true, false, 2, 1));
		
		List<org.eclipse.swt.widgets.List> wodelClassWhereElementsSelectors = new ArrayList<org.eclipse.swt.widgets.List>();
		for (int i = 0; i < selectedIndices.size(); i++) {
			separator = new Label(settings, SWT.HORIZONTAL);
			separator.setLayoutData(new GridData(SWT.PUSH | SWT.FILL, SWT.CENTER, true, false, 2, 1));
			label = new Label(settings, SWT.NULL);
			label.setText("Select " + wodelElementsNames.get(selectedIndices.get(i)) + " where clause feature(s):");
			org.eclipse.swt.widgets.List wodelClassWhereElementsSelector = new org.eclipse.swt.widgets.List(settings, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
			for (String wodelElement : finalWodelClassElementsNames.get(selectedIndices.get(i))) {
				wodelClassWhereElementsSelector.add(wodelElement);
			}
			wodelClassWhereElementsSelectors.add(wodelClassWhereElementsSelector);
			if (wodelClassElementsValues.size() > selectedIndices.get(i)) {
				List<EStructuralFeature> featuresList = wodelClassElementsValues.get(selectedIndices.get(i));
				for (int j = 0; j < selectedWhereIndicesIndices.get(i).size(); j++) {
					if (featuresList.size() > selectedWhereIndicesIndices.get(i).get(j)) {
						EStructuralFeature feature = featuresList.get(selectedWhereIndicesIndices.get(i).get(j));
						if (feature.getEType().getName().equals("EBoolean")) {
							Button featureButton = new Button(settings, SWT.CHECK);
							featureButton.setText(feature.getName() + ":");
							featureButton.setSelection(false);
							controls.add(featureButton);
							final int k = i;
							final int l = j;
							if (selectedWhereClassValues.get(k).size() <= l) {
								selectedWhereClassValues.get(k).add(false);
							}
							featureButton.addFocusListener(new FocusAdapter() {
								@Override
								public void focusLost(FocusEvent e) {
									if (e.widget instanceof Button) {
										Button btn = (Button) e.widget;
										boolean value = btn.getSelection();
										selectedWhereClassValues.get(k).set(l, value);
									}
									if (e.widget instanceof Text) {
										Text btn = (Text) e.widget;
										String value = btn.getText();
										selectedWhereClassValues.get(k).set(l, value);
									}
								}
							});
						}
						if (feature.getEType().getName().equals("EString")) {
							label = new Label(settings, SWT.NULL);
							label.setText(feature.getName() + ":");
							Combo combo = new Combo(settings, SWT.NONE);
							combo.setText("");
							controls.add(combo);
							for (int k = 0; k < finalWodelClassObjectsValues.get(selectedIndices.get(i)).get(selectedWhereIndicesIndices.get(i).get(j)).size(); k++) {
								combo.add(finalWodelClassObjectsValues.get(selectedIndices.get(i)).get(selectedWhereIndicesIndices.get(i).get(j)).get(k).toString());
							}
							final int k = i;
							final int l = j;
							if (selectedWhereClassValues.get(k).size() <= l) {
								selectedWhereClassValues.get(k).add("");
							}
							combo.addFocusListener(new FocusAdapter() {
								@Override
								public void focusLost(FocusEvent e) {
									if (e.widget instanceof Combo) {
										Combo c = (Combo) e.widget;
										String value = c.getText();
										selectedWhereClassValues.get(k).set(l, value);
									}
								}
							});
						}
						if (feature.getEType().getName().equals("EInt")) {
							label = new Label(settings, SWT.NULL);
							label.setText(feature.getName() + ":");
							Text featureText = new Text(settings, SWT.NONE);
							featureText.setText("0");
							controls.add(featureText);
							final int k = i;
							final int l = j;
							if (selectedWhereClassValues.get(k).size() <= l) {
								selectedWhereClassValues.get(k).add("0");
							}
							featureText.addFocusListener(new FocusAdapter() {
								@Override
								public void focusLost(FocusEvent e) {
									if (e.widget instanceof Button) {
										Button btn = (Button) e.widget;
										boolean value = btn.getSelection();
										selectedWhereClassValues.get(k).set(l, value);
									}
									if (e.widget instanceof Text) {
										Text btn = (Text) e.widget;
										String value = btn.getText();
										selectedWhereClassValues.get(k).set(l, value);
									}
								}
							});
						}
						if (feature.getEType().getName().equals("ELong")) {
							label = new Label(settings, SWT.NULL);
							label.setText(feature.getName() + ":");
							Text featureText = new Text(settings, SWT.NONE);
							featureText.setText("0");
							controls.add(featureText);
							final int k = i;
							final int l = j;
							if (selectedWhereClassValues.get(k).size() <= l) {
								selectedWhereClassValues.get(k).add("0");
							}
							featureText.addFocusListener(new FocusAdapter() {
								@Override
								public void focusLost(FocusEvent e) {
									if (e.widget instanceof Button) {
										Button btn = (Button) e.widget;
										boolean value = btn.getSelection();
										selectedWhereClassValues.get(k).set(l, value);
									}
									if (e.widget instanceof Text) {
										Text btn = (Text) e.widget;
										String value = btn.getText();
										selectedWhereClassValues.get(k).set(l, value);
									}
								}
							});
						}
						if (feature.getEType().getName().equals("EDouble")) {
							label = new Label(settings, SWT.NULL);
							label.setText(feature.getName() + ":");
							Text featureText = new Text(settings, SWT.NONE);
							featureText.setText("0.0");
							controls.add(featureText);
							final int k = i;
							final int l = j;
							if (selectedWhereClassValues.get(k).size() <= l) {
								selectedWhereClassValues.get(k).add("0.0");
							}
							featureText.addFocusListener(new FocusAdapter() {
								@Override
								public void focusLost(FocusEvent e) {
									if (e.widget instanceof Button) {
										Button btn = (Button) e.widget;
										boolean value = btn.getSelection();
										selectedWhereClassValues.get(k).set(l, value);
									}
									if (e.widget instanceof Text) {
										Text btn = (Text) e.widget;
										String value = btn.getText();
										selectedWhereClassValues.get(k).set(l, value);
									}
								}
							});
						}
						if (feature.getEType().getName().equals("EFloat")) {
							label = new Label(settings, SWT.NULL);
							label.setText(feature.getName() + ":");
							Text featureText = new Text(settings, SWT.NONE);
							featureText.setText("0.0");
							controls.add(featureText);
							final int k = i;
							final int l = j;
							if (selectedWhereClassValues.get(k).size() <= l) {
								selectedWhereClassValues.get(k).add("0.0");
							}
							featureText.addFocusListener(new FocusAdapter() {
								@Override
								public void focusLost(FocusEvent e) {
									if (e.widget instanceof Button) {
										Button btn = (Button) e.widget;
										boolean value = btn.getSelection();
										selectedWhereClassValues.get(k).set(l, value);
									}
									if (e.widget instanceof Text) {
										Text btn = (Text) e.widget;
										String value = btn.getText();
										selectedWhereClassValues.get(k).set(l, value);
									}
								}
							});
						}
					}
				}
			}
		}
		for (int i = 0; i < selectedIndices.size(); i++) {
			for (int j = 0; j < selectedWhereIndicesIndices.get(i).size(); j++) {
				wodelClassWhereElementsSelectors.get(i).select(selectedWhereIndicesIndices.get(i).get(j));
			}
		}
		for (int i = 0; i < wodelClassWhereElementsSelectors.size(); i++) {
			final int j = i;
			final int index = selectedIndices.get(j);
			wodelClassWhereElementsSelectors.get(j).addSelectionListener(new SelectionAdapter() {
				@Override
			    public void widgetSelected(SelectionEvent e)
			    {
	    			selectedWhereClassElements.get(j).clear();
	    			selectedWhereClassValues.get(j).clear();
					selectedWhereIndicesIndices.get(j).clear();
	    			org.eclipse.swt.widgets.List list = (org.eclipse.swt.widgets.List) e.widget;
	    			int[] selectionIndices = list.getSelectionIndices();
	   				for (int k = 0; k < selectionIndices.length; k++) {
	   					selectedWhereClassElements.get(j).add(finalWodelClassElementsNames.get(index).get(selectionIndices[k]));
	   					selectedWhereIndicesIndices.get(j).add(selectionIndices[k]);
	    			}
	   				dialogChanged();
	   				setControls();
			    }
			});
		}
		separator = new Label(settings, SWT.HORIZONTAL);
		separator.setLayoutData(new GridData(SWT.PUSH | SWT.FILL, SWT.CENTER, true, false, 2, 1));
		
		List<org.eclipse.swt.widgets.List> wodelClassWithElementsSelectors = new ArrayList<org.eclipse.swt.widgets.List>();
		for (int i = 0; i < selectedIndices.size(); i++) {
			separator = new Label(settings, SWT.HORIZONTAL);
			separator.setLayoutData(new GridData(SWT.PUSH | SWT.FILL, SWT.CENTER, true, false, 2, 1));
			label = new Label(settings, SWT.NULL);
			label.setText("Select " + wodelElementsNames.get(selectedIndices.get(i)) + " with clause feature(s):");
			org.eclipse.swt.widgets.List wodelClassWithElementsSelector = new org.eclipse.swt.widgets.List(settings, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
			for (String wodelElement : finalWodelClassElementsNames.get(selectedIndices.get(i))) {
				wodelClassWithElementsSelector.add(wodelElement);
			}
			wodelClassWithElementsSelectors.add(wodelClassWithElementsSelector);
			if (wodelClassElementsValues.size() > selectedIndices.get(i)) {
				List<EStructuralFeature> featuresList = wodelClassElementsValues.get(selectedIndices.get(i));
				for (int j = 0; j < selectedWithIndicesIndices.get(i).size(); j++) {
					if (featuresList.size() > selectedWithIndicesIndices.get(i).get(j)) {
						EStructuralFeature feature = featuresList.get(selectedWithIndicesIndices.get(i).get(j));
						if (feature.getEType().getName().equals("EBoolean")) {
							Button featureButton = new Button(settings, SWT.CHECK);
							featureButton.setText(feature.getName() + ":");
							featureButton.setSelection(false);
							controls.add(featureButton);
							final int k = i;
							final int l = j;
							if (selectedWithClassValues.get(k).size() <= l) {
								selectedWithClassValues.get(k).add(false);
							}
							featureButton.addFocusListener(new FocusAdapter() {
								@Override
								public void focusLost(FocusEvent e) {
									if (e.widget instanceof Button) {
										Button btn = (Button) e.widget;
										boolean value = btn.getSelection();
										selectedWithClassValues.get(k).set(l, value);
									}
									if (e.widget instanceof Text) {
										Text btn = (Text) e.widget;
										String value = btn.getText();
										selectedWithClassValues.get(k).set(l, value);
									}
								}
							});
						}
						if (feature.getEType().getName().equals("EString")) {
							label = new Label(settings, SWT.NULL);
							label.setText(feature.getName() + ":");
							Combo combo = new Combo(settings, SWT.NONE);
							combo.setText("");
							controls.add(combo);
							for (int k = 0; k < finalWodelClassObjectsValues.get(selectedIndices.get(i)).get(selectedWithIndicesIndices.get(i).get(j)).size(); k++) {
								combo.add(finalWodelClassObjectsValues.get(selectedIndices.get(i)).get(selectedWithIndicesIndices.get(i).get(j)).get(k).toString());
							}
							final int k = i;
							final int l = j;
							if (selectedWithClassValues.get(k).size() <= l) {
								selectedWithClassValues.get(k).add("");
							}
							combo.addFocusListener(new FocusAdapter() {
								@Override
								public void focusLost(FocusEvent e) {
									if (e.widget instanceof Combo) {
										Combo c = (Combo) e.widget;
										String value = c.getText();
										selectedWithClassValues.get(k).set(l, value);
									}
								}
							});
						}
						if (feature.getEType().getName().equals("EInt")) {
							label = new Label(settings, SWT.NULL);
							label.setText(feature.getName() + ":");
							Text featureText = new Text(settings, SWT.NONE);
							featureText.setText("0");
							controls.add(featureText);
							final int k = i;
							final int l = j;
							if (selectedWithClassValues.get(k).size() <= l) {
								selectedWithClassValues.get(k).add("0");
							}
							featureText.addFocusListener(new FocusAdapter() {
								@Override
								public void focusLost(FocusEvent e) {
									if (e.widget instanceof Button) {
										Button btn = (Button) e.widget;
										boolean value = btn.getSelection();
										selectedWithClassValues.get(k).set(l, value);
									}
									if (e.widget instanceof Text) {
										Text btn = (Text) e.widget;
										String value = btn.getText();
										selectedWithClassValues.get(k).set(l, value);
									}
								}
							});
						}
						if (feature.getEType().getName().equals("ELong")) {
							label = new Label(settings, SWT.NULL);
							label.setText(feature.getName() + ":");
							Text featureText = new Text(settings, SWT.NONE);
							featureText.setText("0");
							controls.add(featureText);
							final int k = i;
							final int l = j;
							if (selectedWithClassValues.get(k).size() <= l) {
								selectedWithClassValues.get(k).add("0");
							}
							featureText.addFocusListener(new FocusAdapter() {
								@Override
								public void focusLost(FocusEvent e) {
									if (e.widget instanceof Button) {
										Button btn = (Button) e.widget;
										boolean value = btn.getSelection();
										selectedWithClassValues.get(k).set(l, value);
									}
									if (e.widget instanceof Text) {
										Text btn = (Text) e.widget;
										String value = btn.getText();
										selectedWithClassValues.get(k).set(l, value);
									}
								}
							});
						}
						if (feature.getEType().getName().equals("EDouble")) {
							label = new Label(settings, SWT.NULL);
							label.setText(feature.getName() + ":");
							Text featureText = new Text(settings, SWT.NONE);
							featureText.setText("0.0");
							controls.add(featureText);
							final int k = i;
							final int l = j;
							if (selectedWithClassValues.get(k).size() <= l) {
								selectedWithClassValues.get(k).add("0.0");
							}
							featureText.addFocusListener(new FocusAdapter() {
								@Override
								public void focusLost(FocusEvent e) {
									if (e.widget instanceof Button) {
										Button btn = (Button) e.widget;
										boolean value = btn.getSelection();
										selectedWithClassValues.get(k).set(l, value);
									}
									if (e.widget instanceof Text) {
										Text btn = (Text) e.widget;
										String value = btn.getText();
										selectedWithClassValues.get(k).set(l, value);
									}
								}
							});
						}
						if (feature.getEType().getName().equals("EFloat")) {
							label = new Label(settings, SWT.NULL);
							label.setText(feature.getName() + ":");
							Text featureText = new Text(settings, SWT.NONE);
							featureText.setText("0.0");
							controls.add(featureText);
							final int k = i;
							final int l = j;
							if (selectedWithClassValues.get(k).size() <= l) {
								selectedWithClassValues.get(k).add("0.0");
							}
							featureText.addFocusListener(new FocusAdapter() {
								@Override
								public void focusLost(FocusEvent e) {
									if (e.widget instanceof Button) {
										Button btn = (Button) e.widget;
										boolean value = btn.getSelection();
										selectedWithClassValues.get(k).set(l, value);
									}
									if (e.widget instanceof Text) {
										Text btn = (Text) e.widget;
										String value = btn.getText();
										selectedWithClassValues.get(k).set(l, value);
									}
								}
							});
						}
					}
				}
			}
		}
		for (int i = 0; i < selectedIndices.size(); i++) {
			for (int j = 0; j < selectedWithIndicesIndices.get(i).size(); j++) {
				wodelClassWithElementsSelectors.get(i).select(selectedWithIndicesIndices.get(i).get(j));
			}
		}
		for (int i = 0; i < wodelClassWithElementsSelectors.size(); i++) {
			final int j = i;
			final int index = selectedIndices.get(j);
			wodelClassWithElementsSelectors.get(j).addSelectionListener(new SelectionAdapter() {
				@Override
			    public void widgetSelected(SelectionEvent e)
			    {
	    			selectedWithClassElements.get(j).clear();
	    			selectedWithClassValues.get(j).clear();
					selectedWithIndicesIndices.get(j).clear();
	    			org.eclipse.swt.widgets.List list = (org.eclipse.swt.widgets.List) e.widget;
	    			int[] selectionIndices = list.getSelectionIndices();
	   				for (int k = 0; k < selectionIndices.length; k++) {
	   					selectedWithClassElements.get(j).add(finalWodelClassElementsNames.get(index).get(selectionIndices[k]));
	   					selectedWithIndicesIndices.get(j).add(selectionIndices[k]);
	    			}
	   				dialogChanged();
	   				setControls();
			    }
			});
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
