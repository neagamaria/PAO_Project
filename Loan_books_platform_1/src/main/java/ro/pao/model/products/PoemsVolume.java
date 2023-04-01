package ro.pao.model.products;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
@SuperBuilder
@Getter
public class PoemsVolume extends Book
{
    private final int number_poems;
    private String literary_current;
    @Override
    public void addToCollection()
    {
        System.out.println("The volume of poems " + this.getTitle() + " was added to the collection.");
    }

    @Override
    public void show()
    {
        super.show();
        System.out.print(" Number poems: " + this.number_poems + " Literary current: " + this.literary_current + "\n\n");
    }

}
