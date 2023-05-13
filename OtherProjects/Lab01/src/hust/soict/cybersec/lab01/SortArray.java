package hust.soict.cybersec.lab01;
import java.util.Arrays;
import java.util.Scanner;

public class SortArray {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int size = scanner.nextInt();

        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();

        System.out.println("The original array is: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        double sum = 0;

        Arrays.sort(arr);
        System.out.println("\nThe sorted array is: ");
        for (int num : arr) {
            System.out.print(num + " ");
            sum += num;
        }
        double avg = sum / size;
        System.out.println("\nSum of the array elements is: " + sum);
        System.out.println("Average value of the array elements is: " + avg);

    }
}
