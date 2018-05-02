package com.nms.cs;

import java.util.Arrays;

public class PriorityQueueBinaryHeap<Item extends Comparable> {

    private Item[] priorityQueue;
    private int currentInsertIndex;

    public PriorityQueueBinaryHeap(int capacity) {
        priorityQueue = (Item[]) new Comparable[capacity + 1];
        currentInsertIndex = 1;
    }


    public void insert(Item item) {
        priorityQueue[currentInsertIndex] = item;
        swim(currentInsertIndex);
    }

    //Update heap to have maximum element at root
    private void swim(int index) {
        int parentIndex = index / 2;
        while (parentIndex >= 1) {
            if (greater(priorityQueue[index], priorityQueue[parentIndex])) {
                swap(index, parentIndex);
                index = parentIndex;
                parentIndex = index / 2;
                System.out.println(index + ":" + parentIndex);
            } else {
                break;
            }
        }
        currentInsertIndex++;
        System.out.println(Arrays.toString(priorityQueue));
    }

    private boolean greater(Item one, Item two) {
        return one.compareTo(two) > 0;
    }

    private void swap(int indexOne, int indexTwo) {
        System.out.println("Swapping " + priorityQueue[indexOne] + " and " + priorityQueue[indexTwo]);
        Item temp = priorityQueue[indexOne];
        priorityQueue[indexOne] = priorityQueue[indexTwo];
        priorityQueue[indexTwo] = temp;
    }

    public Item removeMax() {
        //Swap max element
        Item max = priorityQueue[currentInsertIndex - 1];
        swap(1, currentInsertIndex - 1);
        priorityQueue[currentInsertIndex - 1] = null;
        currentInsertIndex -= 1;
        sink(1);
        return max;
    }

    private void sink(int index) {

        while (2 * index <= currentInsertIndex - 1) {
            int leftChildIndex = (2 * index);
            int rightChildIndex = (2 * index) + 1;
            int swapIndex = (rightChildIndex > currentInsertIndex - 1) || greater(priorityQueue[leftChildIndex],
                priorityQueue[rightChildIndex]) ? leftChildIndex : rightChildIndex;
            if (greater(priorityQueue[swapIndex], priorityQueue[index])) {
                swap(index, swapIndex);
                index = swapIndex;
            } else {
                break;
            }
        }
        System.out.println(Arrays.toString(priorityQueue));
    }

    public static void main(String[] args) {
        PriorityQueueBinaryHeap pqb = new PriorityQueueBinaryHeap(12);
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
        pqb.removeMax();
        pqb.removeMax();
    }

}
