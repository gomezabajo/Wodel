package wodel.ai.assistant.utils;

import java.util.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import wodel.ai.experiments.ExperimentResult;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;

public class AssistantUtils {
	
	public static ExperimentResult computeExecStats(List<Long> durations, int numModels) {
		// Convert nanoseconds to milliseconds
		List<Double> durationsMs = new ArrayList<>();
		for (long duration : durations) {
			durationsMs.add(duration / 1000000.0);
		}
		
		return new ExperimentResult(durationsMs);
	}
	
    /**
     * Converts an EMF Resource to a local java.io.File if possible.
     * Supports file:// and platform:/resource URIs.
     *
     * @param resource the EMF resource
     * @return the corresponding File, or null if not local
     */
    public static File getLocalFile(Resource resource) {
        if (resource == null || resource.getURI() == null) {
            return null;
        }

        URI uri = resource.getURI();

        if (uri.isFile()) {
            return new File(uri.toFileString());
        } else if (uri.isPlatformResource()) {
            String platformString = uri.toPlatformString(true);
            IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(platformString));
            if (file.exists()) {
                return file.getLocation().toFile();
            }
        }

        // Not a local file
        return null;
    }
    
	public static Resource loadModel(ResourceSet resourceSet, File file) throws Exception {	// TO
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("xmi", new XMIResourceFactoryImpl());
		m.put("model", new XMIResourceFactoryImpl());
		try {
			URI fileUri = URI.createFileURI(file.getAbsolutePath());
			Resource resource = resourceSet.getResource(fileUri, true);				
			return resource;
		} catch (Exception e) {
			System.out.println("Failed to load: " + file.getName());
			System.out.println("Reason: "+e.toString());
			throw e;
		}		
	}
	
	public static String processGPTResponse(String response, String fileType) {
	    String trimmed = response.trim();
	    String fence = "```" + fileType;

	    if (!trimmed.startsWith("```")) 
	        return trimmed;	    

	    int startIdx = fence.length();
	    int endIdx = trimmed.lastIndexOf("```");

	    if (endIdx <= startIdx) 
	        return trimmed;		// no end fence found -> return as is	    

	    String content = trimmed.substring(startIdx, endIdx).trim(); // keep the inner part of fence
	    return content;
	}

	public static String fixName(File file) {
		return fixName(file.getAbsolutePath());
	}
	
	public static String fixName(String fileName) {
		int dotIndex = fileName.lastIndexOf(".");
		String nameWithoutExtension = fileName.substring(0, dotIndex);
        String extension = fileName.substring(dotIndex); // includes the dot
        return nameWithoutExtension + "fix" + extension;
	}
	
	public static String escapeJson(String str) {
        return str.replace("\\", "\\\\")  // Escape backslash
                  .replace("\"", "\\\"")  // Escape double quote
                  .replace("\n", "\\n")  // Escape new line
                  .replace("\r", "\\r")  // Escape carriage return
                  .replace("\t", "\\t"); // Escape tab
    }
	
	public static String buildPath(String... segments) {
	    if (segments == null || segments.length == 0) return "";

	    // Join using the platform rules (handles separators properly)
	    java.nio.file.Path p = Paths.get(segments[0], Arrays.copyOfRange(segments, 1, segments.length)).normalize();
	    String path = p.toString();

	    // On Ubuntu, System.getProperty("os.name") is typically "Linux"
	    if (isLinux() && !path.startsWith(File.separator)) {
	        path = File.separator + path; // adds leading "/"
	    }

	    return path;
	}

	private static boolean isLinux() {
	    String os = System.getProperty("os.name", "");
	    return os.toLowerCase(Locale.ROOT).contains("linux");
	}
	
	public static String loadModelAsString(String path) {
		try {
            return Files.readString(java.nio.file.Path.of(path));
		} catch (IOException e) {
       		e.printStackTrace();
        }
		return "";
	}
}
