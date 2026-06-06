package payment_system;

import main.Beverage;
import java.util.List;

public class Menu {

    public static final List<Beverage> MENU = List.of(

            new Beverage(100, "Black Coffee"),
            new Beverage(100, "Black Coffee Weak"),
            new Beverage(150, "Espresso"),
            new Beverage(150, "Nescafe"),
            new Beverage(200, "Nescafe & Milk"),
            new Beverage(200, "Cappuccino"),
            new Beverage(100, "Lemon Tea"),
            new Beverage(100, "Peach Tea"),
            new Beverage(200, "Chocolate"),
            new Beverage(250, "Double Chocolate"),
            new Beverage(250, "Milk Chocolate"),
            new Beverage(50,"Empty cup")
    );
}