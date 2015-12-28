import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoardManager
{
    private int row;
    private int col;
    private int size;
    private List<Number> board;
    
    public BoardManager(int row, int col)
    {
        this.row = row;
        this.col = col;
        this.size = row * col;
        this.board = new ArrayList<Number>(size);
    }

    public void initialize()
    {
        List<Integer> numbers = new ArrayList<Integer>(size);
        
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

    public int toLinear(int x, int y)
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
              
                output += String.format("%3d", num);
            }
            output += "\n";
        }

        return output;
    }

    public void show()
    {
        System.out.println(this);
    }
}
