package paquete;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletBorrar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String ruta = request.getServletContext().getRealPath("/") + request.getParameter("archivo");
        File archivo = new File(ruta);
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Borrar</title>");
        out.println("</head>");
        out.println("<body>");
        if(archivo.delete()){
            out.println("<div id='titulo'>El archivo fue borrado exitosamente</div>");
            out.println("<form action='index.html'>");
            out.println("<button class='button' type='submit'>Menu Principal</button>");
            out.println("</form>");
        }else{
            out.println("<div id='titulo'>El archivo no se pudo borrar</div>");
            out.println("<form action='index.html'>");
            out.println("<button class='button' type='submit'>Menu Principal</button>");
            out.println("</form>");
        }
        out.println("</body>");
        out.println("</html>");
    }
}
