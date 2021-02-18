package org.jack;

import java.util.ArrayList;
import java.util.List;

/**
 * ListNode
 *
 * @author zhengzhe17
 * @CreateTime 2020/9/21
 */
public class ListNode {
    public int val;
    public ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
    public static ListNode arr2List(int[] nums) {
        ListNode head = null;
        ListNode pre = null;
        for (int i = 0; i < nums.length; i++) {
            ListNode node = new ListNode(nums[i]);
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
    public static List<Integer> list2Arr(ListNode head) {
        List<Integer> nums = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            nums.add(node.val);
            node = node.next;
        }
        return nums;
    }
}
