package efinder.emfocl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.BagType;
import org.eclipse.ocl.pivot.BooleanLiteralExp;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.CollectionItem;
import org.eclipse.ocl.pivot.CollectionLiteralExp;
import org.eclipse.ocl.pivot.CollectionLiteralPart;
import org.eclipse.ocl.pivot.CollectionRange;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Constraint;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.EnumLiteralExp;
import org.eclipse.ocl.pivot.Enumeration;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.IfExp;
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.IntegerLiteralExp;
import org.eclipse.ocl.pivot.InvalidLiteralExp;
import org.eclipse.ocl.pivot.InvalidType;
import org.eclipse.ocl.pivot.IterateExp;
import org.eclipse.ocl.pivot.IteratorExp;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.LetExp;
import org.eclipse.ocl.pivot.Library;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.NullLiteralExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.OppositePropertyCallExp;
import org.eclipse.ocl.pivot.OrderedSetType;
import org.eclipse.ocl.pivot.Package;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.PrimitiveType;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.ocl.pivot.RealLiteralExp;
import org.eclipse.ocl.pivot.SequenceType;
import org.eclipse.ocl.pivot.SetType;
import org.eclipse.ocl.pivot.ShadowExp;
import org.eclipse.ocl.pivot.StringLiteralExp;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.TupleLiteralExp;
import org.eclipse.ocl.pivot.TupleLiteralPart;
import org.eclipse.ocl.pivot.TupleType;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypeExp;
import org.eclipse.ocl.pivot.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.VoidType;
import org.eclipse.ocl.pivot.internal.ecore.EObjectOperation;
import org.eclipse.ocl.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.pivot.utilities.ParserException;
import org.eclipse.ocl.pivot.values.IntegerValue;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;

import efinder.core.DialectToIRCompiler;
import efinder.core.EFinderModel;
import efinder.core.errors.InvalidModelException;
import efinder.core.errors.Report;
import efinder.core.errors.UnsupportedTranslationException;
import efinder.core.ir.IRBuilder;
import efinder.core.utils.IRUtils;
import efinder.core.utils.IRUtils.TupleTypeHandler;
import efinder.ir.AbstractFunction;
import efinder.ir.DefinedOperationRef;
import efinder.ir.DerivedPropertyRef;
import efinder.ir.EFClass;
import efinder.ir.EFEnum;
import efinder.ir.EFEnumLiteral;
import efinder.ir.EFPackage;
import efinder.ir.EFPrimitiveType;
import efinder.ir.EFTupleType;
import efinder.ir.EfinderFactory;
import efinder.ir.MetaTypeRef;
import efinder.ir.Specification;
import efinder.ir.TupleFieldRef;
import efinder.ir.TypeRef;
import efinder.ir.VariableDeclaration;
import efinder.ir.ocl.CollectionCallExp;
import efinder.ir.ocl.Iterator;
import efinder.ir.ocl.OclDerivedProperty;
import efinder.ir.ocl.OclExpression;
import efinder.ir.ocl.OclFactory;
import efinder.ir.ocl.OclInvariant;
import efinder.ir.ocl.OclOperation;
import efinder.ir.ocl.OclPackage;
import efinder.ir.ocl.OperatorKind;
import efinder.ir.ocl.TuplePart;

/**
 * Transforms a pivot AST into the IR representation.
 * 
 * @author jesus
 *
 */
public class PivotOclCompiler implements DialectToIRCompiler {

	@NonNull
	private final Model ocl;
	@NonNull
	private final Report report = new Report();
	@Nullable
	private Registry registry = Registry.INSTANCE;
	@NonNull
	private Set<EPackage> packages = Collections.emptySet();
	
	public PivotOclCompiler(Model ocl) {
		this.ocl = ocl;
	}
	
	/**
	 * @param ocl
	 * @param rs ResourceSet used to load the model. 
	 *           If it contains registered packages, they are looked up
	 */
	public PivotOclCompiler(@NonNull Model ocl, @NonNull ResourceSet rs) {
		this(ocl);
		this.registry = rs.getPackageRegistry();
	}

	public PivotOclCompiler withPackages(List<? extends Resource> resources) {
		this.packages = new HashSet<EPackage>();
		for (Resource r : resources) {
			r.getAllContents().forEachRemaining(o -> {
				if (o instanceof EPackage) {
					packages.add((EPackage) o);
				}
			});
		}
		return this;
	}
	
	@NonNull 
	public EFinderModel compile() {
		MetamodelContext metamodelContext = precomputeMetamodel();
		CompilerContext ctx = new CompilerContext(metamodelContext, report);
		ModelVisitor visitor = new ModelVisitor(ctx);
		ocl.accept(visitor);
		
		for (EFPackage pkg : metamodelContext.packages.values()) {
			if (pkg.eContainer() == null) {
				visitor.specification.getMetamodels().add(IRBuilder.newMetamodel(pkg));	
			}
		}
		
		visitor.specification.getTupleTypes().addAll(metamodelContext.tupleTypes.values());	
		visitor.specification.getPrimitiveTypes().addAll(metamodelContext.primitiveTypes.values());

		ctx.applyPending();
		
		return new EFinderModel(visitor.specification);
	}
	
	
	/**
	 * The problem is that there are two instances of Package, Class, etc.
	 * 
	 * 1. The ones that belongs to the import, which references to the Ecore element
	 * 2. The ones that are part of the structure of the document  
	 * @return 
	 */
	@NonNull
	private MetamodelContext precomputeMetamodel() {
		MetamodelContext metamodelContext = new MetamodelContext(registry);
		for(EPackage pkg : packages) {
			metamodelContext.createPackage(pkg);
		}
		
		ModelImporter importer = new ModelImporter(metamodelContext);
		for (Import import_ : ocl.getOwnedImports()) {			
			Namespace ns = import_.getImportedNamespace();
			ns.accept(importer);
		}
		for (Package pkg : ocl.getOwnedPackages()) {
			pkg.accept(importer);
		}
		return metamodelContext;
	}
	
