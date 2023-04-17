package ro.pao.model.administration;

import lombok.*;
import lombok.experimental.SuperBuilder;
@Getter
@Setter
@SuperBuilder

public class CompanySubscription extends Subscription {
    private double discount;
    private int numberPeople;
}
