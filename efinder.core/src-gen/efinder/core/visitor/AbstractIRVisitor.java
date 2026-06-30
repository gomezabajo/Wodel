package efinder.core.visitor;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

@SuppressWarnings("unchecked")
public abstract class AbstractIRVisitor<O, I>  {
	
	public O visitEnumLiteralExp(efinder.ir.ocl.EnumLiteralExp self, I input) { return defaultHandler(self, input); }
	public O visitBooleanLiteralExp(efinder.ir.ocl.BooleanLiteralExp self, I input) { return defaultHandler(self, input); }
	public O visitSequenceTypeRef(efinder.ir.SequenceTypeRef self, I input) { return defaultHandler(self, input); }
	public O visitTupleLiteralExp(efinder.ir.ocl.TupleLiteralExp self, I input) { return defaultHandler(self, input); }
	public O visitDefinedOperationRef(efinder.ir.DefinedOperationRef self, I input) { return defaultHandler(self, input); }
	public O visitTypeRef(efinder.ir.TypeRef self, I input) { return defaultHandler(self, input); }
	public O visitTuplePart(efinder.ir.ocl.TuplePart self, I input) { return defaultHandler(self, input); }
	public O visitEFTupleType(efinder.ir.EFTupleType self, I input) { return defaultHandler(self, input); }
	public O visitStringLiteralExp(efinder.ir.ocl.StringLiteralExp self, I input) { return defaultHandler(self, input); }
	public O visitOclExpression(efinder.ir.ocl.OclExpression self, I input) { return defaultHandler(self, input); }
	public O visitFeatureRef(efinder.ir.FeatureRef self, I input) { return defaultHandler(self, input); }
	public O visitIteratorExp(efinder.ir.ocl.IteratorExp self, I input) { return defaultHandler(self, input); }
	public O visitTupleTypeElement(efinder.ir.TupleTypeElement self, I input) { return defaultHandler(self, input); }
	public O visitOperationCallExp(efinder.ir.ocl.OperationCallExp self, I input) { return defaultHandler(self, input); }
	public O visitOclInvalid(efinder.ir.ocl.OclInvalid self, I input) { return defaultHandler(self, input); }
	public O visitAbstractFunction(efinder.ir.AbstractFunction self, I input) { return defaultHandler(self, input); }
	public O visitSpecification(efinder.ir.Specification self, I input) { return defaultHandler(self, input); }
	public O visitIntegerLiteralExp(efinder.ir.ocl.IntegerLiteralExp self, I input) { return defaultHandler(self, input); }
	public O visitOclDerivedProperty(efinder.ir.ocl.OclDerivedProperty self, I input) { return defaultHandler(self, input); }
	public O visitOperation(efinder.ir.Operation self, I input) { return defaultHandler(self, input); }
	public O visitRealLiteralExp(efinder.ir.ocl.RealLiteralExp self, I input) { return defaultHandler(self, input); }
	public O visitParameter(efinder.ir.Parameter self, I input) { return defaultHandler(self, input); }
	public O visitDerivedPropertyRef(efinder.ir.DerivedPropertyRef self, I input) { return defaultHandler(self, input); }
	public O visitInvalidTypeRef(efinder.ir.InvalidTypeRef self, I input) { return defaultHandler(self, input); }
	public O visitCollectionCallExp(efinder.ir.ocl.CollectionCallExp self, I input) { return defaultHandler(self, input); }
	public O visitOclInvariant(efinder.ir.ocl.OclInvariant self, I input) { return defaultHandler(self, input); }
	public O visitOclAnyLibElement(efinder.ir.ocl.OclAnyLibElement self, I input) { return defaultHandler(self, input); }
	public O visitAbstractOperationCallExp(efinder.ir.ocl.AbstractOperationCallExp self, I input) { return defaultHandler(self, input); }
	public O visitCollectionLiteralExp(efinder.ir.ocl.CollectionLiteralExp self, I input) { return defaultHandler(self, input); }
	public O visitTypedElement(efinder.ir.TypedElement self, I input) { return defaultHandler(self, input); }
	public O visitBuiltinPropertyRef(efinder.ir.BuiltinPropertyRef self, I input) { return defaultHandler(self, input); }
	public O visitOperatorCallExp(efinder.ir.ocl.OperatorCallExp self, I input) { return defaultHandler(self, input); }
	public O visitEFClass(efinder.ir.EFClass self, I input) { return defaultHandler(self, input); }
	public O visitConstraint(efinder.ir.Constraint self, I input) { return defaultHandler(self, input); }
	public O visitEFPrimitiveType(efinder.ir.EFPrimitiveType self, I input) { return defaultHandler(self, input); }
	public O visitBagLiteralExp(efinder.ir.ocl.BagLiteralExp self, I input) { return defaultHandler(self, input); }
	public O visitLiteralExp(efinder.ir.ocl.LiteralExp self, I input) { return defaultHandler(self, input); }
	public O visitOclUndefined(efinder.ir.ocl.OclUndefined self, I input) { return defaultHandler(self, input); }
	public O visitDerivedProperty(efinder.ir.DerivedProperty self, I input) { return defaultHandler(self, input); }
	public O visitOrderedSetTypeRef(efinder.ir.OrderedSetTypeRef self, I input) { return defaultHandler(self, input); }
	public O visitPropertyCallExp(efinder.ir.ocl.PropertyCallExp self, I input) { return defaultHandler(self, input); }
	public O visitIfExp(efinder.ir.ocl.IfExp self, I input) { return defaultHandler(self, input); }
	public O visitCallExp(efinder.ir.ocl.CallExp self, I input) { return defaultHandler(self, input); }
	public O visitOclOperation(efinder.ir.ocl.OclOperation self, I input) { return defaultHandler(self, input); }
	public O visitSetTypeRef(efinder.ir.SetTypeRef self, I input) { return defaultHandler(self, input); }
	public O visitEFType(efinder.ir.EFType self, I input) { return defaultHandler(self, input); }
	public O visitTupleFieldRef(efinder.ir.TupleFieldRef self, I input) { return defaultHandler(self, input); }
	public O visitEFPackage(efinder.ir.EFPackage self, I input) { return defaultHandler(self, input); }
	public O visitModelElement(efinder.ir.ocl.ModelElement self, I input) { return defaultHandler(self, input); }
	public O visitSequenceLiteralExp(efinder.ir.ocl.SequenceLiteralExp self, I input) { return defaultHandler(self, input); }
	public O visitOperationFeatureRef(efinder.ir.OperationFeatureRef self, I input) { return defaultHandler(self, input); }
	public O visitBuiltinOperationRef(efinder.ir.BuiltinOperationRef self, I input) { return defaultHandler(self, input); }
	public O visitPropertyFeatureRef(efinder.ir.PropertyFeatureRef self, I input) { return defaultHandler(self, input); }
	public O visitEFEnum(efinder.ir.EFEnum self, I input) { return defaultHandler(self, input); }
	public O visitIterateExp(efinder.ir.ocl.IterateExp self, I input) { return defaultHandler(self, input); }
	public O visitLoopExp(efinder.ir.ocl.LoopExp self, I input) { return defaultHandler(self, input); }
	public O visitSetLiteralExp(efinder.ir.ocl.SetLiteralExp self, I input) { return defaultHandler(self, input); }
	public O visitEFMetamodel(efinder.ir.EFMetamodel self, I input) { return defaultHandler(self, input); }
	public O visitEFEnumLiteral(efinder.ir.EFEnumLiteral self, I input) { return defaultHandler(self, input); }
	public O visitUnsupportedExp(efinder.ir.ocl.UnsupportedExp self, I input) { return defaultHandler(self, input); }
	public O visitIterator(efinder.ir.ocl.Iterator self, I input) { return defaultHandler(self, input); }
	public O visitLetExp(efinder.ir.ocl.LetExp self, I input) { return defaultHandler(self, input); }
	public O visitMetamodelFeatureRef(efinder.ir.MetamodelFeatureRef self, I input) { return defaultHandler(self, input); }
	public O visitWithContextVariable(efinder.ir.ocl.WithContextVariable self, I input) { return defaultHandler(self, input); }
	public O visitVariableDeclaration(efinder.ir.VariableDeclaration self, I input) { return defaultHandler(self, input); }
	public O visitOrderedSetLiteralExp(efinder.ir.ocl.OrderedSetLiteralExp self, I input) { return defaultHandler(self, input); }
	public O visitBagTypeRef(efinder.ir.BagTypeRef self, I input) { return defaultHandler(self, input); }
	public O visitVarExp(efinder.ir.ocl.VarExp self, I input) { return defaultHandler(self, input); }
	public O visitCollectionTypeRef(efinder.ir.CollectionTypeRef self, I input) { return defaultHandler(self, input); }
	public O visitMetaTypeRef(efinder.ir.MetaTypeRef self, I input) { return defaultHandler(self, input); }
		
