package wodel.utils.manager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WodelTestGlobalResult {
	
	public enum Status {
		ERROR,
		OK,
		EXCEPTION
	}

	private List<WodelTestResultClass> results = null;
	private int numTestsExecuted = 0;
	private int numTestsFailed = 0;
	private int numTestsError = 0;
	private Status status = Status.OK;
	
	public List<WodelTestResultClass> getResults() {
		return results;
	}
	
	public void addResult(WodelTestResultClass wtrc) {
		results.add(wtrc);
	}
	
	public int getNumTestsExecuted() {
		return numTestsExecuted;
	}
	
	public void setNumTestsExecuted(int value) {
		numTestsExecuted = value;
	}
	
	public void incNumTestsExecuted() {
		numTestsExecuted++;
	}
	
	public void incNumTestsExecuted(int value) {
		numTestsExecuted += value;
	}

	public int getNumTestsFailed() {
		return numTestsFailed;
	}
	
	public void setNumTestsFailed(int value) {
		numTestsFailed = value;
	}

	public void incNumTestsFailed() {
		numTestsFailed++;
	}
	
	public void incNumTestsFailed(int value) {
		numTestsFailed += value;
	}

	public int getNumTestsError() {
		return numTestsError;
	}
	
	public void setNumTestsError(int value) {
		numTestsError = value;
	}

	public void incNumTestsError() {
		numTestsError++;
	}
	
	public void incNumTestsError(int value) {
		numTestsError += value;
	}
	
	public void setStatus(Status value) {
		status = value;
	}
	
	public Status getStatus() {
		return status;
	}

	public WodelTestGlobalResult() {
		results = new ArrayList<WodelTestResultClass>();
	}

	public static void resetValues(String path) {
		File file = new File(path);
		try {
			file.createNewFile();
			FileWriter writer = new FileWriter(file);
			writer.write("0|0|0|0\n");
			writer.flush();
			writer.close();

		} catch (IOException e) {
		}
	}

	public static void storeValues(String path, WodelTestGlobalResult globalResult) {
		WodelTestGlobalResult currentResult = loadValues(path);
		globalResult.incNumTestsExecuted(currentResult.getNumTestsExecuted());
		globalResult.incNumTestsFailed(currentResult.getNumTestsFailed());
		globalResult.incNumTestsError(currentResult.getNumTestsError());
		File file = new File(path);
		try {
			LockRegistry.INSTANCE.acquire(path, LockRegistry.LockType.WRITE);
			if (file.exists() != true) {
				file.createNewFile();
			}
			FileWriter writer = new FileWriter(file);
			writer.write(globalResult.getNumTestsExecuted() + "|" + globalResult.getNumTestsFailed()+ "|" + globalResult.getNumTestsError() + "\n");
			writer.flush();
			writer.close();
			LockRegistry.INSTANCE.release(path, LockRegistry.LockType.WRITE);
		} catch (IOException e) {
		}
	}

	public static WodelTestGlobalResult loadValues(String path) {
		WodelTestGlobalResult globalResult = new WodelTestGlobalResult();
		try {
			LockRegistry.INSTANCE.acquire(path, LockRegistry.LockType.READ);
			FileReader fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			if (line != null) {
				String[] data = line.split("[|]");
				globalResult.setNumTestsExecuted(Integer.parseInt(data[0]));
				globalResult.setNumTestsFailed(Integer.parseInt(data[1]));
				globalResult.setNumTestsError(Integer.parseInt(data[2]));
			}
			br.close();
			fr.close();
			LockRegistry.INSTANCE.release(path, LockRegistry.LockType.READ);
		} catch (IOException ex){
		}
		
		return globalResult;
	}
}
