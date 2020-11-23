package alumno;

/**
 *
 * @author MaFer
 */
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;                // librerias para ejecutar el programa
import javax.servlet.http.HttpSession;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class VerExamen extends HttpServlet { //Public es un modificador de clase, no es modificador de acceso

    @Override //Es una notación 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)//Protected en este caso si es un modificador de acceso, HTTPServelet son parámetros de entrada: request es de lado clienteservidor, response, el servidor WEB es el que proporciona los objetos request y response
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8"); //indica que se esta trabajando con una página html
        PrintWriter out = response.getWriter(); // se recupera el objeto out que nos permite establecer el canal de comunicación con el cliente, indicamos que enviaremos un flujo de salida de texto
        String tipo = request.getParameter("tipo");  // recuperamos el parametro tipo y lo almacenamos en una cadena llamada 
        String id = request.getParameter("id");  // recuperamos el parametro id y lo almacenamos en una cadena llamada id
        HttpSession session = request.getSession(); // recuperamos la sesion
        session.setAttribute("tipo", tipo);  //volvemos a subir el parametro tipo como atributo a la session
        session.setAttribute("id", id);   //volvemos a subir el parametro id como atributo a la session
        String rutaAbsoluta = request.getSession().getServletContext().getRealPath("/");  //primero obtenemos la session y hacemos comunicacion con el registro de servlets y esa ruta la transforma a una ruta del S.O. 
        rutaAbsoluta = rutaAbsoluta.replace("\\", "/"); // reemplaza los caracteres \\ por /
        rutaAbsoluta = rutaAbsoluta.replaceAll("/build", "");    
        rutaAbsoluta = rutaAbsoluta + "/examen" + id + ".xml"; // a la ruta anterior le agregamos examen y concatenamos el id para saber ue examen es

        //aquí ya se manda a imprimir lo que la página 
        out.println("<!DOCTYPE html>");  //escribimos el tipo de documento html
        out.println("<html>"); // abrimos etiqueta html
        out.println("<head>"); //abrimos etiqueta del encabezado de la pagina
        out.println("<title>dinamica</title>");    // definimos el titulo de la pagina para la url relativa
        out.println("<link type='text/css' rel='stylesheet' href='http://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/hot-sneaks/jquery-ui.css' />"); // hacemos conecxion conjQuery a traves de javascript para las CSS
        out.println("<link rel='stylesheet' type='text/css' href='https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css'/>");  // libreria para las talas de CSS en javascript
        out.println("<link rel='stylesheet' href='fondoYletra.css'>");   //establecemos el fondo de la pagina
        out.println("<style>");  // abrimos la etiqueta que dara estilo a la pagina
        out.println("#Examen{");  // determinamos el estilo para el examen
        out.println("  text-align: left;");  // el texto lo alinemamos a la izquierda
        out.println("  padding-left: 20px;");   
        out.println("  padding-right: 0px;");
        out.println("  }");
        out.println(".hotobject{");  // determinamos el estilo para el hotObject
        out.println("  padding: 50px;");
        out.println("  margin: 10px;");
        out.println("  }");
        out.println("</style>");  // cerramos la etiqueta del estilo de la pagina
        out.println("</head>");  // cerramos la etiqueta del encabezado 
        out.println("<body>");  // abrimos la etiqueta donde se mostrara el cuerpode l apagina
        out.println("<div id= 'main'>");   // una etiqueta div para seccionar la paagina en un main
        
        
        out.println("<table id='myTable' class='display' style='width:100%'");  // creamos una tabla de estas caracteristicas
        out.println("<thead>");   // determinamos el encabezado de la tabla 
        out.println("        <tr>");
        out.println("            <th>Examen</th>");   // atributos de la tabla como encabezado
        out.println("            <th>Acciones</th>");
        out.println(" </thead>");  // cerramos en elcabezado de la tabla
        out.println("<tbody>"); // cerramos todo el cuerpo de la tabla 
        
        String carpeta = request.getSession().getServletContext().getRealPath("/");  // obtenemos la session y hacemos comunicacion con el archivo dde servlets y obtenemos su ruta para pasarla a una ruta del S.O
        carpeta = carpeta.replace("\\", "/");   // reemplaza las \\ por /
        carpeta = carpeta.replaceAll("/build", "");   
        File ruta = new File(carpeta);   // creamos un archivo y damos la direccion obtenida anteriormente
        File[] archivo = ruta.listFiles();  // creamos un arreglo de archivos
        
          int x = 0;
       if (archivo != null) {   // verifica si si se creo el archivo
            //recorremos el vector
            for (int i = 0; i < archivo.length; i++) {
                File Arc = archivo[i];
                //evaluamos si el archivo o ruta es una carpeta
                if (archivo[i].isDirectory() == false) {
                    if (archivo[i].getName().startsWith("examen") && archivo[i].getName().startsWith("examen")) {  

                        out.println("<tr>");             // etiqueta para escribir vertical
                        out.println("<td>Examen " + archivo[i].getName().charAt(6) + "</td>");  // escribimos el archivo del examen con su id
                        out.println("<td><a href='RealizarExamen?id=" + archivo[i].getName().charAt(6) +"&cont=0&vista=alumno '>Realizar Examen</a>");  // genera un link que llevara a realizar examen
                        out.println("<td > MultipleChoice </td>");
                        x = i;  //  sacamos el identificador del archivo

                    }
                }
            }
            out.println("</tr>");   // cerramos la etiqueta que escribe en la tabla verticalmente
            out.println("</tbody>");   // cerramos el cuerpo de la tabla
            out.println("</table>");    // cerramos toda la tabla
           

        }
        out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>");      // coenctamos con las apis de Jquery a trves de google para los estilos de la pagina
        out.println("<script type='text/javascript' src='https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js'></script>");
        out.println("<script src='http://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js'></script>");
        out.println("<script>");   // abrimoos etiqueta de javascript
        out.println("$(document).ready( function () {");  // decimos que si el documento esta listo se iniciara en la tabla
        out.println("    $('#myTable').DataTable();");
        out.println("} );");
        out.println("$( '.button' ).button();");    // establecemos un boton
        out.println("$( '#dialog-link' ).click(function URL(){");   //  checa si se ha dado click para realizar una funcion
        out.println("	document.location.href = 'login.html'; ");  // cuando se de click en el boton te llevara al login
        out.println("});");
        if (x != 0) {  
            out.println("$( '#dialog' ).dialog({");
            out.println("	autoOpen: false,");
            out.println("	width: 400,");
            out.println("	buttons: [");
            out.println("		{");
            out.println("			text: 'Si',");
            out.println("			click: function URL() {");
            out.println("				$( this ).dialog( document.location.href = 'EliminarPregunta?id=" + archivo[x].getName().charAt(9) + "&tipo=" + archivo[x].getName().charAt(8) + "' );");
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
            out.println("$( '.dialog-click' ).click(function( event ) {");
            out.println("	$( '#dialog' ).dialog( 'open' );");
            out.println("	event.preventDefault();");
            out.println("});");
        }
        
        out.println("<button id='button'>Regresar</button>");  // establecemos el boton cin un id
        out.println("</div>");   // cerramos la etiqueta div 
        out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>");
        out.println("<script type='text/javascript' src='https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js'></script>");  // establecemos el uso de Jquery para las tablas
        out.println("<script src='http://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js'></script>");  // llama la api por medio de google para su uso
        out.println("<script>");   // abrimos  etiqueta de javascript
        out.println("$('input[type=checkbox]').checkboxradio();");  //  realizamos un checkbox-radio
        out.println("$( '#button' ).button();"); // creamos un boton
        out.println("$( '#button' ).click(function URL(){");    // cuando de click ejecutara lo siguiente
        out.println("	document.location.href = 'EscritorioAlumno'; ");  // el boton al dar click llevara al escritorio de alumno
        out.println("});");
        
        
        
        
        
        out.println("</script>");  // cerramos etiqueta de javascript
        out.println("</body>");   // cerramos el cuerpo de la pagina
        out.println("</html>");    // cerramos el html
    }
        
}
