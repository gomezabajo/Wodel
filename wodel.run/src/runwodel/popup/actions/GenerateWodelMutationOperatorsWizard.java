package runwodel.popup.actions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.ide.IDE;
import org.osgi.framework.Bundle;
import wodel.dsls.WodelUtils;
import exceptions.MetaModelNotFoundException;
import exceptions.ModelNotFoundException;
import manager.IOUtils;
import manager.ModelManager;
import manager.MutatorUtils;
import manager.ProjectUtils;
import mutatorenvironment.AttributeEvaluation;
import mutatorenvironment.AttributeScalar;
import mutatorenvironment.AttributeType;
import mutatorenvironment.BinaryOperator;
import mutatorenvironment.Block;
import mutatorenvironment.CloneObjectMutator;
import mutatorenvironment.CreateObjectMutator;
import mutatorenvironment.Expression;
import mutatorenvironment.LogicOperator;
import mutatorenvironment.ModifyInformationMutator;
import mutatorenvironment.Mutator;
import mutatorenvironment.MutatorEnvironment;
import mutatorenvironment.MutatorenvironmentFactory;
import mutatorenvironment.ObSelectionStrategy;
import mutatorenvironment.Operator;
import mutatorenvironment.ReferenceEvaluation;
import mutatorenvironment.ReferenceInit;
import mutatorenvironment.RemoveObjectMutator;
import mutatorenvironment.RetypeObjectMutator;
import mutatorenvironment.SelectObjectMutator;
import mutatorenvironment.SpecificBooleanType;
import mutatorenvironment.SpecificDoubleType;
import mutatorenvironment.SpecificIntegerType;
import mutatorenvironment.SpecificStringType;

public class GenerateWodelMutationOperatorsWizard extends AbstractHandler {
	
	public class WodelMutationOperatorsWizard extends Wizard implements INewWizard {
		
		private ISelection selection;

		private IFile file = null;

		private Shell shell;
		
		private ExecutionEvent event;
		
		private GenerateWodelMutationOperatorsWizardPage _pageOne;
		
		private GenerateWodelMutationOperatorsFilterWizardPage _pageTwo;
		
		private static final String WIZARD_NAME = "Generate Wodel Mutation Operators Wizard";
		
		private final String WORKSPACE = ModelManager.getWorkspaceAbsolutePath();
		
		private final String PROJECT = ProjectUtils.getProject().getName();
		
		private final String OUTPUT = ModelManager.getOutputPath();

		private String metamodel = null;

		private List<EPackage> mutatorPackages = null;
		
		private List<EPackage> packages = null;
		
		private Resource model = null;
		
		/**
		 * Constructor for WodelWizard.
		 */
		public WodelMutationOperatorsWizard(Shell shell, ExecutionEvent event) {
			super();
			this.shell = shell;
			this.event = event;
			setWindowTitle(WIZARD_NAME);
			setNeedsProgressMonitor(true);
		}
		
