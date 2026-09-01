package wodel.synthesizer.generator;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import wodel.utils.manager.ModelManager;
import wodel.utils.manager.UseGeneratorUtils;
import mutatorenvironment.ListStringType;
import mutatorenvironment.SpecificStringType;
import mutatorenvironment.MutatorenvironmentPackage;

/**
 * @author Pablo Gomez-Abajo
 * 
 * USEUtils
 * 
 * Utils for the seed models synthesis
 * using USE model validator
 * 
 */
public class USEUtils {

	/**
	 * Decodes USE className: packageName + "XxxX" + className
	 * @param className
	 * @return
	 */
	public static String[] decodeClassName(String className) {
		if (className == null || className.isEmpty()) {
			return new String[0];
		}
		String decodedClassName = UseGeneratorUtils.decodeWord(className);
		return decodedClassName.split("XxxX", -1);
	}
	
	/**
	 * Gets the meta-model URI from given XMI
	 * @param xmiURI
	 * @param classNames
	 * @return
	 */
	private static URI getMetaModelURIFromXMI(URI xmiURI, Map<URI, String> classNames) {
		if (xmiURI == null || classNames == null || classNames.isEmpty()) {
			return null;
		}
		String uriValue = xmiURI.toString();
		int fragment = uriValue.indexOf('#');
		if (fragment < 0) {
			return classNames.containsKey(xmiURI) ? xmiURI : null;
		}
		uriValue = uriValue.substring(fragment);
		for (URI uri : classNames.keySet()) {
			if (uri != null && uri.toString().endsWith(uriValue)) {
				return uri;
			}
		}
		return null;
	}
	
	/**
	 * Gets USE string name
	 * @param o
	 * @return
	 */
	private static String escapeUseString(String value) {
		return value == null ? "" : value.replace("'", "''");
	}

	private static String getStringName(Object o) {
		if (o instanceof String || o instanceof Character) {
			return "'" + escapeUseString(String.valueOf(o)) + "'";
		}
		return "";
	}
	
	/**
	 * Completes the necesary parentheses for the given constraint
	 * @param constraint
	 * @return
	 */
	private static String completeParentheses(String constraint) {
		if (constraint == null || constraint.isEmpty()) {
			return constraint;
		}
		int count = 0;
		boolean inString = false;
		for (int i = 0; i < constraint.length(); i++) {
			char c = constraint.charAt(i);
			if (c == '\'') {
				if (inString && i + 1 < constraint.length() && constraint.charAt(i + 1) == '\'') {
					i++; // OCL/USE escaped apostrophe ('')
					continue;
				}
				inString = !inString;
				continue;
			}
			if (inString) continue;
			if (c == '(') {
				count++;
			} else if (c == ')') {
				if (--count < 0) {
					throw new IllegalArgumentException("Unbalanced OCL/USE expression: " + constraint);
				}
			}
		}
		if (inString) {
			throw new IllegalArgumentException("Unterminated OCL/USE string literal: " + constraint);
		}
		StringBuilder completed = new StringBuilder(constraint);
		while (count-- > 0) completed.append(')');
		return completed.toString();
	}
	
