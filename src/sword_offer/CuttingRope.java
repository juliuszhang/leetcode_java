package sword_offer;

/**
 * @author yibozhang
 * @date 2020/3/31 20:23
 */
public class CuttingRope {

    public int cuttingRope(int n) {
        if (n == 0) return 0;
        if (n <= 2) return 1;
        if (n == 3) return 2;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] * dp[j]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int i = new CuttingRope().cuttingRope(5);
        System.out.println(i);
    }

}
