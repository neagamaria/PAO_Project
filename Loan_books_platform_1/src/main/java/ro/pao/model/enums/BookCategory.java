package ro.pao.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
@Getter
@AllArgsConstructor
public enum BookCategory
{
    NONE("none"); // in cazul in care nu este niciun field
    private final String typeString;

    public static BookCategory getEnumByFieldString(String field)
    {
        return Arrays.stream(BookCategory.values())
                .filter(enumElement -> enumElement.getTypeString().equals(field))
                .findAny()
                .orElse(NONE); // in cazul in care nu este niciun field
    }
}
