/*
 * UoW ID: w2121174
 * IIT ID: 20230641
 * Name: Thakshila Deshani
 */

import java.util.*;

public class Graph {

    // Graph representation with an adjacency list
    private final Map<Integer, List<Integer>> adjList;

    // Constructor
    public Graph() {
        adjList = new HashMap<>();
    }

    /**
     * Include a directed edge from "from" to "to."
     */
    public void addEdge(int from, int to) {
        adjList.putIfAbsent(from, new ArrayList<>());
        adjList.putIfAbsent(to, new ArrayList<>());

        adjList.get(from).add(to);
    }

    /**
     * Obtain every vertex in the graph
     */
    public Set<Integer> getVertices() {
        return adjList.keySet();
    }

    /**
     * Locate a sink, which is a vertex without any outgoing edges.
     */
    public Integer findSink() {
        for (int v : adjList.keySet()) {
            if (adjList.get(v).isEmpty()) {
                return v;
            }
        }
        return null;
    }

    /**
     * Eliminate a vertex and every edge that points to it.
     */
    public void removeVertex(int v) {
        adjList.remove(v);

        // Remove incoming edges
        for (List<Integer> edges : adjList.values()) {
            edges.remove(Integer.valueOf(v));
        }
    }

    /**
     * Get adjacency list (used by DFS)
     */
    public Map<Integer, List<Integer>> getAdjList() {
        return adjList;
    }
}