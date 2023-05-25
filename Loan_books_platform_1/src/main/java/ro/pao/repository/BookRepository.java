package ro.pao.repository;

import ro.pao.model.products.Book;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookRepository {

    Optional<Book> getObjectById(UUID id);

    Optional<List<Book>> getObjectByCategory(String category);

    Optional<List<Book>> getObjectByTitle(String title);

    void deleteObjectById(UUID id);

    void updateObjectById(UUID id, Book newBook);

    void addNewObject(Book book);

    List<Book> getAll();

    void addAllFromGivenList(List<Book> bookList);
}
