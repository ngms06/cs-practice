package com.nms.cs.priorityqueue;

import java.util.Arrays;

public class MinHeap<Item extends Comparable> {

    private Item[] priorityQueue;
    private int currentInsertIndex;

    public MinHeap(int capacity) {
        priorityQueue = (Item[]) new Comparable[capacity + 1];
        currentInsertIndex = 1;
    }

    public void insert(Item item) {
        priorityQueue[currentInsertIndex] = item;
        swim(currentInsertIndex);
    }

    //Update heap to have minimum element at root
    private void swim(int index) {
        int parentIndex = index / 2;
        while (parentIndex >= 1) {
            if (lesser(priorityQueue[index], priorityQueue[parentIndex])) {
                swap(index, parentIndex);
                index = parentIndex;
                parentIndex = index / 2;
            } else {
                break;
            }
        }
        currentInsertIndex++;
        System.out.println("Priority queue after swim: " + Arrays.toString(priorityQueue));
    }

    private boolean lesser(Item one, Item two) {
        return one.compareTo(two) < 0;
    }

    private void swap(int indexOne, int indexTwo) {
        System.out.println("Swapping " + priorityQueue[indexOne] + " and " + priorityQueue[indexTwo]);
        Item temp = priorityQueue[indexOne];
        priorityQueue[indexOne] = priorityQueue[indexTwo];
        priorityQueue[indexTwo] = temp;
    }

    public Item removeMin() {
        //Swap min element
        Item min = priorityQueue[1];
        System.out.println("Min element removed: " + min);
        swap(1, currentInsertIndex - 1);
        priorityQueue[currentInsertIndex - 1] = null;
        currentInsertIndex -= 1;
        sink(1);
        return min;
    }

    private void sink(int index) {

        while (2 * index <= currentInsertIndex - 1) {
            int leftChildIndex = (2 * index);
            int rightChildIndex = (2 * index) + 1;
            int swapIndex = (rightChildIndex > currentInsertIndex - 1) || lesser(priorityQueue[leftChildIndex],
                priorityQueue[rightChildIndex]) ? leftChildIndex : rightChildIndex;
            if (lesser(priorityQueue[swapIndex], priorityQueue[index])) {
                swap(index, swapIndex);
                index = swapIndex;
            } else {
                break;
            }
        }
        System.out.println("Priority queue after sink: " + Arrays.toString(priorityQueue));
    }

    public Item[] getPriorityQueue() {
        return priorityQueue;
    }

    public int size(){
        return priorityQueue.length - 1;
    }

    public static void main(String[] args) {
        MinHeap pqb = new MinHeap(12);
        pqb.insert("T");
        pqb.insert("P");
        pqb.insert("R");
        pqb.insert("N");
        pqb.insert("H");
        pqb.insert("O");
        pqb.insert("A");
        pqb.insert("E");
        pqb.insert("I");
        pqb.insert("G");
        pqb.insert("S");
        pqb.removeMin();
        pqb.removeMin();
    }
}
