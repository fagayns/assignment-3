//TransactionType Enum
public enum TransactionType {
    DEPOSIT,
    WITHDRAWAL
}

//Amount Class
public class Amount {
    private double amount;
    private TransactionType transactionType;

    // Constructor
    public Amount(double amount, TransactionType transactionType) {
        this.amount = amount;
        this.transactionType = transactionType;
    }

    // Getter methods
    public double getAmount() {
        return amount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    // toString method to display transaction info
    @Override
    public String toString() {
        return "Transaction: " + transactionType + " of $" + amount;
    }
}


//PersonalAccount Class
 import java.util.ArrayList;

public class PersonalAccount {
    private int accountNumber;
    private String accountHolder;
    private double balance;
    private ArrayList<Amount> transactions;

    // Constructor to initialize account
    public PersonalAccount(int accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be greater than zero.");
            return;
        }
        balance += amount;
        transactions.add(new Amount(amount, TransactionType.DEPOSIT));
        System.out.println("Deposited $" + amount);
    }

    // Method to withdraw money from the account
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be greater than zero.");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient balance for withdrawal.");
            return;
        }
        balance -= amount;
        transactions.add(new Amount(amount, TransactionType.WITHDRAWAL));
        System.out.println("Withdrew $" + amount);
    }

    // Method to print the transaction history
    public void printTransactionHistory() {
        System.out.println("Transaction history for account: " + accountNumber);
        for (Amount transaction : transactions) {
            System.out.println(transaction);
        }
    }

    // Method to get current balance
    public double getBalance() {
        return balance;
    }

    // Method to get account number
    public int getAccountNumber() {
        return accountNumber;
    }

    // Method to get account holder name
    public String getAccountHolder() {
        return accountHolder;
    }

    // Main method for testing
    public static void main(String[] args) {
        // Creating an instance of PersonalAccount
        PersonalAccount account = new PersonalAccount(123456, "John Doe");

        // Testing deposit method
        account.deposit(500);
        account.deposit(200);

        // Testing withdraw method
        account.withdraw(100);
        account.withdraw(1000); // Attempting to withdraw more than balance

        // Print balance
        System.out.println("Current Balance: $" + account.getBalance());

        // Print transaction history
        account.printTransactionHistory();
    }
}

