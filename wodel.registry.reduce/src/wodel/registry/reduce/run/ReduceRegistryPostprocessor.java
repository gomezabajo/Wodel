package wodel.registry.reduce.run;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import wodel.utils.manager.ModelManager;
import wodel.utils.manager.MutatorUtils;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osgi.framework.Bundle;

import wodel.registry.run.IRegistryPostprocessor;
import wodel.utils.exceptions.MetaModelNotFoundException;
import wodel.utils.exceptions.ModelNotFoundException;
import appliedMutations.AppMutation;
import appliedMutations.AppliedMutationsFactory;
import appliedMutations.AttributeChanged;
import appliedMutations.AttributeSwap;
import appliedMutations.InformationChanged;
import appliedMutations.Mutations;
import appliedMutations.ObjectCreated;
import appliedMutations.ObjectRemoved;
import appliedMutations.ObjectRetyped;
import appliedMutations.ReferenceChanged;
import appliedMutations.ReferenceCreated;
import appliedMutations.ReferenceRemoved;
import appliedMutations.ReferenceSwap;
import appliedMutations.SourceReferenceChanged;
import appliedMutations.TargetReferenceChanged;

/**
 * @author Pablo Gomez-Abajo - Wodel compact registry extension
 * 
 */
public class ReduceRegistryPostprocessor implements IRegistryPostprocessor {

	@Override
	public String getName() {
		return "Reduce registry: compose applied mutations in generated registry models";
		// TODO Auto-generated method stub
	}
	
	private void processRegistry(AppMutation mut, HashMap<EObject, HashMap<String, List<AppMutation>>> dependencies, Resource seed, Resource mutant) {
		HashMap<String, List<AppMutation>> dependency = null;
		List<AppMutation> lmut = null;
		EList<EObject> objs = null;
		EObject obj = null;
		EObject o = null;
		if (mut instanceof ObjectCreated) {
			objs = ((ObjectCreated) mut).getObject();
			if (objs.size() > 0) {
				obj = objs.get(0);
				o = ModelManager.getObject(mutant, obj);
			}
		}
		if (mut instanceof ObjectRemoved) {
			objs = ((ObjectRemoved) mut).getObject();
			if (objs.size() > 0) {
				obj = objs.get(0);
				o = ModelManager.getObject(seed, obj);
			}
		}
		if (mut instanceof ObjectRetyped) {
			objs = ((ObjectRetyped) mut).getObject();
			if (objs.size() > 0) {
				obj = objs.get(0);
				o = ModelManager.getObject(mutant, obj);
			}
		}
		if (mut instanceof ReferenceCreated) {
			objs = ((ReferenceCreated) mut).getObject();
			if (objs.size() > 0) {
				obj = objs.get(0);
				o = ModelManager.getObject(mutant, obj);
			}
		}
		if (mut instanceof ReferenceRemoved) {
			objs = ((ReferenceRemoved) mut).getObject();
			if (objs.size() > 0) {
				obj = objs.get(0);
				o = ModelManager.getObject(seed, obj);
			}
		}
		if (mut instanceof TargetReferenceChanged) {
			objs = ((TargetReferenceChanged) mut).getObject();
			if (objs.size() > 0) {
				obj = objs.get(0);
				o = obj;
			}
		}
		if (mut instanceof SourceReferenceChanged) {
			objs = ((SourceReferenceChanged) mut).getObject();
			if (objs.size() > 0) {
				obj = objs.get(0);
				o = obj;
			}
		}
		if (mut instanceof InformationChanged) {
			obj = ((InformationChanged) mut).getObject();
			o = obj;
		}
		if (mut instanceof ReferenceSwap) {
			objs = ((ReferenceSwap) mut).getObject();
			if (objs.size() > 0) {
				obj = objs.get(0);
				o = obj;
			}
		}
		if (o != null) {
			if (obj != null) {
				if (dependencies.get(obj) == null) {
					dependency = new HashMap<String, List<AppMutation>>();
					lmut = new ArrayList<AppMutation>();
				}
				else {
					dependency = dependencies.get(obj);
					if (dependency.get(mut.eClass().getName()) == null) {
						lmut = new ArrayList<AppMutation>();
					}
					else {
						lmut = dependency.get(mut.eClass().getName());
					}
				}
				lmut.add(mut);
				dependency.put(mut.eClass().getName(), lmut);
				dependencies.put(obj, dependency);
			}
		}
	}
	
