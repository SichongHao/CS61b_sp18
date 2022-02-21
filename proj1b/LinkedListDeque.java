public class LinkedListDeque<T> implements Deque<T> {
    private class Node {
        private T item;
        private Node prev;
        private Node next;

        public Node(Node p, T i, Node n) {
            item = i;
            next = n;
            prev = p;
        }
    }

    private Node sentinel;
    private int size;

    /** Creates an empty List. */
    public LinkedListDeque() {
        sentinel = new Node(null, (T) new Object(), null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

//    public LinkedListDeque(T item) {
//            sentinel = new Node(null, (T) new Object(), null);
//            sentinel.next = new Node(sentinel, item, null);
//            sentinel.prev = sentinel.next;
//            size = 1;
//    }
    @Override
    public void addFirst(T item) {
        if (size == 0) {
            sentinel = new Node(null, (T) new Object(), null);
            sentinel.next = new Node(sentinel, item, sentinel);
            sentinel.prev = sentinel.next;
            size = 1;
        } else {
            sentinel.next = new Node(sentinel, item, sentinel.next);
            sentinel.next.next.prev = sentinel.next;
            size += 1;
        }
    }

    @Override
    public void addLast(T item) {
        if (size == 0) {
            sentinel = new Node(null, (T) new Object(), null);
            sentinel.next = new Node(sentinel, item, sentinel);
            sentinel.prev = sentinel.next;
            size = 1;
        } else {
            sentinel.prev = new Node(sentinel.prev, item, sentinel);
            sentinel.prev.prev.next = sentinel.prev;
            size += 1;
        }
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node del = sentinel.next;
        T x = del.item;
        sentinel.next = del.next;
        sentinel.next.prev = sentinel;
        del.prev = null;
        del.next = null;
        del.item = null;
        size -= 1;
        return x;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        Node del = sentinel.prev;
        T x = del.item;
        sentinel.prev = del.prev;
        sentinel.prev.next = sentinel;
        del.item = null;
        del.prev = null;
        del.next = null;
        size -= 1;
        return x;
    }

    @Override
    public T get(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        int i = 0;
        Node n = sentinel.next;
        while (i != index) {
            n = n.next;
            i += 1;
        }
        return n.item;
    }

//    @Override
//    public T getRecursive(int index) {
//        if (index >= size || index < 0) {
//            return null;
//        } else if (index == 0) {
//            return sentinel.next.item;
//        } else {
//            sentinel.next = sentinel.next.next;
//            return getRecursive(index - 1);
//        }
//
//    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void printDeque() {
        Node n = sentinel.next;
        if (n == null) {
            System.out.print("Deque is empty!");
        } else {
            while (n != sentinel) {
                System.out.print(n.item.toString() + " ");
                n = n.next;
            }
            System.out.println();
        }
    }

}
