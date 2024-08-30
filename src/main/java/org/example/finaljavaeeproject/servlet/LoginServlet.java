package org.example.finaljavaeeproject.servlet;

import org.example.finaljavaeeproject.util.ServletUtil;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.servlet.ServletException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

//        ДОБАВИТЬ ЛОГИ
        ServletUtil.forwardJsp("jsp/login", request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }
}
