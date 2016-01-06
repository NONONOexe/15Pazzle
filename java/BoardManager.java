import java.util.ArrayList;
import java.util.Collections;

public class BoardManager
{
    private int cols;
    private int rows;
    private int size;
    private ArrayList<Number> board;

    public static final int FREE = 0;
    public static final int LOWER_RIGHT = 1;

    public BoardManager(int cols, int rows)
    {
        this.cols = cols;
        this.rows = rows;
        this.size = rows * cols;
        this.board = new ArrayList<>(size);
        initialize();
    }

    public BoardManager(int cols, int rows, int brankPosition)
    {
        this(cols, rows);
        if(brankPosition == LOWER_RIGHT)
        {
            int brankIndex = indexOf(size);
            int rowerrightIndex = toLinear(cols - 1, rows - 1);
            swapIndex(brankIndex, rowerrightIndex);
        }
    }

    public void initialize()
    {
        ArrayList<Integer> numbers = new ArrayList<>(size);
        for(int num = 1; num <= size; num++)
        {
            numbers.add(num);
        }
        Collections.shuffle(numbers);
        for(int row = 0; row < rows; row++)
        {
            for(int col = 0; col < cols; col++)
            {
                int index = toLinear(col, row);
                int num = numbers.get(index);
                Number number = new Number(num, col, row);
                board.add(number);
            }
        }
    }

    public int toLinear(int col, int row)
    {
        return row * cols + col;
    }

    @Override
    public String toString()
    {
        String output = "";
        for(int row = 0; row < rows; row++)
        {
            for(int col = 0; col < cols; col++)
            {
                int index = toLinear(col, row);
                int num = board.get(index).getNum();
                if(num != size)
                    output += String.format("%3d", num);
                else
                    output += "   ";
            }
            output += "\n";
        }
        return output;
    }

    public void show()
    {
        System.out.print(this);
    }

    public int indexOf(int num)
    {
        for(Number number : board)
        {
            if(number.getNum() == num)
                return board.indexOf(number);
        }
        return -1;
    }

    public void swapIndex(int indexA, int indexB)
    {
        Number a = board.get(indexA);
        Number b = board.get(indexB);
        a.setPoint(b.getPoint());
        b.setPoint(a.getPoint());
        board.set(indexA, b);
        board.set(indexB, a);
    }

    public void swap(GridPoint a, GridPoint b)
    {
        int indexA = toLinear(a.getX(), a.getY());
        int indexB = toLinear(b.getX(), b.getY());
        swapIndex(indexA, indexB);
    }

    public void swap(int x1, int y1, int x2, int y2)
    {
        swap(new GridPoint(x1, y1), new GridPoint(x2, y2));
    }

    public void moveUp()
    {
        int brankIndex = indexOf(size);
        int lowerIndex = brankIndex + cols;
        if(lowerIndex < board.size())
        {
            swapIndex(brankIndex, lowerIndex);
        }
        else
        {
            System.out.println("Can't move up!");
        }
    }

    public void moveDown()
    {
        int brankIndex = indexOf(size);
        int upperIndex = brankIndex - cols;
        if(-1 <upperIndex)
        {
            swapIndex(brankIndex, upperIndex);
        }
        else
        {
            System.out.println("Can't move down!");
        }
    }

    public void moveLeft()
    {
        int brankIndex = indexOf(size);
        int rightIndex = brankIndex + 1;
        if(rightIndex % cols != 0)
        {
            swapIndex(brankIndex, rightIndex);
        }
        else
        {
            System.out.println("Can't move left!");
        }
    }
    public void moveRight()
    {
        int brankIndex = indexOf(size);
        int leftIndex = brankIndex - 1;
        if((leftIndex + 1) % cols != 0)
        {
            swapIndex(brankIndex, leftIndex);
        }
        else
        {
            System.out.println("Can't move right!");
        }
    }

    public void move(Direction d)
    {
        if(d == null)
            return;
        if(d.getName().equals("UP"))
        {
            moveUp();
        }
        if(d.getName().equals("DOWN"))
        {
            moveDown();
        }
        if(d.getName().equals("LEFT"))
        {
            moveLeft();
        }
        if(d.getName().equals("RIGHT"))
        {
            moveRight();
        }
    }

    public boolean isGameOver()
    {
        for(Number number : board)
        {
            if(number.getNum() - 1 != board.indexOf(number))
                return false;
        }
        return true;
    }

    public int getCols()
    {
        return cols;
    }

    public int getRows()
    {
        return rows;
    }

    public int getSize()
    {
        return size;
    }

    public ArrayList<Number> getBoard()
    {
        return board;
    }
}
