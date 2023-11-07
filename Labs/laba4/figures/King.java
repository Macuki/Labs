package laba4.figures;

import java.util.Objects;

public class King extends Figure{
    public King(String name, char color) {
        super(name, color);
    }

    private boolean isFirstStep = true;

    @Override
    public boolean canMove(int row, int col, int row1, int col1,Figure[][] fields) {
        if (this.isFirstStep == true)
        {
            if ((row1 == row) && Objects.equals(fields[row1][col1].getName(), "R"))
            {
                if (col1 > col)
                {
                    boolean flag =  false;
                    for (int i = col + 1; i < col1; ++i)
                    {
                        if (fields[row][i] != null)
                        {
                            flag = true;
                            break;
                        }
                    }
                    if (flag == false)
                    {
                        return true;
                    }
                    else
                    {
                        return false;
                    }
                }
                else
                {
                    boolean flag =  false;
                    for (int i = col -1; i > col1; --i)
                    {
                        if (fields[row][i] != null)
                        {
                            flag = true;
                            break;
                        }
                    }
                    if (flag == false)
                    {

                        return true;
                    }
                    else
                    {
                        return false;
                    }

                }
            }
            else
            {
                if ((Math.abs(row - row1)==1 && col ==col1) ||(row == row1 && Math.abs(col -col1)==1) || ((Math.abs(row - row1) ==1 && Math.abs(col-col1)==1))){
                    return true;
                }
                return false;
            }

        }
        if ((Math.abs(row - row1)==1 && col ==col1) ||(row == row1 && Math.abs(col -col1)==1) || ((Math.abs(row - row1) ==1 && Math.abs(col-col1)==1))){
            return true;
        }
        return false;
    }

    @Override
    public boolean canAttack(int row, int col, int row1, int col1,Figure[][] fields) {
        return this.canMove(row, col, row1, col1,fields);
    }

    @Override
    public void move(int row, int col, int row1, int col1, Figure[][] fields)
    {
        if (this.isFirstStep == true)
        {
            if ((row1 == row) && Objects.equals(fields[row1][col1].getName(), "R"))
            {
                char color = fields[row][col].getColor();
                Rook rock = new Rook("R",color);
                King king = new King("K",color);
                if (col1 > col)
                {
                    fields[row][col + 1] = rock;
                    fields[row][col + 2] = king;
                }
                else
                {
                    fields[row][col - 1] = rock;
                    fields[row][col - 2] = king;
                }
                fields[row][col] = null;
                fields[row1][col1] = null;
            }
            else
            {
                fields[row1][col1] = fields[row][col];
                fields[row][col] = null;
            }
            this.isFirstStep = false;

        }
        else
        {
            fields[row1][col1] = fields[row][col];
            fields[row][col] = null;
        }
    }
}
