package com.bridgelabz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        AddressBook addressBookManager = new AddressBook();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome To Address Book Program");
        int option;
        String currentAddressBook = null;

        while (true) {
            AddressBook.printMainMenu();
            System.out.println("Enter your choice: ");
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
                    ArrayList<Contact> newContacts = AddressBook.takeUserInput(scanner);
                    addressBookManager.addContacts(currentAddressBook, newContacts);
                    addressBookManager.printContacts(currentAddressBook);
                    break;
                case 4:
                    System.out.println("Enter the first name to find the contact: ");
                    String findFirstName = scanner.nextLine();
                    addressBookManager.editContact(currentAddressBook, findFirstName, scanner);
                    addressBookManager.printContacts(currentAddressBook);
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
                case 7:
                    System.out.println("Enter city to find contacts: ");
                    String cityToFind = scanner.nextLine();
                    List<Contact> contactsInCity = addressBookManager.findByCity(currentAddressBook, cityToFind);
                    if (!contactsInCity.isEmpty()) {
                        System.out.println("Contacts found in the city:");
                        for (Contact contact : contactsInCity) {
                            System.out.println(contact.getFirstName() + " " + contact.getLastName());
                        }
                    } else {
                        System.out.println("No contacts found in the specified city.");
                    }
                    break;
                case 8:
                    System.out.println("Enter state to find contacts: ");
                    String stateToFind = scanner.nextLine();
                    List<Contact> contactsInState = addressBookManager.findByState(currentAddressBook, stateToFind);
                    if (!contactsInState.isEmpty()) {
                        System.out.println("Contacts found in the state:");
                        for (Contact contact : contactsInState) {
                            System.out.println(contact.getFirstName() + " " + contact.getLastName());
                        }
                    } else {
                        System.out.println("No contacts found in the specified state.");
                    }
                    break;
                case 9:
                    System.out.println("Viewing contacts by city directory: ");
                    addressBookManager.viewFirstNameCityDirectory(currentAddressBook);
                    break;
                case 10:
                    System.out.println("Viewing contacts by state directory: ");
                    addressBookManager.viewFirstNameStateDirectory(currentAddressBook);
                    break;
                case 11:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
                    break;
            }
        }
    }
}
