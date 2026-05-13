/*
 * UoW ID: w2121174
 * IIT ID: 20230641
 * Name: Thakshila Deshani
 */

import java.util.*;

public class CycleFinder {

    /**
     * uses DFS to locate and display a cycle in the provided graph.
     */
    public static void findCycle(Graph graph) {

        // Track visited nodes
        Set<Integer> visited = new HashSet<>();

        // Keep track of the nodes in the recursion stack.
        Set<Integer> recursionStack = new HashSet<>();

        // To recreate the cycle, store parent relationships.
        Map<Integer, Integer> parent = new HashMap<>();

        // Execute DFS from every vertex.
        for (int vertex : graph.getVertices()) {
            if (dfs(vertex, graph, visited, recursionStack, parent)) {
                return; // Stop after finding first cycle
            }
        }
    }

    /**
     * To find a cycle, use Depth First Search.
     */
    private static boolean dfs(int v, Graph graph, Set<Integer> visited,
                               Set<Integer> stack, Map<Integer, Integer> parent) {

        visited.add(v);   // Mark node as visited
        stack.add(v);     // Add to recursion stack

        // Traverse all neighbors
        for (int neighbor : graph.getAdjList().getOrDefault(v, new ArrayList<>())) {

            // If not visited, continue DFS
            if (!visited.contains(neighbor)) {

                parent.put(neighbor, v); // Set parent

                if (dfs(neighbor, graph, visited, stack, parent)) {
                    return true;
                }

            }
            // A cycle is identified if the neighbor is in the recursion stack.
            else if (stack.contains(neighbor)) {

                List<Integer> cycle = new ArrayList<>();
                int current = v;

                // Begin the cycle at the identified node.
                cycle.add(neighbor);

                // Use the parent map to trace back
                while (current != neighbor) {
                    cycle.add(current);
                    current = parent.get(current);
                }

                cycle.add(neighbor); // Close the cycle

                // Reverse to the proper sequence
                Collections.reverse(cycle);

                // Print cycle
                for (int i = 0; i < cycle.size() - 1; i++) {
                    System.out.print(cycle.get(i) + " → ");
                }

                System.out.println(cycle.get(cycle.size() - 1));

                return true;
            }
        }

        stack.remove(v); // Remove from recursion stack
        return false;
    }
}