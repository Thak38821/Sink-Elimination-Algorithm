/*
 * UoW ID: w2121174
 * IIT ID: 20230641
 * Name: Thakshila Deshani
 */

import java.io.*;

public class Parser {

    /**
     * creates the Graph object after reading the graph from the input file.
     */
    public static Graph parseFile(String filename) throws IOException {

        Graph graph = new Graph();

        // Read file line by line
        BufferedReader br = new BufferedReader(new FileReader(filename));

        String line;

        while ((line = br.readLine()) != null) {

            line = line.trim(); // Remove spaces

            // Skip empty lines
            if (line.isEmpty()) {
                continue;
            }

            // Split line into parts
            String[] parts = line.split("\\s+");

            // Check the format
            if (parts.length < 2) {
                System.out.println("Skipping invalid line: " + line);
                continue;
            }

            try {
                int from = Integer.parseInt(parts[0]);
                int to = Integer.parseInt(parts[1]);

                // Include an edge in the graph
                graph.addEdge(from, to);

            } catch (NumberFormatException e) {
                System.out.println("Skipping invalid numbers in line: " + line);
            }
        }

        br.close();
        return graph;
    }
}