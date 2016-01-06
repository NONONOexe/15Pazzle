public final class Pazzle
{
    public static final String description
        = "java BoardManager <col> <row> <blankPosition>\n"
        + "col - Column number of board\n"
        + "row - Lows of board\n"
        + "blankPosition - You can select free(0) or lower right(1).";

    public static void main(String args[])
    {
        if(args.length < 2 || 3 < args.length)
        {
            System.err.println(description);
            return;
        }

        int col = Integer.parseInt(args[0]);
        int row = Integer.parseInt(args[1]);
        int blankPosition = (args.length == 3) ?
            Integer.parseInt(args[2]) : 0;
        BoardManager bm = new BoardManager(col, row, blankPosition);
        Player player = new Player(bm);

        bm.show();
        player.play();
    }
}
