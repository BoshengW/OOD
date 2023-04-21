package multithread;

public class TestMultiThreads {

    public static void main(String[] args) throws InterruptedException {
        /* create multi-threads */
        System.out.println("Use Extend class to create multi-thread");
        for (int i=0; i<8; i++) {
            DemoThread1 obj = new DemoThread1();
            obj.start();
            obj.join(); // join() wait for current thread die, main thread will wait until this sub-thread finish then continue next line.
        }


        /* create multi-threads */
        System.out.println("Use Interface to create multi-thread");
        for (int i = 0; i < 8; i++) {
            Thread obj = new Thread(new DemoThread2());
            obj.start();
        }
    }
}
