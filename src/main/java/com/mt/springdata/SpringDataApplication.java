package com.mt.springdata;

import com.mt.springdata.services.InitializeTheDb;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.hazelcast.HazelcastAutoConfiguration;

@SpringBootApplication(exclude = HazelcastAutoConfiguration.class)
@RequiredArgsConstructor
@Slf4j
public class SpringDataApplication implements CommandLineRunner {

    private final InitializeTheDb initializeTheDb;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataApplication.class, args);
    }

    @Override
    public void run(String... args) {
        // initializeTheDb.init();
        initializeTheDb.initTopics();
        log.info("Nothing to be DONE 😁");
    }

}
