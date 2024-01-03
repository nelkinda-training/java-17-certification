import java.util.*;
import java.util.concurrent.*;

class Thing {
    private String name;
    public Thing(final String name) {
        this.name = name;
    }
    public String toString() {
        return name;
    }
}

class Consumer implements Runnable {
    private BlockingQueue<Thing> things;
    public Consumer(BlockingQueue<Thing> things) {
        this.things = things;
    }
    public void run() {
        while (true) {
            try { consume(things.take()); } catch (final InterruptedException e) {}
        }
    }
    public void consume(final Thing thing) {
        System.out.println("Consumed " + thing);
    }
}

class Producer implements Runnable {
    private BlockingQueue<Thing> things;
    private int count;
    public Producer(BlockingQueue<Thing> things) {
        this.things = things;
    }
    public void run() {
        while (true) {
            produce();
        }
    }
    public void produce() {
        try { things.put(new Thing("Thing " + ++count)); } catch (final InterruptedException e) {}
        pretendProductionIsExpensive();
    }
    private static void pretendProductionIsExpensive() {
        try { Thread.sleep(5); } catch (final InterruptedException e) {}
    }
}

class Main {
    public static void main(final String... args) {
        BlockingQueue<Thing> things = new LinkedBlockingQueue<>(10);
        new Thread(new Consumer(things)).start();
        new Thread(new Consumer(things)).start();
        new Thread(new Producer(things)).start();
        new Thread(new Producer(things)).start();
    }
}
