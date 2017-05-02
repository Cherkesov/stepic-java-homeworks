package com.gfb.webapp.handler;

import com.gfb.webapp.web.ChatSocket;
import org.eclipse.jetty.websocket.server.WebSocketHandler;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;

/**
 * Created by goforbroke on 02.05.17.
 */
public class ChatWebSocketHandler extends WebSocketHandler {
    public void configure(WebSocketServletFactory webSocketServletFactory) {
        webSocketServletFactory.register(ChatSocket.class);
    }
}
