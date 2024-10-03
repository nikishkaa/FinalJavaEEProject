package org.example.finaljavaeeproject.servlet;

import org.example.finaljavaeeproject.util.ServletUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HomePageServlet", value = "/home")
public class HomePageServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // TODO логи
        ServletUtil.forwardJsp("jsp/home_page.jsp", request, response);
    }


}
