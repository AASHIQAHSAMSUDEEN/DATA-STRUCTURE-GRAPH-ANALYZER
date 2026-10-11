public class StackStructure {
    private final int[] stack;
    private int top;

    public StackStructure(int capacity) {
        stack = new int[capacity];
        top = -1;
    }

    public void push(int value) {
        if (top == stack.length - 1) {
            System.out.println("Stack overflow. Stack is full.");
            return;
        }
        stack[++top] = value;
        System.out.println("Pushed " + value + ".");
    }

    public void pop() {
        if (top == -1) {
            System.out.println("Stack is empty. Cannot pop.");
            return;
        }
        System.out.println("Popped " + stack[top--] + ".");
    }

    public void peek() {
        if (top == -1) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.println("Top element: " + stack[top]);
    }

    public void display() {
        if (top == -1) {
            System.out.println("Stack is empty.");
            return;
        }

        System.out.print("Stack (top to bottom): ");
        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + (i > 0 ? " " : ""));
        }
        System.out.println();
    }
}
