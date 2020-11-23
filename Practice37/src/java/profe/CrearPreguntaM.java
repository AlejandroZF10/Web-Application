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
import javax.xml.parsers.DocumentBuilderFactory;
import org.jdom.DocType;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;

public class CrearPreguntaM extends HttpServlet { //Public es un modificador de clase, no es modificador de acceso
   
    @Override //Es una notación 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)//Protected en este caso si es un modificador de acceso, HTTPServelet son parámetros de entrada: request es de lado clienteservidor, response, el servidor WEB es el que proporciona los objetos request y response
         throws ServletException, IOException { 
         response.setContentType("text/html;charset=UTF-8"); //indica que se esta trabajando con una página html
         PrintWriter out = response.getWriter(); // se recupera el objeto out que nos permite establecer el canal de comunicación con el cliente, indicamos que enviaremos un flujo de salida de texto
         HttpSession session=request.getSession();
         String tipo = (String) session.getAttribute("tipo");
         String carpeta= request.getSession().getServletContext().getRealPath("/");//ruta para guardar los archivos de preguntas
         carpeta = carpeta.replace("\\", "/");//en la cadena carpeta al encontrar \\ lo sustituira por /
         carpeta = carpeta.replaceAll("/build", "");//si encuentra /build lo cambiera por una cadena vacía
         int conti=Integer.parseInt(request.getParameter("cont"));//recuperamos el atributo contador que es el numero de opciones que tiene la pregunta
         String multimedia = (String) session.getAttribute("filename");
         
         try{
            DocType type = new DocType("pregunta","preguntaDTDMultiple.dtd");
            Element raiz = new Element("pregunta");//creamos el elemento raiz (pregunta)
            Element[] op=new Element[conti] ;//creamos un arreglo de elementos de tamaño de conti 
            if(multimedia!=null){//verificamos si existen elemetos multimedia
                raiz.setAttribute("multimedia",multimedia);//en caso de existir elementos multimedia los va a guardar el atributo llamado multimedia 
            }else{
                raiz.setAttribute("multimedia","no"); //en caso contrario se le asignara el valor de NO al atributo multimedia
            }
            for(int i=0;i<conti;i++){ //ciclo de 0 a conti (numero de opciones que tiene la pregunta)
                op[i]= new Element("opcion"); //creamos un nuevo elemento llamado opcopnes 
                op[i].setAttribute("estado",request.getParameter("check"+i));
                op[i].setText(request.getParameter("num"+i)); //agregamos texto en la etiqueta opción
                raiz.addContent(op[i]);//anidamos jerarquicamente la hoja a la raiz
            
            }
            
            
            //agregamos a la etiqueta pregunta, otros atributos como texto, id y tipo para indicar las caracteristicas de las preguntas 
            raiz.setAttribute("texto",request.getParameter("pregunta"));//nombre y valor del atributo
            raiz.setAttribute("id",request.getParameter("id"));    
            raiz.setAttribute("tipo","M");
            
            Document newdoc = new Document(raiz,type);//generamos un documento con esa estructura en memoria
            XMLOutputter fmt = new XMLOutputter();
            FileWriter writer = new FileWriter(carpeta + "/preguntaM" + request.getParameter("id") + ".xml");
            fmt.output(newdoc, writer);
            writer.flush();
            writer.close();
            
         }catch(Exception e){
            e.printStackTrace();
          }
            response.sendRedirect("BienvenidoProfe");

        }
    }
