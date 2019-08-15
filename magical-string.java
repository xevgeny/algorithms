/*

- https://leetcode.com/problems/magical-string/
- Shor C++ solution: https://leetcode.com/problems/magical-string/discuss/96408/Short-C%2B%2B

string | 1 | 22 | 11 | 2 | 1 | ..
groups | 1 | 2  | 2  | 1 | 1 | 2  | 1 | ..

*/

class Solution {
    public int magicalString(int n) {
        if (n == 0) return 0;
        else if (n <= 3) return 1;
        
        int[] magic = new int[n];        
        magic[0] = 1; magic[1] = 2; magic[2] = 2; // Start with {1,2,2}
        
        int i = 3, groupPos = 2;
        int[] counts = new int[]{1,2};
            
        while (i < n) {
            int tail = 3 - magic[i-1]; // flip tail: 3 - tail
                                       // alternative: 3 ^ tail
            if (magic[groupPos] == 1) {
                magic[i] = tail;
                counts[tail-1] += 1;
                i += 1;
            } else {
                magic[i] = tail;
                if (i+1 < n) {
                    magic[i+1] = tail;
                    counts[tail-1] += 2;
                } else counts[tail-1] += 1;
                i += 2;
            }
            groupPos++;
        }
        
        // System.out.println(Arrays.toString(magic));
        
        return counts[0];
    }
}