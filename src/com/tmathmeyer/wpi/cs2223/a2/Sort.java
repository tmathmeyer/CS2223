package com.tmathmeyer.wpi.cs2223.a2;

public interface Sort
{
    public void sort() throws InterruptedException;

    public void setValues(int[] values);

    public void setViewer(Viewer v);
}