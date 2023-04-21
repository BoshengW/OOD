package multithread;

/* Make multi-thread extends Thread class */
public class DemoThread1 extends Thread {
    public void run() {
        System.out.println("Thread" + Thread.currentThread().getId());
    }
}
