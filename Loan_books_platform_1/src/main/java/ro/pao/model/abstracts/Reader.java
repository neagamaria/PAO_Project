package ro.pao.model.abstracts;

import lombok.*;
import lombok.experimental.SuperBuilder;
import java.util.UUID;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
@EqualsAndHashCode

public abstract class Reader
{
    private UUID readerID;
    private String name;
    private Date joinDate;
    public abstract void logIn();
}
