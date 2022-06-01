package ShoppingList;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class ShoppingListCSV {
    private Path file;

    public ShoppingListCSV(Path file) {
        this.file = file;
    }

    public ShoppingList loadList() throws IOException {
        LinkedHashMap<Item, Double> map = new LinkedHashMap<>();

        List<String> lines = Files.readAllLines(file);
        for (String line : lines) {
            String[] fields = line.split(",[ ]*");
            System.out.println(Arrays.asList(fields));
            Item item = new Item(fields[0], Item.Unit.valueOf(fields[1].toUpperCase()));
            map.put(item, Double.parseDouble(fields[2]));
        }

        return new ShoppingList(map);
    }
    public void saveList(ShoppingList myList) {
        List<String> lines = new ArrayList<>();
        for (Map.Entry<Item, Double> entry : myList.getItems().entrySet()) {
            Item item = entry.getKey();
            Double quantity = entry.getValue();
            String line = item.getName() + ", " + item.getUnit().name().toLowerCase() + ", " + quantity;
            lines.add(line);
        }
        try {
            Files.write(file, lines, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}