	private static class MetamodelContext {
		@NonNull
		private final Map<String, EFPackage> packages = new HashMap<>();
		@NonNull
		private final Map<EClass, EFClass> classes = new HashMap<>();
		@NonNull
		private final Map<EEnum, EFEnum> enums = new HashMap<>();
		@NonNull
		private final Map<String, EFPrimitiveType> primitiveTypes = new HashMap<>();
		@NonNull
		private final Map<String, EFTupleType> tupleTypes = new HashMap<>();
		@NonNull 
		private final Registry registry;
				
		public MetamodelContext(@NonNull Registry registry) {
			this.registry = registry;
		}
		
		@Nullable
		public EFPackage getEFPackage(@NonNull Package pkg) {
			return packages.get(pkg.getURI());
		}

		@NonNull
		public EFClass getClass(@NonNull Class c) {		
			EFClass libType = getLibraryType(c);
			if (libType != null)
				return libType;
			
			EFPackage pkg = getEFPackage(c.getOwningPackage());
			EClassifier eclass = pkg.getPkg().getEClassifier(c.getName());
			if (!(eclass instanceof EClass)) {
				// TODO: Report proper error (e.g., when class not exists)
				throw new IllegalStateException();
			}
			
			if (! classes.containsKey(eclass))
				throw new IllegalStateException("Can't find" + eclass);
			return classes.get(eclass);			
		}
		
		@NonNull
		public EFEnum getEnum(@NonNull Enumeration e) {
			EEnum eenum = (EEnum) e.getESObject();
			if (! enums.containsKey(eenum))
				throw new IllegalStateException("Can't find " + eenum);
			return enums.get(eenum);
		}
		
		@Nullable
		private EFClass getLibraryType(@NonNull Class c) {			
			if (c.eContainer() instanceof Library) {
				Library lib = (Library) c.eContainer();
				if (lib.getName().equals("ocl") && c.getName().equals("OclElement")) {
					// TODO: Refine this, make it contained somewhere
					return IRBuilder.newClass(OclPackage.Literals.OCL_ANY_LIB_ELEMENT);
				}
			}
			return null;
		}

		@Nullable
		public TypeRef getType(@NonNull Type t) {
			if (t instanceof TemplateParameter) {
				throw new UnsupportedTranslationException("Template parameters are not supported", "template-parameter");
			}
			
			// In EMF/OCL we have that PrimitiveType < Class < Type
			//                         CollectionType < DataType
			if (t instanceof CollectionType) {
				CollectionType ct = (CollectionType) t;
				return getCollectionType(ct);
			} else if (t instanceof TupleType) {
				TupleType tt = (TupleType) t;
				return IRBuilder.newMetaTypeRef(getTupleType(tt));
			} else if (t instanceof PrimitiveType || (t instanceof DataType && !(t instanceof Enumeration))) {
				DataType pt = (DataType) t;
				return IRBuilder.newMetaTypeRef(getOrCreatePrimitiveType(pt.getName()));
			} else if (t instanceof Enumeration) {
				return IRBuilder.newMetaTypeRef(getEnum((Enumeration) t));
			} else if (t instanceof InvalidType) {
				return IRBuilder.newInvalidTypeRef();
			} else if (t instanceof Class) {
				return IRBuilder.newMetaTypeRef(getClass((Class) t));		
			}
			
			throw new UnsupportedOperationException("No support for: " + t);				
		}


		@NonNull
		public EFTupleType getTupleType(TupleType tt) {		
			TupleTypeHandler handler = getTupleTypeHandler(tt);
			EFTupleType eft = tupleTypes.computeIfAbsent(handler.getId(), (k) -> handler.toType());
			return eft;
		}
		
		@NonNull
		protected TupleTypeHandler getTupleTypeHandler(TupleType tt) {
			Map<String, TypeRef> prop2types = new HashMap<String, TypeRef>();
			for (Property property : tt.getOwnedProperties()) {
				prop2types.put(property.getName(), getType(property.getType()));
			}
			
			TupleTypeHandler handler = IRUtils.getTupleTypeHandler(prop2types);
			return handler;
		}
				
		@NonNull
		private TypeRef getCollectionType(@NonNull CollectionType ct) {
			TypeRef elementType = getType(ct.getElementType());
			if (ct instanceof SetType) {
				return IRBuilder.newSetTypeRef(elementType);
			} else if (ct instanceof SequenceType) {
				return IRBuilder.newSequenceTypeRef(elementType);
			} else if (ct instanceof OrderedSetType) {
				return IRBuilder.newOrderedSetTypeRef(elementType);
			} else if (ct instanceof BagType) {
				return IRBuilder.newBagTypeRef(elementType);
			} else if (ct.getName().equals("Collection")) {
				System.out.println("Asumming a sequence");
				return IRBuilder.newSequenceTypeRef(elementType);
			}
			throw new IllegalStateException();
		}

