package paquete;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8"); 
        PrintWriter out = response.getWriter(); 
        String appletEjemplo = request.getParameter("appletEjemplo");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> </title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<applet code='"+ appletEjemplo +".class' width=\"300\" height=\"100\">");
            response.sendRedirect("AppletSimple.java");
            out.println("</applet>");
            out.println("</body>");
            out.println("</html>");
    }
}