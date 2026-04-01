package access_modifier;
import java.util.Set;
public class Main {

    public static void main(String[] args) {
        // BankAccount bankAccount = new BankAccount();
        // // System.out.println(bankAccount.balance);
        // System.out.println(bankAccount.branch);
        // System.out.println(bankAccount.name);

        int[] nums = { 1, 5, 4, 2, 9, 9, 9 };
        System.out.println(maximumSubarraySum(nums, 3));
    }

    public static long maximumSubarraySum(int[] nums, int k) {
        int sum = 0;
        int max = 0;
        boolean isDuplicate = false;

        for (int i = 0; i < k; i++) {
            if (i < k - 1 && nums[i] == nums[i + 1]) {
                isDuplicate = true;
                sum += nums[i];
            } else {
                sum += nums[i];
            }
        }

        if (isDuplicate) {
            max = 0;
        } else {
            max = sum;
        }

        for (int i = 1; i <= nums.length - k; i++) {
            if (i < nums.length - 1 && nums[i] == nums[i + 1] || nums[i + k - 1] == nums[i + k - 2]) {
                isDuplicate = true;
                sum = sum - nums[i - 1] + nums[i + k - 1];
            } else {
                sum = sum - nums[i - 1] + nums[i + k - 1];
            }

            if (!isDuplicate) {
                max = Math.max(sum, max);
            }
        }

        return max;
    }
}
