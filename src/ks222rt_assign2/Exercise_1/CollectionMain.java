package ks222rt_assign2.Exercise_1;

import java.util.Iterator;

/**
 * Created by Kristoffer on 2016-09-13.
 */
public class CollectionMain {
    public static void main(String[] args){
        tryArrayIntList();
        tryArrayIntStack();
    }

    private static void tryArrayIntStack(){
        ArrayIntStack intStack = new ArrayIntStack();
        System.out.println("----------------------------------------");
        try {
            intStack.pop();
        }catch (IndexOutOfBoundsException e){
            System.out.println("Stack is empty, cant pop!");
        }

        try {
            intStack.peek();
        }catch(IndexOutOfBoundsException e){
            System.out.println("Stack is empty, cant peek!");
        }

        System.out.println("Stack size = " + intStack.size());
        for (int i = 0; i < 7; i++){
            intStack.push(i + 1);
        }

        System.out.println("Stack size = " + intStack.size());
        writeOutNumbersStack(intStack);
        System.out.println();

        int i = intStack.pop();
        System.out.println("Removed: " + i);

        System.out.println("Stack size = " + intStack.size());
        writeOutNumbersStack(intStack);
        System.out.println();

        int k = intStack.peek();
        System.out.println(k + " is peeking from the top!");
    }

    private static void tryArrayIntList(){
        ArrayIntList intList = new ArrayIntList();
        System.out.println();
        try{
            intList.addAt(1, 15);
        }catch(IndexOutOfBoundsException e){
            System.out.println("List is empty, cant addAt");
        }

        try{
            intList.remove(1);
        }catch(IndexOutOfBoundsException e){
            System.out.println("List is empty, cant remove!");
        }

        try{
            intList.get(1);
        }catch(IndexOutOfBoundsException e){
            System.out.println("List is empty, cant get index!");
        }

        System.out.println("Array size = " + intList.size());
        for (int i = 0; i < 14; i++){
            intList.add(i + 1);
        }

        System.out.println("Array size = " + intList.size());
        writeOutNumbers(intList);
        System.out.println();

        intList.addAt(1337, 3);

        System.out.println("Array size = " + intList.size());
        writeOutNumbers(intList);
        System.out.println();

        int i = intList.get(3);
        System.out.println("number at index 3 = " + i);

        intList.remove(3);
        System.out.println("Array size = " + intList.size());
        writeOutNumbers(intList);
        System.out.println();

        int k = intList.indexOf(5);
        if (k != -1){
            System.out.println("Number 5 is at index " + k);
        }

        k = intList.indexOf(1337);
        if (k == -1){
            System.out.println("Number 1337 aint in the list");
        }
    }

    private static void writeOutNumbers(ArrayIntList intList){
        Iterator it = intList.iterator();
        while (it.hasNext()){
            Object i = it.next();
            System.out.print(i + ", ");
        }
    }

    private static void writeOutNumbersStack(ArrayIntStack intStack){
        Iterator it = intStack.iterator();
        while (it.hasNext()){
            Object i = it.next();
            System.out.print(i + ", ");
        }
    }

}