	/**
	 * Process object names
	 * @param object
	 * @param eObjectNamesHashMap
	 * @param addComma
	 * @return
	 */
	private static String processObjectNames(Object object, HashMap<EObject, String> eObjectNamesHashMap, boolean addComma) {
		String oclNames = "";
		if (object instanceof List<?>) {
			List<EObject> eObjects = (List<EObject>) object;
			if (eObjects.size() > 1) {
				for (EObject eObject : eObjects.subList(0, eObjects.size() - 1)) {
					List<EReference> references = eObject.eClass().getEAllReferences();
					for (EReference ref : references) {
						if (ref.isContainment() == true) {
							String processed = processObjectNames(eObject.eGet(ref), eObjectNamesHashMap, addComma);
							if (processed.length() > 0) {
								if (addComma == true && oclNames.length() > 0) {
									oclNames += ", ";
									addComma = false;
								}
								oclNames += processed; 
								addComma = true;
							}
						}
					}
					List<EAttribute> attributes = eObject.eClass().getEAllAttributes();
					if (attributes.size() > 1) {
						for (EAttribute att : attributes.subList(0, attributes.size() - 1)) {
							String processed = getStringName(eObject.eGet(att));
							if (processed.length() > 0) {
								if (addComma == true && oclNames.length() > 0) {
									oclNames += ", ";
									addComma = false;
								}
								oclNames += processed;
								addComma = true;
							}
						}
					}
					if (attributes.size() == 1) {
						EAttribute att = attributes.get(0);
						String processed = getStringName(eObject.eGet(att));
						if (processed.length() > 0) {
							if (addComma == true && oclNames.length() > 0) {
								oclNames += ", ";
								addComma = false;
							}
							oclNames += processed; 
							addComma = true;
						}
					}
					else if (attributes.size() > 0) {
						EAttribute att = attributes.get(attributes.size() - 1);
						String processed = getStringName(eObject.eGet(att));
						if (processed.length() > 0) {
							if (addComma == true && oclNames.length() > 0) {
								oclNames += ", ";
							}
							oclNames += processed;
						}
					}
				}
			}
			if (eObjects.size() == 1) {
				EObject eObject = eObjects.get(0);
				List<EReference> references = eObject.eClass().getEAllReferences();
				for (EReference ref : references) {
					if (ref.isContainment() == true) {
						String processed = processObjectNames(eObject.eGet(ref), eObjectNamesHashMap, addComma);
						if (processed.length() > 0) {
							if (addComma == true && oclNames.length() > 0) {
								oclNames += ", ";
								addComma = false;
							}
							oclNames += processed; 
							addComma = true;
						}
					}
				}
				List<EAttribute> attributes = eObject.eClass().getEAllAttributes();
				if (attributes.size() > 1) {
					for (EAttribute att : attributes.subList(0, attributes.size() - 1)) {
						String processed = getStringName(eObject.eGet(att));
						if (processed.length() > 0) {
							if (addComma == true && oclNames.length() > 0) {
								oclNames += ", ";
								addComma = false;
							}
							oclNames += processed;
							addComma = true;
						}
					}
				}
				if (attributes.size() == 1) {
					EAttribute att = attributes.get(0);
					String processed = getStringName(eObject.eGet(att));
					if (processed.length() > 0) {
						if (addComma == true && oclNames.length() > 0) {
							oclNames += ", ";
							addComma = false;
						}
						oclNames += processed;
						addComma = true;
					}
				}
				else if (attributes.size() > 0) {
					EAttribute att = attributes.get(attributes.size() - 1);
					String processed = getStringName(eObject.eGet(att));
					if (processed.length() > 0) {
						if (addComma == true && oclNames.length() > 0) {
							oclNames += ", ";
						}
						oclNames += processed;
					}
				}
			}
			else if (eObjects.size() > 0) {
				EObject eObject = eObjects.get(eObjects.size() - 1);
				List<EReference> references = eObject.eClass().getEAllReferences();
				for (EReference ref : references) {
					if (ref.isContainment() == true) {
						String processed = processObjectNames(eObject.eGet(ref), eObjectNamesHashMap, addComma);
						if (processed.length() > 0) {
							if (addComma == true && oclNames.length() > 0) {
								oclNames += ", ";
								addComma = false;
							}
							oclNames += processed; 
							addComma = true;
						}
					}
				}
				List<EAttribute> attributes = eObject.eClass().getEAllAttributes();
				if (attributes.size() > 1) {
					for (EAttribute att : attributes.subList(0, attributes.size() - 1)) {
						String processed = getStringName(eObject.eGet(att));
						if (processed.length() > 0) {
							if (addComma == true && oclNames.length() > 0) {
								oclNames += ", ";
							}
							oclNames += processed;
						}
					}
				}
				if (attributes.size() == 1) {
					EAttribute att = attributes.get(0);
					String processed = getStringName(eObject.eGet(att));
					if (processed.length() > 0) {
						if (addComma == true && oclNames.length() > 0) {
							oclNames += ", ";
							addComma = false;
						}
						oclNames += processed;
						addComma = true;
					}
				}
				else if (attributes.size() > 0) {
					EAttribute att = attributes.get(attributes.size() - 1);
					String processed = getStringName(eObject.eGet(att));
					if (processed.length() > 0) {
						if (addComma == true && oclNames.length() > 0) {
							oclNames += ", ";
						}
						oclNames += processed;
					}
				}
			}
		}
		if (object instanceof EObject) {
			EObject eObject = (EObject) object;
			List<EReference> references = eObject.eClass().getEAllReferences();
			for (EReference ref : references) {
				if (ref.isContainment() == true) {
					String processed = processObjectNames(eObject.eGet(ref), eObjectNamesHashMap, addComma);
					if (processed.length() > 0) {
						if (addComma == true && oclNames.length() > 0) {
							oclNames += ", ";
							addComma = false;
						}
						oclNames += processed; 
						addComma = true;
					}
				}
			}
			List<EAttribute> attributes = eObject.eClass().getEAllAttributes();
			if (attributes.size() > 1) {
				for (EAttribute att : attributes.subList(0, attributes.size() - 1)) {
					String processed = getStringName(eObject.eGet(att));
					if (processed.length() > 0) {
						if (addComma == true && oclNames.length() > 0) {
							oclNames += ", ";
							addComma = false;
						}
						oclNames += processed;
						addComma = true;
					}
				}
			}
			if (attributes.size() == 1) {
				EAttribute att = attributes.get(0);
				String processed = getStringName(eObject.eGet(att));
				if (processed.length() > 0) {
					if (addComma == true && oclNames.length() > 0) {
						oclNames += ", ";
						addComma = false;
					}
					oclNames += processed;
					addComma = true;
				}
			}
			else if (attributes.size() > 0) {
				EAttribute att = attributes.get(attributes.size() - 1);
				String processed = getStringName(eObject.eGet(att));
				if (processed.length() > 0) {
					if (addComma == true && oclNames.length() > 0) {
						oclNames += ", ";
					}
					oclNames += processed;
				}
			}
		}
		return oclNames;
	}

	/**
	 * Process objects names
	 * @param object
	 * @param varNamesHashMap
	 * @param eObjectNamesHashMap
	 * @param classNames
	 */
	private static void processObjectNames(Object object, HashMap<String, Integer> varNamesHashMap, HashMap<EObject, String> eObjectNamesHashMap, HashMap<URI, String> classNames) {
		if (object instanceof List<?>) {
			List<EObject> eObjects = (List<EObject>) object;
			List<String> varNames = new ArrayList<String>();
			for (EObject eObject : eObjects) {
				String className = eObject.eClass().getName();
				String varName = className.substring(0, 1).toLowerCase();
				int index = 0;
				if (varNamesHashMap.get(varName) != null) {
					index = varNamesHashMap.get(varName) + 1;
				}
				varNamesHashMap.put(varName, index);
				varName += index;
				varNames.add(varName);
				eObjectNamesHashMap.put(eObject, varName);
			}
			for (EObject eObject : eObjects) {
				List<EReference> references = eObject.eClass().getEAllReferences();
				for (EReference ref : references) {
					if (ref.isContainment() == true) {
						processObjectNames(eObject.eGet(ref), varNamesHashMap, eObjectNamesHashMap, classNames);
					}
				}
			}
		}
		if (object instanceof EObject) {
			EObject eObject = (EObject) object;
			String className = eObject.eClass().getName();
			String varName = className.substring(0, 1).toLowerCase();
			int index = 0;
			if (varNamesHashMap.get(varName) != null) {
				index = varNamesHashMap.get(varName) + 1;
			}
			varNamesHashMap.put(varName, index);
			varName += index;
			eObjectNamesHashMap.put(eObject, varName);
			List<EReference> references = eObject.eClass().getEAllReferences();
			for (EReference ref : references) {
				if (ref.isContainment() == true) {
					processObjectNames(eObject.eGet(ref), varNamesHashMap, eObjectNamesHashMap, classNames);
				}
			}
		}
	}
	
