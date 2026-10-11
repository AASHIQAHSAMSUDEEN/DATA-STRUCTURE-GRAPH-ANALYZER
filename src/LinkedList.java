package datastructures;

public class LinkedListStructure {
	

	    private Node head;

	    // Insert a new value
	    public void insert(int data) {

	        Node newNode = new Node(data);

	        if (head == null) {
	            head = newNode;
	            return;
	        }

	        Node current = head;

	        while (current.next != null) {
	            current = current.next;
	        }

	        current.next = newNode;
	    }

	    // Delete a value
	    public boolean delete(int data) {

	        if (head == null) {
	            return false;
	        }

	        if (head.data == data) {
	            head = head.next;
	            return true;
	        }

	        Node current = head;

	        while (current.next != null) {

	            if (current.next.data == data) {
	                current.next = current.next.next;
	                return true;
	            }

	            current = current.next;
	        }

	        return false;
	    }

	    // Search for a value
	    public boolean search(int data) {

	        Node current = head;

	        while (current != null) {

	            if (current.data == data) {
	                return true;
	            }

	            current = current.next;
	        }

	        return false;
	    }

	    // Display the list
	    public void display() {

	        if (head == null) {
	            System.out.println("Linked List is empty.");
	            return;
	        }

	        Node current = head;

	        System.out.print("Linked List: ");

	        while (current != null) {

	            System.out.print(current.data);

	            if (current.next != null) {
	                System.out.print(" -> ");
	            }

	            current = current.next;
	        }

	        System.out.println(" -> NULL");
	    }
	}

