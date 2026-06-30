package tinytools.metamodel.extender;

import java.util.HashMap;

public class ExtenderOptions {

	private String classPrefix = "";
	private String classPostfix = "";
	private String pkgURI = "http://extension";
	
	public String getClassPrefix() {
		return classPrefix;
	}
	
	public String getClassPostfix() {
		return classPostfix;
	}
	
	public void setClassPostfix(String classPostfix) {
		this.classPostfix = classPostfix;
	}
	
	public void setClassPrefix(String classPrefix) {
		this.classPrefix = classPrefix;
	}
	
	public String getPkgURI() {
		return pkgURI;
	}
	public void setPkgURI(String pkgURI) {
		this.pkgURI = pkgURI;
	}

	
	private HashMap<String, String> pkgMapping = new HashMap<String, String>();
	public void addPackageMapping(String string, String string2) {
		pkgMapping.put(string, string2);
	}
	
	public String getPackageName(String pkgName) {
		String name = pkgMapping.get(pkgName);
		if ( name == null ) {
			return pkgName;
		}
		return name;
	}
	
}
