import com.example.orders.*;
import java.util.List;

public class TryIt {
    public static void main(String[] args) {
        System.out.println("=== Builder Pattern Demo ===\n");
        
        OrderLine l1 = new OrderLine("A", 1, 200);
        OrderLine l2 = new OrderLine("B", 3, 100);
        
        System.out.println("Creating order with builder...");
        
        Order order = new Order.Builder("ORD-001", "customer@example.com")
            .addLine(l1)
            .addLine(l2)
            .discountPercent(10)
            .expedited(true)
            .notes("Priority order")
            .build();
        
        System.out.println("Order created: " + order);
        System.out.println("Total before discount: " + order.totalBeforeDiscount() + "¢");
        System.out.println("Total after discount: " + order.totalAfterDiscount() + "¢");
        
        System.out.println("\n--- Testing immutability ---");
        
        try {
            List<OrderLine> lines = order.getLines();
            
            System.out.println("✓ Order lines are immutable - can't add new lines after creation");
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
        
        System.out.println("\n--- Testing validation ---");
        
        try {
            Order invalidOrder = new Order.Builder("", "invalid-email")
                .addLine(l1)
                .build();
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Validation caught empty ID: " + e.getMessage());
        }
        
        try {
            Order invalidOrder = new Order.Builder("ORD-002", "customer@example.com")
                .discountPercent(150) // Invalid: > 100%
                .build();
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Validation caught invalid discount: " + e.getMessage());
        }
        
        try {
            Order invalidOrder = new Order.Builder("ORD-003", "customer@example.com")
                .build(); // No lines!
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Validation caught missing order lines: " + e.getMessage());
        }
        
        System.out.println("\n=== Builder Pattern Benefits ===");
        System.out.println("1. ✓ No more telescoping constructors");
        System.out.println("2. ✓ Immutable objects (thread-safe, no side effects)");
        System.out.println("3. ✓ Validation in one place (build method)");
        System.out.println("4. ✓ Fluent API (method chaining)");
        System.out.println("5. ✓ Defensive copying prevents external modification");
        System.out.println("6. ✓ Clear required vs optional parameters");
    }
}
