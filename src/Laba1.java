import java.io.*;
import java.util.Scanner;
public class Laba1 {
    public static void main(String[] args) {
        System.out.println(solve3());

    }
    private static int solve1()
    {

        Scanner s = new Scanner(System.in);
        int number = s.nextInt();
        int cnt = 0;
        while (number != 1)
        {
            if (number % 2 == 0)
            {
                number /= 2;

            }
            else
            {
                number = 3*number + 1;
            }
            cnt += 1;
        }
        return cnt;
    }
    private static int solve2()
    {
       Scanner s = new Scanner(System.in);
       int n = s.nextInt();
       int sign = 1;
       int sum = 0;
       for (int i = 0; i < n; ++i)
       {
           int tmpValue = s.nextInt();
           sum += tmpValue*sign;
           sign *=-1;
       }
       return sum;
    }

    private static int solve3()
    {
        Scanner s = new Scanner(System.in);
        int x = 0;
        int y = 0;
        int x0 = s.nextInt();
        int y0 = s.nextInt();
        int cnt = 0;
        while (true)
        {
            String tmp = s.nextLine();
            if (tmp.equals("стоп"))
            {
                break;
            }
            else
            {
                if (x == x0 & y == y0)
                {
                    continue;
                }
                else
                {
                    int step = s.nextInt();
                    if (tmp.equals("север"))
                    {
                        y0 += step;
                    }
                    else if (tmp.equals("запад"))
                    {
                        x0 -= step;
                    }
                    else if (tmp.equals("юг"))
                    {
                        y0 -= step;

                    }
                    else
                    {
                        x0 += step;
                    }
                    cnt += 1;
                }
            }
        }

        return cnt;
    }
    private static void solve4()
    {
        int numberOfRoad = -1;
        int maxHeight = -1;
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for (int i = 1; i <= n; ++i)
        {
            int tmpRoad = s.nextInt();
            int tmpMax = Integer.MAX_VALUE;
            for (int j = 0; j < tmpRoad; ++j)
            {
                int tmpValue = s.nextInt();
                tmpMax = Math.min(tmpMax,tmpValue);
            }
            if (tmpMax > maxHeight)
            {
                maxHeight = tmpMax;
                numberOfRoad = i;
            }
        }
        System.out.println(numberOfRoad);
        System.out.println(maxHeight);
    }
    private static boolean solve5()
    {
        Scanner s = new Scanner(System.in);
        int number = s.nextInt();
        int sum = 0;
        int product = 1;
        while (number > 0)
        {
            int digit = number % 10;
            sum += digit;
            product *= digit;
            number /= 10;
        }
        return sum % 2 == 0 & product % 2 == 0;
    }

}