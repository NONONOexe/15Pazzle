import java.util.ArrayList;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

class PuzzleJPanel extends JPanel
{
    private BoardManager bm;
    // private ArrayList<JPanel> panels;
    private ArrayList<BufferedImage> boardImage;

    public PuzzleJPanel(BoardManager bm)
    {
        int cols = bm.getCols();
        int rows = bm.getRows();
        int size = bm.getSize();
        this.bm = bm;
        // setLayout(new GridLayout(cols, rows));
        // this.panels = new ArrayList<>(size);
        // for(int i = 0; i < size; i++)
        // {
        //     JPanel panel = new JPanel();
        //     add(panel);
        //     panels.add(panel);
        // }
        BoardImageCreater bic = new BoardImageCreater(bm.getCols(), bm.getRows());
        boardImage = bic.create("./image/Octocat.png");
    }

    @Override
    public void update(Graphics g)
    {
        super.update(g);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        ArrayList<Number> board = bm.getBoard();
        int w = getWidth() / bm.getCols();
        int h = getHeight() / bm.getRows();
        int cols = bm.getCols();
        int rows = bm.getRows();
        for(int row = 0; row < rows; row++)
        {
            for(int col = 0; col < cols; col++)
            {
                int index = bm.toLinear(col, row);
                int num = board.get(index).getNum();
                int x = col * w;
                int y = row * h;
                BufferedImage sub = boardImage.get(num - 1);
                g.drawImage(sub, x, y, w, h, Color.WHITE, this);
            }
        }
    }
}
