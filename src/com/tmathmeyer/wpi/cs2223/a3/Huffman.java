package com.tmathmeyer.wpi.cs2223.a3;

public class Huffman
{
    public static void main(String[] args) throws Exception
    {
        String mode = args[0];
        String fileFrom = args[1];
        String fileTo = args[2];

        if (mode.equalsIgnoreCase("encode"))
        {
            new Encode(fileFrom, fileTo);
        }
        if (mode.equalsIgnoreCase("decode"))
        {
            new Decode(fileFrom, fileTo);
        }
    }
}