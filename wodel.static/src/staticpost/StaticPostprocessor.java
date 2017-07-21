package staticpost;


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

import postprocessor.run.IPostprocessor;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StaticPostprocessor implements IPostprocessor {

	@Override
	public String getName() {

		return "Static: generates mutants in .json file format";
		// TODO Auto-generated method stub

	}

	@Override
	public boolean doProcess(Resource model, String filename) {
		// TODO Auto-generated method stub
		// EMFJSON
		try {
			Map<String, Object> options = new HashMap<>();
			options.put(EMFJs.OPTION_USE_ID, true);
			ObjectMapper mapper = new ObjectMapper();
			mapper.registerModule(new EMFModule(options));
			JsonNode node = mapper.valueToTree(model);
			String targetname = filename.replace(".model", ".json");
			
			File f = new File(filename);
			if (f.exists()) {
				OutputStream outputStream = new FileOutputStream(targetname);
				Writer writer = new OutputStreamWriter(outputStream);

				writer.write(node.toString());

				writer.close();
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
