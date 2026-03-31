package access_modifier.default_package;

import access_modifier.BankAccount;

public class Test extends BankAccount {

    public void accessName() {
        System.out.println(name);
    }

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        Test t = new Test();
        // System.out.println(bankAccount.branch);
        t.accessName();
    }

}
