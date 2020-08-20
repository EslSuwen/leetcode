import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子数组
 *
 * https://leetcode-cn.com/problems/maximum-product-subarray/description/
 *
 * algorithms
 * Medium (40.16%)
 * Likes:    717
 * Dislikes: 0
 * Total Accepted:    87.8K
 * Total Submissions: 218.7K
 * Testcase Example:  '[2,3,-2,4]'
 *
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 
 * 
 * 示例 2:
 * 
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 * 
class Solution {
    public int maxProduct(int[] nums) {
        int MAX = Integer.MIN_VALUE;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                list.add(nums[i]);
            } else if (nums[i] == 0) {
                MAX = Math.max(MAX, fun(list));
                list.clear();
            } else {
                if (i == nums.length - 1) {
                    if (list.isEmpty()) {
                        list.add(nums[i]);
                    }
                    MAX = Math.max(MAX, fun(list));
                    list.clear();
                    continue;
                }
                if (nums[i + 1] < 0) {
                    list.add(nums[i]);
                    list.add(nums[i + 1]);
                    i++;
                } else {
                    if(list.isEmpty()){
                        list.add(nums[i]);
                    }
                    MAX = Math.max(MAX, fun(list));
                    list.clear();
                }
            }
        }
        if (!list.isEmpty()) {
            MAX = Math.max(MAX, fun(list));
        }
        return MAX;
    }

    private int fun(List<Integer> list) {
        if (list.isEmpty()) {
            return 0;
        }
        int temp = 1;
        for (Integer each : list) {
            temp *= each;
        }
        return temp;
    }
}
*/

// @lc code=start
public class Solution {

    public int maxProduct(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int res = nums[0];

        // dp[i][0]：以 nums[i] 结尾的连续子数组的最小值
        // dp[i][1]：以 nums[i] 结尾的连续子数组的最大值
        int[][] dp = new int[len][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] >= 0) {
                dp[i][0] = Math.min(nums[i], nums[i] * dp[i - 1][0]);
                dp[i][1] = Math.max(nums[i], nums[i] * dp[i - 1][1]);
            } else {
                dp[i][0] = Math.min(nums[i], nums[i] * dp[i - 1][1]);
                dp[i][1] = Math.max(nums[i], nums[i] * dp[i - 1][0]);
            }
            // 只关心最大值
            res = Math.max(res, dp[i][1]);
        }
        return res;
    }
}
/*
 * 作者：liweiwei1419
 * 链接：https://leetcode-cn.com/problems/maximum-product-subarray/solution/dong-
 * tai-gui-hua-li-jie-wu-hou-xiao-xing-by-liweiw/ 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
// @lc code=end
