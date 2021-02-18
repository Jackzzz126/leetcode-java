package org.jack.SpringBootTest;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootTestApplication {

    public static void main(String[] args) {
        //SpringApplication.run(SpringBootTestApplication.class, args);
        AlgTest algTest = new AlgTest();
        algTest.run();
    }
}
