package ro.pao.model.administration;
import java.util.UUID;
public class Subscription
{
    private UUID subscriptionID;
    private double price;
    private int validity;

    public Subscription(double price, int months)
    {
        this.price = price;
        this.validity = months;
    }
}
