package Admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class VerAudio extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sesion = request.getSession();
        String id = (String)sesion.getAttribute("userName");
        String rutaAbsoluta = request.getSession().getServletContext().getRealPath("/"); 
        rutaAbsoluta = rutaAbsoluta.replace("\\", "/");
        rutaAbsoluta = rutaAbsoluta.replaceAll("/build", "");
        rutaAbsoluta = rutaAbsoluta+id; String nombre = "";
        String texto = ""; String multimedia = ""; String []opcion;
        try (PrintWriter out = response.getWriter()) {
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
            out.println("<body>");
            try{
                SAXBuilder builder = new SAXBuilder(); 
                Document documento = builder.build(rutaAbsoluta);
                Element raiz = documento.getRootElement();
                List lista = raiz.getChildren("opcion"); 
                Element[] elemento=new Element[lista.size()];
                texto = raiz.getAttribute("texto").getValue();
                out.println("<div class='divisor'>");
                out.println("<h1 class='fuente'>" + texto + "</h1>");
                out.println("<table class='table-fill' align='center' border='1' width='200'>");
                out.println("<tbody>");
                for(int j=0; j<lista.size();j++){
                    elemento[j]=(Element) lista.get(j);
                }
                for (int i = 0; i < lista.size(); i++) {
                    nombre = elemento[i].getText();//Obtenemos el texto de la opcion
                    out.println("<tr><td><p class='fuente'>"+nombre+"</p></td><td><input type='checkbox' name='correct"+i+"' value='Correct"+i+"'></td>");
                }
                multimedia = raiz.getAttribute("multimedia").getValue();
                out.println("</div>");
                out.println("</table></br><input type='text' name='correct' size='100'></br></br>");
                out.println("<audio controls autoplay><source src='"+multimedia+"' type=\"audio/mp3\">Your browser does not support the audio element</audio>");
            }catch (JDOMException e) {
                out.println("entre c");
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
                out.println("entre c");
            }
            
            
            out.println("</body>");
            out.println("</html>");
        }
    }
}