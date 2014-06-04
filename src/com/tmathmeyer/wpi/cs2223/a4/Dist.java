package com.tmathmeyer.wpi.cs2223.a4;

public class Dist
{
    public static void main(String[] args)
    {
        int[][] vals = new int[args[0].length() + 1][args[1].length() + 1];
        for (int i = 0; i < vals.length; i++)
        {
            vals[i][0] = i * 2;
        }
        for (int i = 0; i < vals[0].length; i++)
        {
            vals[0][i] = i * 2;
        }
        for (int i = 1; i < vals.length; i++)
        {
            for (int j = 1; j < vals[i].length; j++)
            {
                int diag = 2;
                if (args[0].charAt(i - 1) == args[1].charAt(j - 1))
                {
                    diag = 0;
                }
                else if (args[0].charAt(i - 1) == 'C' || args[0].charAt(i - 1) == 'G')
                {   
                    if (args[1].charAt(j - 1) == 'C' || args[1].charAt(j - 1) == 'G')
                    {
                        diag = 1;
                    }
                }
                vals[i][j] = min(vals[i - 1][j] + 2, vals[i][j - 1] + 2, (vals[i - 1][j - 1] + diag));
            }
        }
        print(vals);
    }

    public static int min(int a, int b, int c)
    {
        return min(a, min(b, c));
    }

    public static int min(int a, int b)
    {
        return a < b ? a : b;
    }

    public static void print(int[][] vals)
    {
        System.out.println("+===+===+===+===+===+===+===+===+===+===+===+===+");
        for (int i = 0; i < vals.length; i++)
        {
            for (int j = 0; j < vals[i].length; j++)
            {
                System.out.print((vals[i][j] < 10 ? "| " : "|") + vals[i][j] + " ");
            }
            System.out.println("|\n+===+===+===+===+===+===+===+===+===+===+===+===+");
        }
        System.out.println("");
    }
}