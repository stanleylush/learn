package com.stanley.lus.mq.activemq;

import javax.jms.Destination;

public interface ProducerService {

	public void sendMessage(Destination d, String message);
}
