import java.util.ArrayList;
import java.util.List;

public class ChangeCalculator {


    public int[] getChange(int[] coinDenominations, int change, int[] minimumCoins, int[] coinsUsed) throws IllegalArgumentException {
        if (coinDenominations.length == 0)
            throw new IllegalArgumentException("Invalid coin array.");
        for (int coins = 0; coins <= change; coins++) {
            int coinCount = coins;
            int newCoin = 1;
            for (int c : coinDenominations) {
                if (c <= coins) {
                    if (minimumCoins[coins - c] + 1 < coinCount) {
                        coinCount = minimumCoins[coins - c] + 1;
                        newCoin = c;
                    }
                }
            }
            minimumCoins[coins] = coinCount;
            coinsUsed[coins] = newCoin;
        }
        return minimumCoins;
    }

    public int[] getChangeArray(int[] coinsUsed, int change) {
        List<Integer> coinsList = new ArrayList<>();
        int coin = change;
        while (coin > 0) {
            int currCoin = coinsUsed[coin];
            coinsList.add(currCoin);
            coin -= currCoin;
        }
        int[] result = coinsList.stream().mapToInt(i -> i).toArray();
        return result;
    }
}