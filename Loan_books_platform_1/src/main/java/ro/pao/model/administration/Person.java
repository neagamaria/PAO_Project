package ro.pao.model.administration;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import ro.pao.model.abstracts.Reader;

@SuperBuilder
@Getter
public class Person extends Reader
{
    private int age;
    private String email;
    @Override
    public void logIn()
    {
        System.out.println("Person " + this.getName() + " is logged in");
    }
}
