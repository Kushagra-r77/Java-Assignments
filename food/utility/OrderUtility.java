package food.utility;
import food.model.FoodOrder;
import food.service.Discountable;

public class OrderUtility {
    
    public static boolean validateAmount(double amount) {
        return amount > 0;
    }

    public static boolean validateCustomerName(String name) {
        return name != null && !name.trim().isEmpty();
    }

    public static void generateOrderSummary(FoodOrder order) {
        if (!validateAmount(order.getAmount()) || !validateCustomerName(order.getCustomerName())) {
            System.out.println("Invalid order details for Order ID: " + order.getOrderId());
            return;
        }

        double discount = 0.0;
        if (order instanceof Discountable) {
            discount = ((Discountable) order).applyDiscount();
        }
        
        double deliveryCharge = order.calculateDeliveryCharge();
        double finalAmount = (order.getAmount() - discount) + deliveryCharge;

        System.out.println("------------------------------------------------");
        System.out.println("Restaurant: " + FoodOrder.getRestaurantName());
        System.out.println("Order ID: " + order.getOrderId());
        System.out.println("Customer Name: " + order.getCustomerName());
        System.out.println("Bill Amount: Rs. " + order.getAmount());
        System.out.println("Discount Applied: Rs. " + discount);
        System.out.println("Delivery Charge: Rs. " + deliveryCharge);
        System.out.println("Final Payable Amount: Rs. " + finalAmount);
        System.out.println("------------------------------------------------");
    }
}