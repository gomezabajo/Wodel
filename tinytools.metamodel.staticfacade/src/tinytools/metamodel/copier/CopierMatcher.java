package tinytools.metamodel.copier;

public interface CopierMatcher {
	public boolean match(String original, String target);
	
	public static class Equality implements CopierMatcher {

		@Override
		public boolean match(String original, String target) {
			return original.equals(target);
		}
		
	}
	
}
