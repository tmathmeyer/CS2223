package com.tmathmeyer.wpi.cs2223.a2;

public class HeapSort implements Sort
{
    int[] values;
    Viewer v;

    public void sort() throws InterruptedException
    {
        v.set(values);
        this.heapify();
        this.heapSort(values.length - 1);
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

    public void swap(int px, int py)
    {
        int temp = values[px];
        values[px] = values[py];
        values[py] = temp;
    }

    public void heapify() throws InterruptedException
    {
        for (int lastHeapIndex = 0; lastHeapIndex < values.length - 1; lastHeapIndex++)
        {
            int newAddition = lastHeapIndex + 1;
            int parent = lastHeapIndex / 2;
            while (values[parent] < values[newAddition])
            {
                swap(parent, newAddition);
                v.set(values);
                pause();
                newAddition = parent;
                parent = (parent - 1) / 2;
            }
        }
    }

    public void reHeapify(int top, int max) throws InterruptedException
    {
        int left = top * 2 + 1;
        int right = top * 2 + 2;
        if (left >= max)
            return;
        if (right >= max && values[top] < values[left])
        {
            swap(left, top);
            reHeapify(left, max);
        }

        v.set(values);
        this.pause();

        if (values[left] >= values[right] && values[top] < values[left])
        {
            swap(top, left);
            reHeapify(left, max);
        }
        else if (values[top] < values[right])
        {
            swap(top, right);
            reHeapify(right, max);
        }
    }

    public void heapSort(int v) throws InterruptedException
    {
        for (int lastHeapIndex = v; lastHeapIndex >= 0; lastHeapIndex--)
        {
            swap(0, lastHeapIndex);
            this.v.set(values);
            pause();
            reHeapify(0, lastHeapIndex - 1);
        }
    }

    public boolean isHeap(int head, int last)
    {
        int left = head * 2 + 1;
        int right = head * 2 + 2;

        boolean r = (right >= last) ? true : (values[right] <= values[head] && isHeap(right, last));
        boolean l = (left >= last) ? true : (values[left] <= values[head] && isHeap(left, last));

        return l && r;
    }
}
