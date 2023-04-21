package multithread;

public class DemoThread2 implements Runnable {

    @Override
    public void run() {
        System.out.println("Thread " + Thread.currentThread().getId());
    }
}
