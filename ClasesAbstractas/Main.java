package ClasesAbstractas;

public class Main {
    public static void main(String[] args){

        CreditCardPayment tarjeta = new CreditCardPayment();
        PayPalPayment usuario = new PayPalPayment();


        tarjeta.processPayment(50000);
        usuario.processPayment(10000);

       



    }
}
