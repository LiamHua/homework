package per.liam.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author liam
 * @date 2020/6/2 21:00
 */
@WebServlet("/InitServlet")
public class InitServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("执行了post请求...");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("执行了get请求...");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("执行了service方法...");
        super.service(req, resp);
    }

    @Override
    public void init() throws ServletException {
        System.out.println("执行了init方法...");
        super.init();
    }

    @Override
    public void destroy() {
        System.out.println("执行了destroy方法...");
        super.destroy();
    }
}
