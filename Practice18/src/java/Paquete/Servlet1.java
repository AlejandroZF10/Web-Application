package Paquete;

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet1</title>");            
            out.println("</head>");
            out.println("<frameset cols='*,200' frameborder='yes' border='1'>");
            out.println("<frame src='PaginaIzquierda.html' name='izquierdo'/>");
            out.println("<frame src='PaginaDerecha.html' name='derecho'/>");
            out.println("</frameset>");
            out.println("<noframes>");
            out.println("<body>");
            out.println("</body>");
            out.println("</noframes>");
            out.println("</html>");
        }
    }