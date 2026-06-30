package efinder.tasks;

import java.io.File;

import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import tinytools.metamodel.explicitvisitor.ExplicitVisitorCreator;
import tinytools.metamodel.explicitvisitor.ExplicitVisitorOptions;

public class GenerateVisitor {


	public static void main(String[] args) throws Exception {
		ResourceSet rs = new ResourceSetImpl();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new XMIResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("genmodel", new EcoreResourceFactoryImpl());
		// GenModelPackage.eINSTANCE
		rs.getPackageRegistry().put(GenModelPackage.eINSTANCE.getNsURI(), GenModelPackage.eINSTANCE);
		
		Resource r3 = rs.getResource(URI.createURI("file://" + new File("../plugins/efinder.core/model/efinder.genmodel").getAbsolutePath()), true);
		
		ExplicitVisitorOptions options = new ExplicitVisitorOptions ();
		// options.setBaseDir("tmp_");
		options.setBaseDir(new File("../plugins/efinder.core/src-gen").getAbsolutePath());
		options.setPackagePrefix("efinder.core.visitor");
		options.setVisitorClass("AbstractIRVisitor");
		
		ExplicitVisitorCreator compiler = new ExplicitVisitorCreator();
		compiler.compile(r3, options);
	}

}
