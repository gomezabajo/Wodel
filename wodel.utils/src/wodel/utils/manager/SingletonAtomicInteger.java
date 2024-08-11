package wodel.utils.manager;

import java.util.concurrent.atomic.AtomicInteger;

public class SingletonAtomicInteger {
	private static SingletonAtomicInteger INSTANCE;
	private AtomicInteger value;
	private SingletonAtomicInteger(int value) {
		this.value = new AtomicInteger(value);
	}
	public static SingletonAtomicInteger getInstance(int value) {
		if (SingletonAtomicInteger.INSTANCE == null) {
			SingletonAtomicInteger.INSTANCE = new SingletonAtomicInteger(value);
		}
		return SingletonAtomicInteger.INSTANCE;
	}
	public static SingletonAtomicInteger getInstance() {
		return SingletonAtomicInteger.getInstance(0);
	}

	public AtomicInteger getValue() {
		if (SingletonAtomicInteger.INSTANCE != null) {
			return this.value;
		}
		return null;
	}
}
