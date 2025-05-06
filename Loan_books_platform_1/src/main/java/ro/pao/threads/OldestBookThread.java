package ro.pao.threads;

import lombok.AllArgsConstructor;
import ro.pao.application.csv.CsvReader;
import ro.pao.model.products.Book;

import java.util.List;
import java.util.logging.Logger;

@AllArgsConstructor
public class OldestBookThread implements Runnable {

    private List<Book> bookList;
    private Book oldestBook;
    private static final CsvReader csvReader = CsvReader.getInstance();

    private static final Logger logger = Logger.getGlobal();

    public Book findOldestBook(List<Book> bookList){
        for(Book book : bookList) {
            if(book.getPublishingYear() <= oldestBook.getPublishingYear())
                oldestBook = book;
        }
        return oldestBook;
    }


    @Override
    public void run() {
        findOldestBook(bookList);
       System.out.println("(Thread OldestBookThread) The oldest book in the collection: " + oldestBook.getTitle() + " published in: " + oldestBook.getPublishingYear() + "\n");
    }
}
