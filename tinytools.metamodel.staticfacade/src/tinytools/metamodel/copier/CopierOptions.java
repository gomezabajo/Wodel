package tinytools.metamodel.copier;

public class CopierOptions {
	private String baseDir;
	private String root;
	private String packagePrefix;
	private String copierClass = "Copier";
	private CopierMatcher matcher = new CopierMatcher.Equality();
	
	public String getBaseDir() {
		return baseDir;
	}

	public void setBaseDir(String baseDir) {
		this.baseDir = baseDir;
	}

	public void setRoot(String root) {
		this.root = root;
	}
	
	public String getRoot() {
		return root;
	}

	public void setPackagePrefix(String string) {
		this.packagePrefix = string;
	}
	
	public String getPackagePrefix() {
		return packagePrefix;
	}

	public String getCopierClass() {
		return copierClass ;
	}
	
	public void setCopierClass(String copierClass) {
		this.copierClass = copierClass;
	}

	public void setMatcher(CopierMatcher matcher) {
		this.matcher = matcher;
	}
	
	public CopierMatcher getMatcher() {
		return matcher;
	}
	
}
