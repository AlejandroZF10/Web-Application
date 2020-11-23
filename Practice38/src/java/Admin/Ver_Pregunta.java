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

public class Ver_Pregunta extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("id");
        HttpSession sesion = request.getSession();
        sesion.setAttribute("userName",id);
        String rutaAbsoluta = request.getSession().getServletContext().getRealPath("/"); 
        rutaAbsoluta = rutaAbsoluta.replace("\\", "/");
        rutaAbsoluta = rutaAbsoluta.replaceAll("/build", "");
        rutaAbsoluta = rutaAbsoluta+id;
        try (PrintWriter out = response.getWriter()) {
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
                    response.sendRedirect("VerAudio");
                }else{
                    if(raiz.getAttribute("tipo").getValue().compareTo("Video")==0){
                        response.sendRedirect("VerVideo");
                    }else{
                        if(raiz.getAttribute("tipo").getValue().compareTo("Image")==0){
                            response.sendRedirect("VerImage");
                        }else{
                            if(raiz.getAttribute("tipo").getValue().compareTo("texto")==0){
                                response.sendRedirect("VerTexto1");
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
        }
    }
}