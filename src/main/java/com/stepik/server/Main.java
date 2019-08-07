package com.stepik.server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;

import javax.servlet.Servlet;

public class Main {

    public static void main(String[] args) throws Exception {
        Frontend frontend = new Frontend();
        Admin admin = new Admin();
        Login login = new Login();
        Exit exit = new Exit();
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(frontend),"/");
        context.addServlet(new ServletHolder(login), "/login");
        context.addServlet(new ServletHolder(admin), "/admin");
        context.addServlet(new ServletHolder(exit), "/exit");

        context.getSessionHandler().getSessionManager().setMaxInactiveInterval(1);
        Server server = new Server(8080);
        server.setHandler(context);
        server.start();
        System.out.println("Server started");

    }

}
