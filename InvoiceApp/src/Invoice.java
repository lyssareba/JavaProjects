import java.text.NumberFormat;

/**
 *Invoice class for the InvoiceApp
 * @author lyssa
 */
public class Invoice {
    /*Variables*/
    private String customerType;
    private double subtotal;
    /*Constructor*/
    public Invoice(String customerType, double subtotal)
    {
        this.customerType=customerType;
        this.subtotal=subtotal;
    }
    /*subtotal get method*/
    public double getSubtotal()
    {
        return subtotal;
    }
    public String getCustomerType()
    {
        String sCustomerType="";                
        if (customerType.equalsIgnoreCase("r"))
            sCustomerType = "Retail";
        else if (customerType.equalsIgnoreCase("c"))
            sCustomerType = "College";
        return sCustomerType;
    }
    
    /*discountPercent get method*/
    public double getDiscountPercent()
    {
        double discountPercent=this.getDiscountPercent(subtotal, customerType);
        return discountPercent;        
    }
    /*calculate discountPercent get method*/
    public double getDiscountPercent(double subtotal, String type)
    {
                double discountPercent = 0.0;
        if (type.equalsIgnoreCase("r"))
        {
            if (subtotal >= 500)
                discountPercent = .2;
            else if (subtotal >= 250 && subtotal < 500)
                discountPercent =.15;
            else if (subtotal >= 100 && subtotal < 250)
                discountPercent =.1;
            else if (subtotal < 100)
                discountPercent =.0;
        }
        else if (type.equalsIgnoreCase("c"))
        {
                discountPercent = .2;
        }
        else
            discountPercent = .05;

        return discountPercent;
    }
    /*discountAmount get method*/
    public double getDiscountAmount()
    {
        double discountAmount=subtotal*this.getDiscountPercent();
        return discountAmount;
    }
    /*total get method*/
    public double getTotal()
    {
        double total=subtotal-this.getDiscountAmount();
        return total;
    }
    /*subtotal Formatting method*/
    public String getFormattedSubtotal()
    {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(this.getSubtotal());
    }
    /*discountPercent Formatting method*/
    public String getFormattedDiscountPercent()
    {
        NumberFormat percent = NumberFormat.getPercentInstance();
        return percent.format(this.getDiscountPercent());
    }
    /*discountAmount Formatting method*/
    public String getFormattedDiscountAmount()
    {
        NumberFormat currency=NumberFormat.getCurrencyInstance();
        return currency.format(this.getDiscountAmount());
    }
    /*total Formatting method*/
    public String getFormattedTotal()
    {
        NumberFormat currency=NumberFormat.getCurrencyInstance();
        return currency.format(this.getTotal());
    }
    public String getInvoice()
    {
        String message = "Subtotal:         " + this.getFormattedSubtotal() + "\n"
                           + "Customer type:    " + this.getCustomerType() + "\n"
                           + "Discount percent: " + this.getFormattedDiscountPercent() + "\n"
                           + "Discount amount:  " + this.getFormattedDiscountAmount() + "\n"
                           + "Total:            " + this.getFormattedTotal() + "\n";
        return message;
    }
    
    
}
