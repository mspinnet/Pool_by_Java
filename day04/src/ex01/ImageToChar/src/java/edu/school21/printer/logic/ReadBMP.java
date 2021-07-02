package edu.school21.printer;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.*;

public class ReadBMP {
    private String BMPFileName;

    public ReadBMP(String filename)
    {
        BMPFileName = filename;
    }

    public void seeBMPImage(char white, char black) throws IOException
    {
        File file = new File(BMPFileName);
        BufferedImage image = ImageIO.read(file);
        char[][] array2D = new char[image.getHeight()][image.getWidth()];

        for (int xPixel = 0; xPixel < image.getHeight(); xPixel++)
        {
            for (int yPixel = 0; yPixel < image.getWidth(); yPixel++)
            {
                int color = image.getRGB(yPixel, xPixel);
                if (color==Color.BLACK.getRGB()) {
                    array2D[xPixel][yPixel] = black;
                } else {
                    array2D[xPixel][yPixel] = white;
                }
            }
        }
        for (int x = 0; x < array2D.length; x++)
        {
            for (int y = 0; y < array2D[x].length; y++)
            {
                System.out.print(array2D[x][y]);
            }
            System.out.println();
        }
    }
}
