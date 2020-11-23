
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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PreguntaH extends HttpServlet { //Public es un modificador de clase, no es modificador de acceso

    @Override //Es una notación 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)//Protected en este caso si es un modificador de acceso, HTTPServelet son parámetros de entrada: request es de lado clienteservidor, response, el servidor WEB es el que proporciona los objetos request y response
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8"); //indica que se esta trabajando con una página html
        PrintWriter out = response.getWriter(); // se recupera el objeto out que nos permite establecer el canal de comunicación con el cliente, indicamos que enviaremos un flujo de salida de texto
        String tipo = request.getParameter("boton"); //recuperamos el tipo de boton ya sea pregunta H p M
        HttpSession session = request.getSession();
        session.setAttribute("tipo", tipo); 

        String carpeta = request.getSession().getServletContext().getRealPath("/"); //ruta donde se guardan todos los archivos
        carpeta = carpeta.replace("\\", "/"); //en la cadena carpeta al encontrar \\ lo sustituira por /
        carpeta = carpeta.replaceAll("/build", ""); //si encuentra /build lo cambiera por una cadena vacía
        
        File f = new File(carpeta); //apuntador f a caprtea 
        File[] imagenes = f.listFiles();//se guardan la imagenes en un arrglo 
        //aquí ya se manda a imprimir lo que la página 
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>dinamica</title>");
        out.println(" <link type='text/css' rel='stylesheet' href='http://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/hot-sneaks/jquery-ui.css' />");
        out.println("<link rel='stylesheet' href='fondoYletra.css'>");
        out.println("<style>");
        out.println(".caja{");
        out.println("  height: 30px;");
        out.println("}");
        out.println(".autocomplete{");
        out.println("  height: 30px;");
        out.println("}");
        out.println(".area{");
        out.println("  width: 85%;");
        out.println("}");
        out.println("#cont{");
        out.println("  width: 0px;");
        out.println("  heigth: 0px;");
        out.println("border: 0px;");
        out.println("}");
        out.println(".ocultar{");
        out.println("  width: 0px;");
        out.println("  heigth: 0px;");
        out.println("border: 0px;");
        out.println("}");
        out.println("</style");
        out.println("</head>");
        out.println("<body>");
        out.println("<div id='main'>");
        out.println("<div class='ui-widget'>");
        out.println("	<div class='ui-state-error ui-corner-all' style='padding: 0 .7em;'>");
        out.println("		<p><span class='ui-icon ui-icon-alert' style='float: left; margin-right: .3em;'></span>");
        out.println("		<strong>Alerta:</strong> Primero sube tus archivos antes de llenar los demas campos</p>");
        out.println("	</div>");
        out.println("</div>");
        out.println("<h1>HOT OBJECT</h1>");
        out.println("<br>");
        out.println("<form action = 'UploadServletH' method = 'post' enctype = 'multipart/form-data'>");
        out.println("<input class='button' type = 'file' name = 'file' />");
        out.println("<br>");
        out.println("<br>");
        out.println("<input class='button' type = 'submit' id='up' value = 'Upload File' />");
        out.println("</form>");
        int numImg=0;
        int prefijo=0;
        for (int i = 0; i < imagenes.length; i++) {    //ciclo para  validar que los archivos multimedia sean de las extensiones        
            if (imagenes[i].getName().endsWith(".jpg") || imagenes[i].getName().endsWith(".png") || imagenes[i].getName().endsWith(".gif")) {                
                String onlyName = imagenes[i].getName();
                out.println("<input type='text' id='imagenes" + prefijo + "' value='" + onlyName + "' class='ocultar' >"); //dentro de una caja oculta guardamos el prefijo y el nombre de la imagen 
                numImg++;
                prefijo++;
            }
        }
        out.println("<input type='text' id='numeroImagenes' value='" +numImg+ "' class='ocultar'>"); //reecuperas el numero de imagen 
        out.println("<form action='CrearPreguntaH' method='post' id='fo' > ");
        out.println("<h2>ID de Interaccion:</h2> <input type='text' name='id' class='caja'/>");
        out.println("<br>");
        out.println("<h2>Pregunta</h2> <br> <textarea class='area' rows='4' cols='30' placeholder='Ingresa Pregunta' name='pregunta' form='fo' >");
        out.println("</textarea>");
        out.println("<br>");
        out.println("<h2>Nombres de las instancias HotObject:</h2> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
        out.println("<br>");
        out.println("<button id='buttonC' class='button' type='button'>Agregar Opcion</button> <input type='text' name='cont' id='cont' value='1'/>");
        out.println("<br>");
        out.println("<br>");
        out.println("<div id='dinam'");
        out.println("<b>1.</b> <input type='text' name='num0' class='caja'/><select name='check0' class='selectmenu'  > <option value='correcto' >Correcto</option> <option value='incorrecto' >Incorrecto</option></select><br><b>IMAGEN:</b><input type='text' name='multi0' class='autocomplete'/> <br>");
        out.println("</div>");
        out.println("<br>");
        out.println("<br>");
        out.println("<input type='submit'  value='guardar' class='button' id='submit' />   <input type='submit' value='opciones' class='button' formaction='opcionesPregunta' /> ");
        out.println("</form>");
        out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>");
        out.println("<script src='http://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js'></script>");
        out.println("<script>");
        out.println("var x=0;");
        out.println("var y=1;");
        out.println("$('#buttonC').click(function(){");
        out.println("x=x+1;");
        out.println("y=y+1;");
        out.println("        $('#dinam').append(\"<b>\"+y+\".</b> <input type='text' name='num\"+x+\"' class='caja'/><select name='check\"+x+\"' class='selectmenu'  > <option value='correcto' >Correcto</option> <option value='incorrecto' >Incorrecto</option>  </select><br><b>IMAGEN:</b><input type='text' name='multi\"+x+\"' class='autocomplete'/> <br>\");");
        out.println("$('#cont').val(y);");
        out.println("$( '.selectmenu' ).selectmenu();");
        out.println("$('.button').button();");
        out.println("$( '.autocomplete' ).autocomplete({");
        out.println("	source: array");
        out.println("});");
        out.println("});");
        out.println("$( '.selectmenu' ).selectmenu();");
        out.println("$('.button').button();");
        out.println("var numImagenes = $('#numeroImagenes').val();");
        out.println("var Num = parseInt(numImagenes);");
        out.println("var i = 0;");
        out.println("var array = [];");
        out.println("for(i=0;i<Num;i++)");
        out.println("{");
        out.println("     array [i] = $('#imagenes'+i).val();");
        out.println("}");
        out.println("$( '.autocomplete' ).autocomplete({");
        out.println("	source: array");
        out.println("});");
        out.println("</script>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}
