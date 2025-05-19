package MinSwaps;

import java.util.*;

class Solution {
    public int minSwaps(int[] nums) {
        // Convert int[] to List<Integer>
        List<Integer> sorted = new ArrayList<>();
        for (int num : nums) sorted.add(num);

        // Use custom comparator
        sorted.sort(new DigitSumComparator());

        // Map from value to its sorted index (no need for queue since all values are distinct)
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < sorted.size(); i++) {
            map.put(sorted.get(i), i);
        }

        int[] arr = Arrays.copyOf(nums, nums.length); // Work on a copy
        int swp = 0;

        for (int i = 0; i < arr.length; i++) {
            int correctVal = sorted.get(i);
            if (arr[i] != correctVal) {
                // Find the index where the correct value is currently located
                int toSwapIdx = -1;
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] == correctVal) {
                        toSwapIdx = j;
                        break;
                    }
                }
                // Swap
                int temp = arr[i];
                arr[i] = arr[toSwapIdx];
                arr[toSwapIdx] = temp;
                swp++;
            }
        }
        return swp;
    }
}

// Renamed comparator to avoid conflict
class DigitSumComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer x, Integer y) {
        int a = digitSum(x);
        int b = digitSum(y);
        if (a != b) return a - b;
        else return x - y;
    }

    public int digitSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n = n / 10;
        }
        return sum;
    }
}