package ks222rt_assign1.Exercise_7_13;

/**
 * Created by Kristoffer on 2016-08-31.
 */
public class ArraysMain {
    private static int[] testArray = {1, 2, 3, 4, 5};
    private static int[] diffArray = {8, 1, 4, 1, 2};
    private static int[] hasSubArray = {2, 3, 4, 5, 6, 7};
    private static int[] isSubArray = {4, 5, 6};
    private static int[] isNotSubArray = {6, 7, 5};

    public static void main(String[] args){
        Arrays arrayClass = new Arrays();

        // Function sum
        System.out.println("Testing function: sum");
        int sum = arrayClass.sum(testArray);
        System.out.println("Sum of the array is: " + sum);
        System.out.println("--------------------------");

        // Function toString
        System.out.println("Testing function: toString");
        System.out.println(arrayClass.toString(testArray));
        System.out.println("--------------------------");

        // Function addN
        System.out.println("Testing function: addN");
        int[] arr1 = arrayClass.addN(testArray, 2);
        for (int i : arr1){
            System.out.println(Integer.toString(i) + ", ");
        }
        System.out.println("--------------------------");

        // Function reverse
        System.out.println("Testing function: reverse");
        int[] arr2 = arrayClass.reverse(testArray);
        System.out.println("Old array:" );
        for (int i : testArray){
            System.out.print(Integer.toString(i));
        }
        System.out.println();
        System.out.println("Reversed array:");
        for (int i : arr2){
            System.out.print(Integer.toString(i));
        }
        System.out.println();
        System.out.println("--------------------------");

        // Function replaceAll
        System.out.println("Testing function: replaceAll");
        System.out.println("Old array:");
        for (int i : testArray){
            System.out.print(Integer.toString(i));
        }
        arrayClass.replaceAll(testArray, 3, 6);
        System.out.println();
        System.out.println("New array:");
        for (int i : testArray){
            System.out.print(Integer.toString(i));
        }
        System.out.println();
        System.out.println("--------------------------");

        // Function sort
        System.out.println("Testing function: sort");
        int[] arr4 = arrayClass.sort(testArray);
        System.out.println("Old array:");
        for (int i : testArray){
            System.out.print(Integer.toString(i));
        }
        System.out.println();
        System.out.println("Sorted Array:");
        for (int i : arr4){
            System.out.print(Integer.toString(i));
        }
        System.out.println();
        System.out.println("--------------------------");

        // Function hasSubsequence
        System.out.println("Testing function: hasSubsequence");
        System.out.println("Is: " + arrayClass.toString(isNotSubArray) + " a subsquence to: " + arrayClass.toString(hasSubArray) + "?");
        boolean isit = arrayClass.hasSubsequence(hasSubArray, isNotSubArray);
        System.out.println(isit);
        System.out.println("Is: " + arrayClass.toString(isSubArray) + " a subsquence to: " + arrayClass.toString(hasSubArray) + "?");
        isit = arrayClass.hasSubsequence(hasSubArray, isSubArray);
        System.out.println(isit);
        try{
            System.out.println("Is: " + arrayClass.toString(hasSubArray) + " longer than: " + arrayClass.toString(isSubArray) + "?");
            isit = arrayClass.hasSubsequence(testArray, hasSubArray);
        }catch(Error e){
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println();
        System.out.println("--------------------------");

        // Function absDif
        System.out.println("Testing function: absDif");
        System.out.println("Is: " + arrayClass.toString(hasSubArray) + " longer than: " + arrayClass.toString(isSubArray) + "?");
        try{
            int[] arr5 = arrayClass.absDif(hasSubArray, isSubArray);
        }catch(IndexOutOfBoundsException e){
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Difference between elements in: " + arrayClass.toString(testArray) + " and " + arrayClass.toString(diffArray) + "is =");
        int[] arr6 = arrayClass.absDif(testArray, diffArray);
        System.out.println(arrayClass.toString(arr6));
        System.out.println("--------------------------");
    }
}
