package design_pattern.structural_design_patterns.adapter_pattern;

public class Adapter implements NewPayment {

    private OldPayment oldPayment;

    Adapter(OldPayment oldPayment) {
        this.oldPayment = oldPayment;
    }

    @Override
    public void payUsingUpi() {
        oldPayment.payUsingCash();
    }

}
