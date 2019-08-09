package bitmap.transformer;


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
        if(args.length == 3) {
            BufferedImage img = bitmapReadFile(args[0]);
            BufferedImage newImage = bitmapTransformer(args[2], img);
            bitmapWriteFile(newImage, args[1]);
            System.out.println("Success, you have transformed the picture");
        }
        else{
            System.out.println("Please enter all the arguments in this order ./gradlew run --args ./assets/coffee.bmp ./assets/coffeeNew.bmp one");
        }
    }

    public static BufferedImage bitmapReadFile(String path){
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(path));
        }catch (IOException e){
            System.out.println(e.getMessage()+" " + path + " is not a path, try again");
        }
        return img;
    }

    public static void bitmapWriteFile(BufferedImage updatedImage,String path){
        try {
            ImageIO.write(updatedImage, "bmp", new File(path));
        }
        catch (IOException e){
            System.out.println(e.getMessage()+" " + path + " is not a path, try again");
        }

    }

    public static BufferedImage bitmapTransformer(String transform, BufferedImage img){
        if(transform.equals("one")) {
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
        if(transform.equals("two")){
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
        if(transform.equals("three")) {
            int[][] imgHeightNWidth = new int[img.getHeight()][img.getWidth()];
            Bitmap newBitmap = new Bitmap(imgHeightNWidth,img);
            int width = newBitmap.img.getWidth();
            for (int i = 0; i < newBitmap.imgHeightNWidth.length; i++) {
                for (int j = 0; j < newBitmap.imgHeightNWidth[i].length; j++) {
                    newBitmap.img.setRGB((width - 1) - j, i, img.getRGB(j, i));
                }
            }
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
