package sword_offer;

/**
 * @author yibozhang
 * @date 2020/3/30 13:55
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [7,5,6,4]
 * 输出: 5
 *
 */
public class ReversePairs {

    int ans = 0;

    public int reversePairs(int[] nums) {
        if (nums.length < 2) return 0;
        divide(nums, 0, nums.length - 1);
        return ans;
    }

    private void divide(int[] nums, int low, int high) {
        if (low != high) {
            int mid = (low + high) >> 1;
            divide(nums, low, mid);
            divide(nums, mid + 1, high);
            mergeAndCount(nums, low, high, mid);
        }
    }

    private void mergeAndCount(int[] nums, int low, int high, int mid) {
        int i = low;
        int j = mid + 1;
        int[] temp = new int[high - low + 1];
        int index = 0;
        while (i <= mid && j <= high) {
            if (nums[i] > nums[j]) {
                //发现逆序对
                temp[index++] = nums[j++];
                ans += mid - i + 1;
            } else {
                temp[index++] = nums[i++];
            }
        }

        while (i <= mid) {
            temp[index++] = nums[i++];
        }
        while (j <= high) {
            temp[index++] = nums[j++];
        }

        index = 0;
        for (int k = low; k <= high; k++) {
            nums[k] = temp[index++];
        }
    }

    public static void main(String[] args) {
        int i = new ReversePairs().reversePairs(new int[]{});
        System.out.println(i);
    }


}
