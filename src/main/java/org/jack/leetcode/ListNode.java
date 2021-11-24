package org.jack.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用方法
 *
 * str = "[1,2,2,3,null,null,3,4,null,null,4]";
 * TreeNode root = TreeNode.fromString(str);
 * log.info("{}", str);
 * log.info("{}", root.toString());

 * str = "[1,2,2,3]";
 * ListNode head = ListNode.fromString(str);
 * log.info("{}", str);
 * log.info("{}", head.toString());
 */

/**
 * ListNode
 *
 * @author zhengzhe17
 * @date 2020/9/21
 */
public class ListNode {
    public int val;
    public ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        List<Integer> nums = this.toIntList();
        return StrUtils.intList2Str(nums);
    }

    public List<Integer> toIntList() {
        List<Integer> nums = new ArrayList<>();
        ListNode node = this;
        while (node != null) {
            nums.add(node.val);
            node = node.next;
        }
        return nums;
    }

    public static ListNode fromString(String string) {
        List<Integer> nums = StrUtils.str2IntList(string);
        return ListNode.fromIntList(nums);
    }

    private static ListNode fromIntList(List<Integer> nums) {
        ListNode head = null;
        ListNode pre = null;
        for (Integer num : nums) {
            ListNode node = new ListNode(num);
            if(pre != null) {
                pre.next = node;
            }
            pre = node;
            if(head == null) {
                head = node;
            }
        }
        return head;
    }
}
