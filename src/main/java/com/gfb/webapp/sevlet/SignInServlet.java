package com.gfb.webapp.sevlet;

import com.gfb.webapp.service.AccountService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by goforbroke on 17.04.17.
 */
public class SignInServlet extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger(SignInServlet.class);

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
            if (AccountService.authorize(login, password)) {
                resp.setStatus(200);
                resp.getWriter().println("Authorized: " + login);
                LOGGER.info("Authorized: " + login);
                return;
            } else {
                resp.setStatus(401);
                resp.getWriter().println("Unauthorized");
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } catch (ClassNotFoundException e) {
            LOGGER.error(e.getMessage());
        }

        resp.setStatus(400);
    }

}
