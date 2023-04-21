package singleton.LockLogger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {

    private FileWriter writer;

    public Logger() throws IOException {
        File file = new File("/Users/repo/log.txt");
        writer = new FileWriter(file, true);
    }

    /* Not thread safe */
    public void log(String msg) throws IOException {
        writer.write(msg);
    }

    /* Solution 1: add class level lock */
    public void log_threadSafe(String msg) throws IOException {
        /* synchronize 是对象级别的锁只对该对象有用 - 不同对象之间无法共享 - 所以不可行*/
        /* 改良：将该类创建成singleton使得所有应用指向同一个对象 */
        synchronized (this) {
            writer.write(msg);
        }

        /* 类级别的锁 - 同类之间可以相互共享 */
        synchronized (Logger.class) {
            writer.write(msg);
        }
    }

    /* Solution 2. Blocking Queue并发队列 - all threads put data into queue and use another thread to load queue data into log */

}

class LoggerSingleton {
    /* Solution 3. Singleton class + object-level lock */
    private FileWriter writer;

    private static final LoggerSingleton instance;

    static {
        try {
            instance = new LoggerSingleton();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private LoggerSingleton() throws IOException {
        File file = new File("/Users/repo/log.txt");
        writer = new FileWriter(file, true);
    }

    public static LoggerSingleton getInstance() {
        return instance;
    }

    public void log(String msg) throws IOException {
        /* FileWrite include object-level lock */
        writer.write(msg);
    }

}