		private static ImmutableMap<String, String> ecoreDataTypes = ImmutableMap.<String, String>builder()
				.put("EInt", "Integer")
				.put("EBoolean", "Boolean").build();	
		
		@NonNull
		private EFPrimitiveType getOrCreatePrimitiveType(@NonNull String name) {
			final String normalizedDataType;
			if (ecoreDataTypes.containsKey(name))
				normalizedDataType = ecoreDataTypes.get(name);
			else
				normalizedDataType = name;
			// We can normalize better, but for the moment...
			return primitiveTypes.computeIfAbsent(name, n -> IRBuilder.newPrimitiveType(normalizedDataType));
		}

		public void createPackage(@NonNull Package pkg) {		
			EPackage epkg = getEPackage(pkg);			
			if (epkg == null) {
				if (! packages.containsKey(pkg.getURI()))
					System.out.println("Cannot load package " + pkg.getName());
				return;
			}			
			
			createPackage(epkg);
		}

		protected void createPackage(@NonNull EPackage epkg) {
			String id = epkg.getNsURI();
			if (packages.containsKey(id))
				return;

			EFPackage efp = IRBuilder.newPackage(epkg);
			packages.put(id, efp);

			for (EClassifier eClassifier : epkg.getEClassifiers()) {
				if (eClassifier instanceof EClass) {
					createClass(efp, (EClass) eClassifier);					
				} else if (eClassifier instanceof EEnum) {
					createEnum(efp, (EEnum) eClassifier);
				}
			}

			for (EPackage ePackage : epkg.getESubpackages()) {
				createPackage(ePackage);
			}
		}

		private EPackage getEPackage(@NonNull Package pkg) {
			EPackage epkg;
			if (pkg.getEPackage() == null) {
				String uri = pkg.getURI();
				epkg = registry.getEPackage(uri);
			} else {
				epkg = pkg.getEPackage();
			}
			return epkg;
		}

		public void createClass(@NonNull EFPackage pkg, @NonNull EClass eclass) {
			Preconditions.checkArgument(! classes.containsKey(eclass));
			
			EFClass r = IRBuilder.newClass((EClass) eclass);
			pkg.getClasses().add(r);
			classes.put(eclass, r);
			
			// Recursively visit reference types in case we need to load its packages
			// Sometimes this is needed, see e.g., 'eclipse/ocl/examples/org.eclipse.ocl.examples.project.completeocltutorial/model/ExtraXtextValidation.ocl'
			for (EReference ref : eclass.getEAllReferences()) {
				EClass target = ref.getEReferenceType();
				createPackage(target.getEPackage());
			}
			
		}

		public void createEnum(@NonNull EFPackage pkg, @NonNull EEnum enum_) {
			Preconditions.checkArgument(! enums.containsKey(enum_));
			
			List<EFEnumLiteral> literals = new ArrayList<EFEnumLiteral>();
			for (EEnumLiteral lit : enum_.getELiterals()) {
				literals.add(IRBuilder.newEnumLiteral(lit.getName()));
			}
			
			if (literals.isEmpty()) {
				throw new InvalidModelException("Enum " + enum_.getName() + " without literals");
			}
			
			EFEnum r = IRBuilder.newEnum((EEnum) enum_, literals);
			pkg.getEnumerations().add(r);
			enums.put((EEnum) enum_, r);
		}

	}

	private static class ModelImporter extends AbstractExtendingVisitor<Void, MetamodelContext> {

		protected ModelImporter(MetamodelContext context) {
			super(context);
		}

		@Override
		public Void visiting(@NonNull Visitable visitable) {
			throw new IllegalStateException();
		}

		@Override
		public Void visitModel(@NonNull Model object) {
			object.getOwnedImports().forEach(i -> i.accept(this));
			object.getOwnedPackages().forEach(p -> p.accept(this));
			return null;
		}
		
		@Override
		public Void visitImport(@NonNull Import object) {
			Namespace ns = object.getImportedNamespace();
			if (ns != null)
				ns.accept(this);
			return null;
		}
		
		@Override
		public Void visitPackage(@NonNull Package pkg) {
			context.createPackage(pkg);
			pkg.getOwnedPackages().forEach(p -> p.accept(this));
			return null;
		}
		
	}
	
	private static class ModelVisitor extends AbstractExtendingVisitor<Void, CompilerContext> {

		@NonNull 
		private final Specification specification;
		@NonNull
		private MetamodelContext metamodels;

		protected ModelVisitor(@NonNull CompilerContext ctx) {
			super(ctx);
			this.metamodels = ctx.metamodels;
			this.specification = IRBuilder.newSpecification();
		}
		
		@Override
		public Void visitModel(@NonNull Model object) {			
			object.getOwnedImports().forEach(p -> p.accept(this));
			object.getOwnedPackages().forEach(p -> p.accept(this));
			return null;
		}
		
		@Override
		public Void visitImport(@NonNull Import object) {
			Namespace ns = object.getImportedNamespace();
			if (ns == null)
				return null;
			ns.accept(this);
			return null;
		}
		
