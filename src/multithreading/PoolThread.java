package multithreading;

import java.util.concurrent.BlockingQueue;

public class PoolThread extends Thread {
    private BlockingQueue<Runnable> taskQueue;
    private boolean isStopped = false;

    public PoolThread(BlockingQueue<Runnable> taskQueue) {
        this.taskQueue = taskQueue;
    }

    @Override
    public void run() {
        while (!isStopped()) {
            try {
                Runnable runnable = taskQueue.take();
                runnable.run();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean isStopped() {
        return isStopped;
    }

    public void doStop() {
        isStopped = true;
        this.interrupt();
    }
}
