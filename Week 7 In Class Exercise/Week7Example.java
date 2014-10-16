public class Week7Example
{
   public static void main(String[] args)
   {
      Stack<String> mcDonalds = new Stack<String>();
      
      System.out.println(mcDonalds.push("Eric C") + " walks into McDonalds");
      System.out.println(mcDonalds.push("Eric S") + " walks into McDonalds");
      
      System.out.println(mcDonalds.pop() + " gets their order");
      
      System.out.println(mcDonalds.push("Chris Y") + " walks into McDonalds");
      
      System.out.println(mcDonalds.pop() + " gets their order");
      
      System.out.println(mcDonalds.pop() + " gets their order");
   }
}