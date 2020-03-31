package sword_offer;

/**
 * @author yibozhang
 * @date 2020/3/31 19:13
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 * <p>
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 * <p>
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 */
public class Exist {

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        char[] chs = word.toCharArray();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, i, j, chs, 0, new boolean[m][n])) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, char[] chs, int index, boolean[][] visited) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != chs[index])
            return false;
        if (index == chs.length - 1) return true;
        visited[i][j] = true;
        boolean result = dfs(board, i - 1, j, chs, index + 1, visited)
                || dfs(board, i + 1, j, chs, index + 1, visited)
                || dfs(board, i, j - 1, chs, index + 1, visited)
                || dfs(board, i, j + 1, chs, index + 1, visited);
        visited[i][j] = false;
        return result;
    }

    public static void main(String[] args) {
        new Exist().exist(new char[][]{{'a'}}, "b");
    }

}
