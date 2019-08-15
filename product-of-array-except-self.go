// Product of Array Except Self:
//   https://leetcode.com/problems/product-of-array-except-self/
//
// Solution without division and in O(n):
//   new element should be the product of all the numbers to the left
//   times the product of all the numbers to the right

func productExceptSelf(nums []int) []int {
	if len(nums) < 2 {
		return nums
	}

	acc := 1
	right := make([]int, len(nums))

	for i := len(nums) - 1; i > 0; i-- {
		acc *= nums[i]
		right[i] = acc
	}

	acc = 1
	res := make([]int, len(nums))
	for i := 0; i < len(nums)-1; i++ {
		res[i] = acc * right[i+1]
		acc *= nums[i]
	}
	res[len(nums)-1] = acc

	return res
}