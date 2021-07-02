package edu.school21.printer;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.*;

public class Program {
    public static void main(String[] args) {
        if (args.length != 2 || args[0].length() != 2)
        {
            System.err.println("Illegal argument");
            System.exit(-1);
        }
        char white = args[0].charAt(0);
        char black = args[0].charAt(1);
        ReadBMP rbmp = new ReadBMP(args[1]);
        try
        {
            rbmp.seeBMPImage(white, black);
        }
        catch (IOException e)
        {
            System.out.println("Cannot read file!");
        }
    }
}
