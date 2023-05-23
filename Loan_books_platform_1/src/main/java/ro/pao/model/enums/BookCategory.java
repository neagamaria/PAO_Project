package ro.pao.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
@Getter
@AllArgsConstructor

public enum BookCategory {
    //fiction
    CLASSICS("classics"),
    FANTASY("fantasy"),
    SF("sf"),
    ROMANCE("romance"),
    ADVENTURE("adventure"),
    DYSTOPIAN("dystopian"),
    HORROR("horror"),
    HISTORICAL_FICTION("historical fiction"),

    //nonfiction
    BIOGRAPHY("biography"),
    POLITICS("politics"),
    SCIENCES("sciences"),
    HISTORY("history"),
    PSYCHOLOGY("psychology"),
    NONE("none"); // in cazul in care nu este niciun field
    private final String typeString;

    public static BookCategory getEnumByFieldString(String field){
        return Arrays.stream(BookCategory.values())
                .filter(enumElement -> enumElement.getTypeString().equals(field))
                .findAny()
                .orElse(NONE); // in cazul in care nu este niciun field
    }
}
