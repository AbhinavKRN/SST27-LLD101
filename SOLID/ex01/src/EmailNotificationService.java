public class EmailNotificationService implements NotificationService {
    @Override
    public void sendOrderConfirmation(String customerEmail, double total) {
        String message = "Thank you for your order! Your total amount is $" + String.format("%.2f", total);
        System.out.println("[EMAIL sent to " + customerEmail + "] " + message);
    }
}
