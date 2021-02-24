/*
 * @lc app=leetcode.cn id=230 lang=java
 *
 * [230] 二叉搜索树中第K小的元素
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
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) {
            return 0;
        }
        List<Integer> nums = new ArrayList<>();
        toList(root, nums);
        return nums.get(k-1);
    }

    private void toList(TreeNode root, List<Integer> nums) {
        if(root.left != null) {
            toList(root.left, nums);
        }
        nums.add(root.val);
        if(root.right != null) {
            toList(root.right, nums);
        }
    }
}
// @lc code=end

