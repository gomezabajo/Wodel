package manager;

public interface IHashingStrategy {
	
	IHashingStrategy DEFAULT = new IHashingStrategy() {

		@Override
		public boolean equals(Object a, Object b) {
			return a.equals(b);
		}

		@Override
		public int hashCode(Object o) {
			return o.hashCode();
		}
		
	};
	
	int hashCode(Object o);
	
	// A is likely to be not null
	boolean equals(Object a, Object b);
}