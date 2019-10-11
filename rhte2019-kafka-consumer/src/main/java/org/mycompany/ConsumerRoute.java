package org.mycompany;

import static org.apache.camel.model.rest.RestParamType.body;
import static org.apache.camel.model.rest.RestParamType.path;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.mycompany.*;

@Component
public class ConsumerRoute extends RouteBuilder {
	@Autowired
	private Environment env;

	@Value("${camel.component.servlet.mapping.context-path}")
	private String contextPath;

	@Override
	public void configure() throws Exception {
		
		//from("kafka:dbserver1.inventory.customers?brokers=broker-kafka-bootstrap.test.svc:9092").log("Message received: ${body}").unmarshal().json(JsonLibrary.Jackson, ChangeEvent.class).to("direct:update-customer");
		
		// consumer.seekTo = beginning
		//from("kafka:{{consumer.topic}}?brokers={{kafka.host}}:{{kafka.port}}&seekTo={{consumer.seekTo}}").log("Message received: ${body}").unmarshal().json(JsonLibrary.Jackson, ChangeEvent.class).to("direct:update-customer");
		
		//from("kafka:{{consumer.topic}}?brokers={{kafka.host}}:{{kafka.port}}").log("Message received: ${body}").unmarshal().json(JsonLibrary.Jackson, ChangeEvent.class).to("direct:update-customer");
		
		
		// receive change event and verify message structure	
		from("kafka:{{consumer.topic}}?brokers={{kafka.host}}:{{kafka.port}}")
			
			.doTry()
				.log("<< Begin message receive...>>")
				.log("Message received: ||${body}||.")
				.unmarshal().json(JsonLibrary.Jackson, ChangeEvent.class)
				.log("Processing change event.")
				.to("direct:update-customer")
			.doCatch(org.apache.camel.NoTypeConversionAvailableException.class)
				.log("Unable to parse incoming message.")
			.doFinally()
				.log("<< End message receive>>.");
			
		// process change event
		from("direct:update-customer")
			.to("bean:customerService?method=updateCustomerWithChangeEvent")
			.outputType(Customers.class)
			.log("Return value: ${body}");
		
	}

}