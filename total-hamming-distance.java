/*

Problem:

- https://leetcode.com/problems/total-hamming-distance/

Solutions:

- https://leetcode.com/problems/total-hamming-distance/discuss/96226/Java-O(n)-time-O(1)-Space
- https://leetcode.com/problems/total-hamming-distance/discuss/96243/Share-my-O(n)-C++-bitwise-solution-with-thinking-process-and-explanation

For all number a1, a2, a3,..., a(n), if there are p numbers have 0 as LSB (put in set M), 
and q numbers have 1 for LSB (put in set N).

There are 2 situations:
Situation 1. If the 2 number in a pair both comes from M (or N), the total will get 0.
Situation 2. If the 1 number in a pair comes from M, the other comes from N, the total will get 1.
Since Situation 1 will add NOTHING to the total, we only need to think about Situation 2
How many pairs are there in Situation 2?
We choose 1 number from M (p possibilities), and 1 number from N (q possibilities).
The total possibilities is p × q = pq, which means
The total Hamming distance will get pq from LSB.

*/

class Solution {
    public int totalHammingDistance(int[] nums) {
        int total = 0, N = nums.length;
        for (int i = 0; i < 32; i++) {
            int k = 0; // number of ones in i'th position 
                       // N-k - number of zeros in i'th position
            for (int num : nums) {
                k += (num >> i) & 1; // LSB equal to 1?
            }
            total += k * (N - k);
        }
        return total;
    }
}