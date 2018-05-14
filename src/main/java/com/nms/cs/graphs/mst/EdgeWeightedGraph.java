package com.nms.cs.graphs.mst;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EdgeWeightedGraph {

    private List<Edge>[] edgeWeightedGraph;
    private int numVertices;

    public EdgeWeightedGraph(int numVertices){
        this.numVertices = numVertices;
        edgeWeightedGraph = (List<Edge>[]) new ArrayList[numVertices];
        for(int index = 0; index < numVertices; index++){
            edgeWeightedGraph[index] = new ArrayList<>();
        }
    }

    public void addEdge(Edge edge){
        int v = edge.either();
        int w = edge.other(v);
        edgeWeightedGraph[v].add(edge);
        edgeWeightedGraph[w].add(edge);
    }

    public Iterable<Edge> adjacentVertices(int vertex){
        return edgeWeightedGraph[vertex];
    }

    public int getNumVertices(){
        return this.numVertices;
    }

    public Set<Edge> edges(){
        Set<Edge> edges = new HashSet<Edge>();
        for(int index = 0; index < numVertices; index++){
            List<Edge> edgeList = edgeWeightedGraph[index];
            for(Edge edge : edgeList){
                edges.add(edge);
            }
        }
        return edges;
    }

}
