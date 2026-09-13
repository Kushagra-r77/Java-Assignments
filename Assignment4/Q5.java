package Assignment4;

class InsufficientBalanceException extends Exception {

    InsufficientBalanceException(String message) {
        super(message);
    }
}

class InvalidAmountException extends Exception {

    InvalidAmountException(String message) {
        super(message);
    }
}

class AccountNotFoundException extends Exception {

    AccountNotFoundException(String message) {
        super(message);
    }
}

class BankAccount {

    private int accountNumber;
    private double balance;

    BankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount)
            throws InvalidAmountException {

        if (amount <= 0) {
            throw new InvalidAmountException(
                "Deposit must be greater than zero"
            );
        }

        balance += amount;
    }

    public void withdraw(double amount)
            throws InvalidAmountException,
                   InsufficientBalanceException {

        if (amount <= 0) {
            throw new InvalidAmountException(
                "Withdrawal must be greater than zero"
            );
        }

        if (amount > balance) {
            throw new InsufficientBalanceException(
                "Insufficient balance"
            );
        }

        balance -= amount;
    }
}
public class Q5 {

    static BankAccount findAccount(
            BankAccount[] accounts,
            int accountNumber)
            throws AccountNotFoundException {

        for (BankAccount account : accounts) {

            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }

        throw new AccountNotFoundException(
            "Account not found"
        );
    }

    public static void main(String[] args) {

        BankAccount[] accounts = {
            new BankAccount(101, 5000),
            new BankAccount(102, 3000)
        };

        try {

            BankAccount account =
                findAccount(accounts, 101);

            account.deposit(1000);

            account.withdraw(2000);

            System.out.println(
                "Balance = Rs. " + account.getBalance()
            );

        }
        catch (AccountNotFoundException e) {
            System.out.println(e.getMessage());
        }
        catch (InvalidAmountException e) {
            System.out.println(e.getMessage());
        }
        catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }
}