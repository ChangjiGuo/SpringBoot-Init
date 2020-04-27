package com.ly.ysmr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

/**
 * main entry
 */
@SpringBootApplication
@EnableSwagger2
@RestController
public class YsmrApplication {

    public static void main(String[] args) {
        SpringApplication.run(YsmrApplication.class, args);
    }

    @GetMapping("/")
    public void index(HttpServletResponse response) throws IOException {
        response.sendRedirect("swagger-ui.html");
    }
    @GetMapping("/monitor")
    public String monitor() {
        return "ok";
    }

}
