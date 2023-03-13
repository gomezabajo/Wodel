package wodeltest.optimiser.subsumption.run;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;

import wodel.utils.manager.IWodelTest;
import wodel.utils.manager.ModelManager;
import wodel.utils.manager.WodelTestClass;
import wodel.utils.manager.WodelTestClassInfo;
import wodel.utils.manager.WodelTestResultInfo;
import wodel.utils.manager.WodelTestUtils;
import wodeltest.optimiser.run.MutationOptimiser;
import wodeltest.run.utils.MutatorHelper;

public class SubsumptionMutationOptimiser extends MutationOptimiser {

	private class SubsumedMutantsData {
		public WodelTestClassInfo mutant;
		public List<WodelTestClassInfo> subsumed;
		public int max;
		
		public SubsumedMutantsData() {
		}
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Wodel-Test subsumption mutation optimiser";
	}

	@Override
	public String getURI() {
		// TODO Auto-generated method stub
		return "";
	}

	private List<WodelTestClassInfo> getKilledMutants(List<WodelTestClassInfo> remaining) {
		List<WodelTestClassInfo> killed = new ArrayList<WodelTestClassInfo>();
	    for (WodelTestClassInfo info : remaining) {
	    	if (info.tests != null && info.tests.size() > 0) {
	    		for (WodelTestResultInfo t : info.tests) {
	    			if (t.value == true) {
	    				boolean found = false;
	    				for (WodelTestClassInfo k : killed) {
	    					if (k.path.equals(info.path)) {
	    						found = true;
	    						break;
	    					}
	    				}
	    				if (found == false) {
	    					killed.add(info);
	    					break;
	    				}
	    			}
	    		}
	    	}
		}
	    return killed;
	}

	private SubsumedMutantsData subsumeMutants(List<WodelTestClassInfo> remaining) {
		// Gets the most subsuming mutant
	    WodelTestClassInfo mutant = null;
	    List<WodelTestClassInfo> subsumedMutants = new ArrayList<WodelTestClassInfo>();
	    int max = Integer.MIN_VALUE;
	    for (WodelTestClassInfo info : remaining) {
	    	List<String> failed = new ArrayList<String>();
	    	if (info.tests != null && info.tests.size() > 0) {
	    		for (WodelTestResultInfo t : info.tests) {
	    			if (t.value == true) {
	    				failed.add(t.name);
	    			}
	    		}
	    	}
	    	if (failed.size() > 0) {
	    		List<WodelTestClassInfo> iterable = new ArrayList<WodelTestClassInfo>();
	    		iterable.addAll(remaining);
	    		iterable.remove(info);
	    		int counter = 0;
	    		List<WodelTestClassInfo> subsumedMutators = new ArrayList<WodelTestClassInfo>();
	    		for (WodelTestClassInfo nested : iterable) {
	    			List<String> nestedFailed = new ArrayList<String>();
	    			if (nested.tests != null && nested.tests.size() > 0) {
	    				for (WodelTestResultInfo t : nested.tests) {
	    					if (t.value == true) {
	    						nestedFailed.add(t.name);
	    					}
	    				}
	    			}
	    			if (nestedFailed.size() > 0) {
	    				boolean subsumed = true;
	    				for (String t : failed) {
	    					if (!nestedFailed.contains(t) ) {
	    						subsumed = false;
	    						break;
	    					}
	    				}
	    				if (subsumed == true) {
	    					boolean already = false;
	    					for (WodelTestClassInfo subsumedMutator : subsumedMutators) {
	    						if (subsumedMutator.path.equals(nested.path)) {
	    							already = true;
	    							break;
	    						}
	    					}
	    					if (already == false) {
	    						subsumedMutators.add(nested);
	    						counter++;
	    					}
	    				}
	    			}
	    		}
	    		if (max < counter) {
	    			max = counter;
	    			mutant = info;
	    			subsumedMutants.clear();
	    			subsumedMutants.addAll(subsumedMutators);
	    		}
	    	}
	    }
	    SubsumedMutantsData subsumed = new SubsumedMutantsData();
	    subsumed.mutant = mutant;
	    subsumed.subsumed = subsumedMutants;
	    subsumed.max = max;
		return subsumed;
	}
	
	@Override
	public boolean doOptimise(IProject project) {
		String path = ModelManager.getWorkspaceAbsolutePath().replace("\\\\", "/") + "/" + project.getFullPath().toFile().getPath().toString();
	    IWodelTest test = MutatorHelper.getTest(project);
		
	    String classespath = path + "/data/classes.txt";
	    String infopath = ModelManager.getWorkspaceAbsolutePath().replace("\\\\", "/") + "/" + project.getFullPath().toFile().getPath().toString() + "/data/classes.results.txt";
	    Map<String, List<WodelTestClass>> packageClasses = WodelTestUtils.getPackageClasses(test, project.getName(), classespath, infopath);
	    List<WodelTestClassInfo> killed = new ArrayList<WodelTestClassInfo>();
	    List<WodelTestClassInfo> subsuming = new ArrayList<WodelTestClassInfo>();
		for (String key : packageClasses.keySet()) {
			List<WodelTestClass> classes = packageClasses.get(key);
			for (WodelTestClass mut : classes) {
				int killedSize = 0;
				int aliveSize = 0;
				if (mut.info.size() > 0) {
					mut.info.remove(0);
					killed.addAll(getKilledMutants(mut.info));
					killedSize = killed.size();
					aliveSize = mut.info.size() - killedSize;
				}
				while (killed.size() > 0) {
					SubsumedMutantsData subsumedMutants = subsumeMutants(killed);
					List<WodelTestClassInfo> killedTmp = new ArrayList<WodelTestClassInfo>();
					if (subsumedMutants.mutant != null) {
						subsuming.add(subsumedMutants.mutant);
						killed.remove(subsumedMutants.mutant);
						killedTmp.addAll(killed);
						for (WodelTestClassInfo mutator : subsumedMutants.subsumed) {
							for (WodelTestClassInfo m : killed) {
								if (m.path.equals(mutator.path)) {
									killedTmp.remove(m);
									break;
								}
							}
						}
					}
					killed.clear();
					killed.addAll(killedTmp);
				}
				System.out.println("PROCESS FINISHED: " + subsuming.size() + " subsuming mutants found from a total of " + killedSize + " killed mutants.");
				DecimalFormat formatter = new DecimalFormat("###.##%");
				double subsumingMutationScore = 1.0 * subsuming.size() / (subsuming.size() + aliveSize);
				System.out.println("Subsuming mutation score: " + formatter.format(subsumingMutationScore));
			}
		}
		
		return true;
	}
}
