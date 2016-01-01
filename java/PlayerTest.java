import java.io.IOException;

final class PlayerTest
{

    public static void main(String args[]) throws IOException
    {
        Player player = new Player();
        int input = 0;

        while(input != -1)
        {
            input = player.getInputDirection();
            System.out.println(input);
        }
    }
}
