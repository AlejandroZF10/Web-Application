/**
 * @author
 * JIMENEZ MUÑOZ ARVID
 * LASTIRI ALFARO MARIA FERNANDA
 * MELENDEZ MACEDONIO JONATHAN 
 * QUINTANA RUIZ AJITZI RICARDO 
 */

package profe;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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

public class ModificarPregunta extends HttpServlet { //Public es un modificador de clase, no es modificador de acceso

    @Override //Es una notación 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)//Protected en este caso si es un modificador de acceso, HTTPServelet son parámetros de entrada: request es de lado clienteservidor, response, el servidor WEB es el que proporciona los objetos request y response
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8"); //indica que se esta trabajando con una página html
        PrintWriter out = response.getWriter(); // se recupera el objeto out que nos permite establecer el canal de comunicación con el cliente, indicamos que enviaremos un flujo de salida de texto
        String tipo = request.getParameter("tipo"); //recuperamos el valor de tipo de pregunta 
        String id = request.getParameter("id"); //recupeamos el número de pregunta 
        HttpSession session = request.getSession();
        session.setAttribute("tipo", tipo); //guardamos el tipo de pregunta, esto con el fin de que no se pierda el valor cuando la página de refresca
        session.setAttribute("id", id); //guardamos el número de pregunta, esto con el fin de que no se pierda el valor cuando la página de refresca
        

        String rutaAbsoluta = request.getSession().getServletContext().getRealPath("/"); //ruta donde se guardan todos los archivos
        rutaAbsoluta = rutaAbsoluta.replace("\\", "/"); //en la cadena carpeta al encontrar \\ lo sustituira por /
        rutaAbsoluta = rutaAbsoluta.replaceAll("/build", ""); //si encuentra /build lo cambiera por una cadena vacía
        rutaAbsoluta = "file:///"+rutaAbsoluta + "pregunta" + tipo + id + ".xml"; //concatenamos a la ruta el nombre y extensión del archivo
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>dinamica</title>");
        out.println(" <link type='text/css' rel='stylesheet' href='http://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/hot-sneaks/jquery-ui.css' />");
        out.println("<link rel='stylesheet' href='fondoYletra.css'>");
        out.println("<style>");       
        out.println(".caja{");
        out.println("  height: 30px;");
        out.println("}");
        out.println(".area{");
        out.println("  width: 85%;");
        out.println("}");
        out.println("</style");
        out.println("</head>");
        out.println("<body>");
        out.println("<div id='main'>");
        
