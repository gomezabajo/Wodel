package runwodel.popup.actions;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import exceptions.MetaModelNotFoundException;
import manager.ModelManager;

public class TestAlternativeTextualRepresentationWizardPage extends WizardPage {

	private ISelection selection;
	
	private ScrolledComposite scrolledComposite;
	
	private Composite container;
	
	public boolean valid = false;
	
	public Map<String, SimpleEntry<String, SimpleEntry<Object, Method>>> selectedAlternativeTextualRepresentations = new TreeMap<String, SimpleEntry<String, SimpleEntry<Object, Method>>>();
	
	protected TestAlternativeTextualRepresentationWizardPage(ISelection selection) {
		super("wodelPage");
		setTitle("Test Wodel Alternative Textual Representation");
		setDescription("Test Wodel Alternative Textual Representation");
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

	/*
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
		
		String metamodel = ModelManager.getMetaModel();
		Map<String, SimpleEntry<String, SimpleEntry<Object, Method>>> model2TextExtensions = new TreeMap<String, SimpleEntry<String, SimpleEntry<Object, Method>>>();
		
		try {
			if (Platform.getExtensionRegistry() != null) {
				IConfigurationElement[] extensions = Platform
						.getExtensionRegistry().getConfigurationElementsFor(
								"wodel.model2text.ModelToText");

				for (IConfigurationElement extension : extensions) {
					Class<?> extensionClass;
						extensionClass = Platform.getBundle(extension.getDeclaringExtension().getContributor().getName()).loadClass(extension.getAttribute("class"));
						Object model2Text =  extensionClass.getDeclaredConstructor().newInstance();
						Method getURI = extensionClass.getDeclaredMethod("getURI");
						List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
						String uri = (String) getURI.invoke(model2Text);
						if (uri.equals(packages.get(0).getNsURI())) {
							Method getId = extensionClass.getDeclaredMethod("getId");
							String id = (String) getId.invoke(model2Text);
							Method getName = extensionClass.getDeclaredMethod("getName");
							String name = (String) getName.invoke(model2Text);
							Method getText = extensionClass.getDeclaredMethod("getText", new Class[]{String.class, String.class});
							model2TextExtensions.put(id, new SimpleEntry<String, SimpleEntry<Object, Method>>(name, new SimpleEntry<Object, Method>(model2Text, getText)));
						}
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidRegistryObjectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MetaModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

		if (selectedAlternativeTextualRepresentations.size() == 0) {
			valid = false;
		}
		Label separator = new Label(settings, SWT.HORIZONTAL);
		separator.setLayoutData(new GridData(SWT.PUSH | SWT.FILL, SWT.CENTER, true, false, 2, 1));
		List<String> model2TextIDs = new ArrayList<String>();
		List<String> model2TextNames = new ArrayList<String>();
		List<Object> model2TextInstances = new ArrayList<Object>();
		List<Method> model2TextMethods = new ArrayList<Method>();
		for (String model2TextID : model2TextExtensions.keySet()) {
			model2TextIDs.add(model2TextID);
			model2TextNames.add(model2TextExtensions.get(model2TextID).getKey());
			model2TextInstances.add(model2TextExtensions.get(model2TextID).getValue().getKey());
			model2TextMethods.add(model2TextExtensions.get(model2TextID).getValue().getValue());
		}
		Label label = new Label(settings, SWT.NULL);
		label.setText("Select alternative &textual representation(s):");
		org.eclipse.swt.widgets.List alternativeTextualRepresentations = new org.eclipse.swt.widgets.List(settings, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
		for (String model2TextID : model2TextExtensions.keySet()) {
			alternativeTextualRepresentations.add(model2TextExtensions.get(model2TextID).getKey());
		}
		final List<String> fModel2TextIDs = model2TextIDs;
		final List<String> fModel2TextNames = model2TextNames;
		final List<Object> fModel2TextInstances = model2TextInstances;
		final List<Method> fModel2TextMethods = model2TextMethods;
		alternativeTextualRepresentations.addSelectionListener(new SelectionAdapter() {
    		@Override
		    public void widgetSelected(SelectionEvent e)
		    {
    			selectedAlternativeTextualRepresentations.clear();
    			org.eclipse.swt.widgets.List list = (org.eclipse.swt.widgets.List) e.widget;
    			int[] selectionIndices = list.getSelectionIndices();
   				for (int i = 0; i < selectionIndices.length; i++) {
   					selectedAlternativeTextualRepresentations.put(fModel2TextIDs.get(selectionIndices[i]), new SimpleEntry<String, SimpleEntry<Object, Method>>(fModel2TextNames.get(selectionIndices[i]), new SimpleEntry<Object, Method>(fModel2TextInstances.get(selectionIndices[i]), fModel2TextMethods.get(selectionIndices[i]))));
    			}
   				if (selectedAlternativeTextualRepresentations.size() > 0) {
   					valid = true;
   				}
		    }
    	});
		contents.layout();
		scrolledComposite.setContent(container);
		scrolledComposite.setMinSize(container.computeSize(SWT.DEFAULT,	SWT.DEFAULT));
	}
	
	/**
	 * Ensures that both text fields are set.
	 */
	private void dialogChanged() {
	}
}
