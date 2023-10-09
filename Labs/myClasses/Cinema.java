package myClasses;

import java.util.Scanner;
import java.util.Vector;



public class Cinema
{
    public Vector<Cinema_hall> cimena_halls = new Vector<Cinema_hall>();
    public void cntOfCinemaHalls()
    {
        System.out.println("There are " + this.cimena_halls.size() + " cimena halls at Cinema");
    }
    public void addCinemaHalls()
    {
        System.out.println("how much row in cinema hall do you like?");
        Scanner in = new Scanner(System.in);
        int cnt = in.nextInt();
        Cinema_hall tmp = new Cinema_hall(cnt);
        this.cimena_halls.add(tmp);
    }
}
