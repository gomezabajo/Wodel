package efinder.core.ir;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;

import efinder.ir.BagTypeRef;
import efinder.ir.DefinedOperationRef;
import efinder.ir.EFClass;
import efinder.ir.EFEnum;
import efinder.ir.EFEnumLiteral;
import efinder.ir.EFMetamodel;
import efinder.ir.EFPackage;
import efinder.ir.EFPrimitiveType;
import efinder.ir.EFType;
import efinder.ir.EfinderFactory;
import efinder.ir.MetaTypeRef;
import efinder.ir.MetamodelFeatureRef;
import efinder.ir.OperationFeatureRef;
import efinder.ir.OrderedSetTypeRef;
import efinder.ir.Parameter;
import efinder.ir.SequenceTypeRef;
import efinder.ir.SetTypeRef;
import efinder.ir.Specification;
import efinder.ir.TypeRef;
import efinder.ir.VariableDeclaration;
import efinder.ir.ocl.BagLiteralExp;
import efinder.ir.ocl.BooleanLiteralExp;
import efinder.ir.ocl.CollectionCallExp;
import efinder.ir.ocl.EnumLiteralExp;
import efinder.ir.ocl.IfExp;
import efinder.ir.ocl.IntegerLiteralExp;
import efinder.ir.ocl.IterateExp;
import efinder.ir.ocl.Iterator;
import efinder.ir.ocl.IteratorExp;
import efinder.ir.ocl.LetExp;
import efinder.ir.ocl.ModelElement;
import efinder.ir.ocl.OclDerivedProperty;
import efinder.ir.ocl.OclExpression;
import efinder.ir.ocl.OclFactory;
import efinder.ir.ocl.OclInvalid;
import efinder.ir.ocl.OclInvariant;
import efinder.ir.ocl.OclOperation;
import efinder.ir.ocl.OclUndefined;
import efinder.ir.ocl.OperatorCallExp;
import efinder.ir.ocl.OperatorKind;
import efinder.ir.ocl.OrderedSetLiteralExp;
import efinder.ir.ocl.PropertyCallExp;
import efinder.ir.ocl.RealLiteralExp;
import efinder.ir.ocl.SequenceLiteralExp;
import efinder.ir.ocl.SetLiteralExp;
import efinder.ir.ocl.StringLiteralExp;
import efinder.ir.ocl.TupleLiteralExp;
import efinder.ir.ocl.UnsupportedExp;
import efinder.ir.ocl.VarExp;

public class IRBuilder {

	public static ImmutableMap<String, EDataType> DataTypes = ImmutableMap.<String, EDataType>builder().
			put("String", EcorePackage.Literals.ESTRING).
			put("Integer", EcorePackage.Literals.EINT).
			put("Boolean", EcorePackage.Literals.EBOOLEAN).build();	

	@NonNull
	public static Specification newSpecification() {
		Specification spec = EfinderFactory.eINSTANCE.createSpecification();
		spec.setTemporary(EfinderFactory.eINSTANCE.createTemporary());
		return spec;
	}

	@NonNull
	public static EFPrimitiveType newPrimitiveType(@NonNull String name) {
		EFPrimitiveType pt = EfinderFactory.eINSTANCE.createEFPrimitiveType();
		pt.setName(name);
		return pt;
	}
	
	@NonNull
	public static OclInvariant newInvariant(@NonNull OclExpression expr, String name) {
		OclInvariant constraint = OclFactory.eINSTANCE.createOclInvariant();
		constraint.setExpression(expr);
		constraint.setName(name);
		return constraint;
	}

	@NonNull
	public static EFMetamodel newMetamodel(@NonNull EFPackage pkg) {
		EFMetamodel m = EfinderFactory.eINSTANCE.createEFMetamodel();
		m.getRoots().add(pkg);
		return m;
	}
	
	@NonNull
	public static EFMetamodel newMetamodel(@NonNull Collection<? extends EFPackage> pkgs) {
		EFMetamodel m = EfinderFactory.eINSTANCE.createEFMetamodel();
		m.getRoots().addAll(pkgs);
		return m;
	}
	
