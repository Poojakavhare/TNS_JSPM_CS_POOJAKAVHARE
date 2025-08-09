package com.tns_Assignment3;
import java.util.Scanner;
class TicketBooking {
    private String stageEvent;
    private String customer;
    private Integer noOfSeats;

    
    public TicketBooking() {}

    
    public TicketBooking(String stageEvent, String customer, Integer noOfSeats) {
        this.stageEvent = stageEvent;
        this.customer = customer;
        this.noOfSeats = noOfSeats;
    }

    
    public String getStageEvent() {
        return stageEvent;
    }

    public String getCustomer() {
        return customer;
    }

    public Integer getNoOfSeats() {
        return noOfSeats;
    }

   
    public void setStageEvent(String stageEvent) {
        this.stageEvent = stageEvent;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public void setNoOfSeats(Integer noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    
    public void makePayment(Double amount) {
        System.out.printf("Amount %.1f paid in cash\n", amount);
    }

    public void makePayment(String walletNumber, Double amount) {
        System.out.printf("Amount %.1f paid using wallet number %s\n", amount, walletNumber);
    }

    public void makePayment(String creditCard, String ccv, String name, Double amount) {
        System.out.printf("Holder name:%s\n", name);
        System.out.printf("Amount %.1f paid using %s card\n", amount, creditCard);
        System.out.printf("CCV:%s\n", ccv);
    }
}
public class Ticket_Booking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read booking details
        String[] input = sc.nextLine().split(",");
        String stageEvent = input[0];
        String customer = input[1];
        int noOfSeats = Integer.parseInt(input[2]);

        
        TicketBooking tb = new TicketBooking(stageEvent, customer, noOfSeats);

        int choice = sc.nextInt();
        sc.nextLine(); 

        
        System.out.println("Stage event:" + tb.getStageEvent());
        System.out.println("Customer:" + tb.getCustomer());
        System.out.println("Number of seats:" + tb.getNoOfSeats());

       
        switch (choice) {
            case 1:
                double cashAmount = sc.nextDouble();
                tb.makePayment(cashAmount);
                break;
            case 2:
                double walletAmount = sc.nextDouble();
                sc.nextLine(); // consume newline
                String walletNumber = sc.nextLine();
                tb.makePayment(walletNumber, walletAmount);
                break;
            case 3:
                String name = sc.nextLine();
                double creditAmount = sc.nextDouble();
                sc.nextLine(); // consume newline
                String creditCard = sc.nextLine();
                String ccv = sc.nextLine();
                tb.makePayment(creditCard, ccv, name, creditAmount);
                break;
            default:
                System.out.println("Invalid choice");
        }

        sc.close();
    }
}