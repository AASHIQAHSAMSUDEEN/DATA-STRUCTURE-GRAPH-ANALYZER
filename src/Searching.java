public class Searching {

    // Linear Search
    public static int linearSearchSteps(int[] data, int target) {

        for (int i = 0; i < data.length; i++) {

            if (data[i] == target) {
                return i;
            }
        }

        return -1;
    }

    // Binary Search
    public static int binarySearchSteps(int[] data, int target) {

        int left = 0;
        int right = data.length - 1;

        while (left <= right) {

            int middle = (left + right) / 2;

            if (data[middle] == target) {
                return middle;
            }

            if (data[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return -1;
    }
}