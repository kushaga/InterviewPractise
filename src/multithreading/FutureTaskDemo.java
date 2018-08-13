package multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

//class that demonstrates future task usage in java
public class FutureTaskDemo {
    static class DemoCallable implements Callable<String> {

        private String name;

        public DemoCallable(String name) {
            this.name = name;
        }

        @Override public String call() throws Exception {
            Thread.sleep(1000);

            return String.format("%s.Task.Completed", name).toString();
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        FutureTask task1 = new FutureTask(new DemoCallable("1"));
        FutureTask task2 = new FutureTask(new DemoCallable("2"));

        executorService.execute(task1);
        executorService.execute(task2);

        while (true) {
            if (task1.isDone() && task2.isDone()) {
                System.out.println("Both tasks finished Shutitng down....");
                executorService.shutdown();
                return;
            }
            if (!task1.isDone()) {
                System.out.println("task1 Name:" + task1.get());
            }
            System.out.println("Waiting for 2nd task ....");
            System.out.println("2nd Name:" + task2.get());
        }

    }

}
