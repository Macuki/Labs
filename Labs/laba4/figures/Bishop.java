package laba4.figures;

public class Bishop extends Figure{
    public Bishop(String name, char color) {
        super(name, color);
    }

    @Override
    public boolean canMove(int row, int col, int row1, int col1,Figure[][] fields) {
       if (Math.abs(row - row1) == Math.abs(col-col1))
       {
           if (row1 > row && col1 > col)
           {
               for (int i =  1; i < row1 - row; ++i)
               {
                   if (fields[row+i][col+i] != null)
                   {
                       return false;
                   }
               }
           }
           else if (row1 > row && col1 < col)
           {
               for (int i = 1; i < row1 - row; ++i)
               {
                   if (fields[row+i][col - i] != null)
                   {
                       return false;
                   }
               }
           }
           else if (row1 < row && col1 > col)
           {
               for (int i = 1; i < col1 - col;++i)
               {
                   if (fields[row-i][col+i] != null)
                   {
                       return false;
                   }
               }
           }
           else
           {
               for (int i =  - 1; i > row1 - row; --i)
               {
                   if (fields[row-i][col-i] != null)
                   {
                       return false;
                   }
               }
           }
           return true;
       }
        return false;
    }

    @Override
    public boolean canAttack(int row, int col, int row1, int col1,Figure[][] fields) {
        return this.canMove(row, col, row1, col1,fields);
    }
}
