package com.nms.cs.graphs.directed;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TestClient {

    public static void main(String[] args) throws IOException {

        String fileName = "src/main/resources/mstGraphInput";
        List<String> lines = Files.readAllLines(Paths.get(fileName));
        DirectedGraph directedGraph = new DirectedGraph(6);
        for (String line : lines) {
            String[] edges = line.split("->");
            directedGraph.addEdge(Integer.parseInt(edges[0].trim()), Integer.parseInt(edges[1].trim()));
        }

        //Connected Components
        TopologicalSort tps = new TopologicalSort(directedGraph);
        System.out.println(tps.getOrder());

    }
}
