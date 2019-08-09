package bitmap.transformer;


import javafx.scene.transform.MatrixType;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;


public class Bitmap {
    private int[][] imgHeightNWidth;
    private BufferedImage img;

    public Bitmap(int[][]  imgHeightNWidth , BufferedImage img){
        this.imgHeightNWidth = imgHeightNWidth;
        this.img = img;

    }

    public static void main(String[] args) {
        BufferedImage img = bitmapReadFile("./assets/coffee.bmp");
        BufferedImage newImage = bitmapTransformer("2",img);
        bitmapWriteFile(newImage,"./assets/coffeeNew.bmp" );
    }

    public static BufferedImage bitmapReadFile(String path){
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(path));
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return img;
    }

    public static void bitmapWriteFile(BufferedImage updatedImage,String path){
        try {
            ImageIO.write(updatedImage, "bmp", new File(path));
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }

    }

    public static BufferedImage bitmapTransformer(String transform, BufferedImage img){
        if(transform == "1") {
        int[][] imgHeightNWidth = new int[img.getHeight()][img.getWidth()];
        Bitmap newBitmap = new Bitmap(imgHeightNWidth,img);
        int width = newBitmap.img.getWidth();

            for (int i = 0; i < newBitmap.imgHeightNWidth.length; i++) {
                for (int j = 0; j < newBitmap.imgHeightNWidth[i].length; j++) {
                    newBitmap.img.setRGB((width - 1) - j, i, img.getRGB(j, i));
                }
            }
            return newBitmap.img;
        }
        if(transform == "2") {
        int[][] imgHeightNWidth = new int[img.getHeight()][img.getWidth()];
        Bitmap newBitmap = new Bitmap(imgHeightNWidth,img);
        int height = newBitmap.img.getHeight();

            for (int i = 0; i < newBitmap.imgHeightNWidth.length; i++) {
                for (int j = 0; j < newBitmap.imgHeightNWidth[i].length; j++) {
                    newBitmap.img.setRGB(j,(height - 1) - i,  img.getRGB(j, i));
                }
            }
            return newBitmap.img;
        }

        return img;
    }

}
