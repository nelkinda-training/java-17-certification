import java.util.*;

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
    private List<Thing> things;
    public Consumer(List<Thing> things) {
        this.things = things;
    }
    public void run() {
        while (true) {
            Thing thing;
            synchronized (things) {
                while (things.size() == 0) {
                    try { things.wait(); } catch (final InterruptedException e) {}
                }
                thing = things.remove(0);
            }
            consume(thing);
        }
    }
    public void consume(final Thing thing) {
        System.out.println("Consumed " + thing);
    }
}

class Producer implements Runnable {
    private List<Thing> things;
    private int count;
    public Producer(List<Thing> things) {
        this.things = things;
    }
    public void run() {
        while (true) {
            if (things.size() < 10) {
                produce();
            }
        }
    }
    public void produce() {
        final Thing newThing = new Thing("Thing " + ++count);
        synchronized (things) {
            things.add(newThing);
            things.notify();
        }
        pretendProductionIsExpensive();
    }
    private static void pretendProductionIsExpensive() {
        try { Thread.sleep(5); } catch (final InterruptedException e) {}
    }
}

class Main {
    public static void main(final String... args) {
        List<Thing> things = Collections.synchronizedList(new ArrayList<>());
        new Thread(new Consumer(things)).start();
        new Thread(new Consumer(things)).start();
        new Thread(new Producer(things)).start();
        new Thread(new Producer(things)).start();
    }
}
