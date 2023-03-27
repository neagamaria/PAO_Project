package model.products;
public class PoemsVolume extends Book
{
    private final int number_poems;
    private String literary_current;

    public PoemsVolume(String title, String authors, String category, int year, int number, String current)
    {
        super(title, authors, category, year);
        this.number_poems = number;
        this.literary_current = current;
    }

    @Override
    public void addToCollection()
    {
        System.out.println("The volume of poems " + this.getTitle() + " was added to the collection.");
    }
}
