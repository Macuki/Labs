package laba4;
import laba4.figures.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Board {
    //TODO: Список фигур и начальное положение всех фигур
    private Figure fields[][] = new Figure[8][8];
    private ArrayList<String> takeWhite = new ArrayList(16);
    private ArrayList<String> takeBlack = new ArrayList(16);

    public char getColorGaming() {
        return colorGaming;
    }

    public void setColorGaming(char colorGaming) {
        this.colorGaming = colorGaming;
    }

    private char colorGaming;
    private boolean isKingAttacked = false;
    private String colorOfAttacked;

    public void init(){
        this.fields[0] = new Figure[]{
                new Rook("R", 'w'), new Knight("N", 'w'),
                new Bishop("B", 'w'), new Queen("Q", 'w'),
                new King("K", 'w'), new Bishop("B", 'w'),
                new Knight("N", 'w'),new Rook("R", 'w')
        };
        this.fields[1] = new Figure[]{
                new Pawn("P", 'w'),    new Pawn("P", 'w'),
                new Pawn("P", 'w'),    new Pawn("P", 'w'),
                new Pawn("P", 'w'),    new Pawn("P", 'w'),
                new Pawn("P", 'w'),    new Pawn("P", 'w'),
        };

        this.fields[7] = new Figure[]{
                new Rook("R", 'b'), new Knight("N", 'b'),
                new Bishop("B", 'b'), new Queen("Q", 'b'),
                new King("K", 'b'), new Bishop("B", 'b'),
                new Knight("N", 'b'),new Rook("R", 'b')
        };
        this.fields[6] = new Figure[]{
                new Pawn("P", 'b'),    new Pawn("P", 'b'),
                new Pawn("P", 'b'),    new Pawn("P", 'b'),
                new Pawn("P", 'b'),    new Pawn("P", 'b'),
                new Pawn("P", 'b'),    new Pawn("P", 'b'),
        };
    }

    public String getCell(int row, int col){
        Figure figure = this.fields[row][col];
        if (figure == null){
            return "    ";
        }
        return " "+figure.getColor()+figure.getName()+" ";
    }

    public ArrayList<String> getTakeWhite() {
        return takeWhite;
    }

    public ArrayList<String> getTakeBlack() {
        return takeBlack;
    }

    public boolean move_figure(int row1, int col1, int row2, int col2 ){

        Figure figure =  this.fields[row1][col1];
        if (this.isKingAttacked == true)
        {
            boolean flag2 = false;
            do
            {
                if (flag2 == true)
                {
                    System.out.println("Нельзя так ходить, так как имеется шах");
                    Scanner in = new Scanner(System.in);
                    String inputLine = in.nextLine();
                    String[] coords = inputLine.split(" ");
                    row1 = Integer.parseInt(coords[0]);
                    col1 = Integer.parseInt(coords[1]);
                    row2 = Integer.parseInt(coords[2]);
                    col2 = Integer.parseInt(coords[3]);
                    figure =  this.fields[row1][col1];
                }
                if (figure.canMove(row1,col1,row2,col2,this.fields))
                {
                    figure.move(row1,col1,row2,col2,this.fields);
                }
                boolean flag = false;
                char color;
                if (Objects.equals(colorOfAttacked, "white"))
                {
                    color = 'b';
                }
                else
                {
                    color = 'w';
                }
                for (int i = 0; i < 8; ++i)
                {
                    for (int j =0; j < 8; ++j)
                    {
                        if (fields[i][j] != null && fields[i][j].getColor() == color && fields[i][j].canAttackKing(i, j, this.fields))
                        {
                            flag = true;
                            break;
                        }
                    }
                    if (flag == true)
                    {
                        break;
                    }
                }
                if (flag == true)
                {
                    this.fields[row2][col2] = null;
                    this.fields[row1][col1] = figure;
                }
                else
                {
                    this.isKingAttacked = false;
                }
                if (flag2 == false)
                {
                    flag2 = true;
                }
            } while (this.isKingAttacked == true);
            return true;
        }

        else if ((figure.canMove(row1, col1, row2, col2,this.fields))  || (Objects.equals(this.fields[row1][col1].getName(), "K") && Objects.equals(this.fields[row2][col2].getName(), "R"))){
            System.out.println("move");
            figure.move(row1,col1,row2,col2,this.fields);
            this.isKingAttacked = figure.canAttackKing(row2,col2,this.fields);
            if (this.isKingAttacked == true)
            {
                if (fields[row2][col2].getColor() == 'w')
                {
                    this.colorOfAttacked = "black";
                }
                else
                {
                    this.colorOfAttacked = "white";
                }
                System.out.println(colorOfAttacked + " king is Attacked, Save him!");
            }
            return true;
        } else if (figure.canAttack(row1, col1, row2, col2,this.fields) && this.fields[row2][col2] != null && this.fields[row2][col2].getColor() != this.fields[row1][col1].getColor() ){
            System.out.println("attack");
            switch (this.fields[row2][col2].getColor()){
                case 'w': this.takeWhite.add(this.fields[row2][col2].getColor()+this.fields[row2][col2].getName());break;
                case 'b': this.takeBlack.add(this.fields[row2][col2].getColor()+this.fields[row2][col2].getName());break;
            }
            figure.attack(row1,col1,row2,col2,this.fields);
            return true;
        }
        return false;





    }

    public void print_board(){
        System.out.println(" +----+----+----+----+----+----+----+----+");
        for(int row = 7; row > -1; row--){
            System.out.print(row);
            for(int col = 0; col< 8; col++){
                System.out.print("|"+getCell(row, col));
            }
            System.out.println("|");
            System.out.println(" +----+----+----+----+----+----+----+----+");
        }

        for(int col = 0; col < 8; col++){
            System.out.print("    "+col);
        }


    }


}
