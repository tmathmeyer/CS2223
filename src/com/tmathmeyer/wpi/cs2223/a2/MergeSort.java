package com.tmathmeyer.wpi.cs2223.a2;

public class MergeSort implements Sort
{
    int[] values;
    int[] helper;

    Viewer v;

    public void sort() throws InterruptedException
    {
        v.set(values);
        this.mergeSort(0, values.length - 1);
    }

    public void setValues(int[] values)
    {
        this.values = values;
        this.helper = new int[values.length];
    }

    public void setViewer(Viewer v)
    {
        this.v = v;
    }

    public void mergeSort(int low, int high) throws InterruptedException
    {
        if (high > low)
        {
            int middle = low + (high - low) / 2;
            mergeSort(low, middle);
            mergeSort(middle + 1, high);
            merge(low, middle, high);
        }
    }

    private void merge(int low, int middle, int high) throws InterruptedException
    {
        for (int i = low; i <= high; i++)
            helper[i] = values[i];

        int i = low;
        int j = middle + 1;
        int k = low;

        while (i <= middle && j <= high)
        {
            if (helper[i] <= helper[j])
            {
                values[k] = helper[i];
                v.set(values);
                i++;
                pause();
            }
            else
            {
                values[k] = helper[j];
                v.set(values);
                j++;
                pause();
            }
            k++;
        }
        while (i <= middle)
        {
            values[k] = helper[i];
            v.set(values);
            k++;
            i++;
            pause();
        }

    }

    public void pause() throws InterruptedException
    {
        Thread.sleep(0);
    }
}