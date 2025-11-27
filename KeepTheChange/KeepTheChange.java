
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class KeepTheChange {

    public static List<Integer> computeChange(int amount, Set<Integer> coins) {
        List<Integer> result = new ArrayList<>();
        List<Integer> sortedCoins = new ArrayList<>(coins);
        sortedCoins.sort(Collections.reverseOrder());

        for (int coin : sortedCoins) {
            while (amount >= coin) {
                amount -= coin;
                result.add(coin);
            }
        }

        if (amount != 0) {
            return new ArrayList<>();
        }

        return result;
    }
}
