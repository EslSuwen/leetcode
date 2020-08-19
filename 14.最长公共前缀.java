/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 *
 * https://leetcode-cn.com/problems/longest-common-prefix/description/
 *
 * algorithms
 * Easy (37.13%)
 * Likes:    1120
 * Dislikes: 0
 * Total Accepted:    298.8K
 * Total Submissions: 779.1K
 * Testcase Example:  '["flower","flow","flight"]'
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 
 * 如果不存在公共前缀，返回空字符串 ""。
 * 
 * 示例 1:
 * 
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 
 * 
 * 示例 2:
 * 
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 
 * 
 * 说明:
 * 
 * 所有输入只包含小写字母 a-z 。
 * 
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        String ans = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < ans.length() && j < strs[i].length(); j++) {
                if (ans.charAt(j) != strs[i].charAt(j))
                    break;
            }
            ans = ans.substring(0, j);
            if (ans.equals(""))
                return ans;
        }
        return ans;
    }
}

/*
 * 作者：guanpengchn
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix/solution/hua-jie-
 * suan-fa-14-zui-chang-gong-gong-qian-zhui-b/ 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
/*
 * import java.util.*;
 * 
 * class Solution { public String longestCommonPrefix(String[] strs) { if
 * (strs.length == 0) return ""; List<String> strList = Arrays.asList(strs);
 * String result = ""; int length = 0xFFFFFFF; for (String each : strList) { if
 * (each.length() < length) length = each.length(); } for (int i = 0; i <
 * length; i++) { char eachChar = strList.get(0).charAt(i); for (String each :
 * strList) { if (each.charAt(i) != eachChar) return result; } result +=
 * eachChar; } return result; } }
 */
// @lc code=end
