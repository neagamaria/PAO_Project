package model.administration;
public class Subscription
{
    private int subscriptionID;
    private double price;
    private int validity;
    static int count = 0;

    public Subscription(double price, int months)
    {
        this.subscriptionID = ++count;
        this.price = price;
        this.validity = months;
    }
}
