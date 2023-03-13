package wodel.run.popup.actions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import wodel.utils.exceptions.MetaModelNotFoundException;
import wodel.utils.exceptions.ModelNotFoundException;
import wodel.utils.manager.IOUtils;
import wodel.utils.manager.ModelManager;
import wodel.utils.manager.MutatorUtils;
import wodel.utils.manager.ProjectUtils;
import mutatorenvironment.AttributeEvaluation;
import mutatorenvironment.AttributeEvaluationType;
import mutatorenvironment.AttributeScalar;
import mutatorenvironment.AttributeType;
import mutatorenvironment.BinaryOperator;
import mutatorenvironment.Block;
import mutatorenvironment.CloneObjectMutator;
import mutatorenvironment.CreateObjectMutator;
import mutatorenvironment.Expression;
import mutatorenvironment.ListStringType;
import mutatorenvironment.LogicOperator;
import mutatorenvironment.ModifyInformationMutator;
import mutatorenvironment.Mutator;
import mutatorenvironment.MutatorEnvironment;
import mutatorenvironment.MutatorenvironmentFactory;
import mutatorenvironment.MutatorenvironmentPackage;
import mutatorenvironment.ObSelectionStrategy;
import mutatorenvironment.Operator;
import mutatorenvironment.Program;
import mutatorenvironment.RandomBooleanType;
import mutatorenvironment.RandomDoubleType;
import mutatorenvironment.RandomIntegerType;
import mutatorenvironment.RandomStringType;
import mutatorenvironment.ReferenceEvaluation;
import mutatorenvironment.ReferenceInit;
import mutatorenvironment.RemoveObjectMutator;
import mutatorenvironment.RetypeObjectMutator;
import mutatorenvironment.SelectObjectMutator;
import mutatorenvironment.Source;
import mutatorenvironment.SpecificBooleanType;
import mutatorenvironment.SpecificDoubleType;
import mutatorenvironment.SpecificIntegerType;

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
				URL fileURL = bundle.getEntry("/model/MutatorEnvironment.ecore");
				String mutatorecore = FileLocator.resolve(fileURL).getFile();
				mutatorPackages = ModelManager.loadMetaModel(mutatorecore);
				IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getCurrentSelectionChecked(event);
				file = (IFile) selection.getFirstElement();
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
			
			MutatorEnvironment previousMutatorEnvironment = (MutatorEnvironment) model.getContents().get(0);
			Program previousProgram = (Program) previousMutatorEnvironment.getDefinition();
			Source previousSource = previousProgram.getSource();

			//MutatorenvironmentPackage.eINSTANCE.getClass();

			List<Resource> wodelModels = new ArrayList<Resource>();
			wodelModels.addAll(ModelManager.getModelsNoException(metamodel, WORKSPACE + "/" + previousSource.getPath()));
			
			MutatorEnvironment mutatorEnvironment = MutatorenvironmentFactory.eINSTANCE.createMutatorEnvironment();
			Program program = MutatorenvironmentFactory.eINSTANCE.createProgram();
			program.setExhaustive(previousProgram.isExhaustive());
			program.setMetamodel(previousProgram.getMetamodel());
			program.setNum(0);
			program.setOutput(previousProgram.getOutput());
			Source source = MutatorenvironmentFactory.eINSTANCE.createSource();
			source.setPath(previousSource.getPath());
			program.setSource(source);
			mutatorEnvironment.setDefinition(program);

