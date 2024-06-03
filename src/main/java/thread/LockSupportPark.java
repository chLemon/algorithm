package thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

public class LockSupportPark {

    private static int count = 3000;

    public static void main(String[] args) {

        MyThread a = new MyThread("A");
        MyThread b = new MyThread("B");
        MyThread c = new MyThread("C");
        a.nextThread = b;
        b.nextThread = c;
        c.nextThread = a;

        a.start();
        b.start();
        c.start();

    }

    static class MyThread extends Thread {

        public Thread nextThread;
        private String out;

        private int count = 100;

        MyThread(String out) {
            this.out = out;
        }

        @Override
        public void run() {
            while (count-- > 0) {
                if (out.equals("A")) {
                    System.out.print(out);
                    count--;
                    LockSupport.unpark(nextThread);
                    LockSupport.park();
                } else {
                    LockSupport.park();
                    System.out.print(out);
                    if (out.equals("C")) {
                        System.out.println();
                    }
                    count--;
                    LockSupport.unpark(nextThread);
                }
            }
        }
    }

}
