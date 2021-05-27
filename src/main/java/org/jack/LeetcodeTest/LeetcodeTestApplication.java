package org.jack.LeetcodeTest;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LeetcodeTestApplication {

    public static void main(String[] args) {
        //SpringApplication.run(SpringBootTestApplication.class, args);
        AlgTest algTest = new AlgTest();
        algTest.run();
    }
}
