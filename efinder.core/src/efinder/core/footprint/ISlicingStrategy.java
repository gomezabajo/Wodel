package efinder.core.footprint;

import org.eclipse.jdt.annotation.NonNull;

import efinder.core.EFinderModel;

public interface ISlicingStrategy {

	@NonNull
	IFootprint getFootprint(@NonNull EFinderModel model);

	public class NoSlice implements ISlicingStrategy {

		@Override
		public @NonNull IFootprint getFootprint(@NonNull EFinderModel model) {			
			return IFootprint.NULL_FOOTPRINT;
		}

	}

}
