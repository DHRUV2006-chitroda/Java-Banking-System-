import java.util.*;

class Transaction {

    int id;
    String description;
    double amount;
    String type;

    Transaction(int id, String description, double amount, String type) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.type = type;
    }
}

public class SavingApp {

    static Scanner sc = new Scanner(System.in);

    // Store registered user details
    static String regUsername = "";
    static String regEmail = "";
    static String regPassword = "";

    static ArrayList<Transaction> list = new ArrayList<>();
static int id = 1;

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n==============================");
            System.out.println(" DHRUV'S BANKING SYSTEM");
            System.out.println("==============================");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // Clear buffer

            switch (choice) {

                case 1:
                    register();
                    break;

                case 2:
                    if (login()) {
                        dashboard();   // Call your existing dashboard code here
                    }
                    break;

                case 3:
                    System.out.println("Thank You!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }

    // Registration Method
    static void register() {

        System.out.println("\n===== Registration =====");

        System.out.print("Enter Username: ");
        regUsername = sc.nextLine();

       if (!regUsername.matches( "[a-zA-Z]+")) {
       System.out.println("Invalid Username. Only letters are allowed.");
       System.exit( 0); 
}

        System.out.print("Enter Email: ");
        regEmail = sc.nextLine();

        System.out.print("Enter Password: ");
        regPassword = sc.nextLine();

        System.out.println("\nRegistration Successful!");
    }

    // Login Method
    static boolean login() {

        System.out.println("\n===== Login =====");

        System.out.print("Username: ");
        String username = sc.nextLine();

        System.out.print("Password: ");
        String password = sc.nextLine();

        if (username.equals(regUsername) && password.equals(regPassword)) {

            System.out.println("\nLogin Successful!");
            return true;

        } else {

            System.out.println("\nInvalid Username or Password!");
            return false;

        }
    }

    // Replace this with your previous transaction menu
    static void dashboard() {

        while (true) {

            System.out.println("\n===== Dashboard =====");
            System.out.println("1. Add Transaction");
            System.out.println("2. View Transactions");
            // System.out.println("3. Update Transaction");
            System.out.println("3. Delete Transaction");
            // System.out.println("4. Show Summary");
            System.out.println("4. Logout");

            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();
            // sc.nextLine();

            switch (choice) {

                case 1:
                    addTransaction();
                    break;

                case 2:
                    viewTransaction();
                    break;

                // case 3:
                //     updateTransaction();
                //     break;

                case 3:
                    deleteTransaction();
                    break;

                // case 5:
                //     showSummary();
                //     break;

                case 4:
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }

        }

    }

    static void addTransaction() {

        sc.nextLine();

        System.out.print("Description: ");
        String des = sc.nextLine();

        System.out.print("Amount: ");
        double amount = sc.nextDouble();

        sc.nextLine();

        System.out.print("Type (Deposit/Withdraw): ");
        String type = sc.nextLine();

        list.add(new Transaction(id++, des, amount, type));

        System.out.println("Transaction Added Successfully.");

    }

    static void viewTransaction() {

        System.out.println("\nID\tDescription\tAmount\tType");

        for (Transaction t : list) {

            System.out.println(t.id + "\t" + t.description + "\t" + t.amount + "\t" + t.type);

        }

    }

    // static void updateTransaction() {

    //     System.out.print("Enter Transaction ID: ");
    //     int updateId = sc.nextInt();

    //     for (Transaction t : list) {

    //         if (t.id == updateId) {

    //             sc.nextLine();

    //             System.out.print("New Description: ");
    //             t.description = sc.nextLine();

    //             System.out.print("New Amount: ");
    //             t.amount = sc.nextDouble();

    //             sc.nextLine();

    //             System.out.print("New Type: ");
    //             t.type = sc.nextLine();

    //             System.out.println("Updated Successfully.");

    //             return;
    //         }

    //     }

    //     System.out.println("Transaction Not Found.");

    // }

    static void deleteTransaction() {

        System.out.print("Enter Transaction ID: ");
        int deleteId = sc.nextInt();

        Iterator<Transaction> it = list.iterator();

        while (it.hasNext()) {

            Transaction t = it.next();

            if (t.id == deleteId) {

                it.remove();

                System.out.println("Deleted Successfully.");

                return;
            }

        }

        System.out.println("Transaction Not Found.");

    }

    // 

}