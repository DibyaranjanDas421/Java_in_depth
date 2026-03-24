package polymorphism.runtimepolymorphism;

public class Main {
    public static void main(String[] args) {
        PaymentService p = new UpiPaymentService();
        p.pay();
    }

}
