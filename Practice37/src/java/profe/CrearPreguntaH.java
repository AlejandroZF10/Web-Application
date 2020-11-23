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
import org.jdom.DocType;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;

public class CrearPreguntaH extends HttpServlet { //Public es un modificador de clase, no es modificador de acceso
   
    @Override //Es una notación 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)//Protected en este caso si es un modificador de acceso, HTTPServelet son parámetros de entrada: request es de lado clienteservidor, response, el servidor WEB es el que proporciona los objetos request y response
         throws ServletException, IOException { 
         response.setContentType("text/html;charset=UTF-8"); //indica que se esta trabajando con una página html
         PrintWriter out = response.getWriter(); // se recupera el objeto out que nos permite establecer el canal de comunicación con el cliente, indicamos que enviaremos un flujo de salida de texto
         String carpeta= request.getSession().getServletContext().getRealPath("/");//ruta para guardar los archivos de preguntas
         carpeta = carpeta.replace("\\", "/"); //en la cadena carpeta al encontrar \\ lo sustituira por /
         carpeta = carpeta.replaceAll("/build", ""); //si encuentra /build lo cambiera por una cadena vacía
         int conti=Integer.parseInt(request.getParameter("cont"));//recuperamos el atributo contador que es el numero de opciones que tiene la pregunta
         int i;
         HttpSession session = request.getSession();
        
         try{
            DocType type = new DocType("pregunta","preguntaDTDHot.dtd");
            Element raiz = new Element("pregunta");//creamos el elemento raiz (pregunta)
            Element[] op=new Element[conti] ; //creamos un arreglo de elementos de tamaño de conti 
            String[] multimedias = new String[conti]; //creamos un arreglo de cadenas de tamaño conti 

            for(i=0;i<conti;i++){//ciclo de 0 al numero de opciones (conti) 
                multimedias[i] = request.getParameter("multi"+i); //recuperamos los elementos multimedia 
                op[i]= new Element("opcion"); //creamos el elemento de opcion 
                op[i].setAttribute("estado",request.getParameter("check"+i)); //le damos un atributo al elemento opción  llamado estado 
                if(multimedias[i]!=null){ //verificamos si existen elemetos multimedia 
                    op[i].setAttribute("multimedia",multimedias[i]);//en caso de existir elementos multimedia los va a guardar el atributo llamado multimedia 
                }else{
                    op[i].setAttribute("multimedia","no"); //en caso contrario se le asignara el valor de NO al atributo multimedia
                }
                op[i].setText(request.getParameter("num"+i)); //se le agrega texto (correcto o incorrecto) dentro  de la etiqueta opcion
                raiz.addContent(op[i]);//anidamos jerarquicamente la hoja a la raiz
                
            }
            //agregamos a la etiqueta pregunta, otros atributos como texto, id y tipo para indicar las caracteristicas de las preguntas 
            raiz.setAttribute("texto",request.getParameter("pregunta"));//nombre y valor del atributo
            raiz.setAttribute("id",request.getParameter("id"));          
            raiz.setAttribute("tipo","H");
            
            session.setAttribute("id",request.getParameter("id"));
            session.setAttribute("tipo","H");
            Document newdoc = new Document(raiz,type);//generamos un documento con esa estructura en memoria
            XMLOutputter fmt = new XMLOutputter();
            
            FileWriter writer = new FileWriter(carpeta+"/preguntaH"+request.getParameter("id")+".xml");//se crea el documento con la ruta y el nombre de archivo que se especifíca 
            fmt.output(newdoc,writer);
            writer.flush();
            writer.close();

            
         }catch(Exception e){
            e.printStackTrace();
          }
            response.sendRedirect("BienvenidoProfe"); //redireccionar a servelet BienvenidoProfe

        }
    }

    
