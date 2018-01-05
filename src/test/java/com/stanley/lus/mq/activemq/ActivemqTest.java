package com.stanley.lus.mq.activemq;

import javax.jms.Destination;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration("/spring-jms.xml") 
public class ActivemqTest {
	@Autowired  
    private ProducerService producerService;  
    @Autowired  
    @Qualifier("queueDestination")  
    private Destination destination;
    @Autowired  
    @Qualifier("sessionAwareDestination")  
    private Destination sessionAwareDestination;
      
    @Test  
    public void testSend() {  
        for (int i=0; i<1; i++) {
            producerService.sendMessage(destination, "消息" + (i+1));  
        }  
    }
    
    @Test  
    public void testSessionAwareSend() {
        producerService.sendMessage(sessionAwareDestination, "sessionAware消息");  
    }
}
