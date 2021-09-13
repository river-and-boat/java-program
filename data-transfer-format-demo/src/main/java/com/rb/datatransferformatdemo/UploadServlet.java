package com.rb.datatransferformatdemo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/upload")
public class UploadServlet extends HttpServlet {
    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) {
        String nameParam = req.getParameter("name");
        String nameAge = req.getParameter("age");
        System.out.println("GET请求: " + nameParam + ", age: " + nameAge);
    }

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) {
        String nameParam = req.getParameter("name");
        String nameAge = req.getParameter("age");
        String fileParam = req.getParameter("file");
        System.out.println("POST请求: " + nameParam + ", age: " + nameAge + ", file: " + fileParam);
    }
}
