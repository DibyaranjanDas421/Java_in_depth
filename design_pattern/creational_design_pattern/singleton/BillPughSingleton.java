package design_pattern.creational_design_pattern.singleton;

public class BillPughSingleton {

    private BillPughSingleton() {
    };

    public static class InnerBillPughSingleton {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInatance() {
        return InnerBillPughSingleton.INSTANCE;
    }

}
