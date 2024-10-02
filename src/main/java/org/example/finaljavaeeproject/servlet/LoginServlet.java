package org.example.finaljavaeeproject.servlet;

import org.example.finaljavaeeproject.dao.UserDaoImpl;
import org.example.finaljavaeeproject.entity.User;
import org.example.finaljavaeeproject.util.EncryptDecryptUtils;
import org.example.finaljavaeeproject.util.ServletUtil;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.servlet.ServletException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private UserDaoImpl userDAO = new UserDaoImpl();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();

        if (session.getAttribute("user") != null) {
            ServletUtil.forwardJsp("jsp/home_page", request, response);
        } else {
            ServletUtil.forwardJsp("jsp/form/login", request, response);
        }


//        TODO добавить логи
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        final String email = request.getParameter("email");
        final String password = request.getParameter("psw");

        User user = userDAO.findByEmail(email);
        if (user != null) {
            if (user.getPassword().equals(EncryptDecryptUtils.encrypt(password))) {
                HttpSession session = request.getSession();

                session.setAttribute("user", user);

                ServletUtil.forwardJsp("jsp/home_page", request, response);
                return;
            } else {
                request.setAttribute("msg", "Password or Email Invalid");
                ServletUtil.forwardJsp("jsp/form/login", request, response);
                return;
            }
        } else {
            request.setAttribute("msg", "Password or Email Invalid");
            ServletUtil.forwardJsp("jsp/form/login", request, response);
            return;
        }

    }
}
