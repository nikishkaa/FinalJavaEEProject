package org.example.finaljavaeeproject.servlet;

import org.example.finaljavaeeproject.util.ServletUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LogoutServlet", value = "/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();

        if (session.getAttribute("user") != null) {
            session.invalidate();
            //TODO добавить логи
            ServletUtil.forwardJsp("jsp/home_page", request, response);
        } else {
            ServletUtil.forwardJsp("jsp/form/login", request, response);
        }


    }


}
