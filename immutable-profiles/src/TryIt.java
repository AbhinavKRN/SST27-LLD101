import com.example.profiles.*;

/**
 * Demo class to show how the immutable UserProfile works.
 * Run this to see the difference between the old mutable and new immutable approach.
 */
public class TryIt {
    public static void main(String[] args) {
        System.out.println("=== Immutable UserProfile Demo ===\n");
        
        ProfileService svc = new ProfileService();
        
        System.out.println("1. Creating minimal profile:");
        UserProfile minimalProfile = svc.createMinimal("user123", "john@example.com");
        System.out.println("   Created: " + minimalProfile);
        System.out.println();
        
        System.out.println("2. Attempting to modify immutable profile:");
        try {
            System.out.println("   [OK] Can't modify - no setters available!");
        } catch (Exception e) {
            System.out.println("   [ERROR] Error: " + e.getMessage());
        }
        System.out.println();
        
        System.out.println("3. Creating full profile with Builder:");
        UserProfile fullProfile = UserProfile.builder()
                .id("dev456")
                .email("sarah@tech.com")
                .phone("555-0123")
                .displayName("Sarah Developer")
                .address("123 Code Street, Programming City")
                .marketingOptIn(true)
                .twitter("@sarahdev")
                .github("sarah-dev")
                .build();
        System.out.println("   Created: " + fullProfile);
        System.out.println();
        
        System.out.println("4. Updating immutable profile (creating new object):");
        UserProfile updatedProfile = svc.updateDisplayName(fullProfile, "Sarah Super Developer");
        System.out.println("   Original: " + fullProfile.getDisplayName());
        System.out.println("   Updated:  " + updatedProfile.getDisplayName());
        System.out.println("   Are they the same object? " + (fullProfile == updatedProfile));
        System.out.println();
        
        System.out.println("5. Testing Builder validation:");
        try {
            UserProfile invalidProfile = UserProfile.builder()
                    .id("")
                    .email("not-an-email") 
                    .build();
            System.out.println("   [ERROR] Should have failed validation!");
        } catch (IllegalArgumentException e) {
            System.out.println("   [OK] Validation caught error: " + e.getMessage());
        }
        
        try {
            UserProfile invalidProfile2 = UserProfile.builder()
                    .id("valid-id")
                    .build();
            System.out.println("   [ERROR] Should have failed validation!");
        } catch (IllegalArgumentException e) {
            System.out.println("   [OK] Validation caught error: " + e.getMessage());
        }
        System.out.println();
        
        // Show the fluent Builder API
        System.out.println("6. Fluent Builder API:");
        UserProfile fluentProfile = UserProfile.builder()
                .id("fluent123")
                .email("fluent@example.com")
                .phone("555-9999")
                .displayName("Fluent User")
                .build();
        System.out.println("   Created with fluent API: " + fluentProfile);
        System.out.println();
        
        System.out.println("=== Key Benefits of Immutability ===");
        System.out.println("[+] Thread-safe - can be shared between threads without synchronization");
        System.out.println("[+] Bug-resistant - can't accidentally change data after creation");
        System.out.println("[+] Predictable - object state never changes during its lifetime");
        System.out.println("[+] Cacheable - can be safely cached and reused");
        System.out.println("[+] Builder pattern - clean, readable object construction");
    }
}
