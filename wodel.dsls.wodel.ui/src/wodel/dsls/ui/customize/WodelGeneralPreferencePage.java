package wodel.dsls.ui.customize;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.xtext.ui.editor.preferences.LanguageRootPreferencePage;
import org.eclipse.xtext.ui.editor.preferences.fields.LabelFieldEditor;
import wodel.postprocessor.run.IPostprocessor;
import wodel.registry.run.IRegistryPostprocessor;
import wodel.utils.exceptions.MetaModelNotFoundException;
import wodel.utils.manager.ModelManager;

public class WodelGeneralPreferencePage extends LanguageRootPreferencePage {
	public static final String PREF_GPT_API_KEY = "wodel.ai.gptApiKey";
	public List<String> selectedValidationNames = new ArrayList<String>();
	
    @Override
    protected void createFieldEditors() {
    	String metamodel = ModelManager.getMetaModel();
    	List<EPackage> packages = null;
    	try {
			packages = ModelManager.loadMetaModel(metamodel);
    	} catch (MetaModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		String uri = packages.get(0).getNsURI();
    	Composite composite = getFieldEditorParent();
		IPreferenceStore preferenceStore = doGetPreferenceStore();
		
		// Masked text field (recommended)
		new LabelFieldEditor("\n\ngen-AI API Key", composite);
		StringFieldEditor apiKeyEditor = new StringFieldEditor(PREF_GPT_API_KEY, "", 60, composite) {
		    @Override
		    protected void doFillIntoGrid(Composite parent, int numColumns) {
		        super.doFillIntoGrid(parent, numColumns);
		        // Mask the key in the UI (you can remove this line if you want plain text)
		        getTextControl(parent).setEchoChar('\u2022'); // bullet
		    }
		};

		apiKeyEditor.setEmptyStringAllowed(true);
		apiKeyEditor.setTextLimit(250);
		addField(apiKeyEditor);

		// Default value (empty)
		preferenceStore.setDefault(PREF_GPT_API_KEY, "");
		
		Map<String, String> modelMap = new LinkedHashMap<String, String>();
		modelMap.put("gpt-3.5-turbo", "gpt-3.5-turbo");
		modelMap.put("gpt-4o-mini", "gpt-4o-mini");
		modelMap.put("gpt-4.1-mini", "gpt-4.1-mini");
		modelMap.put("gpt-4.1-nano", "gpt-4.1-nano");
		modelMap.put("gpt-5-mini", "gpt-5-mini");
		modelMap.put("gpt-5-nano", "gpt-5-nano");
		
		List<String> modelList = new ArrayList<String>();
		modelList.add("");
		for (String name : modelMap.keySet()) {
			String nameValue = modelMap.get(name);
			if (nameValue.equals("")) {
				modelList.add(name);
			}
			if (nameValue.equals(name)) {
				modelList.add(name);
			}
		}
		String[][] values = new String[modelList.size()][2];
		int index = 0;
		for (String value : modelList) {
			values[index][0] = value;
			values[index][1] = value;
			index++;
		}
		
		new LabelFieldEditor(" ", composite);
		
		new LabelFieldEditor("\n\nAI generative model", composite);
    	ComboFieldEditor comboGenAIModel = new ComboFieldEditor("AI generative model", "", values, composite);
    	preferenceStore.setDefault("AI generative model", "gpt-4o-mini");
    	addField(comboGenAIModel);
    	
    	new LabelFieldEditor(" ", composite);
    	
    	new LabelFieldEditor("\n\nTemperature", composite);
    	StringFieldEditor text = new StringFieldEditor("Temperature", "", 8, composite);
    	preferenceStore.setDefault("Temperature", "0");
    	text.setEmptyStringAllowed(true);
    	text.setTextLimit(8);
    	addField(text);
    	new LabelFieldEditor(" ", composite);
    	addField(new BooleanFieldEditor("Generate registry", "Generate registry", composite));
    	preferenceStore.setDefault("Generate registry", true);

    	if (Platform.getExtensionRegistry() != null) {
			IConfigurationElement[] extensions = Platform
					.getExtensionRegistry()
					.getConfigurationElementsFor("wodel.registry", "MutRegistryPostprocessor");
			if (extensions != null) {
				for (int j = 0; j < extensions.length; j++) {
					IRegistryPostprocessor src = null;
					try {
						src = (IRegistryPostprocessor) extensions[j]
								.createExecutableExtension("class");
					} catch (CoreException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if (src != null) {
						addField(new BooleanFieldEditor(src.getName(), src.getName(), composite));
					}
				}
			}
		}

    	new LabelFieldEditor(" ", composite);
    	addField(new BooleanFieldEditor("Serialize models", "Serialize models", composite));
    	preferenceStore.setDefault("Serialize models", true);
    	
    	Map<String, String> valueMap = new HashMap<String, String>();
    	if (Platform.getExtensionRegistry() != null) {
			IConfigurationElement[] extensions = Platform
					.getExtensionRegistry()
					.getConfigurationElementsFor("wodel.postprocessor", "MutPostprocessor");
			if (extensions != null) {
				for (int j = 0; j < extensions.length; j++) {
					String value = "";
					String uriValue = "";
					try {
						Class<?> extensionClass = Platform.getBundle(extensions[j].getDeclaringExtension().getContributor().getName()).loadClass(extensions[j].getAttribute("class"));
						Object comparison =  extensionClass.getDeclaredConstructor().newInstance();
						Method method = extensionClass.getDeclaredMethod("getName");
						value = (String) method.invoke(comparison);
						method = extensionClass.getDeclaredMethod("getURI");
						uriValue = (String) method.invoke(comparison);
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvalidRegistryObjectException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NoSuchMethodException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (value.length() > 0) {
						valueMap.put(value, uriValue);
					}
				}
			}
			List<String> valueList = new ArrayList<String>();
			valueList.add("");
			for (String value : valueMap.keySet()) {
				String uriValue = valueMap.get(value);
				if (uriValue.equals("")) {
					valueList.add(value);
				}
				if (uriValue.equals(uri)) {
					valueList.add(value);
				}
			}
				
			values = new String[valueList.size()][2];
			index = 0;
			for (String value : valueList) {
				values[index][0] = value;
				values[index][1] = value;
				index++;
			}
	    	
	    	new LabelFieldEditor("\n\nMutants postprocessing extension", composite);
	    	ComboFieldEditor combo = new ComboFieldEditor("Mutants postprocessing extension", "", values, composite);
	    	addField(combo);
    	}
    	new LabelFieldEditor(" \n\n", composite);
    	new LabelFieldEditor("\n\nWrite which number of attempts will be executed until assuring mutant is unique", composite);
    	StringFieldEditor field = new StringFieldEditor("Number of attempts", "", 8, composite);
    	preferenceStore.setDefault("Number of attempts", "3");
    	addField(field);
    	new LabelFieldEditor("\n\n", composite);
    	new LabelFieldEditor("Top number of mutants that will be generated by default", composite);
    	field = new StringFieldEditor("Number of mutants", "", 8, composite);
    	preferenceStore.setDefault("Number of mutants", "3");
    	addField(field);
    	new LabelFieldEditor("\n\n", composite);

    	valueMap = new HashMap<String, String>();
    	if (Platform.getExtensionRegistry() != null) {
			IConfigurationElement[] extensions = Platform
					.getExtensionRegistry()
					.getConfigurationElementsFor("wodel.syntactic.validation" , "MutSyntacticValidation");
			if (extensions != null) { 
				for (int j = 0; j < extensions.length; j++) {
					String value = "";
					String uriValue = "";
					try {
						Class<?> extensionClass = Platform.getBundle(extensions[j].getDeclaringExtension().getContributor().getName()).loadClass(extensions[j].getAttribute("class"));
						Object validation =  extensionClass.getDeclaredConstructor().newInstance();
						Method method = extensionClass.getDeclaredMethod("getName");
						value = (String) method.invoke(validation);
						method = extensionClass.getDeclaredMethod("getURI");
						uriValue = (String) method.invoke(validation);
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvalidRegistryObjectException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NoSuchMethodException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (value.length() > 0) {
						valueMap.put(value, uriValue);
					}
				}
			}
			List<String> valueList = new ArrayList<String>();
			valueList.add("");
			for (String value : valueMap.keySet()) {
				String uriValue = valueMap.get(value);
				if (uriValue.equals("")) {
					valueList.add(value);
				}
				if (uriValue.equals(uri)) {
					valueList.add(value);
				}
			}
			values = new String[valueList.size()][2];
			index = 0;
			for (String value : valueList) {
				values[index][0] = value;
				values[index][1] = value;
				index++;
			}
//			String[][] values = new String[valueList.size() + 1][2];
//			int index = 0;
//			for (String value : valueList) {
//				values[index][0] = value;
//				values[index][1] = value;
//				index++;
//			}
//			values[index][0] = "Java Program Validation";
//			values[index][1] = "Java Program Validation";

    		new LabelFieldEditor(" ", composite);
        	addField(new BooleanFieldEditor("Discard invalid mutants", "Discard invalid mutants", composite));
        	preferenceStore.setDefault("Discard invalid mutants", true);

        	new LabelFieldEditor("Mutants validation extensions", composite);
			ComboFieldEditor combo = new ComboFieldEditor("Mutants validation extension", "", values, composite);
			addField(combo);
        	preferenceStore.setDefault("Mutants validation extension", "EMF model validation");
//        	new LabelFieldEditor(" ", composite);
//        	org.eclipse.swt.widgets.List comboList = new org.eclipse.swt.widgets.List(composite, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
//        	for (String[] value : values) {
//        		comboList.add(value[0]);
//        	}
//        	comboList.addSelectionListener(new SelectionAdapter() {
//        		@Override
//    		    public void widgetSelected(SelectionEvent e)
//    		    {
//        			org.eclipse.swt.widgets.List list = (org.eclipse.swt.widgets.List) e.widget;
//        			int[] selectionIndices = list.getSelectionIndices();
//        			if (selectionIndices[0] == 0) {
//        				selectedValidationNames.add(values[0][0]);
//        			}
//        			else {
//        				for (int i = 0; i < selectionIndices.length; i++) {
//        					selectedValidationNames.add(values[selectionIndices[i]][0]);
//        				}
//        			}
//    		    }
//        	});
    	}
    	
    	new LabelFieldEditor("\n\n", composite);
    	valueMap = new HashMap<String, String>();
    	if (Platform.getExtensionRegistry() != null) {
			IConfigurationElement[] extensions = Platform
					.getExtensionRegistry()
					.getConfigurationElementsFor("wodel.syntactic.comparison", "MutSyntacticComparison");
			if (extensions != null) {
				for (int j = 0; j < extensions.length; j++) {
					String value = "";
					String uriValue = "";
					try {
						Class<?> extensionClass = Platform.getBundle(extensions[j].getDeclaringExtension().getContributor().getName()).loadClass(extensions[j].getAttribute("class"));
						Object comparison =  extensionClass.getDeclaredConstructor().newInstance();
						Method method = extensionClass.getDeclaredMethod("getName");
						value = (String) method.invoke(comparison);
						method = extensionClass.getDeclaredMethod("getURI");
						uriValue = (String) method.invoke(comparison);
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvalidRegistryObjectException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NoSuchMethodException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (value.length() > 0) {
						valueMap.put(value, uriValue);
					}
				}
			}
			List<String> valueList = new ArrayList<String>();
			valueList.add("");
			for (String value : valueMap.keySet()) {
				String uriValue = valueMap.get(value);
				if (uriValue.equals("")) {
					valueList.add(value);
				}
				if (uriValue.equals(uri)) {
					valueList.add(value);
				}
			}

			values = new String[valueList.size()][2];
			index = 0;
			for (String value : valueList) {
				values[index][0] = value;
				values[index][1] = value;
				index++;
			}

    		new LabelFieldEditor(" ", composite);
        	addField(new BooleanFieldEditor("Discard syntactic duplicate mutants", "Discard syntactic duplicate mutants", composite));
        	preferenceStore.setDefault("Discard syntactic duplicate mutants", true);

        	new LabelFieldEditor("Duplicate mutants detection extension", composite);
			ComboFieldEditor combo = new ComboFieldEditor("Duplicate mutants detection extension", "", values, composite);
			addField(combo);
        	preferenceStore.setDefault("Duplicate mutants detection extension", "EMF model comparison");
    	}

    	new LabelFieldEditor("\n\n", composite);
    	valueMap = new HashMap<String, String>();
    	if (Platform.getExtensionRegistry() != null) {
    		IConfigurationElement[] extensions = Platform
    				.getExtensionRegistry()
    				.getConfigurationElementsFor("wodel.semantic.comparison", "MutSemanticComparison");
    		if (extensions != null) {
        		for (int j = 0; j < extensions.length; j++) {
        			String value = "";
        			String uriValue = "";
        			try {
        				Class<?> extensionClass = Platform.getBundle(extensions[j].getDeclaringExtension().getContributor().getName()).loadClass(extensions[j].getAttribute("class"));
        				Object comparison =  extensionClass.getDeclaredConstructor().newInstance();
        				Method method = extensionClass.getDeclaredMethod("getName");
        				value = (String) method.invoke(comparison);
        				method = extensionClass.getDeclaredMethod("getURI");
        				uriValue = (String) method.invoke(comparison);
        			} catch (InstantiationException e) {
        				// TODO Auto-generated catch block
        				e.printStackTrace();
        			} catch (IllegalAccessException e) {
        				// TODO Auto-generated catch block
        				e.printStackTrace();
        			} catch (ClassNotFoundException e) {
        				// TODO Auto-generated catch block
        				e.printStackTrace();
        			} catch (InvalidRegistryObjectException e) {
        				// TODO Auto-generated catch block
        				e.printStackTrace();
        			} catch (NoSuchMethodException e) {
        				// TODO Auto-generated catch block
        				e.printStackTrace();
        			} catch (SecurityException e) {
        				// TODO Auto-generated catch block
        				e.printStackTrace();
        			} catch (IllegalArgumentException e) {
        				// TODO Auto-generated catch block
        				e.printStackTrace();
        			} catch (InvocationTargetException e) {
        				// TODO Auto-generated catch block
        				e.printStackTrace();
        			}
        			if (value.length() > 0) {
        				valueMap.put(value, uriValue);
        			}
        		}
    		}
    		List<String> valueList = new ArrayList<String>();
			valueList.add("");
   			for (String value : valueMap.keySet()) {
   				String uriValue = valueMap.get(value);
   				if (uriValue.equals("")) {
   					valueList.add(value);
   				}
   				if (uriValue.equals(uri)) {
   					valueList.add(value);
   				}
   			}

    		values = new String[valueList.size()][2];
    		index = 0;
    		for (String value : valueList) {
    			values[index][0] = value;
    			values[index][1] = value;
    			index++;
    		}

//    		String[][] values = new String[1][2];
//   			values[0][0] = "Java Program Equivalence";
//   			values[0][1] = "Java Program Equivalence";

    		new LabelFieldEditor(" ", composite);
        	addField(new BooleanFieldEditor("Discard semantic equivalent mutants", "Discard semantic equivalent mutants", composite));

        	new LabelFieldEditor("Semantic equivalent mutants detection extension", composite);
    		ComboFieldEditor combo = new ComboFieldEditor("Semantic equivalent mutants detection extension", "", values, composite);
    		addField(combo);
    	}
    	
    	new LabelFieldEditor("\n\n", composite);

    	valueMap = new HashMap<String, String>();
    	if (Platform.getExtensionRegistry() != null) {
			IConfigurationElement[] extensions = Platform
					.getExtensionRegistry()
					.getConfigurationElementsFor("wodel.semantic.validation", "MutSemanticValidation");
			if (extensions != null) {
				for (int j = 0; j < extensions.length; j++) {
					String value = "";
					String uriValue = "";
					try {
						Class<?> extensionClass = Platform.getBundle(extensions[j].getDeclaringExtension().getContributor().getName()).loadClass(extensions[j].getAttribute("class"));
						Object comparison =  extensionClass.getDeclaredConstructor().newInstance();
						Method method = extensionClass.getDeclaredMethod("getName");
						value = (String) method.invoke(comparison);
						method = extensionClass.getDeclaredMethod("getURI");
						uriValue = (String) method.invoke(comparison);
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvalidRegistryObjectException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NoSuchMethodException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (value.length() > 0) {
						valueMap.put(value, uriValue);
					}
				}
			}
			List<String> valueList = new ArrayList<String>();
			valueList.add("");
			for (String value : valueMap.keySet()) {
				String uriValue = valueMap.get(value);
				if (uriValue.equals("")) {
					valueList.add(value);
				}
				if (uriValue.equals(uri)) {
					valueList.add(value);
				}
			}
			values = new String[valueList.size()][2];
			index = 0;
			for (String value : valueList) {
				values[index][0] = value;
				values[index][1] = value;
				index++;
			}
	    	
	    	new LabelFieldEditor("Mutants valid programs extension", composite);
	    	ComboFieldEditor combo = new ComboFieldEditor("Mutants valid programs extension", "", values, composite);
	    	addField(combo);
    	}
    	
    	new LabelFieldEditor("\n\n", composite);

    	valueMap = new HashMap<String, String>();
    	if (Platform.getExtensionRegistry() != null) {
			IConfigurationElement[] extensions = Platform
					.getExtensionRegistry()
					.getConfigurationElementsFor("wodeltest.optimiser", "MutTestingOptimiser");
			if (extensions != null) {
				for (int j = 0; j < extensions.length; j++) {
					String value = "";
					String uriValue = "";
					try {
						Class<?> extensionClass = Platform.getBundle(extensions[j].getDeclaringExtension().getContributor().getName()).loadClass(extensions[j].getAttribute("class"));
						Object comparison =  extensionClass.getDeclaredConstructor().newInstance();
						Method method = extensionClass.getDeclaredMethod("getName");
						value = (String) method.invoke(comparison);
						method = extensionClass.getDeclaredMethod("getURI");
						uriValue = (String) method.invoke(comparison);
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvalidRegistryObjectException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NoSuchMethodException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (value.length() > 0) {
						valueMap.put(value, uriValue);
					}
				}
			}
			List<String> valueList = new ArrayList<String>();
			valueList.add("");
			for (String value : valueMap.keySet()) {
				String uriValue = valueMap.get(value);
				if (uriValue.equals("")) {
					valueList.add(value);
				}
				if (uriValue.equals(uri)) {
					valueList.add(value);
				}
			}
				
			values = new String[valueList.size()][2];
			index = 0;
			for (String value : valueList) {
				values[index][0] = value;
				values[index][1] = value;
				index++;
			}
	    	
    		new LabelFieldEditor(" ", composite);
        	addField(new BooleanFieldEditor("Optimise mutants", "Optimise mutants", composite));

        	new LabelFieldEditor("Mutants optimiser extension", composite);
	    	ComboFieldEditor combo = new ComboFieldEditor("Mutants optimiser extension", "", values, composite);
	    	addField(combo);
    	}
    }
    @Override
    public void init(IWorkbench workbench) {
    	if (Platform.getExtensionRegistry() != null) {
			IConfigurationElement[] extensions = Platform
					.getExtensionRegistry()
					.getConfigurationElementsFor("wodel.postprocessor", "MutPostprocessor");
			if (extensions != null) {
				for (int j = 0; j < extensions.length; j++) {
					IPostprocessor src = null;
					try {
						src = (IPostprocessor) extensions[j]
								.createExecutableExtension("class");
					} catch (CoreException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if (src != null) {
						getPreferenceStore().setDefault(src.getName(), false);
					}
				}
			}
    	}
    	getPreferenceStore().setDefault("Discard semantic equivalent mutants", false);
    	getPreferenceStore().setDefault("Serialize models", true);
    }

}
