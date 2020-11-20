package Paquete;

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
            String numerolineas = request.getParameter("numerolineas");
            int numerolineasi = Integer.parseInt(numerolineas);
            HttpSession session = request.getSession();
            session.setAttribute("clave1",numerolineas);
            PrintWriter out = response.getWriter();
            out.println("<DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> Servlet Servlet 1</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<form action='Servlet2' method='get'>");
            for(int i=0;i<numerolineasi;i++){
                out.println("Punto de inicio XI <input type = 'text' name = 'xi_"+i+"'/><br/>");
                out.println("Punto de inicio YI <input type = 'text' name = 'yi_"+i+"'/><br/>");
                out.println("Punto de fin XF <input type = 'text' name = 'xf_"+i+"'/><br/>");
                out.println("Punto de fin YF <input type = 'text' name = 'yf_"+i+"'/><br/><br/>");
            }
            out.println("<input type='submit' />");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
}