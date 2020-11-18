package paquete;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet1 extends HttpServlet {
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8"); 
        String links = request.getParameter("links");
        int linksi = Integer.parseInt(links);
        HttpSession session = request.getSession();
        session.setAttribute("claveLinks", links);
        PrintWriter out = response.getWriter(); 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> Nav </title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<form action=\"Servlet2\" method=\"get\">");
            for (int i=0; i<linksi; i++)
            {
                out.println("Link "+i+"<br/>");
                out.println("Nombre del Link: <input type=\"text\" name='nombre_"+i+"'/>");
                out.println("URL: <input type=\"text\" name='link_"+i+"'/><br/><br/>");
            }
            out.println("<input type=\"submit\" value=\"Continuar\"/>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
    }
}