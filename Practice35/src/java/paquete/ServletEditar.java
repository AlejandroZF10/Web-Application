package paquete;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletEditar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String ruta = request.getServletContext().getRealPath("/") + request.getParameter("archivo");
        String texto = "";
        FileReader lectura = new FileReader(ruta);
        BufferedReader contenido = new BufferedReader(lectura);
        HttpSession session = request.getSession();
        session.setAttribute("archivo", request.getParameter("archivo"));
         
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Editar XML</title>"); 
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Escribe tu archivo</h1><textarea name='texto' rows='20' cols='100' form='formulario'>");
        while((texto=contenido.readLine())!=null){
            out.println(texto);
        }
        out.println("</textarea>");
        out.println("<form action='ServletValidacion' method='post' id='formulario'>");
        out.println("<button class='button' type='submit'>Guardar Archivo</button>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
}
