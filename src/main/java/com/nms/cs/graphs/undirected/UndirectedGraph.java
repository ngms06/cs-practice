package com.nms.cs.graphs.undirected;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of graph using adjacency lists
 */
public class UndirectedGraph {
    public int numVertices;
    public List<Integer>[] adjList;

    public UndirectedGraph(int numVertices){
        this.numVertices = numVertices;
        adjList = (List<Integer>[])new ArrayList[numVertices];
        for(int index = 0; index < numVertices; index++){
            adjList[index] = new ArrayList();
        }
    }

    public void addEdge(int v, int w){
        adjList[v].add(w);
        adjList[w].add(v);
    }

    public List<Integer> adjacentVertices(int v){
        return adjList[v];
    }

}
