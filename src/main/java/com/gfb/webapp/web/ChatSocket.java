package com.gfb.webapp.web;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

/**
 * Created by goforbroke on 02.05.17.
 */
@WebSocket
public class ChatSocket {

    private static final Logger LOGGER = LogManager.getLogger(ChatSocket.class);

    @OnWebSocketMessage
    public void onMessageReceived(Session session, String message) {
        LOGGER.info("Got message - " + message);
        if (session.isOpen()) {
            session.getRemote().sendString(message, null);
        }
    }

}
