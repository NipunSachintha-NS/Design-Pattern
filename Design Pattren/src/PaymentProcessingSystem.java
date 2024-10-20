public class PaymentProcessingSystem {
    public interface PaymentProcessor {
        void processPayment(double amount);
    }

    // PayPal Class
    public class PayPal implements PaymentProcessor {
        @Override
        public void processPayment(double amount) {
            System.out.println("Processing payment of $" + amount + " through PayPal.");
        }
    }

    // Stripe Class
    public class Stripe {
        public void makePayment(double amount) {
            System.out.println("Processing payment of $" + amount + " through Stripe.");
        }
    }

    // StripeAdapter Class
    public class StripeAdapter implements PaymentProcessor {
        private Stripe stripe;

        public StripeAdapter(Stripe stripe) {
            this.stripe = stripe;
        }

        @Override
        public void processPayment(double amount) {
            stripe.makePayment(amount);
        }
    }

    // Main Method
    public static void main(String[] args) {
        PaymentProcessingSystem system = new PaymentProcessingSystem();

        PaymentProcessor paypalProcessor = system.new PayPal();
        paypalProcessor.processPayment(100.0);

        Stripe stripe = system.new Stripe();
        PaymentProcessor stripeProcessor = system.new StripeAdapter(stripe);
        stripeProcessor.processPayment(200.0);
    }
}
