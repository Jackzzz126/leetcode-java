package org.jack.LeetcodeTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LeetcodeTestApplication {
    public static void main(String[] args) {
        //SpringApplication.run(LeetcodeTestApplication.class, args);
        AlgTest algTest = new AlgTest();
        algTest.run();
    }
}
