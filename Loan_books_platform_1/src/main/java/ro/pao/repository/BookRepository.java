package ro.pao.repository;

import ro.pao.model.products.Book;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookRepository {

    Optional<Book> getObjectById(UUID id);

    void deleteObjectById(UUID id);

    void updateObjectById(UUID id, Book newObject);

    void addNewObject(Book exampleClass);

    List<Book> getAll();

    void addAllFromGivenList(List<Book> bookList);
}
