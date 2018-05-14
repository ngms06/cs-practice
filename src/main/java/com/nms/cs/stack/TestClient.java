package com.nms.cs.stack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TestClient {

    public static void main(String[] args){
        //ArrayStack stack = new ArrayStack(10);
        LinkedStack stack = new LinkedStack();
        String fileName = "/Users/nsail/github/ngms06/cs-practice/src/main/resources/stackQueueTest.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                if(line.equals("-")){
                    System.out.println("Popped stack item: " + stack.pop());
                } else {
                    stack.push(line.trim());
                }
            }
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

}
