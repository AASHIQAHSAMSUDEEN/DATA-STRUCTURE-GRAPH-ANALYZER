import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayStructure array = new ArrayStructure(50);

        int choice;

        do {
            System.out.println("\n=================================");
            System.out.println("   DATA STRUCTURES SYSTEM");
            System.out.println("=================================");
            System.out.println("1. Array");
            System.out.println("2. Searching");
            System.out.println("0. Exit");
            System.out.println("=================================");

            choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    arrayMenu(array);
                    break;

                case 2:
                    searchingMenu(array);
                    break;

                case 0:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 0);

        scanner.close();
    }

   

    public static void arrayMenu(ArrayStructure array) {

        int choice;

        do {
            System.out.println("\n----------- ARRAY MENU -----------");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Search");
            System.out.println("4. Display");
            System.out.println("0. Back to Main Menu");
            System.out.println("----------------------------------");

            choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    int insertValue = readInt("Enter value to insert: ");

                    if (array.insert(insertValue)) {
                        System.out.println("Value inserted successfully.");
                    } else {
                        System.out.println("Array is full.");
                    }
                    break;

                case 2:
                    int deleteValue = readInt("Enter value to delete: ");

                    if (array.delete(deleteValue)) {
                        System.out.println("Value deleted successfully.");
                    } else {
                        System.out.println("Value not found.");
                    }
                    break;

                case 3:
                    int searchValue = readInt("Enter value to search: ");

                    int position = array.linearSearch(searchValue);

                    if (position != -1) {
                        System.out.println(
                                "Value found at index: " + position
                        );
                    } else {
                        System.out.println("Value not found.");
                    }
                    break;

                case 4:
                    array.display();
                    break;

                case 0:
                    System.out.println("Returning to main menu...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }

    // =========================
    // SEARCHING MENU
    // =========================

    public static void searchingMenu(ArrayStructure array) {

        int choice;

        do {
            System.out.println("\n--------- SEARCHING MENU ---------");
            System.out.println("1. Linear Search");
            System.out.println("2. Binary Search");
            System.out.println("0. Back to Main Menu");
            System.out.println("----------------------------------");

            choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    linearSearch(array);
                    break;

                case 2:
                    binarySearch(array);
                    break;

                case 0:
                    System.out.println("Returning to main menu...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }

    // =========================
    // LINEAR SEARCH
    // =========================

    public static void linearSearch(ArrayStructure array) {

        if (array.size() == 0) {
            System.out.println("Array is empty.");
            return;
        }

        int value = readInt("Enter value to search: ");

        int result = Searching.linearSearchSteps(
                array.getDataCopy(),
                value
        );

        if (result != -1) {
            System.out.println("Value found.");
            System.out.println("Index: " + result);
        } else {
            System.out.println("Value not found.");
        }

        System.out.println("Time Complexity: O(n)");
    }

    // =========================
    // BINARY SEARCH
    // =========================

    public static void binarySearch(ArrayStructure array) {

        if (array.size() == 0) {
            System.out.println("Array is empty.");
            return;
        }

        int value = readInt("Enter value to search: ");

        int[] sortedData = array.getSortedData();

        int result = Searching.binarySearchSteps(
                sortedData,
                value
        );

        if (result != -1) {
            System.out.println("Value found.");
            System.out.println("Index in sorted array: " + result);
        } else {
            System.out.println("Value not found.");
        }

        System.out.println("Time Complexity: O(log n)");
    }

    


    

    public static int readInt(String message) {

        while (true) {

            System.out.print(message);

            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            }

            System.out.println("Please enter a valid number.");
            scanner.next();
        }
    }
}