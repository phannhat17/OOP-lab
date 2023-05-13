package hust.soict.cybersec.lab01;
import java.util.Scanner;

public class InputFromKeyboard {
    
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("What's your name?");
        String strName = keyboard.nextLine();
        System.out.println("How old are you?");
        int iAge = keyboard.nextInt();
        System.out.println("How tall are you (m)?");
        double dHeight = keyboard.nextDouble();

        keyboard.close();
        
        System.out.println("Mrs/Mr. " + strName + ", " + iAge + " years old. " + "Your height is " + dHeight + ".");

    }

}
