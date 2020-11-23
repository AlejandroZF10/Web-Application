/*
El escritorio del administrador estaba pensado para que tuviera una tabla con los alumnos y profesores
que tenian acceso a la pagina, el iba a escibir, modificar, eliminar id's y passwords del xml de users.xml
*/


package admin;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EscritorioAdmin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("userName");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Admin Dashboard</title>");
        out.println("<meta http-equiv='X-UA-Compatible' content='IE-edge'>");
        out.println("        <meta name='viewport' content='width = device-width, initial-scale=1 ' >");
        out.println("        <link type='text/css' rel='stylesheet' href='http://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/hot-sneaks/jquery-ui.css' />");
        out.println("<link rel='stylesheet' href='fondoYletra.css'>");//llamamos a la hoja de estilo donde esta el tipo de letra y el fondo
        out.println("        <style>");
        out.println("#dialog-link{");
        out.println("    margin: 20px 0px 20px 85%;"); //acomodamos en la esquina superior derecha el boton de log out
        out.println("}");
        out.println("h1{");
        out.println("  margin: 150px auto;");
        out.println("  width: 600px;");
        out.println("}");
        out.println("        </style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<button id='dialog-link' class='ui-button ui-corner-all ui-widget'>"); //boton de log out con el
        out.println("		<span class='ui-icon ui-icon-home'></span> Log Out");//icono de la casita
        out.println("	</button>");
        out.println("<div id='main'>");
        out.println("<h1>Welcome Administrador: " + userName + "</h1>"); //titulo donde recuperamos el nombre del usuario
        out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>");
        out.println("<script src='http://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js'></script>");
        out.println("<script>");
        out.println("$( '#dialog-link' ).click(function URL(){"); //script  para regresar al login cuando se clicke al log out
        out.println("	document.location.href = 'login.html'; ");
        out.println("});");
        out.println("</script>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}
