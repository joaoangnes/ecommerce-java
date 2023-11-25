import entities.CreditCardPayment;
// import entities.DebitCardPayment;
// import entities.PixPayment;

public class TestExercicie01 {
    public static void main(String[] args) throws Exception {
        ECommerce ecommerce = new ECommerce();

        ecommerce.setPaymentMethod(new CreditCardPayment());

        // double amount = 11;
        // boolean paymentStatus = ecommerce.makePayment(amount);

        // if (paymentStatus) {
        //     System.out.println("Payment successful!");
        // } else {
        //     System.out.println("Payment failed. Please try again.");
        // }
    }
}
