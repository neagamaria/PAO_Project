# PAO_Project

  This project named Loan_books_platform is based on the functionality of a platform for loaning items: books and ebooks. Both these categories have fileds and methods specific to the item category. There are some special types of books which have their particular fields, therefore we can separate from Book entity the following: Novel, PoemsVolume and Encyclopedia; the other types of books share the original particularities of Book entity.
  The readers that are logged in the platform can be either people or companies, for each category existing a subscription: the basic one for a person and the Company_Subscription for a company. What is more, there must be kept an evidence of the current loans in the platform, each loan belonging to a reader and having a collection of items assigned to it. Besides that, there are special offers available for a period of time that provide a discount for subscriptions and even certain facilities.
  
  ***Part II***
  
  **Database**
 I created the DataBase tables corresponding to the java Classes: BOOK, NOVEL, POEMSVOLUME, ENCYCLOPEDIA, EBOOK, PERSON, COMPANY, SUBSCRIPTION, COMPANY_SUBSCRIPTION, LOAN, LOAN_ITEM (to fix the many-to-many relationship between Item and Loan). 
  The CRUD operations for the tables are located in the RepositoryImpl classes, that implement the functions mentioned in Repository interfaces.
 The Mapping classes that correspond to each RepositoryImpl class create the mappation to the real database info.
 
 **Sealed Classes**
 I updated the Book and Subscription Java classes by mentioning the sub-classes that can inherit them, therefore I made them sealed.
 
 **Iterator**
 It is used to go through the elements stored in the instance of BookService declared in the Menu.
 
 **Operations**
 I created a list of books and saved it in the Database in order to be able to select all the books from the model that are included in a given category.
 

