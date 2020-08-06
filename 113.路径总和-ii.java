/*
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
 *
 * https://leetcode-cn.com/problems/path-sum-ii/description/
 *
 * algorithms
 * Medium (59.48%)
 * Likes:    286
 * Dislikes: 0
 * Total Accepted:    64.4K
 * Total Submissions: 106.1K
 * Testcase Example:  '[5,4,8,11,null,13,4,7,2,null,null,5,1]\n22'
 *
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * 
 * ⁠             5
 * ⁠            / \
 * ⁠           4   8
 * ⁠          /   / \
 * ⁠         11  13  4
 * ⁠        /  \    / \
 * ⁠       7    2  5   1
 * 
 * 
 * 返回:
 * 
 * [
 * ⁠  [5,4,11,2],
 * ⁠  [5,8,4,5]
 * ]
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node. 
 * public class TreeNode { 
 * int val; 
 * TreeNode left; 
 * TreeNode right; 
 * TreeNode(int x) { val = x; }
 * }
 * 
 * https://blog.csdn.net/linhuanmars/article/details/23655413
 */

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        List<Integer> item = new ArrayList<>();
        item.add(root.val);
        helper(root, sum - root.val, item, res);
        return res;
    }

    private void helper(TreeNode root, int sum, List<Integer> item, List<List<Integer>> res) {
        if (root == null)
            return;
        if (root.left == null && root.right == null && sum == 0) {
            res.add(new ArrayList<Integer>(item));
            return;
        }
        if (root.left != null) {
            item.add(root.left.val);
            helper(root.left, sum - root.left.val, item, res);
            item.remove(item.size() - 1);
        }
        if (root.right != null) {
            item.add(root.right.val);
            helper(root.right, sum - root.right.val, item, res);
            item.remove(item.size() - 1);
        }
    }
}
// @lc code=end
