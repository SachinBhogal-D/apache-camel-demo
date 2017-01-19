package com.example;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.spi.ExceptionHandler;
import org.springframework.stereotype.Component;


@Component
public  class CustomExceptionHandler implements ExceptionHandler {


    private ProducerTemplate template;


    public void setTemplate(ProducerTemplate template) {
        this.template = template;
    }
    @Override
    public void handleException(Throwable exception) {
        handleException(exception.getMessage(), exception);
    }

    @Override
    public void handleException(String message, Throwable exception) {
        handleException(exception.getMessage(), null, exception);
    }

    @Override
    public void handleException(final String message, final Exchange originalExchange, final Throwable exception) {
        // send the message to the special direct:file-error endpoint, which will trigger exception handling
        //
        template.send("direct:file-error", new Processor() {
            @Override
            public void process(Exchange exchange) throws Exception {
                // set an exception on the message from the start so the error handling is triggered
                exchange.setException(exception);
                exchange.getIn().setBody(message);
            }
        });
    }
}
