package wodel.synthesizer.generator;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osgi.framework.Bundle;

import exceptions.MetaModelNotFoundException;
import exceptions.ModelNotFoundException;
import manager.ModelManager;
import manager.UseGeneratorUtils;
import mutatorenvironment.AttributeEvaluation;
import mutatorenvironment.CloneObjectMutator;
import mutatorenvironment.Expression;
import mutatorenvironment.ListStringType;
import mutatorenvironment.ModifyInformationMutator;
import mutatorenvironment.ObSelectionStrategy;
import mutatorenvironment.RandomTypeSelection;
import mutatorenvironment.RemoveObjectMutator;
import mutatorenvironment.RetypeObjectMutator;
import mutatorenvironment.SelectObjectMutator;
import mutatorenvironment.SpecificStringType;

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
		String decodedClassName = className;
		if (className.startsWith("xxxx")) {
			if (Arrays.asList(UseGeneratorUtils.useWords).contains(className.substring(4, className.length()))) {
				decodedClassName = className.substring(4, className.length());
			}
		}
		return decodedClassName.split("XxxX");
	}
	
	/**
	 * Gets the meta-model URI from given XMI
	 * @param xmiURI
	 * @param classNames
	 * @return
	 */
	private static URI getMetaModelURIFromXMI(URI xmiURI, HashMap<URI, String> classNames) {
		URI metamodelURI = null;
		String uriValue = xmiURI.toString();
		uriValue = uriValue.substring(uriValue.indexOf("#"), uriValue.length());
		for (URI uri : classNames.keySet()) {
			if (uri.toString().endsWith(uriValue)) {
				metamodelURI = uri;
				break;
			}
		}
		return metamodelURI;
	}
	
	/**
	 * Gets USE string name
	 * @param o
	 * @return
	 */
	private static String getStringName(Object o) {
		String processed = "";
		if (o instanceof String) {
			processed = "'" + o.toString() + "'";
		}
		return processed;
	}
	
	/**
	 * Completes the necesary parentheses for the given constraint
	 * @param constraint
	 * @return
	 */
	private static String completeParentheses(String constraint) {
		int count = 0;
		for (char c : constraint.toCharArray()) {
			if (c == '(') {
				count++;
			}
			if (c == ')') {
				count--;
			}
		}
		for (int i = 0; i < count; i++) {
			constraint += ")";
		}
		return constraint;
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
		String processed = "";
		if (o instanceof Boolean) {
			processed = o.toString();
		}
		if (o instanceof String) {
			processed = "'" + o.toString() + "'";
		}
		if (o instanceof Double) {
			processed = o.toString();
		}
		if (o instanceof Integer) {
			processed = o.toString();
		}
		return processed;
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
								int i = getObjectMaxIndex(objs.get(0), eObjectNamesHashMap);
								constraint += varNames.get(index) + "." + UseGeneratorUtils.encodeWord(getTarUseReferenceName(eObject.eClass(), ref, classNames, useReferences)) + "->exists(";
								String className = ref.getEType().getName();
								List<String> localVarNames = new ArrayList<String>();
								String varName = "";
								for (EObject obj : objs.subList(0, objs.size() - 1)) {
									varName = className.substring(0, 1).toLowerCase() + i;
									constraint += varName + ", ";
									localVarNames.add(varName);
									i++;
								}
								varName = className.substring(0, 1).toLowerCase() + i;
								constraint += varName + " | ";
								localVarNames.add(varName);
								i = 0;
								for (EObject obj : objs.subList(0, objs.size() - 1)) {
									constraint += localVarNames.get(i) + "=" + eObjectNamesHashMap.get(obj) + " and ";
									i++;
								}
								constraint += localVarNames.get(i) + "=" + eObjectNamesHashMap.get(objs.get(objs.size() - 1)) + ")";
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
							int i = getObjectMaxIndex(objs.get(0), eObjectNamesHashMap);
							constraint += varNames.get(0) + "." + UseGeneratorUtils.encodeWord(getTarUseReferenceName(eObject.eClass(), ref, classNames, useReferences)) + "->exists(";
							String className = ref.getEType().getName();
							List<String> localVarNames = new ArrayList<String>();
							String varName = "";
							for (EObject obj : objs.subList(0, objs.size() - 1)) {
								varName = className.substring(0, 1).toLowerCase() + i;
								constraint += varName + ", ";
								localVarNames.add(varName);
								i++;
							}
							varName = className.substring(0, 1).toLowerCase() + i;
							constraint += varName + " | ";
							localVarNames.add(varName);
							i = 0;
							for (EObject obj : objs.subList(0, objs.size() - 1)) {
								constraint += localVarNames.get(i) + "=" + eObjectNamesHashMap.get(obj) + " and ";
								i++;
							}
							constraint += localVarNames.get(i) + "=" + eObjectNamesHashMap.get(objs.get(objs.size() - 1)) + ")";
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
							int i = getObjectMaxIndex(objs.get(0), eObjectNamesHashMap);
							constraint += varNames.get(eObjects.size() - 1) + "." + UseGeneratorUtils.encodeWord(getTarUseReferenceName(eObject.eClass(), ref, classNames, useReferences)) + "->exists(";
							String className = ref.getEType().getName();
							List<String> localVarNames = new ArrayList<String>();
							String varName = "";
							for (EObject obj : objs.subList(0, objs.size() - 1)) {
								varName = className.substring(0, 1).toLowerCase() + i;
								constraint += varName + ", ";
								localVarNames.add(varName);
								i++;
							}
							varName = className.substring(0, 1).toLowerCase() + i;
							constraint += varName + " | ";
							localVarNames.add(varName);
							i = 0;
							for (EObject obj : objs.subList(0, objs.size() - 1)) {
								constraint += localVarNames.get(i) + "=" + eObjectNamesHashMap.get(obj) + " and ";
								i++;
							}
							constraint += localVarNames.get(i) + "=" + eObjectNamesHashMap.get(objs.get(objs.size() - 1)) + ")";
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
						int i = getObjectMaxIndex(objs.get(0), eObjectNamesHashMap);
						constraint += varName + "." + UseGeneratorUtils.encodeWord(getTarUseReferenceName(eObject.eClass(), ref, classNames, useReferences)) + "->exists(";
						String className = ref.getEType().getName();
						List<String> localVarNames = new ArrayList<String>();
						String vName = "";
						for (EObject obj : objs.subList(0, objs.size() - 1)) {
							vName = className.substring(0, 1).toLowerCase() + i;
							constraint += vName + ", ";
							localVarNames.add(vName);
							i++;
						}
						vName = className.substring(0, 1).toLowerCase() + i;
						constraint += vName + " | ";
						localVarNames.add(vName);
						i = 0;
						for (EObject obj : objs.subList(0, objs.size() - 1)) {
							constraint += localVarNames.get(i) + "=" + eObjectNamesHashMap.get(obj) + " and ";
							i++;
						}
						constraint += localVarNames.get(i) + "=" + eObjectNamesHashMap.get(objs.get(objs.size() - 1)) + ")";
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
		List<String> names = new ArrayList<String>();
		char[] chars = text.toCharArray();
		int i = 0;
		while (i < chars.length) {
			if (chars[i] == '\'') {
				int j = i + 1;
				String name = "'";
				while (j < chars.length) {
					name += chars[j];
					if (chars[j] == '\'') {
						break;
					}
					j++;
				}
				names.add(name);
				i= j+1;
			}
			i++;
		}
		String[] ret = null;
		if (names.size() > 0) {
			ret = new String[names.size()];
			names.toArray(ret);
		}
		
		return ret;
	}

	
	/**
	 * Add new USE names from the given text
	 * @param names
	 * @param oclText
	 * @return
	 */
	public static String oclAddNames(String names, String oclText) {
		String[] newNames = getNames(oclText);
		if (newNames != null && newNames.length > 0) {
			List<String> nl = new ArrayList<String>();
			for (String newName : newNames) {
				if (names.indexOf(newName) == - 1) {
					nl.add(newName);
				}
			}
			if (nl.size() > 0) {
				if (names.length() == 0 || names.equals("String = Set{}")) {
					names = "String = Set{";
					names += nl.get(0);
					for (String n : nl.subList(1, nl.size())) {
						names += ", " + n;
					}
				}
				else {
					names = names.replace("}", "");
					for (String n : nl) {
						names += ", " + n;
					}
				}
				names += "}";
			}
		}
		return names;
	}
	
	/**
	 * Converts a XMI model to a USE OCL constraint
	 * @param model
	 * @param classNames
	 * @param useReferences
	 * @return
	 */
	public static String xmi2ocl(Resource model, HashMap<URI, String> classNames, HashMap<URI, HashMap<URI, Entry<String, String>>> useReferences) {
		EObject root = ModelManager.getRoot(model);
		String useText = "";
		String className = classNames.get(getMetaModelURIFromXMI(EcoreUtil.getURI(root.eClass()), classNames));
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
					int i = getObjectMaxIndex(objs.get(0), eObjectNamesHashMap);
					constraint += varName + "." + UseGeneratorUtils.encodeWord(getTarUseReferenceName(root.eClass(), ref, classNames, useReferences)) + "->exists(";
					String clName = ref.getEType().getName();
					List<String> localVarNames = new ArrayList<String>();
					String vName = "";
					for (EObject obj : objs.subList(0, objs.size() - 1)) {
						vName = clName.substring(0, 1).toLowerCase() + i;
						constraint += vName + ", ";
						localVarNames.add(vName);
						i++;
					}
					vName = clName.substring(0, 1).toLowerCase() + i;
					constraint += vName + " | ";
					localVarNames.add(vName);
					i = 0;
					for (EObject obj : objs.subList(0, objs.size() - 1)) {
						constraint += localVarNames.get(i) + "=" + eObjectNamesHashMap.get(obj) + " and ";
						i++;
					}
					constraint += localVarNames.get(i) + "=" + eObjectNamesHashMap.get(objs.get(objs.size() - 1)) + ")";
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
		EObject root = ModelManager.getRoot(model);
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
		String useNames = "String = Set{";
		try {
			String xmiFileName = "file:/" + ModelManager.getOutputPath() +  "/" + filename.replace(".mutator", ".model");
			Bundle bundle = Platform.getBundle("wodel.models");
			URL fileURL = bundle.getEntry("/models/MutatorEnvironment.ecore");
			String ecore = FileLocator.resolve(fileURL).getFile();
			List<EPackage> mutatorecore = ModelManager.loadMetaModel(ecore);
			Resource wodel = ModelManager.loadModel(mutatorecore, URI.createURI(xmiFileName).toFileString());
			List<EObject> objects = ModelManager.getAllObjects(wodel);
			List<String> names = new ArrayList<String>();
			for (EObject object : objects) {
				if (object instanceof RemoveObjectMutator) {
					RemoveObjectMutator mut = (RemoveObjectMutator) object;
					ObSelectionStrategy strategy = mut.getObject();
					if (strategy instanceof RandomTypeSelection) {
						RandomTypeSelection selection = (RandomTypeSelection) strategy;
						Expression expression = selection.getExpression();
						if (expression != null) {
							if (expression.getFirst() instanceof AttributeEvaluation) {
								AttributeEvaluation attev = (AttributeEvaluation) expression.getFirst();
								if (attev.getValue() instanceof SpecificStringType) {
									SpecificStringType stringType = (SpecificStringType) attev.getValue();
									if (!names.contains(stringType.getValue())) {
										names.add(stringType.getValue());
									}
								}
								if (attev.getValue() instanceof ListStringType) {
									ListStringType listStringType = (ListStringType) attev.getValue();
									for (String value : listStringType.getValue()) {
										if (!names.contains(value)) {
											names.add(value);
										}
									}
								}
							}
							if (expression.getSecond() instanceof AttributeEvaluation) {
								AttributeEvaluation attev = (AttributeEvaluation) expression.getSecond();
								if (attev.getValue() instanceof SpecificStringType) {
									SpecificStringType stringType = (SpecificStringType) attev.getValue();
									if (!names.contains(stringType.getValue())) {
										names.add(stringType.getValue());
									}
								}
								if (attev.getValue() instanceof ListStringType) {
									ListStringType listStringType = (ListStringType) attev.getValue();
									for (String value : listStringType.getValue()) {
										if (!names.contains(value)) {
											names.add(value);
										}
									}
								}
							}
						}
					}
				}
				if (object instanceof SelectObjectMutator) {
					SelectObjectMutator mut = (SelectObjectMutator) object;
					ObSelectionStrategy strategy = mut.getObject();
					if (strategy instanceof RandomTypeSelection) {
						RandomTypeSelection selection = (RandomTypeSelection) strategy;
						Expression expression = selection.getExpression();
						if (expression != null) {
							if (expression.getFirst() instanceof AttributeEvaluation) {
								AttributeEvaluation attev = (AttributeEvaluation) expression.getFirst();
								if (attev.getValue() instanceof SpecificStringType) {
									SpecificStringType stringType = (SpecificStringType) attev.getValue();
									if (!names.contains(stringType.getValue())) {
										names.add(stringType.getValue());
									}
								}
								if (attev.getValue() instanceof ListStringType) {
									ListStringType listStringType = (ListStringType) attev.getValue();
									for (String value : listStringType.getValue()) {
										if (!names.contains(value)) {
											names.add(value);
										}
									}
								}
							}
							if (expression.getSecond() instanceof AttributeEvaluation) {
								AttributeEvaluation attev = (AttributeEvaluation) expression.getSecond();
								if (attev.getValue() instanceof SpecificStringType) {
									SpecificStringType stringType = (SpecificStringType) attev.getValue();
									if (!names.contains(stringType.getValue())) {
										names.add(stringType.getValue());
									}
								}
								if (attev.getValue() instanceof ListStringType) {
									ListStringType listStringType = (ListStringType) attev.getValue();
									for (String value : listStringType.getValue()) {
										if (!names.contains(value)) {
											names.add(value);
										}
									}
								}
							}
						}
					}
				}
				if (object instanceof ModifyInformationMutator) {
					ModifyInformationMutator mut = (ModifyInformationMutator) object;
					ObSelectionStrategy strategy = mut.getObject();
					if (strategy instanceof RandomTypeSelection) {
						RandomTypeSelection selection = (RandomTypeSelection) strategy;
						Expression expression = selection.getExpression();
						if (expression != null) {
							if (expression.getFirst() instanceof AttributeEvaluation) {
								AttributeEvaluation attev = (AttributeEvaluation) expression.getFirst();
								if (attev.getValue() instanceof SpecificStringType) {
									SpecificStringType stringType = (SpecificStringType) attev.getValue();
									if (!names.contains(stringType.getValue())) {
										names.add(stringType.getValue());
									}
								}
								if (attev.getValue() instanceof ListStringType) {
									ListStringType listStringType = (ListStringType) attev.getValue();
									for (String value : listStringType.getValue()) {
										if (!names.contains(value)) {
											names.add(value);
										}
									}
								}
							}
							if (expression.getSecond() instanceof AttributeEvaluation) {
								AttributeEvaluation attev = (AttributeEvaluation) expression.getSecond();
								if (attev.getValue() instanceof SpecificStringType) {
									SpecificStringType stringType = (SpecificStringType) attev.getValue();
									if (!names.contains(stringType.getValue())) {
										names.add(stringType.getValue());
									}
								}
								if (attev.getValue() instanceof ListStringType) {
									ListStringType listStringType = (ListStringType) attev.getValue();
									for (String value : listStringType.getValue()) {
										if (!names.contains(value)) {
											names.add(value);
										}
									}
								}
							}
						}
					}
				}
				if (object instanceof CloneObjectMutator) {
					CloneObjectMutator mut = (CloneObjectMutator) object;
					ObSelectionStrategy strategy = mut.getObject();
					if (strategy instanceof RandomTypeSelection) {
						RandomTypeSelection selection = (RandomTypeSelection) strategy;
						Expression expression = selection.getExpression();
						if (expression != null) {
							if (expression.getFirst() instanceof AttributeEvaluation) {
								AttributeEvaluation attev = (AttributeEvaluation) expression.getFirst();
								if (attev.getValue() instanceof SpecificStringType) {
									SpecificStringType stringType = (SpecificStringType) attev.getValue();
									if (!names.contains(stringType.getValue())) {
										names.add(stringType.getValue());
									}
								}
								if (attev.getValue() instanceof ListStringType) {
									ListStringType listStringType = (ListStringType) attev.getValue();
									for (String value : listStringType.getValue()) {
										if (!names.contains(value)) {
											names.add(value);
										}
									}
								}
							}
							if (expression.getSecond() instanceof AttributeEvaluation) {
								AttributeEvaluation attev = (AttributeEvaluation) expression.getSecond();
								if (attev.getValue() instanceof SpecificStringType) {
									SpecificStringType stringType = (SpecificStringType) attev.getValue();
									if (!names.contains(stringType.getValue())) {
										names.add(stringType.getValue());
									}
								}
								if (attev.getValue() instanceof ListStringType) {
									ListStringType listStringType = (ListStringType) attev.getValue();
									for (String value : listStringType.getValue()) {
										if (!names.contains(value)) {
											names.add(value);
										}
									}
								}
							}
						}
					}
				}
				if (object instanceof RetypeObjectMutator) {
					RetypeObjectMutator mut = (RetypeObjectMutator) object;
					ObSelectionStrategy strategy = mut.getObject();
					if (strategy instanceof RandomTypeSelection) {
						RandomTypeSelection selection = (RandomTypeSelection) strategy;
						Expression expression = selection.getExpression();
						if (expression != null) {
							if (expression.getFirst() instanceof AttributeEvaluation) {
								AttributeEvaluation attev = (AttributeEvaluation) expression.getFirst();
								if (attev.getValue() instanceof SpecificStringType) {
									SpecificStringType stringType = (SpecificStringType) attev.getValue();
									if (!names.contains(stringType.getValue())) {
										names.add(stringType.getValue());
									}
								}
								if (attev.getValue() instanceof ListStringType) {
									ListStringType listStringType = (ListStringType) attev.getValue();
									for (String value : listStringType.getValue()) {
										if (!names.contains(value)) {
											names.add(value);
										}
									}
								}
							}
							if (expression.getSecond() instanceof AttributeEvaluation) {
								AttributeEvaluation attev = (AttributeEvaluation) expression.getSecond();
								if (attev.getValue() instanceof SpecificStringType) {
									SpecificStringType stringType = (SpecificStringType) attev.getValue();
									if (!names.contains(stringType.getValue())) {
										names.add(stringType.getValue());
									}
								}
								if (attev.getValue() instanceof ListStringType) {
									ListStringType listStringType = (ListStringType) attev.getValue();
									for (String value : listStringType.getValue()) {
										if (!names.contains(value)) {
											names.add(value);
										}
									}
								}
							}
						}
					}
				}
			}
			for (String name : names) {
				useNames += name + ", ";
			}
			if (useNames.indexOf(",") > 0) {
				useNames = useNames.substring(0, useNames.lastIndexOf(","));
			}
		} catch (ModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MetaModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		useNames += "}";
		if (useNames.equals("String = Set{}")) {
			useNames = "";
		}
		return useNames;
	}
	
	/**
	 * Converts EMF OCL to USE OCL
	 * @param packages
	 * @param oclText
	 * @param useReferences
	 * @return
	 */
	public static String ocl2use(List<EPackage> packages, String oclText, HashMap<URI, String> classNames, HashMap<URI, HashMap<URI, Entry<String, String>>> useReferences) {
		String oclUseText = oclText;
		char[] chars = oclUseText.toCharArray();
		for (URI classURI : useReferences.keySet()) {
			EClass eClass = ModelManager.getEClassByURI(packages, classURI);
			String className = eClass.getName();
			if (oclUseText.indexOf(className) != -1) {
				int begin = oclUseText.indexOf(className) + className.length();
				boolean flag = false;
				int i = begin;
				while (i < chars.length) {
					if (chars[i] == '(') {
						if (flag == true) {
							break;
						}
					}
					if (chars[i] == ')') {
						flag = true;
					}
					i++;
				}
				begin = i + 1;
				int end = 0;
				int countParentheses = 1;
				i = begin;
				while (i < chars.length) {
					if (chars[i] == '(') {
						countParentheses ++;
					}
					if (chars[i] == ')') {
						countParentheses --;
					}
					if (countParentheses == 0) {
						end = i;
					}
					i++;
				}
				String part = oclUseText.substring(begin, end);
				String newPart = part;
				for (URI refURI : useReferences.get(classURI).keySet()) {
					EReference ref = ModelManager.getEReferenceByURI(eClass, refURI);
					newPart = newPart.replaceAll(ref.getName(), useReferences.get(classURI).get(refURI).getValue());
				}
				oclUseText = oclUseText.replace(part, newPart);
			}
		}
		for (URI classURI : classNames.keySet()) {
			EClass eClass = ModelManager.getEClassByURI(packages, classURI);
			String className = eClass.getName();
			oclUseText = oclUseText.replaceAll(className, classNames.get(classURI));
		}
		
		return oclUseText;
	}
}
