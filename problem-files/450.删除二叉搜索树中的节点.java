/*
 * @lc app=leetcode.cn id=450 lang=java
 *
 * [450] 删除二叉搜索树中的节点
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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) {
            return null;
        }

        if(key < root.val) {
            root.left = this.deleteNode(root.left, key);
        } else if(root.val == key) {
            if(root.right == null) {
                if(root.left == null) {
                    return null;
                } else {
                    return root.left;
                }
            } else {
                if(root.left == null) {
                    return root.right;
                } else {
                    root.val = getMinVal(root.right);
                    root.right = this.deleteNode(root.right, root.val);
                }
            }
        } else {
            root.right = this.deleteNode(root.right, key);
        }
        return root;
    }
    private int getMinVal(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null) {
            return root.val;
        } else {
            return this.getMinVal(root.left);
        }
    }
}
// @lc code=end

