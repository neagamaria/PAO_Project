package ro.pao.model.products;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder

public class Novel extends Book
{
    private int volume = 0; //number of volume 0 means the novel has no more other volumes
    private int number_chapters;

    //constructor for novel without multiple volumes
    public Novel(String publishing, String category, int publishing_year, int chapters)
    {
        super(publishing, category, publishing_year);
        this.number_chapters = chapters;
    }
    public void addVolumeToName()
    {
        if(this.volume != 0)
        {
            String volume = Integer.toString(this.volume);
            this.setTitle(volume);
        }
    }

    @Override
    public void addToCollection()
    {
        System.out.println("The novel " + this.getTitle() + " was added to the collection.");
    }
}
