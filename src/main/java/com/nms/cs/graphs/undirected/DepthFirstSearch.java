package com.nms.cs.graphs.undirected;

import java.util.List;
import java.util.Stack;

public class DepthFirstSearch {

    boolean[] visited;
    int[] pathTo;
    int source;

    public DepthFirstSearch(UndirectedGraph undirectedGraph, int source){
        this.source = source;
        visited = new boolean[undirectedGraph.numVertices];
        pathTo = new int[undirectedGraph.numVertices];
        dfs(undirectedGraph, source);
    }

    private void dfs(UndirectedGraph undirectedGraph, int source){
        visited[source] = true;
        for(int vertex : undirectedGraph.adjacentVertices(source)){
            if(visited[vertex] != true){
                dfs(undirectedGraph, vertex);
                pathTo[vertex] = source;
            }
        }
    }

    public boolean hasPath(int vertex){
        return visited[vertex];
    }

    public List<Integer> getPath(int vertex){
        Stack<Integer> path = new Stack<>();
        int upstream = pathTo[vertex];
        while (upstream != source){
            path.add(upstream);
            upstream = pathTo[upstream];
        }
        path.add(source);
        return path;
    }



}
