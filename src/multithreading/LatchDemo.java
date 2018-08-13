package multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.stream.IntStream;

public class LatchDemo {

    static class ThreadDemo extends Thread {
        private String name;
        private CountDownLatch latch;

        public ThreadDemo(String name , CountDownLatch latch) {
            this.name = name;
            this.latch = latch;
        }

        @Override public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name);
            latch.countDown();
        }
    }

    private static CountDownLatch latch;

    public static void main(String args[]) throws InterruptedException {

        latch = new CountDownLatch(5);

        IntStream.range(0, 5).mapToObj(new IntFunction<ThreadDemo>() {
            @Override public ThreadDemo apply(int value) {
                return new ThreadDemo(String.valueOf(value),latch);
            }
        }).forEach(new Consumer<ThreadDemo>() {
            @Override public void accept(ThreadDemo threadDemo) {
                threadDemo.run();
            }
        });

        latch.await();
        System.out.println(Thread.currentThread().getName() + " has finished");
    }

}
