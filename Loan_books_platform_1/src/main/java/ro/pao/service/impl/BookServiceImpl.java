package ro.pao.service.impl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import ro.pao.model.products.Book;
import ro.pao.service.BookService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter

public class BookServiceImpl implements BookService
{
    private static List<Book> bookList = new ArrayList<>();
    @Override
    public Optional<Book> getById(UUID id)
    {
        return bookList.stream().filter(obj -> id.equals(obj.getItemId())).findAny();
    }

    @Override
    public Optional<List<Book>> getByCategory(String category)
    {
        List<Book> list = bookList.stream().filter(book -> book.getCategory().equals(category)).collect(Collectors.toList());
        return Optional.ofNullable(list);
    }

    @Override
    public List<Book> getAll()
    {
        return bookList;
    }

    @Override
    public void addAll(List<Book> bookList)
    {
        BookServiceImpl.bookList.addAll(bookList);
    }

    @Override
    public void addOne(Book book)
    {
        bookList.add(book);
    }

    @Override
    public void removeById(UUID id)
    {
        bookList = bookList.stream().filter(element -> !id.equals(element.getItemId())).collect(Collectors.toList());
    }

    @Override
    public void modifyById(UUID id, Book newBook)
    {
        removeById(id);
        addOne(newBook);
    }


}