        try {
            SAXBuilder builder = new SAXBuilder(); 
            Document documento = builder.build(rutaAbsoluta);
            Element raiz = documento.getRootElement();//obtenemos la etiqueta raiz del documento 
            List lista = raiz.getChildren("opcion"); //guarda en una lista todas las etiquetas opcion 
            Element[] elemento=new Element[lista.size()]; //obtenemos el tamaño de la lista anterior
            
            for(int j=0; j<lista.size();j++){ //ciclo desde 0 hasta el tamaño de la lista
                elemento[j]=(Element) lista.get(j); //convertimos cada elemeto de la lista a un arreglo de ELEMENT
            }
            
            session.setAttribute("cont",lista.size()); //guardamos el tamaño de la lista en el vale de cont

            if (tipo.compareTo("H") == 0) { //si el tipo de la pregunta es H entonces hará las siguientes opciones 
                out.println("<h1>HOTOBJECT</h1>");
                out.println("<br>");
                out.println("<form action='SobrescribirH' method='post' id='fo' > "); //form que direcciona a SobrescribirH
                out.println("<h2>ID de Interaccion:</h2> <input type='text' class='caja' name='id' value='" + id + "'/>"); //creamos un cuadro de texto para agregar el id
                out.println("<br>");
                out.println("<h2>Pregunta</h2> <br> <textarea class='area' rows='4' cols='30' name='pregunta' form='fo' >"); //espacio para agregar la pregunta
                out.println(raiz.getAttribute("texto").getValue()); //obtenemos de la etiqueta pregunta el valor del atributo texto 
                out.println("</textarea>");
                out.println("<br>");
                out.println("<h2>Nombres de las instancias hotobject</h2> ");
                out.println("<br>");
                for(int i=0;i<lista.size();i++){//creacion de las cajas que contienen las opciones de respuesta de la pregunta 
                    out.println("<b>"+(i+1)+"</b> <input type='text' name='num"+i+"' class='caja' value='" + elemento[i].getText() + "'/>");
                    out.println("<input type='text' class='caja' name='multimedia"+i+"' value='"+elemento[i].getAttributeValue("multimedia")+"' readonly/>");
                    if (elemento[i].getAttributeValue("estado").compareTo("correcto") == 0) {//verificamos el estado de la opcion, si es incorrecto: 
                        out.println("<select class='selectmenu' name='check"+i+"'  > <option value='correcto' selected>Correcto</option> <option value='incorrecto' >Incorrecto</option>  </select> <br>"); //se agrega en la vista para dicha opción que estado tiene
                    } else { //en caso contrario, estamos hablando de una opción corredcta 
                        out.println("<select class='selectmenu' name='check"+i+"'  > <option value='correcto' >Correcto</option> <option value='incorrecto' selected>Incorrecto</option>  </select> <br>");//se agrega en la vista para dicha opción que estado tiene
                    }
                }
                
                
                out.println("<br>");
                out.println("<br>");
                out.println("<input type='submit'  value='guardar' class='button' />    <input type='submit' value='opciones' class='button' formaction='opcionesPregunta' /> ");//botón que te envía a a las opciones de pregunta

                out.println("</form>");
            }

            if (tipo.compareTo("M") == 0) {
                out.println("<h1>MULTIPLE CHOICE</h1>"); //si el tipo de la pregunta es M entonces hará las siguientes opciones 
                out.println("<br>");
                out.println("<form action='SobrescribirM' method='post' id='fo' > ");//form que direcciona a SobrescribirM
                out.println("<h2>ID de Interaccion:</h2> <input type='text' name='id' class='caja'  value='" + id + "'/>");
                out.println("<br>");
                out.println("<input type='text' name='filename' value='"+raiz.getAttributeValue("multimedia")+"' class='caja' readonly/>");
                out.println("<br>");
                out.println("<h2>Pregunta</h2> <br> <textarea class='area' rows='4' cols='30' placeholder='Ingresa Pregunta' name='pregunta' form='fo' >");
                out.println(raiz.getAttribute("texto").getValue());
                out.println("</textarea>");
                out.println("<br>");
                out.println("<h2>Nombres de las instancias Multiple Choice:</h2> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                out.println("<br>");
               
                for(int i=0;i<lista.size();i++){//creacion de las cajas que contienen las opciones de respuesta de la pregunta 
                    out.println("<b>"+(i+1)+"</b> <input type='text' name='num"+i+"' class='caja' value='" + elemento[i].getText() + "'/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                
                    if (elemento[i].getAttributeValue("estado").compareTo("correcto") == 0) {
                        out.println("<select class='selectmenu' name='check"+i+"'  > <option value='correcto' selected>Correcto</option> <option value='incorrecto' >Incorrecto</option>  </select> <br>");//verificamos el estado de la opcion, si es incorrecto: 
                    } else {
                        out.println("<select class='selectmenu' name='check"+i+"'  > <option value='correcto' >Correcto</option> <option value='incorrecto' selected>Incorrecto</option>  </select> <br>");
                    }
                }

                out.println("<br>");
                out.println("<br>");
                out.println("<input type='submit'  value='guardar' class='button'/>    <input type='submit' value='opciones' class='button' formaction='opcionesPreguntaM' /> ");
                out.println("</form>");
            }
        } catch (JDOMException e) {
            out.println("entre c");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            out.println("entre c");
        }
        
        
        out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>");
        out.println("<script src='http://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js'></script>");
        out.println("<script>");
        out.println("$( '.selectmenu' ).selectmenu();");
        out.println("$('.button').button();");
        out.println("</script>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}
