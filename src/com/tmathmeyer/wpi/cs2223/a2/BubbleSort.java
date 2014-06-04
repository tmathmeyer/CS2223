package com.tmathmeyer.wpi.cs2223.a2;

public class BubbleSort implements Sort
{
    int[] values;
    Viewer v;

    public void sort()
    {
        v.set(values);
        this.bubbleSort();
    }

    public void setValues(int[] values)
    {
        this.values = values;
    }

    public void setViewer(Viewer v)
    {
        this.v = v;
    }

    public void pause() throws InterruptedException
    {
        Thread.sleep(0);
    }

    public void bubbleSort()
    {
        boolean swapped = true;
        int j = 0;
        while (swapped)
        {
            swapped = false;
            j++;
            for (int i = 0; i < values.length - j; i++)
            {
                if (values[i] > values[i + 1])
                {
                    swap(i, i + 1);
                    swapped = true;
                    v.set(values);
                    // pause();
                }
            }
        }
    }

    public void swap(int px, int py)
    {
        int temp = values[px];
        values[px] = values[py];
        values[py] = temp;
    }
}