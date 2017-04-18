package com.gfb.webapp.sevlet;

import com.gfb.webapp.service.AccountService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by goforbroke on 17.04.17.
 */
public class SignUpServlet extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger(SignUpServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if (null == login || null == password) {
            resp.sendError(400, "Login and password must be specified.");
            return;
        }

        try {
            if (AccountService.register(login, password)) {
                LOGGER.debug("Registration done");
                resp.setStatus(200);
                resp.getWriter().println("Registered");
                return;
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } catch (ClassNotFoundException e) {
            LOGGER.error(e.getMessage());
        }

        resp.setStatus(401);
    }

}
