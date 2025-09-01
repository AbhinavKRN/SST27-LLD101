package com.example.orders;


public final class OrderLine {
    private final String sku;
    private final int quantity;
    private final int unitPriceCents;

    public OrderLine(String sku, int quantity, int unitPriceCents) {
        this.sku = sku;
        this.quantity = quantity;
        this.unitPriceCents = unitPriceCents;
    }

    public String getSku() { return sku; }
    public int getQuantity() { return quantity; }
    public int getUnitPriceCents() { return unitPriceCents; }
    
    
    @Override
    public String toString() {
        return String.format("OrderLine{sku='%s', qty=%d, price=%d¢}", sku, quantity, unitPriceCents);
    }
}
