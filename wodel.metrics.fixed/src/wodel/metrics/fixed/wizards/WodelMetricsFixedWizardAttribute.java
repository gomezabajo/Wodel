package wodel.metrics.fixed.wizards;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import manager.ModelManager;
import mutator.MutatorUtils;
import manager.WodelContext;
import mutatorenvironment.AttributeScalar;
import mutatorenvironment.AttributeType;
import mutatorenvironment.ModifyInformationMutator;
import mutatorenvironment.Mutator;
import mutatorenvironment.MutatorenvironmentFactory;
import mutatorenvironment.ObSelectionStrategy;
import mutatorenvironment.Operator;
import mutatorenvironment.ReferenceInit;
import mutatorenvironment.SpecificBooleanType;
import mutatorenvironment.SpecificDoubleType;
import mutatorenvironment.SpecificIntegerType;
import mutatorenvironment.SpecificStringType;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.osgi.framework.Bundle;

import wodel.dsls.WodelUtils;
import exceptions.MetaModelNotFoundException;
import exceptions.ModelNotFoundException;
import exceptions.ReferenceNonExistingException;

public class WodelMetricsFixedWizardAttribute extends Wizard implements INewWizard {
	
	private ISelection selection;
	
	private static String className;
	
	private static String attributeName;

	public WodelMetricsFixedWizardAttributePage _pageOne;
	//public WodelWizardMetamodelPage _pageTwo;
	
	private static final String WIZARD_NAME = "Wodel Static Metrics Attribute Wizard";
	
	private static final String WORKSPACE = ModelManager.getWorkspaceAbsolutePath();
	
	private static final String PROJECT = WodelContext.getProject();
	
	private static final String OUTPUT = ModelManager.getOutputPath();
	
	private static ArrayList<EPackage> mutatorPackages = null;
	
	private static ArrayList<EPackage> packages = null;
	
	private static Resource model = null;
	
	/**
	 * Adding the page to the wizard.
	 */

