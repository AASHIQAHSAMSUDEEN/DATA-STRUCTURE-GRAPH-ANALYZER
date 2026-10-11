public class PerformanceAnalyzer {

    public void showComparison(ArrayStructure array, Graph graph) {
        System.out.println("\n=============================================");
        System.out.println("          PERFORMANCE COMPARISON");
        System.out.println("=============================================");

        int[] data = array.getDataCopy();

        if (data.length == 0) {
            System.out.println("Add some values to the array first for a meaningful search comparison.");
        } else {
            int target = data[data.length - 1];
            int[] sorted = array.getSortedData();

            int linearSteps = Searching.linearSearchSteps(data, target);
            int binarySteps = Searching.binarySearchSteps(sorted, target);

            System.out.println("Search target: " + target);
            System.out.println("---------------------------------------------");
            System.out.println("Linear Search");
            System.out.println("Steps: " + linearSteps);
            System.out.println("Average complexity: O(n)");

            System.out.println("---------------------------------------------");
            System.out.println("Binary Search");
            System.out.println("Steps: " + binarySteps);
            System.out.println("Average complexity: O(log n)");
        }

        System.out.println("---------------------------------------------");
        System.out.println("Graph");
        System.out.println("Vertices: " + graph.vertexCount());
        System.out.println("Edges: " + graph.edgeCount());
        System.out.println("BFS complexity: O(V + E)");
        System.out.println("DFS complexity: O(V + E)");
        System.out.println("=============================================");
    }
}
