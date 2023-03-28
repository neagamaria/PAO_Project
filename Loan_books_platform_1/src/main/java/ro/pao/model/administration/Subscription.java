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
public class Subscription
{
    private UUID subscriptionID;
    private double price;
    private int validity;

}
