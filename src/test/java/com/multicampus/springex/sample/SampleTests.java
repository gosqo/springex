package com.multicampus.springex.sample;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;

@Log4j2
// spring-test 를 이용하기 위한 설정 Junit5 버전,
// Junit4 @RunWith 사용.
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class SampleTests {

    // 스프링에서 사용하는 의존성 주입 어노테이션
    // "해당 타입의 빈이 스프링 컨테이너에 존재한다면, 여기에 주입해 주기를 원한다."
    // Field Injection 방식 (필드 주입)
    @Autowired
    private SampleService sampleService;

    @Autowired
    private DataSource dataSource;

    @Test
    public void testService() {
        log.info(sampleService);
        Assertions.assertNotNull(sampleService);
    }

    @Test
    public void testConnection() throws Exception {

        Connection con = dataSource.getConnection();
        System.out.println("=== \"got connected.\" ===");
        log.info(con);
        Assertions.assertNotNull(con);
        System.out.println("=== \"instance con is not null.\" ===");
        con.close();
        System.out.println("=== \"connection closed.\" ===");

    }
}
