/*
 * UoW ID: w2121174
 * IIT ID: 20230641
 * Name: Thakshila Deshani
 */

public class CycleDetector {

    /**
     * determines whether a graph is acyclic using the Sink Elimination Algorithm
     */
    public static boolean isAcyclic(Graph graph) {

        // A graph is acyclic if it has no vertices.
        if (graph.getVertices().isEmpty()) {
            return true;
        }

        // Continue until the graph is empty.
        while (!graph.getVertices().isEmpty()) {

            Integer sink = graph.findSink();

            // If there is no sink, there is a cycle.
            if (sink == null) {
                return false;
            }

            // Print sink removal step
            System.out.println("Removing sink: " + sink);

            // Remove sink from graph
            graph.removeVertex(sink);
        }

        // Acyclic graph with full reduction
        return true;
    }
}