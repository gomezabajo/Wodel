package wodel.utils.manager;

import java.io.FileNotFoundException;

import wodel.utils.exceptions.MetaModelNotFoundException;
import wodel.utils.exceptions.ModelNotFoundException;

/**
 * @author Pablo Gomez-Abajo
 * 
 * IMutatorGraph interface for the execution
 * of the models graphical representation
 * 
 */

public interface IMutatorDraw {
	public void generate() throws MetaModelNotFoundException,
		ModelNotFoundException, FileNotFoundException;

}
