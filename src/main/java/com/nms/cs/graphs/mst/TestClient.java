package com.nms.cs.graphs.mst;

import com.nms.cs.graphs.directed.DirectedGraph;
import com.nms.cs.graphs.directed.TopologicalSort;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class TestClient {

    public static void main(String[] args) throws IOException {

        String fileName = "src/main/resources/mstGraphInput";
        List<String> lines = Files.readAllLines(Paths.get(fileName));
        EdgeWeightedGraph graph = new EdgeWeightedGraph(8);
        for (String line : lines) {
            double[] graphParams = Arrays.stream(line.split(" ")).mapToDouble(Double::parseDouble).toArray();
            graph.addEdge(new Edge((int)graphParams[0], (int)graphParams[1], graphParams[2]));
        }

        //Connected Components
        KruskalMinimumSpanningTree kmst = new KruskalMinimumSpanningTree(graph);
        System.out.println(kmst.edges());
    }
}
