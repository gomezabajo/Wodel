package wodel.ai.experiments;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.security.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.*;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

public class DuplicateXMIChecker {

	public static void main(String[] args) {
		String folderPath = "data//cloud//follow_ups//model_4_racksb//mr5";
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap()
	    		.put("ecore", new XMIResourceFactoryImpl());
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.getResource(URI.createURI("data//cloud//datac.ecore"), true);

		// Register the package
		EPackage ePackage = (EPackage) resource.getContents().get(0);
		EPackage.Registry.INSTANCE.put(ePackage.getNsURI(), ePackage);
		//checkForDuplicateModels(folderPath);
		int numUnique = countUniqueFiles(folderPath); // just use text comparison
		System.out.println(numUnique + " unique files");
	}

	public static int countUniqueFiles(String folderPath) {
	    Set<String> hashes = new HashSet<>();
	    
	    try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(folderPath), "*.xmi")) {
	        for (Path file : stream) {
	            String content = Files.readString(file);
	            String hash = hashString(content);
	            hashes.add(hash);
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    
	    return hashes.size();
	}

	private static String hashString(String input) {
	    try {
	        MessageDigest md = MessageDigest.getInstance("SHA-256");
	        byte[] hashBytes = md.digest(input.getBytes());
	        StringBuilder sb = new StringBuilder();
	        for (byte b : hashBytes) {
	            sb.append(String.format("%02x", b));
	        }
	        return sb.toString();
	    } catch (NoSuchAlgorithmException e) {
	        throw new RuntimeException("SHA-256 not available", e);
	    }
	}
	
	public static void checkForDuplicateModels(String folderPath) {
		// Register the XMI resource factory for ".xmi" extension
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("xmi", new XMIResourceFactoryImpl());

		ResourceSet resourceSet = new ResourceSetImpl();
		File folder = new File(folderPath);
		File[] files = folder.listFiles((dir, name) -> name.endsWith(".xmi"));

		if (files == null || files.length == 0) {
			System.out.println("No .xmi files found.");
			return;
		}

		Map<String, String> hashToFile = new HashMap<>();
		boolean duplicatesFound = false;

		for (File file : files) {
			try {
				URI fileUri = URI.createFileURI(file.getAbsolutePath());
				Resource resource = resourceSet.getResource(fileUri, true);
				String serialized = serializeEObject(resource.getContents());
				String hash = Integer.toString(serialized.hashCode());

				if (hashToFile.containsKey(hash)) {
					System.out.println("Duplicate found:");
					System.out.println(" - " + file.getName());
					System.out.println(" - " + hashToFile.get(hash));
					duplicatesFound = true;
				} else {
					hashToFile.put(hash, file.getName());
				}

			} catch (Exception e) {
				System.err.println("Failed to load: " + file.getName());
				e.printStackTrace();
			}
		}

		if (!duplicatesFound) {
			System.out.println("No duplicates found.");
		}
	}

	private static String serializeEObject(List<EObject> contents) throws IOException {
		// Very simple string-based serialization
		StringBuilder sb = new StringBuilder();
		for (EObject obj : contents) {
			sb.append(obj.toString()); 
		}
		return sb.toString();
	}
}

