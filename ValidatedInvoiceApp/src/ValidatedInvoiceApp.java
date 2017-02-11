import java.text.NumberFormat;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Description of the Project: Calculates the subtotal of a customer based on
 * their code status. Data is validated and an error is displayed if the data 
 * is invalid.
 * @author     Alyssa Watson
 * @created    January 23, 2016
 */
public class ValidatedInvoiceApp
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String choice = "y";
        
        while (!choice.equalsIgnoreCase("n"))
        {
            // get the input from the user
            String customerType = getValidCustomerType(sc, "Enter customer type (r/c): ");
            double subtotal = 0.0;
            try
            {
                subtotal=getValidSubtotal(sc, "Enter subtotal:   ", 0, 10000);
            }
            catch(InputMismatchException e)
            {
                sc.next();
                System.out.println("Error! Invalid number. Please try again.\n");
                continue;
            }
                
            
            // get the discount percent
            double discountPercent = 0;
            if (customerType.equalsIgnoreCase("R"))
            {
                if (subtotal < 100)
                    discountPercent = 0;
                else if (subtotal >= 100 && subtotal < 250)
                    discountPercent = .1;
                else if (subtotal >= 250)
                    discountPercent = .2;
            }
            else if (customerType.equalsIgnoreCase("C"))
            {
                if (subtotal < 250)
                    discountPercent = .2;
                else
                    discountPercent = .3;
            }
            else
            {
                discountPercent = .1;
            }
            
            // calculate the discount amount and total
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
            sc.nextLine();
            System.out.println();
        }
    }
    
    public static String getValidCustomerType(Scanner sc, String prompt)
    {
        String c= " ";
        boolean isValid=false;
        while(isValid==false)
        {
            System.out.print(prompt);
            String userInput=sc.next();
            if (userInput.equalsIgnoreCase("r") || userInput.equalsIgnoreCase("c"))
            {
                c=userInput;
                isValid=true;
            }
            else
            {
                System.out.println("Error! Invalid string value. Try again.");
            }
        }
        return c;
    }
    
    public static double getValidSubtotal(Scanner sc, String prompt, double min, double max)
    {
        double d=0.0;
        boolean isValid=false;
        while(isValid==false)
        {
            d=getSubtotal(sc, prompt);
            if(d<=min)
                System.out.println("Error! Number must be greater than " +min+".");
            else if (d>=max)
                System.out.println("Error! Number must be less than "+max+".");
            else
                isValid=true;
        }
        return d;
    }
    
    public static double getSubtotal(Scanner sc, String prompt)
    {
        double d = 0.0;
        boolean isValid=false;
        while(isValid==false)
        {
            System.out.print(prompt);
            if(sc.hasNextDouble())
            {
                d = sc.nextDouble();
                isValid=true;
            }
            else
            {
                System.out.println("Error! Invalid decimal value. Try again.");
            }
            sc.nextLine();
        }
        return d;
    }
}