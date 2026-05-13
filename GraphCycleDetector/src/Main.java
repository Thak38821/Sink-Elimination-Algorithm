/*
 * UoW ID: w2121174
 * IIT ID: 20230641
 * Name: Thakshila Deshani
 */

public static void main(String[] ignoredArgs) {
    try {
        // Graph parsing from an input file
        Graph graph = Parser.parseFile("input.txt");

        // Make a duplicate of the graph in order to perform acyclic checking.
        Graph copyGraph = Parser.parseFile("input.txt");

        // Determine if the graph is acyclic by applying sink elimination.
        boolean acyclic = CycleDetector.isAcyclic(copyGraph);

        // If graph is acyclic
        if (acyclic) {
            System.out.println("Yes");
            System.out.println("The graph is now empty");
        }
        // If graph contains a cycle
        else {
            System.out.println("No");
            System.out.println("No sink found — the graph contains a cycle.");

            // Using a DFS-based approach, print the observed cycle.
            System.out.println("Cycle detected in graph:");
            CycleFinder.findCycle(graph);
        }

    } catch (IOException e) {
        // Handle file reading errors
        e.printStackTrace();
    }
}