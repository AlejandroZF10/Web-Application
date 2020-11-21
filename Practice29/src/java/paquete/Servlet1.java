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
            String cadena1= request.getRealPath("/");
            String cadena2=this.getServletContext().getRealPath("/");
            out.println("<DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> Servlet Servlet 1</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>"+cadena1+"</h1><br />");
            out.println("<h1>"+cadena2+"</h1>"); 
            out.println("</body>");
            out.println("</html>");
        }
}
