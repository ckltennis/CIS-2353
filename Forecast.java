public class Forecast
{
   public final static int DAYS_IN_FORECAST = 7;
   
   private Weather[] nextSevenDays;
   
   public Forecast()
   {
      nextSevenDays = new Weather[DAYS_IN_FORECAST];
      
      for ( int index = 0; index < nextSevenDays.length; index++)
      {
         nextSevenDays[index] = new Weather();
      }
   }
   
   public Weather[] getForecast()
   {
      return nextSevenDays;
   }
   
   public void setForecast( Weather[] forecast )
   {
      if ( forecast.length != DAYS_IN_FORECAST )
      {
         // do something here
      }
      else
      {
         nextSevenDays = forecast;
      }
   }
   
   public String toString()
   {
      String result = "Your forecast for "
         + "tomorrow and the next 7 days is:\n";
      for ( Weather weather : nextSevenDays )
      {
         result += weather.toString() + "\n";
      }
      
      return result;
   }
   
   public boolean areNext7DaysAllTheSame()
   {
      boolean same = true;
      Weather firstWeather = nextSevenDays[0];
      for ( int index = 1; same && index < nextSevenDays.length; index++ )
      {
         if ( !firstWeather.equals( nextSevenDays[index] ) )
         {
            same = false;
         }
      }
      
      return same;
   }
}