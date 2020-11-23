package profe;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class opcionesPregunta extends HttpServlet { //Public es un modificador de clase, no es modificador de acceso

    @Override //Es una notación 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)//Protected en este caso si es un modificador de acceso, HTTPServelet son parámetros de entrada: request es de lado clienteservidor, response, el servidor WEB es el que proporciona los objetos request y response
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8"); //indica que se esta trabajando con una página html
        PrintWriter out = response.getWriter(); // se recupera el objeto out que nos permite establecer el canal de comunicación con el cliente, indicamos que enviaremos un flujo de salida de texto
        HttpSession session = request.getSession();

        String tipo = (String) session.getAttribute("tipo");

        //aquí ya se manda a imprimir lo que la página 
         out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>dinamica</title>");
        out.println(" <link type='text/css' rel='stylesheet' href='http://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/hot-sneaks/jquery-ui.css' />");
        out.println("<link rel='stylesheet' href='fondoYletra.css'>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div id='main'>");
        out.println("<h1>Hot Object</h1>");
        out.println("<br>");
        out.println("<br>");
        out.println("<form action='Preguntas' method='post' id='fo' > ");//Indicamos el form su metodo, action y un id.
        out.println("<b>Feedback Tries</b> <input type='text' name='intentos' />");//Agregamos un cuadro de texto para indicar los intentos.
        out.println("<br><br>");
        out.println("<b>Feedback Inicial</b> <input type='text' name='inicial' />");//Agregamos un cuadro de texto para indicar que dira como descripcion inicial.
        out.println("<br><br>");
        out.println("<b>Feedback de Evaluacion</b> <input type='text' name='evaluacion' />");//Agregamos un cuadro de texto para indicar que dira como descripcion al terminar.
        out.println("<br><br>");
        out.println("<b>Feedback Correcto</b> <input type='text' name='correcto' />");//Agregamos un cuadro de texto para indicar lo que dira cuando tenga la respuesta correcta
        out.println("<br><br>");
        out.println("<b>Feedback Incorrecto</b> <input type='text' name='incorrecto' />");//Agregamos un cuadro de texto para indicar lo que dira cuando tenga la respuesta incorrecta
        out.println("<br><br>");
        out.println("<b>Feedback Intentos</b> <input type='text' name='intentos1' />");//Agregamos un cuadro de texto para indicar lo que dira cuando haya agotado los intentos.
        out.println("<br><br>");
        out.println("<button id='button' form='fo' name='boton' formaction='Preguntas' type='submit' value='hotobject' >");//Creamos un boton para mandar la informacion.
        out.println("guardar");
        out.println("</button>");
        out.println("</form>");
        out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>");
        out.println("<script src='http://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js'></script>");
        out.println("<script>");
        out.println("$('#button').button();");
        out.println("</script>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}
