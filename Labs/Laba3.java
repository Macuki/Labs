
import java.util.*;
import java.util.Vector;
import java.util.Scanner;
import myClasses.*;


public class Laba3 {

    public static void main(String[] args) {

        Human a = new Human();
        // while flag == true we will use our application
        boolean flag = true;
        int mode;// 0 - basic user, 1 - administraion.
        Scanner in = new Scanner(System.in);
        int cnt;
        while (flag == true)
        {
            System.out.println("choose 0 to be a basic user or 1 - to administraion ");
            mode = in.nextInt();
            if (mode == 0)
            {
                System.out.println("what do you wanna do?");
                System.out.println("1) cheks available movie");
                System.out.println("2) TakeChairAtCinema");
                cnt = in.nextInt();
                if (cnt == 1)
                {
                    a.cntOfCinemas();
                    System.out.println("please, choose cinema:");
                    cnt = in.nextInt();
                    for (int i = 0; i < a.cinemas.elementAt(cnt-1).cimena_halls.size(); ++i)
                    {
                        a.cinemas.elementAt(cnt-1).cimena_halls.elementAt(i).showMovies();
                    }
                    a.cinemas.elementAt(cnt-1);
                }
                else
                {
                    for (int i = 0; i < a.cinemas.size(); ++i)
                    {
                        System.out.println("-----------------------------");
                        System.out.println(i+1 +"th cinema:");

                        for (int j = 0; j < a.cinemas.elementAt(i).cimena_halls.size(); ++j)
                        {
                            System.out.println(j + 1 + "th cinema halls");
                            a.cinemas.elementAt(i).cimena_halls.elementAt(j).showMovies();
                        }
                    }
                    System.out.println("-----------------------------");
                    System.out.println("please, choose the cinema");
                    int cin = in.nextInt();
                    System.out.println("cinema hall");
                    int cin_hall = in.nextInt();
                    System.out.println("number of movie");
                    int number = in.nextInt();
                    System.out.println("and row with col");
                    System.out.println("row:");
                    int row = in.nextInt();
                    System.out.println("col:");
                    int col = in.nextInt();
                    a.cinemas.elementAt(cin-1).cimena_halls.elementAt(cin_hall-1).takeChairAtMovie(number,row,col);
                }

            }
            else
            {
                System.out.println("what do you wanna do?");
                System.out.println("1) add a cinema");
                System.out.println("2) add a cinema hall");
                System.out.println("3) add a movie");
                System.out.println("4) type all info:");
                cnt = in.nextInt();
                if (cnt == 1)
                {
                    a.addCinema();
                }
                else if (cnt == 2)
                {
                    System.out.println("in which cinema do you like to add a cinema hall?");
                    cnt = in.nextInt();
                    a.cinemas.elementAt(cnt-1).addCinemaHalls();
                }
                else if (cnt == 3)
                {
                    System.out.println("in which cinema do you like to add a movie");
                    cnt = in.nextInt();
                    System.out.println("and in which cinema halls?");
                    int tmp = in.nextInt();
                    a.cinemas.elementAt(cnt-1).cimena_halls.elementAt(tmp-1).addMovie();
                }
                else
                {
                    for (int i = 0; i < a.cinemas.size(); ++i)
                    {
                        System.out.println("-----------------------------");
                        System.out.println(i+1 +"th cinema:");

                        for (int j = 0; j < a.cinemas.elementAt(i).cimena_halls.size(); ++j)
                        {
                            System.out.println(j + 1 + "th cinema halls");
                            a.cinemas.elementAt(i).cimena_halls.elementAt(j).showMovies();
                        }


                    }
                    System.out.println("-----------------------------");
                }
            }
            System.out.println("do you wanna exit? Press 0 to exit else 1");
            cnt = in.nextInt();
            flag = cnt != 0;
        }

    }


}
