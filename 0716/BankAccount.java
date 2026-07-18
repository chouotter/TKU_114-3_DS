public class BankAccount {


    private String accountNumber;
    private String accountName;
    private int balance;


    public BankAccount(String accountNumber, String accountName, int balance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;

        if (balance >= 0) {
            this.balance = balance;
        } else {
            this.balance = 0;
        }
    }


    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public int getBalance() {
        return balance;
    }


    public boolean deposit(int amount) {
        if (amount <= 0) {
            return false;
        }

        balance += amount;
        return true;
    }


    public boolean withdraw(int amount) {
        if (amount <= 0) {
            return false;
        }

        if (amount > balance) {
            return false;
        }

        balance -= amount;
        return true;
    }


    public boolean transferTo(BankAccount target, int amount) {
        if (amount <= 0) {
            return false;
        }

        if (amount > balance) {
            return false;
        }

        balance -= amount;
        target.balance += amount;

        return true;
    }


    @Override
    public String toString() {
        return "帳號：" + accountNumber +
               "，戶名：" + accountName +
               "，餘額：" + balance;
    }
}