package com.yangle.queue;

import org.apache.log4j.Logger;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

/**
 * Created by yangle on 2017/10/13.
 */
public class ActiveMQQueueListener implements javax.jms.MessageListener{
    private Logger logger=Logger.getLogger(ActiveMQQueueListener.class);
    @Override
    public void onMessage(Message message) {
        if(message instanceof TextMessage){
            TextMessage message1s= (TextMessage) message;
            try {

                logger.info("收到一条消息:"+((TextMessage) message).getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
        System.out.println("aadsad");
    }
}
