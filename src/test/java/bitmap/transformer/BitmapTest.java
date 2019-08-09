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

    }

    @Test
    public void bitmapTransformer() {
    }
}