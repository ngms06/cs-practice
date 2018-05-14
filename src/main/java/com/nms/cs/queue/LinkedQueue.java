package com.nms.cs.queue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LinkedQueue {

    private Node head;
    private Node tail;

    private class Node {
        String item;
        Node next;
    }

    public void eneque(String item){
        Node newNode = new Node();
        newNode.item = item;
        if(tail != null){
            tail.next = newNode;
        }
        tail = newNode;
        if(head == null){
            head = newNode;
        }
    }

    public String dequeue(){
        Node currentHead = head;
        head = head.next;
        return currentHead.item;
    }

    private static void main(String[] args){
        LinkedQueue queue = new LinkedQueue();
        String fileName = "/Users/nsail/github/ngms06/cs-practice/src/main/resources/resources/stackQueueTest.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                if(line.equals("-")){
                    System.out.println("Dequed queue item: " + queue.dequeue());
                } else {
                    queue.eneque(line.trim());
                }
            }
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

}
