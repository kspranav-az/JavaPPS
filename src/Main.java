//import java.util.Scanner;
//
//class Telephone {
//    String name;
//    String phoneNumber;
//
//    // Constructor
//    public Telephone(String name, String phoneNumber) {
//        this.name = name;
//        this.phoneNumber = phoneNumber;
//    }
//
//    // Getter methods
//    public String getName() {
//        return name;
//    }
//
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    // Display method
//    public void display() {
//        System.out.println("Name: " + name + ", Phone Number: " + phoneNumber);
//    }
//}
//
//class TelephoneIndex extends Telephone {
//    public TelephoneIndex(String name, String phoneNumber) {
//        super(name, phoneNumber);
//    }
//
//    // Method to change the name
//    public void changeName(String newName) {
//        this.name = newName;
//    }
//
//    // Method to change the phone number
//    public void changePhoneNumber(String newPhoneNumber) {
//        this.phoneNumber = newPhoneNumber;
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        // Create an array of TelephoneIndex objects
//        TelephoneIndex[] telephoneArray = {
//                new TelephoneIndex("John Doe", "123-456-7890"),
//                new TelephoneIndex("Jane Smith", "987-654-3210"),
//                // Add more entries as needed
//        };
//
//        Scanner scanner = new Scanner(System.in);
//
//        // a. Search for a name
//        System.out.print("Enter name or first few characters: ");
//        String searchString = scanner.nextLine();
//
//        for (TelephoneIndex telephone : telephoneArray) {
//            if (telephone.getName().toLowerCase().contains(searchString.toLowerCase())) {
//                telephone.display();
//            }
//        }
//
//        // b. Display all matching names and phone numbers
//
//        // c. Change the name of a customer
//        System.out.print("Enter the name of the customer to change: ");
//        String customerToChangeName = scanner.nextLine();
//        for (TelephoneIndex telephone : telephoneArray) {
//            if (telephone.getName().equalsIgnoreCase(customerToChangeName)) {
//                System.out.print("Enter the new name: ");
//                String newName = scanner.nextLine();
//                telephone.changeName(newName);
//                System.out.println("Name changed successfully!");
//                break;
//            }
//        }
//
//        // d. Change the phone number of a customer
//        System.out.print("Enter the name of the customer to change phone number: ");
//        String customerToChangePhoneNumber = scanner.nextLine();
//        for (TelephoneIndex telephone : telephoneArray) {
//            if (telephone.getName().equalsIgnoreCase(customerToChangePhoneNumber)) {
//                System.out.print("Enter the new phone number: ");
//                String newPhoneNumber = scanner.nextLine();
//                telephone.changePhoneNumber(newPhoneNumber);
//                System.out.println("Phone number changed successfully!");
//                break;
//            }
//        }
//    }
//}
