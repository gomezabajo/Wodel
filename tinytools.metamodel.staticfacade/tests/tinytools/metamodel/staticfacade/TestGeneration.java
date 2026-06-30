package tinytools.metamodel.staticfacade;

import static org.junit.Assert.*;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.impl.EcoreFactoryImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.junit.Test;

public class TestGeneration {

	@Test
	public void testGenerateATL() throws IOException {
		ResourceSet rs = new ResourceSetImpl();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new XMIResourceFactoryImpl());
		
		Resource r = rs.getResource(URI.createURI("tests/tinytools/metamodel/staticfacade/ATL.ecore"), true);
	
		Options options = new Options();
		// options.setBaseDir("tmp_");
		options.setBaseDir("/home/jesus/projects/genericity/compiler/genericity.compiler.atl.typing/atl_wrapper");
		options.setPackagePrefix("atl.metamodel");
		options.setManagerClass("ATLModel");
		options.setVisitable(true);
		
		CompileMetamodel compiler = new CompileMetamodel();
		compiler.compile(r, options);
	}

}
