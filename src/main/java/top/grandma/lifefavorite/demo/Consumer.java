package top.grandma.lifefavorite.demo;

import java.util.Queue;

public class Consumer extends Thread{

    private final Queue sharedQueue;

    public Consumer(Queue sharedQueue) {
        super();
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        while(true) {
            synchronized (sharedQueue) {
                while (sharedQueue.size() == 0) {
                    try {
                        System.out.println("队列空了，等待生产");
                        sharedQueue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("进行消费 : " + sharedQueue.poll().toString());
                sharedQueue.notify();
            }
        }
    }

}
