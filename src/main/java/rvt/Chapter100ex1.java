package rvt;

import java.util.Scanner;

public class Chapter100ex1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.print("Enter the numerator: ");
            String input = scanner.nextLine();

            if (input.startsWith("q")) {
                break;
            }

            int numerator;

            try {
                numerator = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("You entered bad data.");
                System.out.println("Please try again.");
                continue;
            }

            System.out.print("Enter the divisor: ");

            try {
                int divisor = Integer.parseInt(scanner.nextLine());
                int result = numerator / divisor;

                System.out.println(numerator + " / " + divisor + " is " + result);

            } catch (ArithmeticException e) {
                System.out.println("You can't divide " + numerator + " by 0");
            }
        }

        scanner.close();
    }
}