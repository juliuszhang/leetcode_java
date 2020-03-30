package sword_offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yibozhang
 * @date 2020/3/30 22:07
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * <p>
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 * <p>
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 */
public class FindContinuousSequence {

    public int[][] findContinuousSequence(int target) {
        //滑动窗口
        List<Integer> window = new LinkedList<>();
        int sum = 0;
        int start = 0;
        int i = 1;
        List<List<Integer>> ansList = new ArrayList<>();
        while (i <= target) {
            if (sum < target) {
                window.add(i);
                sum += i;
                i++;
            } else if (sum > target) {
                sum -= window.remove(0);
            } else {
                ansList.add(new ArrayList<>(window));
                sum -= window.remove(0);
            }
        }

        int[][] ans = new int[ansList.size()][];
        for (int j = 0; j < ansList.size(); j++) {
            List<Integer> list = ansList.get(j);
            int[] arr = new int[list.size()];
            for (int k = 0; k < arr.length; k++) {
                arr[k] = list.get(k);
            }
            ans[j] = arr;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] continuousSequence = new FindContinuousSequence().findContinuousSequence(9);
        for (int[] ints : continuousSequence) {
            System.out.println("Arrays.toString(ints) = " + Arrays.toString(ints));
        }
    }

}
