package com.tns_Assignment5;
import java.util.Scanner;

class AirIndia {
    protected double hours;
    protected double costPerHour;

    public AirIndia(double hours, double costPerHour) {
        this.hours = hours;
        this.costPerHour = costPerHour;
    }

    public double calculateAmount() {
        return hours * costPerHour;
    }
}

class KingFisher extends AirIndia {

    public KingFisher(double hours, double costPerHour) {
        super(hours, costPerHour);
    }

    @Override
    public double calculateAmount() {
        return super.calculateAmount() * 4;
    }
}

class Indigo extends KingFisher {

    public Indigo(double hours, double costPerHour) {
        super(hours, costPerHour);
    }

    @Override
    public double calculateAmount() {
        return super.calculateAmount() * 2; // Total multiplier = 4 * 2 = 8
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice = Integer.parseInt(scanner.nextLine().trim());
        double hours = Double.parseDouble(scanner.nextLine().trim());
        double costPerHour = Double.parseDouble(scanner.nextLine().trim());

        double result = 0;

        switch (choice) {
            case 1:
                AirIndia ai = new AirIndia(hours, costPerHour);
                result = ai.calculateAmount();
                break;
            case 2:
                KingFisher kf = new KingFisher(hours, costPerHour);
                result = kf.calculateAmount();
                break;
            case 3:
                Indigo ig = new Indigo(hours, costPerHour);
                result = ig.calculateAmount();
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        System.out.printf("%.2f\n", result);
    }
}