package laba4.figures;

import java.util.Objects;

public class Rook extends Figure{
    public Rook(String name, char color) {
        super(name, color);
    }

    @Override
    public boolean canMove(int row, int col, int row1, int col1,Figure[][] fields) {

        if (row == row1 || col == col1){
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

        return false;
    }

    @Override
    public boolean canAttack(int row, int col, int row1, int col1,Figure[][] fields) {
        return this.canMove(row, col, row1, col1, fields);
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
        return false;
    }
}
