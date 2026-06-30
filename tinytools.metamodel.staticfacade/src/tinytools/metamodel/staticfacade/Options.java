package tinytools.metamodel.staticfacade;

public class Options {
	private String baseDir;
	private String packagePrefix;
	private String managerClass = "Manager";
	private boolean visitable;

	public String getBaseDir() {
		return baseDir;
	}

	public String getPackagePrefix() {
		return packagePrefix;
	}

	public void setBaseDir(String baseDir) {
		this.baseDir = baseDir;
	}

	public void setPackagePrefix(String packagePrefix) {
		this.packagePrefix = packagePrefix;
	}

	public void setManagerClass(String name) {
		this.managerClass  = name;
	}
	
	public String getManagerClass() {
		return managerClass;
	}
	
	public void setVisitable(boolean visitable) {
		this.visitable = true;
	}
	
	public boolean isVisitable() {
		return visitable;
	}
	
	
}
