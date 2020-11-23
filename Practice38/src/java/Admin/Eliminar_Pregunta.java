package Admin;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Eliminar_Pregunta extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("id");
        String rutaAbsoluta = request.getSession().getServletContext().getRealPath("/"); 
        rutaAbsoluta = rutaAbsoluta.replace("\\", "/");
        rutaAbsoluta = rutaAbsoluta.replaceAll("/build", "");
        rutaAbsoluta = rutaAbsoluta+id;
        File archivo = new File(rutaAbsoluta); 
        archivo.delete();
        response.sendRedirect("Administrador");
    }
}