	@NonNull
	public static EFPackage newPackage(@NonNull EPackage ePackage) {
		Preconditions.checkNotNull(ePackage);
		EFPackage p = EfinderFactory.eINSTANCE.createEFPackage();
		p.setPkg(ePackage);
		return p;
	}

	@NonNull
	public static EFClass newClass(@NonNull EClass eclass) {
		EFClass c = EfinderFactory.eINSTANCE.createEFClass();
		c.setKlass(eclass);
		return c;
	}
	
	@NonNull
	public static EFEnum newEnum(@NonNull EEnum enum_, @NonNull List<? extends EFEnumLiteral> literals) {
		EFEnum c = EfinderFactory.eINSTANCE.createEFEnum();
		c.setEnum_(enum_);
		c.getLiterals().addAll(literals);
		return c;
	}

	@NonNull
	public static EFEnumLiteral newEnumLiteral(@NonNull String name) {
		EFEnumLiteral l = EfinderFactory.eINSTANCE.createEFEnumLiteral();
		l.setName(name);
		return l;
	}

	@NonNull
	public static ModelElement newModelElement(TypeRef t) {
		ModelElement me = OclFactory.eINSTANCE.createModelElement();
		me.setType(t);
		return me;
	}

	@NonNull
	public static VariableDeclaration newVariableDeclaration(@NonNull String name, @NonNull TypeRef type) {
		VariableDeclaration dcl = EfinderFactory.eINSTANCE.createVariableDeclaration();
		dcl.setName(name);
		dcl.setType(type);
		return dcl;
	}

	@NonNull
	public static Iterator newIterator(@NonNull String name, @NonNull TypeRef type) {
		Iterator it = OclFactory.eINSTANCE.createIterator();
		it.setName(name);
		it.setType(type);
		return it;
	}
	
	@NonNull
	public static OclExpression newVariableExp(@NonNull VariableDeclaration varDcl) {
		VarExp exp = OclFactory.eINSTANCE.createVarExp();
		exp.setVariable(varDcl);
		return exp;
	}

	// Expressions
	
	public static OperatorKind getOperator(String op) {
		switch (op) {
		case "+":
			return OperatorKind.PLUS;
		case "-":
			return OperatorKind.MINUS;
		case "=":
			return OperatorKind.EQUAL;
		case "/":
			return OperatorKind.DIV;
		case "*":
			return OperatorKind.MUL;
		}
		throw new IllegalArgumentException("Operator " + op + " not supported.");
	}
	
	@NonNull
	public static OperatorCallExp newOperatorCallExp(OperatorKind operator, @NonNull OclExpression source, @NonNull OclExpression arg) {
		return newOperatorCallExp(operator, source, Collections.singletonList(arg));
	}
	
	@NonNull
	public static OperatorCallExp newOperatorCallExp(OperatorKind operator, @NonNull OclExpression source, List<? extends OclExpression> args) {
		OperatorCallExp call = OclFactory.eINSTANCE.createOperatorCallExp();
		call.setOperator(operator);
		call.setSource(source);
		if (operator != OperatorKind.NOT) {
			call.setArgument(args.get(0));
		}
		return call;
	}

	@NonNull
	public static PropertyCallExp newProperyCallExp(@NonNull String name, @Nullable EStructuralFeature feature, @NonNull OclExpression source) {
		PropertyCallExp call = OclFactory.eINSTANCE.createPropertyCallExp();
		call.setName(name);
		call.setSource(source);
		if (feature != null) {
			MetamodelFeatureRef ref = EfinderFactory.eINSTANCE.createMetamodelFeatureRef();
			ref.setFeature(feature);
			call.setFeature(ref);
		}
		return call;
	}

	@NonNull
	public static CollectionCallExp newCollectionCallExp(@NonNull String name, @NonNull OclExpression source, List<? extends OclExpression> args) {
		CollectionCallExp call = OclFactory.eINSTANCE.createCollectionCallExp();
		call.setName(name);
		call.setSource(source);
		call.getArguments().addAll(args);
		return call;	
	}

	@NonNull
	public static IteratorExp newIteratorExp(@NonNull String name, @NonNull OclExpression source, Iterator iterator, @NonNull Function<Iterator, OclExpression> bodyFunction) {
		OclExpression body = bodyFunction.apply(iterator);
		return newIteratorExp(name, source, Collections.singletonList(iterator), body);
	}
	
