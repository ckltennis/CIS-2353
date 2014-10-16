import java.util.*;

public class KnightsTour implements Application
{
   private static final int BOARD_SIZE = 8;
   private static final int OPEN = 0;
   
   protected byte[][] board;
   protected byte moves;
   protected int totalAttemptedMoves;
   
   public KnightsTour()
   {
      board = new byte[BOARD_SIZE][BOARD_SIZE];
      moves = 0;
      totalAttemptedMoves = 0;
   }
   
   public boolean isOK (Position pos)
   {
      return pos.getRow() >= 0 && pos.getRow() < BOARD_SIZE
         && pos.getColumn() >= 0 && pos.getColumn() < BOARD_SIZE
         && board[pos.getRow()][pos.getColumn()] == OPEN;
   }
   
   public void markAsPossible (Position pos)
   {
      board[pos.getRow()][pos.getColumn()] = ++moves;
      totalAttemptedMoves++;
   }
   
   public boolean isGoal (Position pos)
   {
      return moves == BOARD_SIZE * BOARD_SIZE;
   }
   
   public void markAsDeadEnd (Position pos)
   {
      board[pos.getRow()][pos.getColumn()] = OPEN;
      moves--;
   }
   public String toString()
   {
      String result = "";
      
      for ( int row = 0; row < BOARD_SIZE; row++ )
      {
         result += "|";
         for ( int column = 0; column < BOARD_SIZE; column++ )
         {
            result += String.format("%02d", board[row][column]) + "|";
         }
         result += "\n";
      }
      
      result += "Total Attempted Moves: " + totalAttemptedMoves;
      
      return result;
   }
   
   public Iterator<Position> iterator (Position pos)
   {
      return new KnightIterator( pos );
   }
   
   protected class KnightIterator implements Iterator<Position> 
   {      
      protected static final int MAX_MOVES = 8;
      protected Position position;
      protected int move;
      
      public KnightIterator( Position pos )
      {
         position = pos;
         move = 0;
      }
      
      public boolean hasNext() 
      {
          return move < MAX_MOVES;
      }
     
      public Position next () 
      {
         Position newPosition = null;
         
         switch ( move++ )
         {
            case 0:
               newPosition = new Position( 
                  position.getRow() - 2, 
                  position.getColumn() + 1 );
               break;
            case 1:
               newPosition = new Position( 
                  position.getRow() - 1, 
                  position.getColumn() + 2 );
               break;
            case 2:
               newPosition = new Position( 
                  position.getRow() + 1, 
                  position.getColumn() + 2 );
               break;   
            case 3:
               newPosition = new Position( 
                  position.getRow() + 2, 
                  position.getColumn() + 1 );
               break;
            case 4:
               newPosition = new Position( 
                  position.getRow() + 2, 
                  position.getColumn() - 1 );
               break;  
            case 5:
               newPosition = new Position( 
                  position.getRow() + 1, 
                  position.getColumn() - 2 );
               break; 
            case 6:
               newPosition = new Position( 
                  position.getRow() - 1, 
                  position.getColumn() - 2 );
               break;  
            case 7:
               newPosition = new Position( 
                  position.getRow() - 2, 
                  position.getColumn() - 1 );
               break;          
         }
         return newPosition;
      }
      
       public void remove () 
       { 
          // removal is illegal for a MazeIterator object
          throw new UnsupportedOperationException(); 
      }
   }  
}