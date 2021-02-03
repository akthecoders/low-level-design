package TrueCaller;

import java.util.*;

class DB {
    HashMap<Plan, String> planModuleMapping = new HashMap<Plan, String>();
    List<Contact> contactStore;
    HashSet<Contact> blockedContacts;
    List<Contact> globalContactStore;
}

class UserService {
    public Account registerUser(String userName, String password) {
        return new Account();
    }
}

class Account {
    String userName;
    String password;
}

class User {
    String firstName;
    String lastName;
    Location location;
    String email;
    Plan plan;
    Business business;
}

class BusinessService {
    public Business registerAsBusiness(User user, Business businessData) {
        return new Business();
    }
}

class Business {
    String businessName;
    String businessId;
    Location location;
    boolean isGSTCompliant;
    BusinessSize size;
    BusinessType businessType;
}

enum BusinessSize {
    SMALL,
    MEDIUM,
    LARGE,
    ENTERPRISE
}

enum BusinessType {
    EXPORT,
    IMPORTS,
    FINTECH,
    CLOTHING,
}

class SearchService {
    public List<Contact> searchByName(String name) {
        return new ArrayList<>();
    }

    public List<Contact> searchByNumber(String number) {
        return new ArrayList<>();
    }

    public List<Contact> searchFromGlobal(String number) {
        return new ArrayList<>();
    }
}

class ContactsService {
    public boolean importContacts(User user, List<Contact> contactList) {
        return true;
    }

    public boolean addContacts(User user, List<Contact> contactList) {
        return true;
    }

    public Contact blockContact(User user, Contact contact) {
        return new Contact();
    }

    public Contact unblockContact(User user, Contact contact) {
        return new Contact();
    }
}

class Contact {
    String number;
    String name;
    String email;
    Location location;
}

class Location {
    String lat;
    String lng;
    int pinCode;
    String street;
    String city;
    String state;
    String country;
}

class PlanService {
    Plan plan;

    public List<Plan> getPlans() {
        return new ArrayList<>();
    }

    public Plan upgradeToPlan(int planId) {
        return new Plan();
    }
}

class Plan {
    PlanType planType;

    public PlanType getPlanType() {
        return planType;
    }
}

interface PlanType {
    public List<String> getPrevileges();
}

class FreePlan implements PlanType {
    String planName;
    String planId;
    Integer price;

    @Override
    public List<String> getPrevileges() {
        return null;
    }

    public Integer getPrice() {
        return price;
    }
}

class NotificationService {
    User user;
    NotificationGateway notificationGateway;
    Template template;

    public boolean sendNotification(Message message, Template template) {
        return true;
    }
}

interface NotificationGateway {
    public boolean sendNotification(Message message, Template template);
}

class MessageNotification implements NotificationGateway {
    Message message;
    Template template;

    @Override
    public boolean sendNotification(Message message, Template template) {
        return false;
    }
}

class Message {
    String message;
    MessageType type;
    Date sentTime;
}

enum MessageType {
    EMAIL,
    SMS,
}

interface Template {

}

class SquareTemplate implements Template {

}

class BlueTemplate implements Template {

}

public class TrueCaller {

}

