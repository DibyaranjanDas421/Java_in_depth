package access_modifier;

public class BankAccount {
    private Integer balance = 1000;
    String branch = "CSE";
    protected String name = "Dibya";

    private void calculateInterest() {
        System.out.println("Interest calculated");
    }

    public static void main(String[] args) {

        BankAccount bankAccount = new BankAccount();
        System.out.println(bankAccount.balance);

    }
}
