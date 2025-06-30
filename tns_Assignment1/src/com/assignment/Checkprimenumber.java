package com.assignment;
	import java.util.Scanner;

	public class Checkprimenumber {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);  // Make sure this is written correctly

	        System.out.print("Enter a number: ");
	        int num = sc.nextInt();

	        boolean isPrime = true;

	        if (num <= 1) {
	            isPrime = false;
	        } else {
	            for (int i = 2; i <= Math.sqrt(num); i++) {
	                if (num % i == 0) {
	                    isPrime = false;
	                    break;
	                }
	            }
	        }

	        if (isPrime) {
	            System.out.println(num + " is a Prime number.");
	        } else {
	            System.out.println(num + " is NOT a Prime number.");
	        }

	        sc.close();
	    }
	}
