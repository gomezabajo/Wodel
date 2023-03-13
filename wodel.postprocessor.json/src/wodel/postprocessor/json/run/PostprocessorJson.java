package wodel.postprocessor.json.run;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.ecore.resource.Resource;
import org.emfjson.EMFJs;
import org.emfjson.jackson.module.EMFModule;
import org.emfjson.jackson.JacksonOptions;
import org.emfjson.jackson.JacksonOptions.Builder;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	public boolean doProcess(String metamodelpath, String metamodel, Resource model, String filename) {
		// TODO Auto-generated method stub
		// EMFJSON
		try {
			Builder builder = new Builder();
			Map<String, Boolean> options = new HashMap<String, Boolean>();
			options.put(EMFJs.OPTION_USE_ID, true);
			options.put(EMFJs.OPTION_INDENT_OUTPUT, true);
			JacksonOptions jacksonOptions = builder.build(options);
			
			ObjectMapper mapper = new ObjectMapper();
			mapper.registerModule(new EMFModule(model.getResourceSet(), jacksonOptions));
			JsonNode node = mapper.valueToTree(model);
			String targetname = filename.replace(".model", ".json");
			
			File f = new File(filename);
			if (f.exists()) {
				OutputStream outputStream = new FileOutputStream(targetname);
				Writer writer = new OutputStreamWriter(outputStream);

				writer.write(node.toString());

				writer.close();
				outputStream.close();
			}
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
