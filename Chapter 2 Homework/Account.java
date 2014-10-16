import java.text.DecimalFormat;

public class Account
{
   public static DecimalFormat MONEY_FORMAT = new DecimalFormat("$#,##0.00");
   
   private double balance;
   
   public Account( double bal )
   {
      setBalance( bal );
   }
   
   public double getBalance()
   {
      return balance;
   }
   
   public void setBalance( double bal )
   {
      balance = bal;
   }
   
   public String toString()
   {
      return MONEY_FORMAT.format(balance);
   }
}