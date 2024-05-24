package temp;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        new Test().test();
    }

    public void test() throws InterruptedException {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("JVM is shutting down");
        }));
        Runnable runnable = () -> {
            try {
                int count = 0;
                while (Thread.currentThread().isAlive()) {
                    System.out.println(count++);
                }
            } finally {
                System.out.println("守护线程中断后1");
            }
            System.out.println("守护线程中断后2");
        };

        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.start();
        Thread.sleep(1);
        System.out.println("main线程结束");
    }

}