		@Override
		public Void visitPackage(@NonNull Package object) {
			EFPackage pkg = metamodels.getEFPackage(object);
			if (pkg == null) {
				System.out.println("No package " + object);
				// Report?
				return null;
			}

			object.getOwnedPackages().forEach(p -> p.accept(this));
			object.getOwnedClasses().forEach(p -> p.accept(this));			
			return null;
		}
		
		@Override
		public Void visitClass(@NonNull Class object) {
			object.getOwnedConstraints().forEach(c -> c.accept(this));
			object.getOwnedInvariants().forEach(c -> c.accept(this));
			object.getOwnedOperations().forEach(c -> c.accept(this));
			object.getOwnedProperties().forEach(c -> c.accept(this));
			return null;
		}
			
		@Override
		public Void visitConstraint(@NonNull Constraint object) {
			ExpressionInOCL expr = (ExpressionInOCL) getExpression(object.getOwnedSpecification());
			
			Namespace ctx = object.getContext();
			
			// There are two contexts: one in the constraint and another in the expression
			// It seems that the one in the expression is more precise, since in e.g., OclTest there is an invariant for an enumeration
			// this is the only way of seeing it
			Type type = expr.getOwnedContext().getType();
			if (type instanceof Enumeration) {
				// This is supported in EMF/OCL but not our IR, besides is of little utility
				context.report.addUnsupported("Constraint with enumeration context", object, Report.Action.IGNORE, "datatype-context");
				return null;
			} else if (type instanceof DataType) {
				context.report.addUnsupported("Constraint with datatype context", object, Report.Action.IGNORE, "datatype-context");
				return null;				
			}
			
			if (ctx instanceof Class) {
				Class c = (Class) ctx;
				EFClass efc = metamodels.getClass(c);

				// 2. Create the context variable, possibly using the type created in (1)
				Variable exprCtx = expr.getOwnedContext();
				VariableDeclaration varDcl = context.toVariableDeclaration(exprCtx, (eft) -> IRBuilder.newVariableDeclaration(exprCtx.getName(), eft));				
				
				// 3. Compile the expression after having set the context
				OclExpression irExpr = ExpressionVisitor.compileExpression(expr, context);
				
				// 4. Create the invariant object
				OclInvariant invariant = IRBuilder.newInvariant(irExpr, object.getName());
				specification.getConstraints().add(invariant);
				invariant.setKlass(efc);
				invariant.setContextVariable(varDcl);
			} else {
				throw new UnsupportedOperationException("Context type not supported: " + ctx);
			}

			
			return null;
		}
		
		@Override
		public Void visitProperty(@NonNull Property p) {
			if (p.isIsDerived()) {
				ExpressionInOCL expr = getExpression(p.getOwnedExpression());
				if (expr == null) {
					System.out.println("LOG: Property without expressions: " + p);
					// This happens for instance in 'AmeniBF/GemRBAC-CTX-model/GemRBACCTX/model/PL1.ocl' due to eAttributeType 
					return null;
					// throw new UnsupportedOperationException("Property without expression. TODO: What to do");
				}
				
				if ( expr.getOwnedContext() == null ) {
					System.out.println("Property without context: " + p);
					throw new IllegalStateException("Property without context: " + p);
				}
								
				Class pivotCtx = (Class) expr.getOwnedContext().getType();
				EFClass ctx = metamodels.getClass(pivotCtx);
				TypeRef type = metamodels.getType(p.getType());
				
				Variable exprCtx = expr.getOwnedContext();
				VariableDeclaration varDcl = context.toVariableDeclaration(exprCtx, (eft) -> IRBuilder.newVariableDeclaration(exprCtx.getName(), eft));
				
				OclExpression body = ExpressionVisitor.compileExpression(expr, context);
				OclDerivedProperty irProperty = IRBuilder.newOclDerivedProperty(ctx, p.getName(), type, body);
				irProperty.setContextVariable(varDcl);
				specification.getProperties().add(irProperty);
				context.mapProperty(p, irProperty);
			} else {
				// This has already been handled in preComputeMetamodel()
			}
			return null;
		}
		
		@Override
		public Void visitOperation(@NonNull Operation o) {
			ExpressionInOCL expr = getExpression(o.getBodyExpression());
			if (expr == null) {
				System.out.println("LOG: Operation without expressions: " + o);
				// Happens for Ecore operations but also when the operation is defined in the meta-model but there is no available
				// implementation in OCL
				return null;
			}
			
			if ( expr.getOwnedContext() == null ) {
				System.out.println("Operation without context: " + o);
				throw new IllegalStateException("Operation without context: " + o);
			}
							
			Class pivotCtx = (Class) expr.getOwnedContext().getType();
			if (pivotCtx instanceof Enumeration) {
				// This is supported in EMF/OCL but not our IR, besides is of little utility
				context.report.addUnsupported("Operation with enumeration context", o, Report.Action.IGNORE, "datatype-context");
				return null;
			} else if (pivotCtx instanceof DataType) {
				context.report.addUnsupported("Operation with datatype context", o, Report.Action.IGNORE, "datatype-context");
				return null;				
			}

			EFClass ctx = metamodels.getClass(pivotCtx);
			TypeRef type = metamodels.getType(o.getType());
			
			Variable exprCtx = expr.getOwnedContext();
			VariableDeclaration varDcl = context.toVariableDeclaration(exprCtx, (eft) -> IRBuilder.newVariableDeclaration(exprCtx.getName(), eft));
			
			// We have to be careful because o.getOwnedParameters() gives variable declarations which are not actually used by the expression body
			List<efinder.ir.Parameter> parameters = new ArrayList<>(expr.getOwnedParameters().size());			
			for(Variable p : expr.getOwnedParameters()) {
				efinder.ir.Parameter newParameter = context.toVariableDeclaration(p, (eft) -> {
					efinder.ir.Parameter irp = EfinderFactory.eINSTANCE.createParameter();
					irp.setName(p.getName());
					irp.setType(eft);
					return irp;
				});
				
				//TypeRef eft = metamodels.getType(p.getType());
//				efinder.ir.Parameter newParameter = EfinderFactory.eINSTANCE.createParameter();
//				newParameter.setName(p.getName());
//				newParameter.setType(eft);
				parameters.add(newParameter);				
			}
			
			OclExpression body = ExpressionVisitor.compileExpression(expr, context);
			OclOperation irOperation = IRBuilder.newOclOperation(ctx, o.getName(), parameters, type, body);
			irOperation.setContextVariable(varDcl);
			specification.getOperations().add(irOperation);
			context.mapOperation(o, irOperation);
			return null;

		}

