
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MapInventory {

    public static int getProductPrice(Map<String, Integer> inventory, String productId) {
        if (inventory != null && inventory.containsKey(productId)) {
            return inventory.get(productId);
        }
        return -1;
    }

    public static List<String> getProductIdsByPrice(Map<String, Integer> inventory, int price) {
        List<String> l = new ArrayList<>();
        if (inventory == null) {
            return l;
        }

       for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            if (entry.getValue() == price) {
                l.add(entry.getKey());
            }
        }

        return l;
    }
}
