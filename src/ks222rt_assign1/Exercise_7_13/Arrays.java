package ks222rt_assign1.Exercise_7_13;

import java.util.stream.IntStream;


/**
 * Created by Kristoffer on 2016-08-31.
 */
public class Arrays {

    protected static int sum(int[] arr){
        return IntStream.of(arr).sum();
    }

    protected static String toString(int[] arr){
        String str = "Array contains: ";
        for (int i : arr){
            str += Integer.toString(i) + ", ";
        }
        return str;
    }

    protected static int[] addN(int[] arr, int n){
        IntStream.range(0, arr.length).forEach(i -> arr[i] += n);
        return arr;
    }

    protected static int[] reverse(int[] arr){
        int[] newArr = new int[arr.length];
        IntStream.range(0, arr.length).forEachOrdered(i -> newArr[i] = arr[arr.length - i - 1]);
        return newArr;
    }

    protected static void replaceAll(int[] arr, int old, int nw){
        IntStream.range(0, arr.length).filter(i -> arr[i] == old).forEachOrdered(i -> arr[i] = nw);
    }

    protected static int[] sort(int[] arr){
        int [] newArr = new int[arr.length];
        IntStream.range(0, arr.length).forEachOrdered(i -> newArr[i] = arr[i]);
        java.util.Arrays.sort(newArr);
        return newArr;
    }

    protected static boolean hasSubsequence(int[] arr, int[] sub){
        if (arr.length < sub.length){
            throw new Error("Sub array is longer than the right array!");
        }

        for (int i = 0; i < arr.length; i++){
            if (arr[i] == sub[0]){
                for (int k = 0; k < sub.length; k++){
                    if ((i + k) < arr.length) {
                        if (arr[i + k] != sub[k]) {
                            break;
                        }
                        if (k + 1 == sub.length) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    protected static int[] absDif(int[] arr1, int[] arr2) throws IndexOutOfBoundsException {
        if (arr1.length != arr2.length){
            throw new IndexOutOfBoundsException("Arrays have different sizes!");
        }
        int[] newArr = new int[arr1.length];
        IntStream.range(0, (arr1.length)).forEachOrdered(i -> newArr[i] = Math.abs(arr1[i] - arr2[i]));
        return newArr;
    }
}
