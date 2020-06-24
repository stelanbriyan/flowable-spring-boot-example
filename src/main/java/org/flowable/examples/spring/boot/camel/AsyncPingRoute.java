package org.flowable.examples.spring.boot.camel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class AsyncPingRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("flowable:CamelVariableTransmission:ping").transform().simple("${property.input} World This is camel route");
    }

}
