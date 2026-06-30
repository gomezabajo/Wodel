package efinder.core;

import java.util.HashMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.annotation.NonNull;

import com.google.common.base.Preconditions;

public interface IBoundsProvider {

	Interval getScope(EClass klass);
	Interval getScope(EReference feature);
	int getDefaultMaxScope();
	
	@NonNull
	default RealInterval getRealInterval() {
		return new RealInterval(-1.0, 1.0, 0.1);
	}
	
	public static class RealInterval {
		private double min;
		private double max;
		private double step;

		public RealInterval(double min, double max, double step) {
			Preconditions.checkArgument(min < max);
			this.min = min;
			this.max = max;
			this.step = step;
		}
		
		public double getMin() {
			return min;
		}
		
		public double getMax() {
			return max;
		}
		
		public double getStep() {
			return step;
		}		
	}
	
	public static class Interval {
		private int min;
		private int max;
		public Interval(int min, int max) {
			this.min = min;
			this.max = max;
		}
		
		public int getMin() { return min; }
		public int getMax() { return max; }
	}

	boolean incrementScope();
	
	// void setMetamodelRewrite(IMetamodelRewrite rewrite);

	public static final IBoundsProvider FIXED = new Fixed(5, 20);
	
	public static class Fixed implements IBoundsProvider {

		private int maxObjects;
		private int maxReferences;

		public Fixed(int maxObjects, int maxReferences) {
			this.maxObjects = maxObjects;
			this.maxReferences = maxReferences;
		}
		
		@Override
		public Interval getScope(EClass klass) {
			return new Interval(0, maxObjects);
		}

		@Override
		public Interval getScope(EReference feature) {
			return new Interval(0, maxReferences);
		}

		@Override
		public int getDefaultMaxScope() {
			return 5;
		}

		@Override
		public boolean incrementScope() {
			return false;
		}	
	}
	
	public static class PerElement implements IBoundsProvider {

        private HashMap<EClassifier, Interval> bounds = new HashMap<>();

        public void addBound(EClassifier c, int min, int max) {
                this.bounds.put(c, new Interval(min, max));
        }
        
        @Override
        public Interval getScope(EClass klass) {
        	Interval interval = getBounds(klass);
        	if ( interval != null ) {
        		return interval;
            }
            return new Interval(1, 5);
        }

        private Interval getBounds(EClass klass) {
        	return bounds.get(klass);
        }

        @Override
        public Interval getScope(EReference feature) {
        	return new Interval(1, 10);
        }

        @Override
        public int getDefaultMaxScope() {
        	return 5;
        }

        @Override
        public boolean incrementScope() {
        	return false;
        }
	}
        
}
