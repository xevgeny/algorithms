/*

Find the shortest string (lexicographical order). String weight should be equal to the given number. 

Weights:

A: 1
B: 2*A + A = 3
C: 3*B + B = 12
D: 4*C + C = 60
...

Input: 5
Output: AAB

Input: 20
Output: AABBC

*/

import java.util.*;

public class Solution {
    
    private static String shortestString(int n) {
        if (n < 1) return "";
        
        // build character map
        // {1 -> A, 3 -> B, ..}
        HashMap<Integer, Character> map = new HashMap<>();
        map.put(1, 'A');
        
        int prev = 1;
        for (int i = 1; i <= 10; i++) { 
            prev = prev * (i + 2);
            map.put(prev, (char) ('A' + i));
        }
        
        TreeSet<Integer> weights = new TreeSet(map.keySet());
        int max = 1;
        for (int w : weights) {
            if (n == w) return String.valueOf(map.get(w)); 
            if (n < w) break;
            max = w;
        }
        
        // remove weights: w > n
        NavigableSet<Integer> ws = weights.headSet(max, true).descendingSet();
        
        // form result string
        StringBuilder sb = new StringBuilder();  
        while (n > 0) {
            int w = ws.first();
            if (n - w >= 0) {
                n -= w;
                sb.append(map.get(w));
            } else ws.pollFirst();
        }
        
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(shortestString(20));
    }
}