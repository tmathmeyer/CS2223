package com.tmathmeyer.wpi.cs2223.a1;

public class Loops
{

    public static int singleLoop(int[] data)
    {
        int sum = 0;
        for (int i = 0; i < data.length; i++)
        {
            sum += data[i];
        }
        return sum;
    }

    public static int doubleLoop(int[] data)
    {
        int sum = 0;
        for (int i = 0; i < data.length; i++)
        {
            for (int j = 0; j < data.length; j++)
            {
                sum += data[i] * data[j];
            }
        }
        return sum;
    }

    public static int tripleLoop(int[] data)
    {
        int sum = 0;
        for (int i = 0; i < data.length; i++)
        {
            for (int j = 0; j < data.length; j++)
            {
                for (int k = 0; k < data.length; k++)
                {
                    sum += data[i] + data[j] + data[k];
                }
            }
        }
        return sum;
    }

    public static void main(String[] args)
    {
        int[] data = new int[5000];
        long start = 0;
        long elapsed = 0;
        int arg = Integer.parseInt(args[0]);

        if (arg == 1)
        {
            start = System.nanoTime();
            Loops.singleLoop(data);
            elapsed = System.nanoTime() - start;
            System.out.println("Single Loop: " + elapsed / 1000000000.0);
        }

        if (arg == 2)
        {
            start = System.nanoTime();
            Loops.doubleLoop(data);
            elapsed = System.nanoTime() - start;
            System.out.println("Double Loop: " + elapsed / 1000000000.0);
        }

        if (arg == 3)
        {
            start = System.nanoTime();
            Loops.tripleLoop(data);
            elapsed = System.nanoTime() - start;
            System.out.println("Triple Loop: " + elapsed / 1000000000.0);
        }
    }

    /*
     * The data I got from this was as follows (I have a slow computer):
     * Single Loop: 1.89864E-4
     * Double Loop: 0.046412057
     * Triple Loop: 95.469213534
     * 
     * All data are in seconds
     */
}
