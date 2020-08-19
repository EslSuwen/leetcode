/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 *
 * https://leetcode-cn.com/problems/search-a-2d-matrix/description/
 *
 * algorithms
 * Medium (37.81%)
 * Likes:    210
 * Dislikes: 0
 * Total Accepted:    51.9K
 * Total Submissions: 135.1K
 * Testcase Example:  '[[1,3,5,7],[10,11,16,20],[23,30,34,50]]\n3'
 *
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 
 * 
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 
 * 
 * 示例 1:
 * 
 * 输入:
 * matrix = [
 * ⁠ [1,   3,  5,  7],
 * ⁠ [10, 11, 16, 20],
 * ⁠ [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * matrix = [
 * ⁠ [1,   3,  5,  7],
 * ⁠ [10, 11, 16, 20],
 * ⁠ [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 * 
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int startRow = 0, endRow = matrix.length - 1;
        while (startRow + 1 < endRow) {
            int mid = startRow + (endRow - startRow) / 2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] < target) {
                startRow = mid;
            } else {
                endRow = mid;
            }
        }

        int selectRow = 0;
        if (matrix[endRow][0] <= target) {
            selectRow = endRow;
        } else {
            selectRow = startRow;
        }

        int startCol = 0, endCol = matrix[0].length - 1;
        while (startCol + 1 < endCol) {
            int mid = startCol + (endCol - startCol) / 2;
            if (matrix[selectRow][mid] == target) {
                return true;
            } else if (matrix[selectRow][mid] < target) {
                startCol = mid;
            } else {
                endCol = mid;
            }
        }

        if (matrix[selectRow][startCol] == target || matrix[selectRow][endCol] == target) {
            return true;
        }

        return false;
    }
}
// @lc code=end
