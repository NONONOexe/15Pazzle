import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoardManager
{
    private int col;
    private int row;
    private int size;
    private List<Number> board;

    public static final int FREE = 0;
    public static final int LOWER_RIGHT = 1;

    public BoardManager(int col, int row)
    {
        this.col = col;
        this.row = row;
        this.size = row * col;
        this.board = new ArrayList<>(size);
        initialize();
    }

    public BoardManager(int col, int row, int brankPosition)
    {
        this(col, row);
        if(brankPosition == LOWER_RIGHT)
        {
            int brankIndex = indexOf(col * row);
            int rowerrightIndex = toLinear(col - 1, row - 1);
            swapIndex(brankIndex, rowerrightIndex);
            // DEBUG
            // System.out.println("brankIndex = " + brankIndex);
            // System.out.println("rowerrightIndex = " + rowerrightIndex);
        }
    }

    public void initialize()
    {
        List<Integer> numbers = new ArrayList<>(size);

        for(int num = 1; num <= size; num++)
        {
            numbers.add(num);
        }
        Collections.shuffle(numbers);
        for(int gridX = 0; gridX < col; gridX++)
        {
            for(int gridY = 0; gridY < row; gridY++)
            {
                int index = toLinear(gridX, gridY);
                int num = numbers.get(index);
                Number number = new Number(num, gridX, gridY);

                board.add(number);
            }
        }

    }

    private int toLinear(int x, int y)
    {
        return x * col + y;
    }

    @Override
    public String toString()
    {
        String output = "";

        for(int gridX = 0; gridX < col; gridX++)
        {
            for(int gridY = 0; gridY < row; gridY++)
            {
                int index = toLinear(gridX, gridY);
                int num = board.get(index).getNum();

                if(num != col * row)
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

    // public void swapElement(Number a, Number b)
    // {
    //     int indexA = board.indexOf(a);
    //     int indexB = board.indexOf(b);
    //
    //     a.setPoint(b.getPoint());
    //     b.setPoint(a.getPoint());
    //     board.set(indexA, b);
    //     board.set(indexB, a);
    // }

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

    // public void swap(int num1, int num2)
    // {
    //     int indexA = indexOf(num1);
    //     int indexB = indexOf(num2);
    //
    //     swapIndex(indexA, indexB);
    // }

    public void moveUp()
    {
        int brankIndex = indexOf(col * row);
        int lowerIndex = brankIndex + col;

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
        int brankIndex = indexOf(col * row);
        int upperIndex = brankIndex - col;

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
        int brankIndex = indexOf(col * row);
        int rightIndex = brankIndex + 1;

        if(rightIndex % col != 0)
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
        int brankIndex = indexOf(col * row);
        int leftIndex = brankIndex - 1;

        if((leftIndex + 1) % col != 0)
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
}
