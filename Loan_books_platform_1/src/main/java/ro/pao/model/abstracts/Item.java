package ro.pao.model.abstracts;
import java.util.UUID;
public abstract class Item
{
    private UUID itemId;
    private String title;
    private String authors;
    private int number_copies;
    static int total_items = 0;

    public Item(String title, String authors)
    {
        this.title = title;
        this.authors = authors;
    }
    static
    {
        total_items++;
    }

    public abstract void addToCollection();

    public UUID getItemId()
    {
        return itemId;
    }

    public String getTitle()
    {
        return this.title;
    }
    public void setTitle(String s)
    {
        this.title += s;
    }
    public String getAuthors()
    {
        return this.authors;
    }

    public void setAuthors(String authors)
    {
        this.authors = authors;
    }

    public int getNumber_copies()
    {
        return number_copies;
    }

    public void setNumber_copies(int number_copies)
    {
        this.number_copies = number_copies;
    }
}
