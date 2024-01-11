package com.bridgelabz;

import java.util.*;

/*  This class contains printMainMenu(), createAddressBook(), switchAddressBook(), takeMultipleUserInput(),
    takeUserInput(), addContacts(), editContact(), findContact(), deleteContact(), printContacts().
*/

public class AddressBook {

    /*  @Description: This class contains all implementation details are procedures for AddressBook Program.
        @Parameters: bookName, newContacts, scanner, firstName.
        @Return: newContacts, Contact, contact.
    */

    private Map<String, ArrayList<Contact>> addressBooks;

    public AddressBook() {
        addressBooks = new HashMap<>();
    }

    public static void printMainMenu() {
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

    public static ArrayList<Contact> takeMultipleUserInput(Scanner scanner) {
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

    public static Contact takeUserInput(Scanner scanner) {
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
            ArrayList<Contact> existingContacts = addressBooks.get(bookName);

            for (Contact newContact : newContacts) {
                if (!existingContacts.contains(newContact)) {
                    existingContacts.add(newContact);
                    System.out.println("Contact added successfully to Address Book: " + bookName);
                } else {
                    System.out.println("Duplicate contact found. Contact not added to Address Book: " + bookName);
                }
            }
        } else {
            System.out.println("Address Book not found! Create address book first.");
        }
    }

    public void editContact(String bookName, String firstName, Scanner scanner) {
        if (addressBooks.containsKey(bookName)) {
            Contact contactToEdit = findContact(bookName, firstName);

            if (contactToEdit != null) {
                System.out.println("Editing Contact with first name: " + firstName);
                System.out.println("Select field to edit:");
                System.out.println("1. First Name");
                System.out.println("2. Last Name");
                System.out.println("3. Address");
                System.out.println("4. City");
                System.out.println("5. State");
                System.out.println("6. Zipcode");
                System.out.println("7. Phone");
                System.out.println("8. Email");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        System.out.println("Enter new last name: ");
                        String newFirstName = scanner.nextLine();
                        contactToEdit.setFirstName(newFirstName);
                        break;
                    case 2:
                        System.out.println("Enter new last name: ");
                        String newLastName = scanner.nextLine();
                        contactToEdit.setLastName(newLastName);
                        break;
                    case 3:
                        System.out.println("Enter new address: ");
                        String newAddress = scanner.nextLine();
                        contactToEdit.setAddress(newAddress);
                        break;
                    case 4:
                        System.out.println("Enter new city: ");
                        String newCity = scanner.nextLine();
                        contactToEdit.setCity(newCity);
                        break;
                    case 5:
                        System.out.println("Enter new state: ");
                        String newState = scanner.nextLine();
                        contactToEdit.setState(newState);
                        break;
                    case 6:
                        System.out.println("Enter new zipcode: ");
                        String newZipcode = scanner.nextLine();
                        contactToEdit.setZipcode(newZipcode);
                        break;
                    case 7:
                        System.out.println("Enter new phone number: ");
                        String newPhone = scanner.nextLine();
                        contactToEdit.setPhone(newPhone);
                        break;
                    case 8:
                        System.out.println("Enter new email: ");
                        String newEmail = scanner.nextLine();
                        contactToEdit.setEmail(newEmail);
                        break;
                    default:
                        System.out.println("Invalid choice. No field edited.");
                }

                System.out.println("Contact edited successfully.");
            } else {
                System.out.println("Contact not found with the given first name in Address Book: " + bookName);
            }
        } else {
            System.out.println("Address Book not found! Please create the address book first.");
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
            System.out.println("Contact not found.");
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
}