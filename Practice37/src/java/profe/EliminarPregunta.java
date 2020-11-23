/**
 * @author
 * JIMENEZ MUÑOZ ARVID
 * LASTIRI ALFARO MARIA FERNANDA
 * MELENDEZ MACEDONIO JONATHAN 
 * QUINTANA RUIZ AJITZI RICARDO 
 */
package profe;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class EliminarPregunta extends HttpServlet { //Public es un modificador de clase, no es modificador de acceso
   
    @Override //Es una notación 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)//Protected en este caso si es un modificador de acceso, HTTPServelet son parámetros de entrada: request es de lado clienteservidor, response, el servidor WEB es el que proporciona los objetos request y response
         throws ServletException, IOException { 
         response.setContentType("text/html;charset=UTF-8"); //indica que se esta trabajando con una página html
         PrintWriter out = response.getWriter(); // se recupera el objeto out que nos permite establecer el canal de comunicación con el cliente, indicamos que enviaremos un flujo de salida de texto
           String tipo = request.getParameter("tipo"); //recuperamos el tipo de pregunta que es H o M
           String id = request.getParameter("id"); //recuepramos el número de pregunta que se va a eliminar
           
           
           String rutaAbsoluta = request.getSession().getServletContext().getRealPath("/"); //ruta al archivo xml 
            rutaAbsoluta = rutaAbsoluta.replace("\\", "/");//en la cadena carpeta al encontrar \\ lo sustituira por /
            rutaAbsoluta = rutaAbsoluta.replaceAll("/build", ""); //si encuentra /build lo cambiera por una cadena vacía
            rutaAbsoluta = rutaAbsoluta + "/pregunta" + tipo + id + ".xml"; //concatenar  a la ruta el nombre del archivo 
            
            File archivo = new File(rutaAbsoluta); //apuntador a archivo 
            archivo.delete(); //borra archivo xml

            response.sendRedirect("BienvenidoProfe"); //redireccionamiento a BienvenidoProfe

        }
    }