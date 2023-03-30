package ro.pao.application;

import ro.pao.model.abstracts.Reader;
import ro.pao.model.administration.Company;
import ro.pao.model.administration.Person;
import ro.pao.model.enums.BookCategory;
import ro.pao.model.products.Book;
import ro.pao.model.products.Encyclopedia;
import ro.pao.model.products.Novel;
import ro.pao.model.products.PoemsVolume;
import ro.pao.service.BookService;
import ro.pao.service.ReaderService;
import ro.pao.service.impl.BookServiceImpl;
import ro.pao.service.impl.ReaderServiceImpl;

import java.util.*;
public class Menu
{
    private static Menu INSTANCE;
    private final ReaderService readerService = new ReaderServiceImpl();
    private final BookService bookService = new BookServiceImpl();

    public static Menu getInstance()
    {
        return (INSTANCE == null ? new Menu() : INSTANCE);
    }

    private Menu()
    {
    }

    public void intro()
    {
        String intro = """
                Intro example
                """;

        System.out.println(intro);

        //list of readers with upcasting
        //created for sorting

        List<Reader> platformReaders = new ArrayList<>();
        platformReaders.add(Person.builder()
                .readerID(UUID.randomUUID())
                .name("Popescu Ion")
                .joinDate(new Date(2021, 7, 9)) // set join date to March 1st, 2022
                .age(25)
                .email("popescuion@gmail.com")
                .build());

        platformReaders.add(Person.builder()
                .readerID(UUID.randomUUID())
                .name("Georgescu Elena")
                .joinDate(new Date(2022, 5, 7)) // set join date to March 1st, 2022
                .age(33)
                .email("elenag@yahoo.ro")
                .build());

        platformReaders.add(Person.builder()
                .readerID(UUID.randomUUID())
                .name("Ionescu Anca")
                .joinDate(new Date(2022, 12, 22)) // set join date to March 1st, 2022
                .age(40)
                .email("ancaionescu@yahoo.com")
                .build());

        platformReaders.add(Company.builder()
                .readerID(UUID.randomUUID())
                .name("Vodafone")
                .joinDate(new Date(2022, 2, 1)) // set join date to March 1st, 2022
                .number_readers(100)
                .link("www.vodafone.ro")
                .build());

        platformReaders.add(Company.builder()
                .readerID(UUID.randomUUID())
                .name("Revolut")
                .joinDate(new Date(2023, 3, 4)) // set join date to March 1st, 2022
                .number_readers(50)
                .link("www.revolut.com")
                .build());

        platformReaders.add(Company.builder()
                .readerID(UUID.randomUUID())
                .name("eMag")
                .joinDate(new Date(2022, 10, 11)) // set join date to March 1st, 2022
                .number_readers(50)
                .link("www.emag.ro")
                .build());

        Collections.sort(platformReaders, new Comparator<Reader>(){
            public int compare(Reader r1, Reader r2)
            {
                if(r1.getJoinDate().before(r2.getJoinDate()))
                    return -1;
                else if(r1.getJoinDate().after(r2.getJoinDate()))
                        return 1;
                return 0;
            }
        });

        readerService.addAll(platformReaders);
        System.out.println("The list of logged readers sorted by join_date: ");
        readerService.getAll().forEach(elementFromList -> System.out.println(elementFromList));

        //list of Books with upcasting
        List<Book> newCollection = List.of(
                Novel.builder()
                        .itemId(UUID.randomUUID())
                        .title("Wuthering Heights")
                        .authors("Emily Bronte")
                        .publishing("Collins Classics")
                        .category(BookCategory.CLASSICS.getTypeString())
                        .publishing_year(2010)
                        .number_chapters(34)
                        .volume(2)
                        .build(),

                Encyclopedia.builder()
                        .itemId(UUID.randomUUID())
                        .title("Planets")
                        .authors("Sam J., Thomas Q.")
                        .publishing("Britannica")
                        .category(BookCategory.SCIENCES.getTypeString())
                        .publishing_year(2003)
                        .domain("Our solar system")
                        .build(),

                Novel.builder()
                        .itemId(UUID.randomUUID())
                        .title("The pillars of the earth")
                        .authors("Ken Follet")
                        .publishing("Art")
                        .category(BookCategory.HISTORICAL_FICTION.getTypeString())
                        .publishing_year(1847)
                        .number_chapters(25)
                        .build(),

                PoemsVolume.builder()
                        .itemId(UUID.randomUUID())
                        .title("Essential poems of E. A. Poe")
                        .authors("Edgar Allan Poe")
                        .publishing("Chartwell Classics")
                        .category(BookCategory.CLASSICS.getTypeString())
                        .publishing_year(2015)
                        .literary_current("Sybolism")
                        .number_poems(15)
                        .build(),

                PoemsVolume.builder()
                        .itemId(UUID.randomUUID())
                        .title("The collected poems")
                        .authors("Robert Frost")
                        .publishing("The sign")
                        .category(BookCategory.ROMANCE.getTypeString())
                        .publishing_year(2017)
                        .literary_current("Modernism")
                        .number_poems(30)
                        .build(),

                Book.builder()
                        .itemId(UUID.randomUUID())
                        .title("The comfort book")
                        .authors("Matt Haig")
                        .publishing("Sunday Times")
                        .category(BookCategory.PSYCHOLOGY.getTypeString())
                        .publishing_year(2021)
                        .build(),

                Novel.builder()
                        .itemId(UUID.randomUUID())
                        .title("The bastard of Istanbul")
                        .authors("Elif Shafak")
                        .publishing("Penguin")
                        .category(BookCategory.HISTORICAL_FICTION.getTypeString())
                        .publishing_year(2006)
                        .number_chapters(18)
                        .build(),

                Book.builder()
                        .itemId(UUID.randomUUID())
                        .title("Winston Churchill")
                        .authors("James G. Humes")
                        .publishing("DK")
                        .category(BookCategory.BIOGRAPHY.getTypeString())
                        .publishing_year(2011)
                        .build());


        bookService.addAll(newCollection);
        System.out.println("\n\nThe new collection: ");
        bookService.getAll().forEach(elementFromList -> System.out.println(elementFromList));

        //get all books from a given category
        Optional <List<Book>> booksToRemove = bookService.getByCategory("psychology");
        System.out.println("\n\nThe list of books from the given category (to be removed): ");

        //remove from list of books
        if(!booksToRemove.isEmpty())
        {
            List<Book> booksToRemoveList = booksToRemove.orElse(Collections.emptyList());
            for(Book book : booksToRemoveList)
            {
                System.out.println(book + "\n");
                bookService.removeById(book.getItemId());
            }
        }
        else
        {
            System.out.println("There are no books from the given category\n\n");
        }

        System.out.println("\nAfter removing all the books from the PSYCHOLOGY category: ");
        bookService.getAll().forEach(elementFromList -> System.out.println(elementFromList));
    }
}
