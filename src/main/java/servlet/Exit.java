package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static config.Config.WEB_URL_BEGIN;

/**
 * @author 刘宣兑
 */
@WebServlet(urlPatterns = "/Exit")
public class Exit extends HttpServlet {
   static final String URL = WEB_URL_BEGIN + "index.html";
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("user") != null){
            request.getSession().setAttribute("user", null);
            response.sendRedirect(URL);
        }else {
            response.setContentType("text/html");
            response.getWriter().print("<script> alert('Error, You're not logged in.'); </script>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
