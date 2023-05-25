package ro.pao.model.administration;

import lombok.*;
import lombok.experimental.SuperBuilder;
@Getter
@Setter
@SuperBuilder

public non-sealed class CompanySubscription extends Subscription {
    private double discount;
    private int numberPeople;
}
