import java.util.*;

public class Graph {
    private final Map<String, List<String>> adjacencyList = new LinkedHashMap<>();

    public void addVertex(String vertex) {
        if (adjacencyList.containsKey(vertex)) {
            System.out.println("Vertex already exists.");
            return;
        }

        adjacencyList.put(vertex, new ArrayList<>());
        System.out.println("Vertex " + vertex + " added.");
    }

    public void addEdge(String from, String to) {
        if (!adjacencyList.containsKey(from) || !adjacencyList.containsKey(to)) {
            System.out.println("Both vertices must exist before adding an edge.");
            return;
        }

        if (!adjacencyList.get(from).contains(to)) {
            adjacencyList.get(from).add(to);
        }

        if (!adjacencyList.get(to).contains(from)) {
            adjacencyList.get(to).add(from);
        }

        System.out.println("Edge added between " + from + " and " + to + ".");
    }

    public void display() {
        if (adjacencyList.isEmpty()) {
            System.out.println("Graph is empty.");
            return;
        }

        System.out.println("Graph:");
        for (Map.Entry<String, List<String>> entry : adjacencyList.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public void bfs(String start) {
        if (!adjacencyList.containsKey(start)) {
            System.out.println("Start vertex does not exist.");
            return;
        }

        Set<String> visited = new LinkedHashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(start);
        visited.add(start);

        System.out.print("BFS Traversal: ");

        while (!queue.isEmpty()) {
            String current = queue.poll();
            System.out.print(current + " ");

            for (String neighbor : adjacencyList.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        System.out.println();
    }

    public void dfs(String start) {
        if (!adjacencyList.containsKey(start)) {
            System.out.println("Start vertex does not exist.");
            return;
        }

        Set<String> visited = new LinkedHashSet<>();
        System.out.print("DFS Traversal: ");
        dfsRecursive(start, visited);
        System.out.println();
    }

    private void dfsRecursive(String vertex, Set<String> visited) {
        visited.add(vertex);
        System.out.print(vertex + " ");

        for (String neighbor : adjacencyList.get(vertex)) {
            if (!visited.contains(neighbor)) {
                dfsRecursive(neighbor, visited);
            }
        }
    }

    public int vertexCount() {
        return adjacencyList.size();
    }

    public int edgeCount() {
        int total = 0;
        for (List<String> neighbors : adjacencyList.values()) {
            total += neighbors.size();
        }
        return total / 2;
    }
}
