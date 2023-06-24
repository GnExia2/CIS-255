import java.util.Scanner;

public class ShoppingCartManager {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        System.out.println("Enter customer's name:");
        String customerName = scnr.nextLine();

        System.out.println("Enter today's date:");
        String currentDate = scnr.nextLine();
        System.out.println();

        System.out.println("Customer name: " + customerName);
        System.out.println("Today's date: " + currentDate);

        ShoppingCart cart = new ShoppingCart(customerName, currentDate);

        System.out.println();
        printMenu();

        char userChoice;
        do {
            userChoice = scnr.nextLine().charAt(0);
            executeMenu(userChoice, cart, scnr);
            System.out.println();
            printMenu();
        } while (userChoice != 'q');
    }

    public static void printMenu() {
        System.out.println("MENU");
        System.out.println("a - Add item to cart");
        System.out.println("d - Remove item from cart");
        System.out.println("c - Change item quantity");
        System.out.println("i - Output items' descriptions");
        System.out.println("o - Output shopping cart");
        System.out.println("q - Quit");
        System.out.println();
        System.out.println("Choose an option:");
    }

    public static void executeMenu(char userChoice, ShoppingCart cart, Scanner scnr) {
        switch (userChoice) {
            case 'a':
                addItemToCart(cart, scnr);
                break;
            case 'd':
                removeItemFromCart(cart, scnr);
                break;
            case 'c':
                changeItemQuantity(cart, scnr);
                break;
            case 'i':
                cart.printDescriptions();
                break;
            case 'o':
                cart.printTotal();
                break;
            case 'q':
                System.out.println("Program terminating...");
                break;
            default:
                System.out.println("Invalid menu option. Please try again.");
        }
    }

    public static void addItemToCart(ShoppingCart cart, Scanner scnr) {
        System.out.println("ADD ITEM TO CART");
        System.out.println("Enter the item name:");
        String itemName = scnr.nextLine();

        System.out.println("Enter the item description:");
        String itemDescription = scnr.nextLine();

        System.out.println("Enter the item price:");
        int itemPrice = scnr.nextInt();

        System.out.println("Enter the item quantity:");
        int itemQuantity = scnr.nextInt();
        scnr.nextLine(); // Consume the newline character

        ItemToPurchase newItem = new ItemToPurchase(itemName, itemDescription, itemPrice, itemQuantity);
        cart.addItem(newItem);
    }

    public static void removeItemFromCart(ShoppingCart cart, Scanner scnr) {
        System.out.println("REMOVE ITEM FROM CART");
        System.out.println("Enter the name of the item to remove:");
        String itemName = scnr.nextLine();
        cart.removeItem(itemName);
    }

    public static void changeItemQuantity(ShoppingCart cart, Scanner scnr) {
        System.out.println("CHANGE ITEM QUANTITY");
        System.out.println("Enter the item name:");
        String itemName = scnr.nextLine();

        System.out.println("Enter the new quantity:");
        int newQuantity = scnr.nextInt();
        scnr.nextLine(); // Consume the newline character

        ItemToPurchase modifiedItem = new ItemToPurchase(itemName, "none", 0, newQuantity);
        cart.modifyItem(modifiedItem);
    }
}

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
                if (!modifiedItem.getDescription().equals("none")) {
                    item.setDescription(modifiedItem.getDescription());
                }
                if (modifiedItem.getPrice() != 0) {
                    item.setPrice(modifiedItem.getPrice());
                }
                if (modifiedItem.getQuantity() != 0) {
                    item.setQuantity(modifiedItem.getQuantity());
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
            numItems += item.getQuantity();
        }
        return numItems;
    }

    public int getCostOfCart() {
        int totalCost = 0;
        for (ItemToPurchase item : cartItems) {
            totalCost += item.getItemPrice() * item.getQuantity();
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

public class ItemToPurchase {
    private String itemName;
    private String itemDescription;
    private int itemPrice;
    private int itemQuantity;

    public ItemToPurchase() {
        this.itemDescription = "none";
    }

    public ItemToPurchase(String itemName, String itemDescription, int itemPrice, int itemQuantity) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemPrice = itemPrice;
        this.itemQuantity = itemQuantity;
    }

    public void setDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getDescription() {
        return itemDescription;
    }

    public void printItemCost() {
        System.out.println(itemName + " " + itemQuantity + " @ $" + itemPrice + " = $" + (itemPrice * itemQuantity));
    }

    public void printItemDescription() {
        System.out.println(itemName + ": " + itemDescription);
    }
}
