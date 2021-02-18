package org.jack.SpringBootTest;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * TreeNode
 *
 * @author zhengzhe17
 * @CreateTime 2020/9/21
 */
public class TreeNode {
    public int val = 0;
    public TreeNode left = null;
    public TreeNode right = null;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode() {
    }

    public static List<Integer> tree2Arr(TreeNode root) {
          List<Integer> valList = new ArrayList<>();
          if(root == null) {
              return valList;
          }

          List<TreeNode> curNodes = new ArrayList<>();
          curNodes.add(root);
          valList.add(root.val);

          while (!CollectionUtils.isEmpty(curNodes)) {
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

      public static TreeNode arr2Tree(List<Integer> nums) {
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
