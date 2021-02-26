/*
 * @lc app=leetcode.cn id=297 lang=java
 *
 * [297] 二叉树的序列化与反序列化
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> nums = this.toIntList(root);
        return this.intList2Str(nums);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<Integer> nums = this.str2IntList(data);
        return this.fromIntList(nums);
    }

    private String intList2Str(List<Integer> nums) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < nums.size(); i++) {
            Integer num = nums.get(i);

            if(num == null) {
                sb.append("null");
            } else {
                sb.append(num.toString());
            }

            if(i != (nums.size() - 1)) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private List<Integer> str2IntList(String str) {
        List<Integer> nums = new ArrayList<>();
        if(str == null && str.length() < 2) {
            return nums;
        }

        int leftIndex = str.indexOf("[");
        int rightIndex = str.indexOf("]");
        if(leftIndex < 0 || rightIndex < 0) {
            return nums;
        }
        String numsStr = str.substring(leftIndex + 1, rightIndex);
        String[] numStrs = numsStr.split(",");

        for (String numStr : numStrs) {
            if("null".equals(numStr.toLowerCase())) {
                nums.add(null);
            } else if("".equals(numsStr)){
                continue;
            } else {
                nums.add(Integer.valueOf(numStr));
            }
        }
        return nums;
    }

    private List<Integer> toIntList(TreeNode root) {
        List<Integer> valList = new ArrayList<>();
        if(root == null) {
            return valList;
        }

        List<TreeNode> curNodes = new ArrayList<>();
        curNodes.add(root);
        valList.add(root.val);

        while (curNodes.size() > 0) {
            List<TreeNode> nextNodes = new ArrayList<>();
            for (TreeNode treeNode : curNodes) {
                if(treeNode != null) {
                    if(treeNode.left != null) {
                        valList.add(treeNode.left.val);
                        nextNodes.add(treeNode.left);
                    } else {
                        valList.add(null);
                    }
                    if(treeNode.right != null) {
                        nextNodes.add(treeNode.right);
                        valList.add(treeNode.right.val);
                    } else {
                        valList.add(null);
                    }
                }
            }
            curNodes = nextNodes;
        }

        int lastNotNullIndex = valList.size() - 1;
        for(; lastNotNullIndex > 0; lastNotNullIndex--) {
            if(valList.get(lastNotNullIndex) != null) {
                break;
            }
        }

        return valList.subList(0, lastNotNullIndex + 1);
    }

    private TreeNode fromIntList(List<Integer> nums) {
        if(nums == null || nums.size() < 1) {
            return null;
        }

        TreeNode root = new TreeNode(nums.get(0));
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);

        int numIndex = 1;
        int nodeIndex = 0;
        while(nodeIndex < nodes.size()) {
            TreeNode curNode = nodes.get(nodeIndex);

            if(numIndex >= nums.size()) {
                break;
            }
            Integer leftValue = nums.get(numIndex);
            if(leftValue != null) {
                TreeNode node = new TreeNode(leftValue);
                curNode.left = node;
                nodes.add(node);
            }
            if((numIndex + 1) >= nums.size()) {
                break;
            }

            Integer rightValue = nums.get(numIndex + 1);
            if(rightValue != null) {
                TreeNode node = new TreeNode(rightValue);
                curNode.right = node;
                nodes.add(node);
            }
            nodeIndex++;
            numIndex+=2;
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
// @lc code=end

