package laba4.figures;

import java.util.Objects;

public class King extends Figure{
    public King(String name, char color) {
        super(name, color);
    }


    @Override
    public boolean canMove(int row, int col, int row1, int col1,Figure[][] fields) {
        if ((row == row1 && col == col1) || fields[row1][col1] != null)
        {
            return false;
        }
        if ((Math.abs(row - row1)==1 && col ==col1) ||(row == row1 && Math.abs(col -col1)==1) || ((Math.abs(row - row1) ==1 && Math.abs(col-col1)==1))){
            return true;
        }
        return false;
    }

    @Override
    public boolean canAttack(int row, int col, int row1, int col1,Figure[][] fields) {
        if ((row == row1 && col == col1) || fields[row1][col1] == null)
        {
            return false;
        }
        if ((Math.abs(row - row1)==1 && col ==col1) ||(row == row1 && Math.abs(col -col1)==1) || ((Math.abs(row - row1) ==1 && Math.abs(col-col1)==1))){
            return true;
        }
        return false;
    }

    @Override
    public void move(int row, int col, int row1, int col1, Figure[][] fields)
    {

            fields[row1][col1] = fields[row][col];
            fields[row][col] = null;

    }
}
