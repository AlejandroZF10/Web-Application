/*
Este paquete esta pensado para administrar todos los servlets de control

Este servlet es llamado cuando algun dat, id o contraseña, no coinciden con el de users.xml
*/
package control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletFallo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(); //recuperamos la sesion
        String userName = (String) session.getAttribute("userName");//recuperamos el atributo del usuario que logueo
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Admin Dashboard</title>");
        out.println("<meta http-equiv='X-UA-Compatible' content='IE-edge'>");
        out.println("        <meta name='viewport' content='width = device-width, initial-scale=1 ' >");
        out.println("        <link type='text/css' rel='stylesheet' href='http://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/hot-sneaks/jquery-ui.css' />");
        out.println("<link rel='stylesheet' href='fondoYletra.css'>");//incluimos la hoja de estilo que nos da el fondo y la letra
        out.println("</head>");
        out.println("<body>");
        out.println("<div id='main'>");
        out.println("<h1>usuario o contraseña no registrado en el archivo XML de usuarios</h1>");//muestra al usuario que ingreso un dato incorrecto
        out.println("<br>");
        out.println("<a href='login.html' >Regresar al login para volver a intentarlo</a>"); //referencia al html del login para que vuelva ingresar los datos    
        out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>");
        out.println("<script src='http://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js'></script>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}
