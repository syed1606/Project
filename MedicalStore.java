import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class MedicalStore {
    private Map<String, Integer> inventory;

    public MedicalStore() {
        inventory = new HashMap<>();
    }

    public void addItem(String item, int quantity) {
        inventory.put(item, quantity);
    }

    public void sellItem(String item, int quantity) {
        if (inventory.containsKey(item)) {
            int availableQuantity = inventory.get(item);
            if (availableQuantity >= quantity) {
                inventory.put(item, availableQuantity - quantity);
                System.out.println("Sold " + quantity + " " + item);
            } else {
                System.out.println("Insufficient quantity of " + item);
            }
        } else {
            System.out.println(item + " not found in inventory");
        }
    }

    public void displayInventory() {
        System.out.println("Inventory:");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MedicalStore store = new MedicalStore();

        store.addItem("Aspirin", 100);
        store.addItem("Bandage", 50);
        store.addItem("Antibiotic", 30);

        int choice;
        do {
            System.out.println("\n1. Sell Item\n2. Display Inventory\n3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String item = scanner.next();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    store.sellItem(item, quantity);
                    break;
                case 2:
                    store.displayInventory();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 3);

        scanner.close();
    }
}