	@NonNull
	public static IteratorExp newIteratorExp(@NonNull String name, @NonNull OclExpression source, Iterator iterator, @NonNull OclExpression body) {
		return newIteratorExp(name, source, Collections.singletonList(iterator), body);
	}
	
	@NonNull
	public static IteratorExp newIteratorExp(@NonNull String name, @NonNull OclExpression source, @NonNull List<? extends Iterator> iterators, @NonNull OclExpression body) {
		IteratorExp call = OclFactory.eINSTANCE.createIteratorExp();
		call.setName(name);
		call.setSource(source);
		call.setBody(body);
		call.getIterators().addAll(iterators);
		return call;
	}
	
	public static OclExpression newIterateExp(@NonNull OclExpression source, @NonNull VariableDeclaration resultVar,
			@NonNull OclExpression initResultVar, @NonNull List<? extends Iterator> iterators, @NonNull OclExpression body) {
		IterateExp call = OclFactory.eINSTANCE.createIterateExp();
		call.setSource(source);
		call.setResult(resultVar);
		call.setInit(initResultVar);
		call.setBody(body);
		call.getIterators().addAll(iterators);
		return call;
	}

	public static efinder.ir.ocl.@NonNull OperationCallExp newOperationCallExp(@NonNull String name, @NonNull OclExpression source) {
		return newOperationCallExp(name, source, Collections.emptyList());
	}
	
	public static efinder.ir.ocl.@NonNull OperationCallExp newOperationCallExp(@NonNull String name, @NonNull OclExpression source, List<? extends OclExpression> args) {
		efinder.ir.ocl.OperationCallExp call = OclFactory.eINSTANCE.createOperationCallExp();
		call.setName(name);
		call.setSource(source);
		call.getArguments().addAll(args);
		return call;	
	}

	@NonNull
	public static OclExpression newIfExp(@NonNull OclExpression condition, @NonNull OclExpression then_, @NonNull OclExpression else_) {
		IfExp if_ = OclFactory.eINSTANCE.createIfExp();
		if_.setCondition(condition);
		if_.setThen(then_);
		if_.setElse(else_);
		return if_;	
	}

	@NonNull
	public static LetExp newLetExp(@NonNull VariableDeclaration varDcl, @NonNull OclExpression init, @NonNull OclExpression in) {
		LetExp letExp = OclFactory.eINSTANCE.createLetExp();
		letExp.setVariable(varDcl);
		letExp.setInit(init);
		letExp.setIn(in);
		return letExp;
	}

	@NonNull
	public static BooleanLiteralExp newBooleanExp(boolean b) {
		BooleanLiteralExp lit = OclFactory.eINSTANCE.createBooleanLiteralExp();
		lit.setValue(b);
		return lit;
	}

	@NonNull
	public static StringLiteralExp newStringExp(@NonNull String stringSymbol) {
		StringLiteralExp lit = OclFactory.eINSTANCE.createStringLiteralExp();
		lit.setValue(stringSymbol);
		return lit;
	}

	@NonNull
	public static OclExpression newIntegerExp(@NonNull Number integerSymbol) {
		IntegerLiteralExp lit = OclFactory.eINSTANCE.createIntegerLiteralExp();
		lit.setValue(integerSymbol.intValue());
		return lit;
	}
	
	@NonNull
	public static OclExpression newRealExp(Number realSymbol) {
		RealLiteralExp lit = OclFactory.eINSTANCE.createRealLiteralExp();
		lit.setValue(realSymbol.doubleValue());
		return lit;
	}

	public static TupleLiteralExp newTupleLiteral() {
		TupleLiteralExp exp = OclFactory.eINSTANCE.createTupleLiteralExp();
		return exp;
	}
	
	@NonNull
	public static OclDerivedProperty newOclDerivedProperty(@NonNull EFType ctx, @NonNull String name, @NonNull TypeRef type, @NonNull OclExpression body) {
		OclDerivedProperty p = OclFactory.eINSTANCE.createOclDerivedProperty();
		p.setName(name);
		p.setContext(ctx);
		p.setType(type);
		p.setBody(body);
		return p;
	}

