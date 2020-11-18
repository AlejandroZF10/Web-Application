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
        String texto = request.getParameter("texto");
        PrintWriter out = response.getWriter(); 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Article</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<article>");
            out.println("<h1>Texto con Article</h1>");
            out.println("<p>"+texto+"</p>");
            out.println("</article>");
            out.println("<h1>Texto sin Article</h1>");
            out.println("<p>"+texto+"</p>");
            out.println("</body>");
            out.println("</html>");
    }
}