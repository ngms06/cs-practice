package com.nms.cs.graphs.directed;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of graph using adjacency lists
 */
public class DirectedGraph {

    public int numVertices;
    public List<Integer>[] adjList;

    public DirectedGraph(int numVertices) {
        this.numVertices = numVertices;
        adjList = (List<Integer>[]) new ArrayList[numVertices];
        for (int index = 0; index < numVertices; index++) {
            adjList[index] = new ArrayList();
        }
    }

    public void addEdge(int v, int w) {
        adjList[v].add(w);
    }

    public List<Integer> adjacentVertices(int v) {
        return adjList[v];
    }

}
