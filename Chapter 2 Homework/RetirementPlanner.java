import java.util.Scanner;
import java.io.*;

public class RetirementPlanner
{
   private static final double BANK_RATE_OF_RETURN = .01;

   private Account matress;
   private FixedRateOfReturnAccount bank;
   private VariableRateOfReturnAccount bonds;
   private VariableRateOfReturnAccount stocks;
   private int currentAge, desiredRetirementAge, yearsUntilRetirement;
   Scanner keyboard;
   
   public static void main(String[] args)
   {
      new RetirementPlanner();
   }
   
   public RetirementPlanner()
   {
      keyboard = new Scanner(System.in);
      System.out.println("How old are you?");
      currentAge = keyboard.nextInt();
      
      System.out.println("How old do you want to be when you retire?");
      desiredRetirementAge = keyboard.nextInt();
      
      yearsUntilRetirement = desiredRetirementAge - currentAge;
      
      matress = new Account( promptForCurrentBalance("matress") );
      bank = new FixedRateOfReturnAccount( 
         promptForCurrentBalance("bank savings"), 
         BANK_RATE_OF_RETURN );
      
      Scanner bondsRateOfReturn;
      File bondsRateOfReturnFile = new File("BondsAnnualRateOfReturn.txt");
      try
      {
         bondsRateOfReturn = new Scanner( bondsRateOfReturnFile );
         bonds = new VariableRateOfReturnAccount(
         promptForCurrentBalance("bonds investment"), bondsRateOfReturn );
      }
      catch ( FileNotFoundException e )
      {
         System.out.println( "Can't find the bonds file!");
      }
      
      Scanner stocksRateOfReturn;
      File stocksRateOfReturnFile = new File("StocksAnnualRateOfReturn.txt");
      try
      {
         stocksRateOfReturn = new Scanner( stocksRateOfReturnFile );
         stocks = new VariableRateOfReturnAccount(
         promptForCurrentBalance("stocks investment"), stocksRateOfReturn );
      }
      catch ( FileNotFoundException e )
      {
         System.out.println( "Can't find the stocks file!");
      }
      try
      {
         PrintWriter outputFile = new PrintWriter("investment.txt");
         
         while( currentAge < desiredRetirementAge )
         {
            promptUserForAdditionalInvestment();
            bank.applyRateOfReturn();
            bonds.applyRateOfReturn();
            stocks.applyRateOfReturn();
         
            System.out.println( getBalances() );
            outputFile.println( getBalances() );
            currentAge++;
         }
         
         double totalInvestmentValue = matress.getBalance() + bank.getBalance()
             + bonds.getBalance() + stocks.getBalance();
             
         double totalInvestmentValueInTodaysDollars = 
            totalInvestmentValue / Math.pow( 1.03, yearsUntilRetirement );
         
         System.out.println( "Total Investment: " + 
            Account.MONEY_FORMAT.format(totalInvestmentValue) );
         System.out.println( "Total Investment in today's dollars: " +
            Account.MONEY_FORMAT.format(totalInvestmentValueInTodaysDollars) );
         
         outputFile.println( "Total Investment: " + 
            Account.MONEY_FORMAT.format(totalInvestmentValue) );
         outputFile.println( "Total Investment in today's dollars: " +
            Account.MONEY_FORMAT.format(totalInvestmentValueInTodaysDollars) );
         
         outputFile.close();
      }
      catch( FileNotFoundException e )
      {
         System.out.println("Unable to write to file!");
      }
   }
   
   public double promptForCurrentBalance( String accountName )
   {
      System.out.println("How much money do you have in your " + accountName);
      return keyboard.nextDouble();
   }
   
   public void promptUserForAdditionalInvestment()
   {
      System.out.println("At age " + currentAge 
         + ", do you want to investment this year?");
      keyboard.nextLine();
      if ( keyboard.nextLine().equals("yes") )
      {
         matress.setBalance( matress.getBalance() + 
            promptForInvestmentAmount( "matress" ) );
         bank.setBalance( bank.getBalance() + 
            promptForInvestmentAmount( "bank savings" ) );
         bonds.setBalance( bonds.getBalance() + 
            promptForInvestmentAmount( "bonds investment" ) );
         stocks.setBalance( stocks.getBalance() + 
            promptForInvestmentAmount( "stocks investment" ) );
      }
   }
   
   public double promptForInvestmentAmount( String accountName )
   {
      System.out.println("How much do you want to invest in your " 
         + accountName);
      return keyboard.nextDouble();
   }
   
   public String getBalances()
   {
      return "Matress: " + matress.toString() + "\n"
         + "Bank: " + bank.toString() + "\n"
         + "Bonds: " + bonds.toString() + "\n"
         + "Stocks: " + stocks.toString() + "\n";
   }
}