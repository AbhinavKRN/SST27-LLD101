package com.example.orders;

import java.util.List;

public class OrderService {

    public Order createOrder(String id, String email, List<OrderLine> lines, Integer discount, boolean expedited, String notes) {
        // Using the builder pattern - much cleaner than the old way!
        Order.Builder builder = new Order.Builder(id, email);
        
        if (lines != null) {
            builder.addLines(lines);
        }
        
        if (discount != null) {
            builder.discountPercent(discount);
        }
        
        if (expedited) {
            builder.expedited(true);
        }
        
        if (notes != null && !notes.trim().isEmpty()) {
            builder.notes(notes);
        }
        
        return builder.build();
    }
    
    public Order createSimpleOrder(String id, String email, List<OrderLine> lines) {
        return new Order.Builder(id, email)
            .addLines(lines)
            .build();
    }
}
