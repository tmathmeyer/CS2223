package com.tmathmeyer.wpi.cs2223.avl;

public class Main
{
    public static void main(String[] args)
    {
        AVL<Integer> v = new EmptyAVLTree<>();
        for (int i = 0; i < 200; i++)
        {
            v = v.add(i);
        }

        v.print(0);
    }
}