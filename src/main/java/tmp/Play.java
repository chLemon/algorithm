package tmp;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Play {

    public static void main(String[] args) throws InterruptedException {
        new Play().method();
        System.gc();
        Thread.sleep(5);
        System.gc();
        while (true) {

        }
    }

    private void method() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(50,
                60, 1, TimeUnit.DAYS, new ArrayBlockingQueue<>(1));
        for (int i = 0; i < 50; i++) {
            threadPoolExecutor.execute(() -> {
            });
        }
        System.gc();

    }

}
