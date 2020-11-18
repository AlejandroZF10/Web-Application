package paquete;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet2 extends HttpServlet {
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8"); 
        HttpSession session = request.getSession();
        String links = (String)session.getAttribute("claveLinks");
        int linksi = Integer.parseInt(links);
        PrintWriter out = response.getWriter(); 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> Nav </title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<nav>");
            for (int i=0; i<linksi; i++)
            {
                out.println("<a href='"+request.getParameter("link_"+i)+"'>"+request.getParameter("nombre_"+i)+"</a> |");
            }
            out.println("</nav>");
            out.println("</body>");
            out.println("</html>");
    }
}