/*
 * @lc app=leetcode.cn id=1038 lang=java
 *
 * [1038] 把二叉搜索树转换为累加树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode bstToGst(TreeNode root) {
        if(root == null) {
            return null;
        }
        convert(root);

        return root;
    }
    int sum = 0;
    private void convert(TreeNode root) {
        if(root == null) {
            return;
        }
        if(root.right != null) {
            convert(root.right);
        }
        sum += root.val;
        root.val = sum;
        if(root.left != null) {
            convert(root.left);
        }
    }
}
// @lc code=end

