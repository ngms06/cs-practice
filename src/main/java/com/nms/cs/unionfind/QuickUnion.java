package com.nms.cs.unionfind;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class QuickUnion {


    public int[] items;
    public int[] sizeOfConnectedComponents;

    public QuickUnion(int numItems){
        items = new int[numItems];
        sizeOfConnectedComponents = new int[numItems];
        for(int i = 0; i < numItems; i++){
            items[i] = i;
            sizeOfConnectedComponents[i] = 1;
        }
    }

    public boolean connected(int itemOne, int itemTwo){
        return (root(itemOne) == root(itemTwo));
    }

    public int root(int item){
        while (items[item] != item){
            item = items[item];
        }
        return item;
    }

    public void weightedUnion(int itemOne, int itemTwo){

        int sizeItemOne = sizeOfConnectedComponents[itemOne];
        int sizeItemTwo = sizeOfConnectedComponents[itemTwo];

        if(sizeItemOne > sizeItemTwo){
            items[root(itemTwo)] = root(itemOne);
            sizeOfConnectedComponents[itemOne] += sizeOfConnectedComponents[itemTwo];
        } else {
            items[root(itemOne)] = root(itemTwo);
            sizeOfConnectedComponents[itemTwo] += sizeOfConnectedComponents[itemOne];
        }
    }

    public void quickUnion(int itemOne, int itemTwo){
        items[root(itemOne)] = root(itemTwo);
    }

    @Override
    public String toString(){
        StringBuilder itemsInArray = new StringBuilder();
        for(int item : items){
            itemsInArray.append(item).append(":");
        }
        return itemsInArray.toString();
    }

    public static void main(String[] args){
        String fileName = "src/main/resources/quickUnionTest.txt";
        QuickUnion quf = null;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            int index = 0;
            String line;
            while ((line = br.readLine()) != null) {
                if(index == 0){
                    int items = Integer.parseInt(line);
                    quf = new QuickUnion(items);
                    index++;
                } else {
                    int itemOne = Integer.parseInt(line.split(" ")[0].trim());
                    int itemTwo = Integer.parseInt(line.split(" ")[1].trim());
                    if(!quf.connected(itemOne, itemTwo)){
                        System.out.println("Connecting items: " + itemOne + ":" + itemTwo);
                        quf.weightedUnion(itemOne, itemTwo);
                    } else {
                        System.out.println("Item are connected: " + itemOne + ":" + itemTwo);
                    }
                    System.out.println(quf.toString());
                }
            }
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

}
