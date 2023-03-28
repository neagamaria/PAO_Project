package ro.pao.model.abstracts;
import java.util.UUID;

public abstract class Reader
{
    private UUID readerID;
    private String name;
    static int number_readers = 0;

    public Reader(String name)
    {
        this.name = name;
    }
    public abstract void logIn();

    public String getName()
    {
        return name;
    }

    static
    {
        number_readers++;
    }
}
