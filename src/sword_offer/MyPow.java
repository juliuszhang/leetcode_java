package sword_offer;

/**
 * @author yibozhang
 * @date 2020/3/31 22:16
 */
public class MyPow {

    public double myPow(double x, int n) {
        if (n == 0) return 1.0;
        double ans = 1.0;
        boolean negative = false;
        if (n < 0) {
            negative = true;
        } else {
            n = 0 - n;
        }

        for (int i = n; i < -1; i /= 2) {
            if (i % 2 == -1) {
                ans *= x;
                i++;
            }
            x *= x;
        }
        return negative ? 1 / (ans * x) : 0 - ans * x;
    }

    public static void main(String[] args) {
        double v = new MyPow().myPow(2, 2);
        System.out.println(v);
    }

}
