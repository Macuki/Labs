package laba4.figures;

import java.util.Objects;

public class Queen extends Figure{
    public Queen(String name, char color) {
        super(name, color);
    }

    @Override
    public boolean canMove(int row, int col, int row1, int col1,Figure[][] fields) {
        if ((row == row1 && col == col1) || fields[row1][col1] != null)
        {
            return false;
        }
        if((row == row1 && col !=col1) ||(row != row1 && col ==col1) || (Math.abs(row - row1) == Math.abs(col-col1)) )
        {
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
            else
            {
                if (row == row1)
                {
                    if (col1 > col)
                    {
                        for (int i = col + 1; i < col1; ++i)
                        {
                            if (fields[row][i] != null)
                            {
                                return false;
                            }
                        }
                    }
                    else
                    {
                        for (int i = col - 1; i > col1; --i)
                        {
                            if (fields[row][i] != null)
                            {
                                return false;
                            }
                        }
                    }
                }
                else
                {
                    if (row1 > row)
                    {
                        for(int i = row + 1; i < row1; ++i)
                        {
                            if (fields[i][col] != null)
                            {
                                return false;
                            }
                        }
                    }
                    else
                    {
                        for(int i = row -1; i > row1; --i)
                        {
                            if (fields[i][col] != null)
                            {
                                return false;
                            }
                        }
                    }
                }


                return true;
            }
        }

        return false;
    }

    @Override
    public boolean canAttack(int row, int col, int row1, int col1,Figure[][] fields) {
        if ((row == row1 && col == col1) || fields[row1][col1] == null)
        {
            return false;
        }
        if((row == row1 && col !=col1) ||(row != row1 && col ==col1) || (Math.abs(row - row1) == Math.abs(col-col1)) )
        {
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
            else
            {
                if (row == row1)
                {
                    if (col1 > col)
                    {
                        for (int i = col + 1; i < col1; ++i)
                        {
                            if (fields[row][i] != null)
                            {
                                return false;
                            }
                        }
                    }
                    else
                    {
                        for (int i = col - 1; i > col1; --i)
                        {
                            if (fields[row][i] != null)
                            {
                                return false;
                            }
                        }
                    }
                }
                else
                {
                    if (row1 > row)
                    {
                        for(int i = row + 1; i < row1; ++i)
                        {
                            if (fields[i][col] != null)
                            {
                                return false;
                            }
                        }
                    }
                    else
                    {
                        for(int i = row -1; i > row1; --i)
                        {
                            if (fields[i][col] != null)
                            {
                                return false;
                            }
                        }
                    }
                }


                return true;
            }
        }

        return false;
    }
    @Override
    public boolean canAttackKing(int row, int col, Figure[][]fields)
    {
        for (int i = row + 1; i < 8; ++i)
        {
            if (fields[i][col] != null)
            {
                if (!Objects.equals(fields[i][col].getName(), "K"))
                {
                    break;
                }
                else
                {
                    if (fields[row][col].getColor() != fields[i][col].getColor())
                    {
                        return true;
                    }
                }
            }
        }
        for (int i = row - 1; i >= 0; --i)
        {
            if (fields[i][col] != null)
            {
                if (!Objects.equals(fields[i][col].getName(), "K"))
                {
                    break;
                }
                else
                {
                    if (fields[row][col].getColor() != fields[i][col].getColor())
                    {
                        return true;
                    }
                }
            }
        }
        for (int i = col + 1; i < 8; ++i)
        {
            if (fields[row][i] != null)
            {
                if (!Objects.equals(fields[row][i].getName(), "K"))
                {
                    break;
                }
                else
                {
                    if (fields[row][col].getColor() != fields[row][i].getColor())
                    {
                        return true;
                    }
                }
            }
        }
        for (int i = col -1; i >= 0; --i)
        {
            if (fields[row][i] != null)
            {
                if (!Objects.equals(fields[row][i].getName(), "K"))
                {
                    break;
                }
                else
                {
                    if (fields[row][col].getColor() != fields[row][i].getColor())
                    {
                        return true;
                    }
                }
            }
        }
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
                if (!Objects.equals(fields[row- i][col - i].getName(), "K"))
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
