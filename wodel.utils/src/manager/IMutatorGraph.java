package manager;

import java.io.FileNotFoundException;

import exceptions.*;

public interface IMutatorGraph {
	public void generate() throws MetaModelNotFoundException, ModelNotFoundException, FileNotFoundException;

}
