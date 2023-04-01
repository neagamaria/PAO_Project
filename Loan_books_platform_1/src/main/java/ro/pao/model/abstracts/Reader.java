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
    private Date join_date;
    public abstract void logIn();

    public void show()
    {
        System.out.print("Name: " + this.name + " Join date: " + this.join_date);
    }
}
