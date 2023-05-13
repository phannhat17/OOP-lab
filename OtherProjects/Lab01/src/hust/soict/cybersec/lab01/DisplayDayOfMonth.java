package hust.soict.cybersec.lab01;
import java.util.Scanner;

public class DisplayDayOfMonth {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int month;

        System.out.println("Enter a month (example: January, Jan., Jan, and 1); ");
        String inputMonth = scanner.next().toLowerCase();

        switch (inputMonth) {
            case "january":
            case "jan.":
            case "jan":
            case "1":
                month = 1;
                break;
            case "february":
            case "feb.":
            case "feb":
            case "2":
                month = 2;
                break;
            case "march":
            case "mar.":
            case "mar":
            case "3":
                month = 3;
                break;
            case "april":
            case "apr.":
            case "apr":
            case "4":
                month = 4;
                break;
            case "may":
            case "5":
                month = 5;
                break;
            case "june":
            case "jun":
            case "6":
                month = 6;
                break;
            case "july":
            case "jul":
            case "7":
                month = 7;
                break;
            case "august":
            case "aug.":
            case "aug":
            case "8":
                month = 8;
                break;
            case "september":
            case "sept.":
            case "sep":
            case "9":
                month = 9;
                break;
            case "october":
            case "oct.":
            case "oct":
            case "10":
                month = 10;
                break;
            case "november":
            case "nov.":
            case "nov":
            case "11":
                month = 11;
                break;
            case "december":
            case "dec.":
            case "dec":
            case "12":
                month = 12;
                break;
            default:
                System.out.println("Invalid month. Please enter a valid month."); 
                scanner.close();     
                return;
        }
        System.out.println("Enter a year (example: 1999): ");
        int year = scanner.nextInt();
        
        if (year <= 0) {
            System.out.println("Invalid year. Please enter a non-negative number.");
            scanner.close();
            return;
        }

        scanner.close();
        
        // Month class in the same folder
        Month currentMonth = new Month(month, year);
        System.out.println(currentMonth.getNumberOfDays());
        

    }

}
