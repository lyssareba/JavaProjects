import java.text.NumberFormat;
import java.util.Scanner;

/**
 * Description of the Project: Calculates discount amount and total based on 
 * customer codes.
 *
 * @author     Alyssa Watson
 * @created    January 18, 2016
 */

public class EnhancedInvoiceApp
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String choice = "y";

        while (!choice.equalsIgnoreCase("n"))
        {
            // get the input from the user
            System.out.print("Enter customer type (r/c/t): ");
            String customerType = sc.next();
            System.out.print("Enter subtotal:   ");
            double subtotal = sc.nextDouble();

            // calculate the discount amount and total
            double discountPercent= getDiscountPercent(customerType, subtotal);
            double discountAmount = subtotal * discountPercent;
            double total = subtotal - discountAmount;

            // format and display the results
            NumberFormat currency = NumberFormat.getCurrencyInstance();
            NumberFormat percent = NumberFormat.getPercentInstance();
            System.out.println(
                "Discount percent: " + percent.format(discountPercent) + "\n" +
                "Discount amount:  " + currency.format(discountAmount) + "\n" +
                "Total:            " + currency.format(total) + "\n");

            // see if the user wants to continue
            System.out.print("Continue? (y/n): ");
            choice = sc.next();
            System.out.println();
        }
    }
    public static double getDiscountPercent(String customerType, double subtotal)
    {
        // get the discount percent
        double discountPercent = 0;
        if (customerType.equalsIgnoreCase("R"))
            {
                
                if (subtotal < 250)
                    discountPercent = 0;
                else if (subtotal >= 250 && subtotal < 500)
                    discountPercent = .25;
                else if (subtotal >= 500)
                    discountPercent = .30;
            }
        else if (customerType.equalsIgnoreCase("C"))
        {
            discountPercent = .2;
        }
        else if(customerType.equalsIgnoreCase("T"))
        {
          if (subtotal <500)
              discountPercent = .4;
          else if (subtotal>=500)
              discountPercent = .5;
        }
        else
            discountPercent = 0;
        
        return discountPercent;
    }
}