		/**
		 * Adding the page to the wizard.
		 */
		@Override
		public void addPages() {
			try {
				super.addPages();
				Bundle bundle = Platform.getBundle("wodel.models");
				URL fileURL = bundle.getEntry("/models/MutatorEnvironment.ecore");
				String mutatorecore = FileLocator.resolve(fileURL).getFile();
				mutatorPackages = ModelManager.loadMetaModel(mutatorecore);
				IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getCurrentSelectionChecked(event);
				file = (IFile) selection.getFirstElement();
				IOUtils.copyFile(OUTPUT + "/" + file.getName().replace(".mutator", ".model"), OUTPUT + "/" + file.getName().replace(".mutator", ".model.bak"));
				model = ModelManager.loadModel(mutatorPackages, OUTPUT + "/" + file.getName().replace(".mutator", ".model"));
				metamodel = ModelManager.getMetaModel();
				packages = ModelManager.loadMetaModel(metamodel);
				_pageOne = new GenerateWodelMutationOperatorsWizardPage(selection, mutatorPackages, model, packages);
				_pageOne.setTitle("Generate Wodel Mutation Operators Wizard");
				_pageOne.setDescription("Generate Wodel Mutation Operators Wizard");
				addPage(_pageOne);
				_pageTwo = new GenerateWodelMutationOperatorsFilterWizardPage(selection, metamodel, mutatorPackages, model, packages);
				_pageTwo.setTitle("Generate Wodel Mutation Operators Filter Wizard");
				_pageTwo.setDescription("Generate Wodel Mutation Operators Filter Wizard");
				addPage(_pageTwo);
			} catch (MetaModelNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ModelNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		@Override
		public void init(IWorkbench workbench, IStructuredSelection selection) {
			setWindowTitle(WIZARD_NAME);
			setNeedsProgressMonitor(true);
			this.selection = selection;
			this.file = (IFile) selection.getFirstElement();
			addPages();
			
		}

		@Override
		public boolean performFinish() {
			IFile file = null;
			try {
				IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getCurrentSelectionChecked(event);
				file = (IFile) selection.getFirstElement();
			} catch (ExecutionException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			if (file == null) {
				return true;
			}
			
			MutatorEnvironment mutatorEnvironment = (MutatorEnvironment) model.getContents().get(0);
			mutatorEnvironment.getBlocks().clear();
			mutatorEnvironment.getCommands().clear();
			
			List<EClass> eClasses = ModelManager.getEClasses(packages);
			List<Block> blocks = new ArrayList<Block>();
			try {
				int i = 0;
				int j = 0;
				for (EClass eClass : eClasses) {
					if (_pageTwo.selectedElements.contains(eClass.getName())) {
						List<String> classWhereElements = _pageTwo.selectedWhereClassElements.get(j);
						List<Object> featureWhereValues = _pageTwo.selectedWhereClassValues.get(j);
						List<String> classWithElements = _pageTwo.selectedWithClassElements.get(j);
						List<Object> featureWithValues = _pageTwo.selectedWithClassValues.get(j);
						for (String wodelOperator : _pageOne.selectedWodelOperators) {
							List<Mutator> mutator = new ArrayList<Mutator>();
							List<Mutator> commands = new ArrayList<Mutator>();
							Block block = null;
							String blockName = "";
							blockName = "b" + i;
							i++;
							block = MutatorenvironmentFactory.eINSTANCE.createBlock();
							block.setName(blockName);
							blocks.add(block);
							if (wodelOperator.equals("select")) {
								SelectObjectMutator selectObjectMutator = MutatorenvironmentFactory.eINSTANCE.createSelectObjectMutator();
								ObSelectionStrategy obSelectionStrategy = null;
								if (_pageOne.strategyClass.equals("random")) {
									obSelectionStrategy = MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
								}
								if (_pageOne.strategyClass.equals("complete")) {
									obSelectionStrategy = MutatorenvironmentFactory.eINSTANCE.createCompleteTypeSelection();
								}
								obSelectionStrategy.setType(eClass);
								Expression expression = MutatorenvironmentFactory.eINSTANCE.createExpression();
								int k = 0;
								for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
									if (classWhereElements.contains(feature.getName())) {
										Object ob = featureWhereValues.get(k);
										k++;
										AttributeEvaluation attributeEvaluation = null;
										ReferenceEvaluation referenceEvaluation = null;
										if (feature instanceof EAttribute) {
											EAttribute attribute = (EAttribute) feature;
											attributeEvaluation = MutatorenvironmentFactory.eINSTANCE.createAttributeEvaluation();
											Operator operator = Operator.EQUALS;
											AttributeType attributeType = null;
											if (attribute.getEType().getName().equals("EString")) {
												SpecificStringType stringType = MutatorenvironmentFactory.eINSTANCE.createSpecificStringType();
												stringType.setOperator(operator);
												stringType.setValue((String) ob);
												attributeType = stringType;
											}
											if (attribute.getEType().getName().equals("EInt")) {
												SpecificIntegerType integerType = MutatorenvironmentFactory.eINSTANCE.createSpecificIntegerType();
												integerType.setOperator(operator);
												integerType.setValue(Integer.valueOf((String) ob));
												attributeType = integerType;
											}
											if (attribute.getEType().getName().equals("EBoolean")) {
												SpecificBooleanType booleanType = MutatorenvironmentFactory.eINSTANCE.createSpecificBooleanType();
												booleanType.setOperator(operator);
												booleanType.setValue((boolean) ob);
												attributeType = booleanType;
											}
											if (attribute.getEType().getName().equals("EDouble")) {
												SpecificDoubleType doubleType = MutatorenvironmentFactory.eINSTANCE.createSpecificDoubleType();
												doubleType.setOperator(operator);
												doubleType.setValue(Double.valueOf((String) ob));
												attributeType = doubleType;
											}
											attributeEvaluation.setName(attribute);
											attributeEvaluation.setValue(attributeType);
										}
										if (feature instanceof EReference) {
											EReference reference = (EReference) feature;
											referenceEvaluation = MutatorenvironmentFactory.eINSTANCE.createReferenceEvaluation();
											ObSelectionStrategy referenceStrategy = MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
											Operator operator = Operator.EQUALS;
											referenceStrategy.setType((EClass) reference.getEType());
											referenceEvaluation.setName(reference);
											referenceEvaluation.setOperator(operator);
											referenceEvaluation.setValue(referenceStrategy);
										}
										if (attributeEvaluation != null) {
											if (k == 1) {
												expression.setFirst(attributeEvaluation);
											}
											if (k > 1) {
												expression.getSecond().add(attributeEvaluation);
												BinaryOperator operator = MutatorenvironmentFactory.eINSTANCE.createBinaryOperator();
												operator.setType(LogicOperator.AND);
												expression.getOperator().add(operator);
											}
										}
										if (referenceEvaluation != null) {
											if (k == 1) {
												expression.setFirst(referenceEvaluation);
											}
											if (k > 1) {
												expression.getSecond().add(referenceEvaluation);
												BinaryOperator operator = MutatorenvironmentFactory.eINSTANCE.createBinaryOperator();
												operator.setType(LogicOperator.AND);
												expression.getOperator().add(operator);
											}
										}
										selectObjectMutator.setName("p");
										obSelectionStrategy.setExpression(expression);
										selectObjectMutator.setObject(obSelectionStrategy);
										mutator.add(selectObjectMutator);
									}
								}
							}
							if (wodelOperator.equals("create")) {
								CreateObjectMutator createObjectMutator = MutatorenvironmentFactory.eINSTANCE.createCreateObjectMutator();
								createObjectMutator.setType(eClass);
								AttributeScalar attributeScalar = null;
								ReferenceInit referenceInit = null;
								int k = 0;
								for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
									if (classWithElements.contains(feature.getName())) {
										Object ob = featureWithValues.get(k);
										k++;
										if (feature instanceof EAttribute) {
											EAttribute attribute = (EAttribute) feature;
											attributeScalar = MutatorenvironmentFactory.eINSTANCE.createAttributeScalar();
											attributeScalar.getAttribute().add(attribute);
											Operator operator = Operator.EQUALS;
											AttributeType attributeType = null;
											if (attribute.getEType().getName().equals("EString")) {
												SpecificStringType stringType = MutatorenvironmentFactory.eINSTANCE.createSpecificStringType();
												stringType.setOperator(operator);
												stringType.setValue((String) ob);
												attributeType = stringType;
											}
											if (attribute.getEType().getName().equals("EInt")) {
												SpecificIntegerType integerType = MutatorenvironmentFactory.eINSTANCE.createSpecificIntegerType();
												integerType.setOperator(operator);
												integerType.setValue(Integer.valueOf((String) ob));
												attributeType = integerType;
											}
											if (attribute.getEType().getName().equals("EBoolean")) {
												SpecificBooleanType booleanType = MutatorenvironmentFactory.eINSTANCE.createSpecificBooleanType();
												booleanType.setOperator(operator);
												booleanType.setValue((boolean) ob);
												attributeType = booleanType;
											}
											if (attribute.getEType().getName().equals("EDouble")) {
												SpecificDoubleType doubleType = MutatorenvironmentFactory.eINSTANCE.createSpecificDoubleType();
												doubleType.setOperator(operator);
												doubleType.setValue(Double.valueOf((String) ob));
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
										if (attributeScalar != null) {
											createObjectMutator.getAttributes().add(attributeScalar);
										}
										if (referenceInit != null) {
											createObjectMutator.getReferences().add(referenceInit);
										}
									}
								}
								mutator.add(createObjectMutator);
							}
							if (wodelOperator.equals("remove")) {
								RemoveObjectMutator removeObjectMutator = MutatorenvironmentFactory.eINSTANCE.createRemoveObjectMutator();
								ObSelectionStrategy obSelectionStrategy = null;
								if (_pageOne.strategyClass.equals("random")) {
									obSelectionStrategy = MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
								}
								if (_pageOne.strategyClass.equals("complete")) {
									obSelectionStrategy = MutatorenvironmentFactory.eINSTANCE.createCompleteTypeSelection();
								}
								obSelectionStrategy.setType(eClass);
								Expression expression = MutatorenvironmentFactory.eINSTANCE.createExpression();
								int k = 0;
								for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
									if (classWhereElements.contains(feature.getName())) {
										Object ob = featureWhereValues.get(k);
										k++;
										AttributeEvaluation attributeEvaluation = null;
										ReferenceEvaluation referenceEvaluation = null;
										if (feature instanceof EAttribute) {
											EAttribute attribute = (EAttribute) feature;
											attributeEvaluation = MutatorenvironmentFactory.eINSTANCE.createAttributeEvaluation();
											Operator operator = Operator.EQUALS;
											AttributeType attributeType = null;
											if (attribute.getEType().getName().equals("EString")) {
												SpecificStringType stringType = MutatorenvironmentFactory.eINSTANCE.createSpecificStringType();
												stringType.setOperator(operator);
												stringType.setValue((String) ob);
												attributeType = stringType;
											}
											if (attribute.getEType().getName().equals("EInt")) {
												SpecificIntegerType integerType = MutatorenvironmentFactory.eINSTANCE.createSpecificIntegerType();
												integerType.setOperator(operator);
												integerType.setValue(Integer.valueOf((String) ob));
												attributeType = integerType;
											}
											if (attribute.getEType().getName().equals("EBoolean")) {
												SpecificBooleanType booleanType = MutatorenvironmentFactory.eINSTANCE.createSpecificBooleanType();
												booleanType.setOperator(operator);
												booleanType.setValue((boolean) ob);
												attributeType = booleanType;
											}
											if (attribute.getEType().getName().equals("EDouble")) {
												SpecificDoubleType doubleType = MutatorenvironmentFactory.eINSTANCE.createSpecificDoubleType();
												doubleType.setOperator(operator);
												doubleType.setValue(Double.valueOf((String) ob));
												attributeType = doubleType;
											}
											attributeEvaluation.setName(attribute);
											attributeEvaluation.setValue(attributeType);
										}
										if (feature instanceof EReference) {
											EReference reference = (EReference) feature;
											referenceEvaluation = MutatorenvironmentFactory.eINSTANCE.createReferenceEvaluation();
											ObSelectionStrategy referenceStrategy = MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
											Operator operator = Operator.EQUALS;
											referenceStrategy.setType((EClass) reference.getEType());
											referenceEvaluation.setName(reference);
											referenceEvaluation.setOperator(operator);
											referenceEvaluation.setValue(referenceStrategy);
										}
										if (attributeEvaluation != null) {
											if (k == 1) {
												expression.setFirst(attributeEvaluation);
											}
											if (k > 1) {
												expression.getSecond().add(attributeEvaluation);
												BinaryOperator operator = MutatorenvironmentFactory.eINSTANCE.createBinaryOperator();
												operator.setType(LogicOperator.AND);
												expression.getOperator().add(operator);
											}
										}
										if (referenceEvaluation != null) {
											if (k == 1) {
												expression.setFirst(referenceEvaluation);
											}
											if (k > 1) {
												expression.getSecond().add(referenceEvaluation);
												BinaryOperator operator = MutatorenvironmentFactory.eINSTANCE.createBinaryOperator();
												operator.setType(LogicOperator.AND);
												expression.getOperator().add(operator);
											}
										}
										removeObjectMutator.setName("p");
										obSelectionStrategy.setExpression(expression);
									}
								}
								removeObjectMutator.setObject(obSelectionStrategy);
								mutator.add(removeObjectMutator);
							}
							if (wodelOperator.equals("modify")) {
								ModifyInformationMutator modifyInformationMutator = MutatorenvironmentFactory.eINSTANCE.createModifyInformationMutator();
								ObSelectionStrategy obSelectionStrategy = null;
								if (_pageOne.strategyClass.equals("random")) {
									obSelectionStrategy = MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
								}
								if (_pageOne.strategyClass.equals("complete")) {
									obSelectionStrategy = MutatorenvironmentFactory.eINSTANCE.createCompleteTypeSelection();
								}
								obSelectionStrategy.setType(eClass);
								Expression expression = MutatorenvironmentFactory.eINSTANCE.createExpression();
								int k = 0;
								for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
									if (classWhereElements.contains(feature.getName())) {
										Object ob = featureWhereValues.get(k);
										k++;
										AttributeEvaluation attributeEvaluation = null;
										ReferenceEvaluation referenceEvaluation = null;
										if (feature instanceof EAttribute) {
											EAttribute attribute = (EAttribute) feature;
											attributeEvaluation = MutatorenvironmentFactory.eINSTANCE.createAttributeEvaluation();
											Operator operator = Operator.EQUALS;
											AttributeType attributeType = null;
											if (attribute.getEType().getName().equals("EString")) {
												SpecificStringType stringType = MutatorenvironmentFactory.eINSTANCE.createSpecificStringType();
												stringType.setOperator(operator);
												stringType.setValue((String) ob);
												attributeType = stringType;
											}
											if (attribute.getEType().getName().equals("EInt")) {
												SpecificIntegerType integerType = MutatorenvironmentFactory.eINSTANCE.createSpecificIntegerType();
												integerType.setOperator(operator);
												integerType.setValue(Integer.valueOf((String) ob));
												attributeType = integerType;
											}
											if (attribute.getEType().getName().equals("EBoolean")) {
												SpecificBooleanType booleanType = MutatorenvironmentFactory.eINSTANCE.createSpecificBooleanType();
												booleanType.setOperator(operator);
												booleanType.setValue((boolean) ob);
												attributeType = booleanType;
											}
											if (attribute.getEType().getName().equals("EDouble")) {
												SpecificDoubleType doubleType = MutatorenvironmentFactory.eINSTANCE.createSpecificDoubleType();
												doubleType.setOperator(operator);
												doubleType.setValue(Double.valueOf((String) ob));
												attributeType = doubleType;
											}
											attributeEvaluation.setName(attribute);
											attributeEvaluation.setValue(attributeType);
										}
										if (feature instanceof EReference) {
											EReference reference = (EReference) feature;
											referenceEvaluation = MutatorenvironmentFactory.eINSTANCE.createReferenceEvaluation();
											ObSelectionStrategy referenceStrategy = MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
											Operator operator = Operator.EQUALS;
											referenceStrategy.setType((EClass) reference.getEType());
											referenceEvaluation.setName(reference);
											referenceEvaluation.setOperator(operator);
											referenceEvaluation.setValue(referenceStrategy);
										}
										if (attributeEvaluation != null) {
											if (k == 1) {
												expression.setFirst(attributeEvaluation);
											}
											if (k > 1) {
												expression.getSecond().add(attributeEvaluation);
												BinaryOperator operator = MutatorenvironmentFactory.eINSTANCE.createBinaryOperator();
												operator.setType(LogicOperator.AND);
												expression.getOperator().add(operator);
											}
										}
										if (referenceEvaluation != null) {
											if (k == 1) {
												expression.setFirst(referenceEvaluation);
											}
											if (k > 1) {
												expression.getSecond().add(referenceEvaluation);
												BinaryOperator operator = MutatorenvironmentFactory.eINSTANCE.createBinaryOperator();
												operator.setType(LogicOperator.AND);
												expression.getOperator().add(operator);
											}
										}
										modifyInformationMutator.setName("p");
										obSelectionStrategy.setExpression(expression);
									}
								}
								AttributeScalar attributeScalar = null;
								ReferenceInit referenceInit = null;
								int l = 0;
								for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
									if (classWithElements.contains(feature.getName())) {
										Object ob = featureWithValues.get(l);
										l++;
										if (feature instanceof EAttribute) {
											EAttribute attribute = (EAttribute) feature;
											attributeScalar = MutatorenvironmentFactory.eINSTANCE.createAttributeScalar();
											attributeScalar.getAttribute().add(attribute);
											Operator operator = Operator.EQUALS;
											AttributeType attributeType = null;
											if (attribute.getEType().getName().equals("EString")) {
												SpecificStringType stringType = MutatorenvironmentFactory.eINSTANCE.createSpecificStringType();
												stringType.setOperator(operator);
												stringType.setValue((String) ob);
												attributeType = stringType;
											}
											if (attribute.getEType().getName().equals("EInt")) {
												SpecificIntegerType integerType = MutatorenvironmentFactory.eINSTANCE.createSpecificIntegerType();
												integerType.setOperator(operator);
												integerType.setValue(Integer.valueOf((String) ob));
												attributeType = integerType;
											}
											if (attribute.getEType().getName().equals("EBoolean")) {
												SpecificBooleanType booleanType = MutatorenvironmentFactory.eINSTANCE.createSpecificBooleanType();
												booleanType.setOperator(operator);
												booleanType.setValue((boolean) ob);
												attributeType = booleanType;
											}
											if (attribute.getEType().getName().equals("EDouble")) {
												SpecificDoubleType doubleType = MutatorenvironmentFactory.eINSTANCE.createSpecificDoubleType();
												doubleType.setOperator(operator);
												doubleType.setValue(Double.valueOf((String) ob));
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
										obSelectionStrategy.setType(eClass);
										if (attributeScalar != null) {
											modifyInformationMutator.getAttributes().add(attributeScalar);
										}
										if (referenceInit != null) {
											modifyInformationMutator.getReferences().add(referenceInit);
										}
									}
								}
								modifyInformationMutator.setObject(obSelectionStrategy);
								mutator.add(modifyInformationMutator);
							}
							if (wodelOperator.equals("clone")) {
								CloneObjectMutator cloneObjectMutator = MutatorenvironmentFactory.eINSTANCE.createCloneObjectMutator();
								cloneObjectMutator.setContents(true);
								ObSelectionStrategy obSelectionStrategy = null;
								if (_pageOne.strategyClass.equals("random")) {
									obSelectionStrategy = MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
								}
								if (_pageOne.strategyClass.equals("complete")) {
									obSelectionStrategy = MutatorenvironmentFactory.eINSTANCE.createCompleteTypeSelection();
								}
								obSelectionStrategy.setType(eClass);
								Expression expression = MutatorenvironmentFactory.eINSTANCE.createExpression();
								int k = 0;
								for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
									if (classWhereElements.contains(feature.getName())) {
										Object ob = featureWhereValues.get(k);
										k++;
										AttributeEvaluation attributeEvaluation = null;
										ReferenceEvaluation referenceEvaluation = null;
										if (feature instanceof EAttribute) {
											EAttribute attribute = (EAttribute) feature;
											attributeEvaluation = MutatorenvironmentFactory.eINSTANCE.createAttributeEvaluation();
											Operator operator = Operator.EQUALS;
											AttributeType attributeType = null;
											if (attribute.getEType().getName().equals("EString")) {
												SpecificStringType stringType = MutatorenvironmentFactory.eINSTANCE.createSpecificStringType();
												stringType.setOperator(operator);
												stringType.setValue((String) ob);
												attributeType = stringType;
											}
											if (attribute.getEType().getName().equals("EInt")) {
												SpecificIntegerType integerType = MutatorenvironmentFactory.eINSTANCE.createSpecificIntegerType();
												integerType.setOperator(operator);
												integerType.setValue(Integer.valueOf((String) ob));
												attributeType = integerType;
											}
											if (attribute.getEType().getName().equals("EBoolean")) {
												SpecificBooleanType booleanType = MutatorenvironmentFactory.eINSTANCE.createSpecificBooleanType();
												booleanType.setOperator(operator);
												booleanType.setValue((boolean) ob);
												attributeType = booleanType;
											}
											if (attribute.getEType().getName().equals("EDouble")) {
												SpecificDoubleType doubleType = MutatorenvironmentFactory.eINSTANCE.createSpecificDoubleType();
												doubleType.setOperator(operator);
												doubleType.setValue(Double.valueOf((String) ob));
												attributeType = doubleType;
											}
											attributeEvaluation.setName(attribute);
											attributeEvaluation.setValue(attributeType);
										}
										if (feature instanceof EReference) {
											EReference reference = (EReference) feature;
											referenceEvaluation = MutatorenvironmentFactory.eINSTANCE.createReferenceEvaluation();
											ObSelectionStrategy referenceStrategy = MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
											Operator operator = Operator.EQUALS;
											referenceStrategy.setType((EClass) reference.getEType());
											referenceEvaluation.setName(reference);
											referenceEvaluation.setOperator(operator);
											referenceEvaluation.setValue(referenceStrategy);
										}
										if (attributeEvaluation != null) {
											if (k == 1) {
												expression.setFirst(attributeEvaluation);
											}
											if (k > 1) {
												expression.getSecond().add(attributeEvaluation);
												BinaryOperator operator = MutatorenvironmentFactory.eINSTANCE.createBinaryOperator();
												operator.setType(LogicOperator.AND);
												expression.getOperator().add(operator);
											}
										}
										if (referenceEvaluation != null) {
											if (k == 1) {
												expression.setFirst(referenceEvaluation);
											}
											if (k > 1) {
												expression.getSecond().add(referenceEvaluation);
												BinaryOperator operator = MutatorenvironmentFactory.eINSTANCE.createBinaryOperator();
												operator.setType(LogicOperator.AND);
												expression.getOperator().add(operator);
											}
										}
										cloneObjectMutator.setName("p");
										obSelectionStrategy.setExpression(expression);
									}
								}
								AttributeScalar attributeScalar = null;
								ReferenceInit referenceInit = null;
								int l = 0;
								for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
									if (classWithElements.contains(feature.getName())) {
										Object ob = featureWithValues.get(l);
										l++;
										if (feature instanceof EAttribute) {
											EAttribute attribute = (EAttribute) feature;
											attributeScalar = MutatorenvironmentFactory.eINSTANCE.createAttributeScalar();
											attributeScalar.getAttribute().add(attribute);
											Operator operator = Operator.EQUALS;
											AttributeType attributeType = null;
											if (attribute.getEType().getName().equals("EString")) {
												SpecificStringType stringType = MutatorenvironmentFactory.eINSTANCE.createSpecificStringType();
												stringType.setOperator(operator);
												stringType.setValue((String) ob);
												attributeType = stringType;
											}
											if (attribute.getEType().getName().equals("EInt")) {
												SpecificIntegerType integerType = MutatorenvironmentFactory.eINSTANCE.createSpecificIntegerType();
												integerType.setOperator(operator);
												integerType.setValue(Integer.valueOf((String) ob));
												attributeType = integerType;
											}
											if (attribute.getEType().getName().equals("EBoolean")) {
												SpecificBooleanType booleanType = MutatorenvironmentFactory.eINSTANCE.createSpecificBooleanType();
												booleanType.setOperator(operator);
												booleanType.setValue((boolean) ob);
												attributeType = booleanType;
											}
											if (attribute.getEType().getName().equals("EDouble")) {
												SpecificDoubleType doubleType = MutatorenvironmentFactory.eINSTANCE.createSpecificDoubleType();
												doubleType.setOperator(operator);
												doubleType.setValue(Double.valueOf((String) ob));
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
										if (attributeScalar != null) {
											cloneObjectMutator.getAttributes().add(attributeScalar);
										}
										if (referenceInit != null) {
											cloneObjectMutator.getReferences().add(referenceInit);
										}
									}
								}
								cloneObjectMutator.setObject(obSelectionStrategy);
								mutator.add(cloneObjectMutator);
							}
							if (wodelOperator.equals("retype")) {
								RetypeObjectMutator retypeObjectMutator = MutatorenvironmentFactory.eINSTANCE.createRetypeObjectMutator();
								ObSelectionStrategy obSelectionStrategy = null;
								if (_pageOne.strategyClass.equals("random")) {
									obSelectionStrategy = MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
								}
								if (_pageOne.strategyClass.equals("complete")) {
									obSelectionStrategy = MutatorenvironmentFactory.eINSTANCE.createCompleteTypeSelection();
								}
								obSelectionStrategy.setType(eClass);
								retypeObjectMutator.setObject(obSelectionStrategy);
								List<EClass> siblingEClasses = ModelManager.getSiblingEClasses(metamodel, MutatorUtils.getStrategyTypes(retypeObjectMutator.getObject()));
								List<EClass> classesToAdd = new ArrayList<EClass>();
								for (EClass sibCl : siblingEClasses) {
									EClassifier classifier = eClass.getEPackage().getEClassifier(sibCl.getName());
									if (classifier instanceof EClass) {
										classesToAdd.add((EClass) classifier);
									}
								}
								retypeObjectMutator.getTypes().addAll(classesToAdd);
								Expression expression = MutatorenvironmentFactory.eINSTANCE.createExpression();
								int k = 0;
								for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
									if (classWhereElements.contains(feature.getName())) {
										Object ob = featureWhereValues.get(k);
										k++;
										AttributeEvaluation attributeEvaluation = null;
										ReferenceEvaluation referenceEvaluation = null;
										if (feature instanceof EAttribute) {
											EAttribute attribute = (EAttribute) feature;
											attributeEvaluation = MutatorenvironmentFactory.eINSTANCE.createAttributeEvaluation();
											Operator operator = Operator.EQUALS;
											AttributeType attributeType = null;
											if (attribute.getEType().getName().equals("EString")) {
												SpecificStringType stringType = MutatorenvironmentFactory.eINSTANCE.createSpecificStringType();
												stringType.setOperator(operator);
												stringType.setValue((String) ob);
												attributeType = stringType;
											}
											if (attribute.getEType().getName().equals("EInt")) {
												SpecificIntegerType integerType = MutatorenvironmentFactory.eINSTANCE.createSpecificIntegerType();
												integerType.setOperator(operator);
												integerType.setValue(Integer.valueOf((String) ob));
												attributeType = integerType;
											}
											if (attribute.getEType().getName().equals("EBoolean")) {
												SpecificBooleanType booleanType = MutatorenvironmentFactory.eINSTANCE.createSpecificBooleanType();
												booleanType.setOperator(operator);
												booleanType.setValue((boolean) ob);
												attributeType = booleanType;
											}
											if (attribute.getEType().getName().equals("EDouble")) {
												SpecificDoubleType doubleType = MutatorenvironmentFactory.eINSTANCE.createSpecificDoubleType();
												doubleType.setOperator(operator);
												doubleType.setValue(Double.valueOf((String) ob));
												attributeType = doubleType;
											}
											attributeEvaluation.setName(attribute);
											attributeEvaluation.setValue(attributeType);
										}
										if (feature instanceof EReference) {
											EReference reference = (EReference) feature;
											referenceEvaluation = MutatorenvironmentFactory.eINSTANCE.createReferenceEvaluation();
											ObSelectionStrategy referenceStrategy = MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
											Operator operator = Operator.EQUALS;
											referenceStrategy.setType((EClass) reference.getEType());
											referenceEvaluation.setName(reference);
											referenceEvaluation.setOperator(operator);
											referenceEvaluation.setValue(referenceStrategy);
										}
										if (attributeEvaluation != null) {
											if (k == 1) {
												expression.setFirst(attributeEvaluation);
											}
											if (k > 1) {
												expression.getSecond().add(attributeEvaluation);
												BinaryOperator operator = MutatorenvironmentFactory.eINSTANCE.createBinaryOperator();
												operator.setType(LogicOperator.AND);
												expression.getOperator().add(operator);
											}
										}
										if (referenceEvaluation != null) {
											if (k == 1) {
												expression.setFirst(referenceEvaluation);
											}
											if (k > 1) {
												expression.getSecond().add(referenceEvaluation);
												BinaryOperator operator = MutatorenvironmentFactory.eINSTANCE.createBinaryOperator();
												operator.setType(LogicOperator.AND);
												expression.getOperator().add(operator);
											}
										}
										retypeObjectMutator.setName("p");
										obSelectionStrategy.setExpression(expression);
									}
								}
								AttributeScalar attributeScalar = null;
								ReferenceInit referenceInit = null;
								int l = 0;
								for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
									if (classWithElements.contains(feature.getName())) {
										Object ob = featureWithValues.get(l);
										l++;
										if (feature instanceof EAttribute) {
											EAttribute attribute = (EAttribute) feature;
											attributeScalar = MutatorenvironmentFactory.eINSTANCE.createAttributeScalar();
											attributeScalar.getAttribute().add(attribute);
											Operator operator = Operator.EQUALS;
											AttributeType attributeType = null;
											if (attribute.getEType().getName().equals("EString")) {
												SpecificStringType stringType = MutatorenvironmentFactory.eINSTANCE.createSpecificStringType();
												stringType.setOperator(operator);
												stringType.setValue((String) ob);
												attributeType = stringType;
											}
											if (attribute.getEType().getName().equals("EInt")) {
												SpecificIntegerType integerType = MutatorenvironmentFactory.eINSTANCE.createSpecificIntegerType();
												integerType.setOperator(operator);
												integerType.setValue(Integer.valueOf((String) ob));
												attributeType = integerType;
											}
											if (attribute.getEType().getName().equals("EBoolean")) {
												SpecificBooleanType booleanType = MutatorenvironmentFactory.eINSTANCE.createSpecificBooleanType();
												booleanType.setOperator(operator);
												booleanType.setValue((boolean) ob);
												attributeType = booleanType;
											}
											if (attribute.getEType().getName().equals("EDouble")) {
												SpecificDoubleType doubleType = MutatorenvironmentFactory.eINSTANCE.createSpecificDoubleType();
												doubleType.setOperator(operator);
												doubleType.setValue(Double.valueOf((String) ob));
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
										if (attributeScalar != null) {
											retypeObjectMutator.getAttributes().add(attributeScalar);
										}
										if (referenceInit != null) {
											retypeObjectMutator.getReferences().add(referenceInit);
										}
									}
								}
								mutator.add(retypeObjectMutator);
							}
							commands.addAll(mutator);
							block.getCommands().addAll(commands);
						}
						j++;
					}
				}

				List<Block> processedBlocks = new ArrayList<Block>();
				for (Block block : blocks) {
					if (block.getCommands().size() > 0) {
						processedBlocks.add(block);
					}
				}
				mutatorEnvironment.getBlocks().addAll(processedBlocks);

				ModelManager.saveModel(model, "file:/" + OUTPUT + "/" + file.getName().replace(".mutator", ".model"));
				
				//Reload input
				try {
					model.unload();
					model.load(null);
				} catch (Exception e) {}
				
				EObject root = ModelManager.getRoot(model);
				String mutatorCode = WodelUtils.deserialize("file:/" + WORKSPACE + "/" + PROJECT + "/src/" + file.getName(), root);

				int index = 0;
				String mutatorFileName = WORKSPACE + "/" + PROJECT + "/src/" + file.getName().replace(".mutator", "_auto" + index + ".mutator");
				File mutatorFile = new File(mutatorFileName);
				while (mutatorFile.exists() && mutatorFile.isFile()) {
					index++;
					mutatorFileName = WORKSPACE + "/" + PROJECT + "/src/" + file.getName().replace(".mutator", "_auto" + index + ".mutator");
					mutatorFile = new File(mutatorFileName);
				}
				FileWriter fileWriter = new FileWriter(mutatorFileName);
				BufferedWriter writer = new BufferedWriter(fileWriter);
				writer.write(mutatorCode);
				writer.close();
				fileWriter.close();
				IOUtils.copyFile(OUTPUT + "/" + file.getName().replace(".mutator", ".model.bak"), OUTPUT + "/" + file.getName().replace(".mutator", ".model"));
				IOUtils.deleteFile(OUTPUT + "/" + file.getName().replace(".mutator", ".model.bak"));
				
				//Refresh project
				ResourcesPlugin.getWorkspace().getRoot().getProject(PROJECT).refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
				
				IEditorPart editor = null;
				if (mutatorFile.exists() && mutatorFile.isFile()) {
					IFileStore fileStore = EFS.getLocalFileSystem().getStore(mutatorFile.toURI());
					IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			 
					try {
						editor = IDE.openEditorOnFileStore( page, fileStore );
					} catch ( PartInitException e ) {
						//Put your exception handler here if you wish to
					}
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (CoreException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
			}

			return true;
		}
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Shell shell = HandlerUtil.getActiveShell(event);
		WodelMutationOperatorsWizard wodelMutationOperatorsWizard = new WodelMutationOperatorsWizard(shell, event);
		WizardDialog wd = new WizardDialog(shell, wodelMutationOperatorsWizard);
		wd.setTitle(wodelMutationOperatorsWizard.getWindowTitle());
		wd.open();
		return null;
	}

}
