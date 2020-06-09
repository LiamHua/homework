package per.liam.web;

import per.liam.domain.User;
import per.liam.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author liam
 * @date 2020/6/2 21:38
 */
@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        UserService userService = new UserService();
        boolean b = userService.addUser(user);

        PrintWriter writer = response.getWriter();
        if (b) {
            writer.write("<h1>注册成功，3秒后转到登陆页面</h1>");
            response.setHeader("refresh", "3;url=index.html");
        } else {
            writer.write("<h1>该用户已存在，请重新注册！</h1>");
            response.setHeader("refresh", "3;url=register.html");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
