package ShoppingList;

import java.util.Map;

        /**
         * This class manages a list of items by adding, updating and removing them from the list.
         */

public class ShoppingList {

    // The Map allows storing unique keys with corresponding values. The key is the item, the value is the quantity.
    private Map<Item, Double> items;

    public ShoppingList(Map<Item, Double> items) {
        this.items = items;
    }

    public Map<Item, Double> getItems() {
        return items;
    }

    public boolean addItem(Item newItem, Double quantity) {

        if (items.containsKey(newItem)) {
            return false;
        }

        try {
            items.put(newItem, quantity);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public boolean updateItem(Item item, Double newQuantity) {
        if (!items.containsKey(item)) {
            return false;
        }

        try {
            items.put(item, newQuantity);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public boolean removeItem(Item item) {
        if (!items.containsKey(item)) {
            return false;
        }

        try {
            items.remove(item);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        if (items.entrySet().isEmpty()) {
            return "The shopping list is empty.";
        }
        String shoppingList = "";
        for (Map.Entry<Item, Double> listEntry :
                items.entrySet()) {
            shoppingList += listEntry.getKey().getName()
                    + " " + listEntry.getValue()
                    + " " + listEntry.getKey().getUnit().name().toLowerCase() +"\n";
        }
        return shoppingList;
    }
}