import java.util.*;

public class GiveMeMyForecast
{
   public static void main(String[] args)
   {
      Forecast forecast = new Forecast();
      
      System.out.println( forecast.areNext7DaysAllTheSame() );
      System.out.println( forecast.toString() );
      
      Scanner keyboard = new Scanner(System.in);
      
      Weather[] nextSevenDays = forecast.getForecast();
      
      for ( int index = 0; index < nextSevenDays.length; index++ )
      {
         System.out.println("What is the weather going to be"
            + " like in " + ( index + 1 ) + " days?");
         String description = keyboard.nextLine();
         System.out.println("What is the temp going to be"
            + " in " + ( index + 1 ) + " days?");
         int temp = Integer.parseInt( keyboard.nextLine() );
         
         nextSevenDays[index] = new Weather( description, temp );
      }
      
      System.out.println( forecast.toString() );
      System.out.println( forecast.areNext7DaysAllTheSame() );
   }
}