package com.gfb.webapp.sevlet;

import com.gfb.webapp.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by goforbroke on 17.04.17.
 */
public class SignInServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
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
                resp.getWriter().print("Authorized");
            } else {
                resp.setStatus(401);
                resp.getWriter().print("Unauthorized");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            resp.getWriter().print(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            resp.getWriter().print(e.getMessage());
        }

        resp.setStatus(400);
    }
}
