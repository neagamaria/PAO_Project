package ro.pao.model.products;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
@SuperBuilder
@Getter
public class Encyclopedia extends Book
{
    private String domain;
    @Override
    public void addToCollection()
    {
        System.out.println("The encyclopedia " + this.getTitle() + " was added to the collection.");
    }

    @Override
    public void show()
    {
        super.show();
        System.out.print("Domain: " + this.domain + "\n\n");
    }
}
