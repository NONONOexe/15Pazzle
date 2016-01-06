import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

public class Player
{
    private BoardManager bm;

    public Player(BoardManager bm)
    {
        this.bm = bm;
    }

    private Direction getInputDirection()
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String input = null;
        Direction d = null;
        try
        {
            input = br.readLine();
        }
        catch(IOException ioe)
        {
            System.err.println("Input Error!");
        }
        if(input.equals("q"))
        {
            System.exit(0);
        }
        d = Direction.getDirection(input);
        if(d == null)
        {
            String msg = "UP:w, DOWN:s, LEFT:a, RIGHT:d, QUIT:q";
            System.out.println(msg);
        }
        return d;
    }

    private void turn()
    {
        bm.show();
        bm.move(getInputDirection());
    }

    private void finish()
    {
        if(bm.isGameOver())
            bm.show();
    }

    public void play()
    {
        while(!bm.isGameOver())
        {
            turn();
        }
        finish();
    }

    public void playOnGUI(PuzzleGUI gui)
    {
        gui.start();
        while(!bm.isGameOver())
        {
            turn();
            gui.repaint();
        }
        finish();
        gui.repaint();
    }
}
