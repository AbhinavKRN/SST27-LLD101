package beverages_decorator;

/**
 * Base decorator class for beverages.
 * This allows adding features like milk, sugar, whip cream to any beverage.
 */
public abstract class BeverageDecorator extends Beverage {
    protected Beverage beverage;
    
    public BeverageDecorator(Beverage beverage) {
        this.beverage = beverage;
    }
    
    @Override
    public abstract int cost();
    
    @Override
    public abstract String getDescription();
}
