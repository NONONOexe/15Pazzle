class BoardManagerTest
{
    public static final String description = "java BoardManager <col> <row>";

    public static void main(String args[])
    {
        if(args.length != 2)
        {
            System.err.println(description);
            return;
        }

        int col = Integer.parseInt(args[0]);
        int row = Integer.parseInt(args[1]);
        BoardManager bm = new BoardManager(col, row);

        System.out.println(bm);
    }
}
