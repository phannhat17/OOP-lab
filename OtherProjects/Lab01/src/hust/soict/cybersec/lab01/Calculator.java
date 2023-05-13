package hust.soict.cybersec.lab01;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        double a = scanner.nextDouble();
        System.out.print("Enter the second number: ");
        double b = scanner.nextDouble();

        scanner.close();
        
        // Sum of the numbers
        System.out.print("Sum of the numbers: ");
        System.out.print(a + b);
        System.out.println();

        // Different of the numbers
        System.out.print("Different of the numbers: ");
        System.out.print(a - b);
        System.out.println();

        // Product of the numbers
        System.out.print("Product of the numbers: ");
        System.out.print(a * b);
        System.out.println();

        // Quotient of the numbers
        System.out.print("Quotient of the numbers: ");
        System.out.print(a/b);
        System.out.println();

    }
    
}