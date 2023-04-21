package singleton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/* 构建线程间不唯一，单一线程内唯一的单例 */
/* 传统单例类，是进程内唯一，也就是各个线程间都唯一 */
public class SingletonThreadOnly {

    private static final Map<Long, SingletonThreadOnly> threadSingleton = new ConcurrentHashMap<>();

    private AtomicLong id;

    private SingletonThreadOnly() {
        id = new AtomicLong(0);
    }

    public static SingletonThreadOnly getInstance() {
        Long currThread = Thread.currentThread().getId();
        threadSingleton.putIfAbsent(currThread, new SingletonThreadOnly());
        System.out.println(threadSingleton.size());
        return threadSingleton.get(currThread);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 8; i++) {
            Thread job = new Thread(new TestSingletonThreadOnly());
            job.start();
        }
    }
}

class TestSingletonThreadOnly implements Runnable {

    @Override
    public void run() {
        SingletonThreadOnly.getInstance();
    }
}
