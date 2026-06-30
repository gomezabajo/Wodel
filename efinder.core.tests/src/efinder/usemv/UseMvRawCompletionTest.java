package efinder.usemv;

import java.io.ByteArrayInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.junit.BeforeClass;
import org.junit.Test;
import org.tzi.use.api.UseApiException;
import org.tzi.use.api.UseSystemApi;
import org.tzi.use.main.Session;
import org.tzi.use.uml.sys.MSystemState;

import efinder.core.management.EMFModel;
import efinder.core.utils.ResourceUtils;

/**
 * Tests functionality at the USE Validator level, passing 
 * raw USE models to check that they are correctly handled.
 * 
 * @author jesus
 */
public class UseMvRawCompletionTest {

	private String model = "model TestModel\n" + 
			"class Person\n" + 
			"attributes\n" + 
			"  name:String\n" + 
			"  age:Integer\n" + 
			"end\n" + 
			"class Global\n" + 
			"end\n" +
			"constraints\n"
			;
	
	String properties = //"Person = ada\n" + 
			"\n" + 
			"Global_min = 1\n" +
			"Global_max = 1\n" +		
			"Person_min = 0\n" +
			"Person_max = 5\n" +
			"Person_name_min = -1\n" + 
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
		model +=" context g : Global inv global1:\n"
			  + "		Person.allInstances()->size() = 1"
			  + " context p : Person inv age:\n"
			  + "		p.age = 15";
				//+ "		p.age = 18 implies p.alive = true";

		toFile("/tmp/test.use", model);
		toFile("/tmp/test.properties", properties);
		
		TestPartialInputModel partialModel = new TestPartialInputModel();
		UseMvFinder finder = new UseMvFinder().
				withPartialModel(partialModel);
		
		finder.doFind(new ByteArrayInputStream(model.getBytes()), new StringReader(properties));
	
		MSystemState state = partialModel.session.system().state();
		
	}
	
	private void toFile(String fileName, String contents) throws IOException {
		System.out.println(contents);
		System.out.println();
		FileWriter fw = new FileWriter(fileName);
		fw.append(contents);
		fw.close();
	}

	public static class TestPartialInputModel implements IUseInputPartialModel {

		protected Session session;

		@Override
		public void makeUseObjects(Session fSession) {
			if (this.session != null)
				throw new IllegalStateException("Test method must be called only once");
			this.session = fSession;
			
			/**
			 * !create gg : Global
			 * !create p1 : Person
			 * !set p1.name := 'Jack'
			 */
			UseSystemApi sysApi = UseSystemApi.create(fSession);
			try {
				sysApi.createObject("Global", "gg");
				sysApi.createObject("Person", "p1");
			} catch (UseApiException e) {
				throw new IllegalStateException();
			}
		}
		
	}
	
//	@Test
//	public void test() {
//		UseMvFinder finder = new UseMvFinder();	
//		finder.doFind(new ByteArrayInputStream(model.getBytes()), new StringReader(properties));		
//	}

}
