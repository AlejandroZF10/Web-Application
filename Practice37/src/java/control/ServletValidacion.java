
package Servlets;

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
import profe.JDOMValidador;

public class ServletValidacion extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        HttpSession session = request.getSession();
        String id = request.getParameter("id");
        String tipo = request.getParameter("tipo");
        String rutaAbsoluta = request.getSession().getServletContext().getRealPath("/"); //ruta al archivo xml 
            rutaAbsoluta = rutaAbsoluta.replace("\\", "/");//en la cadena carpeta al encontrar \\ lo sustituira por /
            rutaAbsoluta = rutaAbsoluta.replaceAll("/build", ""); //si encuentra /build lo cambiera por una cadena vacía
            rutaAbsoluta = rutaAbsoluta + "/pregunta" + tipo + id + ".xml"; //concatenar  a la ruta el nombre del archivo
        boolean flag = true;
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Validacion</title>");
        out.println("</head>");
        out.println("<body>");
        
        try{
            File archivo = new File(rutaAbsoluta);

        }catch(Exception e){
            out.println("Error al guardar el archivo");
        }
        JDOMValidador validador = new JDOMValidador();
        try{
            try{
                //¿Documento conforme?
                validador.checkConforme(rutaAbsoluta);
            }catch(JDOMException e){
                //Indicacion de un fichero mal conformado.
                out.println("NO esta bien conformado");
                out.println(e.getMessage());
                out.println("<br/>");
                out.println("<form action='Pregunta"+tipo+"' method='get'>");
                out.println("<button class='button' name='archivo' type='submit'>Regresar a editar</button>");
                out.println("<form action='BienvenidoProfe'>");
                out.println("<button class='button' type='submit'>Guardar de todos modos</button>");
                out.println("</form>");
                out.println("</form>");
                flag = false;
            }
            //Si el fichero esta bien conformado no saltara ningun error.
            if(flag){
                out.println("<div id='titulo'>Archivo guardado</div>");
                out.println("<br/>");
                out.println("<form action='BienvenidoProfe'>");
                out.println("<button class='button' type='submit'>Menu Principal</button>");
                out.println("</form>");
            }
            
            /*
            try{
                //¿Documento Valido?
                validador.checkValido(ruta);
            }catch(JDOMException e){
                //Indicacion de un fichero no valido.
                out.println("NO es valido");
                out.println(e.getMessage());
                out.println("<br/>");
            }*/
            //Si el fichero es valido no saltara ningun error.
            /*out.println("Es valido");
            out.println("<br/>");*/
        }catch(IOException e){
            //Indicacion de que el fichero no es accesible.
            out.println("No se puede acceder a " + rutaAbsoluta);
            out.println("porque " + e.getMessage());
            out.println("<br/>");
        }
        out.println("</body>");
        out.println("</html>");
    }
}
