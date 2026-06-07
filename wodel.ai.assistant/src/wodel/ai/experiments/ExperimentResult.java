package wodel.ai.experiments;

import java.util.*;

public class ExperimentResult {
	private List<Double> durations = new ArrayList<>(); // in ms
	private double avg;
	private double median;
	private double stdDev;
	private int numFups;
	private Map<Integer, Integer> fups = new LinkedHashMap<>();
	private int numXMIFixes = 0;

	public ExperimentResult(List<Double> durationsMs) {
		this.durations.addAll(durationsMs);
		this.calculateStats();
	}
	
	public void setFollowups(int numFups) {
		this.numFups = numFups;
	}
	
	public List<Double> getDurations() {
		return durations;
	}
	
	public double getAverage() {
		return avg;
	}
	
	public double getMedian() {
		return median;
	}
	
	public double getStdDev() {
		return stdDev;
	}
	
	public int getNumberOfFollowUps() {
		return numFups;
	}
	
	public int getNumberOfXMIFixes() {
		return numXMIFixes;
	}
	
	@Override
	public String toString() {
		String result = "\nTiming Statistics (ms):\n";
		int numModels = durations.size();
		result+= String.format("%d models, with exec. times in ms:\n", numModels);
		for (double d: durations) 
			result+= String.format("%.4f\n", d);		
		result+= String.format("Average time: %.2f ms\n", avg);
		result+= String.format("Median time: %.2f ms\n", median);
		result+= String.format("Standard deviation: %.2f ms\n", stdDev);
		double perc = 100.0 * numFups / numModels;
		result+= "Number of XMI fixes performed: "+this.numXMIFixes+"\n";
		result+= "Total number of follow-ups: "+numFups+" ("+String.format("%.2f", perc)+"%)\n";
		result+= "Number of follow-ups by trial (0 means no fixing was necessary): "+this.fups;
		return result;
	}

	public ExperimentResult add(ExperimentResult er) {
		ExperimentResult newResult = new ExperimentResult(durations);
		newResult.durations.addAll(er.durations);
		//newResult.setFollowups(this.numFups+er.numFups);
		newResult.addFollowups(this.fups);
		newResult.addFollowups(er.fups);
		newResult.addXMIFixes(this.numXMIFixes);
		newResult.addXMIFixes(er.numXMIFixes);
		newResult.calculateStats();
		return newResult;
	}

	private void calculateStats() {
		double sum = this.durations.stream().mapToDouble(Double::doubleValue).sum();
		this.avg = sum / this.durations.size();

		// Compute median
		Collections.sort(this.durations);
		int size = this.durations.size();
		if (size % 2 == 0) 
			this.median = (this.durations.get(size / 2 - 1) + this.durations.get(size / 2)) / 2.0;
		else 
			this.median = this.durations.get(size / 2);	

		// Compute standard deviation
		double variance = this.durations.stream().mapToDouble(d -> Math.pow(d - avg, 2)).sum() / this.durations.size();
		this.stdDev = Math.sqrt(variance);
	}

	public void addFollowups(Map<Integer, Integer> fupsCount) {
		for (Integer k: fupsCount.keySet()) {
			if (this.fups.containsKey(k)) 
				this.fups.put(k, fupsCount.get(k) + this.fups.get(k));
			else
				this.fups.put(k, fupsCount.get(k));
			this.numFups += fupsCount.get(k);
		}
	}

	public void addXMIFixes(int numXMIFixes) {
		this.numXMIFixes += numXMIFixes;
	}
}
