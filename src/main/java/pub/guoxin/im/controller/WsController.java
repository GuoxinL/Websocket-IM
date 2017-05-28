package pub.guoxin.im.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * Created by guoxin on 17-5-25.
 */
@Controller
public class WsController {
    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chat")
    public void handleChat(Principal principal, String msg) {
        System.out.println(principal.toString());
        String name = principal.getName();
        if (name.equals("sang")) {
            sendUser(name, "lenve", msg);
        } else {
            sendUser(name, "sang", msg);
        }
    }

    private void sendUser(String name, String toName, String msg) {
        messagingTemplate.convertAndSendToUser(toName, "/queue/notifications", name + "给您发来了消息：" + msg);

    }
}