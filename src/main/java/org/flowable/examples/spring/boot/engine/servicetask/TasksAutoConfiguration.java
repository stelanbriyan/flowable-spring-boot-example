package org.flowable.examples.spring.boot.engine.servicetask;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TasksAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(PrintDocumentGenerate.class)
    public PrintDocumentGenerate generateDocumentService() {
        return new PrintDocumentGenerate();
    }

    @Bean
    public ServiceTaskTwo taskTwo() {
        return new ServiceTaskTwo();
    }

    @Bean
    public ServiceTaskThree taskThree() {
        return new ServiceTaskThree();
    }

}