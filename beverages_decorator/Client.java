package beverages_decorator;

public class Client {

	public static void main(String[] args) {
		System.out.println("=== Beverage Decorator Pattern Demo ===\n");
		
		// Basic beverages
		Beverage cappuccino = new Cappuccino();
		System.out.println(cappuccino.getDescription() + " - Cost: $" + cappuccino.cost());
		
		Beverage latte = new Latte();
		System.out.println(latte.getDescription() + " - Cost: $" + latte.cost());
		
		System.out.println("\n=== Adding Decorators ===\n");
		
		// Cappuccino with milk
		Beverage cappuccinoWithMilk = new MilkDecorator(new Cappuccino());
		System.out.println(cappuccinoWithMilk.getDescription() + " - Cost: $" + cappuccinoWithMilk.cost());
		
		// Latte with sugar and milk
		Beverage latteWithSugarAndMilk = new SugarDecorator(new MilkDecorator(new Latte()));
		System.out.println(latteWithSugarAndMilk.getDescription() + " - Cost: $" + latteWithSugarAndMilk.cost());
		
		// Cappuccino with multiple decorators
		Beverage fancyCappuccino = new WhipCreamDecorator(
			new VanillaDecorator(
				new MilkDecorator(
					new SugarDecorator(new Cappuccino())
				)
			)
		);
		System.out.println(fancyCappuccino.getDescription() + " - Cost: $" + fancyCappuccino.cost());
		
		// Latte with whip cream and vanilla
		Beverage premiumLatte = new VanillaDecorator(new WhipCreamDecorator(new Latte()));
		System.out.println(premiumLatte.getDescription() + " - Cost: $" + premiumLatte.cost());
		
		System.out.println("\n=== Cost Breakdown ===");
		System.out.println("Base Cappuccino: $10");
		System.out.println("+ Sugar: $2");
		System.out.println("+ Milk: $5");
		System.out.println("+ Vanilla: $3");
		System.out.println("+ Whip Cream: $8");
		System.out.println("Total: $" + fancyCappuccino.cost());
	}
}