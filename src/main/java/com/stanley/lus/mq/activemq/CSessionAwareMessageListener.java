package com.stanley.lus.mq.activemq;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.stereotype.Component;

@Component("csessionAwareMessageListener")
public class CSessionAwareMessageListener implements SessionAwareMessageListener<TextMessage> {

	@Autowired  
    @Qualifier("queueDestination")
    private Destination destination;
	
	public void onMessage(TextMessage message, Session session) throws JMSException {
		// 收到消息
		System.out.println("-sc-：" + message.getText());
		// 返回消息
		MessageProducer messageProducer = session.createProducer(destination);
		messageProducer.send(session.createTextMessage("sessionAware收到"));
		
	}

}
