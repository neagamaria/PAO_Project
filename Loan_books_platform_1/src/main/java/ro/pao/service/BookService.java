package ro.pao.service;

import ro.pao.model.products.Book;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface BookService
{
    Optional<Book> getById(UUID id);
    Optional<List<Book>> getByCategory(String category);
    Optional<List<Book>> getByTitle(String title);
    List<Book> getAll();
    void addAll(List<Book> bookList);
    void addOne(Book book);
    void removeById(UUID id);
    void modifyById(UUID id, Book newBook);
}
