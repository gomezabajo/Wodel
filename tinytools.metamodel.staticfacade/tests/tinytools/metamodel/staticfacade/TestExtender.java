package tinytools.metamodel.staticfacade;

import static org.junit.Assert.*;

import java.io.FileOutputStream;
import java.io.IOException;

import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.impl.EcoreFactoryImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.junit.Test;

import tinytools.metamodel.copier.CopierCreator;
import tinytools.metamodel.copier.CopierOptions;
import tinytools.metamodel.extender.Extender;
import tinytools.metamodel.extender.ExtenderOptions;

public class TestExtender {

	@Test
	public void testGenerateATL() throws IOException {
		ResourceSet rs = new ResourceSetImpl();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("genmodel", new EcoreResourceFactoryImpl());
		// GenModelPackage.eINSTANCE
		rs.getPackageRegistry().put(GenModelPackage.eINSTANCE.getNsURI(), GenModelPackage.eINSTANCE);
		
		Resource r = rs.getResource(URI.createURI("file:///home/jesus/projects/genericity/compiler/genericity.compiler.atl.typing/model/ATLStatic.ecore"), true);
		
		ExtenderOptions options = new ExtenderOptions ();
		options.setClassPrefix("X");
		options.addPackageMapping("atlstatic", "atlext");
		
		Extender compiler = new Extender();
		Resource target = compiler.compile(r, options);
		target.save(new FileOutputStream("/home/jesus/projects/genericity/compiler/genericity.compiler.atl.typing/model/ATLExt.ecore"), null);
	}

}
