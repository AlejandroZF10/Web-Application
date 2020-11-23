package Admin;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FillInBlankType extends HttpServlet {
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
            out.println("<h1 class='fuente'>Componentes</h1>");
            out.println("</br><button name='button1' class='mdc-button mdc-button--outlined' onclick=\"location.href='FillInBlankText'\">Texto</button>");
            out.println("<button name='button4' class='mdc-button mdc-button--outlined' onclick=\"location.href='FillInBlankAudio'\">Audio</button>");
            out.println("<button name='button2' class='mdc-button mdc-button--outlined' onclick=\"location.href='FillInBlankImage1'\">Imagen</button>");
            out.println("<button name='button3' class='mdc-button mdc-button--outlined' onclick=\"location.href='FillInBlankVideo1'\">Video</button></br></br>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}