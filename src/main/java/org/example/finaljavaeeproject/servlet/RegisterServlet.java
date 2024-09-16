package org.example.finaljavaeeproject.servlet;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.example.finaljavaeeproject.dao.RoleDao;
import org.example.finaljavaeeproject.dao.UserDao;
import org.example.finaljavaeeproject.entity.User;
import org.example.finaljavaeeproject.util.EncryptDecryptUtils;
import org.example.finaljavaeeproject.util.ServletUtil;

import java.io.*;
import java.util.Date;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.servlet.ServletException;

@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {
    private static final int defaultRole = 3;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("Register page request " + new Date());
        //TODO заменить логи

        ServletUtil.forwardJsp("jsp/form/register", request, response);

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String userName = request.getParameter("user_name");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phone_number");

        String password = request.getParameter("psw");
        String repeatedPassword = request.getParameter("psw_replay");

        if (password.equals(repeatedPassword)) {
            User user = new User();
            user.setName(userName);
            user.setEmail(email);
            user.setPhoneNumber(phoneNumber);

            String encryptedPassword = EncryptDecryptUtils.encrypt(password);
            user.setPassword(encryptedPassword);

            UserDao userDAO = new UserDao();
            RoleDao roleDAO = new RoleDao();

            try {
                user.setRole(roleDAO.findById(defaultRole));
                userDAO.create(user);
                boolean isCreated = userDAO.findByEmail(email) != null;

                if (isCreated) {
                    request.setAttribute("msg", "Check email to Activate your account");
                    // TODO send mail to activated
                    ServletUtil.forwardJsp("jsp/form/register", request, response);
                } else {
                    request.setAttribute("msg", "Error User Registration");
                    ServletUtil.forwardJsp("jsp/form/register", request, response);

                    // FIXME не работает проверка на то есть ли пользователь с таким email
                }


            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("msg", "Internal Error User Registration");
                String message = ExceptionUtils.getMessage(e.getCause());
                String stackTrace = ExceptionUtils.getStackTrace(e);
                request.setAttribute("cause", StringUtils.isEmpty(message) ? ExceptionUtils.getMessage(e) : message); // извлекает сообщение
                request.setAttribute("stack-trace", stackTrace);
                ServletUtil.forwardJsp("jsp/form/register", request, response);
                return;
            }

        } else {
            request.setAttribute("msg", "Passwords do not match");
            ServletUtil.forwardJsp("jsp/form/register", request, response);
        }
        return;
    }
}
