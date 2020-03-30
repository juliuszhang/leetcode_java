package sword_offer;

import java.util.Arrays;

/**
 * @author yibozhang
 * @date 2020/3/30 21:38
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 示例 2：
 *
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 *
 */
public class SingleNumbers {

    public int[] singleNumbers(int[] nums) {
        int i = 0;
        for (int num : nums) {
            i ^= num;
        }

        int n = 1;
        while ((i & n) == 0) {
            n <<= 1;
        }

        int r1 = 0;
        int r2 = 0;
        for (int num : nums) {
            if ((n & num) == 0) {
                r1 ^= num;
            } else {
                r2 ^= num;
            }
        }
        return new int[]{r1, r2};
    }

    public static void main(String[] args) {
        int[] ints = new SingleNumbers().singleNumbers(new int[]{1, 2, 5, 2});
        System.out.println(Arrays.toString(ints));
    }

}
