package wodeledu.utils.manager;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import modeltext.Element;
import modeltext.ModeltextFactory;
import modeltext.ValuedFeature;
import mutatext.Option;
import mutatext.Variable;
import mutatext.Word;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import wodel.utils.manager.ModelManager;

/**
 * @author Pablo Gomez-Abajo
 * 
 * WodelEduUtils methods to get information of
 * the mutations
 * 
 */

public class WodelEduUtils {


	/**
	 * Gets the given type configure option - DSL mutaText
	 */
	public static Option getConfigureOption(String type, Resource model) {
		Iterator<EObject> objects = model.getAllContents();

		Option opt = null;
		while (objects.hasNext()) {
			EObject object = objects.next();
			if (object instanceof Option) {
				Option op = (Option) object;
				if (op.getType().getName().equals(type)) {
					opt = op;
					break;
				}
			}
		}
		if (opt == null) {
			opt = mutatext.MutatextFactory.eINSTANCE.createOption();
			if (type.equals("TargetReferenceChanged")) {
				Word w = mutatext.MutatextFactory.eINSTANCE.createConstant();
				ModelManager.setStringAttribute("value", w, "Change");
				opt.getValid().getWords().add(w);
				Variable v = mutatext.MutatextFactory.eINSTANCE.createVariable();
				//v.
				//v.setType(value);
				
				//COMPLETE

				opt.getInvalid().getWords().add(w);
				
			}
		}
		
		return opt;
	}

