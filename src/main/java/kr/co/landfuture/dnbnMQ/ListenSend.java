package kr.co.landfuture.dnbnMQ;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;
import javax.sound.midi.Receiver;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import kr.co.landfuture.util.Def;
import kr.co.landfuture.util.UtilFunc;

@Component
public class ListenSend {
    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);
    private Gson gson = new Gson();
    public static int cc_order = 0;
    Map<String, Integer> map_jc_odr = new HashMap<String, Integer>();

    public ListenSend() {
        map_jc_odr.put("abi", 0);
        map_jc_odr.put("fname", 0);
    }

    @JmsListener(destination = "dnbn.inbound.queue")
    @SendTo("dnbn.outbound.queue")
    public String receive(final Message aMessage) throws JMSException, JsonSyntaxException, IOException {
        String messageData = null;
        String response = null;
        String jobTp = null;
        LOGGER.info("received message='{}'", aMessage);
        // ------------------
        if (aMessage instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) aMessage;
            messageData = textMessage.getText();
            if (UtilFunc.isJsonValid(messageData)) {
                // Map map = gson.fromJson(messageData, Map.class);
                // response = "Hello " + map.get("name");
                QueueData qData = gson.fromJson(messageData, QueueData.class);
                jobTp = qData.getJobTp();
            } else {
                jobTp = messageData;
            }

            if (!map_jc_odr.containsKey(jobTp))
                return "NA";
        } else {
            response = "NA";
        }
        // ------------------
        cc_order = map_jc_odr.get(jobTp);
        response = Def.CC_CN_array[cc_order++ % 59][0];
        map_jc_odr.put(jobTp, cc_order);
        return response;
    }
}
