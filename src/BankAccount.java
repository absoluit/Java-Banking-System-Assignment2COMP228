import java.util.Locale;
import java.text.NumberFormat;

public class BankAccount {
    private final String accName;
    private final String accNumber;
    private double accBalance;
    NumberFormat cadFormat = NumberFormat.getCurrencyInstance(Locale.CANADA);

    public BankAccount(String accName, String accNumber) throws Exception {
        this.accName = verifyAccName(accName);
        this.accNumber = verifyAccNumber(accNumber);
        this.accBalance = verifyAccBalance(999_999);
    }

    public String getAccName() {
        return accName;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public String getAccBalance() {
        return cadFormat.format(accBalance);
    }

    public void getAccInfo() {
        System.out.println("Account Name: " + accName);
        System.out.println("Account Number: " + accNumber);
        System.out.println("Balance: " + getAccBalance());
    }

    public void deposit(double amount) throws NegativeAmountException, ZeroAmountException {
        try {
            if (amount < 0) {
                throw new NegativeAmountException("Amount cannot be negative");
            }
            if (amount == 0) {
                throw new ZeroAmountException("Amount cannot be zero");
            }
            accBalance += amount;
            System.out.printf("$%.2f Deposited%n", amount);
        } finally {
            System.out.println("If you are having problems, please contact customer support: 123 456 7890");
        }
    }

    public void withdraw(double amount) throws NegativeAmountException, ZeroAmountException, InsufficientFundsException {
        try {
            if (amount < 0) {
                throw new NegativeAmountException("Amount cannot be negative");
            }
            if (amount == 0) {
                throw new ZeroAmountException("Amount cannot be zero");
            }
            if (amount > accBalance) {
                throw new InsufficientFundsException("Withdraw amount must be less than current account balance");
            }
            accBalance -= amount;
            System.out.printf("$%.2f Withdrawn%n", amount);
            } finally {
            System.out.println("If you are having a problem, please contact customer support: 123 456 7890");
        }
    }

    private String verifyAccName(String accName) throws EmptyFieldException {
        if (accName == null) {
            throw new EmptyFieldException("Name is null");
        }
        if (accName.isEmpty()) {
            throw new EmptyFieldException("Name is empty");
        }
        if (accName.length() < 3) {
            throw new EmptyFieldException("Name is too short");
        }
        return accName;
    }

    private String verifyAccNumber(String accNumber) throws InvalidAccountNumberException {
        if (accNumber.length() != 9) {
            throw new InvalidAccountNumberException("Account number is invalid");
        }
        return accNumber;
    }

    private double verifyAccBalance(double accBalance) throws NegativeAmountException {
        if (accBalance < 0) {
            throw new NegativeAmountException("Balance is negative");
        }
        return accBalance;
    }
}