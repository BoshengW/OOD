package singleton;

import java.util.concurrent.atomic.AtomicLong;

public class SingletonProcessOnly {
    private static Object instance;
    private static final FileStorageClass singletonInCluster = new FileStorageClass("external location");
    private static DistributedLock lock = new DistributedLock();

    public static synchronized Object getInstance() {
        if (instance == null) {
            lock.lock(); // add distributed lock
            instance = singletonInCluster.returnSingletonInCluster();
        }
        return instance;
    }

    public static synchronized void releaseDistributedLock() {
        singletonInCluster.updateSingletonToCluster();
        lock.unlock();
    }

}

class FileStorageClass {
    /* assume there is a class used for read + write Singleton class in a external storage location */
    Object instance;

    public FileStorageClass(String location) {}

    public Object returnSingletonInCluster() {
        return new Object();
    }

    public void updateSingletonToCluster() {}
}

class DistributedLock {
    /* a distributed lock between nodes in cluster */
    public void lock() {}

    public void unlock() {}
}
