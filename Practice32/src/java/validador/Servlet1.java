package validador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jdomvalidador.JDOMValidador;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;


public class Servlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            response.setContentType("text/html;charset=UTF-8");
            String url = request.getParameter("url");
            PrintWriter out = response.getWriter();
            out.println("<DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> Servlet Servlet 1</title>");
            out.println("</head>");
            out.println("<body>");
              
            JDOMValidador validador=new JDOMValidador();
            try{
                try{
                    //DOCUMENTO CONFORME??
                    validador.checkConforme(url);
                }catch(JDOMException e){
                    out.println(url+" No esta bien conformado");
                    out.println(e.getMessage());
                    out.println("</body>");
                    out.println("</html>");
                    
                }
                //SI EL FICHERO ESTA BIEN COONFORMADO, SIN ERRORES
                out.println(url+" Esta bien conformado");
                try{
                    //DOCUMENTO VALIDO??
                    validador.checkValido(url);
                }catch(JDOMException e){
                    //INDICACION DE UN FICHERO NO VALIDO
                    out.println(url+" NO es valido");
                    out.println(e.getMessage());
                    out.println("</body>");
                    out.println("</html>");
                    
                }
                //SI EL FICHERO ES VALIDO
                out.println(url+" ES valido");
            }catch(IOException e){
                //INDICACION DE QUE EL FICHERO NO ES ACCESIBLE
                out.println("NO se puede chequear "+url);
                out.println("porque: "+e.getMessage());
                out.println("</body>");
                out.println("</html>");
            }
            out.println("</body>");
            out.println("</html>");
    
    
    }
}