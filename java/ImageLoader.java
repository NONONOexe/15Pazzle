import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

class ImageLoader
{
    public static final BufferedImage getImage(String filePath)
    {
        File file = new File(filePath);
        BufferedImage img = null;
        try
        {
            img = ImageIO.read(file);
        }
        catch(IOException ioe)
        {
            System.err.println("Input image error");
            System.exit(0);
        }
        return img;
    }
}
