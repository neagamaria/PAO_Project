package ro.pao.model.products;

public class Encyclopedia extends Book
{
    private String domain;
    public Encyclopedia(String title, String authors, String category, int year, String domain)
    {
        super(title, authors, category, year);
        this.domain = domain;
    }
    @Override
    public void addToCollection()
    {
        System.out.println("The encyclopedia " + this.getTitle() + " was added to the collection.");
    }
}
