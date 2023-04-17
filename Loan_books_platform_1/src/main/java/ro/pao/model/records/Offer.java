package ro.pao.model.records;

import java.util.Date;
import java.util.UUID;
public record Offer(UUID offerId, Date startDate, Date endDate, double specialDiscount, String description) {
    public Offer(UUID offerId, Date startDate, Date endDate, double specialDiscount, String description) {
        this.offerId = offerId;
        this.startDate = startDate;
        this.description = description;

        if(endDate.before(startDate)) {
            endDate = new Date(startDate.getTime() + 86400000);
        }

        this.endDate = endDate;
        if(specialDiscount  < 10.0) {
            specialDiscount = 10.0; //minimum discount
        }
        this.specialDiscount = specialDiscount;
    }
}
