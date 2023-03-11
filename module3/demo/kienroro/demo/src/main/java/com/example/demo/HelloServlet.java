package com.example.demo;

import java.io.*;
import java.util.Date;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "ServerTimServlet", value = "/index")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
//        out.println("<html>");
//        out.println("<h1>Hello world</h1>");
//        out.println("</html>");
        out.println("<html>");
        Date today = new Date();
        out.println("<h1>" + today + "</h1>");
        out.println("</html>");
    }

    public void destroy() {
    }
}