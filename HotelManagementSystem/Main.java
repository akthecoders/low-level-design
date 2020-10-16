import java.sql.Date;
import java.util.List;

class Hotel {
    String name;
    Integer id;
    Location location;
    List<Rooms> rooms;
}

class Location {
    int pin;
    String street;
    String area;
    String state;
    String country;
}

class Rooms {
    String roomNumber;
    RoomStyle roomStyle;
    RoomStatus status;
    Double bookingPrice;
    List<RoomKey> roomKeys;
    List<HouseKeepingLogs> houseKeepingLogs;

}

enum RoomStyle {
    DELUX, STANDARD, ROYAL;
}

enum RoomStatus {
    ACTIVE, BOOKED, INACTIVE, RESERVED;
}

class RoomKey {
    int id;
    String barCodeId;
    String issuedAt;
    Boolean isActive;
    Boolean isMaster;

    public void assignRoom(Rooms room) {
    }
}

class HouseKeepingLogs {
    int id;
    String description;
    String startDate;
    int duration;
    HouseKeeper houseKeeper;

    public void addRoom(Rooms room) {
    }
}

abstract class Person {
    String name;
    Account accountDetails;
    String phone;
}

class Account {
    String username;
    String password;
    AccountStatus status;
}

enum AccountStatus {
    ACTIVE, INACTIVE;
}

class HouseKeeper extends Person {
    public List<Rooms> getRoomsServiced(Date date) {
        return null;
    }
}

class Guest extends Person {
    Search searchObj;
    Booking bookingObj;

    public List<RoomBooking> getAllBookings() {
        return null;
    }
}

class Receptionist extends Person {
    Search searchObj;
    Booking bookingObj;

    public void checkInGuest(Guest guest, RoomBooking roombooking){}

    public void checkOutGuest(Guest guest, RoomBooking roombooking){}
}

class Admin extends Person {
    public void addRoom(Rooms roomDetails){}

    public void removeRoom(String roomId){}

    public void editRoom(Rooms roomDetails){}
}

class Search {
    public List<Rooms> searchRoom(RoomStyle roomStyle, Date startDate, int duration){
        return null;
    }
}

class Booking {
    public RoomBooking createBooking(Guest guestInfo){
        return null;
    }

    public RoomBooking cancelBooking(int bookingId){
        return null;
    }
}

class RoomBooking {
    String startDate;
    BookingStatus bookingStatus;
    List<Guest> guests;
    List<Rooms> roomsInfo;
    BaseRoomCharge totalRoomCharge;
}

enum BookingStatus {
    BOOKED, NOTBOOKED;
}

interface BaseRoomCharge {
    Double getCost();

    void setCost(double d);
}

class RoomService implements BaseRoomCharge {
    double cost;
    BaseRoomCharge baseRoomCharge;

    public Double getCost() {
        baseRoomCharge.setCost(baseRoomCharge.getCost() + cost);
        return baseRoomCharge.getCost();
    }

    @Override
    public void setCost(double d) {
        // TODO Auto-generated method stub

    }
}

class InRoomPurchaseCharges implements BaseRoomCharge {
    double cost;
    BaseRoomCharge baseRoomCharge;

    public Double getCost() {
        baseRoomCharge.setCost(baseRoomCharge.getCost() + cost);
        return baseRoomCharge.getCost();
    }

    @Override
    public void setCost(double d) {
        // TODO Auto-generated method stub

    }
}