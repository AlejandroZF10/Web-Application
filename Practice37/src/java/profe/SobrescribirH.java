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

public class SobrescribirH extends HttpServlet { //Public es un modificador de clase, no es modificador de acceso
   
    @Override //Es una notación 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)//Protected en este caso si es un modificador de acceso, HTTPServelet son parámetros de entrada: request es de lado clienteservidor, response, el servidor WEB es el que proporciona los objetos request y response
        throws ServletException, IOException { 
        response.setContentType("text/html;charset=UTF-8"); //indica que se esta trabajando con una página html
        PrintWriter out = response.getWriter(); // se recupera el objeto out que nos permite establecer el canal de comunicación con el cliente, indicamos que enviaremos un flujo de salida de texto
        String carpeta= request.getSession().getServletContext().getRealPath("/");
        
        int i;
        carpeta = carpeta.replace("\\", "/"); //en la cadena carpeta al encontrar \\ lo sustituira por /
        carpeta = carpeta.replaceAll("/build", ""); //si encuentra /build lo cambiera por una cadena vacía
        HttpSession session=request.getSession();
        String tipo = (String) session.getAttribute("tipo"); //recuperamos el valor de tipo de prregunta    
        String id = (String) session.getAttribute("id");//recuperamos el numero de pregunta q
        int conti = (int) session.getAttribute("cont");
        File archivo = new File(carpeta+"/pregunta"+tipo+id+".xml");//concatenamos ruta con nombre de archivo extensión 
        archivo.delete();
        
         try{
            DocType type = new DocType("pregunta","preguntaDTDHot.dtd"); //definimos el tipo de documento 
            Element raiz = new Element("pregunta");//nombre del elemento
            Element[] op=new Element[conti] ; //creamos un arreglo de elementos
            String[] multimedias = new String[conti]; //creamos un arreglo de multimedia

            for(i=0;i<conti;i++){ //el ciclo se detiene cuando la cantidad (conti) que es el número de opciones 
                multimedias[i] = request.getParameter("multimedia"+i); //guarda todos los parametrod de cultimedia en el arreglo
                op[i]= new Element("opcion");//crear los elementos opcion 
                op[i].setAttribute("estado",request.getParameter("check"+i)); //al atributo estaod se le asigna el valor de paraetro recuperado 
                if(multimedias[i]!=null){//verificamos si multimedia no esta seleccionado, si si lo esta:
                    op[i].setAttribute("multimedia",multimedias[i]);//al atributo multimedia le asignamos el valor del elemento 
                }else{
                    op[i].setAttribute("multimedia","no"); //en caso contrario le agregamos el valor 'No'
                }
                op[i].setText(request.getParameter("num"+i));
                raiz.addContent(op[i]);//anidamos jerarquicamente la hoja a la raiz
                
            }
            
            raiz.setAttribute("texto",request.getParameter("pregunta"));//nombre y valor del atributo
            raiz.setAttribute("id",id);            
            raiz.setAttribute("tipo","H");
            Document newdoc = new Document(raiz,type);//generamos un documento con esa estructura en memoria
            XMLOutputter fmt = new XMLOutputter();
          
            FileWriter writer = new FileWriter(carpeta+"/preguntaH"+id+".xml");
            fmt.output(newdoc,writer);
            writer.flush();
            writer.close();

            
         }catch(Exception e){
            e.printStackTrace();
          }
            response.sendRedirect("BienvenidoProfe"); //redireccionamos a BienvenidoProfe

        }
    }

    
