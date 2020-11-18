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
        String user = request.getParameter("usuario");
        String pass = request.getParameter("pass");
        PrintWriter out = response.getWriter(); 
        
        if ("Alejandro".equals(user) && "pass".equals(pass)){
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Bienvenido</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("Bienvenido!");
            out.println("</body>");
            out.println("</html>"); 
        }
        else 
        {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>LABEL EJEMPLO CONTRASEÑA</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<form action=\"Servlet1\" method=\"get\">");
            out.println("INGRESA TU CONTRASEÑA DE NUEVO</br></br>");
            out.println("<label>Nombre de usuario: <input type=\"text\" name=\"usuario\"></label>");
            out.println("<label>Contrasena: <input type=\"password\" name=\"pass\"></label>");
            out.println("<input type=\"submit\" value=\"Enviar datos\">");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>"); 
        }
    }
}        