public class Searching {
    public static int binarySearch(int[] sortedArray, int target) {
        int left = 0;
        int right = sortedArray.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (sortedArray[mid] == target) return mid;
            if (sortedArray[mid] < target) left = mid + 1;
            else right = mid - 1;
        }

        return -1;
    }

    public static int linearSearchSteps(int[] data, int target) {
        int steps = 0;
        for (int value : data) {
            steps++;
            if (value == target) return steps;
        }
        return steps;
    }

    public static int binarySearchSteps(int[] sortedArray, int target) {
        int left = 0;
        int right = sortedArray.length - 1;
        int steps = 0;

        while (left <= right) {
            steps++;
            int mid = left + (right - left) / 2;

            if (sortedArray[mid] == target) return steps;
            if (sortedArray[mid] < target) left = mid + 1;
            else right = mid - 1;
        }

        return steps;
    }
}