//			MutatorEnvironment mutatorEnvironment = (MutatorEnvironment) model.getContents().get(0);

			mutatorEnvironment.getBlocks().clear();
			mutatorEnvironment.getCommands().clear();
			
			List<EClass> eClasses = ModelManager.getEClasses(packages);
			EClass rootClass = ModelManager.getRootEClass(packages);
			rootClass.getEPackage().getClass();
			List<Block> blocks = new ArrayList<Block>();
			try {
				int i = 0;
				for (EClass eClass : eClasses) {
					if (eClass.isAbstract() == true) {
						continue;
					}
					if (_pageTwo.selectedElements.contains(eClass.getName())) {
						int j = _pageTwo.selectedElements.indexOf(eClass.getName());
						System.out.println("Generation of mutation operators for the class: " + eClass.getName());
						List<String> classWhereElements = _pageTwo.selectedWhereClassElements.get(j);
						List<List<Object>> featureWhereValues = _pageTwo.selectedWhereClassValues.get(j);
						List<String> classWithElements = _pageTwo.selectedWithClassElements.get(j);
						List<List<Object>> featureWithValues = _pageTwo.selectedWithClassValues.get(j);
						for (String wodelOperator : _pageOne.selectedWodelOperators) {
							List<Mutator> mutator = new ArrayList<Mutator>();
							List<Mutator> commands = new ArrayList<Mutator>();
							Block block = null;
							String blockName = "";
							blockName = "b" + i;
							block = MutatorenvironmentFactory.eINSTANCE.createBlock();
							block.setName(blockName);
							if (wodelOperator.equals("select")) {
								System.out.println(eClass.getName() + " ----- Selection mutation operator");
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
								int mAtt = 0;
								List<AttributeEvaluation> listAttributeEvaluation = new ArrayList<AttributeEvaluation>();
								for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
									if (classWhereElements.contains(feature.getName())) {
										List<Object> lob = featureWhereValues.get(k);
										k++;
										if (feature instanceof EAttribute) {
											AttributeEvaluation attributeEvaluation = MutatorenvironmentFactory.eINSTANCE.createAttributeEvaluation();
											EAttribute attribute = (EAttribute) feature;
											AttributeEvaluationType attributeType = null;
											for (Object ob : lob) {
												if (attribute.getEType().getName().equals("EString")) {
													ListStringType stringType = null;
													if (attributeType == null) {
														Operator operator = Operator.IN;
														stringType = MutatorenvironmentFactory.eINSTANCE.createListStringType();
														stringType.setOperator(operator);
														attributeType = stringType;
													}
													else {
														stringType = (ListStringType) attributeType;
													}
													stringType.getValue().add(((String) ob).replace("\\n", ""));
												}
												if (attribute.getEType().getName().equals("EInt")) {
													SpecificIntegerType integerType = null;
													if (attributeType == null) {
														Operator operator = Operator.EQUALS;
														integerType = MutatorenvironmentFactory.eINSTANCE.createSpecificIntegerType();
														integerType.setOperator(operator);
														attributeType = integerType;
													}
													else {
														integerType = (SpecificIntegerType) attributeType;
													}
													integerType.setValue((int) ob);
												}
												if (attribute.getEType().getName().equals("EBoolean")) {
													SpecificBooleanType booleanType = null;
													if (attributeType == null) {
														Operator operator = Operator.EQUALS;
														booleanType = MutatorenvironmentFactory.eINSTANCE.createSpecificBooleanType();
														booleanType.setOperator(operator);
														attributeType = booleanType;
													}
													else {
														booleanType = (SpecificBooleanType) attributeType;
													}
													booleanType.setValue((boolean) ob);
												}
												if (attribute.getEType().getName().equals("EDouble")) {
													SpecificDoubleType doubleType = null;
													if (attributeType == null) {
														Operator operator = Operator.EQUALS;
														doubleType = MutatorenvironmentFactory.eINSTANCE.createSpecificDoubleType();
														doubleType.setOperator(operator);
														attributeType = doubleType;
													}
													doubleType.setValue((double) ob);
												}
												if (attributeType != null) {
													attributeEvaluation.setName(attribute);
													attributeEvaluation.setValue(attributeType);
												}
											}
											if (attributeType != null) {
												listAttributeEvaluation.add(attributeEvaluation);
											}
										}
									}
								}
								mAtt = 0;
								if (listAttributeEvaluation != null && listAttributeEvaluation.size() > 0) {
									for (AttributeEvaluation attributeEvaluation : listAttributeEvaluation) {
										if (attributeEvaluation != null && attributeEvaluation.getValue() != null) {
											if (mAtt == 0) {
												expression.setFirst(attributeEvaluation);
											}
											if (mAtt > 0) {
												expression.getSecond().add(attributeEvaluation);
												BinaryOperator operator = MutatorenvironmentFactory.eINSTANCE.createBinaryOperator();
												operator.setType(LogicOperator.OR);
												expression.getOperator().add(operator);
											}
											mAtt++;
										}
									}
								}
								k = 0;
								int mRef = 0;
								List<ReferenceEvaluation> listReferenceEvaluation = new ArrayList<ReferenceEvaluation>();
								for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
									if (classWhereElements.contains(feature.getName())) {
										k++;
										if (feature instanceof EReference) {
											ReferenceEvaluation referenceEvaluation = MutatorenvironmentFactory.eINSTANCE.createReferenceEvaluation();
											EReference reference = (EReference) feature;
											ObSelectionStrategy referenceStrategy = MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
											Operator operator = Operator.EQUALS;
											referenceStrategy.setType((EClass) reference.getEType());
											referenceEvaluation.setName(reference);
											referenceEvaluation.setOperator(operator);
											referenceEvaluation.setValue(referenceStrategy);
											if (referenceEvaluation != null) {
												listReferenceEvaluation.add(referenceEvaluation);
											}
										}
									}
								}
								mRef = 0;
								if (listReferenceEvaluation != null && listReferenceEvaluation.size() > 0) {
									for (ReferenceEvaluation referenceEvaluation : listReferenceEvaluation) {
										if (referenceEvaluation != null && referenceEvaluation.getValue() != null) {
											if (mAtt == 0 && mRef == 0) {
												expression.setFirst(referenceEvaluation);
											}
											if (mAtt > 0 || mRef > 0) {
												expression.getSecond().add(referenceEvaluation);
												BinaryOperator operator = MutatorenvironmentFactory.eINSTANCE.createBinaryOperator();
												operator.setType(LogicOperator.OR);
												expression.getOperator().add(operator);
											}
											mRef++;
										}
									}
								}
								selectObjectMutator.setName("p");
								if (mAtt > 0 || mRef > 0) {
									obSelectionStrategy.setExpression(expression);
								}
								selectObjectMutator.setObject(obSelectionStrategy);
								mutator.add(selectObjectMutator);
							}
							if (wodelOperator.equals("create")) {
								System.out.println(eClass.getName() + " ----- Creation mutation operator");
								CreateObjectMutator createObjectMutator = MutatorenvironmentFactory.eINSTANCE.createCreateObjectMutator();
								createObjectMutator.setType(eClass);
								int k = 0;
								for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
									if (classWithElements.contains(feature.getName())) {
										List<Object> lob = featureWithValues.get(k);
										k++;
										if (feature instanceof EAttribute) {
											EAttribute attribute = (EAttribute) feature;
											AttributeType attributeType = null;
											AttributeScalar attributeScalar = MutatorenvironmentFactory.eINSTANCE.createAttributeScalar();
											attributeScalar.getAttribute().add(attribute);
											for (Object ob : lob) {
												if (attribute.getEType().getName().equals("EString")) {
													ListStringType stringType = null;
													if (attributeType == null) {
														Operator operator = Operator.IN;
														stringType = MutatorenvironmentFactory.eINSTANCE.createListStringType();
														stringType.setOperator(operator);
														attributeType = stringType;
													}
													else {
														stringType = (ListStringType) attributeType;
													}
													stringType.getValue().add(((String) ob).replace("\\n", ""));
												}
												if (attribute.getEType().getName().equals("EInt")) {
													SpecificIntegerType integerType = null;
													if (attributeType == null) {
														Operator operator = Operator.EQUALS;
														integerType = MutatorenvironmentFactory.eINSTANCE.createSpecificIntegerType();
														integerType.setOperator(operator);
														attributeType = integerType;
													}
													else {
														integerType = (SpecificIntegerType) attributeType;
													}
													integerType.setValue((int) ob);
												}
												if (attribute.getEType().getName().equals("EBoolean")) {
													SpecificBooleanType booleanType = null;
													if (attributeType == null) {
														Operator operator = Operator.EQUALS;
														booleanType = MutatorenvironmentFactory.eINSTANCE.createSpecificBooleanType();
														booleanType.setOperator(operator);
														attributeType = booleanType;
													}
													else {
														booleanType = (SpecificBooleanType) attributeType;
													}
													booleanType.setValue((boolean) ob);
												}
												if (attribute.getEType().getName().equals("EDouble")) {
													SpecificDoubleType doubleType = null;
													if (attributeType == null) {
														Operator operator = Operator.EQUALS;
														doubleType = MutatorenvironmentFactory.eINSTANCE.createSpecificDoubleType();
														doubleType.setOperator(operator);
														attributeType = doubleType;
													}
													doubleType.setValue((double) ob);
												}
											}
											if (attributeType != null) {
												attributeScalar.setValue(attributeType);
											}
											if (attributeScalar != null && attributeScalar.getValue() != null) {
												createObjectMutator.getAttributes().add(attributeScalar);
											}
										}
									}
								}
								k = 0;
								for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
									if (classWithElements.contains(feature.getName())) {
										k++;
										if (feature instanceof EReference) {
											ReferenceInit referenceInit = null;
											EReference reference = (EReference) feature;
											referenceInit = MutatorenvironmentFactory.eINSTANCE.createReferenceInit();
											ObSelectionStrategy referenceStrategy = MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
											referenceStrategy.setType((EClass) reference.getEType());
											referenceInit.setObject(referenceStrategy);
											referenceInit.getReference().add(reference);
											if (referenceInit != null) {
												createObjectMutator.getReferences().add(referenceInit);
											}
										}
									}
								}
								k = 0;
								mutator.add(createObjectMutator);
							}
							if (wodelOperator.equals("remove")) {
								System.out.println(eClass.getName() + " ----- Deletion mutation operator");
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
								int mAtt = 0;
								List<AttributeEvaluation> listAttributeEvaluation = new ArrayList<AttributeEvaluation>();
								for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
									if (classWhereElements.contains(feature.getName())) {
										List<Object> lob = featureWhereValues.get(k);
										k++;
										if (feature instanceof EAttribute) {
											AttributeEvaluation attributeEvaluation = MutatorenvironmentFactory.eINSTANCE.createAttributeEvaluation();
											EAttribute attribute = (EAttribute) feature;
											AttributeEvaluationType attributeType = null;
											for (Object ob : lob) {
												if (attribute.getEType().getName().equals("EString")) {
													ListStringType stringType = null;
													if (attributeType == null) {
														Operator operator = Operator.IN;
														stringType = MutatorenvironmentFactory.eINSTANCE.createListStringType();
														stringType.setOperator(operator);
														attributeType = stringType;
													}
													else {
														stringType = (ListStringType) attributeType;
													}
													stringType.getValue().add(((String) ob).replace("\\n", ""));
												}
												if (attribute.getEType().getName().equals("EInt")) {
													SpecificIntegerType integerType = null;
													if (attributeType == null) {
														Operator operator = Operator.EQUALS;
														integerType = MutatorenvironmentFactory.eINSTANCE.createSpecificIntegerType();
														integerType.setOperator(operator);
														attributeType = integerType;
													}
													else {
														integerType = (SpecificIntegerType) attributeType;
													}
													integerType.setValue((int) ob);
												}
												if (attribute.getEType().getName().equals("EBoolean")) {
													SpecificBooleanType booleanType = null;
													if (attributeType == null) {
														Operator operator = Operator.EQUALS;
														booleanType = MutatorenvironmentFactory.eINSTANCE.createSpecificBooleanType();
														booleanType.setOperator(operator);
														attributeType = booleanType;
													}
													else {
														booleanType = (SpecificBooleanType) attributeType;
													}
													booleanType.setValue((boolean) ob);
												}
												if (attribute.getEType().getName().equals("EDouble")) {
													SpecificDoubleType doubleType = null;
													if (attributeType == null) {
														Operator operator = Operator.EQUALS;
														doubleType = MutatorenvironmentFactory.eINSTANCE.createSpecificDoubleType();
														doubleType.setOperator(operator);
														attributeType = doubleType;
													}
													doubleType.setValue((double) ob);
												}
												if (attributeType != null) {
													attributeEvaluation.setName(attribute);
													attributeEvaluation.setValue(attributeType);
												}
											}
											if (attributeType != null) {
												listAttributeEvaluation.add(attributeEvaluation);
											}
										}
									}
								}
								mAtt = 0;
								if (listAttributeEvaluation != null && listAttributeEvaluation.size() > 0) {
									for (AttributeEvaluation attributeEvaluation : listAttributeEvaluation) {
										if (attributeEvaluation != null && attributeEvaluation.getValue() != null) {
											if (mAtt == 0) {
												expression.setFirst(attributeEvaluation);
											}
											if (mAtt > 0) {
												expression.getSecond().add(attributeEvaluation);
												BinaryOperator operator = MutatorenvironmentFactory.eINSTANCE.createBinaryOperator();
												operator.setType(LogicOperator.OR);
												expression.getOperator().add(operator);
											}
											mAtt++;
										}
									}
								}
								k = 0;
								int mRef = 0;
								List<ReferenceEvaluation> listReferenceEvaluation = new ArrayList<ReferenceEvaluation>();
								for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
									if (classWhereElements.contains(feature.getName())) {
										k++;
										if (feature instanceof EReference) {
											ReferenceEvaluation referenceEvaluation = MutatorenvironmentFactory.eINSTANCE.createReferenceEvaluation();
											EReference reference = (EReference) feature;
											ObSelectionStrategy referenceStrategy = MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
											Operator operator = Operator.EQUALS;
											referenceStrategy.setType((EClass) reference.getEType());
											referenceEvaluation.setName(reference);
											referenceEvaluation.setOperator(operator);
											referenceEvaluation.setValue(referenceStrategy);
											if (referenceEvaluation != null) {
												listReferenceEvaluation.add(referenceEvaluation);
											}
										}
									}
								}
								mRef = 0;
								if (listReferenceEvaluation != null && listReferenceEvaluation.size() > 0) {
									for (ReferenceEvaluation referenceEvaluation : listReferenceEvaluation) {
										if (referenceEvaluation != null && referenceEvaluation.getValue() != null) {
											if (mAtt == 0 && mRef == 0) {
												expression.setFirst(referenceEvaluation);
											}
											if (mAtt > 0 || mRef > 0) {
												expression.getSecond().add(referenceEvaluation);
												BinaryOperator operator = MutatorenvironmentFactory.eINSTANCE.createBinaryOperator();
												operator.setType(LogicOperator.OR);
												expression.getOperator().add(operator);
											}
											mRef++;
										}
									}
								}
								if (mAtt > 0 || mRef > 0) {
									obSelectionStrategy.setExpression(expression);
								}
								removeObjectMutator.setObject(obSelectionStrategy);
								mutator.add(removeObjectMutator);
							}
							if (wodelOperator.equals("modify")) {
								System.out.println(eClass.getName() + " ----- Modification mutation operator");
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
								int mAtt = 0;
								List<AttributeEvaluation> listAttributeEvaluation = new ArrayList<AttributeEvaluation>();
								for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
									if (classWhereElements.contains(feature.getName())) {
										List<Object> lob = featureWhereValues.get(k);
										k++;
										if (feature instanceof EAttribute) {
											AttributeEvaluation attributeEvaluation = MutatorenvironmentFactory.eINSTANCE.createAttributeEvaluation();
											EAttribute attribute = (EAttribute) feature;
											AttributeEvaluationType attributeType = null;
											for (Object ob : lob) {
												if (attribute.getEType().getName().equals("EString")) {
													ListStringType stringType = null;
													if (attributeType == null) {
														Operator operator = Operator.IN;
														stringType = MutatorenvironmentFactory.eINSTANCE.createListStringType();
														stringType.setOperator(operator);
														attributeType = stringType;
													}
													else {
														stringType = (ListStringType) attributeType;
													}
													stringType.getValue().add(((String) ob).replace("\\n", ""));
												}
												if (attribute.getEType().getName().equals("EInt")) {
													SpecificIntegerType integerType = null;
													if (attributeType == null) {
														Operator operator = Operator.EQUALS;
														integerType = MutatorenvironmentFactory.eINSTANCE.createSpecificIntegerType();
														integerType.setOperator(operator);
														attributeType = integerType;
													}
													else {
														integerType = (SpecificIntegerType) attributeType;
													}
													integerType.setValue((int) ob);
												}
												if (attribute.getEType().getName().equals("EBoolean")) {
													SpecificBooleanType booleanType = null;
													if (attributeType == null) {
														Operator operator = Operator.EQUALS;
														booleanType = MutatorenvironmentFactory.eINSTANCE.createSpecificBooleanType();
														booleanType.setOperator(operator);
														attributeType = booleanType;
													}
													else {
														booleanType = (SpecificBooleanType) attributeType;
													}
													booleanType.setValue((boolean) ob);
												}
												if (attribute.getEType().getName().equals("EDouble")) {
													SpecificDoubleType doubleType = null;
													if (attributeType == null) {
														Operator operator = Operator.EQUALS;
														doubleType = MutatorenvironmentFactory.eINSTANCE.createSpecificDoubleType();
														doubleType.setOperator(operator);
														attributeType = doubleType;
													}
													doubleType.setValue((double) ob);
												}
												if (attributeType != null) {
													attributeEvaluation.setName(attribute);
													attributeEvaluation.setValue(attributeType);
												}
											}
											if (attributeType != null) {
												listAttributeEvaluation.add(attributeEvaluation);
											}
										}
									}
								}
								mAtt = 0;
								if (listAttributeEvaluation != null && listAttributeEvaluation.size() > 0) {
									for (AttributeEvaluation attributeEvaluation : listAttributeEvaluation) {
										if (attributeEvaluation != null && attributeEvaluation.getValue() != null) {
											if (mAtt == 0) {
												expression.setFirst(attributeEvaluation);
											}
											if (mAtt > 0) {
												expression.getSecond().add(attributeEvaluation);
												BinaryOperator operator = MutatorenvironmentFactory.eINSTANCE.createBinaryOperator();
												operator.setType(LogicOperator.OR);
												expression.getOperator().add(operator);
											}
											mAtt++;
										}
									}
								}
								k = 0;
								int mRef = 0;
								List<ReferenceEvaluation> listReferenceEvaluation = new ArrayList<ReferenceEvaluation>();
								for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
									if (classWhereElements.contains(feature.getName())) {
										k++;
										if (feature instanceof EReference) {
											ReferenceEvaluation referenceEvaluation = MutatorenvironmentFactory.eINSTANCE.createReferenceEvaluation();
											EReference reference = (EReference) feature;
											ObSelectionStrategy referenceStrategy = MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
											Operator operator = Operator.EQUALS;
											referenceStrategy.setType((EClass) reference.getEType());
											referenceEvaluation.setName(reference);
											referenceEvaluation.setOperator(operator);
											referenceEvaluation.setValue(referenceStrategy);
											if (referenceEvaluation != null) {
												listReferenceEvaluation.add(referenceEvaluation);
											}
										}
									}
								}
								mRef = 0;
								if (listReferenceEvaluation != null && listReferenceEvaluation.size() > 0) {
									for (ReferenceEvaluation referenceEvaluation : listReferenceEvaluation) {
										if (referenceEvaluation != null && referenceEvaluation.getValue() != null) {
											if (mAtt == 0 && mRef == 0) {
												expression.setFirst(referenceEvaluation);
											}
											if (mAtt > 0 || mRef > 0) {
												expression.getSecond().add(referenceEvaluation);
												BinaryOperator operator = MutatorenvironmentFactory.eINSTANCE.createBinaryOperator();
												operator.setType(LogicOperator.OR);
												expression.getOperator().add(operator);
											}
											mRef++;
										}
									}
								}
								modifyInformationMutator.setName("p");
								if (mAtt > 0 || mRef > 0) {
									obSelectionStrategy.setExpression(expression);
								}
								k = 0;
								for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
									if (classWithElements.contains(feature.getName())) {
										List<Object> lob = featureWithValues.get(k);
										k++;
										if (feature instanceof EAttribute) {
											EAttribute attribute = (EAttribute) feature;
											AttributeType attributeType = null;
											AttributeScalar attributeScalar = MutatorenvironmentFactory.eINSTANCE.createAttributeScalar();
											attributeScalar.getAttribute().add(attribute);
											for (Object ob : lob) {
												if (attribute.getEType().getName().equals("EString")) {
													ListStringType stringType = null;
													if (attributeType == null) {
														Operator operator = Operator.IN;
														stringType = MutatorenvironmentFactory.eINSTANCE.createListStringType();
														stringType.setOperator(operator);
														attributeType = stringType;
													}
													else {
														stringType = (ListStringType) attributeType;
													}
													stringType.getValue().add(((String) ob).replace("\\n", ""));
												}
												if (attribute.getEType().getName().equals("EInt")) {
													SpecificIntegerType integerType = null;
													if (attributeType == null) {
														Operator operator = Operator.EQUALS;
														integerType = MutatorenvironmentFactory.eINSTANCE.createSpecificIntegerType();
														integerType.setOperator(operator);
														attributeType = integerType;
													}
													else {
														integerType = (SpecificIntegerType) attributeType;
													}
													integerType.setValue((int) ob);
												}
												if (attribute.getEType().getName().equals("EBoolean")) {
													SpecificBooleanType booleanType = null;
													if (attributeType == null) {
														Operator operator = Operator.EQUALS;
														booleanType = MutatorenvironmentFactory.eINSTANCE.createSpecificBooleanType();
														booleanType.setOperator(operator);
														attributeType = booleanType;
													}
													else {
														booleanType = (SpecificBooleanType) attributeType;
													}
													booleanType.setValue((boolean) ob);
												}
												if (attribute.getEType().getName().equals("EDouble")) {
													SpecificDoubleType doubleType = null;
													if (attributeType == null) {
														Operator operator = Operator.EQUALS;
														doubleType = MutatorenvironmentFactory.eINSTANCE.createSpecificDoubleType();
														doubleType.setOperator(operator);
														attributeType = doubleType;
													}
													doubleType.setValue((double) ob);
												}
											}
											if (attributeType == null) {
												if (feature instanceof EAttribute) {
													Operator operator = Operator.EQUALS;
													if (attribute.getEType().getName().equals("EString")) {
														RandomStringType stringType = MutatorenvironmentFactory.eINSTANCE.createRandomStringType();
														stringType.setOperator(operator);
														stringType.setMin(2);
														stringType.setMax(4);
														attributeType = stringType;
													}
													if (attribute.getEType().getName().equals("EInt")) {
														RandomIntegerType integerType = MutatorenvironmentFactory.eINSTANCE.createRandomIntegerType();
														integerType.setOperator(operator);
														integerType.setMin(2);
														integerType.setMax(10);
														attributeType = integerType;
													}
													if (attribute.getEType().getName().equals("EBoolean")) {
														RandomBooleanType booleanType = MutatorenvironmentFactory.eINSTANCE.createRandomBooleanType();
														booleanType.setOperator(operator);
														attributeType = booleanType;
													}
													if (attribute.getEType().getName().equals("EDouble")) {
														RandomDoubleType doubleType = MutatorenvironmentFactory.eINSTANCE.createRandomDoubleType();
														doubleType.setOperator(operator);
														doubleType.setMin(2);
														doubleType.setMax(10);
														attributeType = doubleType;
													}
												}
											}
											if (attributeType != null) {
												attributeScalar.setValue(attributeType);
											}
											if (attributeScalar != null && attributeScalar.getValue() != null) {
												modifyInformationMutator.getAttributes().add(attributeScalar);
											}
										}
									}
								}
								k = 0;
								for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
									if (classWithElements.contains(feature.getName())) {
										k++;
										if (feature instanceof EReference) {
											ReferenceInit referenceInit = null;
											EReference reference = (EReference) feature;
											referenceInit = MutatorenvironmentFactory.eINSTANCE.createReferenceInit();
											ObSelectionStrategy referenceStrategy = MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
											referenceStrategy.setType((EClass) reference.getEType());
											referenceInit.setObject(referenceStrategy);
											referenceInit.getReference().add(reference);
											if (referenceInit != null) {
												modifyInformationMutator.getReferences().add(referenceInit);
											}
										}
									}
								}
								modifyInformationMutator.setObject(obSelectionStrategy);
								mutator.add(modifyInformationMutator);
							}
							if (wodelOperator.equals("clone")) {
								System.out.println(eClass.getName() + " ----- Clonation mutation operator");
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
								int mAtt = 0;
								List<AttributeEvaluation> listAttributeEvaluation = new ArrayList<AttributeEvaluation>();
								for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
									if (classWhereElements.contains(feature.getName())) {
										List<Object> lob = featureWhereValues.get(k);
										k++;
										if (feature instanceof EAttribute) {
											AttributeEvaluation attributeEvaluation = MutatorenvironmentFactory.eINSTANCE.createAttributeEvaluation();
											EAttribute attribute = (EAttribute) feature;
											AttributeEvaluationType attributeType = null;
											for (Object ob : lob) {
												if (attribute.getEType().getName().equals("EString")) {
													ListStringType stringType = null;
													if (attributeType == null) {
														Operator operator = Operator.IN;
														stringType = MutatorenvironmentFactory.eINSTANCE.createListStringType();
														stringType.setOperator(operator);
														attributeType = stringType;
													}
													else {
														stringType = (ListStringType) attributeType;
													}
													stringType.getValue().add(((String) ob).replace("\\n", ""));
												}
												if (attribute.getEType().getName().equals("EInt")) {
													SpecificIntegerType integerType = null;
													if (attributeType == null) {
														Operator operator = Operator.EQUALS;
														integerType = MutatorenvironmentFactory.eINSTANCE.createSpecificIntegerType();
														integerType.setOperator(operator);
														attributeType = integerType;
													}
													else {
														integerType = (SpecificIntegerType) attributeType;
													}
													integerType.setValue((int) ob);
												}
												if (attribute.getEType().getName().equals("EBoolean")) {
													SpecificBooleanType booleanType = null;
													if (attributeType == null) {
														Operator operator = Operator.EQUALS;
														booleanType = MutatorenvironmentFactory.eINSTANCE.createSpecificBooleanType();
														booleanType.setOperator(operator);
														attributeType = booleanType;
													}
													else {
														booleanType = (SpecificBooleanType) attributeType;
													}
													booleanType.setValue((boolean) ob);
												}
												if (attribute.getEType().getName().equals("EDouble")) {
													SpecificDoubleType doubleType = null;
													if (attributeType == null) {
														Operator operator = Operator.EQUALS;
														doubleType = MutatorenvironmentFactory.eINSTANCE.createSpecificDoubleType();
														doubleType.setOperator(operator);
														attributeType = doubleType;
													}
													doubleType.setValue((double) ob);
												}
												if (attributeType != null) {
													attributeEvaluation.setName(attribute);
													attributeEvaluation.setValue(attributeType);
												}
											}
											if (attributeType != null) {
												listAttributeEvaluation.add(attributeEvaluation);
											}
										}
									}
								}
								mAtt = 0;
								if (listAttributeEvaluation != null && listAttributeEvaluation.size() > 0) {
									for (AttributeEvaluation attributeEvaluation : listAttributeEvaluation) {
										if (attributeEvaluation != null && attributeEvaluation.getValue() != null) {
											if (mAtt == 0) {
												expression.setFirst(attributeEvaluation);
											}
											if (mAtt > 0) {
												expression.getSecond().add(attributeEvaluation);
												BinaryOperator operator = MutatorenvironmentFactory.eINSTANCE.createBinaryOperator();
												operator.setType(LogicOperator.OR);
												expression.getOperator().add(operator);
											}
											mAtt++;
										}
									}
								}
								k = 0;
								int mRef = 0;
								List<ReferenceEvaluation> listReferenceEvaluation = new ArrayList<ReferenceEvaluation>();
								for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
									if (classWhereElements.contains(feature.getName())) {
										k++;
										if (feature instanceof EReference) {
											ReferenceEvaluation referenceEvaluation = MutatorenvironmentFactory.eINSTANCE.createReferenceEvaluation();
											EReference reference = (EReference) feature;
											ObSelectionStrategy referenceStrategy = MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
											Operator operator = Operator.EQUALS;
											referenceStrategy.setType((EClass) reference.getEType());
											referenceEvaluation.setName(reference);
											referenceEvaluation.setOperator(operator);
											referenceEvaluation.setValue(referenceStrategy);
											if (referenceEvaluation != null) {
												listReferenceEvaluation.add(referenceEvaluation);
											}
										}
									}
								}
								mRef = 0;
								if (listReferenceEvaluation != null && listReferenceEvaluation.size() > 0) {
									for (ReferenceEvaluation referenceEvaluation : listReferenceEvaluation) {
										if (referenceEvaluation != null && referenceEvaluation.getValue() != null) {
											if (mAtt == 0 && mRef == 0) {
												expression.setFirst(referenceEvaluation);
											}
											if (mAtt > 0 || mRef > 0) {
												expression.getSecond().add(referenceEvaluation);
												BinaryOperator operator = MutatorenvironmentFactory.eINSTANCE.createBinaryOperator();
												operator.setType(LogicOperator.OR);
												expression.getOperator().add(operator);
											}
											mRef++;
										}
									}
								}
								cloneObjectMutator.setName("p");
								if (mAtt > 0 || mRef > 0) {
									obSelectionStrategy.setExpression(expression);
								}
								k = 0;
								for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
									if (classWithElements.contains(feature.getName())) {
										List<Object> lob = featureWithValues.get(k);
										k++;
										if (feature instanceof EAttribute) {
											EAttribute attribute = (EAttribute) feature;
											AttributeType attributeType = null;
											AttributeScalar attributeScalar = MutatorenvironmentFactory.eINSTANCE.createAttributeScalar();
											attributeScalar.getAttribute().add(attribute);
											for (Object ob : lob) {
												if (attribute.getEType().getName().equals("EString")) {
													ListStringType stringType = null;
													if (attributeType == null) {
														Operator operator = Operator.IN;
														stringType = MutatorenvironmentFactory.eINSTANCE.createListStringType();
														stringType.setOperator(operator);
														attributeType = stringType;
													}
													else {
														stringType = (ListStringType) attributeType;
													}
													stringType.getValue().add(((String) ob).replace("\\n", ""));
												}
												if (attribute.getEType().getName().equals("EInt")) {
													SpecificIntegerType integerType = null;
													if (attributeType == null) {
														Operator operator = Operator.EQUALS;
														integerType = MutatorenvironmentFactory.eINSTANCE.createSpecificIntegerType();
														integerType.setOperator(operator);
														attributeType = integerType;
													}
													else {
														integerType = (SpecificIntegerType) attributeType;
													}
													integerType.setValue((int) ob);
												}
												if (attribute.getEType().getName().equals("EBoolean")) {
													SpecificBooleanType booleanType = null;
													if (attributeType == null) {
														Operator operator = Operator.EQUALS;
														booleanType = MutatorenvironmentFactory.eINSTANCE.createSpecificBooleanType();
														booleanType.setOperator(operator);
														attributeType = booleanType;
													}
													else {
														booleanType = (SpecificBooleanType) attributeType;
													}
													booleanType.setValue((boolean) ob);
												}
												if (attribute.getEType().getName().equals("EDouble")) {
													SpecificDoubleType doubleType = null;
													if (attributeType == null) {
														Operator operator = Operator.EQUALS;
														doubleType = MutatorenvironmentFactory.eINSTANCE.createSpecificDoubleType();
														doubleType.setOperator(operator);
														attributeType = doubleType;
													}
													doubleType.setValue((double) ob);
												}
											}
											if (attributeType == null) {
												if (feature instanceof EAttribute) {
													Operator operator = Operator.EQUALS;
													if (attribute.getEType().getName().equals("EString")) {
														RandomStringType stringType = MutatorenvironmentFactory.eINSTANCE.createRandomStringType();
														stringType.setOperator(operator);
														stringType.setMin(2);
														stringType.setMax(4);
														attributeType = stringType;
													}
													if (attribute.getEType().getName().equals("EInt")) {
														RandomIntegerType integerType = MutatorenvironmentFactory.eINSTANCE.createRandomIntegerType();
														integerType.setOperator(operator);
														integerType.setMin(2);
														integerType.setMax(10);
														attributeType = integerType;
													}
													if (attribute.getEType().getName().equals("EBoolean")) {
														RandomBooleanType booleanType = MutatorenvironmentFactory.eINSTANCE.createRandomBooleanType();
														booleanType.setOperator(operator);
														attributeType = booleanType;
													}
													if (attribute.getEType().getName().equals("EDouble")) {
														RandomDoubleType doubleType = MutatorenvironmentFactory.eINSTANCE.createRandomDoubleType();
														doubleType.setOperator(operator);
														doubleType.setMin(2);
														doubleType.setMax(10);
														attributeType = doubleType;
													}
												}
											}
											if (attributeType != null) {
												attributeScalar.setValue(attributeType);
											}
											if (attributeScalar != null && attributeScalar.getValue() != null) {
												cloneObjectMutator.getAttributes().add(attributeScalar);
											}
										}
									}
								}
								k = 0;
								for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
									if (classWithElements.contains(feature.getName())) {
										k++;
										if (feature instanceof EReference) {
											ReferenceInit referenceInit = null;
											EReference reference = (EReference) feature;
											referenceInit = MutatorenvironmentFactory.eINSTANCE.createReferenceInit();
											ObSelectionStrategy referenceStrategy = MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
											referenceStrategy.setType((EClass) reference.getEType());
											referenceInit.setObject(referenceStrategy);
											referenceInit.getReference().add(reference);
											if (referenceInit != null) {
												cloneObjectMutator.getReferences().add(referenceInit);
											}
										}
									}
								}
								cloneObjectMutator.setObject(obSelectionStrategy);
								mutator.add(cloneObjectMutator);
							}
							if (wodelOperator.equals("retype")) {
								System.out.println(eClass.getName() + " ----- Retyping mutation operator");
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
										EClass classToAdd = (EClass) classifier;
										if (classToAdd.isAbstract() == false) {
											classesToAdd.add(classToAdd);
										}
									}
								}
								if (classesToAdd.size() > 0) {
									Map<EClass, List<EStructuralFeature>> classesToAddFeatures = new HashMap<EClass, List<EStructuralFeature>>();
									for (EClass classToAdd : classesToAdd) {
										List<EStructuralFeature> classToAddFeatures = new ArrayList<EStructuralFeature>();
										classToAddFeatures.addAll(classToAdd.getEAllStructuralFeatures());
										classesToAddFeatures.put(classToAdd, classToAddFeatures);
									}
									List<EStructuralFeature> featuresToAdd = new ArrayList<EStructuralFeature>();
									featuresToAdd.addAll(eClass.getEAllStructuralFeatures());
									for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
										boolean shared = true;
										for (EClass classToAdd : classesToAddFeatures.keySet()) {
											if (!classesToAddFeatures.get(classToAdd).contains(feature)) {
												shared = false;
												break;
											}
										}
										if (shared == false) {
											featuresToAdd.remove(feature);
										}
									}
									retypeObjectMutator.getTypes().addAll(classesToAdd);
									Expression expression = MutatorenvironmentFactory.eINSTANCE.createExpression();
									int k = 0;
									int mAtt = 0;
									List<AttributeEvaluation> listAttributeEvaluation = new ArrayList<AttributeEvaluation>();
									for (EStructuralFeature feature : featuresToAdd) {
										if (classWhereElements.contains(feature.getName())) {
											List<Object> lob = featureWhereValues.get(k);
											k++;
											if (feature instanceof EAttribute) {
												AttributeEvaluation attributeEvaluation = MutatorenvironmentFactory.eINSTANCE.createAttributeEvaluation();
												EAttribute attribute = (EAttribute) feature;
												AttributeEvaluationType attributeType = null;
												for (Object ob : lob) {
													if (attribute.getEType().getName().equals("EString")) {
														ListStringType stringType = null;
														if (attributeType == null) {
															Operator operator = Operator.IN;
															stringType = MutatorenvironmentFactory.eINSTANCE.createListStringType();
															stringType.setOperator(operator);
															attributeType = stringType;
														}
														else {
															stringType = (ListStringType) attributeType;
														}
														stringType.getValue().add(((String) ob).replace("\\n", ""));
													}
													if (attribute.getEType().getName().equals("EInt")) {
														SpecificIntegerType integerType = null;
														if (attributeType == null) {
															Operator operator = Operator.EQUALS;
															integerType = MutatorenvironmentFactory.eINSTANCE.createSpecificIntegerType();
															integerType.setOperator(operator);
															attributeType = integerType;
														}
														else {
															integerType = (SpecificIntegerType) attributeType;
														}
														integerType.setValue((int) ob);
													}
													if (attribute.getEType().getName().equals("EBoolean")) {
														SpecificBooleanType booleanType = null;
														if (attributeType == null) {
															Operator operator = Operator.EQUALS;
															booleanType = MutatorenvironmentFactory.eINSTANCE.createSpecificBooleanType();
															booleanType.setOperator(operator);
															attributeType = booleanType;
														}
														else {
															booleanType = (SpecificBooleanType) attributeType;
														}
														booleanType.setValue((boolean) ob);
													}
													if (attribute.getEType().getName().equals("EDouble")) {
														SpecificDoubleType doubleType = null;
														if (attributeType == null) {
															Operator operator = Operator.EQUALS;
															doubleType = MutatorenvironmentFactory.eINSTANCE.createSpecificDoubleType();
															doubleType.setOperator(operator);
															attributeType = doubleType;
														}
														doubleType.setValue((double) ob);
													}
													if (attributeType != null) {
														attributeEvaluation.setName(attribute);
														attributeEvaluation.setValue(attributeType);
													}
												}
												if (attributeType != null) {
													listAttributeEvaluation.add(attributeEvaluation);
												}
											}
										}
									}
									mAtt = 0;
									if (listAttributeEvaluation != null && listAttributeEvaluation.size() > 0) {
										for (AttributeEvaluation attributeEvaluation : listAttributeEvaluation) {
											if (attributeEvaluation != null && attributeEvaluation.getValue() != null) {
												if (mAtt == 0) {
													expression.setFirst(attributeEvaluation);
												}
												if (mAtt > 0) {
													expression.getSecond().add(attributeEvaluation);
													BinaryOperator operator = MutatorenvironmentFactory.eINSTANCE.createBinaryOperator();
													operator.setType(LogicOperator.OR);
													expression.getOperator().add(operator);
												}
												mAtt++;
											}
										}
									}
									k = 0;
									int mRef = 0;
									List<ReferenceEvaluation> listReferenceEvaluation = new ArrayList<ReferenceEvaluation>();
									for (EStructuralFeature feature : featuresToAdd) {
										if (classWhereElements.contains(feature.getName())) {
											k++;
											if (feature instanceof EReference) {
												ReferenceEvaluation referenceEvaluation = MutatorenvironmentFactory.eINSTANCE.createReferenceEvaluation();
												EReference reference = (EReference) feature;
												ObSelectionStrategy referenceStrategy = MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
												Operator operator = Operator.EQUALS;
												referenceStrategy.setType((EClass) reference.getEType());
												referenceEvaluation.setName(reference);
												referenceEvaluation.setOperator(operator);
												referenceEvaluation.setValue(referenceStrategy);
												if (referenceEvaluation != null) {
													listReferenceEvaluation.add(referenceEvaluation);
												}
											}
										}
									}
									mRef = 0;
									if (listReferenceEvaluation != null && listReferenceEvaluation.size() > 0) {
										for (ReferenceEvaluation referenceEvaluation : listReferenceEvaluation) {
											if (referenceEvaluation != null && referenceEvaluation.getValue() != null) {
												if (mAtt == 0 && mRef == 0) {
													expression.setFirst(referenceEvaluation);
												}
												if (mAtt > 0 || mRef > 0) {
													expression.getSecond().add(referenceEvaluation);
													BinaryOperator operator = MutatorenvironmentFactory.eINSTANCE.createBinaryOperator();
													operator.setType(LogicOperator.OR);
													expression.getOperator().add(operator);
												}
												mRef++;
											}
										}
									}
									retypeObjectMutator.setName("p");
									if (mAtt > 0 || mRef > 0) {
										obSelectionStrategy.setExpression(expression);
									}
									k = 0;
									for (EStructuralFeature feature : featuresToAdd) {
										if (classWithElements.contains(feature.getName())) {
											List<Object> lob = featureWithValues.get(k);
											k++;
											if (feature instanceof EAttribute) {
												EAttribute attribute = (EAttribute) feature;
												AttributeType attributeType = null;
												AttributeScalar attributeScalar = MutatorenvironmentFactory.eINSTANCE.createAttributeScalar();
												attributeScalar.getAttribute().add(attribute);
												for (Object ob : lob) {
													if (attribute.getEType().getName().equals("EString")) {
														ListStringType stringType = null;
														if (attributeType == null) {
															Operator operator = Operator.IN;
															stringType = MutatorenvironmentFactory.eINSTANCE.createListStringType();
															stringType.setOperator(operator);
															attributeType = stringType;
														}
														else {
															stringType = (ListStringType) attributeType;
														}
														stringType.getValue().add(((String) ob).replace("\\n", ""));
													}
													if (attribute.getEType().getName().equals("EInt")) {
														SpecificIntegerType integerType = null;
														if (attributeType == null) {
															Operator operator = Operator.EQUALS;
															integerType = MutatorenvironmentFactory.eINSTANCE.createSpecificIntegerType();
															integerType.setOperator(operator);
															attributeType = integerType;
														}
														else {
															integerType = (SpecificIntegerType) attributeType;
														}
														integerType.setValue((int) ob);
													}
													if (attribute.getEType().getName().equals("EBoolean")) {
														SpecificBooleanType booleanType = null;
														if (attributeType == null) {
															Operator operator = Operator.EQUALS;
															booleanType = MutatorenvironmentFactory.eINSTANCE.createSpecificBooleanType();
															booleanType.setOperator(operator);
															attributeType = booleanType;
														}
														else {
															booleanType = (SpecificBooleanType) attributeType;
														}
														booleanType.setValue((boolean) ob);
													}
													if (attribute.getEType().getName().equals("EDouble")) {
														SpecificDoubleType doubleType = null;
														if (attributeType == null) {
															Operator operator = Operator.EQUALS;
															doubleType = MutatorenvironmentFactory.eINSTANCE.createSpecificDoubleType();
															doubleType.setOperator(operator);
															attributeType = doubleType;
														}
														doubleType.setValue((double) ob);
													}
												}
												if (attributeType == null) {
													if (feature instanceof EAttribute) {
														Operator operator = Operator.EQUALS;
														if (attribute.getEType().getName().equals("EString")) {
															RandomStringType stringType = MutatorenvironmentFactory.eINSTANCE.createRandomStringType();
															stringType.setOperator(operator);
															stringType.setMin(2);
															stringType.setMax(4);
															attributeType = stringType;
														}
														if (attribute.getEType().getName().equals("EInt")) {
															RandomIntegerType integerType = MutatorenvironmentFactory.eINSTANCE.createRandomIntegerType();
															integerType.setOperator(operator);
															integerType.setMin(2);
															integerType.setMax(10);
															attributeType = integerType;
														}
														if (attribute.getEType().getName().equals("EBoolean")) {
															RandomBooleanType booleanType = MutatorenvironmentFactory.eINSTANCE.createRandomBooleanType();
															booleanType.setOperator(operator);
															attributeType = booleanType;
														}
														if (attribute.getEType().getName().equals("EDouble")) {
															RandomDoubleType doubleType = MutatorenvironmentFactory.eINSTANCE.createRandomDoubleType();
															doubleType.setOperator(operator);
															doubleType.setMin(2);
															doubleType.setMax(10);
															attributeType = doubleType;
														}
													}
												}
												if (attributeType != null) {
													attributeScalar.setValue(attributeType);
												}
												if (attributeScalar != null && attributeScalar.getValue() != null) {
													retypeObjectMutator.getAttributes().add(attributeScalar);
												}
											}
										}
									}
									k = 0;
									for (EStructuralFeature feature : featuresToAdd) {
										if (classWithElements.contains(feature.getName())) {
											k++;
											if (feature instanceof EReference) {
												ReferenceInit referenceInit = null;
												EReference reference = (EReference) feature;
												referenceInit = MutatorenvironmentFactory.eINSTANCE.createReferenceInit();
												ObSelectionStrategy referenceStrategy = MutatorenvironmentFactory.eINSTANCE.createRandomTypeSelection();
												referenceStrategy.setType((EClass) reference.getEType());
												referenceInit.setObject(referenceStrategy);
												referenceInit.getReference().add(reference);
												if (referenceInit != null) {
													retypeObjectMutator.getReferences().add(referenceInit);
												}
											}
										}
									}
									retypeObjectMutator.setObject(obSelectionStrategy);
									mutator.add(retypeObjectMutator);
								}
							}
							if (block != null) {
								if (mutator.size() > 0) {
									for (Mutator mut : mutator) {
										if (mut != null) {
											commands.add(mut);
										}
									}
								}
								if (commands.size() > 0) {
									for (Mutator com : commands) {
										if (com != null) {
											block.getCommands().add(com);
										}
									}
									if (block.getCommands().size() > 0) {
										blocks.add(block);
										i++;
									}
								}
							}
						}
					}
				}

				mutatorEnvironment.getBlocks().addAll(blocks);
				mutatorEnvironment.getCommands().clear();
				
				IOUtils.copyFile(WORKSPACE + "/" + PROJECT + "/src/" + file.getName(), WORKSPACE + "/" + PROJECT + "/src/" + file.getName().replace(".mutator", ".mutator.bak"));
				
				String mutatorCode = WodelUtils.deserialize(WORKSPACE + "/" + PROJECT + "/src/" + file.getName(), mutatorEnvironment);

				FileWriter fileWriter = new FileWriter(WORKSPACE + "/" + PROJECT + "/src/" + file.getName());
				BufferedWriter writer = new BufferedWriter(fileWriter);
				writer.write(mutatorCode);
				writer.close();
				fileWriter.close();
				
				WodelUtils.serialize("file:/" + WORKSPACE + "/" + PROJECT + "/src/" + file.getName(), "file:/" + OUTPUT + "/" + file.getName().replace(".mutator", ".model"));
				
				System.out.println("Mutation operators created successfully!!");

				//Refresh project
				ResourcesPlugin.getWorkspace().getRoot().getProject(PROJECT).refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
				
				IEditorPart editor = null;
				File mutatorFile = new File(WORKSPACE + "/" + PROJECT + "/src/" + file.getName());
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
