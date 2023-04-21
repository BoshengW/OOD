package singleton;

/* build singleton class with params */
public class SingletonwParams {

}

class paramsSingleton {

    /* build a singleton which can import params */
    private static paramsSingleton instance;

    private int a1, a2;

    private paramsSingleton(int a1, int a2) {
        this.a1 = a1;
        this.a2 = a2;
    }

    public synchronized static paramsSingleton getInstance(int a1, int a2) {
        if (instance == null) {
            instance = new paramsSingleton(a1, a2);
        } else {
            if (a1!= instance.a1 || a2!= instance.a2) {
                throw new RuntimeException("Instance have created, cannot pass new params");
            }
        }

        return instance;
    }

}


