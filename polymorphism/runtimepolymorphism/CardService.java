package polymorphism.runtimepolymorphism;

public class CardService implements PaymentService {

    @Override
    public void pay() {
        System.out.println("paid using card!");
    }

}
