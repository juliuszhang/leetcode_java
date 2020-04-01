package sword_offer;

import java.util.Arrays;

/**
 * @author yibozhang
 * @date 2020/4/1 22:51
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5]
 * 输出: True
 *  
 *
 * 示例 2:
 *
 * 输入: [0,0,1,2,5]
 * 输出: True
 *
 */
public class IsStraight {

    public boolean isStraight(int[] nums) {
        if (nums.length == 0) return true;
        Arrays.sort(nums);
        int diff = 0;
        int any = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                any++;
            } else if (nums[i] == nums[i + 1]) {
                return false;
            } else {
                diff += Math.abs(nums[i] - nums[i + 1]);
            }
        }

        return diff - nums.length + 1 <= any;
    }

    public static void main(String[] args) {
        new IsStraight().isStraight(new int[]{0, 0, 8, 5, 4});
    }

}
