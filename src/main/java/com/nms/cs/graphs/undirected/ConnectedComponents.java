package com.nms.cs.graphs.undirected;

public class ConnectedComponents {

    boolean[] visited;
    int[] id;
    int connectedComponentsCount;

    public ConnectedComponents(UndirectedGraph undirectedGraph) {
        visited = new boolean[undirectedGraph.numVertices];
        id = new int[undirectedGraph.numVertices];
        for (int index = 0; index < undirectedGraph.numVertices; index++) {
            if (visited[index] != true) {
                dfs(undirectedGraph, index);
                connectedComponentsCount++;
            }
        }
    }

    private void dfs(UndirectedGraph undirectedGraph, int vertex) {
        visited[vertex] = true;
        id[vertex] = connectedComponentsCount;
        for (int adjacentVertices : undirectedGraph.adjacentVertices(vertex)) {
            if (visited[adjacentVertices] != true) {
                dfs(undirectedGraph, adjacentVertices);
            }
        }
    }

    public int count() {
        return connectedComponentsCount;
    }

    public int id(int v) {
        return id[v];
    }

}
