package ro.pao.mapper;

import ro.pao.model.products.Book;
import ro.pao.model.enums.BookCategory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class BookMapper {

    private static final BookMapper INSTANCE = new BookMapper();

    private BookMapper() {
    }

    public static BookMapper getInstance() {
        return INSTANCE;
    }


    public Optional<Book> mapToBook(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return Optional.of(
                    Book.builder()
                            .itemId(UUID.fromString(resultSet.getString(1)))
                            .title(resultSet.getString(2))
                            .publishing(resultSet.getString(3))
                            .publishingYear(resultSet.getInt(4))
                            .category(BookCategory.valueOf(resultSet.getString(5)).getTypeString())
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    public List<Book> mapToBookList(ResultSet resultSet) throws SQLException {
        List<Book> BookList = new ArrayList<>();
        while (resultSet.next()) {
            BookList.add(
                    Book.builder()
                            .itemId(UUID.fromString(resultSet.getString(1)))
                            .title(resultSet.getString(2))
                            .publishing(resultSet.getString(3))
                            .publishingYear(resultSet.getInt(4))
                            .category(BookCategory.valueOf(resultSet.getString(5)).getTypeString())
                            .build()
            );
        }

        return BookList;
    }
}
