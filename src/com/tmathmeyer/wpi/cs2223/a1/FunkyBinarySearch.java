package com.tmathmeyer.wpi.cs2223.a1;

public class FunkyBinarySearch
{
    public static void main(String[] args)
    {
        int[] sortedArray = new int[100];
        for (int i = 0; i < 100; i++)
            sortedArray[i] = 2 * (i + 1);

        int key = Integer.parseInt(args[0]);
        int upper = 100;
        int lower = 0;
        int comparisons = 0;
        boolean found = false;
        int position = 0;

        while (lower < upper)
        {
            int third = (upper - lower) / 3 + lower;
            if (sortedArray[third] > key)
            {
                upper = third;
            }
            else if (sortedArray[third] < key)
            {
                lower = third;
            }
            else
            {
                lower = 200;
                found = true;
                position = third;
            }
            comparisons++;
            if (third == lower)
            {
                lower++;
            }
        }

        System.out.println("The Key " + key + " was " + (found ? "" : "not ") + "found");
        System.out.println("The search performed " + comparisons + " comparisons");
        if (found)
        {
            System.out.println("K was found at " + (position + 1));
        }
    }
}