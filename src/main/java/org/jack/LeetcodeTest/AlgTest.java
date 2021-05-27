package org.jack.LeetcodeTest;

import lombok.extern.slf4j.Slf4j;
import org.jack.ListNode;

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

        String str;

        str = "[1,2,2,3,null,null,3,4,null,null,4]";
        TreeNode root = TreeNode.fromString(str);
        log.info("{}", str);
        log.info("{}", root.toString());

        str = "[1,2,2,3]";
        ListNode head = ListNode.fromString(str);
        log.info("{}", str);
        log.info("{}", head.toString());


        log.info("alg test end running...");
    }
}
