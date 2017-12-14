package manager;

import java.io.FileNotFoundException;

import exceptions.*;

/**
 * @author Pablo Gomez-Abajo
 * 
 * IMutatorGraph interface for the execution
 * of the models graphical representation
 * 
 */

public interface IMutatorGraph {
	public void generate() throws MetaModelNotFoundException,
		ModelNotFoundException, FileNotFoundException;

}
