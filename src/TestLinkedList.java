package datastructures;

public class LinkedListTest {


	    public static void main(String[] args) {

	        LinkedListStructure list = new LinkedListStructure();

	        System.out.println("=== LINKED LIST DEMO ===");

	        // Insert
	        System.out.println("\n1. Inserting values:");

	        list.insert(10);
	        list.insert(20);
	        list.insert(30);
	        list.insert(40);

	        list.display();

	        // Search
	        System.out.println("\n2. Searching for 30:");

	        if (list.search(30)) {
	            System.out.println("30 found.");
	        } else {
	            System.out.println("30 not found.");
	        }

	        // Delete
	        System.out.println("\n3. Deleting 20:");

	        if (list.delete(20)) {
	            System.out.println("20 deleted successfully.");
	        } else {
	            System.out.println("20 not found.");
	        }

	        // Display after deletion
	        System.out.println("\n4. List after deletion:");

	        list.display();

	        // Search deleted value
	        System.out.println("\n5. Searching for 20:");

	        if (list.search(20)) {
	            System.out.println("20 found.");
	        } else {
	            System.out.println("20 not found.");
	        }
	    }
	}