		@Nullable
		private ExpressionInOCL getExpression(@NonNull LanguageExpression spec) {
			if ( spec == null )
				return null;
			ExpressionInOCL exp = (ExpressionInOCL) spec;
			// TODO: Check if this happens in practice
			if ( exp.getOwnedBody() == null ) {
		        OCL ocl = OCL.newInstance(OCL.NO_PROJECTS, exp.eResource().getResourceSet());
		        try {
					ocl.parseSpecification(exp);
		        } catch (ParserException e) {
		        	throw new UnsupportedTranslationException(e.getMessage(), "parse-error");
		        }
			}
			return exp;
		}

		@Override
		public Void visiting(@NonNull Visitable visitable) {
			throw new UnsupportedOperationException("Node " + visitable.getClass().getName() + " - " + visitable + " not supported yet");
		}		
		
	}

	private static class ExpressionVisitor extends AbstractExtendingVisitor<OclExpression, CompilerContext> {
		private static ImmutableMap<String, OperatorKind> operators = ImmutableMap.<String, OperatorKind>builder()
				.put("not", OperatorKind.NOT)
				.put("*", OperatorKind.MUL)
				.put("/", OperatorKind.DIV)
				.put("-", OperatorKind.MINUS)
				.put("+", OperatorKind.PLUS)
				.put("<", OperatorKind.LESS)
				.put(">", OperatorKind.GREATER)
				.put("<=", OperatorKind.LESS_OR_EQUAL)
				.put(">=", OperatorKind.GREATER_OR_EQUAL)
				.put("=", OperatorKind.EQUAL)
				.put("<>", OperatorKind.DISTINCT)
				.put("and", OperatorKind.AND)
				.put("or", OperatorKind.OR)
				.put("xor", OperatorKind.XOR)
				.put("implies", OperatorKind.IMPLIES).build();
				
		protected ExpressionVisitor(@NonNull CompilerContext ctx) {
			super(ctx);
		}

		@Override
		public OclExpression visiting(@NonNull Visitable visitable) {
			throw new UnsupportedOperationException("Node " + visitable.getClass() + " not supported. " + visitable);
		}
		
		@Override
		public OclExpression visitVariableExp(@NonNull VariableExp object) {
			VariableDeclaration varDcl = context.getVariableDeclaration(object.getReferredVariable());
			return IRBuilder.newVariableExp(varDcl);
		}
				
		@Override
		public OclExpression visitTypeExp(@NonNull TypeExp object) {
			Type type = object.getReferredType();
			if (!(type instanceof Class)) {
				throw new UnsupportedOperationException("Only class references allowed: " + object);				
			}
			if (type instanceof Enumeration) {
				return IRBuilder.newUnsupportedExp("TypeExp as enumeration not supported " + object, "TypeExpIsEnum");
			}
			if (type instanceof VoidType) {
				// Tentatively use undefined to represent the same. Example: org.eclipse.ocl.examples.xtext.tests/src/org/eclipse/ocl/examples/test/xtext/models/Bug441620.oc 
				return IRBuilder.newOclUndefined();
			}
			TypeRef t = context.metamodels.getType(type);
			return IRBuilder.newModelElement(t);
		}
		
		// Operations
		
		@Override
		public OclExpression visitPropertyCallExp(@NonNull PropertyCallExp p) {
			String name = p.getReferredProperty().getName();		
			OclExpression source = toExpression(p.getOwnedSource());
			
			Property definition = p.getReferredProperty();
			if (definition.getESObject() == null) {
				efinder.ir.ocl.@NonNull PropertyCallExp call = IRBuilder.newProperyCallExp(name, null, source);

				// It can be a tuple access
				if (definition.eContainer() instanceof TupleType) {
					TupleType tt = (TupleType) definition.eContainer();
					context.addPendingResolution(new ResolveTupleAccess(definition, tt, call));
				} else if (definition.getImplementation() != null) {
					call.setFeature(EfinderFactory.eINSTANCE.createBuiltinPropertyRef());
				} else {				
					// This is likely defined in the OCL text, so we resolve against it					
					context.addPendingResolution(new ResolveProperty(definition, call));
				}
				return call;
			} else {			
				EStructuralFeature f = (EStructuralFeature) p.getReferredProperty().getESObject();
				return IRBuilder.newProperyCallExp(name, f, source);
			}
		}
		
