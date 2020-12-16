package LibraryManagementSystem;

import java.util.*;

class Library {
    String name;
    List<BookItem> bookItems;
    Address location;
}

class Address {
    String no;
    String street;
    String state;
    String country;
    String pinCode;
}

class Book {
    String bookName;
    List<Author>;
    String ISBN;
    BookType type;
}

class BookItem extends Book {
    Rack rack;
    BookStatus status;
    BookFormat format;
    Date issueDate;
    Date publicationDate;
    String barCode;
}

enum BookType {
    ROMANTIC,
    FICTIONAL
}

enum BookFormat {
    HARDCOVER,
    EBOOK,
    ARTICLE
}

enum BookStatus {
    ISSUED,
    NOTISSUED,
    RESERVED,
    NOTAVAILABLE,
}

class Rack {
    int row;
    int col;
}

class Person {
    String firstName;
    String lastName;
}

class Author extends Person {
    List<Book> publishedBooks;
}

class SystemUser extends Person {
    String email;
    String phoneNumber;
    Account account;
}

class Member extends SystemUser {
    int totalBookIssued;
    Search searchObj;
    BookIssueService bookIssueService;
}

class Librarian extends SystemUser {
    Search searchObj;
    BookIssueService bookIssueService;

    public void addBooksItem(BookItem bookItem);

    public BookItem deleteBookItem(int barCode);
}

class Account {
    String userName;
    String passWord;
    int accountId;
}

class Search {
    public List<BookItem> getBookByTitle(String title);

    public List<BookItem> getBookByAuthor(String author);

    public List<BookItem> getBookByType(String type);

    public List<BookItem> getBookByPublicationDate(Date publicationDate);
}

class BookIssueService {
    FineService fineService;

    public BookReservationDetails getReservationDetail(BookItem book);

    public void updateReservation(BookReservationDetails bookReservationDetails);

    public BookReservationDetails reserveBook(BookItem bookItem, SystemUser user);

    public BookIssueDetail issueBook(BookItem book, SystemUser user);

    public BookIssueDetail renewBook(BookItem book, SystemUser user);

    public void returnBook(BookItem book, SystemUser user);
}

class BookLending {
    BookItem bookItem;
    Date startDate;
    SystemUser user;
}

class BookReservationDetails {
    ReservationDetails reservationDetails;
}

class BookIssueDetails extends BookLending {
    Date dueDate;
}

class FineService {
    Date fineDate;
    BookItem book;
    SystemUser user;
    Double fineValue;
}

class ReservationDetails {

}