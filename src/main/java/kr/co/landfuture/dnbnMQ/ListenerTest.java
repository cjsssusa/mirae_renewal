package kr.co.landfuture.dnbnMQ;

import java.io.IOException;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import kr.co.landfuture.util.UtilFunc;

@Component
public class ListenerTest {
    Gson gson;

    public ListenerTest() {
        gson = new Gson();
    }

    @JmsListener(destination = "test.inbound.queue")
    @SendTo("dnbn.outbound.queue")
    public String receiveMessage(final Message jsonMessage) throws JMSException, JsonSyntaxException, IOException {
        String messageData = null;
        System.out.println("Received message " + jsonMessage);
        String response = null;
        if (jsonMessage instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) jsonMessage;
            messageData = textMessage.getText();
            if (UtilFunc.isJsonValid(messageData)) {
                // Map map = gson.fromJson(messageData, Map.class);
                // response = "Hello " + map.get("name");
                QueueData qData = gson.fromJson(messageData, QueueData.class);
                response = qData.getJobTp();
            }
        } else {
            response = messageData;
        }
        return response;
    }
}