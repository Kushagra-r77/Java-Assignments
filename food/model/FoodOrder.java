package food.model;

public abstract class FoodOrder {
    private String orderId;
    private String customerName;
    private double amount;
    private static String restaurantName = "Food Express";
    private static int totalOrders = 0;

    public FoodOrder(String orderId, String customerName, double amount) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.amount = amount;
        totalOrders++;
    }

    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }
    
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    
    public static String getRestaurantName() { return restaurantName; }
    public static void setRestaurantName(String name) { restaurantName = name; }

    public static void displayTotalOrders() {
        System.out.println("Total Orders Placed: " + totalOrders);
    }

    public abstract double calculateDeliveryCharge();
}