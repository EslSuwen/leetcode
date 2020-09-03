import sun.security.util.Length;

/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 实现 strStr()
 *
 * https://leetcode-cn.com/problems/implement-strstr/description/
 *
 * algorithms
 * Easy (39.67%)
 * Likes:    554
 * Dislikes: 0
 * Total Accepted:    225K
 * Total Submissions: 566.2K
 * Testcase Example:  '"hello"\n"ll"'
 *
 * 实现 strStr() 函数。
 * 
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置
 * (从0开始)。如果不存在，则返回  -1。
 * 
 * 示例 1:
 * 
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 
 * 
 * 示例 2:
 * 
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 
 * 
 * 说明:
 * 
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 * 
 */

// @lc code=start
class Solution {
    public int strStr(String haystack, String needle) {

        char[] S = haystack.toCharArray();
        char[] T = needle.toCharArray();

        int i = 0; // i 表示主串 S 中当前位置下标
        int j = 0; // j 表示子串 T 中当前位置下标

        while (i < S.length && j < T.length) { // i 或 j 其中一个到达尾部则终止搜索
            if (S[i] == T[j]) { // 若相等则继续进行下一个元素匹配
                i++;
                j++;
            } else { // 若匹配失败则 j 回溯到第一个元素重新匹配
                i = i - j + 1; // 将 i 重新回溯到上次匹配首位的下一个元素
                j = 0;
            }
        }

        if (j == T.length) {
            return i - T.length;
        } else {
            return -1;
        }
    }
}
// @lc code=end
