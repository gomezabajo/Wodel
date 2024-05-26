package statistics;

import java.io.FileWriter;
import java.io.IOException;

public class ConvertToCSV {
	public static void writeCSV(String file, String[] header, String[][] data) {
		FileWriter fw = null;
		try {
			fw = new FileWriter(file);
			String head = "";
			for (String h : header) {
				head += h + "; ";
			}
			head = head.substring(0, head.lastIndexOf(";"));
			fw.write(head);
			fw.write("\n");
			for (String[] dataLine : data) {
				String dt = "";
				for (String d : dataLine) {
					dt += d + "; ";
				}
				dt = dt.substring(0, dt.lastIndexOf(";"));
				fw.write(dt);
				fw.write("\n");
			}
			fw.flush();
		} catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			IOUtils.close(fw);
		}
		
    }
}