	@NonNull
	public static OclOperation newOclOperation(@NonNull EFClass ctx, @NonNull String name, @NonNull List<? extends Parameter> parameters, @NonNull TypeRef type, @NonNull OclExpression body) {
		OclOperation op = OclFactory.eINSTANCE.createOclOperation();
		op.setName(name);
		op.setContext(ctx);
		op.setType(type);
		op.setBody(body);
		op.getParameters().addAll(parameters);
		return op;
	}

	@NonNull
	public static OclExpression newOclUndefined() {
		OclUndefined undefined = OclFactory.eINSTANCE.createOclUndefined();
		return undefined;
	}
	

	@NonNull
	public static OclExpression newOclInvalid() {
		OclInvalid invalid = OclFactory.eINSTANCE.createOclInvalid();
		return invalid;
	}

	@NonNull
	public static OclExpression newEnumLiteral(@NonNull MetaTypeRef eft, @NonNull EFEnumLiteral literal) {
		EnumLiteralExp lit = OclFactory.eINSTANCE.createEnumLiteralExp();
		lit.setEnum_(eft);
		lit.setLiteral(literal);
		return lit;
	}
	
	@NonNull
	public static TypeRef newMetaTypeRef(@NonNull EFType type) {
		MetaTypeRef ref = EfinderFactory.eINSTANCE.createMetaTypeRef();
		ref.setType(type);
		return ref;
	}

	@NonNull
	public static TypeRef newInvalidTypeRef() {
		return EfinderFactory.eINSTANCE.createInvalidTypeRef();
	}
	
	@NonNull 
	public static TypeRef newSequenceTypeRef(@NonNull TypeRef elementType) {
		SequenceTypeRef ref = EfinderFactory.eINSTANCE.createSequenceTypeRef();
		ref.setContainedType(elementType);
		return ref;		
	}

	@NonNull 
	public static TypeRef newSetTypeRef(@NonNull TypeRef elementType) {
		SetTypeRef ref = EfinderFactory.eINSTANCE.createSetTypeRef();
		ref.setContainedType(elementType);
		return ref;		
	}

	@NonNull 
	public static TypeRef newOrderedSetTypeRef(@NonNull TypeRef elementType) {
		OrderedSetTypeRef ref = EfinderFactory.eINSTANCE.createOrderedSetTypeRef();
		ref.setContainedType(elementType);
		return ref;		
	}

	@NonNull 
	public static TypeRef newBagTypeRef(@NonNull TypeRef elementType) {
		BagTypeRef ref = EfinderFactory.eINSTANCE.createBagTypeRef();
		ref.setContainedType(elementType);
		return ref;		
	}

	@NonNull
	public static OclExpression newSetLiteral(@NonNull List<? extends OclExpression> parts) {
		SetLiteralExp exp = OclFactory.eINSTANCE.createSetLiteralExp();
		exp.getParts().addAll(parts);
		return exp;
	}

	@NonNull
	public static OclExpression newOrderedSetLiteral(@NonNull List<? extends OclExpression> parts) {
		OrderedSetLiteralExp exp = OclFactory.eINSTANCE.createOrderedSetLiteralExp();
		exp.getParts().addAll(parts);
		return exp;
	}
	
	@NonNull
	public static OclExpression newBagLiteral(@NonNull List<? extends OclExpression> parts) {
		BagLiteralExp exp = OclFactory.eINSTANCE.createBagLiteralExp();
		exp.getParts().addAll(parts);
		return exp;
	}
	
	@NonNull
	public static OclExpression newSequenceLiteral(@NonNull List<? extends OclExpression> parts) {
		SequenceLiteralExp exp = OclFactory.eINSTANCE.createSequenceLiteralExp();
		exp.getParts().addAll(parts);
		return exp;
	}

	@NonNull
	public static OclExpression newUnsupportedExp(@NonNull String description, @NonNull String reason) {
		UnsupportedExp exp = OclFactory.eINSTANCE.createUnsupportedExp();
		exp.setDescription(description);
		exp.setReason(reason);
		return exp;
	}

	@NonNull
	public static OperationFeatureRef newDefinedOperationRef(@NonNull OclOperation operation) {
		DefinedOperationRef ref = EfinderFactory.eINSTANCE.createDefinedOperationRef();
		ref.setOperation(operation);
		return ref;
	}

}
