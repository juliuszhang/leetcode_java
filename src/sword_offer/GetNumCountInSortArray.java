package sword_offer;

/**
 * @author yibozhang
 * @date 2020/3/30 16:09
 * 统计一个数字在排序数组中出现的次数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *
 */
public class GetNumCountInSortArray {

    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int target, int low, int high) {
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] >= target) {
                high = mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            }
        }
        int count = 0;
        while (low < nums.length && nums[low++] == target) {
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        new GetNumCountInSortArray().search(new int[]{5, 7, 7, 8, 8, 10}, 8);
    }

}
