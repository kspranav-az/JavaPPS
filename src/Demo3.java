import java.util.Scanner;

class Telephone {
    String name;
    int phnum;
    Scanner sc = new Scanner(System.in);

    Telephone() {
    }

    Telephone(String name, int phnum) {
        this.name = name;
        this.phnum = phnum;
    }

    void inp() {
        System.out.println("Enter customer name: ");
        name = sc.next();
        System.out.println("Enter phone number: ");
        phnum = sc.nextInt();
    }

    void disp() {
        System.out.println("Name: " + name);
        System.out.println("Phone Number: " + phnum);
    }
}

class TelephoneIndex extends Telephone {

    TelephoneIndex() {
    }

    TelephoneIndex(String name, int phnum) {
        super(name, phnum);
    }

    void ChangeName(String name) {
        this.name = name;
    }

    void ChangeNum(int phnum) {
        this.phnum = phnum;
    }
}

class Demo3 {

    static void Search(String str, TelephoneIndex arr[]) {
        for (TelephoneIndex T : arr) {
            if ((T.name).startsWith(str)) {
                System.out.println("Name found: " + T.name);
            }
        }
    }

    static void DispMatch(String strArr[], TelephoneIndex arr[]) {
        for (String str : strArr) {
            for (TelephoneIndex T : arr) {
                if (str.equalsIgnoreCase(T.name)) {
                    T.disp();
                }
            }
        }
    }

    public static void main(String args[]) {
        int n = 5;
        Scanner sc = new Scanner(System.in);
        TelephoneIndex arr[] = new TelephoneIndex[n];
        arr[0] = new TelephoneIndex("Adam", 1234567891);
        arr[1] = new TelephoneIndex("Eve", 1987654321);
        for (int i = 2; i < n; i++) {
            arr[i] = new TelephoneIndex();
            arr[i].inp();
        }

        while (true) {
            System.out.println("1. Search");
            System.out.println("2. Display");
            System.out.println("3. Change name");
            System.out.println("4. Change number");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");
            int ch = sc.nextInt();
            if (ch == 1) {
                System.out.println("Enter name to check: ");
                String str = sc.next();
                Search(str, arr);
            } else if (ch == 2) {
                String str = sc.nextLine();
                String strArr[] = str.split("\\s+");
                DispMatch(strArr, arr);
            } else if (ch == 3) {
                System.out.println("Enter name to replace: ");
                String oldName = sc.next();
                System.out.println("Enter new name: ");
                String newName = sc.next();
                for (TelephoneIndex T : arr) {
                    if (oldName.equalsIgnoreCase(T.name)) {
                        T.ChangeName(newName);
                        T.disp();
                    }
                }
            } else if (ch == 4) {
                System.out.println("Enter number to replace: ");
                int oldNum = sc.nextInt();
                System.out.println("Enter new number: ");
                int newNum = sc.nextInt();
                for (TelephoneIndex T : arr) {
                    if (oldNum == T.phnum) {
                        T.ChangeNum(newNum);
                        T.disp();
                    }
                }
            } else if (ch == 5) {
                break;
            } else {
                System.out.println("Invalid Choice");
                break;
            }
        }
    }
}