	private void reduceRegistry(HashMap<String, List<AppMutation>> dependency, Mutations muts) {
		if (dependency != null) {
			if (dependency.get("ObjectCreated") != null) {
				List<AppMutation> lmut = dependency.get("ObjectCreated");
				muts.getMuts().add(lmut.get(0));
			}
			if (dependency.get("ObjectRemoved") != null) {
				List<AppMutation> lmut = dependency.get("ObjectRemoved");
				muts.getMuts().add(lmut.get(0));
			}
			if (dependency.get("ObjectRetyped") != null) {
				List<AppMutation> lmut = dependency.get("ObjectRetyped");
				muts.getMuts().add(lmut.get(0));
			}
			if (dependency.get("ReferenceCreated") != null) {
				List<AppMutation> lmut = dependency.get("ReferenceCreated");
				muts.getMuts().add(lmut.get(0));
			}
			if (dependency.get("ReferenceRemoved") != null) {
				List<AppMutation> lmut = dependency.get("ReferenceRemoved");
				muts.getMuts().add(lmut.get(0));
			}
			if (dependency.get("TargetReferenceChanged") != null) {
				List<AppMutation> lmut = dependency.get("TargetReferenceChanged");
				muts.getMuts().add(lmut.get(lmut.size() - 1));
			}
			if (dependency.get("SourceReferenceChanged") != null) {
				List<AppMutation> lmut = dependency.get("SourceReferenceChanged");
				muts.getMuts().add(lmut.get(lmut.size() - 1));
			}
			if (dependency.get("InformationChanged") != null) {
				List<AppMutation> lmut = dependency.get("InformationChanged");
				HashMap<String, String[]> catts = new HashMap<String, String[]>();
				ArrayList<Object[]> satts = new ArrayList<Object[]>();
				ArrayList<Object[]> srefs = new ArrayList<Object[]>();
				//ATTRIBUTE CHANGE AND SWAP REFERENCES
				for (AppMutation mut : lmut) {
					InformationChanged ic = (InformationChanged) mut;
					EList<AttributeChanged> atts = ic.getAttChanges();
					if (atts.size() > 0) {
						if (atts.get(0) instanceof AttributeSwap) {
							Object[] attobjs = new Object[6];
							AttributeSwap as = (AttributeSwap) atts.get(0);
							attobjs[0] = ic.getObject();
							attobjs[1] = as.getAttObject();
							attobjs[2] = as.getAttName();
							attobjs[3] = as.getFirstName();
							attobjs[4] = as.getNewVal();
							attobjs[5] = as.getOldVal();
							satts.add(attobjs);
						}
						else {
							String[] vals = new String[2];
							if (catts.get(atts.get(0).getAttName()) != null) {
								vals[0] = (String) catts.get(atts.get(0).getAttName())[0];
							}
							else {
								vals[0] = atts.get(0).getOldVal();
							}
							vals[1] = atts.get(0).getNewVal();
							catts.put(atts.get(0).getAttName(), vals);
						}
					}
					EList<ReferenceChanged> refs = ic.getRefChanges();
					if (refs.size() > 0) {
						if (refs.get(0) instanceof ReferenceSwap) {
							Object[] refobjs = new Object[11];
							ReferenceSwap rs = (ReferenceSwap) refs.get(0);
							refobjs[0] = ic.getObject();
							refobjs[1] = rs.getRefObject();
							refobjs[2] = rs.getFirstName();
							refobjs[3] = rs.getRefName();
							refobjs[4] = rs.getFrom();
							refobjs[5] = rs.getOtherFrom();
							refobjs[6] = rs.getOtherFromName();
							refobjs[7] = rs.getOtherTo();
							refobjs[8] = rs.getOtherToName();
							refobjs[9] = rs.getSrcRefName();
							refobjs[10] = rs.getTo();
							srefs.add(refobjs);
						}
					}
				}
				
				InformationChanged ic = AppliedMutationsFactory.eINSTANCE.createInformationChanged();
				if (lmut.size() > 0) {
					ic.setDef(((InformationChanged) lmut.get(0)).getDef());
					ic.setObject(((InformationChanged) lmut.get(0)).getObject());
					for (String attname : catts.keySet()) {
						if (catts.get(attname)[0].equals(catts.get(attname)[1]) != true) {
							AttributeChanged att = AppliedMutationsFactory.eINSTANCE.createAttributeChanged();
							att.setDef(((InformationChanged) lmut.get(0)).getDef());
							att.setAttName(attname);
							att.setOldVal(catts.get(attname)[0]);
							att.setNewVal(catts.get(attname)[1]);
							ic.getAttChanges().add(att);
						}
					}
					boolean[] checked = new boolean[satts.size()];
					for (int i = 0; i < checked.length; i++) {
						checked[i] = false;
					}
					for (int i = 0; i < satts.size(); i++) {
						if (checked[i] == false) {
							for (int j = i + 1; j < satts.size(); j++) {
								if (checked[j] == false) {
									if (EcoreUtil.equals((EObject) satts.get(i)[0], (EObject) satts.get(j)[0]) &&
											(EcoreUtil.equals((EObject) satts.get(i)[1], (EObject) satts.get(j)[1]) || satts.get(j)[1] == null) &&
											((String) satts.get(i)[2]).equals((String) satts.get(j)[2]) &&
											((String) satts.get(i)[3]).equals((String) satts.get(j)[3])) {
										checked[i] = true;
										checked[j] = true;
										continue;
									}
								}
							}
						}
					}
					for (int i = 0; i < satts.size(); i++) {
						if (checked[i] == false) {
							AttributeSwap att = AppliedMutationsFactory.eINSTANCE.createAttributeSwap();
							att.setDef(((InformationChanged) lmut.get(0)).getDef());
							att.setAttObject((EObject) satts.get(i)[1]);
							att.setAttName((String) satts.get(i)[2]);
							att.setFirstName((String) satts.get(i)[3]);
							att.setNewVal((String) satts.get(i)[4]);
							att.setOldVal((String) satts.get(i)[5]);
							
							ic.getAttChanges().add(att);
						}
					}
					checked = new boolean[srefs.size()];
					for (int i = 0; i < checked.length; i++) {
						checked[i] = false;
					}
					for (int i = 0; i < srefs.size(); i++) {
						if (checked[i] == false) {
							for (int j = i + 1; j < srefs.size(); j++) {
								if (checked[j] == false) {
									if (EcoreUtil.equals((EObject) srefs.get(i)[0], (EObject) srefs.get(j)[0]) &&
											((String) srefs.get(i)[2]).equals((String) srefs.get(j)[2]) &&
											((String) srefs.get(i)[3]).equals((String) srefs.get(j)[3]) &&
											EcoreUtil.equals((EObject) srefs.get(i)[4], (EObject) srefs.get(j)[10]) &&
											EcoreUtil.equals((EObject) srefs.get(i)[10], (EObject) srefs.get(j)[4]) &&
											EcoreUtil.equals((EObject) srefs.get(i)[5], (EObject) srefs.get(j)[5]) &&
											EcoreUtil.equals((EObject) srefs.get(i)[7], (EObject) srefs.get(j)[7])) {
										checked[i] = true;
										checked[j] = true;
										continue;
									}
								}
							}
						}
					}
					for (int i = 0; i < srefs.size(); i++) {
						if (checked[i] == false) {
							ReferenceSwap ref = AppliedMutationsFactory.eINSTANCE.createReferenceSwap();
							ref.setDef(((InformationChanged) lmut.get(0)).getDef());
							ref.setRefObject((EObject) srefs.get(i)[1]);
							ref.setFirstName((String) srefs.get(i)[2]);
							ref.setRefName((String) srefs.get(i)[3]);
							ref.setFrom((EObject) srefs.get(i)[4]);
							ref.setOtherFrom((EObject) srefs.get(i)[5]);
							ref.setOtherFromName((String) srefs.get(i)[6]);
							ref.setOtherTo((EObject) srefs.get(i)[7]);
							ref.setOtherToName((String) srefs.get(i)[8]);
							ref.setSrcRefName((String) srefs.get(i)[9]);
							ref.setTo((EObject) srefs.get(i)[10]);
							
							ic.getRefChanges().add(ref);
						}
					}
				}
				if ((ic.getAttChanges().size() > 0) || ic.getRefChanges().size() > 0) {
					muts.getMuts().add(ic);
				}
			}
		}
	}

	@Override
	public boolean doProcess(Resource seed, Resource mutant, String filename) {
		try {
			Bundle bundle = Platform.getBundle("wodel.models");
	   		URL fileURL = bundle.getEntry("/model/AppliedMutations.ecore");
	   		String ecore = FileLocator.resolve(fileURL).getFile();
	   		
			List<EPackage> packages = ModelManager.loadMetaModel(ecore);
			Resource registry = ModelManager.loadModel(packages, filename);
			
			List<EObject> objs = MutatorUtils.getMutations(ModelManager.getAllObjects(registry));
			
			Mutations muts = AppliedMutationsFactory.eINSTANCE.createMutations();
			HashMap<EObject, HashMap<String, List<AppMutation>>> dependencies = new HashMap<EObject, HashMap<String, List<AppMutation>>>();
			for (EObject obj : objs) {
				processRegistry((AppMutation) obj, dependencies, seed, mutant);
			}
			
			for (EObject obj : dependencies.keySet()) {
				reduceRegistry(dependencies.get(obj), muts);
			}
			
			ModelManager.createModel(muts, filename);
			
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setInitializationData(IConfigurationElement config,
			String propertyName, Object data) throws CoreException {
		// TODO Auto-generated method stub
		
	}
}