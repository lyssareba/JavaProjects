import java.text.NumberFormat;
import java.util.Scanner;
/**
 * Description of the Project: Calculates discounts and totals based on
 * customer type.
 * @author     Alyssa Watson
 * @created    January 30, 2016
 */

public class InvoiceApp
{
    public static void main(String[] args)
    {
        // display a welcome message
        System.out.println("Welcome to the Invoice Total Calculator");
        System.out.println();  // print a blank line

        Scanner sc = new Scanner(System.in);
        String choice = "y";
        while(choice.equalsIgnoreCase("y"))
        {
            // get user entries
            String customerType = Validator.getString(sc,
                "Enter customer type (r/c):   ");
            double subtotal = Validator.getDouble(sc,
                "Enter subtotal:              ", 0, 10000);
            
            Invoice invoice=new Invoice(customerType, subtotal);

            // format and display the results
            String message = invoice.getInvoice();
            System.out.println();
            System.out.println(message);

            System.out.print("Continue? (y/n): ");
            choice = sc.next();
            System.out.println();
        }
    }  
}