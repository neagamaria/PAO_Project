package ro.pao.service.impl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import ro.pao.model.products.Book;
import ro.pao.repository.BookRepository;
import ro.pao.service.BookService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@NoArgsConstructor
@Getter
@RequiredArgsConstructor

public class BookServiceImpl implements BookService
{
    private BookRepository bookRepository;
    private static List<Book> bookList = new ArrayList<>();

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Optional<Book> getById(UUID id) {
       // return bookList.stream().filter(obj -> id.equals(obj.getItemId())).findAny();
        return bookRepository.getObjectById(id);
    }

    @Override
    public Optional<List<Book>> getByCategory(String category) {
        return bookRepository.getObjectByCategory(category);
    }
    @Override
    public Optional<List<Book>> getByTitle(String title) {
        return bookRepository.getObjectByTitle(title);
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.getAll();
    }

    @Override
    public void addAll(List<Book> bookList) {
       // BookServiceImpl.bookList.addAll(bookList);
        bookRepository.addAllFromGivenList(bookList);
    }

    @Override
    public void addOne(Book book) {
        //bookList.add(book);
        bookRepository.addNewObject(book);
    }

    @Override
    public void removeById(UUID id) {
        //bookList = bookList.stream().filter(element -> !id.equals(element.getItemId())).collect(Collectors.toList());
        bookRepository.deleteObjectById(id);
    }

    @Override
    public void modifyById(UUID id, Book newBook) {
        //removeById(id);
        //addOne(newBook);
        bookRepository.updateObjectById(id, newBook);
    }

}
