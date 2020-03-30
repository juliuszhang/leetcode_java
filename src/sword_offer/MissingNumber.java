package sword_offer;

/**
 * @author yibozhang
 * @date 2020/3/30 16:39
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {
        boolean[] temp = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[nums[i]] = true;
        }

        for (int i = 0; i < temp.length; i++) {
            if (!temp[i]) {
                return i;
            }
        }
        return nums.length;
    }

}
