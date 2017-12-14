package com.yangle.queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.jms.core.JmsTemplate;

/**
 * Created by yangle on 2017/10/12.
 */
public class MessageSender {


    private JmsTemplate jmsTemplate;
    private ActiveMQQueue activeMQQueue;
    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }
    public void sendMessages(Object message){this.jmsTemplate.convertAndSend(this.activeMQQueue,message);}
    public void setActiveMQQueue(ActiveMQQueue activeMQQueue) {
        this.activeMQQueue = activeMQQueue;
    }
}
