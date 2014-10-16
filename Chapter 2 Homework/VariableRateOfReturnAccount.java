import java.util.Scanner;

public class VariableRateOfReturnAccount extends Account
{
   private Scanner rateOfReturnScanner;
   
   public VariableRateOfReturnAccount( double balance, Scanner rateOfReturnScanner )
   {
      super(balance);
      this.rateOfReturnScanner = rateOfReturnScanner;
   }
   
   public void applyRateOfReturn()
   {
      setBalance( getBalance() + 
         ( getBalance() * rateOfReturnScanner.nextDouble() ) );
   }
}