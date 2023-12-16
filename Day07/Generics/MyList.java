public class MyList<T> {
    private T element;
    public MyList(T element) {
        this.element = element;
    }
    public void add(T element) {
        this.element = element;
    }
}

interface Comparable<T extends Comparable<T>> {
    int compareTo(T o);
}

class Picture implements Named {
    int width;
    int height;
    String name;
    byte[] data;
    public String getName() {
        return name;
    }
}

class ByHeightComparator implements Comparator<Picture> {
    public int compare(Picture p1, Picture p2) {
        return p1.height - p2.height;
    }
}

interface Named {
    String getName();
}

interface Comparator<T> {
    int compare(T t1, T t2);
}

class Car implements Comparable<Car>, Named {
    int power;
    String name;
    public int compareTo(Car o) {
        return this.power - o.power;
    }
    public String getName() {
        return name;
    }
}

class ByNameComparator implements Comparator<Named> {
    public int compare(Named n1, Named n2) {
        return n1.getName().compareTo(n2.getName());
    }
}

class Collections {
    static <T extends Comparable<? super T>> void sort(MyList<T> list) { }
    static <T> void sort(MyList<T> list, Comparator<? super T> c) { }
}

class Main {
    public static void main(final String... args) {
        MyList<Car> cars = new MyList<>(new Car());
        Comparator<? super Car> comp = new ByNameComparator();
        Collections.sort(cars, comp);
    }
}
