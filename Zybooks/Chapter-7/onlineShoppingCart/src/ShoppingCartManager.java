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
        System.out.print("Today's date: " + currentDate);

        ShoppingCart cart = new ShoppingCart(customerName, currentDate);

        System.out.println();

        char userChoice;
        do {
            printMenu();
            userChoice = scnr.nextLine().charAt(0);
            executeMenu(userChoice, cart, scnr);
        } while (userChoice != 'q');

    }

    public static void printMenu() {
        System.out.println();
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
                break;
            default:
                System.out.println("Choose an option:");
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
        System.out.println("Enter name of item to remove:");
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