	/**
	 * Gets tar USE reference name
	 * @param eClass
	 * @param ref
	 * @param classNames
	 * @param useReferences
	 * @return
	 */
	private static String getTarUseReferenceName(EClass eClass, EReference ref, HashMap<URI, String> classNames, HashMap<URI, HashMap<URI, Entry<String, String>>> useReferences) {
		String useReferenceName = ref.getName();
		if (useReferences != null) {
			HashMap<URI, Entry<String, String>> useReference = useReferences.get(getMetaModelURIFromXMI(EcoreUtil.getURI(eClass), classNames));
			if (useReference != null) {
				URI refURI = null;
				String uriValue = EcoreUtil.getURI(ref).toString();
				uriValue = uriValue.substring(uriValue.indexOf("#"), uriValue.length());
				for (URI uri : useReference.keySet()) {
					if (uri.toString().endsWith(uriValue)) {
						refURI = uri;
						break;
					}
				}
				useReferenceName = useReference.get(refURI).getValue();
			}
		}
		return useReferenceName;
	}
	
	/**
	 * Process the containment references
	 * @param object
	 * @param eObjectNamesHashMap
	 * @param classNames
	 * @param useReferences
	 * @return
	 */
	private static String processContainmentReferences(Object object, HashMap<EObject, String> eObjectNamesHashMap, HashMap<URI, String> classNames, HashMap<URI, HashMap<URI, Entry<String, String>>> useReferences) {
		String constraint = "";
		if (object instanceof List<?>) {
			List<EObject> eObjects = (List<EObject>) object;
			List<String> varNames = new ArrayList<String>();
			if (eObjects.size() > 1) {
				for (EObject eObject : eObjects.subList(0, eObjects.size() - 1)) {
					String varName = eObjectNamesHashMap.get(eObject);
					varNames.add(varName);
					constraint += varName + ", ";
				}
			}
			if (eObjects.size() == 1) {
				String varName = eObjectNamesHashMap.get(eObjects.get(0));
				varNames.add(varName);
				constraint += varName;
			}
			else if (eObjects.size() > 0) {
				String varName = eObjectNamesHashMap.get(eObjects.get(eObjects.size() - 1));
				varNames.add(varName);
				constraint += varName;
			}
			if (constraint.length() > 0) {
				constraint += " | ";
			}
			if (eObjects.size() > 1) {
				int index = 0;
				for (EObject eObject : eObjects.subList(0, eObjects.size() - 1)) {
					List<EReference> references = eObject.eClass().getEAllReferences();
					for (EReference ref : references) {
						if (ref.isContainment() == true) {
							String processed = processContainmentReferences(eObject.eGet(ref), eObjectNamesHashMap, classNames, useReferences);
							if (processed.length() > 0) {
								constraint += varNames.get(index) + "." + UseGeneratorUtils.encodeWord(getTarUseReferenceName(eObject.eClass(), ref, classNames, useReferences)) + "->exists(" + processed;
							}
						}
					}
					index++;
				}
			}
			if (eObjects.size() == 1) {
				EObject eObject = eObjects.get(0);
				List<EReference> references = eObject.eClass().getEAllReferences();
				for (EReference ref : references) {
					if (ref.isContainment() == true) {
						String processed = processContainmentReferences(eObject.eGet(ref), eObjectNamesHashMap, classNames, useReferences);
						if (processed.length() > 0) {
							constraint += varNames.get(0) + "." + UseGeneratorUtils.encodeWord(getTarUseReferenceName(eObject.eClass(), ref, classNames, useReferences)) + "->exists(" + processed;
						}
					}
				}
			}
			else if (eObjects.size() > 0) {
				EObject eObject = eObjects.get(eObjects.size() - 1);
				List<EReference> references = eObject.eClass().getEAllReferences();
				for (EReference ref : references) {
					if (ref.isContainment() == true) {
						String processed = processContainmentReferences(eObject.eGet(ref), eObjectNamesHashMap, classNames, useReferences);
						if (processed.length() > 0) {
							constraint += varNames.get(eObjects.size() - 1) + "." + UseGeneratorUtils.encodeWord(getTarUseReferenceName(eObject.eClass(), ref, classNames, useReferences)) + "->exists(" + processed;
						}
					}
				}
			}
		}
		if (object instanceof EObject) {
			EObject eObject = (EObject) object;
			String varName = eObjectNamesHashMap.get(eObject);
			List<EReference> references = eObject.eClass().getEAllReferences();
			constraint = varName + " | ";
			for (EReference ref : references) {
				if (ref.isContainment() == true) {
					String processed = processContainmentReferences(eObject.eGet(ref), eObjectNamesHashMap, classNames, useReferences);
					if (processed.length() > 0) {
						constraint += varName + "." + UseGeneratorUtils.encodeWord(getTarUseReferenceName(eObject.eClass(), ref, classNames, useReferences)) + "->exists(" + processed;
					}
				}
			}
		}
		return constraint;
	}
	
