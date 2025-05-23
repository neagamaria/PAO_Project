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

public abstract class Item {
    private UUID itemId;
    private String title;
    private String authors;
    static int totalItems = 0;
    public abstract void addToCollection();

    static {
        totalItems++;
    }
    public void show() {

        System.out.print("Title: " + this.title + " Authors: " + this.authors);
    }
}
