package wodel.utils.manager;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public enum LockRegistry {

	// make our class a singleton
	INSTANCE;

	// map of file names to locks - You may want to change the keys to be File or
	// something else, just be wary of the class's hashCode() semantics
	private Map<String, ReadWriteLock> lockMap = new TreeMap<String, ReadWriteLock>();

	// lock to protect our registry - helps to prevent multiple threads
	// from instantiating a lock with the same key
	private Lock registryLock = new ReentrantLock();

	// allow callers to specify the lock type they require
	public enum LockType {
		READ, WRITE
	}

	public void acquire(String fileName, LockType type) {
		// lazily instantiates locks on first use
		ReadWriteLock lock = retrieveLock(fileName);

		switch (type) {
			case READ:
				lock.readLock().lock();
				break;
			case WRITE:
				lock.writeLock().lock();
				break;
			default:
				// handle error scenario
				break;
		}
	}

	public void release(String fileName, LockType type) {

		ReadWriteLock lock = retrieveLock(fileName);

		switch (type) {
			case READ:
				lock.readLock().unlock();
				break;
			case WRITE:
				lock.writeLock().unlock();
				break;
			default:
				// handle error scenario
				break;
		}
	}

	private ReadWriteLock retrieveLock(String fileName) {

		ReadWriteLock newLock = null;

		try {
			registryLock.lock();
			newLock = lockMap.get(fileName);

			// create lock and add to map if it doesn't exist
			if (newLock == null) {
				newLock = new ReentrantReadWriteLock();
				lockMap.put(fileName, newLock);
			}
		} finally {
			registryLock.unlock();
		}
		return newLock;
	}
}