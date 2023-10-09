package myClasses;

import java.util.Scanner;
import java.util.Vector;

public class Cinema_hall
{
    Cinema_hall(int cntOfRow)
    {

        Scanner in = new Scanner(System.in);
        for (int i = 0; i < cntOfRow; ++i)
        {
            Vector<Boolean> tmpVector = new Vector<Boolean>();
            System.out.println("enter cnt of chair at the row:");
            int cnt = in.nextInt();
            for (int j = 0; j < cnt; ++j)
            {
                tmpVector.add(false);
            }
            this.chairs.add(tmpVector);
        }
    }

    //vector of movies' time
    public Vector<Integer> time = new Vector<Integer>();
    // vector of movies' name.
    public Vector<String> name = new Vector<String>();
    // vector of movies' start.
    public Vector<String> start = new Vector<String>();
    // Vector of vector - cnt of chairs.
    Vector<Vector<Boolean>> chairs = new Vector<Vector<Boolean>>();
    // Is chair available at the movie at the position.
    Vector<Vector<Vector<Boolean>>> isNotAvailable = new Vector<Vector<Vector<Boolean>>>();
    public void showMovies()
    {
        System.out.println("Here are following movies:");
        for (int i = 0; i < time.size(); ++i)
        {
            System.out.println(i+1 + ") Name:" + this.name.elementAt(i) + ", Length of film: " + this.time.elementAt(i) + ", the beginning of the film: " + this.start.elementAt(i));
            System.out.println("available chairs:");
            showFreeChairAtMovie(i+1);
        }
    }
    public void addMovie()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("First, print name of movie you wanna add:");
        String tmpName = in.nextLine();
        System.out.println("and what time it'll start (please use the following format: hh:minutes)?");
        String tmpStart = in.nextLine();
        System.out.println("Ok, then how long in minutes it will?");
        Integer tmpTime = in.nextInt();
        this.time.add(tmpTime);
        this.name.add(tmpName);
        this.start.add(tmpStart);
        this.isNotAvailable.add(this.chairs);
        System.out.println("operation was successful, thanks a lot");

    }
    public void showFreeChairAtMovie(int index)
    {
        for (int i = 0; i < this.chairs.size(); ++i)
        {
            System.out.print("At " + (i + 1) +" row: ");
            for (int j =0; j < this.chairs.elementAt(i).size(); ++j)
            {
                if (this.isNotAvailable.elementAt(index-1).elementAt(i).elementAt(j) == false)
                {
                    System.out.print(j + 1 + "; ");
                }
            }
            System.out.println();

        }
    }
    public void takeChairAtMovie(int indexOfMovie, int row, int cntOfChair)
    {
        this.isNotAvailable.elementAt(indexOfMovie - 1).elementAt(row-1).set(cntOfChair - 1,true);
    }



}