import java.util.Arrays;

class OptimalBinarySearchTree {
    static void optimalBST(int freq[]) {
        int n = freq.length;
        int[][] cost = new int[n + 1][n + 1];
        int[][] root = new int[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            cost[i][i] = freq[i];
            root[i][i] = i;
        }

        for (int length = 2; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;
                cost[i][j] = Integer.MAX_VALUE;

                int sum = Arrays.stream(freq, i, j+1).sum();
                for (int k = i; k <= j; k++) {
                    int temp = sum + ((k > i) ? cost[i][k - 1] : 0) + ((k < j) ? cost[k + 1][j] : 0);
                    if (temp < cost[i][j]) {
                        cost[i][j] = temp;
                        root[i][j] = k;
                    }
                }
            }
        }
        System.out.println("Minimum Cost: " + cost[0][n - 1]);
    }

    public static void main(String[] args) {
        int freq[] = {6, 4, 2, 2};
        optimalBST(freq);
    }
}