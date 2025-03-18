package anatlyzer.atl.editor.quickfix;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;

import anatlyzer.atl.analyser.AnalysisResult;
import anatlyzer.atl.editor.builder.AnATLyzerBuilder;

public abstract class QuickfixUtil {
	protected boolean checkProblemType(IMarker marker, Class<?> class1) {
		try {
			Object p = marker.getAttribute(AnATLyzerBuilder.PROBLEM); 
			return class1.isInstance( p);
		} catch (CoreException e) {
			return false;
		}
	}
	
	protected AnalysisResult getAnalyserData(IMarker marker) {
		try {
			return (AnalysisResult) marker.getAttribute(AnATLyzerBuilder.ANALYSIS_DATA);
		} catch (CoreException e) {
			throw new RuntimeException(e);
		}		
	}
	
	/**
	 * Given an expression, whose inferred type may be faulty because it 
	 * contains an error, it applies several heuristics to determine a
	 * good type for it.
	 * 
	 * @param expr
	 * @param defaultType
	 * @return
	 */
// Merged with ASTUtils.find
//	public static Type findPossibleTypeOfFaultyExpression(OclExpression expr, Supplier<Type> defaultType) {
//		EObject parent = expr.eContainer();
//		if ( parent instanceof Binding ) {
//			Binding b = (Binding) expr.eContainer();
//			return b.getLeftType();
//		}
//		if ( parent instanceof IteratorExp ) {
//			String it = ((IteratorExp) parent).getName(); 
//			// TODO: Build all of this into the standard library, and provide there
//			//       queries for the quickfixes...
//			if ( it.equals("select") || it.equals("reject") ) {
//				return TypesFactory.eINSTANCE.createBooleanType();
//			}
//		}
//		
//		// Is in a filter
//		if ( ATLUtils.findElement(expr, (obj) -> obj.eContainingFeature() == ATLPackage.Literals.IN_PATTERN__FILTER).isPresent() ) {
//			return TypesFactory.eINSTANCE.createBooleanType();
//		}
//
//		return defaultType.get();
//	}
//
//	public static Type findPossibleTypeOfFaultyExpression(OclExpression expr) {
//		return findPossibleTypeOfFaultyExpression(expr, () -> TypesFactory.eINSTANCE.createUnknown());
//	}

}
