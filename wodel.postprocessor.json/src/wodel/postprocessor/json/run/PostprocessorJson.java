package wodel.postprocessor.json.run;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.json.JsonMapper.Builder;
import com.fasterxml.jackson.databind.module.SimpleModule;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMLParserPoolImpl;
import org.eclipse.emfcloud.jackson.annotations.JsonAnnotations;
import org.eclipse.emfcloud.jackson.module.EMFModule;
import org.eclipse.emfcloud.jackson.resource.JsonResource;
import org.eclipse.emfcloud.jackson.resource.JsonResourceFactory;

import wodel.postprocessor.run.IPostprocessor;

/**
 * @author Pablo Gomez-Abajo - Wodel postprocessing extension to convert mutants to json format
 * 
 */

public class PostprocessorJson implements IPostprocessor {
	@Override
	public String getName() {

		return "Static: generates mutants in .json file format";
		// TODO Auto-generated method stub

	}
	
	@Override
	public String getURI() {
		return "";
	}

	@Override
	public boolean doProcess(String metamodelpath, List<String> metamodel, Resource model, String filename) {
		// TODO Auto-generated method stub
		// EMFJSON
		try {
			if (!model.isLoaded()) {
				Map<Object, Object> xmlOptions = model.getResourceSet().getLoadOptions();
				xmlOptions.put(XMLResource.OPTION_USE_PARSER_POOL, new XMLParserPoolImpl());
				xmlOptions.put(XMLResource.OPTION_USE_DEPRECATED_METHODS, Boolean.FALSE);
				xmlOptions.put(XMLResource.OPTION_USE_XML_NAME_TO_FEATURE_MAP, new HashMap<Object, Object>());
				xmlOptions.put(XMLResource.OPTION_DEFER_ATTACHMENT, Boolean.TRUE);
				xmlOptions.put(XMLResource.OPTION_DEFER_IDREF_RESOLUTION, Boolean.TRUE);
				model.load(xmlOptions);
			}
			

			
			
//			EMFModule module = new EMFModule(model.getResourceSet(), jacksonOptions);

//			Map<String, Boolean> options = new LinkedHashMap<String, Boolean>();
//			options.put(EMFJs.OPTION_USE_ID, false);
//			options.put(EMFJs.OPTION_INDENT_OUTPUT, true);
			
//			Builder builder = new Builder();
//			Options jacksonOptions = builder.withID(true).build(options);
			
			JsonFactory jsonFactory = JsonFactory.builder()
					.configure(JsonFactory.Feature.CANONICALIZE_FIELD_NAMES, true)
					.build();
			
			SimpleModule module = new EMFModule()
					.configure(EMFModule.Feature.OPTION_USE_ID, false);
			
			ObjectMapper jsonMapper = EMFModule.setupDefaultMapper(jsonFactory)
					.registerModule(module)
					.configure(SerializationFeature.INDENT_OUTPUT, true);

/*
			Builder builder = new Builder(jsonMapper);
			builder.addModule(module).

			JsonAnnotations jacksonOptions = builder.build(options);
*/
			JsonResourceFactory jsonResourceFactory = new JsonResourceFactory(jsonMapper);		

			
			ResourceSet jsonResourceSet = model.getResourceSet();
			jsonResourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("json", jsonResourceFactory);
			Resource jsonResource = jsonResourceSet.createResource(URI.createURI(model.getURI().toString().replace(".model", ".json")));
			jsonResource.getContents().addAll(model.getContents());
			
			JsonNode contents = jsonMapper.valueToTree(jsonResource);
			ObjectWriter writer = jsonMapper.writerWithDefaultPrettyPrinter();
			
			//JsonNode contents = mapper.valueToTree(model);
			
			String targetname = filename.replace(".model", ".json");
			File f = new File(filename);
			if (f.exists()) {
				OutputStream outputStream = new FileOutputStream(targetname);
				writer.writeValue(outputStream, contents);
				outputStream.close();
			}
			model.unload();
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		} catch (IOException e0) {
			// TODO Auto-generated catch block
			e0.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public void setInitializationData(IConfigurationElement config,
			String propertyName, Object data) throws CoreException {
		// TODO Auto-generated method stub
		
	}
}
