package model.products;
public class Novel extends Book
{
    private int volume = 0; //number of volume 0 means the novel has no more other volumes
    private int number_chapters;

    public Novel(String title, String authors, String category, int year, int volume, int chapters)
    {
        super(title, authors, category, year);
        this.volume = volume;
        this.number_chapters = chapters;
    }
    //constructor for novel without multiple volumes
    public Novel(String title, String authors, String category, int year, int chapters)
    {
        super(title, authors, category, year);
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
