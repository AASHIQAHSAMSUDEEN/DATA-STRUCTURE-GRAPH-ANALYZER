import java.util.Arrays;

public class ArrayStructure {
    private final int[] data;
    private int size;

    public ArrayStructure(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    public void insert(int value) {
        if (size == data.length) {
            System.out.println("Array is full.");
            return;
        }
        data[size++] = value;
        System.out.println("Inserted " + value + ".");
    }

    public void delete(int value) {
        int index = linearSearch(value);
        if (index == -1) {
            System.out.println("Value not found.");
            return;
        }

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        System.out.println("Deleted " + value + ".");
    }

    public int linearSearch(int value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value) return i;
        }
        return -1;
    }

    public int[] getSortedData() {
        int[] copy = Arrays.copyOf(data, size);
        Arrays.sort(copy);
        return copy;
    }

    public int[] getDataCopy() {
        return Arrays.copyOf(data, size);
    }

    public void display() {
        if (size == 0) {
            System.out.println("Array is empty.");
            return;
        }
        System.out.print("Array: ");
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + (i < size - 1 ? " " : ""));
        }
        System.out.println();
    }

    public int size() {
        return size;
    }
}
