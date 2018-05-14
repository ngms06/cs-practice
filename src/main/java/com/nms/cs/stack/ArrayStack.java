package com.nms.cs.stack;

public class ArrayStack {

    private String[] arrayStack;
    private int currentHead = 0;

    public ArrayStack(int capacity){
        arrayStack = new String[capacity];
    }

    public void push(String item){
        arrayStack[currentHead++] = item;
        System.out.println("Pushed item:" + item);

    }

    public String pop(){
        return arrayStack[--currentHead];
    }

}
