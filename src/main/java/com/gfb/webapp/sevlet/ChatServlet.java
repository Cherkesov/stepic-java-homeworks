package com.gfb.webapp.sevlet;

import com.gfb.webapp.web.ChatSocket;
import org.eclipse.jetty.websocket.servlet.WebSocketServlet;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;

/**
 * Created by goforbroke on 02.05.17.
 */
public class ChatServlet extends WebSocketServlet {
    public void configure(WebSocketServletFactory webSocketServletFactory) {
        webSocketServletFactory.register(ChatSocket.class);
    }
}
