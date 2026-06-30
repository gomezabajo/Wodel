package efinder.usemv;

import java.util.Iterator;
import java.util.function.Supplier;

import org.eclipse.jdt.annotation.NonNull;

import com.google.common.base.Preconditions;

import efinder.core.IModelFinder.Result;
import efinder.core.IModelFinder.ScrollingResult;
import efinder.core.IModelFinder.Status;
import efinder.core.errors.Report;
import efinder.core.management.EMFModel;
import efinder.usemv.UseMvFinder.KodkodResult;

public abstract class UseMvResult implements Result {

	public static class Scrolling extends UseMvResult implements ScrollingResult {

		private KodkodResult result;
		private Supplier<EMFModel> modelSupplier;

		public Scrolling(KodkodResult kodkod, Supplier<EMFModel> modelSupplier) {
			this.result = kodkod;
			this.modelSupplier = modelSupplier;
		}

		@Override
		public @NonNull Status getStatus() {
			if (result.isSatisfiable()) {
				return Status.SAT;
			}
			
			return Status.UNSAT;
		}
		
		@Override
		public @NonNull EMFModel getWitness() {
			Preconditions.checkState(result.isSatisfiable());
			return modelSupplier.get();
		}

		@Override
		public Iterator<EMFModel> iterator() {
			return new Iterator<EMFModel>() {
				@Override
				public boolean hasNext() {
					return result.isSatisfiable();
				}

				@Override
				public EMFModel next() {
					EMFModel r = getWitness();
					result.nextSolution();
					return r;
				}				
			};
		}

	}


	public static class SAT extends UseMvResult {
		
		@NonNull
		private EMFModel witness;

		public SAT(@NonNull EMFModel witness) {
			this.witness = witness;
		}

		@Override
		public @NonNull Status getStatus() {
			return Status.SAT;
		}		
		
		@Override
		public EMFModel getWitness() {
			return witness;
		}
		
	}


	public static class UNSAT extends UseMvResult {

		@Override
		public @NonNull Status getStatus() {
			return Status.UNSAT;
		}

		@Override
		public EMFModel getWitness() {
			throw new IllegalStateException();
		}

	}
	
	public static class Unsupported extends UseMvResult {

		private Report report;

		public Unsupported(@NonNull Report report) {
			this.report = report;
		}
		
		@Override
		public @NonNull Status getStatus() {
			return Status.UNSUPPORTED_FEATURE;
		}

		@Override
		public @NonNull EMFModel getWitness() {
			throw new IllegalStateException();
		}
		
		@NonNull
		public Report getReport() {
			return report;
		}
	}

	public static class UnsupportedTranslation extends UseMvResult {

		private @NonNull String useErrors;

		public UnsupportedTranslation(@NonNull String useErrors) {
			this.useErrors = useErrors;
		}
		
		@Override
		public @NonNull Status getStatus() {
			return Status.INVALID_TRANSLATION;
		}

		@Override
		public @NonNull EMFModel getWitness() {
			throw new IllegalStateException();
		}

		@NonNull
		public String getUseErrors() {
			return useErrors;
		}
		
	}
	
	
}
