/*
 * @lc app=leetcode.cn id=279 lang=java
 *
 * [279] 完全平方数
 *
 * https://leetcode-cn.com/problems/perfect-squares/description/
 *
 * algorithms
 * Medium (55.96%)
 * Likes:    495
 * Dislikes: 0
 * Total Accepted:    71.5K
 * Total Submissions: 125.7K
 * Testcase Example:  '12'
 *
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * 
 * 示例 1:
 * 
 * 输入: n = 12
 * 输出: 3 
 * 解释: 12 = 4 + 4 + 4.
 * 
 * 示例 2:
 * 
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 * 
 */
/**
 * 这道题目很有意思。
 * 
 * 大部分文章给出的答案都是依托于一个定理：四平方定理。
 * 
 * 四平方定理讲的就是任何一个正整数都可以表示成不超过四个整数的平方之和。也就是说，这道题的答案只有 1，2 ，3，4 这四种可能。
 * 
 * 同时，还有一个非常重要的推论满足四数平方和定理的数n（这里要满足由四个数构成，小于四个不行），必定满足 n = 4a * (8b + 7)。
 * 
 * 根据这个重要的推论来解决此题，首先将输入的n迅速缩小。然后再判断，这个缩小后的数是否可以通过两个平方数的和或一个平方数组成，不能的话我们返回3，能的话我们返回平方数的个数。
 */
// @lc code=start
class Solution {
    public int numSquares(int n) {
        while (n % 4 == 0) {
            n /= 4;
        }
        if (n % 8 == 7) {
            return 4;
        }
        int a = 0;
        while ((a * a) <= n) {
            int b = (int) Math.pow((n - a * a), 0.5);
            if (a * a + b * b == n) {
                // 如果可以 在这里返回
                if (a != 0 && b != 0) {
                    return 2;
                } else {
                    return 1;
                }
            }
            a++;
        }
        return 3;
    }
}
// @lc code=end
