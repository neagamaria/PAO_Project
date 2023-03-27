package model.administration;
import model.abstracts.Reader;
public class Person extends Reader
{
    private int age;
    private String email;

    public Person(String name)
    {
        super(name);
        this.age = age;
        this.email = email;
    }

    @Override
    public void logIn()
    {
        System.out.println("Person " + this.getName() + " is logged in");
    }
}
