package hust.soict.cybersec.lab01;
import java.util.Scanner;

public class LinearSystem {
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Linear system with two variables solver!");
        System.out.println("a11 * x1 + a12 * x2 = b1");
        System.out.println("a21 * x1 + a22 * x2 = b2");

        System.out.print("Enter a11, a12, b1 separated by spaces: ");
        double a11 = scanner.nextDouble();
        double a12 = scanner.nextDouble();
        double b1 = scanner.nextDouble();

        System.out.print("Enter a21, a22, b2 separated by spaces: ");
        double a21 = scanner.nextDouble();
        double a22 = scanner.nextDouble();
        double b2 = scanner.nextDouble();

        scanner.close();
        
        double determinant = a11 * a22 - a21 * a12; // calculate the determinant
        if (determinant == 0) {
            System.out.println("The system of equations has no unique solution.");
            return;
        }

        double x1 = (a22 * b1 - a12 * b2) / determinant;
        double x2 = (a11 * b2 - a21 * b1) / determinant;

        System.out.println("Solution found: x1 = " + x1 + ", x2 = " + x2);


    }

}
