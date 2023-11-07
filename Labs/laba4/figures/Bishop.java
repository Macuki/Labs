package laba4.figures;

import java.util.Objects;

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

    @Override
    public boolean canAttackKing(int row, int col, Figure[][]fields)
    {
        for (int i = 1; row + i < 8 && col + i < 8; ++i)
        {
            if (fields[row+i][col+i] != null)
            {
                if (!Objects.equals(fields[row + i][col + i].getName(), "K"))
                {
                    break;
                }
                else
                {
                    if (fields[row][col].getColor() != fields[row+i][col+i].getColor())
                    {
                        return true;
                    }
                }
            }
        }
        for (int i = 1; row + i < 8 && col - i >=0; ++i)
        {
            if (fields[row+i][col-i] != null)
            {
                if (!Objects.equals(fields[row + i][col - i].getName(), "K"))
                {
                    break;
                }
                else
                {
                    if (fields[row][col].getColor() != fields[row+i][col-i].getColor())
                    {
                        return true;
                    }
                }
            }
        }
        for (int i = 1; row -i >= 0 && col + i  < 7; ++i)
        {
            if (fields[row-i][col+i] != null)
            {
                if (!Objects.equals(fields[row - i][col + i].getName(), "K"))
                {
                    break;
                }
                else
                {
                    if (fields[row][col].getColor() != fields[row-i][col+i].getColor())
                    {
                        return true;
                    }
                }
            }
        }
        for (int i = 1; row - i >= 0 && col - i >=0; ++i)
        {
            if (fields[row-i][col-i] != null)
            {
                if (!Objects.equals(fields[row - i][col - i].getName(), "K"))
                {
                    break;
                }
                else
                {
                    if (fields[row][col].getColor() != fields[row-i][col-i].getColor())
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