	/**
	 * Gets the corresponding element of the given object - DSL modelText
	 */
	public static Element getElement(EObject object, Resource model) {
		List<EClass> types = new ArrayList<EClass>();
		types.add(object.eClass());
		types.addAll(object.eClass().getEAllSuperTypes());
		
		Iterator<EObject> objects = model.getAllContents();

		if (object != null) {
			objects = model.getAllContents();
			while (objects.hasNext()) {
				EObject obj = objects.next();
				if (obj instanceof Element) {
					Element element = (Element) obj;
					EClass type = element.getType();
					for (EClass t : types) { 
						if (type.getName().equals(t.getName())) {
							if (element.getFeature() == null || element.getFeature().size() == 0) {
								return element;
							}
						}
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * Gets the corresponding element of the given object - DSL modelText
	 */
	public static Element getElementValues(EObject object, Resource model, boolean order) {
		List<EClass> types = new ArrayList<EClass>();
		types.add(object.eClass());
		types.addAll(object.eClass().getEAllSuperTypes());

		Iterator<EObject> objects = model.getAllContents();
		
		if (object != null) {
			objects = model.getAllContents();
			while (objects.hasNext()) {
				EObject obj = objects.next();
				if (obj instanceof Element) {
					Element element = (Element) obj;
					EClass type = element.getType();
					for (EClass t : types) { 
						if (type.getName().equals(t.getName())) {
							if (element.getFeature() == null || element.getFeature().size() == 0) {
								continue;
							}
							Map<ValuedFeature, EStructuralFeature> features = new HashMap<ValuedFeature, EStructuralFeature>();
							for (ValuedFeature feature : element.getFeature()) {
								EStructuralFeature eFeat = feature.getFeat();
								for (EStructuralFeature eFeature : object.eClass().getEAllStructuralFeatures()) {
									if (EcoreUtil.equals(eFeat, eFeature)) {
										features.put(feature, eFeature);
									}
								}
							}
							boolean found = true;
							for (ValuedFeature feature : features.keySet()) {
								Object value = object.eGet(features.get(feature));
								if (value != null) {
									if (value instanceof Boolean) {
										Boolean booleanValue = (Boolean) value; 
										if (order == true) {
											if (feature.isNegation() && booleanValue == true) {
												found = false;
												break;
											}
											else if (!feature.isNegation() && booleanValue == false) {
												found = false;
												break;
											}
										}
										else {
											if (!feature.isNegation() && booleanValue == true) {
												found = false;
												break;
											}
											else if (feature.isNegation() && booleanValue == false) {
												found = false;
												break;
											}
										}
									}
								}
								if (value instanceof EObject) {
									EObject ob = (EObject) value;
									if (feature.getRefFeature() != null) {
										EStructuralFeature eRefFeat = feature.getRefFeature();
										EStructuralFeature eRefFeature = null;
										for (EStructuralFeature eFeature : ob.eClass().getEAllStructuralFeatures()) {
											if (EcoreUtil.equals(eRefFeat, eFeature)) {
												eRefFeature = eFeature;
											}
										}
										if (eRefFeature != null) {
											Object v = ob.eGet(eRefFeature);
											if (v != null) {
												if (v instanceof Boolean) {
													Boolean booleanValue = (Boolean) v; 
													if (order == true) {
														if (feature.isNegation() && booleanValue == true) {
															found = false;
															break;
														}
														else if (!feature.isNegation() && booleanValue == false) {
															found = false;
															break;
														}
													}
													else {
														if (!feature.isNegation() && booleanValue == true) {
															found = false;
															break;
														}
														else if (feature.isNegation() && booleanValue == false) {
															found = false;
															break;
														}
													}
												}
											}
											if (feature.getValue().equals("null") && v != null) {
												found = false;
												break;
											}
										}
									}
								}
								if (value instanceof List<?>) {
									List<EObject> values = (List<EObject>) value;
									if (feature.getRefFeature() == null && feature.getValue() == null && values.size() == 0) {
										break;
									}
									if (feature.getRefFeature() != null) {
										boolean one = false;
										for (EObject ob : values) {
											EStructuralFeature eRefFeat = feature.getRefFeature();
											EStructuralFeature eRefFeature = null;
											for (EStructuralFeature eFeature : ob.eClass().getEAllStructuralFeatures()) {
												if (EcoreUtil.equals(eRefFeat, eFeature)) {
													eRefFeature = eFeature;
												}
											}
											if (eRefFeature != null) {
												Object v = ob.eGet(eRefFeature);
												if (v != null) {
													if (v instanceof Boolean) {
														Boolean booleanValue = (Boolean) v; 
														if (order == true) {
															if (feature.isNegation() && booleanValue == false) {
																one = true;
																break;
															}
															else if (!feature.isNegation() && booleanValue == true) {
																one = true;
																break;
															}
														}
														else {
															if (!feature.isNegation() && booleanValue == false) {
																one = true;
																break;
															}
															else if (feature.isNegation() && booleanValue == true) {
																one = true;
																break;
															}
														}
													}
												}
												if (feature.getValue().equals("null") && v == null) {
													one = true;
													break;
												}
											}
										}
										if (one == false) {
											found = false;
											break;
										}
									}
								}
								if (feature.getValue() != null && feature.getValue().equals("null") && feature.getRefFeature() == null && value != null) {
									found = false;
									break;
								}
							}
							if (found == true) {
								return element;
							}
						}
					}
				}
			}
		}
		return null;
	}

	/**
	 * Gets the corresponding element of the given object - DSL modelText
	 */
	public static List<Element> getAllElementValues(EObject object, Resource model) {
		List<EClass> types = new ArrayList<EClass>();
		types.add(object.eClass());
		types.addAll(object.eClass().getEAllSuperTypes());

		Iterator<EObject> objects = model.getAllContents();
		
		List<Element> elements = new ArrayList<Element>();
		if (object != null) {
			objects = model.getAllContents();
			while (objects.hasNext()) {
				EObject obj = objects.next();
				if (obj instanceof Element) {
					Element element = (Element) obj;
					EClass type = element.getType();
					for (EClass t : types) { 
						if (type.getName().equals(t.getName())) {
							if (element.getFeature() == null || element.getFeature().size() == 0) {
								Element emptyElement = ModeltextFactory.eINSTANCE.createElement();
								emptyElement.setType(t);
								elements.add(emptyElement);
								continue;
							}
							elements.add(element);
						}
					}
				}
			}
		}
		return elements;
	}

	/**
	 * Gets the corresponding reference element for the give feature
	 * DSL modelText
	 */
	public static Element getRefElement(EObject object, EStructuralFeature feature, Resource model) {
		List<EClass> types = new ArrayList<EClass>();
		types.add(object.eClass());
		types.addAll(object.eClass().getEAllSuperTypes());

		Iterator<EObject> objects = model.getAllContents();

		objects = model.getAllContents();
		while (objects.hasNext()) {
			EObject obj = objects.next();
			if (obj instanceof Element) {
				Element element = (Element) obj;
				if (EcoreUtil.equals(element.getType(), object.eClass())) {
					EClass type = element.getType();
					for (EClass t : types) { 
						if (type.getName().equals(t.getName())) {
							if (element.getFeature() == null || element.getFeature().size() == 0) {
								if (feature != null) {
									if (element.getRef() != null) {
										if (EcoreUtil.equals(element.getRef().getEReferenceType(), feature.getEType())) {
											return element;
										}
									}
								}
								else {
									return element;
								}
							}
						}
					}
				}
			}
		}
		return null;
	}

	public static BasicFileAttributes awaitFile(String target, long timeout) 
		    throws IOException, InterruptedException
	{
	    final java.nio.file.Path name = Paths.get(target).getFileName();
	    final java.nio.file.Path targetDir = Paths.get(target).getParent();

	    // If path already exists, return early
	    try {
	        return Files.readAttributes(Paths.get(target), BasicFileAttributes.class);
	    } catch (NoSuchFileException ex) {}

	    final WatchService watchService = FileSystems.getDefault().newWatchService();
	    try {
	        final WatchKey watchKey = targetDir.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);
	        // The file could have been created in the window between Files.readAttributes and Path.register
	        try {
	            return Files.readAttributes(Paths.get(target), BasicFileAttributes.class);
	        } catch (NoSuchFileException ex) {}
	        // The file is absent: watch events in parent directory 
	        WatchKey watchKey1 = null;
	        boolean valid = true;
	        do {
	            long t0 = System.currentTimeMillis();
	            watchKey1 = watchService.poll(timeout, TimeUnit.MILLISECONDS);
	            if (watchKey1 == null) {
	                return null; // timed out
	            }
	            // Examine events associated with key
	            for (WatchEvent<?> event: watchKey1.pollEvents()) {
	            	java.nio.file.Path path1 = (java.nio.file.Path) event.context();
	                if (path1.getFileName().equals(name)) {
	                    return Files.readAttributes(Paths.get(target), BasicFileAttributes.class);
	                }
	            }
	            // Did not receive an interesting event; re-register key to queue
	            long elapsed = System.currentTimeMillis() - t0;
	            timeout = elapsed < timeout? (timeout - elapsed) : 0L;
	            valid = watchKey1.reset();
	        } while (valid);
	    } finally {
	        watchService.close();
	    }

	    return null;
	}
}