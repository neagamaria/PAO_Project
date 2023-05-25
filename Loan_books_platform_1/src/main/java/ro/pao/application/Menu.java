package ro.pao.application;

import ro.pao.model.enums.BookCategory;
import ro.pao.model.products.Book;
import ro.pao.model.products.Encyclopedia;
import ro.pao.model.products.Novel;
import ro.pao.model.products.PoemsVolume;
import ro.pao.repository.impl.BookRepositoryImpl;
import ro.pao.service.BookService;
import ro.pao.service.ReaderService;
import ro.pao.service.impl.BookServiceImpl;
import ro.pao.service.impl.ReaderServiceImpl;

import java.util.*;

public class Menu {
    private static Menu INSTANCE;
    private final ReaderService readerService = new ReaderServiceImpl();
    private final BookService bookService = new BookServiceImpl(new BookRepositoryImpl());

    public static Menu getInstance() {
        return (INSTANCE == null ? new Menu() : INSTANCE);
    }

    private Menu() {
    }

    //function used to verify if a given category is in the book categories list
    public boolean isStringInEnum(String input) {
        try {
            BookCategory.valueOf(input);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }


    public void intro() {

        List<Book> newCollection = List.of(
                Novel.builder()
                        .itemId(UUID.randomUUID())
                        .title("Wuthering Heights")
                        .publishing("Collins Classics")
                        .publishingYear(2010)
                        .category(BookCategory.CLASSICS.getTypeString())
                        .build(),

                Encyclopedia.builder()
                        .itemId(UUID.randomUUID())
                        .title("Planets")
                        .publishing("Britannica")
                        .publishingYear(2003)
                        .category(BookCategory.SCIENCES.getTypeString())
                        .build(),

                Novel.builder()
                        .itemId(UUID.randomUUID())
                        .title("The pillars of the earth")
                        .publishing("Art")
                        .publishingYear(1847)
                        .category(BookCategory.HISTORICAL_FICTION.getTypeString())
                        .build(),

                PoemsVolume.builder()
                        .itemId(UUID.randomUUID())
                        .title("Essential poems of E. A. Poe")
                        .publishing("Chartwell Classics")
                        .publishingYear(2015)
                        .category(BookCategory.CLASSICS.getTypeString())
                        .build(),

                PoemsVolume.builder()
                        .itemId(UUID.randomUUID())
                        .title("The collected poems")
                        .publishing("The sign")
                        .publishingYear(2017)
                        .category(BookCategory.ROMANCE.getTypeString())
                        .build(),

                Book.builder()
                        .itemId(UUID.randomUUID())
                        .title("The comfort book")
                        .publishing("Sunday Times")
                        .publishingYear(2021)
                        .category(BookCategory.PSYCHOLOGY.getTypeString())
                        .build(),

                Novel.builder()
                        .itemId(UUID.randomUUID())
                        .title("The bastard of Istanbul")
                        .publishing("Penguin")
                        .publishingYear(2006)
                        .category(BookCategory.HISTORICAL_FICTION.getTypeString())
                        .build(),

                Book.builder()
                        .itemId(UUID.randomUUID())
                        .title("Winston Churchill")
                        .publishing("DK")
                        .publishingYear(2011)
                        .category(BookCategory.BIOGRAPHY.getTypeString())
                        .build());

        bookService.addAll(newCollection);

        if(bookService.getAll() == null) {
            bookService.addAll(newCollection);
        }
        else {
            System.out.println(bookService.getByTitle("The bastard of Istanbul"));
        }

        System.out.println("Search all books from category: ");
        Scanner in = new Scanner(System.in);
        String category = in.nextLine();

        if(isStringInEnum(category.toUpperCase())) {
            Optional <List<Book>> booksInCategory = bookService.getByCategory(category);
            System.out.println("\n\nThe list of books from the given category: " + bookService.getAll().size());

            if(!booksInCategory.isEmpty()){
                List<Book> booksInCategoryList = booksInCategory.orElse(Collections.emptyList());
                Iterator<Book> itr = booksInCategoryList.iterator();

                while(itr.hasNext()) {
                    Book currentBook = itr.next();
                    System.out.println(currentBook.getTitle());
                    //currentBook.show();
                }
            }
            else {
                System.out.println("There are no books in the given category");
            }
        }
    }
}
