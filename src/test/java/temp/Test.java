package temp;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Test {

    static Test instance = new Test();

    public static void main(String[] args) throws InterruptedException {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        lock.readLock().lock();
        lock.writeLock().lock();
        System.out.println("双锁获取");
    }


}
