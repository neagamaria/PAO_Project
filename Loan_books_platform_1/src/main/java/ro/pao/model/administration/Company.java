package ro.pao.model.administration;
import model.abstracts.Reader;
public class Company extends Reader
{
    private String link;
    private int number_employees;
    static int count = 0;
    public Company(String name, int number)
    {
        super(name);
        this.link = link;
        this.number_employees = number;
    }
    @Override
    public void logIn()
    {
        System.out.println("Company " + this.getName() + " is logged in");
    }
}