		@Override
		public OclExpression visitOppositePropertyCallExp(@NonNull OppositePropertyCallExp object) {
			return IRBuilder.newUnsupportedExp("Opposite properties not supported: " + object, "opposite-property");
		}
		
		@Override
		public OclExpression visitShadowExp(@NonNull ShadowExp object) {
			return IRBuilder.newUnsupportedExp("ShadowExp not supported: " + object, "shadow-exp");
		}
		
		@Override
		public OclExpression visitOperationCallExp(@NonNull OperationCallExp op) {
			Type sourceType = op.getOwnedSource().getType();
			String name = op.getReferredOperation().getName();		
			OclExpression source = toExpression(op.getOwnedSource());
			List<OclExpression> args = toExpression(op.getOwnedArguments());
			
			if ( isOperator(op) ) {
				OperatorKind operator = operators.get(name);	
				// It seems that -1 is parsed as op(-), 1 which is very weird and needs some normalization
				if (operator == OperatorKind.MINUS && args.isEmpty()) {
					if (source instanceof efinder.ir.ocl.IntegerLiteralExp) {
						efinder.ir.ocl.IntegerLiteralExp lit = (efinder.ir.ocl.IntegerLiteralExp) source;
						lit.setValue(-1 * lit.getValue());
						return lit;
					} else {
						return IRBuilder.newOperatorCallExp(OperatorKind.MUL, 
								IRBuilder.newIntegerExp(-1), 
								Collections.singletonList(source));
					}
				}
				return IRBuilder.newOperatorCallExp(operator, source, args); 						
			} else {
				if ( sourceType instanceof CollectionType ) {
					CollectionCallExp call = IRBuilder.newCollectionCallExp(name, source, args);
					return call;
				} else {
					efinder.ir.ocl.@NonNull OperationCallExp call = IRBuilder.newOperationCallExp(name, source, args);
					Operation refOp = op.getReferredOperation();
					if (refOp.getImplementation() instanceof EObjectOperation) {
						context.addPendingResolution(new ResolveOperation(refOp, call));
					} else {
						call.setFeature(EfinderFactory.eINSTANCE.createBuiltinOperationRef());
					}
					return call;
				}
			}
		}
		
		@Override
		public OclExpression visitIteratorExp(@NonNull IteratorExp object) {
			OclExpression source = toExpression(object.getOwnedSource());
			List<Iterator> iterators = toIterator(object.getOwnedIterators());
			OclExpression body = toExpression(object.getOwnedBody());
			return IRBuilder.newIteratorExp(object.getName(), source, iterators, body);
		}
		
		private List<Iterator> toIterator(List<? extends Variable> iterators) {
			List<Iterator> newIterators = new ArrayList<Iterator>(iterators.size());
			for (Variable variable : iterators) {
				Iterator it = context.toVariableDeclaration(variable, (eft) -> IRBuilder.newIterator(variable.getName(), eft));
				newIterators.add(it);
			}			
			return newIterators;
		}
		
		@Override
		public OclExpression visitIterateExp(@NonNull IterateExp object) {
			Variable oclVar = object.getOwnedResult();

			OclExpression source = toExpression(object.getOwnedSource());
			VariableDeclaration resultVar = context.toVariableDeclaration(oclVar, (eft) -> IRBuilder.newVariableDeclaration(oclVar.getName(), eft));
			OclExpression initResultVar = toExpression(object.getOwnedResult().getOwnedInit());
			List<Iterator> iterators = toIterator(object.getOwnedIterators());
			OclExpression body = toExpression(object.getOwnedBody());
			
			return IRBuilder.newIterateExp(source, resultVar, initResultVar, iterators, body);
		}
		
		@Override
		public OclExpression visitIfExp(@NonNull IfExp object) {
			OclExpression condition = toExpression(object.getOwnedCondition());
			OclExpression then_ = toExpression(object.getOwnedThen());
			OclExpression else_ = toExpression(object.getOwnedElse());
			return IRBuilder.newIfExp(condition, then_, else_);
		}
		
		@Override
		public OclExpression visitLetExp(@NonNull LetExp object) {
			Variable var = object.getOwnedVariable();
			VariableDeclaration varDcl = context.toVariableDeclaration(var, (eft) -> IRBuilder.newVariableDeclaration(var.getName(), eft));
			OclExpression init = toExpression(var.getOwnedInit());
			OclExpression in = toExpression(object.getOwnedIn());
			
			return IRBuilder.newLetExp(varDcl, init, in);			
		}

		// Literals
		
		@Override
		public OclExpression visitBooleanLiteralExp(@NonNull BooleanLiteralExp object) {
			return IRBuilder.newBooleanExp(object.isBooleanSymbol());			
		}

		@Override
		public OclExpression visitStringLiteralExp(@NonNull StringLiteralExp object) {
			return IRBuilder.newStringExp(object.getStringSymbol());
		}
		
		@Override
		public OclExpression visitIntegerLiteralExp(@NonNull IntegerLiteralExp object) {
			return IRBuilder.newIntegerExp(object.getIntegerSymbol());
		}
		
		@Override
		public OclExpression visitUnlimitedNaturalLiteralExp(@NonNull UnlimitedNaturalLiteralExp object) {
			// TODO: Maybe check if the value is too large?
			return IRBuilder.newIntegerExp(object.getUnlimitedNaturalSymbol());
		}
		
