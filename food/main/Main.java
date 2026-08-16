package food.main;

import food.model.FoodOrder;
import food.model.PremiumOrder;
import food.model.RegularOrder;
import food.utility.OrderUtility;

public class Main {
    public static void main(String[] args) {
        
        FoodOrder[] orders = new FoodOrder[6];
        
        orders[0] = new RegularOrder("ORD101", "AB", 500.0);
        orders[1] = new PremiumOrder("ORD102", "CD", 1200.0);
        orders[2] = new RegularOrder("ORD103", "EF", 350.0);
        orders[3] = new PremiumOrder("ORD104", "GH", 850.0);
        orders[4] = new RegularOrder("ORD105", "IJ", 420.0);
        orders[5] = new PremiumOrder("ORD106", "KL", 1500.0);
        
        for (FoodOrder order : orders) {
            OrderUtility.generateOrderSummary(order);
        }
        
        System.out.println("\n*** Final Report ***");
        FoodOrder.displayTotalOrders();
    }
}