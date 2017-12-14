package manager;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author Pablo Gomez-Abajo
 * 
 * Input and output utilities
 * 
 */

public class IOUtils {

	public static void copyFile(String input, String output) {
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
            fr.close();
            fw.close();
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
		file.delete();
	}

	public static void copyFile(File src, File dest) throws IOException {
		
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
}
