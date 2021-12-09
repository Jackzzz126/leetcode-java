package org.jack.leetcode;

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
        log.info("alg test start...");

        try {
            runTest();
            log.info("alg test ends");
        } catch (Exception e) {
            log.error("alg test end with exception: ", e);
        }
    }

    private void runTest() throws Exception {

    }
}
