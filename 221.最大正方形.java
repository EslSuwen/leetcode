/*
 * @lc app=leetcode.cn id=221 lang=java
 *
 * [221] 最大正方形
 */

// @lc code=start
class Solution {
    public int maximalSquare(char[][] matrix) {
        /*
         * 
         * 
         * matrix： ["1","1","0","1"] ["0","1","0","1"] ["1","1","1","1"] 👆 对于这个位置，(i,
         * j)， 在不管 0 和 1 的情况下，它所能构成的最大正方形的左上角位置，即是 i 和 j 谁距离边界最近 我们可以看出， 即 j 距离边界最近，设
         * diff = Math.min(i, j) 那么它的最大正方形左上角位置为 (i - diff, j - diff)
         * 
         * 即它所能构成最大正方形： 👉 "0","1" "1","1" 👆 即最大构成的正方形索引范围为 (i - diff, j - diff) ...
         * ... (i, j)
         * 
         * 因此，我们可以从 (i, j) 开始慢慢扩展， 如果 (i, j) 为 1，即 [1] 那么我们可以再进一步求 (i - 1, j - 1)
         * 为左上角顶点的边长：(i - 1, j - 1)、(i - 1, j)、(i, j - 1) 全部是否为 1 (i - 1, j - 1) (i - 1,
         * j) (i, j - 1) (i, j) 如果全部是 1，即 [1, 1] [1, 1] 那么我们可以进一步求 (i - 2, j - 2)
         * 为左上角顶点的边长： 如果全部是 1，即 [1, 1, 1] [1, 1, 1] [1, 1, 1] 那么进一步求 (i - 3, j - 3)
         * 为左上角顶点的边长 直到 遇到 0 或 到达 (i - diff, j - diff)
         */
        int rlen = matrix.length;
        if (rlen == 0) {
            return 0;
        }
        int llen = matrix[0].length;

        int maxVal = 0;

        for (int i = 0; i < rlen; i++) {
            for (int j = 0; j < llen; j++) {
                if (matrix[i][j] == '0') {
                    continue;
                }
                // 求出所能构成的最大正方形的左上角顶点
                int diff = min(i, j);
                // 从 (i, j) 扩展到 (i - diff, j - diff)
                for (int x = i, y = j; x >= i - diff; x--, y--) {
                    // 判断边长是否全部为 1
                    int xx = x;
                    int yy = y;
                    for (; xx <= i; xx++, yy++) {
                        if (matrix[x][yy] == '0' || matrix[xx][y] == '0') {
                            break;
                        }
                    }
                    if (xx != i + 1) {
                        break;
                    }
                    maxVal = max(maxVal, (i - x + 1) * (i - x + 1));
                }
            }
        }
        return maxVal;
    }

    public int max(int a, int b) {
        return a > b ? a : b;
    }

    public int min(int a, int b) {
        return a < b ? a : b;
    }
}

// @lc code=end
