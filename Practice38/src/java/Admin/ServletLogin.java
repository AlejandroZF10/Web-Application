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
import org.jdom.Attribute;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class ServletLogin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        String id = request.getParameter("id");
        String password = request.getParameter("password");        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("userName",id);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String rutaAbsoluta = request.getSession().getServletContext().getRealPath("/");
        rutaAbsoluta = rutaAbsoluta.replace("\\","/");
        rutaAbsoluta = rutaAbsoluta.replaceAll("/build","");
        rutaAbsoluta = rutaAbsoluta.concat("Login.xml");
        File users = new File(rutaAbsoluta);
        int tipo = validateUser(users,id,password);
        if(tipo > 0){
            switch (tipo){
                case 1:
                    response.sendRedirect("Administrador");
                break;
                case 2:
                    response.sendRedirect("Profesor");
                break;
                case 3:
                    response.sendRedirect("Alumno");
                break;
            }
        } else {
            response.sendRedirect("FalloLogin");
        }
        
    }
    
    public int validateUser(File users, String userName ,String Password){
        try{
            SAXBuilder builder = new SAXBuilder();
            Document documento = builder.build(users);
            Element raiz = documento.getRootElement();
            List lista = raiz.getChildren("user");
            for(int i = 0; i<lista.size() ;i++){
                Element elemento = (Element)lista.get(i);
                String name = elemento.getChildTextTrim("username");
                String pass = elemento.getChildTextTrim("password");
                if(name.equals(userName)){
                    if(pass.equals(Password)){
                        System.out.println("Acceso exitoso: "+userName);
                        Attribute attribute = elemento.getAttribute("type");
                        int tipo = Integer.parseInt(attribute.getValue());
                        System.out.print("Tipo: "+tipo);
                        return tipo;
                    }
                }
            }
        }catch(JDOMException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }

        return 0;
    }
}