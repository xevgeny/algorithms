/*

Problem:

    - https://leetcode.com/problems/next-permutation/

Solutions:

    - https://leetcode.com/problems/next-permutation/discuss/13994/Readable-code-without-confusing-ij-and-with-explanation
    - https://leetcode.com/problems/next-permutation/discuss/13872/Easiest-JAVA-Solution

Algorithm:

    1. Find pivot element (first non-increasing element) 
    2. Swap `piv` with rightmost element `rm`: rm > piv.
    3. Reverse tail

         piv
         |
[(4) (2) 1 5 3 0]
             |
             rm

(4), (2) - locked elements in permutation

*/


class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length < 2) return;
        int piv = findPivotIndex(nums);
        
        if (piv == -1) reverse(nums, 0, nums.length); // [3,2,1] case, reverse full array.
        else {
            for (int i = nums.length - 1; i > piv; i--) { // Swap `piv` with rightmost element `rm`: rm > piv.
                if (nums[i] > nums[piv]) {
                    swap(nums, i, piv);
                    break;
                }
            }
            reverse(nums, piv + 1, nums.length); // Reverse tail.
        }
    }
    
    private int findPivotIndex(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) return i - 1;
        }
        return -1;
    }
    
    // start - inclusive, end - exclusive
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, --end);
        }
    } 
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}