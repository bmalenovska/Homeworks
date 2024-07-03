import java.util.List;
import java.util.Scanner;

public class Main {
    private static CheeseShop cheeseShop = new CheeseShop();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        
        cheeseShop.addCheese(new Cheese("Swiss", 5.95));
        cheeseShop.addCheese(new Cheese("Blue", 4.89));
        cheeseShop.addCheese(new Cheese("Goat", 7.60));

        boolean exit = false;
        while (!exit) {
            System.out.println("\nWelcome to the Cheese Shop!");
            System.out.println("1. Display Available Cheeses");
            System.out.println("2. Add Cheese to Cart");
            System.out.println("3. Remove Cheese from Cart");
            System.out.println("4. Display Cart");
            System.out.println("5. Exit");

            
            int choice = readIntegerInput();

            switch (choice) {
                case 1:
                    displayAvailableCheeses();
                    break;
                case 2:
                    addCheeseToCart();
                    break;
                case 3:
                    removeCheeseFromCart();
                    break;
                case 4:
                    displayCart();
                    break;
                case 5:
                    exit = true;
                    System.out.println("Thank you for shopping with us!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 5.");
                    break;
            }
        }
        scanner.close();
    }

    private static int readIntegerInput() {
        while (true) {
            System.out.print("Enter your choice: ");
            try {
                
                if (scanner.hasNextInt()) {
                    return scanner.nextInt();
                } else {
                    
                    scanner.nextLine(); 
                    System.out.println("Invalid input. Please enter a number.");
                }
            } catch (Exception e) {
                
                System.out.println("Error reading input. Please try again.");
                scanner.nextLine(); 
            }
        }
    }

    private static void displayAvailableCheeses() {
        List<Cheese> cheeses = cheeseShop.getAllCheeses();
        System.out.println("\nAvailable Cheeses:");
        for (Cheese cheese : cheeses) {
            System.out.println(cheese.getInfo());
        }
    }

    private static void addCheeseToCart() {
        System.out.println("\nEnter the name of the cheese to add to cart:");
        String cheeseName = scanner.nextLine();

        List<Cheese> cheeses = cheeseShop.getAllCheeses();
        Cheese foundCheese = null;
        for (Cheese cheese : cheeses) {
            if (cheese.getName().equalsIgnoreCase(cheeseName)) {
                foundCheese = cheese;
                break;
            }
        }

        if (foundCheese != null) {
            cheeseShop.addToCart(foundCheese);
            System.out.println(foundCheese.getName() + " added to cart.");
        } else {
            System.out.println("Cheese not found in the shop.");
        }
    }

    private static void removeCheeseFromCart() {
        System.out.println("\nEnter the name of the cheese to remove from cart:");
        String cheeseName = scanner.nextLine();

        List<Cheese> cart = cheeseShop.getCart();
        Cheese foundCheese = null;
        for (Cheese cheese : cart) {
            if (cheese.getName().equalsIgnoreCase(cheeseName)) {
                foundCheese = cheese;
                break;
            }
        }

        if (foundCheese != null) {
            cheeseShop.removeFromCart(foundCheese);
            System.out.println(foundCheese.getName() + " removed from cart.");
        } else {
            System.out.println("Cheese not found in the cart.");
        }
    }

    private static void displayCart() {
        List<Cheese> cart = cheeseShop.getCart();
        System.out.println("\nYour Cart:");
        for (Cheese cheese : cart) {
            System.out.println(cheese.getInfo());
        }
    }
}
