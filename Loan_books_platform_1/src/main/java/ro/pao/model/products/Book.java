package ro.pao.model.products;
import ro.pao.model.abstracts.Item;
import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@AllArgsConstructor

public class Book extends Item {
    private String publishing;
    private String category;
    private int publishingYear;
    @Override
    public void addToCollection() {
        System.out.println("The book " + this.getTitle() + " was added to the collection.");
    }

    @Override
    public void show() {
        super.show();
        System.out.print(" Category: " + this.category + " Publishing: " + this.publishing + ", " + this.publishingYear + "\n");
    }
}