		@Override
		public OclExpression visitRealLiteralExp(@NonNull RealLiteralExp object) {
			return IRBuilder.newRealExp(object.getRealSymbol());
		}
		
		@Override
		public OclExpression visitNullLiteralExp(@NonNull NullLiteralExp object) {
			return IRBuilder.newOclUndefined();
		}
		
		@Override
		public OclExpression visitInvalidLiteralExp(@NonNull InvalidLiteralExp object) {
			return IRBuilder.newOclInvalid();
		}
		
		@Override
		public OclExpression visitEnumLiteralExp(@NonNull EnumLiteralExp object) {
			Type t = object.getType();
			MetaTypeRef eft = (MetaTypeRef) context.metamodels.getType(t);
			EFEnum enum_ = (EFEnum) eft.getType();
			EFEnumLiteral found = null;
			for (EFEnumLiteral lit : enum_.getLiterals()) {
				if (lit.getName().equals(object.getName())) {
					found = lit;
					break;
				}
			}
			
			if (found == null) {
				throw new TypeError("Can't find enum literal" + object, "no-enum");
			}
			
			return IRBuilder.newEnumLiteral(eft, found);
		}
		
		@Override
		public OclExpression visitCollectionLiteralExp(@NonNull CollectionLiteralExp object) {
			Type ct = object.getType();
			List<OclExpression> parts = new ArrayList<OclExpression>();
			for (CollectionLiteralPart part : object.getOwnedParts()) {
				if ( part instanceof CollectionItem ) {
					CollectionItem item = (CollectionItem) part;
					parts.add(toExpression(item.getOwnedItem()));
				} else {
					CollectionRange range = (CollectionRange) part;
					List<OclExpression> elements = tryTransformRange(range);
					parts.addAll(elements);
				}
			}
	
			// It is also possible to use object.getKind()
			if (ct instanceof SetType) {
				return IRBuilder.newSetLiteral(parts);
			} else if (ct instanceof SequenceType) {
				return IRBuilder.newSequenceLiteral(parts);
			} else if (ct instanceof OrderedSetType) {
				return IRBuilder.newOrderedSetLiteral(parts);
			} else if (ct instanceof BagType) {
				return IRBuilder.newBagLiteral(parts);
			}

			throw new UnsupportedOperationException("Collection type not supported: " + object);
		}
		
		private static int RANGE_LIMIT = 100;
		
		private List<OclExpression> tryTransformRange(@NonNull CollectionRange range) {
			OCLExpression first = range.getOwnedFirst();
			OCLExpression last = range.getOwnedLast();

			List<OclExpression> unfoldedElements = new ArrayList<OclExpression>();
			try {
				int i1 = evaluateOclExpression(first);
				int i2 = evaluateOclExpression(last);
				if ( i2 > RANGE_LIMIT )
					return Collections.singletonList(IRBuilder.newUnsupportedExp("Collection range is to high:" + range + ". ", "range"));
				
				if ( i1 <= i2 ) {
					for(int i = i1; i <= i2; i++) {
						OclExpression value = IRBuilder.newIntegerExp(i);
						unfoldedElements.add(value);
					}
				
					return unfoldedElements;
				}			
				// I guess this means that unfolding is empty
				return Collections.emptyList();
			} catch ( Exception e ) {
				return Collections.singletonList(IRBuilder.newUnsupportedExp("Collection range cannot be flattened:" + range + ". " + e.getMessage(), "range"));
			}			
		}

		private int evaluateOclExpression(OCLExpression first) {
			try {
	            OCL ocl = OCL.newInstance();
		        //@NonNull
				//OCLHelper helper = ocl.createOCLHelper(first);
		        @NonNull
				ExpressionInOCL query = PivotFactory.eINSTANCE.createExpressionInOCL();
		        query.setOwnedBody(EcoreUtil.copy(first));
		        //@NonNull
				//ExpressionInOCL query = helper.createQuery(first.toString());        
		        Object result = ocl.evaluate(null, query);
		        return ((IntegerValue) result).intValue();
	        } catch (Exception e) {
	        	throw e;
	        }			
		}

		@Override
		public OclExpression visitTupleLiteralExp(@NonNull TupleLiteralExp object) {
			TupleType tt = (TupleType) object.getType();
			EFTupleType eft = context.metamodels.getTupleType(tt);		
			
			efinder.ir.ocl.TupleLiteralExp tuple = IRBuilder.newTupleLiteral();
			for (TupleLiteralPart tupleLiteralPart : object.getOwnedParts()) {
				TuplePart part = OclFactory.eINSTANCE.createTuplePart();
				part.setName(tupleLiteralPart.getName());
				part.setValue(toExpression(tupleLiteralPart.getOwnedInit()));
				tuple.getParts().add(part);
			}

			tuple.setTupleType(eft);
			
			return tuple;
		}
		
		// Utilities

		private boolean isOperator(@NonNull OperationCallExp op) {
			return operators.containsKey(op.getReferredOperation().getName());
		}
		
		@NonNull
		public OclExpression toExpression(@NonNull OCLExpression expr) {
			OclExpression r = expr.accept(this);
			try {
				// TODO: Do all of this in a more elegant way
				if (expr.getType() != null)
					r.setType(context.metamodels.getType(expr.getType()));
			} catch (Exception e) {
				// Fallback, e.g. for ModelElement
				try {
					if (expr.getTypeValue() != null)
						r.setType(context.metamodels.getType(expr.getTypeValue()));
				} catch (Exception e2) {
					// Couldn't recover a type
				}
			}
			return r;
		}		
		
