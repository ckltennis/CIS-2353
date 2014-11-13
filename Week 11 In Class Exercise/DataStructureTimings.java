import java.util.*;

public class DataStructureTimings
{
   public static void main(String[] args)
   {
       ArrayList<Integer> arrayList = new ArrayList<Integer>(100);
       addElements( arrayList, 100000, "ArrayList" );
       Collections.sort(arrayList);
       removeElements( arrayList, 10000, "ArrayList" );
       searchElements( arrayList, 10000, "ArrayList" );
       
       LinkedList<Integer> linkedList = new LinkedList<Integer>();
       addElements( linkedList, 100000, "LinkedList" );
       Collections.sort(linkedList);
       removeElements( linkedList, 10000, "LinkedList" );
       searchElements( linkedList, 10000, "LinkedList" );
       
       TreeSet<Integer> treeSet = new TreeSet<Integer>();
       
       addNonRandomElements(treeSet, 100000, "BinarySearchTree" );
       removeElements( treeSet, 10000, "TreeSet" );
       searchElements( treeSet, 10000, "TreeSet" );
   }
   
   public static void addElements( AbstractCollection<Integer> collection,
      int itemsToAdd, String name )
   {
      collection.clear();
      long startTime, finishTime, elapsedTime;
      Random random = new Random(1000); 
      startTime = System.nanoTime( );

      for ( int count = 0; count < itemsToAdd; count++ )
      {
         collection.add( random.nextInt( 1000000 ) );
      }  
      
       finishTime = System.nanoTime( );
       elapsedTime = finishTime - startTime;
       
       System.out.println( name + " add " + itemsToAdd + ": " 
         + elapsedTime / 1000000000.0 );
   }
   
   public static void addNonRandomElements( AbstractCollection<Integer> collection,
      int itemsToAdd, String name )
   {
      collection.clear();
      long startTime, finishTime, elapsedTime;
      Random random = new Random(1000); 
      startTime = System.nanoTime( );

      for ( int count = 0; count < itemsToAdd; count++ )
      {
         collection.add( count );
      }  
      
       finishTime = System.nanoTime( );
       elapsedTime = finishTime - startTime;
       
       System.out.println( name + " add " + itemsToAdd + ": " 
         + elapsedTime / 1000000000.0 );
   }

   
   public static void removeElements( AbstractCollection<Integer> collection,
      int itemsToRemove, String name )
   {
      long startTime, finishTime, elapsedTime;
      Random random = new Random(1001); 
      startTime = System.nanoTime( );
      int itemsRemoved = 0;
      for ( int count = 0; count < itemsToRemove; count++ )
      {
         if ( collection.remove( random.nextInt( 1000000 ) ) )
         {
            itemsRemoved++;
         }
      }  
      
       finishTime = System.nanoTime( );
       elapsedTime = finishTime - startTime;
       
       System.out.println( name + " remove " + itemsToRemove 
         + " - removed: " + itemsRemoved + " in: "
         + elapsedTime / 1000000000.0 + " seconds" );
   }
   
   public static void searchElements( AbstractCollection<Integer> collection,
      int itemsToSearch, String name )
   {
      long startTime, finishTime, elapsedTime;
      Random random = new Random(1002); 
      startTime = System.nanoTime( );
      int itemsFound = 0;
      for ( int count = 0; count < itemsToSearch; count++ )
      {
         if ( collection.contains( random.nextInt( 1000000 ) ) )
         {
            itemsFound++;
         }
      }  
      
       finishTime = System.nanoTime( );
       elapsedTime = finishTime - startTime;
       
       System.out.println( name + " search " + itemsToSearch 
         + " - found: " + itemsFound + " in: " 
         + elapsedTime / 1000000000.0 + " seconds");
   }

}