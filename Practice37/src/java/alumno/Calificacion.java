package alumno;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import static java.util.stream.DoubleStream.builder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;                          // librerias para ejecutar el programa
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.jdom.Document;
import org.jdom.Element;    
import org.jdom.input.SAXBuilder;

public class Calificacion extends HttpServlet {    //Public es un modificador de clase, no es modificador de acceso

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)     //Protected en este caso si es un modificador de acceso, HTTPServelet son parámetros de entrada: request es de lado clienteservidor, response, el servidor WEB es el que proporciona los objetos request y response
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");  //indica que se esta trabajando con una página html
        HttpSession session = request.getSession();   // obtenemos la session del navegador
        String id = (String) session.getAttribute("id"); // obtenemos el atributo id de la session
        PrintWriter out = response.getWriter();   // se recupera el objeto out que nos permite establecer el canal de comunicación con el cliente, indicamos que enviaremos un flujo de salida de texto
        int aciertos=Integer.parseInt(request.getParameter("aciertos"));  // obtenemos los aciertos del servlet anterior y los convertimos en enteros
        int preguntas =Integer.parseInt(request.getParameter("preguntas"));    // obtenemos las preguntas del servlet anterior y los convertimos en enteros
        
        String rutaAbsoluta = request.getSession().getServletContext().getRealPath("/");  //primero obtenemos la session y hacemos comunicacion con el registro de servlets y esa ruta la transforma a una ruta del S.O.
        rutaAbsoluta = rutaAbsoluta.replace("\\", "/");  // reemplazamos los caracteres \\ por /
        rutaAbsoluta = rutaAbsoluta.replaceAll("/build", "");   
        rutaAbsoluta = rutaAbsoluta + "/examen" + id + ".xml";  //  concatenamos el id de examen que se realizo

        out.println("<!DOCTYPE html>");     // etiqueta de documento html
        out.println("<html>");    // etiqueta html
        out.println("<head>");    // atiqueta de emcbezado de la pagina
        out.println("<title>Admin Dashboard</title>");   // titulo de la ruta relativa de la pagina
        out.println("<meta http-equiv='X-UA-Compatible' content='IE-edge'>");
        out.println("        <meta name='viewport' content='width = device-width, initial-scale=1 ' >"); // escala y tamaño 
        out.println("        <link type='text/css' rel='stylesheet' href='http://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/hot-sneaks/jquery-ui.css' />");  // conexion con tema de hot-sneaks para css de jquery
        out.println("<link rel='stylesheet' href='fondoYletra.css'>");   // establecemos el fondo de la pagina
        out.println("        <style>");  // abrimops etiqueta de estilo para la pagina
        out.println("#dialog-link{");   
        out.println("    margin: 20px 0px 20px 85%;");   //margen del boton
        out.println("}");
        out.println("h1{");    // definimos la etiqueta h1
        out.println("  margin: 150px auto;");   
        out.println("  width: 600px;");
        out.println("}");
        out.println("        </style>");   // cerramos la etiqueta del estilo 
        out.println("</head>");   // cerramos la etiqueta de encabezado
        
        
        
        int calificacion;            // variable para mostar la calificacion
        calificacion = (aciertos/preguntas)*(10);    //  operacion para mostrar la calificacion
        
        
        out.println("<body>");            // etiqueta del cuerpo de la pagina 

        out.println("<button id='dialog-link1' class='ui-button ui-corner-all ui-widget'>");    //  damos un id a un boton 
        out.println("		<span class='ui-icon ui-icon-home'></span> Log Out");    // decimos que icono estara en el boton y texto
        out.println("	</button>");
        
        out.println("<button id='dialog-link2' class='ui-button ui-corner-all ui-widget'>");   //  damos un id a un boton 
        out.println("		<span class='ui-icon ui-icon-newwin'></span> Ir a inicio");   // decimos que icono estara en el boton y texto
        out.println("	</button>");
        
        
        out.println("<div id='main'>");    // abrimos etiueta de div para el main 
        out.println("<h1>La calificacion del examen es: " +calificacion+ "</h1>");   // mostramos la calificacion en la etiqueta h1
        out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>");   
        out.println("<script src='http://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js'></script>");
        out.println("<script>");
        out.println("$( '#dialog-link1' ).click(function URL(){");      // funcion cuando haga click en el boton 
        out.println("	document.location.href = 'login.html'; ");     // llevara al login
        out.println("});");
        
         out.println("$( '#dialog-link2' ).click(function URL(){");    // funcion cuando haga click en el boton 
        out.println("	document.location.href = 'EscritorioAlumno'; ");   // llevara a la pantalla pricipal del alumno
        out.println("});");
        
        
        
        
        
        out.println("</script>");   // cierre de la etiqueta de javascript
        out.println("</div>");    // cierre de la etiqueta div
        out.println("</body>");    // cierre de la etiueta de body
        out.println("</html>");  // cierre de la etiueta html
    }
}
