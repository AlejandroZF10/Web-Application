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

public class SobrescribirM extends HttpServlet { //Public es un modificador de clase, no es modificador de acceso
   
    @Override //Es una notación 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)//Protected en este caso si es un modificador de acceso, HTTPServelet son parámetros de entrada: request es de lado clienteservidor, response, el servidor WEB es el que proporciona los objetos request y response
         throws ServletException, IOException { 
         response.setContentType("text/html;charset=UTF-8"); //indica que se esta trabajando con una página html
         PrintWriter out = response.getWriter(); // se recupera el objeto out que nos permite establecer el canal de comunicación con el cliente, indicamos que enviaremos un flujo de salida de texto
         String carpeta= request.getSession().getServletContext().getRealPath("/");//Obtenemos la ruta de la carpeta
         carpeta = carpeta.replace("\\", "/");
         carpeta = carpeta.replaceAll("/build", "");
         HttpSession session=request.getSession();
         
        String tipo = (String) session.getAttribute("tipo");//Obtenemos el atributo tipo
        String id = (String) session.getAttribute("id");//Obtenemos el atributo tipo
         
         File archivo = new File(carpeta+"/pregunta"+tipo+id+".xml");//Creamos un apuntador al archivo.
         archivo.delete();//Borramos el archivo.
         int conti=(int) session.getAttribute("cont");//obtenemos el atributo cont
          try{
            DocType type = new DocType("pregunta","preguntaDTDMultiple.dtd");//Indicamos el Doctype del documento
            Element raiz = new Element("pregunta");//nombre del elemento
            Element[] op=new Element[conti] ;//Creamos un arreglo de elementos
            
            if(request.getParameter("filename")==null){//Verificamos si tiene multimedia
                raiz.setAttribute("multimedia", "no");//Si no tiene multimedia pone 'no'
            }else{
                raiz.setAttribute("multimedia",request.getParameter("filename"));// Si trae multimedia guarda el nombre del archivo como atributo
            }
            for(int i=0;i<conti;i++){
                op[i]= new Element("opcion");//Creamos elementos 'opcion'
                op[i].setAttribute("estado",request.getParameter("check"+i));//Le damos al atributo estado el valor del parametro recibido
                op[i].setText(request.getParameter("num"+i));//Asignamos texto dentro de las etiquetas
                raiz.addContent(op[i]);//anidamos jerarquicamente la hoja a la raiz
            
            }
            
            raiz.setAttribute("texto",request.getParameter("pregunta"));//Creamos el atributo texto
            raiz.setAttribute("id",request.getParameter("id"));//Creamos el atributo id
            raiz.setAttribute("tipo","M");//Creamos el atributo tipo
                
            Document newdoc = new Document(raiz,type);//generamos un documento con esa estructura en memoria
            XMLOutputter fmt = new XMLOutputter();
            
            FileWriter writer = new FileWriter(carpeta+"/preguntaM"+request.getParameter("id")+".xml");//Creamos el archivo con la ruta especificada
            fmt.output(newdoc,writer);//Escribimos en el archivo
            writer.flush();
            writer.close();
            
         }catch(Exception e){
            e.printStackTrace();
          }
            response.sendRedirect("BienvenidoProfe");

        }
    }

    
