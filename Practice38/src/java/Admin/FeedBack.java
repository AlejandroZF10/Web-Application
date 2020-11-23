package Admin;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FeedBack extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String[] datos = new String[9];
        datos[0] = request.getParameter("id"); datos[1] = request.getParameter("pregunta");
        datos[2] = request.getParameter("Q1"); datos[3] = request.getParameter("Q2");
        datos[4] = request.getParameter("Q3"); datos[5] = request.getParameter("Q4");
        datos[6] = request.getParameter("correct");
        HttpSession session = request.getSession();
        session.setAttribute("id",datos);
               
        try (PrintWriter out = response.getWriter()) {
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
            String ruta = request.getServletContext().getRealPath("/") + request.getParameter("id")+".xml";
            ruta = ruta.replace("\\", "/"); 
            ruta = ruta.replaceAll("/build", "");
            File archivo = new File(ruta);
            if(archivo.exists()) {
                out.println("<body>");
                out.println("<div class='divisor' >");
                out.println("<h1 class='fuente' align='center'>El archivo ya existe, seleccione un nuevo nombre</h></br></br>");
                out.println("<button class='mdc-button mdc-button--outlined' name='opcion' type='submit' onclick=\"location.href='FillInBlankText'\">Regresar</button>");
                out.println("</div>");
                out.println("</body>");
                out.println("</html>");
            }else{
                BufferedWriter escritura = new BufferedWriter(new FileWriter(archivo));
                escritura.close();
                out.println("<body>");
                out.println("<div class='divisor' >");
                out.println("<h2 class='fuente' align='justify'>Feedback</h2>");
                out.println("<table class='fuente' align='center' border='0' width='500'>");
                out.println("<thead class='fuente'><th></th><th></th><th></th></thead>");
                out.println("<form action='XMLTextFill1' method='GET>");
                out.println("<tr align='justify'><td align='justify'>Tries</td><td align='justify'><input type='text' name='T1' size='10'/></td><td></td></tr>");
                out.println("<tr align='justify'><td>Initial Feedback</td><td><input type='text' name='Q1' size='50'/></td><td></td></tr>");
                out.println("<tr align='justify'><td>Evaluate Feedback</td><td><input type='text' name='Q2' size='50'/></td><td></td></tr>");
                out.println("<tr align='justify'><td>Tries FeedBack</td><td><input type='text' name='Q3' size='50'/></td><td></td></tr>");
                out.println("<tr align='justify'><td>Correct Feedback</td><td><input type='text' name='Q4' size='50'/></td><td></td></tr>");
                out.println("<tr align='justify'><td>Incorrect Feedback</td><td><input type='text' name='Q5' size='50'/></td><td></td></tr>");
                out.println("</table>");
                out.println("</br><button name='button1' class='mdc-button mdc-button--outlined'>Continuar</button>");
                out.println("</form></br>");
                out.println("</div>");
                out.println("</body>");
                out.println("</html>");
            }
        }
    }
}