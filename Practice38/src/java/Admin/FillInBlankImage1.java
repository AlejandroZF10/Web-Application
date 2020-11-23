package Admin;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FillInBlankImage1 extends HttpServlet {
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
            
            out.println("<form action = 'UploadServlet1' method = 'POST' enctype = 'multipart/form-data'>");
            out.println("</br></br><input class='button fuente' type = 'file' name = 'file'/>");
            out.println("<button class='mdc-button mdc-button--outlined'>Upload</button>");
            out.println("</form></br>");
            
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}