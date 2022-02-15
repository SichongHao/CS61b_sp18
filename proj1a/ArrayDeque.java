public class ArrayDeque<T> {
    private  T[] items;
    private int nextFirst;
    private int nextLast;
    private int size;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 4;
        nextLast = 5;
    }

    private void resizeLast(int capacity) {
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, nextLast);
        System.arraycopy(items, nextLast, a, nextLast + 1, items.length - nextLast);
        items = a;
        nextFirst += 1;
        if (nextFirst >= items.length) {
            nextFirst = 0;
        }
//        nextLast += 1;
    }

    public void addLast(T item) {
        if (size == items.length) {
            resizeLast(size + 1);
        }
        items[nextLast] = item;
        size += 1;
        nextLast += 1;
        if (nextLast >= items.length) {
            nextLast = 0;
        }
    }

    public T removeLast() {
        int removeIndex = nextLast - 1;
        if (removeIndex < 0) {
            removeIndex = items.length - 1;
        }
        T x = items[removeIndex];
        items[removeIndex] = null;
        size -= 1;
        nextLast -= 1;
        if (nextLast < 0) {
            nextLast = items.length - 1;
        }
        return x;
    }

    private void resizeFirst(int capacity) {
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, nextLast);
        System.arraycopy(items, nextLast, a, nextLast + 1, items.length - nextLast);
        items = a;
        nextFirst += 1;
    }

    public void addFirst(T item) {
        if (size == items.length) {
            resizeFirst(size + 1);
        }
        items[nextFirst] = item;
        size += 1;
        nextFirst -= 1;
        if (nextFirst < 0) {
            nextFirst = items.length - 1;
        }
    }

    public T removeFirst() {
        int removeIndex = nextFirst + 1;
        if (removeIndex >= items.length) {
            removeIndex = 0;
        }
        T x = items[removeIndex];
        items[removeIndex] = null;
        size -= 1;
        nextFirst += 1;
        if (nextFirst >= items.length) {
            nextFirst = 0;
        }
        return x;
    }

    public int size() { return size; }

    public T get(int index) { return items[index]; }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printDeque() {
        int i = 0;
        if (size == 0) {
            System.out.print("Deque is empty!");
        } else {
            while (i < size) {
                System.out.print(items[i].toString() + " ");
                i += 1;
            }
            System.out.println();
        }

    }
}
