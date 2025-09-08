package beverages_decorator;

/**
 * Concrete decorator that adds milk to any beverage.
 */
public class MilkDecorator extends BeverageDecorator {
    
    public MilkDecorator(Beverage beverage) {
        super(beverage);
    }
    
    @Override
    public int cost() {
        return beverage.cost() + 5; 
    }
    
    @Override
    public String getDescription() {
        return beverage.getDescription() + " + Milk";
    }
}
