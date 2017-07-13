package manager;

import java.io.Closeable;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
}
