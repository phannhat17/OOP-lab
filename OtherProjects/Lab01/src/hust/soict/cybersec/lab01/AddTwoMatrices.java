package hust.soict.cybersec.lab01;
import java.util.Scanner;

public class AddTwoMatrices {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        // Get matrix sizes
        System.out.print("Enter the number of rows of the matrix: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns of the matrix: ");
        int columns = scanner.nextInt();

        int[][] firstMatrix = new int[rows][columns];
        int[][] secondMatrix = new int[rows][columns];
        int[][] sumMatrix = new int[rows][columns];

        // Get matrix elements
        System.out.println("Enter the first matrix (row by row): ");
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                firstMatrix[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Enter the second matrix (row by row): ");
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                secondMatrix[i][j] = scanner.nextInt();
            }
        }
        
        scanner.close();

        // Print out the matrix
        System.out.println("The first matrix: ");
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                System.out.print(firstMatrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("The second matrix: ");
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                System.out.print(secondMatrix[i][j] + " ");
            }
            System.out.println();
        }

        // Calculate the sum of the two matrices
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                sumMatrix[i][j] = firstMatrix[i][j] + secondMatrix[i][j];
            }
        }

        
        System.out.println("The sum matrix: ");
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                System.out.print(sumMatrix[i][j] + " ");
            }
            System.out.println();
        }
        
            

    }
    
}
