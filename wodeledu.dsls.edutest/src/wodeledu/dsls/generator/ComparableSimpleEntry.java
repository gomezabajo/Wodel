package wodeledu.dsls.generator;

import java.util.AbstractMap.SimpleEntry;

public class ComparableSimpleEntry<T1, T2> extends SimpleEntry<T1, T2> implements Comparable<ComparableSimpleEntry<T1, T2>> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5891016691019556492L;

	public ComparableSimpleEntry(T1 arg0, T2 arg1) {
		super(arg0, arg1);
	}

	@Override
	public int compareTo(ComparableSimpleEntry<T1, T2> o) {
		if (this.getKey() instanceof String && o.getKey() instanceof String) {
			return ((String) this.getKey()).compareTo((String) o.getKey());
		}
		return this.getKey().equals(o.getKey()) ? 0 : -1;
	}
	
}


