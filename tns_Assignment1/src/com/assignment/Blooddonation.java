package com.assignment;
import java.util.Scanner;

public class Blooddonation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input age and weight
        System.out.print("Enter your age: ");
        int age = input.nextInt();

        System.out.print("Enter your weight (in kg): ");
        int weight = input.nextInt();

        // Check eligibility
        if (age >= 18 && weight >= 50) {
            System.out.println("You are eligible to donate blood.");
        } else {
            System.out.println("You are NOT eligible to donate blood.");
        }

        input.close();
    }
}
