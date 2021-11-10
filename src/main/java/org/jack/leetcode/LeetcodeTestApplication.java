package org.jack.leetcode;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LeetcodeTestApplication {
    public static void main(String[] args) {
        //SpringApplication.run(LeetcodeTestApplication.class, args);
        AlgTest algTest = new AlgTest();
        algTest.run();
    }
}
