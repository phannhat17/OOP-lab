package hust.soict.cybersec.lab01;
import java.util.Scanner;

public class DisplayTriangle {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter height of triangle: ");
        int height = scanner.nextInt();
        System.out.println();

        scanner.close();

        int s = 1;
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= height - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <=s; k++) {
                System.out.print("*");
            }
            s += 2;
            System.out.println();
        }
    }
    
}
