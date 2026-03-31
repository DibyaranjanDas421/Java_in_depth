package design_pattern.structural_design_patterns.adapter_pattern;

public class Main {

    public static void main(String[] args) {
        OldPaymentImpl oldPaymentImpl = new OldPaymentImpl();
        Adapter newPayment = new Adapter(oldPaymentImpl);
        newPayment.payUsingUpi();
    }

}
