package efinder.usemv.utils;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.eclipse.jdt.annotation.NonNull;

/**
 * Auxiliary methods on EMF models. 
 * @author eguerra
 */
public class EMFUtils {
	
	
	/**
	 * It obtains the upper bound of an association end.
	 * @param className name of the class
	 * @param propertyName name of the association end
	 * @param metamodel meta-model
	 */
	public static int upperBound (String className, String propertyName, EPackage metamodel) {
		int maxCardinality = 0;
		EClassifier classifier = metamodel.getEClassifier(className); 
		if (classifier!=null) {
			for (EObject o : classifier.eCrossReferences()) 
				if (o instanceof EReference && ((EReference)o).getName().equals(propertyName))
					maxCardinality = ((EReference)o).getUpperBound(); 
		}
		return maxCardinality;
	}
	
	/**
	 * It returns the type of an attribute.
	 * @param className class that defines the attribute
	 * @param attr name of the attribute
	 * @param metamodel meta-model that contains the attribute definition 
	 * @return
	 */
	public static String attType (String className, String attr, EPackage metamodel) {
		String attType = "";
		if (metamodel!=null) {
			EClassifier eClass = metamodel.getEClassifier(className);
			if (eClass!=null) {
				EStructuralFeature f = eClass.eClass().getEStructuralFeature(attr);
				if (f!=null) attType = f.getEType().getName();
			}
		}
		return attType;
	}
	
	/**
	 * It returns whether a classifier is abstract or not.
	 * @param classifier classifier
	 * @return
	 */
	public static boolean isAbstract (EClassifier classifier) {
		EStructuralFeature isAbstract = classifier.eClass().getEStructuralFeature("abstract"); 
		return isAbstract!=null? 
			    classifier.eGet(isAbstract).toString().toString().equals("true") :
				true;
	}
	
	/**
	 * It returns the name of the feature that relates a class in a domain meta-model with 
	 * another class in a different codomain meta-model.
	 * @param domainClass name of class 1
	 * @param codomainClass name of class 2 related with domainClass
	 * @param domainMM meta-model of class 1
	 * @param codomainMM meta-model of class 2
	 */
	public static String feature (String domainClass, String codomainClass, EPackage domainMM, EPackage codomainMM) {
		String feature = "";
		if (domainMM!=null && codomainMM!=null && domainClass!=null && codomainClass!=null) {
			EClassifier   domainEClass =   domainMM.getEClassifier(  domainClass);
			EClassifier codomainEClass = codomainMM.getEClassifier(codomainClass);
			if (domainEClass!=null && codomainEClass!=null) 
				for (EObject o : domainEClass.eCrossReferences())
					if (o instanceof EReference) 
						if (codomainMM.getEClassifiers().contains(((EReference)o).getEType()))
							feature = ((EReference)o).getName();
		}
		return feature;
	}


	/**
	 * It obtains the traces that a correspondence meta-model defines between given source and target meta-models.
	 * @param sourceMM source meta-model
	 * @param corresMM correspondence meta-model
	 * @param targetMM target meta-model
	 * @return
	 */
	/*
	public static List<EClassifier> traces (EPackage sourceMM, EPackage corresMM, EPackage targetMM) {
		List<EClassifier> traces = new ArrayList<EClassifier>();
		if (sourceMM!=null && corresMM!=null && targetMM!=null)
			for (EClassifier classifier : corresMM.getEClassifiers()) {
				String sourceProperty = "", targetProperty = "";
				for (EObject o : classifier.eCrossReferences()) 
					if (o instanceof EReference) {
						if      (sourceMM.getEClassifiers().contains(((EReference)o).getEType())) sourceProperty = ((EReference)o).getName();
						else if (targetMM.getEClassifiers().contains(((EReference)o).getEType())) targetProperty = ((EReference)o).getName();
					}
			if (!sourceProperty.isEmpty() && !targetProperty.isEmpty()) traces.add(classifier);
		}			
		return traces;
	}	
	*/

	/**
	 * It creates an EObject of the given type
	 */
	public static EObject createEObject (EPackage metamodel, String type) {
		EClassifier classif = metamodel.getEClassifier(type);
		return metamodel.getEFactoryInstance().create((EClass)classif);
	}
	
