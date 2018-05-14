package com.nms.cs.graphs.mst;

import com.nms.cs.priorityqueue.MaxHeap;
import com.nms.cs.priorityqueue.MinHeap;
import com.nms.cs.unionfind.QuickUnion;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class KruskalMinimumSpanningTree {

    Queue<Edge> mst = new LinkedList<>();
    public KruskalMinimumSpanningTree(EdgeWeightedGraph graph) {

        MinHeap<Edge> minHeap = new MinHeap<>(16); //Number of edges
        for(Edge edge : graph.edges()){
            minHeap.insert(edge);
        }
        System.out.println(Arrays.toString(minHeap.getPriorityQueue()));

        QuickUnion quf = new QuickUnion(graph.getNumVertices());
        while((mst.size() < graph.getNumVertices() - 1) && minHeap.size() > 0){
            Edge edge = minHeap.removeMin();
            int v = edge.either();
            int w = edge.other(v);
            if(!quf.connected(v,w)){
                quf.quickUnion(v,w);
                mst.add(edge);
            }
            System.out.println(mst);
        }
    }

    public Iterable<Edge> edges(){
        return mst;
    }
}
