package com.nms.cs.stack;

public class LinkedStack {

    private Node first;

    private class Node {
        String item;
        Node next;
    }

    public void push(String entry){
        Node newFirst = new Node();
        newFirst.item = entry;
        newFirst.next = first;
        first = newFirst;
        System.out.println("Pushed item:" + entry);
    }

    public String pop(){
        if(first != null){
            Node currentFirst = first;
            first =  first.next;
            return currentFirst.item;
        } else {
            return null;
        }
    }


}
