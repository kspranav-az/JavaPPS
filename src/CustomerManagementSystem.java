
import java.util.Scanner;
import java.util.regex.Pattern;

class Customer {
    String name;
    int phoneNumber;
}

class CustomerIndex extends Customer {
    public CustomerIndex() {}

    public CustomerIndex(int num, String str) {
        this.name = str;
        this.phoneNumber = num;
    }

    void changeName(String str) {
        this.name = str;
    }

    void changePhoneNumber(int num) {
        this.phoneNumber = num;
    }
}

public class CustomerManagementSystem {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        CustomerIndex[] customers = new CustomerIndex[2];
        customers[0] = new CustomerIndex(943415560, "Pranav");
        customers[1] = new CustomerIndex(980416787, "Prash");

        while (true) {
            System.out.println("WELCOME TO OUR CUSTOMER MANAGEMENT");
            System.out.println("1. SEARCH CUSTOMER NAME");
            System.out.println("2. SEARCH AND FETCH CUSTOMER DETAIL");
            System.out.println("3. CHANGE A CUSTOMER'S NAME");
            System.out.println("4. CHANGE A CUSTOMER'S PHONE NUMBER");
            System.out.println("5. EXIT");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("ENTER STRING: ");
                    String searchString = scanner.next();
                    String escapedPrefix = Pattern.quote(searchString);
                    Pattern pattern = Pattern.compile("^" + escapedPrefix, Pattern.CASE_INSENSITIVE);
                    for (int i = 0; i < 2; i++) {
                        if (pattern.matcher(customers[i].name).find()) {
                            System.out.println(customers[i].name);
                        }
                    }
                    break;

                case 2:
                    System.out.print("ENTER STRING: ");
                    String searchName = scanner.next();
                    for (int i = 0; i < 2; i++) {
                        if (customers[i].name.equals(searchName)) {
                            System.out.println("Customer Name: " + customers[i].name);
                            System.out.println("Phone Number: " + customers[i].phoneNumber);
                        }
                    }
                    break;

                case 3:
                    System.out.print("ENTER WHO'S NAME YOU WANT TO CHANGE: ");
                    String nameToChange = scanner.next();
                    for (int i = 0; i < 2; i++) {
                        if (customers[i].name.equals(nameToChange)) {
                            System.out.print("ENTER NEW NAME: ");
                            String newName = scanner.next();
                            customers[i].changeName(newName);
                        }
                    }
                    break;

                case 4:
                    System.out.print("ENTER WHO'S PHONE NUMBER YOU WANT TO CHANGE: ");
                    String nameToChangePhoneNumber = scanner.next();
                    for (int i = 0; i < 2; i++) {
                        if (customers[i].name.equals(nameToChangePhoneNumber)) {
                            System.out.print("ENTER NEW PHONE NUMBER: ");
                            int newPhoneNumber = scanner.nextInt();
                            customers[i].changePhoneNumber(newPhoneNumber);
                        }
                    }
                    break;

                case 5:
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
