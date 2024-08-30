package org.example.finaljavaeeproject.util;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class ServletUtil {

    public static void forwardJsp(final String path, final HttpServletRequest request,
                                  final HttpServletResponse response) throws ServletException, IOException {
        System.out.println(new Date() + ". Forward to :" + path);
        request.getRequestDispatcher(path + ".jsp").forward(request, response);
    }
}
