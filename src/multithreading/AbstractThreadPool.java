package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.IntStream;

public class AbstractThreadPool {
    private BlockingQueue<Runnable> taskQueue = null;
    private List<PoolThread> threads = new ArrayList<>();
    private boolean isStopped = false;

    public AbstractThreadPool(int maxthreads, int maxTaks) {
        taskQueue = new LinkedBlockingQueue<>(maxTaks);
        IntStream.range(0, maxthreads).mapToObj(value -> new PoolThread(taskQueue))
                        .forEach(poolThread -> threads.add(poolThread));
        int [] a= {};
        for (PoolThread thread : threads) {
            thread.start();
        }
    }

    public synchronized void stop() {
        isStopped = true;
        for (PoolThread thread : threads) {
            thread.doStop();
        }
    }

    public synchronized void execute(Runnable task) throws Exception {
        if (this.isStopped) {
            throw new Exception("Thread Pool Stopped");
        }
        taskQueue.put(task);
    }

}
