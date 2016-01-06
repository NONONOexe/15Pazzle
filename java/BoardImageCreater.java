import java.util.ArrayList;
import java.awt.image.BufferedImage;

class BoardImageCreater
{
    private int cols;
    private int rows;
    private int size;

    public BoardImageCreater(int cols, int rows)
    {
        this.cols = cols;
        this.rows = rows;
        this.size = cols * rows;
    }

    public ArrayList<BufferedImage> create(String filePath)
    {
        BufferedImage original = ImageLoader.getImage(filePath);
        int width = original.getWidth() / cols;
        int height = original.getHeight() / rows;
        ArrayList<BufferedImage> boardImage = new ArrayList<>(size);
        for(int row = 0; row < rows; row++)
        {
            for(int col = 0; col < cols; col++)
            {
                int x = col * width;
                int y = row * height;
                BufferedImage sub = original.getSubimage(x, y, width, height);
                boardImage.add(sub);
            }
        }
        return boardImage;
    }
}
