package wodel.utils.commands.selection.strategies;

import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * @author Pablo Gomez-Abajo
 * 
 * SpecificSelection selects an specific object
 *  
 * This class was started by Victor Lopez Rivero.
 * Since March, 2015 it is continued by Pablo Gomez Abajo.
 *  
 */
public abstract class SpecificSelection extends ObSelectionStrategy{
	
	public SpecificSelection(List<EPackage> metaModel, Resource model){
		super(metaModel, model);
	}

	public SpecificSelection(List<EPackage> metaModel, List<Resource> models){
		super(metaModel, models);
	}

}
