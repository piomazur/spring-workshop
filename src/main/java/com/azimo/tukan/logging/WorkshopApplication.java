package com.azimo.tukan.logging;

import com.azimo.tukan.logging.micrometer.FragileInner;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import static net.logstash.logback.argument.StructuredArguments.keyValue;
import static net.logstash.logback.argument.StructuredArguments.kv;

@Slf4j
@SpringBootApplication
@EntityScan
@EnableAspectJAutoProxy
public class WorkshopApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder().bannerMode(Banner.Mode.OFF).sources(WorkshopApplication.class).run(args);

        String simpleKeyValue = "123";
        log.error("Simple key value {}", keyValue("simpleKeyValue", simpleKeyValue));

        FragileInner fragile = FragileInner.builder()
                .fragileOne("password")
                .fragileTwo("login")
                .exposableOne("city")
                .exposableTwo("some unimportant things")
                .build();

        System.out.println(fragile);

        log.error("Complex with fragile info {}", kv("fragile", fragile));


        log.error("Fragile: {}", fragile.getExposableOne());
        System.out.println(fragile.dupa());
    }
}
