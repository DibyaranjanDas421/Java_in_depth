package design_pattern.structural_design_patterns.adapter_pattern;

public class OldPaymentImpl implements OldPayment {

    @Override
    public void payUsingCash() {
        System.out.println("Paying using cash!");
    }

}
