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
import org.jdom.output.XMLOutputter;

public class BienvenidoProfe extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        session.setAttribute("filename", null);//creamos atributo llamado filename con valor nulo
        String userName = (String) session.getAttribute("userName");//recurperamos el atributo de nombre de usuario
        PrintWriter out = response.getWriter();// se recupera el objeto out que nos permite establecer el canal de comunicación con el cliente, indicamos que enviaremos un flujo de salida de texto
        int cont = 0;
        session.setAttribute("cont", cont);//creamos atributo llamado contador, con el valor de la varible contador 


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
        out.println(".ocultar{");
        out.println("    height:0px;");
        out.println("    width:0px;");
        out.println("    border:0px;");
        out.println("}");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<button id='dialog-link' class='ui-button ui-corner-all ui-widget'>");
        out.println("		<span class='ui-icon ui-icon-home'></span> Log Out");
        out.println("	</button>");
        out.println("<div id='main'>");
        out.println("<h1>Bienvenido Profe: " + userName + "</h1>"); // mostramos que usuario ha ingresado 

        out.println("<h1>CREACIÓN DE PREGUNTAS</h1>");

        out.println("<form method='get' id='1' >");//este form indica que metodo se utiliza para mandar la informacion 
        //creacion de botones para las opciones de tipos de preguntas
        out.println("<button form='1' name='boton' formaction='PreguntaH' type='submit' value='H' class='button'>");
        out.println("HOTOBJECT");
        out.println("</button>");
        //creacion de botones para las opciones de tipos de preguntas
        out.println("<button form='1' name='boton' formaction='PreguntaM' type='submit' value='M' class='button' >");
        out.println("MULTIPLECHOICE");
        out.println("</button>");

        out.println("<button form='1' formaction='Examenes' type='submit' class='button' >");
        out.println("EXAMENES");
        out.println("</button>");
        out.println("<br>");
        out.println("</form>");

        String carpeta = request.getSession().getServletContext().getRealPath("/"); //ruta donde se guardaran los archivos

        carpeta = carpeta.replace("\\", "/"); 
        carpeta = carpeta.replaceAll("/build", "");
        File ruta = new File(carpeta);//se crea un apuntador a la ruta especificada por carpeta 
        File[] archivo = ruta.listFiles();//enlistamos todos los archivos existentes en  esta ruta 
        int x = 0;
        
        //creacion de tabla para enlistar las preguntas y sus respectivas opciones 
        out.println("<table id='myTable' class='display' style='width:100%'");
        out.println("<thead>");
        out.println("        <tr>");
        out.println("            <th>Nombre</th>");
        out.println("            <th>Opciones</th>");
        out.println("            <th>Tipo</th>");
        out.println("        </tr>");
        out.println(" </thead>");
        out.println("<tbody>");
        //evaluamos si la carpeta tiene archivos 
        if (archivo != null) {//evaluamos si la carpeta tiene archivos
            //recorremos el vector
            for (int i = 0; i < archivo.length; i++) {
                File Arc = archivo[i];
                //evaluamos si el archivo o ruta es una carpeta
                if (archivo[i].isDirectory() == false) {
                    if (archivo[i].getName().startsWith("pregunta") && archivo[i].getName().startsWith("preguntaM")) {//verificamos que el nombre del archivo empiece con la palabra 'preguntaM'
                        //se crea una fila para la tabla con tres celdas

                        out.println("<tr>");
                        out.println("<td>Pregunta " + archivo[i].getName().charAt(9) + "</td>");//creacion de celda con el nombre del archivo, concatenando su numero de serie
                        out.println("<td><a href='VerPreguntas?id=" + archivo[i].getName().charAt(9) + "&tipo=" + archivo[i].getName().charAt(8) + "&vista=profe'>Ver Pregunta</a> | <a href='ModificarPregunta?id=" + archivo[i].getName().charAt(9) + "&tipo=" + archivo[i].getName().charAt(8) + "'>Modificar</a> | <a href='' class='dialog-click' id='" + archivo[i].getName().charAt(9)+"' > <input class='ocultar' type='text' value='"+archivo[i].getName().charAt(8)+"' id='value2'>Eliminar</a></td>");//creacion de celda con el nombre del archivo, concatenando su numero de serie
                        out.println("<td > MultipleChoice </td>");
                        x = i;

                    } else {
                        if (archivo[i].getName().startsWith("pregunta") && archivo[i].getName().startsWith("preguntaH")) {//verificamos que el nombre del archivo empiece con la palabra 'preguntaH'


                            out.println("<tr>");
                            out.println("<td>Pregunta " + archivo[i].getName().charAt(9) + "</td>");//creacion de celda con el nombre del archivo, concatenando su numero de serie
                            out.println("<td><a href='VerPreguntas?id=" + archivo[i].getName().charAt(9) + "&tipo=" + archivo[i].getName().charAt(8) + "&vista=profe'>Ver Pregunta</a> | <a href='ModificarPregunta?id=" + archivo[i].getName().charAt(9) + "&tipo=" + archivo[i].getName().charAt(8) + "'>Modificar</a> | <a href='' class='dialog-click' id='" + archivo[i].getName().charAt(9) + "'><input class='ocultar' type='text' value='"+archivo[i].getName().charAt(8)+"' id='value2'>Eliminar</a></td>");//opciones para trabajar con la preegunta 
                            out.println("<td > HotObject </td>");
                            x = i;
                        }
                    }
                }
            }
            out.println("</tr>");
            out.println("</tbody>");
            out.println("</table>");
            out.println("<input type='text' id='value' class='ocultar'>");
            if (x != 0) {//se crea un dialog para verificar si el usuario oquiere borrar la pregunta 
                out.println("<div id='dialog' title='Alerta'>");
                out.println("<p>¿Buscas borrar la pregunta?</p>");
                out.println("</div>");
            }

        }
        out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>");
        out.println("<script type='text/javascript' src='https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js'></script>");
        out.println("<script src='http://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js'></script>");
        out.println("<script>");
        out.println("$(document).ready( function () {");
        out.println("    $('#myTable').DataTable();");
        out.println("} );");
        out.println("$( '#dialog-link' ).click(function URL(){");
        out.println("	document.location.href = 'login.html'; ");
        out.println("});");
        out.println("$( '.button' ).button();");
        if (x != 0) {
            out.println("$( '#dialog' ).dialog({");//se crea un dialago con las siiguientes caracteristicas 
            out.println("	autoOpen: false,");//no se abre automaticamente
            out.println("	width: 400,");//ancho de 400px
            out.println("	buttons: [");//contiene los siguientes botones 
            out.println("		{");
            out.println("			text: 'Si',");//al dar click en el boton SI se crea una funcion que redirige a otro servelet
            out.println("			click: function URL() {");
            out.println("                               var id = $('#value').val();");
            out.println("                               var tipo = $('#value2').val();");
            out.println("				$( this ).dialog( document.location.href = 'EliminarPregunta?id='+id+'&tipo='+tipo );");// se redirige al servlet ELIMINARPREGUNTA con el metodo document.location.href
            out.println("			}");
            out.println("		},");
            out.println("		{");
            out.println("			text: 'No',");
            out.println("			click: function() {");
            out.println("				$( this ).dialog( 'close' );");
            out.println("			}");
            out.println("		}");
            out.println("	]");
            out.println("});");
            out.println("$( '.dialog-click' ).click(function( event ) {");//cuando se de click a elemento con esta clase comienza un evento, en el cual, se crea un dialog y se abre
            out.println("       var id=$(this).attr('id');    ");
            out.println("       $('#value').val(id);");
            out.println("	$( '#dialog' ).dialog( 'open' );");
            out.println("	event.preventDefault();");
            out.println("});");
        }
        out.println("</script>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}