	/**
	 * Gets the maximum index for the given object
	 * @param eObject
	 * @param eObjectNamesHashMap
	 * @return
	 */
	private static int getObjectMaxIndex(EObject eObject, HashMap<EObject, String> eObjectNamesHashMap) {
		 if (eObject == null || eObjectNamesHashMap == null) {
			 return 0;
		 }
		 String className = eObject.eClass().getName();
		 String varName = className.substring(0, 1).toLowerCase();
		 int max = 0;
		 for (String value : eObjectNamesHashMap.values()) {
			 String v = value.substring(0, 1).toLowerCase();
			 if (varName.equals(v)) {
				 int index = Integer.parseInt(value.substring(1, value.length()));
				 if (index > max) {
					 max = index;
				 }
			 }
		 }
		 max++;
		 return max;
	}
	
	/**
	 * Process the object to USE format
	 * @param o
	 * @return
	 */
	private static String processObject(Object o) {
		if (o == null) {
			return "null";
		}
		if (o instanceof Boolean || o instanceof Number) {
			return String.valueOf(o);
		}
		if (o instanceof String || o instanceof Character) {
			return "'" + escapeUseString(String.valueOf(o)) + "'";
		}
		if (o instanceof EEnumLiteral) {
			return Integer.toString(((EEnumLiteral) o).getValue());
		}
		throw new IllegalArgumentException("Unsupported Ecore value for USE serialization: " + o.getClass().getName());
	}
	
	private static String processReferenceValues(String ownerVariable, EReference ref, List<EObject> objects,
			HashMap<EObject, String> eObjectNamesHashMap, HashMap<URI, String> classNames,
			HashMap<URI, HashMap<URI, Entry<String, String>>> useReferences) {
		String role = UseGeneratorUtils.encodeWord(
				getTarUseReferenceName(ref.getEContainingClass(), ref, classNames, useReferences));
		String navigation = ownerVariable + "." + role;
		if (objects == null || objects.isEmpty()) {
			return navigation + "->isEmpty()";
		}
		int index = getObjectMaxIndex(objects.get(0), eObjectNamesHashMap);
		String className = ref.getEType().getName();
		List<String> localNames = new ArrayList<String>();
		StringBuilder result = new StringBuilder(navigation).append("->exists(");
		for (int n = 0; n < objects.size(); n++) {
			String local = className.substring(0, 1).toLowerCase() + index++;
			localNames.add(local);
			if (n < objects.size() - 1) {
				result.append(local).append(", ");
			} else {
				result.append(local).append(" | ");
			}
		}
		for (int n = 0; n < objects.size(); n++) {
			if (n > 0) result.append(" and ");
			String target = eObjectNamesHashMap.get(objects.get(n));
			if (target == null) {
				throw new IllegalStateException("Referenced EObject has no generated USE variable name: " + objects.get(n));
			}
			result.append(localNames.get(n)).append('=').append(target);
		}
		return result.append(')').toString();
	}

