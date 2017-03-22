package wodel.dsls;

import java.io.IOException;

import mutatorenvironment.MutatorenvironmentPackage;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.serializer.impl.Serializer;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class WodelUtils {

	/**
	 * @param model
	 *            Model one wants to output
	 * @param outputURI
	 *            URI of the new created Model
	 */
	public static void serialize(String xTextURI, String outputURI) {
		EPackage.Registry.INSTANCE.put(MutatorenvironmentPackage.eNS_URI,  MutatorenvironmentPackage.eINSTANCE);
		
		Injector injector = new WodelStandaloneSetup().createInjectorAndDoEMFRegistration();
		ResourceSet xTextRS = injector.getInstance(XtextResourceSet.class);
		System.out.println("xTextURI: " + xTextURI);
		System.out.println("outputURI: " + outputURI);
		XtextResource xtextInput = (XtextResource)xTextRS.getResource(URI.createURI(xTextURI), true);
		EcoreUtil.resolveAll(xtextInput);
		
		//create an empty xmi resource
		ResourceSet xmiRS = new ResourceSetImpl();
		Resource xmiOutput = xmiRS.createResource(URI.createURI(outputURI));
		
		xmiOutput.getContents().add(xtextInput.getContents().get(0));
		try {
			xmiOutput.save(null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("restriction")
	public static String deserialize(EObject eObject) {
		Injector injector = Guice.createInjector(new  wodel.dsls.WodelRuntimeModule());  
		Serializer serializer = injector.getInstance(Serializer.class);  
		return serializer.serialize(eObject);
	}
}
