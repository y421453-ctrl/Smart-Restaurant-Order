
/*
student name : yaser saad
Roll number : 202510460 

*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        final double DRINK_PRICE = 15.50;
        final double STUDENT_DISCOUNT_RATE = 0.10;
        final double SENIOR_DISCOUNT_RATE = 0.05;
        final double TIP_RATE = 0.10;

        System.out.print("Enter customer's name: ");
        String customerName = input.nextLine();

        System.out.print("Enter customer's age: ");
        int age = input.nextInt();

        System.out.print("Enter meal price: $");
        double mealPrice = input.nextDouble();

        System.out.print("Enter number of drinks: ");
        int numberOfDrinks = input.nextInt();

        System.out.print("Is the customer a student? (true/false): ");
        boolean isStudent = input.nextBoolean();

        System.out.print("Enter service rating (1 to 5): ");
        int serviceRating = input.nextInt();

        if (serviceRating < 1 || serviceRating > 5) {
            System.out.println("Error: Service rating must be between 1 and 5.");
            input.close();
            return;
        } else if (mealPrice < 0 || numberOfDrinks < 0 || age < 0) {
            System.out.println("Error: Age, meal price, and number of drinks cannot be negative.");
            input.close();
            return;
        } else {
            // Calculate meal and drinks costs
            double drinksCost = numberOfDrinks * DRINK_PRICE;
            double subtotal = mealPrice + drinksCost;

            double discountRate = 0.0;

            if (isStudent && age >= 60) {
                discountRate = STUDENT_DISCOUNT_RATE;
            } else if (isStudent) {
                discountRate = STUDENT_DISCOUNT_RATE;
            } else if (age >= 60) {
                discountRate = SENIOR_DISCOUNT_RATE;
            } else {
                discountRate = 0.0;
            }

            double discountAmount = subtotal * discountRate;
            double amountAfterDiscount = subtotal - discountAmount;

            
            double tipAmount;
            if (serviceRating == 4 || serviceRating == 5) {
                tipAmount = amountAfterDiscount * TIP_RATE;
            } else {
                tipAmount = 0.0;
            }

            double finalBill = amountAfterDiscount + tipAmount;
            int wholeAmount = (int) finalBill;

            // Print the receipt
            System.out.println();
            System.out.println("========== SMART RESTAURANT ==========");
            System.out.println("Customer: " + customerName);
            System.out.printf("Meal: $%.2f%n", mealPrice);
            System.out.printf("Drinks: $%.2f%n", drinksCost);
            System.out.printf("Discount: $%.2f%n", discountAmount);
            System.out.printf("Tip: $%.2f%n", tipAmount);
            System.out.printf("Final bill: $%.2f%n", finalBill);
            System.out.println("Whole amount: $" + wholeAmount);
            System.out.println("======================================");
        }

        input.close();
    }
}
