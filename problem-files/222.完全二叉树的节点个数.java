/*
 * @lc app=leetcode.cn id=222 lang=java
 *
 * [222] 完全二叉树的节点个数
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
    public int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        TreeNode nodeL = root.left, nodeR = root.right;
        int hL = 1, hR = 1;
        while (nodeL != null) {
            hL++;
            nodeL = nodeL.left;
        }
        while (nodeR != null) {
            hR++;
            nodeR = nodeR.right;
        }
        if(hL == hR) {
            return (int) (Math.pow(2, hL) - 1);
        } else {
            return 1 + this.countNodes(root.left) + this.countNodes(root.right);
        }
    }
}
// @lc code=end

