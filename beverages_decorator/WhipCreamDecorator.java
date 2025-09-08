package beverages_decorator;

/**
 * Concrete decorator that adds whip cream to any beverage.
 */
public class WhipCreamDecorator extends BeverageDecorator {
    
    public WhipCreamDecorator(Beverage beverage) {
        super(beverage);
    }
    
    @Override
    public int cost() {
        return beverage.cost() + 8; 
    }
    
    @Override
    public String getDescription() {
        return beverage.getDescription() + " + Whip Cream";
    }
}
