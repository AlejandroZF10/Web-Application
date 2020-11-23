package Admin;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Administrador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()){
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Administrador</title>");
            out.println("<link rel='stylesheet' href='https://unpkg.com/material-components-web@latest/dist/material-components-web.min.css'>");
            out.println("<link rel='stylesheet' href='css/Clase.css'>");
            out.println("<link rel='stylesheet' href='css/Button.css'>");
            out.println("</head>");
            out.println("<style>");
            //Body
            out.println("body{align-items:center;text-align:center;background:url('Fondo-Login.jpg') no-repeat;");
            out.println("background-attachment:scroll;-webkit-background-size:cover;-moz-background-size:cover;");
            out.println("-o-background-size:cover;background-size:cover;width:100%;display:table;text-align:center;}");
            //Divisor
            out.println(".divisor{width:50%;position:relative;margin:2%auto;border-style:solid;border-radius:10px;");
            out.println("padding:10px 40px 10px 40px;background-color:#eaeded;display:inline-block;}");
            //Fuente
            out.println(".fuente{font-family:Gill Sans,Gill Sans MT,Myriad Pro,DejaVu Sans Condensed,Helvetica,Arial,sans-serif;}");
            out.println("</style>");
            HttpSession sesion = request.getSession();
            String user = (String)sesion.getAttribute("userName");
            String carpeta = request.getSession().getServletContext().getRealPath("/");
            carpeta = carpeta.replace("\\", "/"); 
            carpeta = carpeta.replaceAll("/build", "");
            File ruta = new File(carpeta);
            File[] archivo = ruta.listFiles();
            out.println("<body>");
            out.println("<div class='divisor'>");
                out.println("<h1 class='fuente'>Bienvenido " + user + "</h1>");
                out.println("<table class='table-fill' align='center' border='1' width='500'>");
                out.println("<thead><th class='text-center'>Preguntas</th><th class='text-center'>Opciones</th></thead><tbody class='table-hover'>");
                if (archivo != null){
                    for (int i = 0; i < archivo.length; i++){
                        if (archivo[i].isDirectory() == false){
                            if (archivo[i].getName().startsWith("Pregunta")){
                                out.println("<tr><td>"+archivo[i].getName()+"</td><td>");
                                out.println("<button class='action-button shadow animate green'  onclick=\"location.href='Ver_Pregunta?id="+archivo[i].getName()+"'\">Visualizar</button>");
                                out.println("<button class='action-button shadow animate blue'>Modificar</button> ");
                                out.println("<button class='action-button shadow animate red' onclick=\"location.href='Eliminar_Pregunta?id="+archivo[i].getName()+"'\">Eliminar</button> ");
                                out.println("</td></tr></tbody>");
                            }
                        }                              
                    }
                }

                out.println("</table>");
                out.println("</br><button name='button1' class='mdc-button mdc-button--outlined' onclick=\"location.href='Type_Question'\">Nueva pregunta</button>");
                out.println("<button name='button2' class='mdc-button mdc-button--outlined' onclick=\"location.href='CreateExam'\">Crear examen</button>");
                out.println("<button name='button3' class='mdc-button mdc-button--outlined' onclick=\"location.href='Login.html'\">Salir</button>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}