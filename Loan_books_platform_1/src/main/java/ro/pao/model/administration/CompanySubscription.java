package ro.pao.model.administration;
public class CompanySubscription extends Subscription
{
    private double discount;
    private int number_people;

    public CompanySubscription(double price, int months, double discount, int people)
    {
        super(price, months);
        this.discount = discount;
        this.number_people = people;
    }
}
