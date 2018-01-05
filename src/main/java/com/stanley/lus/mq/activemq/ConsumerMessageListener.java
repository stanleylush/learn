package com.stanley.lus.mq.activemq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsumerMessageListener implements MessageListener {

	@Autowired  
    private TestDao testDao;  
    private int count = 0;
    
	public void onMessage(Message message) {
		//这里我们知道生产者发送的就是一个纯文本消息，所以这里可以直接进行强制转换  
        TextMessage textMsg = (TextMessage) message;
        try {  
            System.out.println("-c-：" + textMsg.getText());
            System.out.println("当前count的值是：" + count);  
            testDao.insert(textMsg.getText() + count);  
            if (count == 0) {  
                count ++;  
                throw new RuntimeException("Error! 出错啦！");  
            }
        } catch (JMSException e) {  
            e.printStackTrace();  
        }
	}

}
