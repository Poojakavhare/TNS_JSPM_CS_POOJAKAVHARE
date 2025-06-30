package com.assignment;
import java.util.Scanner;

public class Evenodd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  // Line 5

        System.out.print("Enter a number: "); // Line 6
        int num = sc.nextInt();

        if (num % 2 == 0) {
            System.out.println(num + " is Even.");
        } else {
            System.out.println(num + " is Odd.");
        }

        sc.close();
    }
}