	/**
	 * Process the object to USE format
	 * @param object
	 * @param eObjectNamesHashMap
	 * @param classNames
	 * @param useReferences
	 * @param addAnd
	 * @return
	 */
	private static String processObject(Object object, HashMap<EObject, String> eObjectNamesHashMap,  HashMap<URI, String> classNames, HashMap<URI, HashMap<URI, Entry<String, String>>> useReferences, boolean addAnd) {
		String constraint = "";
		if (object instanceof List<?>) {
			List<EObject> eObjects = (List<EObject>) object;
			List<String> varNames = new ArrayList<String>();
			if (eObjects.size() > 1) {
				for (EObject eObject : eObjects.subList(0, eObjects.size() - 1)) {
					String varName = eObjectNamesHashMap.get(eObject);
					varNames.add(varName);
				}
			}
			if (eObjects.size() == 1) {
				String varName = eObjectNamesHashMap.get(eObjects.get(0));
				varNames.add(varName);
			}
			else if (eObjects.size() > 0) {
				String varName = eObjectNamesHashMap.get(eObjects.get(eObjects.size() - 1));
				varNames.add(varName);
			}
			if (eObjects.size() > 1) {
				int index = 0;
				for (EObject eObject : eObjects.subList(0, eObjects.size() - 1)) {
					List<EReference> references = eObject.eClass().getEAllReferences();
					for (EReference ref : references) {
						if (addAnd == true) {
							constraint += " and ";
							addAnd = false;
						}
						if (ref.isContainment() == true) {
							String processed = processObject(eObject.eGet(ref), eObjectNamesHashMap, classNames, useReferences, addAnd);
							if (processed.length() > 0) {
								constraint += processed; 
								addAnd = true;
							}
						}
						if (ref.isContainment() == false) {
							Object o = eObject.eGet(ref);
							if (o == null) {
								constraint += varNames.get(index) + "." + UseGeneratorUtils.encodeWord(getTarUseReferenceName(eObject.eClass(), ref, classNames, useReferences)) + "=null";
								addAnd = true;
							}
							if (o instanceof EObject) {
								EObject obj = (EObject) o;
								constraint += varNames.get(index) + "." + UseGeneratorUtils.encodeWord(getTarUseReferenceName(eObject.eClass(), ref, classNames, useReferences)) + "=" + eObjectNamesHashMap.get(obj);
								addAnd = true;
							}
							if (o instanceof List<?>) {
								List<EObject> objs = (List<EObject>) o;
								constraint += processReferenceValues(varNames.get(index), ref, objs, eObjectNamesHashMap, classNames, useReferences);
								addAnd = true;
							}
						}
					}
					List<EAttribute> attributes = eObject.eClass().getEAllAttributes();
					if (attributes.size() > 1) {
						for (EAttribute att : attributes.subList(0, attributes.size() - 1)) {
							if (addAnd == true) {
								constraint += " and ";
								addAnd = false;
							}
							constraint += varNames.get(index) + "." + UseGeneratorUtils.encodeWord(att.getName()) + "=" + processObject(eObject.eGet(att));
							addAnd = true;
						}
					}
					if (attributes.size() == 1) {
						if (addAnd == true) {
							constraint += " and ";
							addAnd = false;
						}
						EAttribute att = attributes.get(0);
						constraint += varNames.get(index) + "." + UseGeneratorUtils.encodeWord(att.getName()) + "=" + processObject(eObject.eGet(att));
						addAnd = true;
					}
					else if (attributes.size() > 0) {
						if (addAnd == true) {
							constraint += " and ";
						}
						EAttribute att = attributes.get(attributes.size() - 1);
						constraint += varNames.get(index) + "." + UseGeneratorUtils.encodeWord(att.getName()) + "=" + processObject(eObject.eGet(att));
					}
					index++;
				}
			}
			if (eObjects.size() == 1) {
				EObject eObject = eObjects.get(0);
				List<EReference> references = eObject.eClass().getEAllReferences();
				for (EReference ref : references) {
					if (addAnd == true) {
						constraint += " and ";
						addAnd = false;
					}
					if (ref.isContainment() == true) {
						String processed = processObject(eObject.eGet(ref), eObjectNamesHashMap, classNames, useReferences, addAnd);
						if (processed.length() > 0) {
							constraint += processed; 
							addAnd = true;
						}
					}
					if (ref.isContainment() == false) {
						Object o = eObject.eGet(ref);
						if (o == null) {
							constraint += varNames.get(0) + "." + UseGeneratorUtils.encodeWord(getTarUseReferenceName(eObject.eClass(), ref, classNames, useReferences)) + "=null";
							addAnd = true;
						}
						if (o instanceof EObject) {
							EObject obj = (EObject) o;
							constraint += varNames.get(0) + "." + UseGeneratorUtils.encodeWord(getTarUseReferenceName(eObject.eClass(), ref, classNames, useReferences)) + "=" + eObjectNamesHashMap.get(obj);
							addAnd = true;
						}
						if (o instanceof List<?>) {
							List<EObject> objs = (List<EObject>) o;
							constraint += processReferenceValues(varNames.get(0), ref, objs, eObjectNamesHashMap, classNames, useReferences);
							addAnd = true;
						}
					}
				}
				List<EAttribute> attributes = eObject.eClass().getEAllAttributes();
				if (attributes.size() > 1) {
					for (EAttribute att : attributes.subList(0, attributes.size() - 1)) {
						if (addAnd == true) {
							constraint += " and ";
							addAnd = false;
						}
						constraint += varNames.get(0) + "." + UseGeneratorUtils.encodeWord(att.getName()) + "=" + processObject(eObject.eGet(att));
						addAnd = true;
					}
				}
				if (attributes.size() == 1) {
					if (addAnd == true) {
						constraint += " and ";
						addAnd = false;
					}
					EAttribute att = attributes.get(0);
					constraint += varNames.get(0) + "." + UseGeneratorUtils.encodeWord(att.getName()) + "=" + processObject(eObject.eGet(att));
					addAnd = true;
				}
				else if (attributes.size() > 0) {
					if (addAnd == true) {
						constraint += " and ";
					}
					EAttribute att = attributes.get(attributes.size() - 1);
					constraint += varNames.get(0) + "." + UseGeneratorUtils.encodeWord(att.getName()) + "=" + processObject(eObject.eGet(att));
				}
			}
			else if (eObjects.size() > 0) {
				EObject eObject = eObjects.get(eObjects.size() - 1);
				List<EReference> references = eObject.eClass().getEAllReferences();
				for (EReference ref : references) {
					if (addAnd == true) {
						constraint += " and ";
						addAnd = false;
					}
					if (ref.isContainment() == true) {
						String processed = processObject(eObject.eGet(ref), eObjectNamesHashMap, classNames, useReferences, addAnd);
						if (processed.length() > 0) {
							constraint += processed; 
							addAnd = true;
						}
					}
					if (ref.isContainment() == false) {
						Object o = eObject.eGet(ref);
						if (o == null) {
							constraint += varNames.get(eObjects.size() - 1) + "." + UseGeneratorUtils.encodeWord(getTarUseReferenceName(eObject.eClass(), ref, classNames, useReferences)) + "=null";
							addAnd = true;
						}
						if (o instanceof EObject) {
							constraint += varNames.get(eObjects.size() - 1) + "." + UseGeneratorUtils.encodeWord(getTarUseReferenceName(eObject.eClass(), ref, classNames, useReferences)) + "=" + eObjectNamesHashMap.get((EObject) o);
							addAnd = true;
						}
						if (o instanceof List<?>) {
							List<EObject> objs = (List<EObject>) o;
							constraint += processReferenceValues(varNames.get(eObjects.size() - 1), ref, objs, eObjectNamesHashMap, classNames, useReferences);
							addAnd = true;
						}
					}
				}
				List<EAttribute> attributes = eObject.eClass().getEAllAttributes();
				if (attributes.size() > 1) {
					for (EAttribute att : attributes.subList(0, attributes.size() - 1)) {
						if (addAnd == true) {
							constraint += " and ";
						}
						constraint += varNames.get(eObjects.size() - 1) + "." + UseGeneratorUtils.encodeWord(att.getName()) + "=" + processObject(eObject.eGet(att));
					}
				}
				if (attributes.size() == 1) {
					if (addAnd == true) {
						constraint += " and ";
						addAnd = false;
					}
					EAttribute att = attributes.get(0);
					constraint += varNames.get(eObjects.size() - 1) + "." + UseGeneratorUtils.encodeWord(att.getName()) + "=" + processObject(eObject.eGet(att));
					addAnd = true;
				}
				else if (attributes.size() > 0) {
					if (addAnd == true) {
						constraint += " and ";
					}
					EAttribute att = attributes.get(attributes.size() - 1);
					constraint += varNames.get(eObjects.size() - 1) + "." + UseGeneratorUtils.encodeWord(att.getName()) + "=" + processObject(eObject.eGet(att));
				}
			}
		}
		if (object instanceof EObject) {
			EObject eObject = (EObject) object;
			String varName = eObjectNamesHashMap.get(eObject);
			List<EReference> references = eObject.eClass().getEAllReferences();
			for (EReference ref : references) {

				if (addAnd == true) {
					constraint += " and ";
					addAnd = false;
				}
				if (ref.isContainment() == true) {
					String processed = processObject(eObject.eGet(ref), eObjectNamesHashMap, classNames, useReferences, addAnd);
					if (processed.length() > 0) {
						constraint += processed; 
						addAnd = true;
					}
				}
				if (ref.isContainment() == false) {
					Object o = eObject.eGet(ref);
					if (o == null) {
						constraint += varName + "." + UseGeneratorUtils.encodeWord(getTarUseReferenceName(eObject.eClass(), ref, classNames, useReferences)) + "=null";
						addAnd = true;
					}
					if (o instanceof EObject) {
						constraint += varName + "." + UseGeneratorUtils.encodeWord(getTarUseReferenceName(eObject.eClass(), ref, classNames, useReferences)) + "=" + eObjectNamesHashMap.get((EObject) o);
						addAnd = true;
					}
					if (o instanceof List<?>) {
						List<EObject> objs = (List<EObject>) o;
						constraint += processReferenceValues(varName, ref, objs, eObjectNamesHashMap, classNames, useReferences);
						addAnd = true;
					}
				}
			}
			List<EAttribute> attributes = eObject.eClass().getEAllAttributes();
			if (attributes.size() > 1) {
				for (EAttribute att : attributes.subList(0, attributes.size() - 1)) {
					if (addAnd == true) {
						constraint += " and ";
						addAnd = false;
					}
					constraint += varName + "." + UseGeneratorUtils.encodeWord(att.getName()) + "=" + processObject(eObject.eGet(att));
					addAnd = true;
				}
			}
			if (attributes.size() == 1) {
				if (addAnd == true) {
					constraint += " and ";
					addAnd = false;
				}
				EAttribute att = attributes.get(0);
				constraint += varName + "." + UseGeneratorUtils.encodeWord(att.getName()) + "=" + processObject(eObject.eGet(att));
				addAnd = true;
			}
			else if (attributes.size() > 0) {
				if (addAnd == true) {
					constraint += " and ";
				}
				EAttribute att = attributes.get(attributes.size() - 1);
				constraint += varName + "." + UseGeneratorUtils.encodeWord(att.getName()) + "=" + processObject(eObject.eGet(att));
			}
		}
		return constraint;
	}
	
