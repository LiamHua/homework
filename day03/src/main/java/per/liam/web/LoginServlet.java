package per.liam.web;

import org.apache.commons.beanutils.BeanUtils;
import per.liam.domain.User;
import per.liam.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @author liam
 * @date {DATE} {TIME}
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> userMap = request.getParameterMap();
        User u = new User();

        // 将数据映射到user对象上
        try {
            BeanUtils.populate(u, userMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 检查账户密码是否匹配
        UserService userService = new UserService();
        boolean flag = userService.checkUser(u);

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = response.getWriter();


        if (flag) {
            // 获取当前时间
            String time = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss").format(new Date());
            String lastTime = null;

            // 获取所有cookie
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                // 获取上次登陆时间并更新时间
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("lastTime")) {
                        lastTime = cookie.getValue();
                        cookie.setValue(time);
                        response.addCookie(cookie);
                    }
                }
                writer.println("欢迎 " + u.getUsername() + " 归来，您上次访问时间为 " + lastTime);
                writer.println("<a href=\"commodities.html\">查看商品</a>");
            } else {
                // 没有获取到cookie表明是第一次登陆
                Cookie lastTimeCookie = new Cookie("lastTime", time);
                writer.write("登陆成功，欢迎 " + u.getUsername() + "这是您第一次登陆！");
                writer.println("<a href=\"commodities.html\">查看商品</a>");
                response.addCookie(lastTimeCookie);
            }

            // 记住用户名
            String rememberMe = request.getParameter("rememberMe");
            String isRememberMe = "true";
            if (isRememberMe.equals(rememberMe)) {
                Cookie nameCookie = new Cookie("name", u.getUsername());
                nameCookie.setMaxAge(3600*24*7);
                response.addCookie(nameCookie);
            }
        } else {
            writer.write("<h2>账户密码不匹配，请<a href=\"index.html\">重新登陆</a></h2>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
