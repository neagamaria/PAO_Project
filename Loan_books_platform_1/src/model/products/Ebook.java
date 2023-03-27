package model.products;
import model.abstracts.Item;

public class Ebook extends Item
{
    private int size;
    private String format;

    public Ebook(String title, String authors, int size, String format)
    {
        super(title, authors);
        this.size = size;
        this.format = format;
    }

    @Override
    public void addToCollection()
    {
        System.out.println("The ebook " + this.getTitle() + " was added to the collection.");
    }
}
