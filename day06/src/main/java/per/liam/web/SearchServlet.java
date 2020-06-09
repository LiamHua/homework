package per.liam.web;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import per.liam.domain.User;
import per.liam.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author liam
 * @date 2020/6/8 23:17
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        response.setContentType("text/html; charset=UTF-8");
        String username = request.getParameter("username");
        System.out.println(username);
        if (username != null) {
            UserService userService = new UserService();
            List<User> users = userService.searchUserService(username);
            System.out.println(users);
            String s = null;
            if (users.isEmpty()) {
                s = new Gson().toJson("没有查询到用户数据");
            }else {
                s = new Gson().toJson(users);
            }
            response.getWriter().write(s);
        }else {
            response.getWriter().write( "没有查询到用户数据");
        }

    }
}
