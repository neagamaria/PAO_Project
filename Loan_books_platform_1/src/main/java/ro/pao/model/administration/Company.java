package ro.pao.model.administration;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import ro.pao.model.abstracts.Reader;

@SuperBuilder
@Getter
public class Company extends Reader {
    private String link;
    private int numberReaders;
    static int count = 0;
    @Override
    public void logIn() {
        System.out.println("Company " + this.getName() + " is logged in");
    }
    @Override
    public void show() {
        super.show();
        System.out.print(" Number readers: : " + this.numberReaders + " Link: " + this.link + "\n\n");
    }
}
