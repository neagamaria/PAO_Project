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
}