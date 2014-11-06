import java.util.*;

public class DataStructureTimings
{
   public static void main(String[] args)
   {
       ArrayList<Integer> arrayList = new ArrayList<Integer>(100);
       addElements( arrayList, 100000, "ArrayList" );

       removeElements( arrayList, 10000, "ArrayList" );
       searchElements( arrayList, 10000, "ArrayList" );
       
       LinkedList<Integer> linkedList = new LinkedList<Integer>();
       addElements( linkedList, 100000, "LinkedList" );

       removeElements( linkedList, 10000, "LinkedList" );
       searchElements( linkedList, 10000, "LinkedList" );
       
       BinarySearchTree<Integer> binarySearchTree = 
         new BinarySearchTree<Integer>();
       addElements(binarySearchTree, 100000, "BinarySearchTree" );
       removeElements( binarySearchTree, 10000, "BinarySearchTree" );
       searchElements( binarySearchTree, 10000, "BinarySearchTree" );
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
         collection.add( random.nextInt() );
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
         if ( collection.remove( random.nextInt() ) )
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
      Random random = new Random(1001); 
      startTime = System.nanoTime( );
      int itemsFound = 0;
      for ( int count = 0; count < itemsToSearch; count++ )
      {
         if ( collection.contains( random.nextInt() ) )
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