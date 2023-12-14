import java.util.ArrayList;

class Contact {

    private String firstName, lastName, address, city, state, zipcode, phone, email;

    public Contact(String firstName, String lastName, String address, String city, String state, String zipcode, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.phone = phone;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getAddress() {
        return address;
    }
    public String getCity() {
        return city;
    }
    public String getState() {
        return state;
    }
    public String getZipcode() {
        return zipcode;
    }
    public String getPhone() {
        return phone;
    }
    public String getEmail() {
        return email;
    }
}

public class AddressBookMain {
    public static void main(String[] args) {
        AddressBookMain addressBook = new AddressBookMain();
        System.out.println("Welcome To Address Book Program");

    }
}