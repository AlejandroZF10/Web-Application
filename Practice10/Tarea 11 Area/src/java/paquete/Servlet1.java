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
        String seleccion = request.getParameter("Seleccion");
        HttpSession session = request.getSession();
        //session.setAttribute("clavedatos",datos);
        PrintWriter out = response.getWriter(); 
        if(seleccion.compareTo("SolarSis")==0)
        {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Sistema Solar</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<p>¡Haz click en el Sol o los otros planetas para verlos de cerca!</p>");
            out.println("<img src=\"planets.gif\" width=\"145\" height=\"126\" alt=\"Planets\" usemap=\"#planetmap\">");
            out.println("<map name=\"planetmap\">");
            out.println("<area shape=\"rect\" coords=\"0,0,82,126\" alt=\"Sun\" href=\"sun.html\">");
            out.println("<area shape=\"circle\" coords=\"90,58,3\" alt=\"Mercury\" href=\"mercur.html\">");
            out.println("<area shape=\"circle\" coords=\"124,58,8\" alt=\"Venus\" href=\"venus.html\">");
            out.println("</map>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}




  
  
  
