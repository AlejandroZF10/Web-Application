package Admin;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class Modificar_Pregunta extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String id = request.getParameter("id");
            String rutaAbsoluta = request.getSession().getServletContext().getRealPath("/"); 
            rutaAbsoluta = rutaAbsoluta.replace("\\", "/");
            rutaAbsoluta = rutaAbsoluta.replaceAll("/build", "");
            rutaAbsoluta = rutaAbsoluta+id;
            File archivo = new File(rutaAbsoluta);
            try{
                SAXBuilder builder = new SAXBuilder(); 
                Document documento = builder.build(rutaAbsoluta);
                Element raiz = documento.getRootElement();
                List lista = raiz.getChildren("opcion"); 
                Element[] elemento=new Element[lista.size()];
                for(int j=0; j<lista.size();j++){ //ciclo desde 0 hasta el tamaño de la lista
                    elemento[j]=(Element) lista.get(j); //convertimos cada elemeto de la lista a un arreglo de ELEMENT
                }
                if(raiz.getAttribute("tipo").getValue().compareTo("Audio")==0){
                    response.sendRedirect("ModificarAudio");
                }else{
                    if(raiz.getAttribute("tipo").getValue().compareTo("Video")==0){
                        response.sendRedirect("ModificarVideo");
                    }else{
                        if(raiz.getAttribute("tipo").getValue().compareTo("Image")==0){
                            response.sendRedirect("ModificarImage");
                        }else{
                            if(raiz.getAttribute("tipo").getValue().compareTo("texto")==0){
                                    response.sendRedirect("ModificarTexto");
                            }
                        }
                    }
                    
                }
                
            }catch (JDOMException e) {
                out.println("entre c");
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
                out.println("entre c");
            }
                   
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Modificar_Pregunta</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Modificar_Pregunta at " + rutaAbsoluta + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
        }
    }
}