package ro.pao.model.products;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import ro.pao.model.abstracts.Item;
@SuperBuilder
@Getter
public class Ebook extends Item {
    private int size;
    private String format;

    @Override
    public void addToCollection() {
        System.out.println("The ebook " + this.getTitle() + " was added to the collection.");
    }

    @Override
    public void show() {
        super.show();
        System.out.print(" Size: " + this.size + " Format: " + this.format);
    }
}
