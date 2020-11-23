package paquete;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletCrear extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String ruta = request.getServletContext().getRealPath("/") + request.getParameter("nombre");
        File archivo = new File(ruta);
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Nuevo</title>");
        out.println("</head>");
        out.println("<body>");
        if(archivo.exists()) {
            out.println("El archivo ya existe, seleccione un nombre diferente");
            out.println("<form action='ServletIntermedio' method='post'>");
            out.println("<button class='button' name='opcion' type='submit' value='nuevo'>Regresar</button>");
            out.println("</form>");
        }else {
            BufferedWriter escritura = new BufferedWriter(new FileWriter(archivo));
            out.println("Archivo creado con exito!<br/>");
            out.println("<form action='ServletEditar' method='post'>");
            out.println("<button class='button' name='archivo' type='submit' value='"+request.getParameter("nombre")+"'>Aceptar</button>");
            out.println("</form>");
            escritura.close();
        }
        out.println("</body>");
        out.println("</html>");
    }
}
