package org.jack.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

/**
 * AlgTest
 *
 * @author zhengzhe17
 * @date 2021/1/22
 */
@Slf4j
public class AlgTest {
    public void run() {
        log.info("alg test start running...");

        //Integer[] numArr = {1,2,2,3,null,null,3,4,null,null,4};
        //TreeNode root = TreeNode.arr2Tree(Arrays.asList(numArr));
        //List<Integer> numList = TreeNode.tree2Arr(root);
        //log.info(numList.toString());

        //int[] numArr = {1,2,2,3};
        //ListNode head = ListNode.arr2List(numArr);
        //List<Integer> numList = ListNode.list2Arr(head);
        //log.info(numList.toString());

        int[] arr = {1, 5, 11, 5};
        boolean result = this.canPartition(arr);
        log.info("{}", result);

        log.info("alg test end running...");
    }
    public boolean canPartition(int[] nums) {
        if(nums.length < 2) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if(sum % 2 != 1) {
            return false;
        }
        int target = sum / 2;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > target) {
                return false;
            }
        }

        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        for (int i = 0; i < (target + 1); i++) {
            dp[0][i] = false;
        }
        for (int i = 0; i < (nums.length + 1); i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < (nums.length +1) ; i++) {
            for (int j = 1; j < (target + 1) ; j++) {
                dp[i][j] = dp[i - 1][j] | dp[i - 1][j-nums[i-1]];
            }
        }

        return dp[nums.length][target];
    }
}

