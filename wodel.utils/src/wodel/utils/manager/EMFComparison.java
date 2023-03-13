package wodel.utils.manager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class EMFComparison {
	
	private static boolean equals (EObject source, EObject target, List<EObject> elemequals) {
		List<Object> objectequals = new ArrayList<Object>();
		Object valuesrc = null;
		Object valuetar = null;
		// attribute equals
		for (EAttribute srcatt : source.eClass().getEAllAttributes()) {
			if ((valuesrc = source.eGet(srcatt)) != null) {
				if (srcatt.isMany()) {
					for (Object srcelem : (EList<?>) valuesrc) {
						for (EAttribute taratt : target.eClass().getEAllAttributes()) {
							if ((valuetar = target.eGet(taratt)) != null) {
								if (taratt.isMany()) {
									for (Object tarelem : (EList<?>) valuetar) {
										if (srcelem.equals(tarelem) && !objectequals.contains(srcelem)) {
											objectequals.add(srcelem);
										}
									}
								}
							}
						}
						if (!objectequals.contains(srcelem)) {
							return false;
						}
					}
				}
				else {
					Object srcelem = valuesrc;
					for (EAttribute taratt : target.eClass().getEAllAttributes()) {
						if ((valuetar = target.eGet(taratt)) != null) {
							if (!taratt.isMany()) {
								Object tarelem = valuetar;
								if (srcelem.equals(tarelem) && !objectequals.contains(srcelem)) {
									objectequals.add(srcelem);
								}
							}
						}
					}
					if (!objectequals.contains(srcelem)) {
						return false;
					}
				}
			}
		}
	
		// reference equals
		for (EReference srcref : source.eClass().getEAllReferences()) {
			if ((valuesrc = source.eGet(srcref)) != null) {
				if (srcref.isContainment()) {
					if (srcref.isMany()) {
						List<EObject> srcelems = new ArrayList<EObject>();
						srcelems.addAll((EList<EObject>) valuesrc);
						for (EObject srcelem : srcelems) {
							if (!elemequals.contains(srcelem)) {
								for (EReference tarref : target.eClass().getEAllReferences()) {
									if ((valuetar = target.eGet(tarref)) != null) {
										if (tarref.isContainment()) {
											if (tarref.isMany()) {
												List<EObject> tarelems = new ArrayList<EObject>();
												tarelems.addAll((EList<EObject>) valuetar);
												for (EObject tarelem : tarelems) {
													equals(srcelem, tarelem, elemequals);
												}
											}
										}
									}
								}
							}
							if (!elemequals.contains(srcelem)) {
								return false;
							}
						}
					}
				}
				else if (srcref.getEOpposite() == null) {
					if (srcref.isMany()) {
						List<EObject> srcelems = new ArrayList<EObject>();
						srcelems.addAll((EList<EObject>) valuesrc);
						for (EObject srcelem : srcelems) {
							if (!elemequals.contains(srcelem)) {
								for (EReference tarref : target.eClass().getEAllReferences()) {
									if ((valuetar = target.eGet(tarref)) != null) {
										if (!tarref.isContainment() && tarref.getEOpposite() == null) {
											if (tarref.isMany()) {
												List<EObject> tarelems = new ArrayList<EObject>();
												tarelems.addAll((EList<EObject>) valuetar);
												for (EObject tarelem : tarelems) {
													equals(srcelem, tarelem, elemequals);
												}
											}
										}
									}
								}
							}
							if (!elemequals.contains(srcelem)) {
								return false;
							}
						}
					}
					else if (valuesrc instanceof EObject) { 
						if (!elemequals.contains(valuesrc)) {
							if (srcref.getEOpposite() != null) {
							    if (srcref.getEOpposite().isMany()) {
									valuesrc = source.eGet(srcref.getEOpposite());
									List<EObject> srcelems = new ArrayList<EObject>();
									srcelems.addAll((EList<EObject>) valuesrc);
									for (EObject srcelem : srcelems) {
										if (!elemequals.contains(srcelem)) {
											for (EReference tarref : target.eClass().getEAllReferences()) {
												if ((valuetar = target.eGet(tarref)) != null) {
													if (!tarref.isContainment() && tarref.getEOpposite() != null && valuetar instanceof EObject) {
														valuetar = target.eGet(tarref.getEOpposite());
														List<EObject> tarelems = new ArrayList<EObject>();
														tarelems.addAll((EList<EObject>) valuetar);
														for (EObject tarelem : tarelems) {
															equals(srcelem, tarelem, elemequals);
														}
													}
												}
											}
										}
										if (!elemequals.contains(srcelem)) {
											return false;
										}
									}
								}
								else {
									valuesrc = source.eGet(srcref.getEOpposite());
									EObject srcelem = (EObject) valuesrc;
									if (!elemequals.contains(srcelem)) {
										for (EReference tarref : target.eClass().getEAllReferences()) {
											if ((valuetar = target.eGet(tarref)) != null) {
												EObject tarelem = (EObject) valuetar;
												equals(srcelem, tarelem, elemequals);
											}
										}
									}
									if (!elemequals.contains(srcelem)) {
										return false;
									}
								}
							}
						}
					}
				}
			}
		}
		if (!elemequals.contains(source)) {
			elemequals.add(source);
		}
		return true;
	}

	public static boolean equals (EObject source, EObject target) {
		if (source == null || target == null) {
			return false;
		}
		if (EcoreUtil.equals(source, target)) {
			return true;
		}
		
		List<EObject> objectequals = new ArrayList<EObject>();
		return equals(source, target, objectequals);
	}
	
	public static boolean equals (Resource source, Resource target) {
		List<EObject> objectequals = new ArrayList<EObject>();

		// object equals
		Iterator<EObject> itsrc = source.getAllContents();
		while (itsrc.hasNext()) { 
			EObject src = itsrc.next();
			Iterator<EObject> ittar = target.getAllContents();
			while (ittar.hasNext()) {
				EObject tar = ittar.next();
				if (equals(src, tar) && !objectequals.contains(src)) {
					objectequals.add(src);
				}
			}
			if (!objectequals.contains(src)) {
				return false;
			}
		}		
		return true;
	}	
}
