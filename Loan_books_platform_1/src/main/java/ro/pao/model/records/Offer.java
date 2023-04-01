package ro.pao.model.records;

import java.util.Date;
import java.util.UUID;
public record Offer(UUID offerId, Date start_date, Date end_date, double special_discount, String description)
{
    public Offer(UUID offerId, Date start_date, Date end_date, double special_discount, String description)
    {
        this.offerId = offerId;
        this.start_date = start_date;
        this.description = description;

        if(end_date.before(start_date))
        {
            end_date = new Date(start_date.getTime() + 86400000);
        }

        this.end_date = end_date;
        if(special_discount  < 10.0)
        {
            special_discount = 10.0; //minimum discount
        }
        this.special_discount = special_discount;
    }

}
