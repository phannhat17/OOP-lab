package hust.soict.cybersec.lab01;
import java.util.Scanner;

public class QuadraticEquation {
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Quadratic equation with one variable solver!");
        System.out.println("a * x^2 + b * x + c = 0");

        System.out.print("Enter a, b, c separated by spaces: ");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        
        scanner.close();

        if (a == 0){
            if (b == 0 ) {
                if ( c == 0){
                    System.out.println("Infinite solution!");
                    return;
                } 
                else {
                    System.out.println("No Solution!");
                    return;
                }
            } 
            System.out.println("Soltion found: x = " + (-c/b));
            return;
        }

        double delta = b*b - 4*a*c;
        if (delta > 0){
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            System.out.println("Soltion found: " + x1 + " and " + x2);
        }
        else if (delta == 0){
            double x = -b / (2*a);
            System.out.println("Soltion found: " + x);
        }
        else {
            System.out.println("No solution!");
        }

    }

}
