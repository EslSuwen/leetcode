/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int result[] = new int[2];
        int i, j;
        boolean flag = false;
        for (i = 0; i < nums.length; i++) {
            if (flag)
                break;
            for (j = i + 1; j < nums.length; j++) {
                if (flag)
                    break;
                if (target == nums[i] + nums[j]) {
                    result[0] = i;
                    result[1] = j;
                    flag = true;
                }
            }
        }
        return result;
    }
}
// @lc code=end
