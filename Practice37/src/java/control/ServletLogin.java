package control;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class ServletLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id"); //recuperamos los parametros del formulario
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        session.setAttribute("userName",id); //subimos a la sesion el id
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //Para obtener la ruta absoluta del proyecto
        String rutaAbsoluta = request.getSession().getServletContext().getRealPath("/");
        rutaAbsoluta = rutaAbsoluta.replace("\\", "/");
        rutaAbsoluta = rutaAbsoluta.replaceAll("/build", "");
        //Ruta absoluta del archivo users.xml
        rutaAbsoluta = rutaAbsoluta.concat("users.xml");
        File users = new File(rutaAbsoluta);    //creamos un File
        int tipo=validateUser(users, id, password); 
        // creamos un entero que regresa el tipo de usuario que sea si es que esta registrado
        if (tipo>0) { //si es mayor que 0 esta registrado
            if(tipo==1) //Si es 1 entonces es administrador
                response.sendRedirect("EscritorioAdmin");
            else if(tipo==2)    //si es 2 entonces es profesor
                response.sendRedirect("BienvenidoProfe");
            else //solo queda que es alumno
                response.sendRedirect("EscritorioAlumno");
        } else // username/password not validated
        {
            response.sendRedirect("ServletFallo");  //sino redireccionamos a la pantalla de fallo
        }

    }

    public int validateUser(File users, String userName, String password) {
        try {
            SAXBuilder builder = new SAXBuilder(); //declaramos nuestro saxbuilder para manejar nuestro xml
            //File archivoXML = new File(url);
            Document documento = builder.build(users);//el file que nos pasan lo contruimos 
            Element raiz = documento.getRootElement();//obtenemos el elemento raiz
            List lista = raiz.getChildren("user"); //agregamos a una lista los usuarios

            for (int i = 0; i < lista.size(); i++) { //recorremos la lita
                Element elemento = (Element) lista.get(i); //hacemos un elemento de los usuarios
                String name = elemento.getChildTextTrim("name");    //recuperamos el texto del hijo name
                String pass = elemento.getChildTextTrim("password");    //recuperamos el texto del hijo password
                if (name.equals(userName)) {    //comparamos los parametro del formulario y del xml
                    if (pass.equals(password)) {    //imprimimos en consola si lo logro loguear
                        System.out.println("Usuario logueado:" + userName );
                        Attribute attribute = elemento.getAttribute("type");//recuperamos el tipo que esta en el xml
                        int tipo=Integer.parseInt(attribute.getValue());    //guardamos el valor en tipo
                        System.out.println("tipo "+tipo);
                        return tipo; //regresamos el tipo
                    }
                } 
            }
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Usuario no logueado: Contraseña incorrecta");
        return 0;
    }
}
