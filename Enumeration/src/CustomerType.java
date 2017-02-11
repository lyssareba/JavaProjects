import java.text.NumberFormat;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lyssa
 */
public enum CustomerType {
    CUST_RETAIL,
    CUST_TRADE,
    CUST_COLLEGE;
    
    
    @Override
    public String toString()
    {
        String s = "";
        switch (this.ordinal()) {
            case 0:
                s= "Retail customer";
                break;
            case 1:
                s = "Trade customer";
                break;
            case 2:
                s = "College customer";
                break;
            default:
                break;
        }
        return s;
    }
    
}