		@NonNull
		private List<OclExpression> toExpression(@NonNull List<? extends OCLExpression> exprs) {
			List<OclExpression> expressions = new ArrayList<OclExpression>(exprs.size());
			for (OCLExpression expr : exprs) {
				expressions.add(toExpression(expr));
			}
			return expressions;
		}

		
		@NonNull
		public static OclExpression compileExpression(@NonNull ExpressionInOCL expr, @NonNull CompilerContext ctx) {			
			return new ExpressionVisitor(ctx).toExpression(expr.getOwnedBody());
		}
		
	}

	private static class CompilerContext {		
		@NonNull 
		private final Report report;
		@NonNull 
		private final MetamodelContext metamodels;
		@NonNull 
		private final Map<org.eclipse.ocl.pivot.VariableDeclaration, VariableDeclaration> variables = new HashMap<>();
		@NonNull 
		private final Map<org.eclipse.ocl.pivot.Feature, AbstractFunction> functions = new HashMap<>();		
		@NonNull
		private final List<Consumer<CompilerContext>> pendingOperations = new ArrayList<Consumer<CompilerContext>>();
		
		public CompilerContext(@NonNull MetamodelContext metamodels, @NonNull Report report) {
			this.metamodels = metamodels;
			this.report = report;
		}
		
		public void addPendingResolution(@NonNull Consumer<CompilerContext> pending) {
			pendingOperations.add(pending);
		}
		
		public void applyPending() {
			pendingOperations.forEach(o -> o.accept(this));
		}

		public efinder.ir.@Nullable Operation getOperation(Operation operation) {
			return (efinder.ir.Operation) functions.get(operation);
		}

		@Nullable
		public OclDerivedProperty getProperty(Property p) {
			return (OclDerivedProperty) functions.get(p);
		}

		public void mapOperation(@NonNull Operation o, @NonNull OclOperation irOperation) {
			functions.put(o, irOperation);
		}

		public void mapProperty(@NonNull Property p, @NonNull OclDerivedProperty irProperty) {
			functions.put(p, irProperty);			
		}

		@NonNull
		public <T extends VariableDeclaration> T toVariableDeclaration(org.eclipse.ocl.pivot.@NonNull VariableDeclaration originalVar, @NonNull Function<TypeRef, T> varDclFactory) {
			Type type = originalVar.getType();
			TypeRef ref = metamodels.getType(type);
			T newVar = varDclFactory.apply(ref);
			variables.put(originalVar, newVar);
			return newVar;
		}

		@NonNull
		public VariableDeclaration getVariableDeclaration(org.eclipse.ocl.pivot.@NonNull VariableDeclaration varDcl) {
			VariableDeclaration v = variables.get(varDcl);
			Preconditions.checkNotNull(v, "Can't find " + varDcl);
			return v;
		}

	}
	
	private static class ResolveOperation implements Consumer<CompilerContext> {

		private final Operation operation;
		private final efinder.ir.ocl.@NonNull OperationCallExp call;

		public ResolveOperation(Operation operation, efinder.ir.ocl.@NonNull OperationCallExp call) {
			this.operation = operation;
			this.call = call;
		}
		
		@Override
		public void accept(CompilerContext c) {
			efinder.ir.Operation irOperation = c.getOperation(operation);
			if (irOperation == null) {
				throw new TypeError("Operation not declared " + operation.getName(), "operation-not-found");
			}

			DefinedOperationRef ref = EfinderFactory.eINSTANCE.createDefinedOperationRef();
			ref.setOperation(irOperation);
			call.setFeature(ref);
		}		
	}

	private static class ResolveProperty implements Consumer<CompilerContext> {

		private final Property property;
		private final efinder.ir.ocl.@NonNull PropertyCallExp call;

		public ResolveProperty(@NonNull Property property, efinder.ir.ocl.@NonNull PropertyCallExp call) {
			this.property = property;
			this.call = call;
		}
		
		@Override
		public void accept(CompilerContext c) {
			@Nullable OclDerivedProperty irProperty = c.getProperty(property);
			if (irProperty == null) {
				throw new TypeError("Property not declared " + property.getName(), "property-not-found");
			}
			
			DerivedPropertyRef ref = EfinderFactory.eINSTANCE.createDerivedPropertyRef();
			ref.setProperty(irProperty);
			call.setFeature(ref);
		}		
	}

	private static class ResolveTupleAccess implements Consumer<CompilerContext> {

		private final Property property;
		private final efinder.ir.ocl.@NonNull PropertyCallExp call;
		private final TupleType tupleType;

		public ResolveTupleAccess(@NonNull Property property, @NonNull TupleType tt, efinder.ir.ocl.@NonNull PropertyCallExp call) {
			this.property = property;
			this.tupleType = tt;
			this.call = call;
		}
		
		@Override
		public void accept(CompilerContext c) {
			EFTupleType ttx = c.metamodels.getTupleType(tupleType);
			if (ttx == null)
				return;

			TupleFieldRef ref = EfinderFactory.eINSTANCE.createTupleFieldRef();
			ref.setType(ttx);
			ref.setName(property.getName());
			call.setFeature(ref);
		}		
	}
}
