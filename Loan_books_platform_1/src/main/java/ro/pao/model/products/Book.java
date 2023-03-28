package ro.pao.model.products;
import ro.pao.model.abstracts.Item;
import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@AllArgsConstructor

public class Book extends Item
{
    private String publishing;
    private String category;
    private int publishing_year;
    @Override
    public void addToCollection()
    {
        System.out.println("The book " + this.getTitle() + " was added to the collection.");
    }
    public String getCategory()
    {
        return category;
    }
    public void setCategory(String category)
    {
        this.category = category;
    }

    public String getPublishing()
    {
        return publishing;
    }

    public void setPublishing(String publishing)
    {
        this.publishing = publishing;
    }

    public int getPublishing_year()
    {
        return publishing_year;
    }

    public void setPublishing_year(int publishing_year)
    {
        this.publishing_year = publishing_year;
    }
}
