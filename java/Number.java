public  class Number
{
    private int num;
    private int gridX;
    private int gridY;
    
    public Number(int num, int gridX, int gridY)
    {
        this.num = num;
        this.gridX = gridX;
        this.gridY = gridY;
    }

    public int getNum()
    {
        return num;
    }

    public int getGridX()
    {
        return gridX;
    }

    public int getGridY()
    {
        return gridY;
    }
}
