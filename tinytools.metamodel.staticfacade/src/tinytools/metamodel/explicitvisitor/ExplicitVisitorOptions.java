package tinytools.metamodel.explicitvisitor;

import org.eclipse.emf.ecore.resource.Resource;

public class ExplicitVisitorOptions {
	private String baseDir;
	private String packagePrefix;
	private String visitorClass = "AbstractVisitor";
	private String baseClass;
	private Resource baseMetamodel;

	public String getBaseDir() {
		return baseDir;
	}

	public void setBaseDir(String baseDir) {
		this.baseDir = baseDir;
	}

	public void setPackagePrefix(String string) {
		this.packagePrefix = string;
	}
	
	public String getPackagePrefix() {
		return packagePrefix;
	}

	public String getVisitorClass() {
		return visitorClass ;
	}
	
	public void setVisitorClass(String visitorClass) {
		this.visitorClass = visitorClass;
	}

	public void setQualifiedBaseClass(String qualifiedClassName) {
		this.baseClass = qualifiedClassName;
		
	}
	
	public String getQualifiedBaseClass() {
		return baseClass;
	}

	public void setBaseMetamodel(Resource r) {
		this.baseMetamodel = r;		
	}
	
	public Resource getBaseMetamodel() {
		return baseMetamodel;
	}

}
