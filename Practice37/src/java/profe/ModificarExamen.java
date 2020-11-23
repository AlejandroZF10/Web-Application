/**
 * @author
 * JIMENEZ MUÑOZ ARVID
 * LASTIRI ALFARO MARIA FERNANDA
 * MELENDEZ MACEDONIO JONATHAN 
 * QUINTANA RUIZ AJITZI RICARDO 
 */
package profe;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

public class ModificarExamen extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        session.setAttribute("filename",null); //creamos atributo llamado filename con valor nulo
        String userName = (String) session.getAttribute("userName"); //recurperamos el atributo de nombre de usuario
        PrintWriter out = response.getWriter(); // se recupera el objeto out que nos permite establecer el canal de comunicación con el cliente, indicamos que enviaremos un flujo de salida de texto
        int cont=0;
        session.setAttribute("cont",cont); //creamos atributo llamado contador, con el valor de la varible contador 
        String ex=request.getParameter("id"); //recuperamos el id del examen a modificar 
        String rutaAbsoluta = request.getSession().getServletContext().getRealPath("/"); //ruta del archivo xml 
        rutaAbsoluta = rutaAbsoluta.replace("\\", "/"); //en la cadena carpeta al encontrar \\ lo sustituira por /
        rutaAbsoluta = rutaAbsoluta.replaceAll("/build", ""); //si encuentra /build lo cambiera por una cadena vacía
        rutaAbsoluta = "file:///"+rutaAbsoluta + "examen" +  ex + ".xml"; //se le concatena a la ruta el nombre del archivo 
        
        

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Servlet1</title>");
        out.println("<link type='text/css' rel='stylesheet' href='http://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/hot-sneaks/jquery-ui.css' />");
        out.println("<link rel='stylesheet' type='text/css' href='https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css'/>");
        out.println("<link rel='stylesheet' href='fondoYletra.css'>");
        out.println("<style>");
        out.println("#main{");
        out.println("  margin: 10px auto;");
        out.println("  width: 600px;");
        out.println("border: 3px solid #000000;");
        out.println(" border-radius: 5px;");
        out.println("background-color: #FFFFFF;");
        out.println("text-align: center;");
        out.println("}");
        out.println(".caja{");
        out.println("  height: 30px;");
        out.println("}");
        out.println("table{");
        out.println("   width: 100%;");
        out.println("   text-align: left;");
        out.println("   border: 1px solid #E1E1E1;");
        out.println("}");
        out.println(".button{");
        out.println("     margin: 10px 10px 30px;");
        out.println("}");
        out.println("#dialog-link{");
        out.println("    margin: 20px 0px 20px 85%;");
        out.println("}");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<button id='dialog-link' class='ui-button ui-corner-all ui-widget'>");
        out.println("		<span class='ui-icon ui-icon-home'></span> Log Out");
        out.println("	</button>");
        out.println("<div id='main'>");

        out.println("<h1>CREACIÓN DE EXAMEN</h1>");
        out.println("<form method='post' id='f1' action='SobrescribirExamen'>");
        out.println("<button form='f1' type='submit' class='button' >");
        out.println("Crear Examen");
        out.println("</button>");
        out.println("<br>");
        
        
        
        
        String carpeta = request.getSession().getServletContext().getRealPath("/"); //ruta donde esta guardado los archivos 

        carpeta = carpeta.replace("\\", "/");
        carpeta = carpeta.replaceAll("/build", "");
        File ruta = new File(carpeta); //apuntador a carpeta
        File[] archivo = ruta.listFiles();// se crea un arreglo con los archivos en la ruta
        
        out.println("ID del Examen: <input value='"+ex+"' type='text' name='id' class='caja' />"); //el valor 'ex' es el id del examen 
        out.println("<br>");
        out.println("<br>");
        //creacion de tabla para enlistar las preguntas y sus respectivas opciones 
        out.println("<table id='myTable' class='display' style='width:100%'");
        out.println("<thead>");
        out.println("        <tr>");
        out.println("            <th>Nombre</th>");
        out.println("            <th>Opciones</th>");
        out.println("            <th>Tipo</th>");
        out.println("<th>Seleccionar</th>");
        out.println("        </tr>");
        out.println(" </thead>");
        out.println("<tbody>");
        if (archivo != null) {//evaluamos si la carpeta tiene archivos 
            //recorremos el vector
            for (int i = 0; i < archivo.length; i++) {
                //evaluamos si el archivo o ruta es una carpeta
                if (archivo[i].isDirectory() == false) {
                    if (archivo[i].getName().startsWith("pregunta") && archivo[i].getName().startsWith("preguntaM")) { //verificamos que el nombre del archivo empiece con la palabra 'preguntaM'
                        //se crea una fila para la tabla con tres celdas
                        out.println("<tr>");
                        out.println("<td>Pregunta " + archivo[i].getName().charAt(9) + "</td>"); //creacion de celda con el nombre del archivo, concatenando su numero de serie
                        out.println("<td><a href='VerPreguntas?id=" + archivo[i].getName().charAt(9) + "&tipo=" + archivo[i].getName().charAt(8) + "&vista=examen'>Ver Pregunta</a></td>");
                        out.println("<td > MultipleChoice </td>");
                        out.println("<td><input type='checkbox' name='check"+cont+"' value='M"+archivo[i].getName().charAt(9)+"' form='f1' formaction='SobrescribirExamen'/></td>");
                        cont++;
                    } else {
                        if (archivo[i].getName().startsWith("pregunta") && archivo[i].getName().startsWith("preguntaH")) {

                            out.println("<tr>");
                            out.println("<td>Pregunta " + archivo[i].getName().charAt(9) + "</td>"); //verificamos que el nombre del archivo empiece con la palabra 'preguntaH'
                            out.println("<td><a href='VerPreguntas?id=" + archivo[i].getName().charAt(9) + "&tipo=" + archivo[i].getName().charAt(8) + "&vista=examen'>Ver Pregunta</a></td>");
                            out.println("<td > HotObject </td>");
                            out.println("<td><input type='checkbox' name='check"+cont+"' value='H"+archivo[i].getName().charAt(9)+"' form='f1' formaction='SobrescribirExamen'/></td>");
                            cont++;
                        }
                    }
                }
            }
            out.println("</tr>");
            out.println("</tbody>");
            out.println("</table>");
        }
        out.println("</form>");
        session.setAttribute("cont",cont);//creamos sesion para poder compartit el valor de cont
        
        
        
        
        out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>");
        out.println("<script type='text/javascript' src='https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js'></script>");
        out.println("<script src='http://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js'></script>");
        out.println("<script>");
        out.println("$(document).ready( function () {");
        out.println("    $('#myTable').DataTable();");
        out.println("} );");
        out.println("$( '.button' ).button();");
        out.println("$( '#dialog-link' ).click(function URL(){");
        out.println("	document.location.href = 'login.html'; ");
        out.println("});");
        out.println("</script>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}
