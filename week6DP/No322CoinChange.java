package DPMedium;

import java.util.Arrays;

public class No322CoinChange {

	public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        
        Arrays.sort(coins);
        int[] res = new int[amount + 1];
        
        for (int i = coins[0]; i <= amount; i++) {
            for (int coin : coins) {
                
                if (coin > i) break;
                
                if (coin == i) {
                    res[i] = 1;
                    break;
                }
                
                if (res[i - coin] == 0) continue;
                
                int candidate = res[i - coin] +1;
                if (candidate < res[i] || res[i] == 0){
                    res[i] = candidate;
                }
                
            }
        }
        if (res[amount] == 0) return -1;
        return res[amount];
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
