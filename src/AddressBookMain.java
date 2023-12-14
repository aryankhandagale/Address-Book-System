import java.util.ArrayList;
import java.util.Scanner;

class Contact {

    private String firstName, lastName, address, city, state, zipcode, phone, email;

    public Contact(String firstName, String lastName, String address, String city,
                   String state, String zipcode, String phone, String email) {
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

    private ArrayList<Contact> contacts;

    public AddressBookMain() {
        contacts = new ArrayList<>();
    }

    private static void printMainMenu() {
        System.out.println("Enter your option: ");
        System.out.println("1. Add Contact");
        System.out.println("2. Edit Existing Contact");

    }

    private static Contact takeUserInput(Scanner scanner){
        System.out.println("Enter the first name of the contact: "); String firstName = scanner.nextLine();
        System.out.println("Enter the last name of the contact: "); String lastName = scanner.nextLine();
        System.out.println("Enter the address of the contact: "); String address = scanner.nextLine();
        System.out.println("Enter the city of the contact: "); String city = scanner.nextLine();
        System.out.println("Enter the state of the contact: "); String state = scanner.nextLine();
        System.out.println("Enter the zipcode of the contact: "); String zipcode = scanner.nextLine();
        System.out.println("Enter the phone number of the contact: "); String phone = scanner.nextLine();
        System.out.println("Enter the email of the contact: "); String email = scanner.nextLine();

        return new Contact(firstName, lastName, address, city, state, zipcode, phone, email);
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public Contact findContact(String firstName) {
        for (Contact contact : contacts) {
            if (contact.getFirstName().equalsIgnoreCase(firstName)) {
                return contact;
            }
        }
        return null; // Contact not found
    }

    public void printContacts() {
        for (Contact contact : contacts) {
            System.out.println(contact.getFirstName() + " " + contact.getLastName() + ", " + contact.getAddress() + ", " + contact.getCity()
                    + ", " + contact.getState() + ", " + contact.getZipcode() + ", " + contact.getPhone() + ", " + contact.getEmail());
        }
    }

    public static void main(String[] args) {
        AddressBookMain addressBook = new AddressBookMain();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome To Address Book Program");
        int option;
        while (true) {
            printMainMenu();
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    Contact contact = takeUserInput(scanner);
                    addressBook.addContact(contact);
                    addressBook.printContacts();
                    break;
                case 2:
                    System.out.println("Enter the first name to find the contact: ");
                    String editFirstName = scanner.nextLine();
                    Contact contactToEdit = addressBook.findContact(editFirstName);

                    if (contactToEdit != null) {
                        System.out.println("Enter new information for the contact:");
                        Contact editedContact = takeUserInput(scanner);
                        addressBook.contacts.remove(contactToEdit);
                        addressBook.contacts.add(editedContact);
                        System.out.println("Contact edited successfully.");
                        addressBook.printContacts();
                    } else {
                        System.out.println("Contact not found with the given first name.");
                    }
                    break;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
                    break;
            }
            System.out.println("Do you want to continue? (yes/no): ");
            String continueOption = scanner.nextLine();
            if (!continueOption.equals("yes")) {
                break;
            }
        }
    }
}