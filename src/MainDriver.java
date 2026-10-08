import java.util.Scanner;

public class MainDriver {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        BankAccount[] bankAccounts = new BankAccount[1];

        for (int i = 0; i < bankAccounts.length; i++) {
            System.out.print("Enter the name that was used to create the account: ");
            String name = sc.nextLine();

            System.out.print("Enter your account number (9 digits): ");
            String number = sc.nextLine();
            System.out.println();

            bankAccounts[i] = new BankAccount(name, number);
        }

        System.out.println("Select an account: ");
        for  (int i = 0; i < bankAccounts.length; i++) {
            System.out.print(i + 1 + ". ");
            System.out.println();
            bankAccounts[i].getAccInfo();
            System.out.println();
        }

        System.out.print("Enter the account number to select: ");
        int accountChoice = sc.nextInt();

        if (accountChoice < 1 || accountChoice > bankAccounts.length) {
            System.out.println("Invalid account choice.");
            return;
        }

        BankAccount selected = bankAccounts[accountChoice - 1];

        System.out.println("Please select the action you would like to perform: ");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println();
        int action = sc.nextInt();

        switch (action) {
            case 1:
                System.out.print("Enter amount to deposit: ");
                double amount = sc.nextDouble();
                selected.deposit(amount);
                selected.getAccInfo();
                break;
            case 2:
                System.out.print("Enter amount to withdraw: ");
                double amount2 = sc.nextDouble();
                selected.withdraw(amount2);
                selected.getAccInfo();
                break;
            default:
                System.out.println("Invalid choice");
        }
        sc.close();
    }
}
