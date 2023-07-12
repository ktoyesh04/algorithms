import java.util.Arrays;

public class knapsack10 {
    public static void main(String[] args) {
        int maxWeight = 6, itemCount = 3;
        int[] weights = {1, 2, 3};
        int[] values = {10, 15, 40};
        int[][] dp = new int[itemCount + 1][maxWeight + 1];

        for (int i = 1; i <= itemCount; i++) {
            int weight = weights[i - 1];
            int value = values[i - 1];

            for (int w = 1; w <= maxWeight; w++) {
                if (weight <= w) 
                    dp[i][w] = Math.max(dp[i - 1][w], value + dp[i - 1][w - weight]);
                else // if(weight > w)
                    dp[i][w] = dp[i - 1][w];
            }
        }

        int[] selectedItems = new int[itemCount];
        int i = itemCount;
        int j = maxWeight;

        while (i > 0 && j > 0) {
            if (dp[i][j] != dp[i - 1][j]) {
                selectedItems[i - 1] = 1;
                j -= weights[i - 1];
            }
            i--;
        }
        System.out.println(Arrays.toString(selectedItems));
    }
}