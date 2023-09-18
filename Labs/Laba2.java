import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.*;
public class Laba2 {
    public static void main(String[] args) {


    }
    private static void solve1()
    {

        String str = "Ahaentabrbajdfae";
        String ans = "";
        for (int i = 0; i < str.length(); ++i)
        {
            String tmpStr = "";
            HashMap<String, Integer> hash_map = new HashMap<String, Integer>();
            for (int j = i; j < str.length(); ++j)
            {
                if (hash_map.containsKey(String.valueOf(str.charAt(j))))
                {
                    break;
                }
                tmpStr = tmpStr + str.charAt(j);
                hash_map.put(String.valueOf(str.charAt(j)),1);

            }
            if (tmpStr.length() > ans.length())
            {
                ans = tmpStr;
            }
        }


    }
    private static void solve2()
    {
        // O(n) time complexity;
        int[] firstArr = {1,4,6,9};
        int[] secondArr = {5,87};
        int i = 0, j = 0;
        int[] ans = new int[firstArr.length + secondArr.length];
        while (i < firstArr.length & j < secondArr.length)
        {
            if (firstArr[i] < secondArr[j])
            {
                ans[i+j] = firstArr[i];
                i += 1;
            }
            else
            {
                ans[i+j] = secondArr[j];
                j += 1;
            }
        }
        while (i < firstArr.length)
        {
            ans[i+j] = firstArr[i];
            i += 1;
        }
        while (j < secondArr.length)
        {
            ans[i+j] = secondArr[j];
            j += 1;
        }
    }
    private static void solve3()
    {
        int maxim = Integer.MIN_VALUE;
        Scanner s = new Scanner(System.in);
        System.out.println("enter amount of row:");
        int row = s.nextInt();

        int[] arr = new int[row];
        System.out.println("now print value of arr:\n");
        for (int i = 0; i < row; ++i)
        {

                int tmp = s.nextInt();
                arr[i]= tmp;

        }
        int tmpMax = 0;
        for (int i = 0; i < row; ++i)
        {
            tmpMax += arr[i];
            if (tmpMax > maxim)
            {
                maxim = tmpMax;
            }
            if (tmpMax <= 0)
            {
                tmpMax = 0;
            }
        }
    }
    private static void solve4()
    {
        Scanner s = new Scanner(System.in);
        System.out.println("enter amount of row:");
        int row = s.nextInt();
        System.out.println("enter amount of col:");
        int col = s.nextInt();
        int[][] arr = new int[row][col];
        System.out.println("now print value of arr:\n");
        for (int i = 0; i < row; ++i)
        {
            for (int j = 0; j < col; ++j)
            {
                int tmp = s.nextInt();
                arr[i][j] = tmp;
            }
        }
        int[][] ans = new int[col][row];
        for (int i = 0; i < row; ++i)
        {
            for (int j = 0; j < col; ++j)
            {
                ans[j][row-i-1] = arr[i][j];
            }
        }
        for (int i = 0; i < row; ++i)
        {

            for (int j = 0; j < col; ++j)
            {
                System.out.println(ans[j][i]);
            }

        }
    }
    private static void solve5()
    {
        int maxim = Integer.MIN_VALUE;
        Scanner s = new Scanner(System.in);
        System.out.println("enter amount of row:");
        int row = s.nextInt();

        int[] arr = new int[row];
        System.out.println("now print value of arr:\n");
        for (int i = 0; i < row; ++i)
        {

            int tmp = s.nextInt();
            arr[i]= tmp;

        }
        // O(n) time & space complexity
        int target = s.nextInt();
        HashMap<Integer, Integer> hash_map = new HashMap<Integer, Integer>();
        for (int i = 0; i < row; ++i)
        {
            if (hash_map.containsKey(target - arr[i]))
            {
                System.out.println("Return   %d  %d".formatted(i, hash_map.get(target-arr[i])));
            }
            else
            {
                hash_map.put(arr[i],i);
            }
        }
        System.out.println("Else return NULL :(  ");


    }
    private static void solve6()
    {
        int summa = 0;
        Scanner s = new Scanner(System.in);
        System.out.println("enter amount of row:");
        int row = s.nextInt();
        System.out.println("enter amount of col:");
        int col = s.nextInt();
        int[][] arr = new int[row][col];
        System.out.println("now print value of arr:\n");
        for (int i = 0; i < row; ++i)
        {
            for (int j = 0; j < col; ++j)
            {
                int tmp = s.nextInt();
                arr[i][j] = tmp;
                summa += arr[i][j];
            }
        }

    }
    private static void solve7()
    {
        Scanner s = new Scanner(System.in);
        System.out.println("enter amount of row:");
        int row = s.nextInt();
        System.out.println("enter amount of col:");
        int col = s.nextInt();
        int[][] arr = new int[row][col];
        System.out.println("now print value of arr:\n");
        for (int i = 0; i < row; ++i)
        {
            for (int j = 0; j < col; ++j)
            {
                int tmp = s.nextInt();
                arr[i][j] = tmp;
            }
        }
        for (int i = 0; i < row; ++i)
        {
            int maxim = Integer.MIN_VALUE;
            for (int j = 0; j < col; ++j)
            {
                if (arr[i][j] > maxim)
                {
                    maxim = arr[i][j];
                }
            }
            System.out.println("Maximum at  %d row is %d".formatted(i+1, maxim));
        }


    }
    private static void solve8()
    {
        Scanner s = new Scanner(System.in);
        System.out.println("enter amount of row:");
        int row = s.nextInt();
        System.out.println("enter amount of col:");
        int col = s.nextInt();
        int[][] arr = new int[row][col];
        System.out.println("now print value of arr:\n");
        for (int i = 0; i < row; ++i)
        {
            for (int j = 0; j < col; ++j)
            {
                int tmp = s.nextInt();
                arr[i][j] = tmp;
            }
        }
        int[][] ans = new int[col][row];
        for (int i = 0; i < row; ++i)
        {
            for (int j = 0; j < col; ++j)
            {
                ans[j][row-i-1] = arr[i][j];
            }
        }
        for (int i = 0; i < row; ++i)
        {

            for (int j = 0; j < col; ++j)
            {
                System.out.println(ans[j][i]);
            }

        }
    }


}