	public static void setAttribute(@NonNull EObject object, String attributeName, String useValue) {
		EAttribute feature = (EAttribute) object.eClass().getEStructuralFeature(attributeName);
		EDataType dt = feature.getEAttributeType();

		/// TODO: See OclTest.ecore... It is a weird scenario 
		if (!feature.isChangeable())
			return;
		
		if ( isBigInteger(dt) ) {
			// isInteger would also return true if isBigInteger(dt) => so this needs to be checked before because it is more specific
			BigInteger bi = new BigInteger(useValue);
			dynamicSet(object, feature, bi);
		} else if (isInteger(dt)) {			
			int v = Integer.parseInt(useValue);
			dynamicSet(object, feature, v);		
		} else if ( isString(dt) ) {
			String str = extractRawString(useValue);
			dynamicSet(object, feature, str);
		} else if ( isChar(dt)) {
			String str = extractRawString(useValue);
			if (! str.isEmpty()) {
				char c = str.charAt(0);			
				dynamicSet(object, feature, c);
			}
		} else if (isBoolean(dt)) {
			boolean b = Boolean.parseBoolean(useValue);
			dynamicSet(object, feature, b);
		} else if (isFloat(dt)) {
			// This is not totally accurate: we use float to make sure that is compatible with both
			float d = Float.parseFloat(useValue);
			dynamicSet(object, feature, d);
		} else if (isDouble(dt)) {
			double d = Double.parseDouble(useValue);
			dynamicSet(object, feature, d);
		} else if (isBigDecimal(dt)) {
			BigDecimal d = new BigDecimal(useValue);
			dynamicSet(object, feature, d);
		} else if (feature.getEType() instanceof EEnum) {
			EEnum enumerate = (EEnum)feature.getEType();
            EEnumLiteral literal = enumerate.getEEnumLiteral(useValue.substring(useValue.indexOf("::")+2));
            object.eSet(feature, literal);
		} else {
			throw new UnsupportedOperationException();
		}
	}

	private static String extractRawString(String useValue) {
		return (useValue.startsWith("\"") && useValue.endsWith("\"")) || (useValue.startsWith("'")  && useValue.endsWith("'")) ? 
				 useValue.substring(1, useValue.length()-1) : useValue;
	}	
	
	private static boolean isChar(EDataType dt) {
		String type = dt.getName();
		return "EChar".equals(type) || "char".equalsIgnoreCase(type);
	}

	private static boolean isBigDecimal(EDataType dt) {
		String type = dt.getName();
		return type.equals("EBigDecimal") || type.equals("BigDecimal");
	}

	private static boolean isInteger(EDataType dt) {
		return isInteger(dt.getName()); // || isInteger(dt.getInstanceTypeName());
	}
	
	private static boolean isBigInteger(EDataType dt) {
		return isBigInteger(dt.getName());
	}
	
	private static boolean isString(EDataType dt) {
		return isString(dt.getName());
	}

	private static boolean isBoolean(EDataType dt) {
		return isBoolean(dt.getName());
	}

	private static boolean isFloat(EDataType dt) {
		return isFloat(dt.getName()); 
	}
	
	private static boolean isDouble(EDataType dt) {
		return isDouble(dt.getName()); 
	}
	
	private static void dynamicSet(@NonNull EObject object, EAttribute feature, Object newValue) {
		if (feature.isMany()) {
			
		} else {
			object.eSet(feature, newValue);
		}
	}

	
	
