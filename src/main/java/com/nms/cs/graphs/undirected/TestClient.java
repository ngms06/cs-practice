package com.nms.cs.graphs.undirected;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class TestClient {

    public static void main(String[] args) throws IOException {

        String fileName = "/Users/nsail/github/ngms06/cs-practice/src/main/java/com/nms/cs/graphs/graphInput";
        List<String> lines = Files.readAllLines(Paths.get(fileName));
        UndirectedGraph undirectedGraph = new UndirectedGraph(13);
        for(String line : lines){
            String[] edges = line.split(" ");
            undirectedGraph.addEdge(Integer.parseInt(edges[0].trim()), Integer.parseInt(edges[1].trim()));
        }

        //DFS
        System.out.println(Arrays.toString(undirectedGraph.adjList));
        DepthFirstSearch dfs = new DepthFirstSearch(undirectedGraph, 0);
        System.out.println(dfs.hasPath(4));
        System.out.println(dfs.getPath(3));

        //BFS
        BreadthFirstSearch bfs = new BreadthFirstSearch(undirectedGraph, 0);
        System.out.println(dfs.hasPath(4));
        System.out.println(dfs.getPath(3));

        //Connected Components
        ConnectedComponents cc = new ConnectedComponents(undirectedGraph);
        System.out.println(cc.count());
        System.out.println(cc.id(0));
        System.out.println(cc.id(7));
        System.out.println(cc.id(11));



    }
}
