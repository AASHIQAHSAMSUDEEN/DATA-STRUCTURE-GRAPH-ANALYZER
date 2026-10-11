import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    private static final ArrayStructure array = new ArrayStructure(50);
    private static final StackStructure stack = new StackStructure(20);
    private static final QueueStructure queue = new QueueStructure(20);
    private static final LinkedListStructure linkedList = new LinkedListStructure();
    private static final Graph graph = new Graph();
    private static final PerformanceAnalyzer performance = new PerformanceAnalyzer();

    public static void main(String[] args) {
        boolean running = true;

        System.out.println("=============================================");
        System.out.println("       DATA STRUCTURE & GRAPH ANALYZER");
        System.out.println("=============================================");

        while (running) {
            showMainMenu();
            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1 -> arrayMenu();
                case 2 -> stackMenu();
                case 3 -> queueMenu();
                case 4 -> linkedListMenu();
                case 5 -> searchingMenu();
                case 6 -> graphMenu();
                case 7 -> performance.showComparison(array, graph);
                case 8 -> displayAllResults();
                case 9 -> {
                    running = false;
                    System.out.println("Thank you for using the system.");
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private static void showMainMenu() {
        System.out.println("\n=============================================");
        System.out.println("1. Array Operations");
        System.out.println("2. Stack Operations");
        System.out.println("3. Queue Operations");
        System.out.println("4. Linked List Operations");
        System.out.println("5. Searching Operations");
        System.out.println("6. Graph Operations");
        System.out.println("7. Performance Comparison");
        System.out.println("8. Display All Results");
        System.out.println("9. Exit");
        System.out.println("=============================================");
    }

    private static void arrayMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--------------- ARRAY OPERATIONS ---------------");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Search");
            System.out.println("4. Display");
            System.out.println("5. Back");

            int choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1 -> array.insert(readInt("Enter value: "));
                case 2 -> array.delete(readInt("Enter value to delete: "));
                case 3 -> {
                    int value = readInt("Enter value to search: ");
                    int index = array.linearSearch(value);
                    System.out.println(index >= 0 ? "Value found at index " + index : "Value not found.");
                }
                case 4 -> array.display();
                case 5 -> back = true;
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void stackMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--------------- STACK OPERATIONS ---------------");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Back");

            int choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1 -> stack.push(readInt("Enter value: "));
                case 2 -> stack.pop();
                case 3 -> stack.peek();
                case 4 -> stack.display();
                case 5 -> back = true;
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void queueMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--------------- QUEUE OPERATIONS ---------------");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Front");
            System.out.println("4. Display");
            System.out.println("5. Back");

            int choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1 -> queue.enqueue(readInt("Enter value: "));
                case 2 -> queue.dequeue();
                case 3 -> queue.front();
                case 4 -> queue.display();
                case 5 -> back = true;
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void linkedListMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--------------- LINKED LIST OPERATIONS ---------------");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Search");
            System.out.println("4. Display");
            System.out.println("5. Back");

            int choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1 -> linkedList.insert(readInt("Enter value: "));
                case 2 -> linkedList.delete(readInt("Enter value to delete: "));
                case 3 -> {
                    int value = readInt("Enter value to search: ");
                    System.out.println(linkedList.search(value) ? "Value found." : "Value not found.");
                }
                case 4 -> linkedList.display();
                case 5 -> back = true;
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void searchingMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--------------- SEARCHING OPERATIONS ---------------");
            System.out.println("1. Linear Search");
            System.out.println("2. Binary Search");
            System.out.println("3. Back");

            int choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1 -> {
                    int value = readInt("Enter value: ");
                    int index = array.linearSearch(value);
                    System.out.println(index >= 0 ? "Linear Search: found at index " + index : "Linear Search: not found.");
                }
                case 2 -> {
                    int value = readInt("Enter value: ");
                    int[] sorted = array.getSortedData();
                    int index = Searching.binarySearch(sorted, value);
                    System.out.println(index >= 0 ? "Binary Search: found at sorted index " + index : "Binary Search: not found.");
                    System.out.print("Sorted data: ");
                    for (int item : sorted) System.out.print(item + " ");
                    System.out.println();
                }
                case 3 -> back = true;
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void graphMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--------------- GRAPH OPERATIONS ---------------");
            System.out.println("1. Add Vertex");
            System.out.println("2. Add Edge");
            System.out.println("3. Display Graph");
            System.out.println("4. BFS Traversal");
            System.out.println("5. DFS Traversal");
            System.out.println("6. Back");

            int choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1 -> graph.addVertex(readString("Enter vertex: "));
                case 2 -> {
                    String from = readString("Enter starting vertex: ");
                    String to = readString("Enter ending vertex: ");
                    graph.addEdge(from, to);
                }
                case 3 -> graph.display();
                case 4 -> graph.bfs(readString("Enter start vertex: "));
                case 5 -> graph.dfs(readString("Enter start vertex: "));
                case 6 -> back = true;
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void displayAllResults() {
        System.out.println("\n=============== ALL RESULTS ===============");
        System.out.println("Array:");
        array.display();
        System.out.println("Stack:");
        stack.display();
        System.out.println("Queue:");
        queue.display();
        System.out.println("Linked List:");
        linkedList.display();
        System.out.println("Graph:");
        graph.display();
        System.out.println("============================================");
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private static String readString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) return input;
            System.out.println("Input cannot be empty.");
        }
    }
}
