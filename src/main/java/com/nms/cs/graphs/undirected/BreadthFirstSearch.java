package com.nms.cs.graphs.undirected;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BreadthFirstSearch {

    boolean[] visited;
    int[] edgeTo;
    int source;

    public BreadthFirstSearch(UndirectedGraph undirectedGraph, int source){
        this.source = source;
        visited = new boolean[undirectedGraph.numVertices];
        edgeTo = new int[undirectedGraph.numVertices];
        bfs(undirectedGraph, source);
    }

    public void bfs(UndirectedGraph undirectedGraph, int source){
        Queue<Integer> queue = new LinkedList();
        queue.add(source);
        visited[source] = true;
        while (queue.isEmpty()){
            int sourceVertex = queue.poll();
            for(int vertex : undirectedGraph.adjacentVertices(sourceVertex)){
                if(visited[vertex] != true){
                    queue.add(vertex);
                    visited[vertex] = true;
                    edgeTo[vertex] = sourceVertex;
                }
            }
        }
    }

    public boolean hasPath(int vertex){
        return visited[vertex];
    }

    public List<Integer> path(int vertex){
        Stack path = new Stack();
        int pathVertex = edgeTo[vertex];
        if(pathVertex != source){
            path.add(pathVertex);
            pathVertex = edgeTo[pathVertex];
        }
        path.add(source);
        return path;
    }

}