	public void addPages() {
		try {
			super.addPages();
//			final File mutatorFile = new File(WORKSPACE + "/" + PROJECT + "/src/" + PROJECT + ".mutator");
//			try {
//				InputStream in = null;
//				OutputStream out = null;
//				if (mutatorFile.exists()) {
//					in = new FileInputStream(mutatorFile);
//					String content = CharStreams.toString(new InputStreamReader(in, Charsets.UTF_8));
//					in.close();
//					out = new FileOutputStream(mutatorFile);
//					out.write(content.getBytes(Charsets.UTF_8));
//					out.close();
//				}
//			} catch (IOException e) {
//			}
//			//Refresh project
//			ResourcesPlugin.getWorkspace().getRoot().getProject(PROJECT).refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
			
			Bundle bundle = Platform.getBundle("wodel.models");
	   		URL fileURL = bundle.getEntry("/models/MutatorEnvironment.ecore");
	   		String mutatorecore = FileLocator.resolve(fileURL).getFile();
			//mutatorPackages = ModelManager.loadMetaModel(WORKSPACE + "/" + PROJECT + "/resources/MutatorEnvironment.ecore");
	   		mutatorPackages = ModelManager.loadMetaModel(mutatorecore);
			model = ModelManager.loadModel(mutatorPackages, OUTPUT + "/" + PROJECT + ".model");
			String metamodel = ModelManager.getMetaModel();
			packages = ModelManager.loadMetaModel(metamodel);
			_pageOne = new WodelMetricsFixedWizardAttributePage(selection, mutatorPackages, model, packages, className, attributeName);
			_pageOne.setTitle("Wodel Mutation Creation Tool");
			_pageOne.setDescription("Wodel Mutation Creation Tool");
			addPage(_pageOne);
		} catch (MetaModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//		} catch (CoreException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
	}
	
	/**
	 * Constructor for WodelWizard.
	 */
	public WodelMetricsFixedWizardAttribute(String className, String attributeName) {
		super();
		this.className = className;
		this.attributeName = attributeName;
		setWindowTitle(WIZARD_NAME);
		setNeedsProgressMonitor(true);
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
		
	}

	@Override
	public boolean performFinish() {
		try {
			EObject root = ModelManager.getRoot(model);

			List<EObject> commands = null;
			if (_pageOne.blockClass == null) {
				commands = ModelManager.getReferences("commands", root);
			}
			else {
				EObject block = MutatorUtils.getBlock(model, _pageOne.blockClass);
				commands = ModelManager.getReferences("commands", block);
			}

			EClass eClass = (EClass) ModelManager.getObjectOfType(className, packages);
			Mutator mutator = null;
			if (_pageOne.mutatorClass.equals("ModifyInformationMutator")) {
				ModifyInformationMutator modifyInformationMutator = MutatorenvironmentFactory.eINSTANCE.createModifyInformationMutator();
				ObSelectionStrategy obSelectionStrategy = null;
				if (_pageOne.strategyClass.equals("RandomTypeSelection")) {
					obSelectionStrategy = MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
				}
				if (_pageOne.strategyClass.equals("CompleteTypeSelection")) {
					obSelectionStrategy = MutatorenvironmentFactory.eINSTANCE.createCompleteTypeSelection();
				}
				AttributeScalar attributeScalar = null;
				ReferenceInit referenceInit = null;
				for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
					if (feature.getName().equals(_pageOne.feature)) {
						if (feature instanceof EAttribute) {
							EAttribute attribute = (EAttribute) feature;
							attributeScalar = MutatorenvironmentFactory.eINSTANCE.createAttributeScalar();
							attributeScalar.getAttribute().add(attribute);
							Operator operator = Operator.EQUALS;
							AttributeType attributeType = null;
							if (attribute.getEType().getName().equals("EString")) {
								SpecificStringType stringType = MutatorenvironmentFactory.eINSTANCE.createSpecificStringType();
								stringType.setOperator(operator);
								stringType.setValue("string");
								attributeType = stringType;
							}
							if (attribute.getEType().getName().equals("EInt")) {
								SpecificIntegerType integerType = MutatorenvironmentFactory.eINSTANCE.createSpecificIntegerType();
								integerType.setOperator(operator);
								integerType.setValue(0);
								attributeType = integerType;
							}
							if (attribute.getEType().getName().equals("EBoolean")) {
								SpecificBooleanType booleanType = MutatorenvironmentFactory.eINSTANCE.createSpecificBooleanType();
								booleanType.setOperator(operator);
								booleanType.setValue(true);
								attributeType = booleanType;
							}
							if (attribute.getEType().getName().equals("EDouble")) {
								SpecificDoubleType doubleType = MutatorenvironmentFactory.eINSTANCE.createSpecificDoubleType();
								doubleType.setOperator(operator);
								doubleType.setValue(0.0);
								attributeType = doubleType;
							}
							attributeScalar.setValue(attributeType);
						}
						if (feature instanceof EReference) {
							EReference reference = (EReference) feature;
							referenceInit = MutatorenvironmentFactory.eINSTANCE.createReferenceInit();
							ObSelectionStrategy referenceStrategy = MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
							referenceStrategy.setType((EClass) reference.getEType());
							referenceInit.setObject(referenceStrategy);
							referenceInit.getReference().add(reference);
						}
						break;
					}
				}
				obSelectionStrategy.setType(eClass);
				modifyInformationMutator.setObject(obSelectionStrategy);
				if (attributeScalar != null) {
					modifyInformationMutator.getAttributes().add(attributeScalar);
				}
				if (referenceInit != null) {
					modifyInformationMutator.getReferences().add(referenceInit);
				}
				mutator = modifyInformationMutator;
			}
			commands.add(mutator);

			ModelManager.saveModel(model, "file:/" + OUTPUT + "/" + PROJECT + ".model");

			//Reload input
			try {
				model.unload();
				model.load(null); 
			} catch (Exception e) {}
			String mutatorCode = WodelUtils.deserialize(root);
			FileWriter fileWriter = new FileWriter(WORKSPACE + "/" + PROJECT + "/src/" + PROJECT + ".mutator");
			BufferedWriter writer = new BufferedWriter(fileWriter);
			writer.write(mutatorCode);
			writer.close();
			fileWriter.close();
			
			//Refresh project
			ResourcesPlugin.getWorkspace().getRoot().getProject(PROJECT).refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());

		} catch (ReferenceNonExistingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}
	
	/**
	 * Toggles the finish button
	 */
	public boolean canFinish()
	{
		if(getContainer().getCurrentPage() == _pageOne) {
			if (_pageOne.valid == true) {
				return true;
			}
		}
		return false;
	}


}
