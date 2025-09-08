package beverages_decorator;

/**
 * Concrete decorator that adds vanilla flavor to any beverage.
 */
public class VanillaDecorator extends BeverageDecorator {
    
    public VanillaDecorator(Beverage beverage) {
        super(beverage);
    }
    
    @Override
    public int cost() {
        return beverage.cost() + 3; 
    }
    
    @Override
    public String getDescription() {
        return beverage.getDescription() + " + Vanilla";
    }
}
