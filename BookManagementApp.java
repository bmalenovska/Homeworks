import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> books = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nBook Management Application");
            System.out.println("Choose an option (1/2/3/4): ");
            System.out.println("1. Add Books");
            System.out.println("2. Remove Books");
            System.out.println("3. View All Books");
            System.out.println("4. Exit");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid choice. Please enter a number (1/2/3/4)");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter the name of the book you want to add: ");
                String bookName = scanner.nextLine();
                books.add(bookName);
                System.out.println("Book added: " + bookName);
            } else if (choice == 2) {
                System.out.print("Enter the name of the book you want to remove: ");
                String bookName = scanner.nextLine();
                if (books.remove(bookName)) {
                    System.out.println("Book removed: " + bookName);
                } else {
                    System.out.println("Book name not found: " + bookName);
                }
            } else if (choice == 3) {
                System.out.println("Books added:");
                for (String book : books) {
                    System.out.println(book);
                }
            } else if (choice == 4) {
                System.out.println("Thank you for using our service!");
                break;
            } else {
                System.out.println("Invalid choice. Please enter a number (1/2/3/4).");
            }
        }

        scanner.close();
    }
}
