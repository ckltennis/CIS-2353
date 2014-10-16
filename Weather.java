public class Weather
{
   private String description;
   private int temp;
   
   public Weather()
   {
      description = "";
      temp = 32;
   }
   
   public Weather( String desc, int temp )
   {
      description = desc;
      this.temp = temp;
   }
   
   public String getDescription()
   {
      return description;
   }
   
   public int getTemp()
   {
      return temp;
   }
   
   public boolean equals( Object obj )
   {
      if ( ! ( obj instanceof Weather ) )
      {
         return false;
      }
      
      Weather weather = (Weather)obj;
      
      return description.equals( weather.getDescription() )
         && temp == weather.getTemp();
   }
   
   public String toString()
   {
      return description + " and " + temp;
   }
}