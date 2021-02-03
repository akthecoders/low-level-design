package BookMyShow;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Main {
    List<Cinema> cinema;

    public List<Movie> getMoviesList(Date date, String city);
    public List<Cinema> getCinemas(String city)
}

public class Cinema {
    String name;
    Address address;
    List<Audi> audiList;

    Map<Date, Movie> getMovies(List<Date> dateList);
    Map<Date, Show> getShows(List<Date> dateList);
}

class Address {
    String street;
    String city;
    String state;
    String county;
    int pinCode;
}

public class Audi {
    int audiId;
    String audiName;
    int totalSeats;
    List<Show> shows;
}

public class Show {
    String showId;
    Movie movie;
    List<Seat> seats;
    Cinema cinema;
    Date startTime;
    Date endTime;
}

class Seat {
    int seatId;
    SeatType type;
    Status status;
    Double price;
}

enum SeatType {
    DELUX,
    VIP,
    ECONOMY
}

enum Status {
    BOOKED,
    RESERVED,
    NOT_AVAILABLE
}

class Movie {
    String movieName;
    int moveId;
    int durationMin;
    String language;
    Genere genere;
    Date releaseDate;
    Map<String, List<Show>> cityShowMap;
}

enum Genere {
    SCIFI,
    FICTOIN,
    ROMANCE
}

public class User {
    int userId;
    Search searchObj;
}

public class SystemMember {
    Account account;
    String name;
    String email;
    Address address;
}

public class Member extends SystemMember {
    public Booking makeBooking(Booking booking);
    public List<Booking> getBooking();
}

public class Admin extends SystemMember {
    public boolean addMovie(Movie movie);
    public boolean addShow(Show show);
}

public class Account {
    String userName;
    String password;
}

public class Search {
    // search methods
}

public class BookingDetail {
    String bookingId;
    Payement payementObj;

    //Other bojs
}

class  Payment {
    double amount;
    Date paymentDate;
    int transactionId;
    PaymentStatus paymentStatus;
}

enum PaymentStatus {
    PAID,
    HOLD,
    NOT_PAID,
    PENDING,
}

