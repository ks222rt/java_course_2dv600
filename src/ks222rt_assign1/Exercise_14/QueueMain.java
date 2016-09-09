package ks222rt_assign1.Exercise_14;

import java.util.Iterator;

/**
 * Created by Kristoffer on 2016-09-07.
 */
public class QueueMain {
    public static void main(String[] args){
        Queue list = new Queue();

        // Test if list is empty
        if (list.isEmpty()){
            System.out.println("List is Empty");
        }

        // Test IndexOutOfBounds on function last()
        try{
            Object test = list.last();
        }catch(IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }

        // Test IndexOutOfBounds on function first()
        try{
            Object test = list.first();
        }catch(IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }

        // Test IndexOutOfBounds on function dequeue()
        try {
            Object test = list.dequeue();
        }catch(IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }

        // Test list size, should be 0
        System.out.println("list size = " + list.size());
        // Adding a new object
        list.enqueue(new TestNode(1337, "Elite"));
        // Test list size, should be 1
        System.out.println("list size = " + list.size());
        // Adding another object
        list.enqueue(new TestNode(12, "Kaffe"));
        // Test list size, should be 2
        System.out.println("list size = " + list.size());
        //Adding another object
        list.enqueue(new TestNode(1991, "Årtal"));
        // Test list size, should be 3
        System.out.println("list size = " + list.size());

        // Test if list is not empty
        if (!list.isEmpty()){
            System.out.println("List is not empty");
        }

        // Test last object in list, should be
        // TestNode.value = 1991 - TestNode.name = Årtal
        Object test = list.last();
        System.out.println("Last object...");
        TestNode test123 = ((TestNode) test);
        System.out.println(test123.value);
        System.out.println(test123.name);

        // Test first object in list, should be
        // TestNode.value = 1337 - TestNode.name = Elite
        Object test1 = list.first();
        System.out.println("First object..");
        test123 = ((TestNode) test1);
        System.out.println(test123.value);
        System.out.println(test123.name);

        // Test if the object contains in the list, should be true
        if (list.contains(test123)){
            System.out.println("Object contains in the list!");
        }

        // Test if the object contains in the list, should be false
        TestNode containTest = new TestNode(1, "hej");
        if (!list.contains(containTest)){
            System.out.println("Object doesnt exist in the list!");
        }

        Iterator it = list.iterator();

        // Try to iterate through list with listIterator
        System.out.println("Iterate through list with 'Homemade' iterator");
        while(it.hasNext()){
            Object testIterator = it.next();
            TestNode nodeIterator = ((TestNode) testIterator);
            System.out.println(nodeIterator.name + " - " + nodeIterator.value);
        }

        // Test dequeue function
        // Should return and remove first object
        // TestNode.value - 1337, TestNode.name - Elite
        System.out.println("----------------");
        System.out.println("Dequeue");
        System.out.println("list size = " + list.size());
        Object removeNode = list.dequeue();
        TestNode testNode123 = ((TestNode) removeNode);
        System.out.println(testNode123.value);
        System.out.println(testNode123.name);
        System.out.println("list size = " + list.size());

        // Try to iterate through list with listIterator
        it = list.iterator();
        System.out.println("------------------");
        System.out.println("Iterate through list with 'Homemade' iterator");
        while(it.hasNext()){
            Object testIterator = it.next();
            TestNode nodeIterator = ((TestNode) testIterator);
            System.out.println(nodeIterator.name + " - " + nodeIterator.value);
        }
    }

    private static class TestNode{
        int value;
        String name;

        public TestNode(int v, String n){
            this.value = v;
            this.name = n;
        }
    }
}
