package ro.pao.model.abstracts;

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

public abstract class Reader
{
    private UUID readerID;
    private String name;
    static int number_readers = 0;
    public abstract void logIn();

    static
    {
        number_readers++;
    }
}
