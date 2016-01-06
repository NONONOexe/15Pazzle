class Puzzle
{
    public static final String description
        = "java Puzzle [Options..] <Enter>\n"
        + "Options\n"
        + "-c [Integer] - Column number of board. Default is 4.\n"
        + "-r [Integer] - Lows of board. Default is 4.\n"
        + "-b [Integer] - You can select free(0) or lower right(1). Default is 1.\n"
        + "-g : Play the Puzzle on GUI\n"
        + "-h : Display this description";

    public static void main(String[] args)
    {
        int cols = 4;
        int rows = 4;
        int blankPosition = 1;
        boolean isPlayGUI = false;
        BoardManager bm = null;
        Player player = null;
        PuzzleGUI gui = null;
        for(int i = 0; i < args.length; i++)
        {
            String arg = args[i];
            if(arg.startsWith("-"))
            {
                if(arg.equals("-c"))
                {
                    i++;
                    cols = Integer.parseInt(args[i]);
                }
                if(arg.equals("-r"))
                {
                    i++;
                    rows = Integer.parseInt(args[i]);
                }
                if(arg.equals("-b"))
                {
                    i++;
                    blankPosition = Integer.parseInt(args[i]);
                }
                if(arg.equals("-g"))
                {
                    isPlayGUI = true;
                }
                if(arg.equals("-h"))
                {
                    System.out.println(description);
                    System.exit(0);
                }
            }
        }
        bm = new BoardManager(cols, rows, blankPosition);
        player = new Player(bm);
        if(isPlayGUI)
        {
            gui = new PuzzleGUI(bm);
            player.playOnGUI(gui);
        }
        else
        {
            player.play();
        }
    }
}
