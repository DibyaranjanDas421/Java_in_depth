package encapsulation;

public class BankAccount {

    private Integer balance;

    public void deposit(Integer amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(Integer amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    public Integer getBalance() {
        return balance;
    }

}
