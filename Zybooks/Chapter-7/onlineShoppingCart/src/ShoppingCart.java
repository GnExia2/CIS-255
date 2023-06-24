import java.util.ArrayList;

public class ShoppingCart {
    private String customerName;
    private String currentDate;
    private ArrayList<ItemToPurchase> cartItems;

    public ShoppingCart() {
        customerName = "none";
        currentDate = "January 1, 2016";
        cartItems = new ArrayList<>();
    }

    public ShoppingCart(String customerName, String currentDate) {
        this.customerName = customerName;
        this.currentDate = currentDate;
        cartItems = new ArrayList<>();
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getDate() {
        return currentDate;
    }

    public void addItem(ItemToPurchase item) {
        cartItems.add(item);
    }

    public void removeItem(String itemName) {
        boolean itemFound = false;
        for (ItemToPurchase item : cartItems) {
            if (item.getItemName().equals(itemName)) {
                cartItems.remove(item);
                itemFound = true;
                break;
            }
        }
        if (!itemFound) {
            System.out.println("Item not found in cart. Nothing removed.");
        }
    }

    public void modifyItem(ItemToPurchase modifiedItem) {
        boolean itemFound = false;
        for (ItemToPurchase item : cartItems) {
            if (item.getItemName().equals(modifiedItem.getItemName())) {
                if (!modifiedItem.getItemDescription().equals("none")) {
                    item.setItemDescription(modifiedItem.getItemDescription());
                }
                if (modifiedItem.getItemPrice() != 0) {
                    item.setItemPrice(modifiedItem.getItemPrice());
                }
                if (modifiedItem.getItemQuantity() != 0) {
                    item.setItemQuantity(modifiedItem.getItemQuantity());
                }
                itemFound = true;
                break;
            }
        }
        if (!itemFound) {
            System.out.println("Item not found in cart. Nothing modified.");
        }
    }

    public int getNumItemsInCart() {
        int numItems = 0;
        for (ItemToPurchase item : cartItems) {
            numItems += item.getItemQuantity();
        }
        return numItems;
    }

    public int getCostOfCart() {
        int totalCost = 0;
        for (ItemToPurchase item : cartItems) {
            totalCost += item.getItemPrice() * item.getItemQuantity();
        }
        return totalCost;
    }

    public void printTotal() {
        System.out.println("OUTPUT SHOPPING CART");
        System.out.println(customerName + "'s Shopping Cart - " + currentDate);
        System.out.println("Number of Items: " + getNumItemsInCart());
        System.out.println();
        if (cartItems.isEmpty()) {
            System.out.println("SHOPPING CART IS EMPTY");
        } else {
            for (ItemToPurchase item : cartItems) {
                item.printItemCost();
            }
        }
        System.out.println();
        System.out.println("Total: $" + getCostOfCart());
    }

    public void printDescriptions() {
        System.out.println("OUTPUT ITEMS' DESCRIPTIONS");
        System.out.println(customerName + "'s Shopping Cart - " + currentDate);
        System.out.println();
        System.out.println("Item Descriptions");
        if (cartItems.isEmpty()) {
            System.out.println("SHOPPING CART IS EMPTY");
        } else {
            for (ItemToPurchase item : cartItems) {
                item.printItemDescription();
            }
        }
    }
}