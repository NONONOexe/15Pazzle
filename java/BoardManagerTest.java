final class BoardManagerTest
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

        bm.show();
        System.out.println("====SwapTest====");
        System.out.printf("swap (0, 0) and (%d, %d)\n", col - 1, row - 1);
        bm.swap(0, 0, col - 1, row - 1);
        bm.show();
        System.out.printf("swap num 1 and num %d\n", col * row);
        bm.swap(1, col * row);
        bm.show();
        System.out.println("====MoveTest====");
        System.out.println("MoveUp");
        bm.moveUp();
        bm.show();
        System.out.println("MoveDown");
        bm.moveDown();
        bm.show();
        System.out.println("MoveLeft");
        bm.moveLeft();
        bm.show();
        System.out.println("MoveRight");
        bm.moveRight();
        bm.show();
    }
}
