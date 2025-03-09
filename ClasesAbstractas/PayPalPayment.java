package ClasesAbstractas;

public class PayPalPayment implements PaymentMethod {

    public PayPalPayment(){};

    @Override
    public void processPayment(double amount) {
        System.out.println("Pago exitoso con paypal :" + amount);
        
    }

}
