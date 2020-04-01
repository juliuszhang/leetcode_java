package sword_offer;

/**
 * @author yibozhang
 * @date 2020/4/1 22:15
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *
 *  
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 *  
 *
 * 限制：
 *
 * 1 <= 数组长度 <= 50000
 *
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        if(nums.length == 0) return 0;
        int count = 1;
        int num = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(count == 0) {
                num = nums[i];
                count++;
            }else if(nums[i] != num){
                count--;
            }else{
                count++;
            }
        }
        return num;
    }

}