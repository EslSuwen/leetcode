/*
 * @lc app=leetcode.cn id=204 lang=java
 *
 * [204] 计数质数
 */

// @lc code=start
class Solution {
    public int countPrimes(int n) {
        int count = 0;
        int[] array= new int[n]; //建立数组，默认整型数组元素都是0.
        // 从2开始进行比较，最后数组元素是0时，为质数，为1时为合数。
        for (int i = 2; i <= (int)Math.sqrt(n); i++) {
            if (array[i] == 0) {
                for (int j = i * i; j < n; j += i) {
                    array[j] = 1;
                }
            }
        }    
        for (int i = 2; i < n; i++) {
            if (array[i] == 0) count++;
        }
        return count;
    }
}
// @lc code=end

