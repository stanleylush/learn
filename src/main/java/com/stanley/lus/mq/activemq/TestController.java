package com.stanley.lus.mq.activemq;

import java.util.Date;

import javax.jms.Destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller  
@RequestMapping("test")
public class TestController {
	@Autowired  
    @Qualifier("queueDestination")  
    private Destination destination;  
      
    @Autowired  
    private ProducerService producerService;  
      
    @RequestMapping("first")  
    public String first() {  
        producerService.sendMessage(destination, "你好，现在是：" + new Date().toLocaleString());  
        return "/test/first";  
    }
}
