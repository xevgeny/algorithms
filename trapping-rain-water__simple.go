/*

https://leetcode.com/problems/trapping-rain-water/
https://www.geeksforgeeks.org/trapping-rain-water/

A Simple Solution is to traverse every array element and find the highest bars on left and right sides.
Take the smaller of two heights.
The difference between the smaller height and height of the current element is the amount of water
that can be stored in this array element.
Time complexity of this solution is O(n2).

*/

func trap(height []int) int {
	h := len(height)
	if h == 0 {
		return 0
	}

	left := make([]int, len(height))
	right := make([]int, len(height))

	left[0] = height[0]
	for i := 1; i < h; i++ {
		left[i] = max(left[i-1], height[i])
	}

	right[h-1] = height[h-1]
	for i := h - 2; i >= 0; i-- {
		right[i] = max(height[i], right[i+1])
	}

	res := 0
	for i := 0; i < h; i++ {
		res += min(left[i], right[i]) - height[i]
	}

	return res
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}