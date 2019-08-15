/*

Dutch National Flag Problem:

- https://leetcode.com/problems/sort-colors/
- http://users.monash.edu/~lloyd/tildeAlgDS/Sort/Flag/
- https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/

Initialization:

  mid                
  lo                hi
  |                 |
[ 2, 0, 1, 2, 1, 1, 0 ] 

Iteration:

        lo mid   hi
        |  |     |
[ 0, 0, 1, 2, 1, 1, 2 ]

*/

class Solution {
    public void sortColors(int[] nums) {   
        int lo = 0, mid = 0, hi = nums.length - 1;
        while (mid <= hi) {
            if (nums[mid] == 0) swap(lo++, mid++, nums);
            else if (nums[mid] == 1) mid++;
            else swap(mid, hi--, nums);
        }
    }
    
    private void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}