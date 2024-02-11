import java.util.*;

public class MyArrayList<T extends Comparable<T>>{
    private T[] list;
    private int size;
    private int default_capacity = 10;

    @SuppressWarnings("unchecked")
    public MyArrayList() {
        list = (T[]) new Comparable[default_capacity];
    }


    public MyArrayList(Collection<? extends T> collection) {
        this();
        addAll(collection);
    }

    public void add(T item) {
        if (size >= default_capacity) {
            default_capacity *= 2;
            list = Arrays.copyOf(list, default_capacity);
        }
        list[size++] = item;
    }

    public void add(int index, T item) {
        if (list.length == default_capacity) {
            list = Arrays.copyOf(list, default_capacity * 2);
        }
        for (int i = size; i > index; i--) {
            list[i] = list[i - 1];
        }

        list[index] = item;
        size++;
    }


    public void addAll(Collection<? extends T> elements) {
        ensureCapacity(size + elements.size());
        for (T element : elements) {
            list[size++] = element;
        }
    }

    public int getSize(){
        return size;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < size; i++) {
            list[i] = list[i + 1];
        }
        size--;
    }

    public T get(int index) {
        return list[index];
    }


    public static <E extends Comparable<E>> void bubbleSort(MyArrayList<E> list) {
        boolean sorted;
        do {
            sorted = true;
            for (int i = 0; i < list.getSize() - 1; i++) {
                if (list.get(i).compareTo(list.get(i + 1)) > 0) {
                    E temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                    sorted = false;
                }
            }
        } while (!sorted);
    }
    public void set(int index, T element) {
        list[index] = element;
    }


    private void ensureCapacity(int requiredCapacity) {
        if (requiredCapacity > list.length) {
            list = Arrays.copyOf(list, requiredCapacity);
        }
    }


    @Override
    public String toString () {
       return Arrays.toString(Arrays.copyOf(list, size));
    }
}
