package org.example.finaljavaeeproject.servlet;

import org.example.finaljavaeeproject.util.ServletUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PasswordRecoveryServlet", value = "/recover")
public class PasswordRecoveryServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

//        TODO добавить логи
        ServletUtil.forwardJsp("jsp/form/password_recovery", request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }
}
