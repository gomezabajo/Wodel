package efinder.usemv.ir;

import org.eclipse.jdt.annotation.NonNull;

import efinder.core.visitor.AbstractIRVisitor;
import efinder.ir.BagTypeRef;
import efinder.ir.EFClass;
import efinder.ir.EFPrimitiveType;
import efinder.ir.MetaTypeRef;
import efinder.ir.OrderedSetTypeRef;
import efinder.ir.SequenceTypeRef;
import efinder.ir.SetTypeRef;
import efinder.ir.TypeRef;

public class UseTypeCompiler extends AbstractIRVisitor<String, Void> {

	private @NonNull UseMapping mapping;

	public UseTypeCompiler(@NonNull UseMapping mapping) {
		this.mapping = mapping;
	}
	
	@NonNull
	public String toTypeText(TypeRef t) {
		return visit(t, null);
	}

	@Override
	public String visitSetTypeRef(SetTypeRef self, Void input) {
		return "Set(" + visit(self.getContainedType(), input) + ")";
	}

	@Override
	public String visitSequenceTypeRef(SequenceTypeRef self, Void input) {
		return "Sequence(" + visit(self.getContainedType(), input) + ")";
	}
	
	@Override
	public String visitOrderedSetTypeRef(OrderedSetTypeRef self, Void input) {
		return "OrderedSet(" + visit(self.getContainedType(), input) + ")";
	}
	
	@Override
	public String visitBagTypeRef(BagTypeRef self, Void input) {
		return "Bag(" + visit(self.getContainedType(), input) + ")";
	}

	@Override
	public String visitMetaTypeRef(MetaTypeRef self, Void input) {
		return visit(self.getType(), input);
	}
	
	@Override
	public String visitEFPrimitiveType(EFPrimitiveType self, Void input) {
		return self.getName();
	}
	
	@Override
	public String visitEFClass(EFClass self, Void input) {
		return mapping.toUseTypeName(self);
	}
	
	
}
