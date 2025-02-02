package BinarySearch;
import java.util.Arrays;
public class FirstAndLastOccurance {


    public static void main(String[] args) {

        int[]arr={1,2,3,7,7,7,7,7,9,20};
        System.out.println(Arrays.toString(searchRange(arr,7)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] ans = { -1, -1 };

        ans[0] = occur(nums, target, true);
        ans[1] = occur(nums, target, false);

        return ans;
    }

    public static int occur(int[] nums, int target, boolean isStart) {
        int ans = -1;

        int s = 0, e = nums.length - 1;

        while (s <= e) {
            int m = s + (e - s) / 2;

            if (nums[m] == target) {
                ans = m;
                if (isStart) {
                    e = m - 1;
                } else {
                    s = m + 1;
                }
            } else if (nums[m] > target) {
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        return ans;
    }
}
