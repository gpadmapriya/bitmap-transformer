package bitmap.transformer;

import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class BitmapTest {

    @Test
    public void bitmapReadFile() {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("./assets/coffee.bmp"));
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        assertNotNull("this should return a buffered image",Bitmap.bitmapReadFile("./assets/coffee.bmp"));
    }

    @Test
    public void bitmapWriteFile() {

        try {
            BufferedImage img = null;
            img = ImageIO.read(new File("./assets/coffee.bmp"));
            int[][] imgHeightNWidth = new int[img.getHeight()][img.getWidth()];
            Bitmap newBitmap = new Bitmap(imgHeightNWidth,img);
            newBitmap.bitmapWriteFile(img,"./assets/coffee.bmp");
            BufferedImage img2 = null;
            img2 = ImageIO.read(new File("./assets/coffeeNew.bmp"));
            int[][] imgHeightNWidth2 = new int[img.getHeight()][img.getWidth()];
            assertFalse("this should return false",newBitmap.compare(img,img2));
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void bitmapTransformer() {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("./assets/coffee.bmp"));
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        int[][] imgHeightNWidth = new int[img.getHeight()][img.getWidth()];
        Bitmap newBitmap = new Bitmap(imgHeightNWidth,img);
        int width = newBitmap.img.getWidth();

        for (int i = 0; i < newBitmap.imgHeightNWidth.length; i++) {
            for (int j = 0; j < newBitmap.imgHeightNWidth[i].length; j++) {
                newBitmap.img.setRGB((width - 1) - j, i, img.getRGB(j, i));
            }
        }
        assertTrue("this should be true",newBitmap.compareTransformed(newBitmap.img,img));
    }
}