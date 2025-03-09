package ClasesAbstractas;

public class CreditCardPayment implements PaymentMethod {


    public CreditCardPayment(){};


    @Override
    public void processPayment(double amount) {

        System.out.println("Pago exitoso con tu tarjeta de credito " + amount);
        
    }
}
