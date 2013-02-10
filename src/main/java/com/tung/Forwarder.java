package com.tung;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Destination;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.jms.core.JmsTemplate;

public class Forwarder implements MessageListener {

  private JmsTemplate t;
  private Destination d;

  public void setTemplate(JmsTemplate t) {
     this.t = t;
  }

  public void setDestination(Destination d) {
     this.d = d;
  }
 
 public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            try {
                System.out.println("FWD = " + ((TextMessage) message).getText());
                t.convertAndSend(d, message);
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

