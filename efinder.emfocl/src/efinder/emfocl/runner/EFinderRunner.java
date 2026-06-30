package efinder.emfocl.runner;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Model;

import com.google.common.base.Preconditions;

import efinder.core.EFinderModel;
import efinder.core.IDialectAdaptation;
import efinder.core.IModelFinder;
import efinder.core.IModelFinder.Result;
import efinder.core.IModelFinder.Status;
import efinder.core.errors.UnsupportedTranslationException;
import efinder.core.footprint.IFootprint;
import efinder.core.footprint.ISlicingStrategy;
import efinder.core.management.EMFModel;
import efinder.core.transform.TupleToClassTransform;
import efinder.core.transform.UnfoldRecursionTransform;
import efinder.emfocl.PivotOclCompiler;
import efinder.emfocl.use.EMFOCL2UseFixer;

public class EFinderRunner {

	private final @NonNull Model pivot;
	private @NonNull IModelFinder finder;
	private final @NonNull TransformRegistry registry = new TransformRegistry();
	
	@NonNull 
	private ISlicingStrategy slicingStrategy = new ISlicingStrategy.NoSlice();
	
	public EFinderRunner(@NonNull Model pivot) {
		this.pivot = pivot;
		// Configuration:
		registry.add("use", new EMFOCL2UseFixer());
		registry.add("use", new TupleToClassTransform());
		registry.add("use", new UnfoldRecursionTransform());		
	}
	
	public EFinderRunner withSlicingStrategy(@NonNull ISlicingStrategy strategy) {
		this.slicingStrategy = strategy;
		return this;
	}
	
	@NonNull
	public static EFinderRunner withOclModel(@NonNull Model pivot) {
		return new EFinderRunner(pivot);
	}
	
	@NonNull
	public EFinderRunner withFinder(@NonNull IModelFinder finder) {
		this.finder = finder;
		return this;
	}

	@NonNull 
	public Result find() {
		EFinderModel ir;
		try {
			PivotOclCompiler compiler = new PivotOclCompiler(pivot);
			ir = compiler.compile();	
		} catch (UnsupportedTranslationException e) {
			return new UnsupportedTranslationResult(e.getReason());
		}
		
		// TODO: Set the bounds and different configuration options in Finder
		Preconditions.checkState(this.finder != null);
		
		List<? extends IDialectAdaptation> transforms = registry.get(finder.backendId());
		for (IDialectAdaptation adaptation : transforms) {
			adaptation.transform(ir);
		}
		
		IFootprint footprint = slicingStrategy.getFootprint(ir);		
		return finder.find(ir, footprint);
	}
	
	public static class UnsupportedTranslationResult implements Result {

		@NonNull
		private String reason;

		public UnsupportedTranslationResult(@NonNull String reason) {
			this.reason = reason;
		}
		
		@NonNull
		public String getReason() {
			return reason;
		}

		@Override
		public @NonNull Status getStatus() {
			return Status.UNSUPPORTED_FEATURE;
		}

		@Override
		public @NonNull EMFModel getWitness() {
			throw new UnsupportedOperationException();
		}
		
	}
	
}
