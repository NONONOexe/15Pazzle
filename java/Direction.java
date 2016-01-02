import java.util.HashMap;

public abstract class Direction
{
    private static HashMap<String, String> aliasMap;
    private static HashMap<String, Direction> directionMap;
    private String name;

    private static final void initializeAliasMap()
    {
        aliasMap = new HashMap<>();
        aliasMap.put("w", "UP");
        aliasMap.put("s", "DOWN");
        aliasMap.put("a", "LEFT");
        aliasMap.put("d", "RIGHT");
        aliasMap.put("UP", "UP");
        aliasMap.put("DOWN", "DOWN");
        aliasMap.put("LEFT", "LEFT");
        aliasMap.put("RIGHT", "RIGHT");
    }

    private static final void initializeDirectionMap()
    {
        directionMap = new HashMap<>();
        directionMap.put("UP", new Up());
        directionMap.put("DOWN", new Down());
        directionMap.put("LEFT", new Left());
        directionMap.put("RIGHT", new Right());
    }

    public static final Direction getDirection(String input)
    {
        if(aliasMap == null)
        {
            initializeAliasMap();
        }
        if(directionMap == null)
        {
            initializeDirectionMap();
        }

        return directionMap.get(aliasMap.get(input));
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