	protected O visit(EObject obj, I input) {	
	if ( obj.eClass().getName().equals("EnumLiteralExp") ) { return visitEnumLiteralExp((efinder.ir.ocl.EnumLiteralExp) obj, input); }
	if ( obj.eClass().getName().equals("BooleanLiteralExp") ) { return visitBooleanLiteralExp((efinder.ir.ocl.BooleanLiteralExp) obj, input); }
	if ( obj.eClass().getName().equals("SequenceTypeRef") ) { return visitSequenceTypeRef((efinder.ir.SequenceTypeRef) obj, input); }
	if ( obj.eClass().getName().equals("TupleLiteralExp") ) { return visitTupleLiteralExp((efinder.ir.ocl.TupleLiteralExp) obj, input); }
	if ( obj.eClass().getName().equals("DefinedOperationRef") ) { return visitDefinedOperationRef((efinder.ir.DefinedOperationRef) obj, input); }
	if ( obj.eClass().getName().equals("TuplePart") ) { return visitTuplePart((efinder.ir.ocl.TuplePart) obj, input); }
	if ( obj.eClass().getName().equals("EFTupleType") ) { return visitEFTupleType((efinder.ir.EFTupleType) obj, input); }
	if ( obj.eClass().getName().equals("StringLiteralExp") ) { return visitStringLiteralExp((efinder.ir.ocl.StringLiteralExp) obj, input); }
	if ( obj.eClass().getName().equals("IteratorExp") ) { return visitIteratorExp((efinder.ir.ocl.IteratorExp) obj, input); }
	if ( obj.eClass().getName().equals("TupleTypeElement") ) { return visitTupleTypeElement((efinder.ir.TupleTypeElement) obj, input); }
	if ( obj.eClass().getName().equals("OperationCallExp") ) { return visitOperationCallExp((efinder.ir.ocl.OperationCallExp) obj, input); }
	if ( obj.eClass().getName().equals("OclInvalid") ) { return visitOclInvalid((efinder.ir.ocl.OclInvalid) obj, input); }
	if ( obj.eClass().getName().equals("Specification") ) { return visitSpecification((efinder.ir.Specification) obj, input); }
	if ( obj.eClass().getName().equals("IntegerLiteralExp") ) { return visitIntegerLiteralExp((efinder.ir.ocl.IntegerLiteralExp) obj, input); }
	if ( obj.eClass().getName().equals("OclDerivedProperty") ) { return visitOclDerivedProperty((efinder.ir.ocl.OclDerivedProperty) obj, input); }
	if ( obj.eClass().getName().equals("RealLiteralExp") ) { return visitRealLiteralExp((efinder.ir.ocl.RealLiteralExp) obj, input); }
	if ( obj.eClass().getName().equals("Parameter") ) { return visitParameter((efinder.ir.Parameter) obj, input); }
	if ( obj.eClass().getName().equals("DerivedPropertyRef") ) { return visitDerivedPropertyRef((efinder.ir.DerivedPropertyRef) obj, input); }
	if ( obj.eClass().getName().equals("InvalidTypeRef") ) { return visitInvalidTypeRef((efinder.ir.InvalidTypeRef) obj, input); }
	if ( obj.eClass().getName().equals("CollectionCallExp") ) { return visitCollectionCallExp((efinder.ir.ocl.CollectionCallExp) obj, input); }
	if ( obj.eClass().getName().equals("OclInvariant") ) { return visitOclInvariant((efinder.ir.ocl.OclInvariant) obj, input); }
	if ( obj.eClass().getName().equals("OclAnyLibElement") ) { return visitOclAnyLibElement((efinder.ir.ocl.OclAnyLibElement) obj, input); }
	if ( obj.eClass().getName().equals("BuiltinPropertyRef") ) { return visitBuiltinPropertyRef((efinder.ir.BuiltinPropertyRef) obj, input); }
	if ( obj.eClass().getName().equals("OperatorCallExp") ) { return visitOperatorCallExp((efinder.ir.ocl.OperatorCallExp) obj, input); }
	if ( obj.eClass().getName().equals("EFClass") ) { return visitEFClass((efinder.ir.EFClass) obj, input); }
	if ( obj.eClass().getName().equals("EFPrimitiveType") ) { return visitEFPrimitiveType((efinder.ir.EFPrimitiveType) obj, input); }
	if ( obj.eClass().getName().equals("BagLiteralExp") ) { return visitBagLiteralExp((efinder.ir.ocl.BagLiteralExp) obj, input); }
	if ( obj.eClass().getName().equals("OclUndefined") ) { return visitOclUndefined((efinder.ir.ocl.OclUndefined) obj, input); }
	if ( obj.eClass().getName().equals("OrderedSetTypeRef") ) { return visitOrderedSetTypeRef((efinder.ir.OrderedSetTypeRef) obj, input); }
	if ( obj.eClass().getName().equals("PropertyCallExp") ) { return visitPropertyCallExp((efinder.ir.ocl.PropertyCallExp) obj, input); }
	if ( obj.eClass().getName().equals("IfExp") ) { return visitIfExp((efinder.ir.ocl.IfExp) obj, input); }
	if ( obj.eClass().getName().equals("OclOperation") ) { return visitOclOperation((efinder.ir.ocl.OclOperation) obj, input); }
	if ( obj.eClass().getName().equals("SetTypeRef") ) { return visitSetTypeRef((efinder.ir.SetTypeRef) obj, input); }
	if ( obj.eClass().getName().equals("TupleFieldRef") ) { return visitTupleFieldRef((efinder.ir.TupleFieldRef) obj, input); }
	if ( obj.eClass().getName().equals("EFPackage") ) { return visitEFPackage((efinder.ir.EFPackage) obj, input); }
	if ( obj.eClass().getName().equals("ModelElement") ) { return visitModelElement((efinder.ir.ocl.ModelElement) obj, input); }
	if ( obj.eClass().getName().equals("SequenceLiteralExp") ) { return visitSequenceLiteralExp((efinder.ir.ocl.SequenceLiteralExp) obj, input); }
	if ( obj.eClass().getName().equals("BuiltinOperationRef") ) { return visitBuiltinOperationRef((efinder.ir.BuiltinOperationRef) obj, input); }
	if ( obj.eClass().getName().equals("EFEnum") ) { return visitEFEnum((efinder.ir.EFEnum) obj, input); }
	if ( obj.eClass().getName().equals("IterateExp") ) { return visitIterateExp((efinder.ir.ocl.IterateExp) obj, input); }
	if ( obj.eClass().getName().equals("SetLiteralExp") ) { return visitSetLiteralExp((efinder.ir.ocl.SetLiteralExp) obj, input); }
	if ( obj.eClass().getName().equals("EFMetamodel") ) { return visitEFMetamodel((efinder.ir.EFMetamodel) obj, input); }
	if ( obj.eClass().getName().equals("EFEnumLiteral") ) { return visitEFEnumLiteral((efinder.ir.EFEnumLiteral) obj, input); }
	if ( obj.eClass().getName().equals("UnsupportedExp") ) { return visitUnsupportedExp((efinder.ir.ocl.UnsupportedExp) obj, input); }
	if ( obj.eClass().getName().equals("Iterator") ) { return visitIterator((efinder.ir.ocl.Iterator) obj, input); }
	if ( obj.eClass().getName().equals("LetExp") ) { return visitLetExp((efinder.ir.ocl.LetExp) obj, input); }
	if ( obj.eClass().getName().equals("MetamodelFeatureRef") ) { return visitMetamodelFeatureRef((efinder.ir.MetamodelFeatureRef) obj, input); }
	if ( obj.eClass().getName().equals("VariableDeclaration") ) { return visitVariableDeclaration((efinder.ir.VariableDeclaration) obj, input); }
	if ( obj.eClass().getName().equals("OrderedSetLiteralExp") ) { return visitOrderedSetLiteralExp((efinder.ir.ocl.OrderedSetLiteralExp) obj, input); }
	if ( obj.eClass().getName().equals("BagTypeRef") ) { return visitBagTypeRef((efinder.ir.BagTypeRef) obj, input); }
	if ( obj.eClass().getName().equals("VarExp") ) { return visitVarExp((efinder.ir.ocl.VarExp) obj, input); }
	if ( obj.eClass().getName().equals("MetaTypeRef") ) { return visitMetaTypeRef((efinder.ir.MetaTypeRef) obj, input); }
		
		return unknownClassOf(obj, input);

	}
	
	protected O unknownClassOf(EObject obj, I input) {
		throw new IllegalStateException("Cannot handle class: " + obj.eClass().getName());	
	}

	protected O defaultHandler(EObject obj, I input) {
		throw new IllegalStateException("Cannot handle class: " + obj.eClass().getName());	
	}
		
}
