package stream;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(max(Arrays.copyOf(nums, k)));
        for (int i = 1; i <= nums.length - k; i++) {
            arr.add(max(Arrays.copyOfRange(nums, i, i + k)));
        }

        int[] res = new int[arr.size()];

        for (int i = 0; i < res.length; i++) {
            res[i] = arr.get(i);
        }
        return res;
    }

    public static int max(int[] arr) {
        Integer max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 3, -1, -3, 5, 3, 6, 7 };

        System.out.println(Arrays.toString(maxSlidingWindow(nums, 3)));
    }
}