import java.util.ArrayList;
import java.util.List;

/**
 * @author yibozhang
 * @date 2020/3/30 19:06
 * N皇后问题
 */
public class NQueen {

    public List<List<String>> solveNQueens(int n) {
        int[] table = new int[n];
        List<List<String>> ans = new ArrayList<>();
        backtrace(table, n, 0, ans);
        return ans;
    }

    private void backtrace(int[] table, int n, int i, List<List<String>> ans) {
        if (i == n) {
            List<String> solve = new ArrayList<>();
            for (int col : table) {
                StringBuilder line = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (j == col) {
                        line.append("Q");
                    } else {
                        line.append(".");
                    }
                }
                solve.add(line.toString());
            }
            ans.add(solve);
            return;
        }
        for (int j = 0; j < n; j++) {
            table[i] = j;
            if (judge(table, i, j)) {
                backtrace(table, n, i + 1, ans);
            }
            table[i] = 0;
        }
    }

    private boolean judge(int[] table, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (table[k] == j || i - k == Math.abs(j - table[k])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> lists = new NQueen().solveNQueens(4);
        System.out.println(lists);
    }

}
