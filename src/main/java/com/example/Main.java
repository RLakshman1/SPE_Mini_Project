package com.example;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Scientific Calculator (type numbers then press Enter).");
        boolean running = true;
        while (running) {
            printMenu();
            String choice = scanner.hasNext() ? scanner.next() : "5";
            switch (choice.trim()) {
                case "1":
                    System.out.print("Enter number for sqrt: ");
                    double sx = readDouble();
                    try {
                        System.out.println("sqrt(" + sx + ") = " + ScientificCalculator.sqrt(sx));
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case "2":
                    System.out.print("Enter integer for factorial: ");
                    int n = readInt();
                    try {
                        System.out.println(n + "! = " + ScientificCalculator.factorial(n));
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case "3":
                    System.out.print("Enter number for ln: ");
                    double lx = readDouble();
                    try {
                        System.out.println("ln(" + lx + ") = " + ScientificCalculator.ln(lx));
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case "4":
                    System.out.print("Enter base x: ");
                    double x = readDouble();
                    System.out.print("Enter exponent b: ");
                    double b = readDouble();
                    System.out.println(x + "^" + b + " = " + ScientificCalculator.power(x, b));
                    break;
                case "5":
                    System.out.println("Exiting.");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice: " + choice);
            }
            System.out.println(); // blank line
        }
    }

    private static void printMenu() {
        System.out.println("---------------------------");
        System.out.println("1) Square root (√x)");
        System.out.println("2) Factorial (n!)");
        System.out.println("3) Natural log (ln x)");
        System.out.println("4) Power (x^b)");
        System.out.println("5) Exit");
        System.out.print("Choose an option: ");
    }

    private static double readDouble() {
        while (!scanner.hasNextDouble()) {
            String s = scanner.next();
            System.out.println("Please enter a numeric value, got: '" + s + "'");
        }
        return scanner.nextDouble();
    }

    private static int readInt() {
        while (!scanner.hasNextInt()) {
            String s = scanner.next();
            System.out.println("Please enter an integer value, got: '" + s + "'");
        }
        return scanner.nextInt();
    }
}
