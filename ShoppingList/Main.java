package ShoppingList;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ShoppingListCSV csv = new ShoppingListCSV(Paths.get("C:\\Users\\Mihaela\\SDA - Java RO23\\Java-Advanced Features Coding\\src\\ShoppingList/shopping_list.csv"));
        ShoppingList myList = null;
        try {
            myList = csv.loadList();
        } catch (IOException e) {
            System.out.println("Error loading list from file!");
            return;
        }
        int option;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println();
            System.out.println("YOUR SHOPPING LIST:");
            System.out.println(myList.toString());
            System.out.println();
            System.out.println("1 -> Add item");
            System.out.println("2 -> Update item");
            System.out.println("3 -> Remove item");
            System.out.println("4 -> Exit");
            System.out.println();

            System.out.print("Choose operation: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Item name: ");
                    String name = scanner.next();
                    System.out.println("Item unit (0->PCS 1->KG 2->GR 3->L 4->M):");
                    int unit_index = scanner.nextInt();
                    Item.Unit unit = Item.Unit.values()[unit_index];
                    System.out.println("Quantity");
                    double quantity = scanner.nextDouble();
                    if (myList.addItem(new Item(name, unit), quantity)) {
                        System.out.println("Item added successfully!");
                    } else {
                        System.out.println("Error adding item!");
                    }
                    break;
                case 2:
                    System.out.println("Item name: ");
                    String nameForUpdate = scanner.next();
                    System.out.println("Quantity");
                    double quantityForUpdate = scanner.nextDouble();
                    if (myList.updateItem(new Item(nameForUpdate), quantityForUpdate)) {
                        System.out.println("Item update successfully!");
                    } else {
                        System.out.println("Error updating item: item might not be in the list!");
                    }
                    break;
                case 3:
                    System.out.println("Item name: ");
                    String nameForRemove = scanner.next();
                    if (myList.removeItem(new Item(nameForRemove))) {
                        System.out.println("Item removed successfully!");
                    } else {
                        System.out.println("Error removing item: item might not be in the list!");
                    }
                    break;
                case 4:
                    csv.saveList(myList);
                    break;
                default:
                    System.out.println("Invalid option!");
            }

        } while (option != 4);

    }
}