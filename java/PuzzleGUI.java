import java.lang.Thread;
import java.lang.InterruptedException;

class PuzzleGUI
{
    BoardManager bm;
    PuzzleJFrame frame;
    PuzzleJPanel panel;

    public PuzzleGUI(BoardManager bm)
    {
        this.bm = bm;
    }

    public void start()
    {
        frame = new PuzzleJFrame();
        panel = new PuzzleJPanel(bm);
        frame.add(panel);
        frame.setVisible(true);
    }

    public PuzzleJPanel getPanel()
    {
        return panel;
    }

    public void repaint()
    {
        frame.repaint();
    }
}
