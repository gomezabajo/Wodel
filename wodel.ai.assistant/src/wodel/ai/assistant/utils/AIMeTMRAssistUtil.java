package wodel.ai.assistant.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class AIMeTMRAssistUtil {

	public static String readGottenModel(String gottenModelPath) {
	    try {
	        // Read all lines from the file
	        String content = new String(Files.readAllBytes(Paths.get(gottenModelPath)));

	        // Replace actual newline characters with the escaped sequence "\\n"
	        return content.replace("\n", "\\n").replace("\r", "");
	    } catch (IOException e) {
	        e.printStackTrace();
	        return "";
	    }
	}
	
	public static String extractMetamorphicRelation(String line, Scanner scanner) {
		if (line == null || line.length() == 0 || scanner == null) {
			return "";
		}
		String mr = line.trim();
		while (mr.lastIndexOf("]\n") != mr.length() - 2 && scanner.hasNextLine()) {
			mr += scanner.nextLine().trim() + "\n";
		}
		return mr;
	}
	
	public static String getProjectNameFromMM(String mm) {
		String projectName = mm.substring(1, mm.length());
		projectName = projectName.substring(0, projectName.indexOf("/"));
		return projectName;
	}
}
