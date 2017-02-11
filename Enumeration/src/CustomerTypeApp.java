import java.util.Scanner;

public class CustomerTypeApp
{
    private static Scanner sc = null;
    
    public static void main(String[] args)
    {
        // display a welcome message
        System.out.println("Welcome to the Customer Type Test application\n");
        

        // get and display the discount percent for a customer type
        for(CustomerType c: CustomerType.values())
        {
            double percent=getDiscount(c);
            System.out.println(
                "The discount percent for " + c.toString() + " is "+ percent);
        }

        // display the value of the toString method of a customer type

    }

    // a method that accepts a CustomerType enumeration
    public static double getDiscount(CustomerType type)
    {
        double discountPercent=0.0;
        if(type==CustomerType.CUST_RETAIL)
        {
            discountPercent=.10;
        }
        else if(type==CustomerType.CUST_TRADE)
        {
            discountPercent=.30;
        }
        else if(type==CustomerType.CUST_COLLEGE)
        {
            discountPercent=.20;
        }
        return discountPercent;
    }

}