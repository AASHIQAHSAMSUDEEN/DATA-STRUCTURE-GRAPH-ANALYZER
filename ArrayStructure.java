public class ArrayStructure {

    private int[] data;
    private int size;

    public ArrayStructure(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    public boolean insert(int value) {

        if (size == data.length) {
            return false;
        }

        data[size] = value;
        size++;

        return true;
    }

    public boolean delete(int value) {

        int index = linearSearch(value);

        if (index == -1) {
            return false;
        }

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        size--;

        return true;
    }

    public int linearSearch(int value) {

        for (int i = 0; i < size; i++) {

            if (data[i] == value) {
                return i;
            }
        }

        return -1;
    }

    public void display() {

        if (size == 0) {
            System.out.println("Array is empty.");
            return;
        }

        System.out.print("Array: ");

        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }

        System.out.println();
    }

    public int size() {
        return size;
    }

    public int[] getDataCopy() {

        int[] copy = new int[size];

        for (int i = 0; i < size; i++) {
            copy[i] = data[i];
        }

        return copy;
    }

    public int[] getSortedData() {

        int[] sorted = getDataCopy();

        for (int i = 0; i < sorted.length - 1; i++) {

            for (int j = 0; j < sorted.length - i - 1; j++) {

                if (sorted[j] > sorted[j + 1]) {

                    int temp = sorted[j];
                    sorted[j] = sorted[j + 1];
                    sorted[j + 1] = temp;
                }
            }
        }

        return sorted;
    }
}