	/**
	 * Gets string names array from given USE set of names
	 * @param text
	 * @return
	 */
	private static String[] getNames(String text) {
		if (text == null || text.isEmpty()) {
			return new String[0];
		}
		List<String> names = new ArrayList<String>();
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) != '\'') continue;
			StringBuilder literal = new StringBuilder("'");
			boolean closed = false;
			for (int j = i + 1; j < text.length(); j++) {
				char c = text.charAt(j);
				literal.append(c);
				if (c == '\'') {
					if (j + 1 < text.length() && text.charAt(j + 1) == '\'') {
						literal.append('\'');
						j++;
						continue;
					}
					closed = true;
					i = j;
					break;
				}
			}
			if (!closed) {
				throw new IllegalArgumentException("Unterminated USE string literal in: " + text);
			}
			names.add(literal.toString());
		}
		return names.toArray(new String[0]);
	}

	
	/**
	 * Add new USE names from the given text
	 * @param names
	 * @param oclText
	 * @return
	 */
	public static String oclAddNames(String names, String oclText) {
		LinkedHashSet<String> values = new LinkedHashSet<String>();
		for (String value : getNames(names)) values.add(value);
		for (String value : getNames(oclText)) values.add(value);
		StringBuilder result = new StringBuilder("String = Set{");
		boolean first = true;
		for (String value : values) {
			if (!first) result.append(", ");
			first = false;
			result.append(value);
		}
		return result.append('}').toString();
	}
	
	/**
	 * Converts a XMI model to a USE OCL constraint
	 * @param model
	 * @param classNames
	 * @param useReferences
	 * @return
	 */
	public static String xmi2ocl(Resource model, HashMap<URI, String> classNames, HashMap<URI, HashMap<URI, Entry<String, String>>> useReferences) {
		if (model == null || classNames == null) {
			throw new IllegalArgumentException("model and classNames must not be null");
		}
		EObject root = ModelManager.getRoot(model);
		if (root == null) {
			throw new IllegalArgumentException("The XMI resource has no root EObject: " + model.getURI());
		}
		String useText = "";
		String className = classNames.get(getMetaModelURIFromXMI(EcoreUtil.getURI(root.eClass()), classNames));
		if (className == null) {
			throw new IllegalArgumentException("No USE class mapping for root EClass " + EcoreUtil.getURI(root.eClass()));
		}
		HashMap<String, Integer> varNamesHashMap = new HashMap<String, Integer>();
		String varName = className.substring(0, 1).toLowerCase();
		varNamesHashMap.put(varName, null);
		HashMap<EObject, String> eObjectNamesHashMap = new HashMap<EObject, String>();
		processObjectNames(root, varNamesHashMap, eObjectNamesHashMap, classNames);
		varName = eObjectNamesHashMap.get(root);
		String constraint = className + ".allInstances()->exists(";
		constraint += processContainmentReferences(root, eObjectNamesHashMap, classNames, useReferences);
		List<EReference> references = root.eClass().getEAllReferences();
		boolean addAnd = false;
		for (EReference ref : references) {
			if (addAnd == true) {
				constraint += " and ";
				addAnd = false;
			}
			if (ref.isContainment() == true) {
				String processed = processObject(root.eGet(ref), eObjectNamesHashMap, classNames, useReferences, addAnd);
				if (processed.length() > 0) {
					constraint += processed; 
					addAnd = true;
				}
			}
			if (ref.isContainment() == false) {
				Object o = root.eGet(ref);
				if (o == null) {
					constraint += varName + "." + UseGeneratorUtils.encodeWord(getTarUseReferenceName(root.eClass(), ref, classNames, useReferences)) + "=null";
					addAnd = true;
				}
				if (o instanceof EObject) {
					constraint += varName + "." + UseGeneratorUtils.encodeWord(getTarUseReferenceName(root.eClass(), ref, classNames, useReferences)) + "=" + eObjectNamesHashMap.get((EObject) o);
					addAnd = true;
				}
				if (o instanceof List<?>) {
					List<EObject> objs = (List<EObject>) o;
					constraint += processReferenceValues(varName, ref, objs, eObjectNamesHashMap, classNames, useReferences);
					addAnd = true;
				}
			}
		}
		List<EAttribute> attributes = root.eClass().getEAllAttributes();
		if (attributes.size() > 1) {
			for (EAttribute att : attributes.subList(0, attributes.size() - 1)) {
				if (addAnd == true) {
					constraint += " and ";
					addAnd = false;
				}
				constraint += varName + "." + UseGeneratorUtils.encodeWord(att.getName()) + "=" + processObject(root.eGet(att));
				addAnd = true;
			}
		}
		if (attributes.size() == 1) {
			if (addAnd == true) {
				constraint += " and ";
			}
			EAttribute att = attributes.get(0);
			constraint += varName + "." + UseGeneratorUtils.encodeWord(att.getName()) + "=" + processObject(root.eGet(att));
		}
		else if (attributes.size() > 0) {
			if (addAnd == true) {
				constraint += " and ";
			}
			EAttribute att = attributes.get(attributes.size() - 1);
			constraint += varName + "." + UseGeneratorUtils.encodeWord(att.getName()) + "=" + processObject(root.eGet(att));
		}
		if (constraint.length() > 0) {
			constraint = completeParentheses(constraint);
			useText += constraint;
		}
		return useText;
	}
	
	/**
	 * Takes XMI strings onto USE strings 
	 * @param model
	 * @param classNames
	 * @return
	 */
	public static String xmi2oclNames(Resource model, HashMap<URI, String> classNames) {
		if (model == null || classNames == null) {
			throw new IllegalArgumentException("model and classNames must not be null");
		}
		EObject root = ModelManager.getRoot(model);
		if (root == null) {
			throw new IllegalArgumentException("The XMI resource has no root EObject: " + model.getURI());
		}
		String oclNames = "String = Set{";
		String className = root.eClass().getName();
		HashMap<String, Integer> varNamesHashMap = new HashMap<String, Integer>();
		String varName = className.substring(0, 1).toLowerCase();
		varNamesHashMap.put(varName, null);
		HashMap<EObject, String> eObjectNamesHashMap = new HashMap<EObject, String>();
		processObjectNames(root, varNamesHashMap, eObjectNamesHashMap, classNames);
		varName = eObjectNamesHashMap.get(root);
		List<EReference> references = root.eClass().getEAllReferences();
		boolean addComma = false;
		for (EReference ref : references) {
			if (ref.isContainment() == true) {
				String processed = processObjectNames(root.eGet(ref), eObjectNamesHashMap, addComma);
				if (processed.length() > 0) {
					if (addComma == true) {
						oclNames += ", ";
						addComma = false;
					}
					oclNames += processed; 
					addComma = true;
				}
			}
		}
		List<EAttribute> attributes = root.eClass().getEAllAttributes();
		if (attributes.size() > 1) {
			for (EAttribute att : attributes.subList(0, attributes.size() - 1)) {
				String processed = getStringName(root.eGet(att));
				if (processed.length() > 0) {
					if (addComma == true) {
						oclNames += ", ";
						addComma = false;
					}
					oclNames += processed;
					addComma = true;
				}
			}
		}
		if (attributes.size() == 1) {
			EAttribute att = attributes.get(0);
			String processed = getStringName(root.eGet(att));
			if (processed.length() > 0) {
				if (addComma == true) {
					oclNames += ", ";
				}
				oclNames += processed;
			}
		}
		else if (attributes.size() > 0) {
			EAttribute att = attributes.get(attributes.size() - 1);
			String processed = getStringName(root.eGet(att));
			if (processed.length() > 0) {
				if (addComma == true) {
					oclNames += ", ";
				}
				oclNames += processed;
			}
		}
		oclNames += "}";
		return oclNames;
	}
	
	/**
	 * Takes Wodel strings onto USE strings
	 * @return
	 */
	public static String wodel2useNames(String filename) {
		if (filename == null || filename.isBlank()) {
			return "String = Set{}";
		}
		String outputPath = ModelManager.getOutputPath();
		File modelFile = new File(outputPath == null ? "" : outputPath,
				filename.replaceFirst("(?i)\\.mutator$", ".model"));
		Resource wodel = null;
		try {
			List<EPackage> packages = new ArrayList<EPackage>();
			packages.add(MutatorenvironmentPackage.eINSTANCE);
			wodel = ModelManager.loadModel(packages, modelFile.getPath());
			Set<String> names = new LinkedHashSet<String>();
			for (EObject object : ModelManager.getAllObjects(wodel)) {
				if (object instanceof SpecificStringType) {
					String value = ((SpecificStringType) object).getValue();
					if (value != null) {
						names.add(value);
					}
				} else if (object instanceof ListStringType) {
					for (String value : ((ListStringType) object).getValue()) {
						if (value != null) {
							names.add(value);
						}
					}
				}
			}
			StringBuilder result = new StringBuilder("String = Set{");
			boolean first = true;
			for (String name : names) {
				if (!first) {
					result.append(", ");
				}
				first = false;
				result.append("'").append(escapeUseString(name)).append("'");
			}
			return result.append('}').toString();
		} catch (Exception ex) {
			throw new IllegalStateException("Could not collect string values from Wodel model: " + modelFile, ex);
		} finally {
			if (wodel != null) {
				try { wodel.unload(); } catch (RuntimeException ignored) { }
			}
		}
	}

	/**
	 * Converts EMF OCL to USE OCL
	 * @param packages
	 * @param oclText
	 * @param useReferences
	 * @return
	 */
	public static String ocl2use(List<EPackage> packages, String oclText,
			HashMap<URI, String> classNames,
			HashMap<URI, HashMap<URI, Entry<String, String>>> useReferences) {
		if (oclText == null || oclText.isBlank()) {
			return oclText;
		}
		if (packages == null || classNames == null) {
			throw new IllegalArgumentException("packages and classNames must not be null");
		}

		String translated = oclText;

		/*
		 * Reference names may be renamed by the USE association generator.  Only
		 * perform a global token replacement when a source EReference name maps
		 * unambiguously to a single USE target role.  This avoids the old
		 * replaceAll(...) implementation accidentally changing string literals,
		 * partial identifiers, or a same-named reference from another class.
		 */
		Map<String, String> uniqueReferenceNames = new LinkedHashMap<String, String>();
		Set<String> ambiguousReferenceNames = new LinkedHashSet<String>();
		if (useReferences != null) {
			for (Map<URI, Entry<String, String>> byReference : useReferences.values()) {
				if (byReference == null) {
					continue;
				}
				for (Map.Entry<URI, Entry<String, String>> entry : byReference.entrySet()) {
					EReference reference = findReferenceByURI(packages, entry.getKey());
					if (reference == null || entry.getValue() == null) {
						continue;
					}
					String original = reference.getName();
					String target = entry.getValue().getValue();
					String previous = uniqueReferenceNames.putIfAbsent(original, target);
					if (previous != null && !previous.equals(target)) {
						ambiguousReferenceNames.add(original);
					}
				}
			}
		}
		for (String ambiguous : ambiguousReferenceNames) {
			uniqueReferenceNames.remove(ambiguous);
		}
		for (Map.Entry<String, String> entry : uniqueReferenceNames.entrySet()) {
			translated = replaceIdentifierOutsideStrings(translated, entry.getKey(), entry.getValue());
		}

		for (Map.Entry<URI, String> entry : classNames.entrySet()) {
			EClass eClass = ModelManager.getEClassByURI(packages, entry.getKey());
			if (eClass != null && eClass.getName() != null) {
				translated = replaceIdentifierOutsideStrings(translated, eClass.getName(), entry.getValue());
			}
		}
		return translated;
	}

	private static EReference findReferenceByURI(List<EPackage> packages, URI uri) {
		if (packages == null || uri == null) {
			return null;
		}
		for (EPackage ePackage : packages) {
			if (ePackage == null) {
				continue;
			}
			for (EClass eClass : ModelManager.getEClasses(java.util.Collections.singletonList(ePackage))) {
				for (EReference reference : eClass.getEAllReferences()) {
					if (uri.equals(EcoreUtil.getURI(reference))) {
						return reference;
					}
				}
			}
		}
		return null;
	}

	private static String replaceIdentifierOutsideStrings(String text, String identifier, String replacement) {
		if (text == null || identifier == null || identifier.isEmpty() || replacement == null
				|| identifier.equals(replacement)) {
			return text;
		}
		StringBuilder result = new StringBuilder(text.length() + 16);
		boolean inString = false;
		for (int i = 0; i < text.length();) {
			char c = text.charAt(i);
			if (c == '\'' ) {
				result.append(c);
				if (inString && i + 1 < text.length() && text.charAt(i + 1) == '\'') {
					result.append('\'');
					i += 2;
					continue;
				}
				inString = !inString;
				i++;
				continue;
			}
			if (!inString && isIdentifierStart(c)) {
				int j = i + 1;
				while (j < text.length() && isIdentifierPart(text.charAt(j))) {
					j++;
				}
				String token = text.substring(i, j);
				result.append(token.equals(identifier) ? replacement : token);
				i = j;
			} else {
				result.append(c);
				i++;
			}
		}
		return result.toString();
	}

	private static boolean isIdentifierStart(char c) {
		return Character.isLetter(c) || c == '_';
	}

	private static boolean isIdentifierPart(char c) {
		return Character.isLetterOrDigit(c) || c == '_';
	}
}
