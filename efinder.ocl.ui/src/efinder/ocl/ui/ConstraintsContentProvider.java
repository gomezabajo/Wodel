package efinder.ocl.ui;

import java.util.List;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ocl.xtext.basecs.ConstraintCS;
import org.eclipse.ocl.xtext.completeoclcs.ClassifierContextDeclCS;

public class ConstraintsContentProvider implements IStructuredContentProvider {

	@Override
	public void dispose() { }

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) { }

	@Override
	public Object[] getElements(Object inputElement) {
		if ( inputElement instanceof OclDocumentData ) {
			OclDocumentData doc = (OclDocumentData) inputElement;
			List<InvariantData> invs = doc.getInvariants();
			return invs.toArray(new InvariantData[invs.size()]);
		}
		return new Object[0];
	}
	
	public static class InvariantData {
		private ConstraintCS constraint;
		private boolean selected = true;

		public InvariantData(ConstraintCS c) {
			this.constraint = c;
		}
		
		public ConstraintCS getConstraint() {
			return constraint;
		}
		
		public boolean isSelected() {
			return selected;
		}
		
		public void setSelected(boolean selected) {
			this.selected = selected;
		}

		public String getInvariantName() {
			return constraint.getName();
		}

		public String getClassName() {
			return ((ClassifierContextDeclCS) constraint.eContainer()).getReferredClass().getName();
		}
	}

	
}
