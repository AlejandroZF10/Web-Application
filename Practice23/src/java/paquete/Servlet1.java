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
        String numeroLineas = request.getParameter("numeroLineas");
        HttpSession session = request.getSession();
        session.setAttribute("clavenumeroLineas", numeroLineas);
        int numeroLineasi = Integer.parseInt(numeroLineas);
        PrintWriter out = response.getWriter(); 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Elipses a Dibujar</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<form action='Servlet2' method='get'>");
            for(int i=0;i<numeroLineasi;i++){
                out.println("Elipse "+i+"<br/>");
                out.println("Punto XI <input type='text' name='xi_"+i+"'/></br>Punto YI <input type='text' name='yi_"+i+"'/><br/>"
                        + "Radio XI <input type='text' name='r1_"+i+"'/></br>Radio YI <input type='text' name='r2_"+i+"'/>"
                        + "</br>Rotacion I <input type='text' name='rot_"+i+"'/></br>Angulo Inicial I <input type='text' name='a1_"+i+"'/>"
                        + "</br>Angulo Final I <input type='text' name='a2_"+i+"'/><br/>");
                out.println("Color <input type='text' name='Color_"+i+"'/><br/><br/>");
            }
            out.println("<input type='submit' value='Enviar'");
            out.println("</body>");
            out.println("</html>");
    }
}