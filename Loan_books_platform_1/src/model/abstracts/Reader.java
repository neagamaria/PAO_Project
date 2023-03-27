package model.abstracts;
public abstract class Reader
{
    private int readerID;
    private String name;
    static int count = 0;

    public Reader(String name)
    {
        this.readerID = ++count;
        this.name = name;
    }
    public abstract void logIn();

    public String getName()
    {
        return name;
    }
}
