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
import ro.pao.model.administration.Loan;
import ro.pao.model.abstracts.Item;
import ro.pao.model.products.Ebook;
import ro.pao.model.records.Offer;

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
    //function used to verify if a given category is in the book categories list
    public boolean isStringInEnum(String input)
    {
        try
        {
            BookCategory.valueOf(input);
            return true;
        }
        catch (IllegalArgumentException e)
        {
            return false;
        }
    }

    public void options()
    {
        String text = "Choose an action:\n1.Display all readers sorted by join_date\n" +
                "2.Display the new collection of books\n3.Open a new loan\n4.See the available offers";
        System.out.println(text);
    }
    public void intro()
    {
        this.options();
        Scanner sc1= new Scanner(System.in);
        int option = sc1.nextInt();

        //list of readers with upcasting
        //created for sorting
        List<Reader> platformReaders = new ArrayList<>();
        platformReaders.add(Person.builder()
                .readerID(UUID.randomUUID())
                .name("Popescu Ion")
                .join_date(new Date(2021, 7, 9)) // set join date to March 1st, 2022
                .age(25)
                .email("popescuion@gmail.com")
                .build());

        platformReaders.add(Person.builder()
                .readerID(UUID.randomUUID())
                .name("Georgescu Elena")
                .join_date(new Date(2022, 5, 7))
                .age(33)
                .email("elenag@yahoo.ro")
                .build());

        platformReaders.add(Person.builder()
                .readerID(UUID.randomUUID())
                .name("Ionescu Anca")
                .join_date(new Date(2022, 12, 22))
                .age(40)
                .email("ancaionescu@yahoo.com")
                .build());

        platformReaders.add(Company.builder()
                .readerID(UUID.randomUUID())
                .name("Vodafone")
                .join_date(new Date(2022, 2, 1))
                .number_readers(100)
                .link("www.vodafone.ro")
                .build());

        platformReaders.add(Company.builder()
                .readerID(UUID.randomUUID())
                .name("Revolut")
                .join_date(new Date(2023, 3, 4))
                .number_readers(50)
                .link("www.revolut.com")
                .build());

        platformReaders.add(Company.builder()
                .readerID(UUID.randomUUID())
                .name("eMag")
                .join_date(new Date(2022, 10, 11))
                .number_readers(50)
                .link("www.emag.ro")
                .build());


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


        if(option == 1)
        {
            Collections.sort(platformReaders, new Comparator<Reader>()
            {
                public int compare(Reader r1, Reader r2)
                {
                    if(r1.getJoin_date().before(r2.getJoin_date()))
                        return -1;
                    else if(r1.getJoin_date().after(r2.getJoin_date()))
                        return 1;
                    return 0;
                }
            });

            readerService.addAll(platformReaders);
            System.out.println("The list of logged readers sorted by join_date: ");
            readerService.getAll().forEach(elementFromList -> elementFromList.show());
        }

        else
        {
            if(option == 2)
            {
                bookService.addAll(newCollection); //action 1 : addAll
                System.out.println("\n\nThe new collection: ");
                bookService.getAll().forEach(elementFromList -> elementFromList.show()); //action 2: getAll

                //get all books from a given category
                System.out.println("\n\nCategory of books (to be removed): ");
                Scanner sc= new Scanner(System.in);
                String givenCategory= sc.nextLine();

                if(isStringInEnum(givenCategory.toUpperCase()))
                {
                    Optional <List<Book>> booksToRemove = bookService.getByCategory(givenCategory); //action 3: getByCategory
                    System.out.println("\n\nThe list of books from the given category (to be removed): ");

                    //remove from list of books
                    if(!booksToRemove.isEmpty())
                    {
                        List<Book> booksToRemoveList = booksToRemove.orElse(Collections.emptyList());
                        for(Book book : booksToRemoveList)
                        {
                            book.show();
                            bookService.removeById(book.getItemId()); //action 4: removeById
                        }
                        System.out.println("\nAfter removing all the books from the given category: ");

                        //show according to their original datatypes

                        bookService.getAll().forEach(elementFromList -> elementFromList.show());
                        }
                        else
                        {
                            System.out.println("There are no books from the given category\n\n");
                        }

                }
                else
                {
                    System.out.println("The category doesn't exist\n\n");
                }


                try
                {
                    System.out.println("\n\nTitle of book to be modified:\n");
                    String title = sc.nextLine();
                    Book bookToModify = bookService.getByTitle(title).get(); //action 5: getByTitle
                    bookToModify.setPublishing("No publishing");
                    bookService.modifyById(bookToModify.getItemId(), bookToModify); //action 6: modifyById
                    System.out.println("The list after the book with given title was modified:\n\n");
                    bookService.getAll().forEach(elementFromList -> elementFromList.show()); //action 7: getAll
                }
               catch(NoSuchElementException e)
               {
                   System.out.println("There is no such book\n\n");
               }


                System.out.println("\n\nAdd a new book from category HISTORY to collection:\nTitle:\n");
                String title = sc.nextLine();
                System.out.println("Authors:\n");
                String authors = sc.nextLine();
                Book bookToAdd = Book.builder()
                        .itemId(UUID.randomUUID())
                        .title(title)
                        .authors(authors)
                        .publishing("No publishing")
                        .category(BookCategory.HISTORY.getTypeString())
                        .publishing_year(2020)
                        .build();
                bookService.addOne(bookToAdd); //action 8: addOne
                System.out.println("The list with the added book:\n\n");
                bookService.getAll().forEach(elementFromList -> elementFromList.show());


            }
            else
                if(option == 3)
                {

                    try
                    {
                        readerService.addAll(platformReaders);
                        //open a new loan
                        Loan newLoan = Loan.builder()
                                .loanId(UUID.randomUUID())
                                .readerID((readerService.getByName("Ionescu Anca").get()).getReaderID()) //action 9: getByName
                                .items_list(new ArrayList<Item>())
                                .start_date(new Date())
                                .return_date(new Date(2023, 4, 30))
                                .extended(false)
                                .build();

                        Item newEbook = Ebook.builder()
                                .itemId(UUID.randomUUID())
                                .title("Ebook one")
                                .authors("James P.")
                                .format("pdf")
                                .size(100)
                                .build();
                        newLoan.addItems_List(newEbook);

                        Item newBook = Novel.builder()
                        .itemId(UUID.randomUUID())
                        .title("1984")
                        .authors("George Orwell")
                        .publishing("Penguin")
                        .category(BookCategory.DYSTOPIAN.getTypeString())
                        .publishing_year(2020)
                        .number_chapters(20)
                        .build();

                        newLoan.addItems_List(newBook); //action 10: addItems_list
                        newLoan.extendLoan(); //if it is extended, one month is added to return_date
                                                //action 11: extendLoan

                        System.out.println("The newly opened loan:\n\n" + newLoan);
                    }
                    catch(NoSuchElementException e)
                    {
                        System.out.println("Cannot open loan\n\n");
                    }
                }
                else
                {
                    if(option == 4)
                    {
                        Offer offer1 = new Offer(UUID.randomUUID(), new Date(2023, 4, 1), new Date(2023, 4, 12),
                                30, "Special extra discount of 30% for all companies!");
                        Offer offer2 = new Offer(UUID.randomUUID(), new Date(2023, 4, 2), new Date(2023, 4, 1),
                            0, "You loan 3 books from the same category, you have one extra book of your choice!");

                        System.out.println(offer1 + "\n" + offer2 + "\n\n");
                    }
                }
        }




    }
}
