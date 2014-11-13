import java.io.*;
import java.util.*;

public class Concordance
{
   public static void main(String[] args)
   {
      if ( args.length != 1 )
      {
         System.out.println("Please provide the path to the file to read");
      }
      else
      {
         System.out.println( new Concordance( args[0] ) );
      }
   }
   
   private TreeMap<String, String> concordance;
   private int currentLineNumber;
   
   public Concordance( String filePath )
   {
      File inputFile = new File( filePath );
      
      if ( !inputFile.exists() )
      {
         System.out.println("Please enter a valid file path");
      }
      else
      {
         currentLineNumber = 0;
         concordance = new TreeMap<String, String>();
         parseFile( inputFile );
      }
   }
   
   public void parseFile( File inputFile )
   {
      Scanner fileScanner = null;
      try
      {
         fileScanner = new Scanner( inputFile );
         while ( fileScanner.hasNext() )
         {
             parseLine( fileScanner.nextLine() );
         }
      }
      catch ( IOException e )
      {
         System.out.println( e.toString() );
      }
   }
   
   public void parseLine( String line )
   {
      currentLineNumber++;
      Scanner lineScanner = new Scanner( line );
      while ( lineScanner.hasNext() )
      {
         parseWord( lineScanner.next() );
      }  
   }
   
   public void parseWord( String word )
   {
      updateConcordance( sanitize( word ) );
   }
   
   public String sanitize( String word )
   {
      return word.replaceAll("[!.,;:\"]","").toLowerCase();
   }
   
   public void updateConcordance( String word )
   {
      String lineNumbers = concordance.get( word );
      if ( lineNumbers == null )
      {
         lineNumbers = Integer.toString(currentLineNumber);
      }
      else
      {
         lineNumbers += ", " + currentLineNumber;
      }   
      concordance.put( word, lineNumbers );
   }
   
   public String toString()
   {
      String result = "";
      for ( Map.Entry<String, String> entry : concordance.entrySet() )
      {
         result += entry.getKey() + ": " + entry.getValue() + "\n";
      }
      return result;
   }
}