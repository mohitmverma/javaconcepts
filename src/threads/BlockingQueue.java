package threads;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue extends Object {
    private Queue<Integer> q;
    private int capacity;

    public BlockingQueue(int capacity) {
        this.q = new LinkedList<>();
        this.capacity = capacity;
    }

    public boolean addItem(int item) {
        synchronized (q) {
            while (q.size() == capacity) {
                try {
                    q.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            q.add(item);
            q.notifyAll();
            return true;
        }
    }

    public int remove() {
        synchronized (q) {
            while(q.isEmpty()) {
                try {
                    q.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            int val = q.poll();
            q.notifyAll();
            return val;
        }
    }

}
