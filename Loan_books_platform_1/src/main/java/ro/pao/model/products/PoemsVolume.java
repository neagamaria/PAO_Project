package ro.pao.model.products;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
@SuperBuilder
@Getter
public non-sealed class PoemsVolume extends Book {
    private final int numberPoems;
    private String literaryCurrent;
    @Override
    public void addToCollection() {
        System.out.println("The volume of poems " + this.getTitle() + " was added to the collection.");
    }

    @Override
    public void show() {
        super.show();
        System.out.print(" Number poems: " + this.numberPoems + " Literary current: " + this.literaryCurrent + "\n\n");
    }

}
