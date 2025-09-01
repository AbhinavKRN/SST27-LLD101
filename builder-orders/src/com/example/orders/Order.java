package com.example.orders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Telescoping constructors + setters. Allows invalid states.
 */
public final class Order {
    private final String id;
    private final String customerEmail;
    private final List<OrderLine> lines;
    private final Integer discountPercent;
    private final boolean expedited;
    private final String notes;
    
    private Order(String id, String customerEmail, List<OrderLine> lines, 
                  Integer discountPercent, boolean expedited, String notes) {
        this.id = id;
        this.customerEmail = customerEmail;
        this.lines = new ArrayList<>(lines); 
        this.discountPercent = discountPercent;
        this.expedited = expedited;
        this.notes = notes;
    }
    
    public String getId() { return id; }
    public String getCustomerEmail() { return customerEmail; }
    public List<OrderLine> getLines() { 
        return Collections.unmodifiableList(lines); 
    }
    public Integer getDiscountPercent() { return discountPercent; }
    public boolean isExpedited() { return expedited; }
    public String getNotes() { return notes; }
        public int totalBeforeDiscount() {
        return lines.stream()
                   .mapToInt(line -> line.getQuantity() * line.getUnitPriceCents())
                   .sum();
    }
    
    public int totalAfterDiscount() {
        int base = totalBeforeDiscount();
        if (discountPercent == null || discountPercent == 0) {
            return base;
        }
        return base - (base * discountPercent / 100);
    }
    
    @Override
    public String toString() {
        return String.format("Order{id='%s', customer='%s', lines=%d, total=%d, discount=%d%%}",
                           id, customerEmail, lines.size(), totalAfterDiscount(), 
                           discountPercent != null ? discountPercent : 0);
    }
    
    /**
     * Builder class for creating Order instances.
     * 
     * This pattern gives us:
     * - Fluent API (method chaining)
     * - Validation in one place (build method)
     * - Clear required vs optional parameters
     */
    public static class Builder {
        private String id;
        private String customerEmail;
        private final List<OrderLine> lines = new ArrayList<>();
        private Integer discountPercent;
        private boolean expedited;
        private String notes;
        
        public Builder(String id, String customerEmail) {
            this.id = Objects.requireNonNull(id, "Order ID cannot be null");
            this.customerEmail = Objects.requireNonNull(customerEmail, "Customer email cannot be null");
        }
        
        public Builder addLine(OrderLine line) {
            lines.add(Objects.requireNonNull(line, "Order line cannot be null"));
            return this;
        }
        
        public Builder addLines(List<OrderLine> lines) {
            if (lines != null) {
                lines.forEach(this::addLine);
            }
            return this;
        }
        
        public Builder discountPercent(Integer discount) {
            this.discountPercent = discount;
            return this;
        }
        
        public Builder expedited(boolean expedited) {
            this.expedited = expedited;
            return this;
        }
        
        public Builder notes(String notes) {
            this.notes = notes;
            return this;
        }
        
        /**
         * Builds the Order with validation.
         * 
         * This is where all the business rules are enforced:
         * - Must have at least one order line
         * - Email must be valid format
         * - Discount must be 0-100%
         */
        public Order build() {
            if (id.trim().isEmpty()) {
                throw new IllegalArgumentException("Order ID cannot be empty");
            }
            
            if (lines.isEmpty()) {
                throw new IllegalArgumentException("Order must have at least one line");
            }
            
            if (!isValidEmail(customerEmail)) {
                throw new IllegalArgumentException("Invalid email format: " + customerEmail);
            }
            
            if (discountPercent != null && (discountPercent < 0 || discountPercent > 100)) {
                throw new IllegalArgumentException("Discount must be between 0 and 100, got: " + discountPercent);
            }
            
            return new Order(id, customerEmail, lines, discountPercent, expedited, notes);
        }
        
        private boolean isValidEmail(String email) {
            String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
            return Pattern.matches(emailRegex, email);
        }
    }
}
