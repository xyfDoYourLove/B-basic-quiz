package com.thoughtworks.gtb.basic.quiz.basic;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.lang.annotation.*;

// GTB: - 定义了却没用到？为什么？
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
public @interface JUnitWebAppTest {
}
