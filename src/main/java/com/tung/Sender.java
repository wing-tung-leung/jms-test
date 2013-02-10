package com.tung;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Destination;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Sender {

  private JmsTemplate t;
  private Destination d;

  public void setTemplate(JmsTemplate t) {
     this.t = t;
  }

  public void setDestination(Destination d) {
     this.d = d;
  }
 
  @RequestMapping("send")
  public ModelAndView send() throws Exception {
      t.convertAndSend(d, new java.util.Date().toString());
      return new ModelAndView("/index.jsp");
  }

}

