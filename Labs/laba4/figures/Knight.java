package laba4.figures;

import java.util.Objects;

public class Knight extends Figure{
    public Knight(String name, char color) {
        super(name, color);
    }

    @Override
    public boolean canMove(int row, int col, int row1, int col1,Figure[][] fields) {
        if (((Math.abs(row - row1)==1 && Math.abs(col - col1)==2) || (Math.abs(row - row1)==2 && Math.abs(col - col1)==1)) && fields[row1][col1] == null)
        {
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
        if (row + 2 < 7 && col + 1 < 7 &&  fields[row+2][col +1] != null && (this.getColor()) != fields[row+2][col+1].getColor()
                && Objects.equals(fields[row + 2][col +1].getName(), "K"))
        {
            return true;
        }
        if (row + 2 < 7 && col - 1 >= 0 && fields[row+2][col -1] != null && (this.getColor()) != fields[row+2][col-1].getColor()
                && Objects.equals(fields[row + 2][col -1].getName(), "K"))
        {
            return true;
        }
        if (row - 2 >=0 && col + 1 < 7 && fields[row-2][col +1] != null &&(this.getColor()) != fields[row-2][col+1].getColor()
                && Objects.equals(fields[row -2][col +1].getName(), "K"))
        {
            return true;
        }
        if (row - 2 >= 0 && col - 1 >= 0 && fields[row-2][col -1] != null &&(this.getColor()) != fields[row-2][col-1].getColor()
                && Objects.equals(fields[row -2][col -1].getName(), "K"))
        {
            return true;
        }
        if (col + 2 < 7 && row + 1 < 7 && fields[row+1][col +2] != null &&(this.getColor()) != fields[row+1][col+2].getColor()
                && Objects.equals(fields[row + 1][col +2].getName(), "K"))
        {
            return true;
        }
        if (col + 2 < 7 && row - 1 >=0 && fields[row-1][col +2] != null &&(this.getColor()) != fields[row-1][col+2].getColor()
                && Objects.equals(fields[row - 1][col +2].getName(), "K"))
        {
            return true;
        }
        if (col -2 >= 0 && row + 1 < 7 && fields[row+1][col -2] != null &&(this.getColor()) != fields[row+1][col-2].getColor()
                && Objects.equals(fields[row + 1][col -2].getName(), "K"))
        {
            return true;
        }
        if (col -2 >= 0&& row -1 >= 0 && fields[row-1][col -2] != null &&(this.getColor()) != fields[row-1][col-2].getColor()
                && Objects.equals(fields[row - 1][col -2].getName(), "K"))
        {
            return true;
        }

        return false;
    }
}
