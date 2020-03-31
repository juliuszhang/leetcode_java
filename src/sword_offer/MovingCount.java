package sword_offer;

/**
 * @author yibozhang
 * @date 2020/3/31 20:08
 *
地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？



示例 1：

输入：m = 2, n = 3, k = 1
输出：3
示例 1：

输入：m = 3, n = 1, k = 0
输出：1
提示：

1 <= n,m <= 100
0 <= k <= 20
 */
public class MovingCount {

    int ans = 0;

    public int movingCount(int m, int n, int k) {
        movingCount(m,n,k,0,0,new boolean[m][n]);
        return ans;
    }

    public void movingCount(int m,int n,int k,int i,int j,boolean[][] visited){
        if(i < 0 || i >= m || j < 0 || j >= n) return;
        if(!canMove(i,j,k) || visited[i][j]) return;
        ans++;
        visited[i][j] = true;
        movingCount(m,n,k,i + 1,j,visited);
        movingCount(m,n,k,i - 1,j,visited);
        movingCount(m,n,k,i,j + 1,visited);
        movingCount(m,n,k,i,j - 1,visited);
    }

    private boolean canMove(int i,int j,int k){
        return (i / 10 + i % 10 + j / 10 + j % 10) <= k;
    }

}
