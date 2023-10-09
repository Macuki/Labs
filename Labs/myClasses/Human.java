package myClasses;

import java.util.Vector;

public class Human
{
    public Vector<Cinema> cinemas = new Vector<Cinema>();
    public void cntOfCinemas()
    {
        System.out.println("There are " + this.cinemas.size() + " cinema halls at Cinema");
    }
    public void addCinema()
    {
        Cinema tmp = new Cinema();
        this.cinemas.add(tmp);
    }
}