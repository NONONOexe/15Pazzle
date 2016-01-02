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
        d = Direction.getDirection(input);
        if(d == null)
        {
            String msg = "UP:w, DOWN:s, LEFT:a, RIGHT:d";
            System.out.println(msg);
        }

        return d;
    }

    public void play()
    {
        while(!bm.isGameOver())
        {
            bm.move(getInputDirection());
            bm.show();
        }
    }
}