	/**
	 * It assigns a certain value to an attribute of an EObject
	 */
	@Deprecated
	public static boolean setAttribute (EPackage metamodel, EObject object, String attname, String attvalue) {
		EStructuralFeature feature = object.eClass().getEStructuralFeature(attname);
		String     featureTypeName = feature.getEType().getName();

		if (feature!=null) {
			// ecore data-types
			if (metamodel.getEClassifier(featureTypeName)==null) {
				if      (isBigInteger(featureTypeName)) setAttribute(metamodel, object, feature, "java.math.BigInteger", new BigInteger(attvalue)); 
				else if (isInteger(featureTypeName))    setAttribute(metamodel, object, feature, "java.lang.Integer", new Integer(attvalue)); // object.eSet(feature, new Integer(attvalue));
				else if (isBoolean(featureTypeName))    setAttribute(metamodel, object, feature, "java.lang.Boolean", new Boolean(attvalue)); // object.eSet(feature, new Boolean(attvalue));
				else if (isString (featureTypeName))    setAttribute(metamodel, object, feature, "java.lang.String", 
						(attvalue.startsWith("\"") && attvalue.endsWith("\"")) || (attvalue.startsWith("'")  && attvalue.endsWith("'")) ? 
						 attvalue.substring(1,attvalue.length()-1) : attvalue);
				//else   object.eSet(feature, attvalue);
				else return false;
				return true;
			}
			// enumerates 
			else if (feature.getEType() instanceof EEnum) {
				EEnum        enumerate = (EEnum)feature.getEType();
				EEnumLiteral literal   = enumerate.getEEnumLiteral(attvalue.substring(attvalue.indexOf("::")+2));
				object.eSet(feature, literal);
				return true;
			}
			// user-defined data-types
			else {
				if      (isInteger(featureTypeName)) setAttribute(metamodel, object, feature, "java.lang.Integer", new Integer(attvalue));
				else if (isBoolean(featureTypeName)) setAttribute(metamodel, object, feature, "java.lang.Boolean", new Boolean(attvalue));
				else if (isString (featureTypeName)) setAttribute(metamodel, object, feature, "java.lang.String", 
						(attvalue.startsWith("\"") && attvalue.endsWith("\"")) || (attvalue.startsWith("'")  && attvalue.endsWith("'")) ? 
						 attvalue.substring(1,attvalue.length()-1) : attvalue);
				else object.eSet(feature, metamodel.getEFactoryInstance().createFromString(((EAttribute)feature).getEAttributeType(), attvalue));
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Method used by public method EMFUtils.setAttribute (EPackage, EObject, String, String). It takes into account that the
	 * instance class name of the data type can be null, in which case, it uses the instance class name received as parameter. 
	 */
	private static void setAttribute (EPackage metamodel, EObject object, EStructuralFeature feature, String instanceClassName, Object value) {
		if (feature.getEType().getInstanceClassName()==null) {
			feature.getEType().setInstanceClassName(instanceClassName);
			object.eSet(feature, value);
		}
		else object.eSet(feature, value);
	}
	
	/**
	 * It assigns a certain value to a reference of an EObject
	 */
	public static boolean setReference (EPackage metamodel, EObject object1, String reference, EObject object2) {
		EStructuralFeature feature = object1.eClass().getEStructuralFeature(reference);
		if (feature!=null && feature.isChangeable()) {
			int upperbound = EMFUtils.upperBound(object1.eClass().getName(), reference, metamodel);
			if      (upperbound== 1)  object1.eSet(feature, object2);
			else if (upperbound==-1) ((EcoreEList)object1.eGet(feature)).add(object2);
			return true;
		}
		return false;
	}
	
	/**
	 * It checks whether an object has an attribute with the given name 
	 * @param object
	 * @param attname
	 * @return true / false
	 */
	public static boolean hasAttribute (EObject object, String attname) {
		EStructuralFeature feature = object.eClass().getEStructuralFeature(attname);
		return feature==null? false : feature instanceof EAttribute;
	}

	/**
	 * It checks whether an object defines a reference with the given name 
	 * @param object
	 * @param refname
	 * @return true / false
	 */
	public static boolean hasReference (EObject object, String refname) {
		EStructuralFeature feature = object.eClass().getEStructuralFeature(refname);
		return feature==null? false : feature instanceof EReference;
	}

	// (some methods to check ecore types)
	public static boolean isBigInteger (String type) { return type.equals("EBigInteger"); }	
	public static boolean isInteger  (String type)   { return type.equals("EInt") || type.equals("Integer") || type.equals("IntegerObject") || type.equals("EIntegerObject") || type.endsWith("Integer"); }	
	public static boolean isString   (String type)   { return type.equals("EString") || type.equals("String") || type.endsWith("String"); }	
	public static boolean isBoolean  (String type)   { return type.equals("EBoolean") || type.equals("boolean") || type.equals("EBooleanObject") || type.equals("Boolean") || type.endsWith("Boolean"); }
	public static boolean isFloat (String type)   { return type.equals("EFloat")  || type.equals("float")  || type.equals("EFloatObject")  || type.equals("Float")  || type.endsWith("Float"); }
	public static boolean isDouble (String type)   { return type.equals("EDouble") || type.equals("double") || type.equals("EDoubleObject") || type.equals("Double") || type.endsWith("Double"); }

	public static boolean isContainment(EObject object, String refname) {
		return ((EReference) object.eClass().getEStructuralFeature(refname)).isContainment();
	}

	public static boolean isNullable(EAttribute att) {
		return isString(att.getEAttributeType()) || att.getEType() instanceof EEnum;
	}
}

