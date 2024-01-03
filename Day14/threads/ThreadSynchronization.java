import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Random;

class Point implements Serializable {
    private int x;
    private int y;

    private transient Object lock = new Object();

    public Point(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    private void readObject(final ObjectInputStream in) {
        in.defaultReadObject();
        lock = new Object();
    }

    public void setX(final int x) {
        this.x = x;
    }

    public void setY(final int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void addXY(int dx, int dy) {
        synchronized (lock) {
            setX(getX() + dx);
            setY(getY() + dy);
        }
    }

    @Override
    public String toString() {
        int x, y;
        synchronized (lock) {
            x = getX();
            y = getY();
        }
        return "Point: " + x + ", " + y;
    }
}

class DrawingThread implements Runnable {
    private Point p;
    public DrawingThread(Point p) {
        this.p = p;
    }
    public void run() {
        while (true) {
            System.out.println(p);
            try { Thread.sleep(50); } catch (final InterruptedException e) {}
        }
    }
}

class PointUpdater implements Runnable {
    private Point p;
    private Random rng = new Random();
    public PointUpdater(Point p) {
        this.p = p;
    }
    public void run() {
        while (true) {
            try { Thread.sleep(200); } catch (final InterruptedException e) {}
            int dx = 1 + rng.nextInt(10);
            int dy = 1 + rng.nextInt(10);
            p.addXY(dx, dy);
        }
    }
}

class ThreadSynchronization {
    public static void main(final String... args) {
        Point p = new Point(0, 0);
        new Thread(new DrawingThread(p)).start();
        new Thread(new PointUpdater(p)).start();
    }
}
