package efinder.usemv;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.StringReader;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.junit.BeforeClass;
import org.junit.Test;

import efinder.core.management.EMFModel;
import efinder.core.utils.ResourceUtils;

/**
 * Tests functionality at the USE Validator level, passing 
 * raw USE models to check that they are correctly handled.
 * 
 * @author jesus
 */
public class UseMvRawTest {

	private String model = "model TestModel\n" + 
			"enum Color {red, green, blue}\n" +
			"class Model\n" +
			"end\n" +
			"class Person\n" + 
			"attributes\n" + 
			"  name:String\n" + 
			"  nicknames:Set(String)\n" + 
			"  bestFriend:Person\n" + 
			"  age:Integer\n" + 
			"  alive:Boolean\n" + 
			"  luckyNumbers:Set(Integer)\n" + 
			"  favoriteColor:Color\n" + 
			"end\n" + 
			"class Company\n" + 
			"end\n" + 
			"class Car\n" + 
			"end\n" + 
			"\n" + 
			"class Animal\n" + 
			"end\n" +
			"class Global\n" + 
			"end\n" +
			"constraints\n"
			+ " context g : Global inv global1:\n"
			+ "		Person.allInstances()->size() = 3"
			;
	
	String properties = //"Person = ada\n" + 
			"\n" + 
			"Global_min = 1\n" +
			"Global_max = 1\n" +

//			"Person_min = 1\n" +
//			"Person_max = 3\n" +
			
			"Person_min = 1\n" +
			"Person_max = 1\n" +

			"Person_name_min = -1\n" + 
			"Person_nicknames_min = -1\n" + 
			"Person_age_min = -1\n" + 
			"Person_alive_min = -1\n" + 
			"Person_luckyNumbers_min = -1\n" + 
			"Person_favoriteColor_min = -1\n" + 
			"\n" + 
			"String_min=10\n" + 
			"\n" + 
			"Integer_min =10\n" + 
			"Integer_max=30";
	
	@BeforeClass
	public static void setUp() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap( ).put("*",  
				new XMIResourceFactoryImpl() {
					public Resource createResource(URI uri) {
						XMIResource xmiResource = new XMIResourceImpl(uri);
						return xmiResource;
					}
				});
	}
	
	@Test
	public void testCompletionWorking() throws Exception {
		model += " context p : Person inv age:\n"
				+ "		p.age = 15";
				//+ "		p.age = 18 implies p.alive = true";

		System.out.println(model);
		System.out.println(properties);
		EMFModel partialModel = ResourceUtils.fromFile("resources/models/people-1.xmi", "resources/metamodels/people.ecore");
		UseMvFinder finder = new UseMvFinder().
				withPartialModel(partialModel);
		
		finder.doFind(new ByteArrayInputStream(model.getBytes()), new StringReader(properties));
	}
	
//	@Test
//	public void test() {
//		UseMvFinder finder = new UseMvFinder();	
//		finder.doFind(new ByteArrayInputStream(model.getBytes()), new StringReader(properties));		
//	}

}
