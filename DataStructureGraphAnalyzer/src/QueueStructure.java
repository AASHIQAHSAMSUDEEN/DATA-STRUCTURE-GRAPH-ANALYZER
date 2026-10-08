public class QueueStructure {
    private final int[] queue;
    private int front;
    private int rear;
    private int size;

    public QueueStructure(int capacity) {
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(int value) {
        if (size == queue.length) {
            System.out.println("Queue is full.");
            return;
        }

        rear = (rear + 1) % queue.length;
        queue[rear] = value;
        size++;
        System.out.println("Enqueued " + value + ".");
    }

    public void dequeue() {
        if (size == 0) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return;
        }

        int value = queue[front];
        front = (front + 1) % queue.length;
        size--;
        System.out.println("Dequeued " + value + ".");
    }

    public void front() {
        if (size == 0) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.println("Front element: " + queue[front]);
    }

    public void display() {
        if (size == 0) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.print("Queue (front to rear): ");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % queue.length;
            System.out.print(queue[index] + (i < size - 1 ? " " : ""));
        }
        System.out.println();
    }
}
