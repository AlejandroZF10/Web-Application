package alumno;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;                      // librerias necesarias para ejecutar el programa
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EscritorioAlumno extends HttpServlet {             // creamos una clase hija que hereda de HttoServlet

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8"); //indica que se esta trabajando con una página html
        HttpSession session = request.getSession();      // recuperamos la sesion de los navegadores
        String userName = (String) session.getAttribute("userName");   // obtenemos un atriburo de la session llamado username y lo almacenamos en una cadena llamada username
        PrintWriter out = response.getWriter();  
        out.println("<!DOCTYPE html>"); // se recupera el objeto out que nos permite establecer el canal de comunicación con el cliente, indicamos que enviaremos un flujo de salida de texto
        out.println("<html>");    // etiqueta de apertura de html
        out.println("<head>");  // etiqueta del encabezado de la paina
        out.println("<title>Admin Dashboard</title>");  // titulo con el cual se va identificar la ruta relativa
        out.println("<meta http-equiv='X-UA-Compatible' content='IE-edge'>");  //
        out.println("        <meta name='viewport' content='width = device-width, initial-scale=1 ' >");// damos tamaño y escala al fondo de la pagina
        out.println("        <link type='text/css' rel='stylesheet' href='http://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/hot-sneaks/jquery-ui.css' />"); // conectamos mediante javascript las librerias de JQuery para las CSS que usamos BASE
        out.println("<link rel='stylesheet' href='fondoYletra.css'>"); // definimos la imagen que sera el fondo de la pagina
        out.println("        <style>");  //etiqueta del estilo de la pagins
        out.println("#dialog-link{");
        out.println("    margin: 20px 0px 20px 85%;"); // definimos el margen de los botones
        out.println("}");
        out.println("h1{");
        out.println("  margin: 150px auto;");  // margen de la etiqueta h1
        out.println("  width: 600px;");   // ancho del mensaje a mostrar en esta etiqueta
        out.println("}");
        out.println("        </style>");  // cierre de la etiqueta para dar estilo a las paginas
        out.println("</head>");   // cierre del encabezado de la pagina
        out.println("<body>");   // apertura de la etiueta body donde se mostrara el cuerpo de la pagina

        out.println("<button id='dialog-link1' class='ui-button ui-corner-all ui-widget'>");  // definimos los atributos que tendra el botono
        out.println("		<span class='ui-icon ui-icon-home'></span> Log Out");  // seleccionamos el icono extraido de Jquery para el boton t l texto del boton
        out.println("	</button>");
         out.println("<button id='dialog-link2' class='ui-button ui-corner-all ui-widget'>");
        out.println("		<span class='ui-icon ui-icon-note'></span> Realizar Examen");
        out.println("	</button>");
        
        out.println("<div id='main'>");   // abrimos etiquwta div para reservar una seccion de la pagina al main
        out.println("<h1>Welcome Alumno: " + userName + "</h1>");  // mensaje de bienvenido concatenado el nombre del usuario
        out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>");  // coenctamos con las apis de Jquery a trves de google para los estilos de la pagina
        out.println("<script src='http://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js'></script>");
        out.println("<script>"); // abrimos etiqueta script para poder hacer uso de este lenguaje para mapear metodos que no podemos realizar en html
        out.println("$( '#dialog-link1' ).click(function URL(){");  // relacionamos el boton con una funcion que ejecutara cuando se de click en el boton
        out.println("	document.location.href = 'login.html'; ");  // a donde nos va direccionar cuando se click en el boton
        out.println("});");
        
        out.println("$( '#dialog-link2' ).click(function URL(){");
        out.println("	document.location.href = 'VerExamen'; ");
        out.println("});");
        
        
        
        
        out.println("</script>");   //cerramos etiqueta de javascript
        out.println("</div>");     //cerramos etiqueta de div 
        out.println("</body>");     //cerramos etiqueta de body
        out.println("</html>");     //cerramos etiqueta de html
    }
}
