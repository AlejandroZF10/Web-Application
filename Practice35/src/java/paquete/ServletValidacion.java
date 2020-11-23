package paquete;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.jdom.JDOMException;

public class ServletValidacion extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        HttpSession session = request.getSession();
        String texto = request.getParameter("texto");
        String ruta = request.getServletContext().getRealPath("/") + (String) session.getAttribute("archivo");
        boolean fC = true; //Bandera de bien conformado
        boolean fV = true; //Bandera de válido 
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Validacion</title>");
        out.println("</head>");
        out.println("<body>");
        
        try{
            File archivo = new File(ruta);
            FileWriter escritura = new FileWriter(archivo);
            escritura.write(texto);
            escritura.close();
        }catch(Exception e){
            out.println("Error al guardar el archivo");
        }
        JDOMValidador validador = new JDOMValidador();
        try{
            try{
                //¿Documento conforme?
                validador.checkConforme(ruta);
            }catch(JDOMException e){
                //Indicacion de un fichero mal conformado.
                out.println("NO esta bien conformado");
                out.println(e.getMessage());
                out.println("<br/>");
                out.println("<form action='ServletEditar' method='post'>");
                out.println("<button class='button' name='archivo' type='submit' value='"+(String) session.getAttribute("archivo")+"'>Regresar a editar</button>");
                out.println("<form action='index.html'>");
                out.println("<button class='button' type='submit'>Guardar de todos modos</button>");
                out.println("</form>");
                out.println("</form>");
                fC = false;
            }
          
            try{
                //¿Documento válido?
                validador.checkValido(ruta);
            }catch(JDOMException e){
                //Indicacion de un fichero no válido.
                out.println("NO es VÁLIDO");
                out.println(e.getMessage());
                out.println("<br/>");
                out.println("<form action='ServletEditar' method='post'>");
                out.println("<button class='button' name='archivo' type='submit' value='"+(String) session.getAttribute("archivo")+"'>Regresar a editar</button>");
                out.println("<form action='index.html'>");
                out.println("</form>");
                out.println("</form>");
                fV = false;
            }
            
            //Si el fichero esta bien conformado y es válido no saltara ningun error.
            if(fV && fC){
                out.println("<div id='titulo'>Archivo guardado con exito está bien conformado y es válido!</div>");
                out.println("<br/>");
                out.println("<form action='index.html'>");
                out.println("<button class='button' type='submit'>Menu Principal</button>");
                out.println("</form>");
            }
            else if(fC == true && fV == false){
                out.println("<div id='titulo'>Archivo guardado con exito pero no está bien conformado!</div>");
                out.println("<br/>");
                out.println("<form action='index.html'>");
                out.println("<button class='button' type='submit'>Menu Principal</button>");
                out.println("</form>");
            }
            
        }catch(IOException e){
            //Indicacion de que el fichero no es accesible.
            out.println("No se puede acceder a " + ruta);
            out.println("porque " + e.getMessage());
            out.println("<br/>");
        }
        out.println("</body>");
        out.println("</html>");
    }
}
