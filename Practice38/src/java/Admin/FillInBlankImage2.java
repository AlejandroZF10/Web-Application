package Admin;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FillInBlankImage2 extends HttpServlet {
     @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()){
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Administrador</title>");
            out.println("<link rel=\"stylesheet\" href=\"https://unpkg.com/material-components-web@latest/dist/material-components-web.min.css\">");
            out.println("</head>");
            out.println("<style>");
            //Body
            out.println("body{align-items:center;text-align:center;background:url('Fondo-Login.jpg') no-repeat;");
            out.println("background-attachment:scroll;-webkit-background-size:cover;-moz-background-size:cover;");
            out.println("-o-background-size:cover;background-size:cover;width:100%;display:table;text-align:center;}");
            //Divisor
            out.println(".divisor{width:35%;position:relative;margin:2%auto;border-style:solid;border-radius:10px;");
            out.println("padding:10px 40px 10px 40px;background-color:#eaeded;display:inline-block;}");
            //Fuente
            out.println(".fuente{font-family:Gill Sans,Gill Sans MT,Myriad Pro,DejaVu Sans Condensed,Helvetica,Arial,sans-serif;}");
            out.println("</style>");
            out.println("<body>");
            out.println("<div class='divisor' >");
            out.println("<button name='type' class='mdc-button mdc-button--raised'>Fill in Blank</button>");
            out.println("<button name='button1' class='mdc-button mdc-button--raised' onclick=\"location.href='Administrador'\">Salir</button></br>");
            out.println("</br></br><button disabled class='mdc-button mdc-button--outlined' \">Texto</button>");
            out.println("<button disabled class='mdc-button mdc-button--outlined'\">Audio</button>");
            out.println("<button class='mdc-button mdc-button--outlined'\">Imagen</button>");
            out.println("<button disabled class='mdc-button mdc-button--outlined'\">Video</button>");
            
            out.println("<form action = 'FeedBack2' method = 'POST'>");
            out.println("</br></br><p class='fuente' align='left'>ID pregunta: <input type='text' name='id'/></p>");
            out.println("<p class='fuente' align='justify'>Pregunta: <input type='text' name='pregunta' size='60'></textarea></p>");
            out.println("<table class='fuente' align='center' border='0' width='500'>");
            out.println("<thead class='fuente'><th></th><th>Respuestas</th><th>Respuesta correcta</th></thead>");
            out.println("<tr><td>1-. </td><td><input type='text' name='Q1' size='50'/></td><td ><input type='checkbox' name='correct' value='Correct1'></td></tr>");
            out.println("<tr><td>2-. </td><td><input type='text' name='Q2' size='50'/></td><td ><input type='checkbox' name='correct' value='Correct2'></td></tr>");
            out.println("<tr><td>3-. </td><td><input type='text' name='Q3' size='50'/></td><td ><input type='checkbox' name='correct' value='Correct3'></td></tr>");
            out.println("<tr><td>4-. </td><td><input type='text' name='Q4' size='50'/></td><td ><input type='checkbox' name='correct' value='Correct4'></td></tr>");
            out.println("</table>");
            out.println("</br><button class='mdc-button mdc-button--outlined'>Continuar</button>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}