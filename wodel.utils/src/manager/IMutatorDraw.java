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

public interface IMutatorDraw {
	public void generate() throws MetaModelNotFoundException,
		ModelNotFoundException, FileNotFoundException;

}
