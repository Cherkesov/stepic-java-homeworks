package com.gfb.webapp;

import com.gfb.webapp.jdbc.DataConnection;
import com.gfb.webapp.sevlet.MirrorServlet;
import com.gfb.webapp.sevlet.SignInServlet;
import com.gfb.webapp.sevlet.SignUpServlet;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import java.net.URL;
import java.sql.Connection;

/**
 * Created by goforbroke on 14.04.17.
 */
public class Application {
    public static void main(String[] args) throws Exception {
        URL url = Resources.getResource("test.sql");
        String text = Resources.toString(url, Charsets.UTF_8);
        Connection connection = DataConnection.openConnection();
        connection.prepareStatement(text).execute();

        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);

        // Lesson 1
        handler.addServlet(new ServletHolder(new MirrorServlet()), "/mirror");

        // Lesson 2
        handler.addServlet(new ServletHolder(new SignUpServlet()), "/signup");
        handler.addServlet(new ServletHolder(new SignInServlet()), "/signin");

        Server server = new Server(8080);
        server.setHandler(handler);

        server.start();
        System.out.println("Server started");
        server.join();
    }
}
