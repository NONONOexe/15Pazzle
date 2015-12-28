public class GridPoint
{
    private int x;
    private int y;

    public GridPoint(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    @Override
    public String toString()
    {
        String str = String.format("x=%d, y=%d", x, y);

        return str;
    }
}
