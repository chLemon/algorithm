package thread;

import com.sun.corba.se.impl.oa.toa.TOA;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockCondition {

    private static AtomicInteger count = new AtomicInteger(0);

    private static Lock lock = new ReentrantLock();
    private static Condition conditionA = lock.newCondition();
    private static Condition conditionB = lock.newCondition();
    private static Condition conditionC = lock.newCondition();

    private static int total = 9;

    public static void main(String[] args) {
        new MyThread(0, "A", conditionA, conditionB).start();
        new MyThread(1, "B", conditionB, conditionC).start();
        new MyThread(2, "C", conditionC, conditionA).start();
    }

    static class MyThread extends Thread {

        private String out;

        private int id;

        private Condition mine;

        private Condition next;

        MyThread(int id, String out, Condition mine, Condition next) {
            this.id = id;
            this.out = out;
            this.mine = mine;
            this.next = next;
        }

        @Override
        public void run() {
            try {
                lock.lock();
                while (count.get() < total) {
                    if (count.get() % 3 != id) {
                        mine.await();
                    }

                    if (count.get() < total) {
                        System.out.print(out);
                        if (out.equals("C")) System.out.println();
                        count.getAndIncrement();
                    }

                    next.signal();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

}
