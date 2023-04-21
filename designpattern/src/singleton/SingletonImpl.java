package singleton;

public class SingletonImpl {

}

class SingletonEagerMode {

    private final static SingletonEagerMode instance = new SingletonEagerMode();
    private SingletonEagerMode() {}

    public static SingletonEagerMode getInstance() {
        return instance;
    }

}

class SingletonLazyMode {
    private static SingletonLazyMode instance;


    public static SingletonLazyMode getInstance_noThreadSafe() {
        if (instance == null) {
            instance = new SingletonLazyMode();
        }

        return instance;
    }

    /* Low Performance: Not efficient since everytime when call this method will add lock and releases lock when finish */
    public static synchronized SingletonLazyMode getInstance_ThreadSafe1() {
        if (instance == null) {
            instance = new SingletonLazyMode();
        }
        return instance;
    }

    public static SingletonLazyMode getInstance_ThreadSafe2() {
        if (instance == null) {
            synchronized (SingletonLazyMode.class) { // synchronized 相当于加锁
                instance = new SingletonLazyMode();
            }
        }
        return instance;
    }

}

/* Thread safe singelton */
class SingletonStaticClass {
    /* use internal static class to make lazy mode */
    private SingletonStaticClass() {}

    private static class InternalClass {
        static SingletonStaticClass instance = new SingletonStaticClass();
    }

    public static SingletonStaticClass getInstance() {
        return InternalClass.instance;
    }
}
