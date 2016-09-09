package ks222rt_assign1.Exercise_1_to_6;

/**
 * Created by Kristoffer on 2016-08-29.
 *
 * Takes an input string and shows it reversed!
 */

import java.util.Scanner;

public class Backwards {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.print("Enter a text: ");
        String text = console.nextLine();
        StringBuilder reverse = new StringBuilder();

        System.out.println("You wrote: " + text);
        System.out.println("Backwards: " + reverse.append(text).reverse());
    }
}
