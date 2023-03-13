package wodel.utils.manager;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Pablo Gomez-Abajo
 * 
 * Input and output utilities
 * 
 */

public class IOUtils {

	public static void copyFile(String input, String output) {
		if (input.equals(output)) {
			return;
		}
		FileReader fr = null;
		FileWriter fw = null;
		try {
			fr = new FileReader(input);
			fw = new FileWriter(output);
			int c = fr.read();
			while(c!=-1) {
				fw.write(c);
				c = fr.read();
			}
			fw.flush();
		} catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			close(fr);
			close(fw);
		}
	}
	
	public static void close(Closeable stream) {
        try {
            if (stream != null) {
                stream.close();
            }
        } catch(IOException e) {
            //...
        }
    }
	
	public static void deleteFile(String filename) {
		File file = new File(filename);
		if (file != null) {
			file.delete();
		}
	}
	
	public static void deleteFolder(String foldername) {
		File folder = new File(foldername);
		if (folder != null) {
			if (folder.isDirectory()) {
				for (File file : folder.listFiles()) {
					if (file.isFile()) {
						file.delete();
					}
					else if (file.isDirectory()) {
						deleteFolder(file.getPath());
					}
				}
			}
			folder.delete();
		}
	}

	public static void deleteFolder(String foldername, List<String> exceptions) {
		File folder = new File(foldername);
		if (folder != null) {
			if (folder.isDirectory()) {
				for (File file : folder.listFiles()) {
					if (file.isFile() && !exceptions.contains(file.getName())) {
						file.delete();
					}
					else if (file.isDirectory()) {
						deleteFolder(file.getPath(), exceptions);
					}
				}
			}
			folder.delete();
		}
	}

	public static void deleteFolder(String foldername, String ext) {
		File folder = new File(foldername);
		if (folder != null) {
			if (folder.isDirectory()) {
				for (File file : folder.listFiles()) {
					if (file.isFile() && file.getName().endsWith("." + ext)) {
						file.delete();
					}
					else if (file.isDirectory()) {
						deleteFolder(file.getPath(), ext);
						if (file.listFiles() == null || file.listFiles().length == 0) {
							file.delete();
						}
					}
				}
			}
		}
	}

	public static void deleteFolder(String foldername, String ext, List<String> exceptions) {
		File folder = new File(foldername);
		if (folder != null) {
			if (folder.isDirectory()) {
				for (File file : folder.listFiles()) {
					if (file.isFile() && file.getName().endsWith("." + ext)) {
						String name = file.getName();
						if (name.indexOf(".") > 0) {
							name = name.substring(0, name.lastIndexOf("."));
						}
						if (!exceptions.contains(name)) {
							file.delete();
						}
					}
					else if (file.isDirectory()) {
						deleteFolder(file.getPath(), ext, exceptions);
						if (file.listFiles() == null || file.listFiles().length == 0) {
							file.delete();
						}
					}
				}
			}
		}
	}

	public static void copyFile(File src, File dest) throws IOException {
		
		if (src.getPath().equals(dest.getPath())) {
			return;
		}
		// if file, then copy it
		// Use bytes stream to support all file types
		InputStream in = new FileInputStream(src);
		OutputStream out = new FileOutputStream(dest);

		byte[] buffer = new byte[1024];

		int length;
		// copy the file content in bytes
		while ((length = in.read(buffer)) > 0) {
			out.write(buffer, 0, length);
		}

		in.close();
		out.close();
	}
	
	public static void copyFolder(File src, File dest) throws IOException {
		
		if (src.getPath().equals(dest.getPath())) {
			return;
		}
		if (src.isDirectory()) {

			// if directory not exists, create it
			if (!dest.exists()) {
				dest.mkdirs();
			}

			// list all the directory contents
			String files[] = src.list();

			for (String file : files) {
				// construct the src and dest file structure
				File srcFile = new File(src, file);
				File destFile = new File(dest, file);
				// recursive copy
				copyFolder(srcFile, destFile);
			}

		} else {
			// if file, then copy it
			// Use bytes stream to support all file types
			InputStream in = new FileInputStream(src);
			OutputStream out = new FileOutputStream(dest);

			byte[] buffer = new byte[1024];

			int length;
			// copy the file content in bytes
			while ((length = in.read(buffer)) > 0) {
				out.write(buffer, 0, length);
			}

			in.close();
			out.close();
		}
	}

	public static void copyFolder(File src, File dest, List<String> exceptions) throws IOException {
		
		if (src.getPath().equals(dest.getPath())) {
			return;
		}
		
		if (src.isDirectory()) {

			// if directory not exists, create it
			if (!dest.exists()) {
				dest.mkdirs();
			}

			// list all the directory contents
			String files[] = src.list();

			for (String file : files) {
				// construct the src and dest file structure
				File srcFile = new File(src, file);
				File destFile = new File(dest, file);
				// recursive copy
				copyFolder(srcFile, destFile, exceptions);
			}

		} else if (!exceptions.contains(src.getName())) {
			// if file, then copy it
			// Use bytes stream to support all file types
			InputStream in = new FileInputStream(src);
			OutputStream out = new FileOutputStream(dest);

			byte[] buffer = new byte[1024];

			int length;
			// copy the file content in bytes
			while ((length = in.read(buffer)) > 0) {
				out.write(buffer, 0, length);
			}

			in.close();
			out.close();
		}
	}

	public static void copyFolder(File src, File dest, String ext) throws IOException {
		
		if (src.getPath().equals(dest.getPath())) {
			return;
		}
		
		if (src.isDirectory()) {

			// if directory not exists, create it
			if (!dest.exists()) {
				dest.mkdirs();
			}

			// list all the directory contents
			String files[] = src.list();

			for (String file : files) {
				// construct the src and dest file structure
				File srcFile = new File(src, file);
				File destFile = new File(dest, file);
				// recursive copy
				copyFolder(srcFile, destFile, ext);
			}

		} else if (src.getName().endsWith("." + ext)) {
			// if file, then copy it
			// Use bytes stream to support all file types
			InputStream in = new FileInputStream(src);
			OutputStream out = new FileOutputStream(dest);

			byte[] buffer = new byte[1024];

			int length;
			// copy the file content in bytes
			while ((length = in.read(buffer)) > 0) {
				out.write(buffer, 0, length);
			}

			in.close();
			out.close();
		}
	}
	
	public static void copyFolder(File src, File dest, String ext, List<String> exceptions) throws IOException {
		
		if (src.getPath().equals(dest.getPath())) {
			return;
		}
		if (src.isDirectory()) {

			// if directory not exists, create it
			if (!dest.exists()) {
				dest.mkdirs();
			}

			// list all the directory contents
			String files[] = src.list();

			for (String file : files) {
				// construct the src and dest file structure
				File srcFile = new File(src, file);
				File destFile = new File(dest, file);
				// recursive copy
				copyFolder(srcFile, destFile, ext, exceptions);
			}

		} else if (src.getName().endsWith("." + ext)) {
			String name = src.getName();
			if (name.indexOf(".") > 0) {
				name = name.substring(0, name.lastIndexOf("."));
			}
			if (!exceptions.contains(name)) {
				// if file, then copy it
				// Use bytes stream to support all file types
				InputStream in = new FileInputStream(src);
				OutputStream out = new FileOutputStream(dest);

				byte[] buffer = new byte[1024];

				int length;
				// copy the file content in bytes
				while ((length = in.read(buffer)) > 0) {
					out.write(buffer, 0, length);
				}

				in.close();
				out.close();
			}
		}
	}

	public static void copyFolderWithReplacements(File src, File dest, List<SimpleEntry<String, String>> replacements) throws IOException {
		
		if (src.getPath().equals(dest.getPath())) {
			return;
		}
		if (src.isDirectory()) {

			// if directory not exists, create it
			if (!dest.exists()) {
				dest.mkdir();
			}

			// list all the directory contents
			String files[] = src.list();

			for (String file : files) {
				// construct the src and dest file structure
				File srcFile = new File(src, file);
				File destFile = new File(dest, file);
				// recursive copy
				copyFolderWithReplacements(srcFile, destFile, replacements);
			}

		} else {
			// if file, then copy it
			// Use bytes stream to support all file types
			InputStream in = new FileInputStream(src);
			OutputStream out = new FileOutputStream(dest);

			byte[] buffer = new byte[1024];

			int length;
			// copy the file content in bytes
			while ((length = in.read(buffer)) > 0) {
				out.write(buffer, 0, length);
			}

			in.close();
			out.close();

			for (SimpleEntry<String, String> replacement: replacements) {
				Scanner scanner = new Scanner(new FileInputStream(dest));
				List<String> lines = new ArrayList<String>();
				while (scanner.hasNextLine()) {
					String line = scanner.nextLine();
					if (line.indexOf(replacement.getKey()) != -1) {
						line = line.replace(replacement.getKey(), replacement.getValue());
					}
					lines.add(line);
				}
				scanner.close();
				if (lines.size() > 0) {
					PrintWriter writer = new PrintWriter(new FileOutputStream(dest));
					for (String l : lines) {
						writer.println(l);
					}
					writer.close();
				}
			}
		}
	}
}
