public class FixedRateOfReturnAccount extends Account
{
   private double rateOfReturn;
   
   public FixedRateOfReturnAccount( double balance, double rateOfReturn )
   {
      super(balance);
      this.rateOfReturn = rateOfReturn;
   }
   
   public void applyRateOfReturn()
   {
      setBalance( getBalance() + ( getBalance() * rateOfReturn ) );
   }
}