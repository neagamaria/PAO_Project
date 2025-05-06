package ro.pao.model.administration;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
@EqualsAndHashCode
public sealed class Subscription permits CompanySubscription{
    private UUID subscriptionID;
    private double price;
    private int validity;

}
