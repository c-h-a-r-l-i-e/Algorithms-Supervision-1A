package uk.ac.cam.cl.cm927.adts;

public class CircularDeque {

    public static void main(String[] args) {
        CircularDeque circle = new CircularDeque(5);
        circle.addFirst(1);
        circle.addLast(2);
        System.out.println(circle.removeFirst());
        System.out.println(circle.removeLast());
    }

    private int[] data;
    private int tail;
    private int head;

    public CircularDeque (int len) {
        data = new int[len];
        head = data.length - 1;
        tail = 0;
    }

    public void addFirst(int i) {
        //Array is full
        if (tail == head) throw new RuntimeException();

        data[head] = i;
        head = (head - 1) % data.length;
    }

    public int removeFirst() {
        if (Math.floorMod(tail - 1, data.length) == head) throw new RuntimeException();

        head = (head + 1) % data.length;
        return data[head];
    }

    public void addLast(int i) {
        //Array is full
        if (tail == head) throw new RuntimeException();

        data[tail] = i;
        tail = (tail + 1) % data.length;
    }

    public int removeLast() {
        if (Math.floorMod(tail - 1, data.length) == head) throw new RuntimeException();

        tail = (tail - 1) % data.length;
        return data[tail];
    }


}
