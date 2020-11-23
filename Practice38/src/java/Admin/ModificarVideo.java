package Admin;

import java.io.File;
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

public class ModificarVideo extends HttpServlet {
     @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()){
            try{
                HttpSession sesion = request.getSession();
                String id = (String)sesion.getAttribute("userName");
                String rutaAbsoluta = request.getSession().getServletContext().getRealPath("/"); 
                rutaAbsoluta = rutaAbsoluta.replace("\\", "/");
                rutaAbsoluta = rutaAbsoluta.replaceAll("/build", "");
                rutaAbsoluta = rutaAbsoluta+id; String nombre = "";
                String texto = ""; String multimedia = ""; String []opcion;
                SAXBuilder builder = new SAXBuilder(); 
                Document documento = builder.build(rutaAbsoluta);
                Element raiz = documento.getRootElement();
                List lista = raiz.getChildren("opcion"); 
                Element[] elemento=new Element[lista.size()];
                texto = raiz.getAttribute("texto").getValue();
                for(int j=0; j<lista.size();j++){
                    elemento[j]=(Element) lista.get(j);
                }
                multimedia = raiz.getAttribute("multimedia").getValue();
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
                out.println("<button disabled class='mdc-button mdc-button--outlined'\">Imagen</button>");
                out.println("<button  class='mdc-button mdc-button--outlined'\">Video</button>");

                out.println("<form action = 'FeedBack2' method = 'POST'>");
                out.println("<p class='fuente' align='justify'>Pregunta: <input type='text' name='pregunta' value='"+texto+"' size='60'></textarea></p>");
                out.println("<table class='fuente' align='center' border='0' width='500'>");
                out.println("<thead class='fuente'><th></th><th>Respuestas</th><th>Respuesta correcta</th></thead>");
                for (int i = 0; i < lista.size(); i++) {
                    nombre = elemento[i].getText();//Obtenemos el texto de la opcion
                    out.println("<tr><td>"+(i+1)+"-. </td><td><input type='text' value='"+nombre+"' name='Q"+(i+1)+"' size='50'/></td><td ><input type='checkbox' name='correct' value='Correct"+(i+1)+"'></td></tr>");
                }
                out.println("</table>");
                out.println("</br><button class='mdc-button mdc-button--outlined'>Continuar</button>");
                out.println("</div>");
                out.println("</body>");
                out.println("</html>");
                }catch (JDOMException e) {
                    out.println("entre c");
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                    out.println("entre c");
                }
        }
    }
}