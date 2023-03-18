import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            CustomerManagement cm = new CustomerManagement();

            Scanner scanner = new Scanner(System.in);
            do {
                System.out.println("Welcome to Customer management Service");
                System.out.println("Select options:");
                System.out.println("1. Create Customer");
                System.out.println("2. View Customer details");
                System.out.println("3. Add balance");
                System.out.println("4. Withdraw Balance");
                System.out.println("5. Exit");

                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        cm.createCustomer();
                        break;

                    case 2:
                        cm.customerDetail();
                        break;

                    case 3:
                        cm.addBalance();

                        break;

                    case 4:
                        cm.withdrawBalance();
                        break;

                    case 5:
                        System.out.println("Thank you for using our software");
                        System.exit(0);

                        break;

                    default:
                        System.out.println("invalid choice:");
                }
            } while (true);
        }



}