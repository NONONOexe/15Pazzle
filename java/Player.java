import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Player
{
    // derections
    public static final int UP      = 1;
    public static final int DOWN    = 2;
    public static final int LEFT    = 3;
    public static final int RIGHT   = 4;

    public int getInputDirection() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String str = br.readLine();

        if(str.equals("w"))
        {
            return UP;
        }
        else if(str.equals("s"))
        {
            return DOWN;
        }
        else if(str.equals("a"))
        {
            return LEFT;
        }
        else if(str.equals("d"))
        {
            return RIGHT;
        }

        return -1;
    }
}
