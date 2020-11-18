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
        String seleccion = request.getParameter("Seleccion");
        String texto = request.getParameter("texto");
        if(seleccion.compareTo("rtl")==0)
        {
           out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>BDO</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("El texto '"+ texto +"' aparecerá de derecha a izquierda<br/><br/>");
            out.println("<bdo dir='rtl'>"+ texto +"</bdo>");
            out.println("</body>");
            out.println("</html>"); 
        }
        if(seleccion.compareTo("ltr")==0)
        {
           out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>BDO</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("El texto '"+ texto +"' aparecerá de izquierda a derecha<br/><br/>");
            out.println("<bdo dir='ltr'>"+ texto +"</bdo>");
            out.println("</body>");
            out.println("</html>"); 
        } 
    }
}