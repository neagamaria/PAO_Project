# PAO_Project

  This project named Loan_books_platform is based on the functionality of a platform for loaning items: books and ebooks. Both these categories have fileds and methods specific to the item category. There are some special types of books which have their particular fields, therefore we can separate from Book entity the following: Novel, PoemsVolume and Encyclopedia; the other types of books share the original particularities of Book entity.
  The readers that are logged in the platform can be either people or companies, for each category existing a subscription: the basic one for a person and the Company_Subscription for a company. What is more, there must be kept an evidence of the current loans in the platform, each loan belonging to a reader and having a collection of items assigned to it. Besides that, there are special offers available for a period of time that provide a discount for subscriptions and even certain facilities.
  
  ***Part I***
  
 **Implementation**

 Classes:
  Abstracts:
  - Item and Reader (there are no objects with only this class types, but they are used to be extended by subclasses)

  Enums:
  - BookCategory (the possible categories for a book)

  Records:
  - Offer (the fileds are validated inside the constructor)
  
  Products:
  - Book extends Item
      - Novel extends Book
      - PoemsVolume extends Book
      - Encyclopedia extends Book
   - Ebook extends Reader
   
  Administartion:
  - Person extends Reader
  - Company extends Reader
  - Subscription
      - CompanySubscription extends Subscription
  - Loan

Service classes: (interfaces, contain methods for manipulating lists of objects; to be implemented in the impl classes)
  - ReaderService
  - BookService
  - LoanService
  - SubscriptionService

Service-implement classes:
  - ReaderServiceImpl
  - BookServiceImpl
  - LoanServiceImpl
  - SubscriptionServiceImpl



The actions that are implemented and exemplified in the project:
1. Add all readers from a collection to the readerService object
2. Sort the list of platform readers (people and companies) 
3. Get a reader by its name
4. Add all books from a given list to bookService
5. Get all books from bookService
6. Get a book from bookService by id
7. Get all books from bookService that belong to a given category
8. Get the book from bookService that has a given title
9. Modify a book in bookService
10. Remove a book from bookService
11. Add a new book in bookService
12. Add items to a new loan


The options in the project:
1. See the list of readers and do actions with it
2. See the collection of books and do actions with it
3. See a newly created loan, extend it and add items to it
4. See the avalable offers (fields validated using Record class)

