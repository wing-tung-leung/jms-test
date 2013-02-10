package com.tung;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Destination;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.jms.core.JmsTemplate;

public class Receiver implements MessageListener {

 public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            try {
                System.out.println("RCV = " + ((TextMessage) message).getText());
            }
            catch (JMSException ex) {
                throw new RuntimeException(ex);
            }
        }
        else {
            throw new IllegalArgumentException("Message must be of type TextMessage");
        }
    }

}

