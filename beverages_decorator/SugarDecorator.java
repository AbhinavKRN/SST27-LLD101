package beverages_decorator;

/**
 * Concrete decorator that adds sugar to any beverage.
 */
public class SugarDecorator extends BeverageDecorator {
    
    public SugarDecorator(Beverage beverage) {
        super(beverage);
    }
    
    @Override
    public int cost() {
        return beverage.cost() + 2; 
    }
    
    @Override
    public String getDescription() {
        return beverage.getDescription() + " + Sugar";
    }
}
