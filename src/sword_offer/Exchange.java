package sword_offer;

/**
 * @author yibozhang
 * @date 2020/4/1 20:54
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 *  
 *
 * 示例：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10000
 *
 */
public class Exchange {

    public int[] exchange(int[] nums) {
        int i = 0,j = nums.length - 1;
        while(i < j){
            if(nums[i] % 2 == 0){
                while(j > i){
                    if(nums[j] % 2 == 1){
                        swap(i,j,nums);
                        j--;
                        break;
                    }
                    j--;
                }
            }
            i++;
        }
        return nums;
    }

    private void swap(int i,int j,int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
