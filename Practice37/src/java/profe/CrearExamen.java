/**
 * @author
 * JIMENEZ MUÑOZ ARVID
 * LASTIRI ALFARO MARIA FERNANDA
 * MELENDEZ MACEDONIO JONATHAN 
 * QUINTANA RUIZ AJITZI RICARDO 
 */
package profe;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;

import org.jdom.output.XMLOutputter;

public class CrearExamen extends HttpServlet { //Public es un modificador de clase, no es modificador de acceso
   
    @Override //Es una notación 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)//Protected en este caso si es un modificador de acceso, HTTPServelet son parámetros de entrada: request es de lado clienteservidor, response, el servidor WEB es el que proporciona los objetos request y response
        throws ServletException, IOException { 
        response.setContentType("text/html;charset=UTF-8"); //indica que se esta trabajando con una página html
        PrintWriter out = response.getWriter(); // se recupera el objeto out que nos permite establecer el canal de comunicación con el cliente, indicamos que enviaremos un flujo de salida de texto
        
        HttpSession session = request.getSession();
        int cont = (int) session.getAttribute("cont");
        String ruta = request.getSession().getServletContext().getRealPath("/");
        ruta = ruta.replace("\\", "/");
        ruta = ruta.replaceAll("/build", "");
        
        try{
            Element examen = new Element("Examen"); //creamos la etiqueta raiz(elemento) del archivo xml de examen //creamos la etiqueta raiz(elemento) del archivo xml de examen 
            
            for (int i = 0; i < cont; i++) {//la variables cont es la cantidad de preguntas creadas hasta el momento
                //obtenemos la ruta donde se estan guardando todo los archivos

                String pregunta = request.getSession().getServletContext().getRealPath("/");
                pregunta = pregunta.replace("\\", "/");
                pregunta = pregunta.replaceAll("/build", "");
                
                if(request.getParameter("check"+i)!=null){ //verifica cual de los checkbox fue seleccionado (los que no fueron seleccionados tienen el valor null)
                    
                    
                  Element preguntaXml = new Element("pregunta"); //creamos la etiqueta pregunta para el archivo xml
                  preguntaXml.setText("pregunta"+request.getParameter("check"+i)+".xml");//dentro de la etiqueta vamos a escribir el nombre del archivo de la pregunta que se quiere agregar
                    examen.addContent(preguntaXml);//anidamos la etiqueta pregunta en la eetiqueta examen
                }
            }

            
            examen.setAttribute("id", request.getParameter("id"));//en la etiqueta examen agregamos un atributo (id) que guarda el id del exmen que el usuario escribio en el input
            
            Document newdoc = new Document(examen);//generamos un documento con esa estructura en memoria
            XMLOutputter fmt = new XMLOutputter();
          //indicamos la ruta en la que se va a guardar el archivo de examen, así como el nombre que va a tener
            FileWriter writer = new FileWriter(ruta+"/examen"+request.getParameter("id")+".xml");
            fmt.output(newdoc,writer);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            out.println("entre c");
        }
        
        response.sendRedirect("Examenes");//redireccionamiento a servlet examenesq

        }
    }
