import java.util.*;

public class EightQueens implements Application
{
   protected static final char QUEEN = 'Q';
   protected static final char BLANK = '_';
   
   private static int BOARD_SIZE = 8;
   
   protected char[][] board;
   
   public EightQueens()
   {
      board = new char[BOARD_SIZE][BOARD_SIZE];
      
      for ( int row = 0; row < BOARD_SIZE; row++ )
      {
         for ( int column = 0; column < BOARD_SIZE; column++ )
         {
            board[row][column] = BLANK;
         }
      }
   }
   
   public boolean isOK (Position pos)
   {
      boolean isOk = true;
      
      for ( int column = 0; isOk && column < pos.getColumn(); column++ )
      {
         if ( board[pos.getRow()][column] == QUEEN )
         {
            isOk = false;
         }
      }
      
      for ( int row = pos.getRow() - 1, column = pos.getColumn() - 1;
         isOk && row >= 0 && column >= 0; row--, column-- )
      {
         if ( board[row][column] == QUEEN )
         {
            isOk = false;
         }
      }
      
      for ( int row = pos.getRow() + 1, column = pos.getColumn() - 1;
         isOk && row < BOARD_SIZE && column >= 0; row++, column-- )
      {
         if ( board[row][column] == QUEEN )
            {
               isOk = false;
            }
      }
      
      return isOk;
   }
   
   public void markAsPossible (Position pos)
   {
      board[pos.getRow()][pos.getColumn()] = QUEEN;
   }
   
   public boolean isGoal (Position pos)
   {
      return pos.getColumn() == BOARD_SIZE - 1;
   }
   
   public void markAsDeadEnd (Position pos)
   {
      board[pos.getRow()][pos.getColumn()] = 'X';
   }
   public String toString()
   {
      String result = "";
      
      for ( int row = 0; row < BOARD_SIZE; row++ )
      {
         result += "|";
         for ( int column = 0; column < BOARD_SIZE; column++ )
         {
            result += board[row][column] + "|";
         }
         result += "\n";
      }
      
      return result;
   }
   
   public Iterator<Position> iterator (Position pos)
   {
      return new EightQueensIterator( pos );
   }
   
   protected class EightQueensIterator implements Iterator<Position> 
   {      
      protected int row, column;
      
      public EightQueensIterator( Position pos )
      {
         row = 0;
         column = pos.getColumn() + 1;
      }
      
      public boolean hasNext () 
      {
          return row < BOARD_SIZE;
      }
     
      public Position next () 
      {
         if ( row == BOARD_SIZE )
         {
            return null;
         }
         return new Position(row++, column);
      }
      
       public void remove () 
       { 
          // removal is illegal for a MazeIterator object
          throw new UnsupportedOperationException(); 
      }
   }     
}