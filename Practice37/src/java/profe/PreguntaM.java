package profe;

/**
 *
 * @author MaFer
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PreguntaM extends HttpServlet { //Public es un modificador de clase, no es modificador de acceso

    @Override //Es una notación 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)//Protected en este caso si es un modificador de acceso, HTTPServelet son parámetros de entrada: request es de lado clienteservidor, response, el servidor WEB es el que proporciona los objetos request y response
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8"); //indica que se esta trabajando con una página html
        PrintWriter out = response.getWriter(); // se recupera el objeto out que nos permite establecer el canal de comunicación con el cliente, indicamos que enviaremos un flujo de salida de texto
        String tipo = request.getParameter("boton");
        HttpSession session = request.getSession();
        session.setAttribute("tipo", tipo);
        String filename = (String) session.getAttribute("filename");        
        
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
        out.println(".area{");
        out.println("  width: 85%;");
        out.println("}");
        out.println("#cont{");
        out.println("  width: 0px;");
        out.println("  heigth: 0px;");
        out.println("border: 0px;");
        out.println("}");
        out.println("#cont2{");
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
        out.println("		<strong>Alerta:</strong> Primero sube tu archivo antes de llenar los demas campos</p>");
        out.println("	</div>");
        out.println("</div>");
        out.println("<h1>MULTIPLE CHOICE</h1>");
        out.println("<br>");
        out.println("<form action = 'UploadServlet' method = 'post' enctype = 'multipart/form-data'>");
        out.println("<input class='button' type = 'file' name = 'file' />");
        out.println("<br>");
        out.println("<br>");
        out.println("<input class='button' type = 'submit' id='up' value = 'Upload File' />");
        out.println("</form>");
        out.println("<input type='text' value='" + filename + "' name='filename' id='cont2'/>");
        out.println("<form action='CrearPreguntaM' method='post' id='fo' > ");
        out.println("<h2>ID de Interaccion:</h2> <input type='text' name='id' class='caja'/>");
        out.println("<br>");
        out.println("<h2>Pregunta</h2> <br> <textarea class='area' rows='4' cols='30' placeholder='Ingresa Pregunta' name='pregunta' form='fo' >");
        out.println("</textarea>");
        out.println("<br>");
        out.println("<h2>Nombres de las instancias Multiple Choice:</h2> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
        out.println("<br>");
        out.println("<button id='buttonC' class='button' type='button'>Agregar Opcion</button> <input type='text' name='cont' id='cont' value='1'/>");
        out.println("<br>");
        out.println("<br>");
        out.println("<div id='dinam'");
        out.println("<b>1.</b> <input type='text' name='num0' class='caja'/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;       <select name='check0' class='selectmenu'  > <option value='correcto' >Correcto</option> <option value='incorrecto' >Incorrecto</option>  </select> <br>");
        out.println("</div>");
        out.println("<br>");
        out.println("<br>");
        out.println("<input type='submit'  value='guardar' class='button' id='submit' />   <input type='submit' value='opciones' class='button' formaction='opcionesPreguntaM' /> ");
        out.println("</form>");
        out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>");
        out.println("<script src='http://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js'></script>");
        out.println("<script>");
        out.println("var x=0;");
        out.println("var y=1;");
        out.println("$('#buttonC').click(function(){");
        out.println("x=x+1;");
        out.println("y=y+1;");
        out.println("        $('#dinam').append(\"<b>\"+y+\".</b> <input type='text' name='num\"+x+\"' class='caja'/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;       <select name='check\"+x+\"' class='selectmenu'  > <option value='correcto' >Correcto</option> <option value='incorrecto' >Incorrecto</option>  </select> <br>\");");
        out.println("$('#cont').val(y);");
        out.println("$( '.selectmenu' ).selectmenu();");
        out.println("$('.button').button();");
        out.println("});");
        out.println("$( '.selectmenu' ).selectmenu();");
        out.println("$('.button').button();");
        out.println("</script>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}
