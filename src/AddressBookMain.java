import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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

    private Map<String, ArrayList<Contact>> addressBooks;

    public AddressBookMain() {
        addressBooks = new HashMap<>();
    }

    private static void printMainMenu() {
        System.out.println("Enter your option: ");
        System.out.println("1. Create New Address Book");
        System.out.println("2. Switch Address Book");
        System.out.println("3. Add Contact");
        System.out.println("4. Edit Existing Contact");
        System.out.println("5. Delete Existing Contact");
        System.out.println("6. Print Contacts");
    }

    public void createAddressBook(String bookName) {
        addressBooks.put(bookName, new ArrayList<>());
    }

    public void switchAddressBook(String bookName) {
        if (addressBooks.containsKey(bookName)) {
            // Perform operations on the selected address book
            System.out.println("Switched to Address Book: " + bookName);
        } else {
            System.out.println("Address Book not found!");
        }
    }

    private static ArrayList<Contact> takeMultipleUserInput(Scanner scanner) {
        ArrayList<Contact> newContacts = new ArrayList<>();

        System.out.println("Enter the number of contacts you want to add: ");
        int numContacts = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int i = 0; i < numContacts; i++) {
            System.out.println("Enter details for Contact " + (i + 1) + ":");
            newContacts.add(takeUserInput(scanner));
        }

        return newContacts;
    }

    private static Contact takeUserInput(Scanner scanner) {
        System.out.println("Enter the first name of the contact: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter the last name of the contact: ");
        String lastName = scanner.nextLine();
        System.out.println("Enter the address of the contact: ");
        String address = scanner.nextLine();
        System.out.println("Enter the city of the contact: ");
        String city = scanner.nextLine();
        System.out.println("Enter the state of the contact: ");
        String state = scanner.nextLine();
        System.out.println("Enter the zipcode of the contact: ");
        String zipcode = scanner.nextLine();
        System.out.println("Enter the phone number of the contact: ");
        String phone = scanner.nextLine();
        System.out.println("Enter the email of the contact: ");
        String email = scanner.nextLine();

        return new Contact(firstName, lastName, address, city, state, zipcode, phone, email);
    }

    public void addContacts(String bookName, ArrayList<Contact> newContacts) {
        if (addressBooks.containsKey(bookName)) {
            addressBooks.get(bookName).addAll(newContacts);
        } else {
            System.out.println("Address Book not found! Create address book first.");
        }
    }

    public Contact findContact(String bookName, String firstName) {
        if (addressBooks.containsKey(bookName)) {
            for (Contact contact : addressBooks.get(bookName)) {
                if (contact.getFirstName().equalsIgnoreCase(firstName)) {
                    return contact;
                }
            }
        } else {
            System.out.println("Address Book not found! Please create the address book first.");
        }
        return null; // Contact not found
    }

    public void deleteContact(String bookName, String firstName) {
        if (addressBooks.containsKey(bookName)) {
            Contact contactToDelete = null;

            for (Contact contact : addressBooks.get(bookName)) {
                if (contact.getFirstName().equalsIgnoreCase(firstName)) {
                    contactToDelete = contact;
                    break;
                }
            }

            if (contactToDelete != null) {
                addressBooks.get(bookName).remove(contactToDelete);
                System.out.println("Contact deleted successfully from Address Book: " + bookName);
            } else {
                System.out.println("Contact not found with the given first name in Address Book: " + bookName);
            }
        } else {
            System.out.println("Address Book not found! Please create the address book first.");
        }
    }

    public void printContacts(String bookName) {
        if (addressBooks.containsKey(bookName)) {
            System.out.println("Contacts in Address Book: " + bookName);
            for (Contact contact : addressBooks.get(bookName)) {
                System.out.println(contact.getFirstName() + " " + contact.getLastName() + ", " +
                        contact.getAddress() + ", " + contact.getCity() + ", " + contact.getState() +
                        ", " + contact.getZipcode() + ", " + contact.getPhone() + ", " + contact.getEmail());
            }
        } else {
            System.out.println("Address Book not found! Please create the address book first.");
        }
    }

    public static void main(String[] args) {
        AddressBookMain addressBookManager = new AddressBookMain();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome To Address Book Program");
        int option;
        String currentAddressBook = null;

        while (true) {
            printMainMenu();
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Enter the name of the new address book: ");
                    String newBookName = scanner.nextLine();
                    addressBookManager.createAddressBook(newBookName);
                    break;
                case 2:
                    System.out.println("Enter the name of the address book to switch: ");
                    String switchBookName = scanner.nextLine();
                    addressBookManager.switchAddressBook(switchBookName);
                    currentAddressBook = switchBookName;
                    break;
                case 3:
                    ArrayList<Contact> newContacts = takeMultipleUserInput(scanner);
                    addressBookManager.addContacts(currentAddressBook, newContacts);
                    addressBookManager.printContacts(currentAddressBook);
                    break;
                case 4:
                    System.out.println("Enter the first name to find the contact: ");
                    String findFirstName = scanner.nextLine();
                    Contact foundContact = addressBookManager.findContact(currentAddressBook, findFirstName);

                    if (foundContact != null) {
                        System.out.println("Contact found in Address Book: " + currentAddressBook);
                        System.out.println(foundContact.getFirstName() + " " + foundContact.getLastName() + ", " +
                                foundContact.getAddress() + ", " + foundContact.getCity() + ", " +
                                foundContact.getState() + ", " + foundContact.getZipcode() + ", " +
                                foundContact.getPhone() + ", " + foundContact.getEmail());
                    } else {
                        System.out.println("Contact not found with the given first name in Address Book: " + currentAddressBook);
                    }
                    break;
                case 5:
                    System.out.println("Enter the first name to delete the contact: ");
                    String deleteFirstName = scanner.nextLine();
                    addressBookManager.deleteContact(currentAddressBook, deleteFirstName);
                    addressBookManager.printContacts(currentAddressBook);
                    break;
                case 6:
                    addressBookManager.printContacts(currentAddressBook);
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
        scanner.close();
    }
}