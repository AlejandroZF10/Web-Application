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

public class CreateXML extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String[] datos = new String[7];
        datos[0] = request.getParameter("id");
        datos[1] = request.getParameter("pregunta");
        datos[2] = request.getParameter("Q1");
        datos[3] = request.getParameter("Q2");
        datos[4] = request.getParameter("Q3");
        datos[5] = request.getParameter("Q4");
        datos[6] = request.getParameter("correct");
        int length = datos[0].length()*datos[1].length()*datos[2].length()*datos[3].length()*datos[4].length()*datos[5].length();
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
            out.println("<body>");
            out.println("<div class='divisor' >");
            if(length>0){
                HttpSession sesion = request.getSession();
                sesion.setAttribute("userName",datos);
                String ruta = request.getServletContext().getRealPath("/") + request.getParameter("id")+".xml";
                File archivo = new File(ruta);
                if(archivo.exists()) {
                    out.println("<h1 class='fuente' align='center'>El archivo ya existe, seleccione un nuevo nombre</h></br></br>");
                    out.println("<button class='mdc-button mdc-button--outlined' name='opcion' type='submit' onclick=\"location.href='FillInBlankText'\">Regresar</button>");
                }else{
                    BufferedWriter escritura = new BufferedWriter(new FileWriter(archivo));
                    response.sendRedirect("EditXML");
                    escritura.close();
                }
            }else{
                out.println("<h1 class='fuente' align='center'>Faltan campos por llenar</h></br></br>");
                out.println("<button class='mdc-button mdc-button--outlined' name='opcion' type='submit' onclick=\"location.href='FillInBlankText'\">Regresar</button>");
            }
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}