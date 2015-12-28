import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoardManager
{
    private int col;
    private int row;
    private int size;
    private List<Number> board;
    
    public BoardManager(int col, int row)
    {
        this.col = col;
        this.row = row;
        this.size = row * col;
        this.board = new ArrayList<>(size);

        initialize();
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
