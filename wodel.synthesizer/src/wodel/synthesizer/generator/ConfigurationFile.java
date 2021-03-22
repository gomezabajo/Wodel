package wodel.synthesizer.generator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.AbstractMap.SimpleEntry;

public class ConfigurationFile {
	public Map<String, Integer> numObjects = null;
	public Map<String, SimpleEntry<String, String>> tagsByClass = null;
	public String file = null;
	public String configurationFile = null;
	public String customOCL = null;
	public int numSeeds = -1;
	public boolean forceRoot = true;
	public String[] selectedBlockNames = null; 
	
	public ConfigurationFile(String configurationFile) {
		try {
			File configurationFileAccess = new File(configurationFile);
			FileReader fileReader = new FileReader(configurationFileAccess);
			BufferedReader br = new BufferedReader(fileReader);
			String line = null;
			line = br.readLine();
			this.numSeeds = Integer.parseInt(line.trim());
			line = br.readLine();
			this.forceRoot = Boolean.parseBoolean(line.trim());
			line = br.readLine();
			if (line.contains(",")) {
				this.selectedBlockNames = line.split(",");
			}
			else {
				this.selectedBlockNames = new String[1];
				this.selectedBlockNames[0] = line.trim();
			}
			while ((line = br.readLine()) != null) {
				if (line.contains("#")) {
					if (this.numObjects == null) {
						this.numObjects = new HashMap<String, Integer>();
					}
					String[] values = line.split("#");
					String className = values[0].trim();
					int num = Integer.parseInt(values[1].trim());
					this.numObjects.put(className, num);
				}
				else if (line.contains(":") && !line.startsWith("ocl: ") && !line.startsWith("initial: ")) {
					if (this.tagsByClass == null) {
						this.tagsByClass = new HashMap<String, SimpleEntry<String, String>>();
					}
					String[] values = line.split(":");
					String className = values[0].trim();
					className = className.substring(0, className.indexOf("("));
					String attName = values[0].trim();
					attName = attName.substring(attName.indexOf("(") + 1, attName.indexOf(")"));
					String tags = values[1].trim();
					SimpleEntry<String, String> tagsForAttribute = new SimpleEntry<String, String>(attName, tags);
					this.tagsByClass.put(className, tagsForAttribute);
				}
				else if (line.startsWith("initial: ")) {
					this.file = line.substring("initial: ".length(), line.length());
				}
				else if (line.startsWith("ocl: ")) {
					if (this.customOCL == null) {
						this.customOCL = "";
					}
					this.customOCL += line.substring("ocl: ".length(), line.length());
				}
			}
			br.close();
			fileReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.configurationFile = configurationFile;
	}
}
