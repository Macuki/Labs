package laba4.figures;

import java.util.Objects;
import java.util.Scanner;

public class Pawn extends Figure {

    private boolean isFirstStep = true;

    public Pawn(String name, char color) {
        super(name, color);
    }

    @Override
    public boolean canMove(int row, int col, int row1, int col1,Figure[][] fields) {
        //   if (!super.canMove(row, col, row1, col1)){
        //       return false;
        //   }

        if (this.isFirstStep) {
            if (((((row + 2 == row1) || (row + 1 == row1)) && this.getColor() == 'w') ||
                    (((row - 2 == row1) || (row - 1 == row1)) && this.getColor() == 'b')) && (col == col1)) {
                this.isFirstStep = false;
                return true;
            }

        } else {
            if ((((row + 1 == row1) && (this.getColor() == 'w')) || ((row - 1 == row1) && (this.getColor() == 'b'))) && (col == col1)) {
                return true;
            }

        }
        return false;
    }

    @Override
    public boolean canAttack(int row, int col, int row1, int col1,Figure[][] fields) {
        switch (this.getColor()) {
            case 'w':
                if (Math.abs(row - row1) == 1 && Math.abs(col - col1) == 1) {
                    return true;
                }
                ;
                break;
            case 'b':
                if (Math.abs(row - row1) == 1 && Math.abs(col - col1) == 1) {
                    return true;
                }
                ;
                break;
        }

        return false;
    }
    @Override
    public void move(int row, int col, int row1, int col1, Figure[][] fields)
    {
        // if col1 == 7 then we can transform it to any figure excepting king.
        if (row1 == 7 || row1 == 0)
        {
            char color = fields[row][col].getColor();
            Scanner s = new Scanner(System.in);
            String figure;
            do
            {
                System.out.println("Print Figure ");
                figure = s.nextLine();

            } while(Objects.equals(figure, "K"));
            Figure fig = new Pawn("P",color);
            switch (figure)
            {
                case "Q":
                    fig = new Queen("Q",color);
                    break;
                case "R":
                    fig = new Rook("R",color);
                    break;
                case "B":
                    fig = new Bishop("B",color);
                    break;
                default:
                    fig = new Knight("N",color);
                    break;

            }

            fields[row1][col1] = fig;

        }
        else
        {
            fields[row1][col1] = fields[row][col];
        }
        fields[row][col ] = null;
    }

}
