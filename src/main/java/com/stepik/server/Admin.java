package com.stepik.server;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class Admin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        HttpSession session = req.getSession();
        String admin =(String) session.getAttribute("Admin");
        if (admin != null && admin.equals("Admin")) {
            writer.println("You admin");
        } else {
            writer.println("who are u?");
        }
    }
}
