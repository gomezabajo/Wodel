package wodel.metrics.fixed.wizards;

import java.util.ArrayList;

import manager.ModelManager;
import mutator.MutatorUtils;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.IWizardContainer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;

public class WodelMetricsFixedWizardModificationReferencePage extends WizardPage {
	
	private String referenceName;
	
	private String className;
	
	private static String[] blockItems = null;
	
	private static String[] mainItems = null;
	
	private static String[] subItems = null;
	
	private static String[] featureItems = null;
	
	public boolean valid = false;
	
	public String blockClass = null;
	
	public String mutatorClass = null;
	
	public String strategyClass = null;
	
	public String feature = null;
	
	private ArrayList<EPackage> mutatorPackages = null;
	
	private ArrayList<EPackage> packages = null;
	
	private Combo blockCombo = null;
	private Combo mainCombo = null;
	private Combo subCombo = null;
	private Combo featuresCombo = null;
	
	public WodelMetricsFixedWizardModificationReferencePage(ISelection selection, ArrayList<EPackage> mutatorPackages, Resource model, ArrayList<EPackage> packages, String className, String referenceName) {
		super("wizardMetricsFixedModificationReferencePage");
		setTitle("Wodel Mutation Creation Tool");
		setDescription("Wodel Mutation Creation Tool");
		setMessage("");
		this.mutatorPackages = mutatorPackages;
		this.packages = packages;
		this.className = className;
		this.referenceName = referenceName;

		ArrayList<EObject> blockObjects = MutatorUtils.getBlocks(model);
		ArrayList<String> blockNames = new ArrayList<String>();
		for (EObject eObject : blockObjects) {
			blockNames.add(ModelManager.getStringAttribute("name", eObject));
		}
		blockItems = new String[blockNames.size()];
		blockNames.toArray(blockItems);
		ArrayList<EClass> mutatorClasses = MutatorUtils.getModificationReferenceClassMutators(mutatorPackages);
		ArrayList<String> mutatorNames = new ArrayList<String>();
		for (EClass eClass : mutatorClasses) {
			mutatorNames.add(eClass.getName());
		}
		mainItems = new String[mutatorNames.size()];
		mutatorNames.toArray(mainItems);
	}

	@Override
	public void createControl(Composite parent) {
		Group contents = new Group(parent, SWT.FILL);
		GridLayout layout = new GridLayout();
		contents.setLayout(layout);
		contents.setText("Select mutation (and strategy)");
		if (blockItems.length == 0) {
			layout.numColumns = 3;
		}
		else {
			layout.numColumns = 4;
		}
		layout.verticalSpacing = 9;
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.horizontalAlignment = SWT.FILL;
		contents.setLayoutData(gridData);
		
		// Create blocks dropdown Combo
		if (blockItems.length > 0) {
			Group blocks = new Group(contents, SWT.FILL);
			GridLayout blockLayout = new GridLayout();
			blocks.setLayout(blockLayout);
			blocks.setText("Blocks");
			blockCombo = new Combo(blocks, SWT.FILL);
			blockCombo.setItems(blockItems);
			blockCombo.addSelectionListener(new BlockSelectionAdapter());
		}
		// Create main dropdown Combo
		Group main = new Group(contents, SWT.FILL);
		GridLayout mainLayout = new GridLayout();
		main.setLayout(mainLayout);
		main.setText("Mutators");
	    mainCombo = new Combo(main, SWT.FILL);
	    mainCombo.setItems(mainItems);
	    mainCombo.addSelectionListener(new MutatorSelectionAdapter());
	    // Create sub dropdown Combo
		Group sub = new Group(contents, SWT.FILL);
		GridLayout subLayout = new GridLayout();
		sub.setLayout(subLayout);
		sub.setText("Strategies");
	    subCombo = new Combo(sub, SWT.FILL);
	    subCombo.addSelectionListener(new StrategySelectionAdapter());
	    // Create atts/refs dropdown Combo
	    Group features = new Group(contents, SWT.FILL);
	    GridLayout featuresLayout = new GridLayout();
	    features.setLayout(featuresLayout);
	    features.setText("Features");
	    featuresCombo = new Combo(features, SWT.FILL);
	    featuresCombo.addSelectionListener(new FeatureSelectionAdapter());

	    setControl(contents);
	}
	
	private class BlockSelectionAdapter extends SelectionAdapter {

		BlockSelectionAdapter() {
		}

		@Override
		public void widgetSelected(SelectionEvent e) {
			if (e.getSource() instanceof Combo) {
				valid = false;
				Combo combo = (Combo) e.getSource();
				blockClass = blockItems[combo.getSelectionIndex()];
				IWizardContainer container = getContainer();
				container.updateButtons();
			}
		}
	}

	private class MutatorSelectionAdapter extends SelectionAdapter {
		MutatorSelectionAdapter() {
		}

		@Override
		public void widgetSelected(SelectionEvent e) {
			if (e.getSource() instanceof Combo) {
				Combo combo = (Combo) e.getSource();
				mutatorClass = mainItems[combo.getSelectionIndex()];
				ArrayList<EClass> strategyClasses = MutatorUtils.getMutatorStrategies(mutatorPackages, mutatorClass);
				if (strategyClasses != null) {
					ArrayList<String> strategyNames = new ArrayList<String>();
					if (strategyClasses.size() == 0) {
						valid = true;
					}
					else {
						valid = false;
						for (EClass eClass : strategyClasses) {
							strategyNames.add(eClass.getName());
						}
					}
					subItems = new String[strategyNames.size()];
					strategyNames.toArray(subItems);
					subCombo.setItems(subItems);
				}
				if (mutatorClass.equals("ModifyInformationMutator") ||
						mutatorClass.equals("ModifySourceReferenceMutator") ||
						mutatorClass.equals("ModifyTargetReferenceMutator")) {
					EClass eClass = ModelManager.getEClassByName(packages, className);
					if (eClass != null) {
						ArrayList<String> features = new ArrayList<String>();
						for (EReference ref : eClass.getEAllReferences()) {
							if (ref.getName().equals(referenceName)) {
								features.add(ref.getName());
								break;
							}
						}
						featureItems = new String[features.size()];
						features.toArray(featureItems);
						featuresCombo.setItems(featureItems);
					}
				}
				else {
					featureItems = new String[0];
					featuresCombo.setItems(featureItems);
				}
				IWizardContainer container = getContainer();
				container.updateButtons();
			}
		}
	}

	private class StrategySelectionAdapter extends SelectionAdapter {

		StrategySelectionAdapter() {
		}

		@Override
		public void widgetSelected(SelectionEvent e) {
			if (e.getSource() instanceof Combo) {
				valid = true;
				Combo combo = (Combo) e.getSource();
				strategyClass = subItems[combo.getSelectionIndex()];
				IWizardContainer container = getContainer();
				container.updateButtons();
			}
		}
	}

	private class FeatureSelectionAdapter extends SelectionAdapter {

		FeatureSelectionAdapter() {
		}

		@Override
		public void widgetSelected(SelectionEvent e) {
			if (e.getSource() instanceof Combo) {
				valid = true;
				Combo combo = (Combo) e.getSource();
				feature = featureItems[combo.getSelectionIndex()];
				IWizardContainer container = getContainer();
				container.updateButtons();
			}
		}
	}
}
