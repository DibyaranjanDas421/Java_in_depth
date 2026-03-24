package polymorphism.runtimepolymorphism;

public class UpiPaymentService implements PaymentService {

    @Override
    public void pay() {
        System.out.println("paid using upi!");
    }

}
