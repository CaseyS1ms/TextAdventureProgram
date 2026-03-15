package Items;

public abstract class Item
{
    private String name;
    private int value;
    private String type;


    Item(String name, int value, String type)
    {
        this.name = name;
        this.value = value;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getValue() {
        return value;
    }
}
