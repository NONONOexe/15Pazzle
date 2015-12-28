public  class Number
{
    private int num;
    private GridPoint p;
    
    public Number(int num, int x, int y)
    {
        this(num, new GridPoint(x, y));
    }
    
    public Number(int num, GridPoint p)
    {
        this.num = num;
        this.p = p;
    }

    public int getNum()
    {
        return num;
    }

    public int getX()
    {
        return p.getX();
    }

    public int getY()
    {
        return p.getY();
    }

    public GridPoint getPoint()
    {
        return p;
    }

    @Override
    public String toString()
    {
        String str = String.format("num=%d, %s", num, p);

        return str;
    }
}
