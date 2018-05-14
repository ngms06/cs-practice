package com.nms.cs.graphs.directed;

import com.nms.cs.graphs.undirected.UndirectedGraph;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TopologicalSort {

    Stack<Integer> reversePostOrder;
    boolean[] visited;

    public TopologicalSort(DirectedGraph directedGraph){
        visited = new boolean[directedGraph.numVertices];
        reversePostOrder = new Stack<>();
        for(int vertex = 0; vertex < directedGraph.numVertices; vertex++ ){
            if(!visited[vertex]){
                dfs(directedGraph, vertex);
            }
        }
    }

    private void dfs(DirectedGraph directedGraph, int vertex){
        visited[vertex] = true;
        for(int adjVertex : directedGraph.adjacentVertices(vertex)){
            System.out.println("Adjacent vertex: " + adjVertex);
            if(visited[adjVertex] != true) {
                dfs(directedGraph, adjVertex);
            }
        }
        System.out.println("Adding vertex to stack: " + vertex);
        reversePostOrder.push(vertex);
    }

    public List<Integer> getOrder(){
        return reversePostOrder;
    }

}
