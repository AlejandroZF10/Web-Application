package profe;

/**
 *
 * @author MaFer
 */
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

public class VerPreguntas extends HttpServlet { //Public es un modificador de clase, no es modificador de acceso

    @Override //Es una notación 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)//Protected en este caso si es un modificador de acceso, HTTPServelet son parámetros de entrada: request es de lado clienteservidor, response, el servidor WEB es el que proporciona los objetos request y response
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8"); //indica que se esta trabajando con una página html
        PrintWriter out = response.getWriter(); // se recupera el objeto out que nos permite establecer el canal de comunicación con el cliente, indicamos que enviaremos un flujo de salida de texto
        String tipo = request.getParameter("tipo");//Recuperamos el atributo tipo
        String id = request.getParameter("id");//Recuperamos el atributo id
        HttpSession session = request.getSession();
        session.setAttribute("tipo", tipo);//Subimos el atributo tipo a la sesion
        session.setAttribute("id", id);//Subimos el atributo id a la sesion
        
        //Recuperamos la ruta de donde se guardan todos los archivos 
        String rutaAbsoluta = request.getSession().getServletContext().getRealPath("/");
        rutaAbsoluta = rutaAbsoluta.replace("\\", "/");
        rutaAbsoluta = rutaAbsoluta.replaceAll("/build", "");   
        rutaAbsoluta = rutaAbsoluta + "/pregunta" + tipo + id + ".xml";//Concatenamos la ruta con el nombre del archivo

        //aquí ya se manda a imprimir lo que la página 
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>dinamica</title>");
        out.println("<link type='text/css' rel='stylesheet' href='http://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/hot-sneaks/jquery-ui.css' />");
        out.println("<link rel='stylesheet' type='text/css' href='https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css'/>");
        out.println("<link rel='stylesheet' href='fondoYletra.css'>");
        out.println("<style>");
        out.println("#preguntas{");
        out.println("  text-align: left;");
        out.println("  padding-left: 20px;");
        out.println("  padding-right: 0px;");
        out.println("  }");
        out.println(".hotobject{");
        out.println("  padding: 50px;");
        out.println("  margin: 10px;");
        out.println("  }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div id= 'main'>");

        try {
            SAXBuilder builder = new SAXBuilder();
            Document documento = builder.build(rutaAbsoluta);// Creamos un documento con la ruta del archivo
            Element raiz = documento.getRootElement();//Obtenemos la raiz de el documento
            List lista = raiz.getChildren("opcion");//Guardamos los hijos 'opcion' en una lista
            Element[] elemento = new Element[lista.size()];//Creamos un arreglo de elementos

            for (int j = 0; j < lista.size(); j++) {
                elemento[j] = (Element) lista.get(j);//Pasamos los objetos de la lista al arreglo
            }

            session.setAttribute("cont", lista.size());//Subimos cont a la sesion

            if (tipo.compareTo("H") == 0) {//Verificamos si es pregunta 'hotobject'
                out.println("<h2 class='demoHeaders'>Hot Object</h2>");
                out.println("<h1>" + raiz.getAttribute("texto").getValue() + "</h1>");//Imprimimos la pregunta
                out.println("<div style='text-align:center; padding:20px;'>");
                out.println("<br>");

                for (int i = 0; i < lista.size(); i++) {
                    String nombre = elemento[i].getText();//Obtenemos el texto de la opcion
                    String multimedia = elemento[i].getAttribute("multimedia").getValue();//Obtenemos el atributo multimedia
                    if (multimedia.equals("")) {//Verificamos si es una cadena vacia multimedia
                        out.println("<label for='" + nombre + "' class='hotobject'>" + nombre + "</label>");//Imprimimos la opcion en la pagina
                        out.println("<input class='che' type='checkbox' name='" + nombre + "' id='" + nombre + "'>");//Ponemos el checkbox con su label
                    } else {
                        out.println("<label>");
                        out.println("                <input type='checkbox' name='radio0' class='radio'>");//Creamos un checkbox con imagen
                        out.println("                <img src='"+multimedia+"' width='150' height='150' class='image'/>");
                        out.println("</label>");

                    }

                }

                out.println("</div>");

                out.println("<br>");
                out.println("<br>");

            }

            if (tipo.compareTo("M") == 0) {//Verificamos que sea una pregunta Multplechoice
                out.println("<h2 class=preguntas'>Multiple Choice</h2>");

                out.println("<h1>" + raiz.getAttribute("texto").getValue() + "</h1>");//Imprimimos la pregunta
                out.println("<div id='preguntas'>");
                out.println("<br>");

                if (!raiz.getAttribute("multimedia").getValue().equals("no")) {//Verificamos si tiene imagen o no
                    String tipoArchivo = raiz.getAttribute("multimedia").getValue();//Guardamos el valor del atributo multimedia
                    String[] arrayTipoArchivo = tipoArchivo.split("\\.");

                    if (arrayTipoArchivo[1].equals("jpg") || arrayTipoArchivo[1].equals("png") || arrayTipoArchivo[1].equals("gif") || arrayTipoArchivo[1].equals("svg")) {//Verificamos que sea un archivo de imagen
                        out.println("<img src='" + tipoArchivo + "' width='300' height='150' align='right'>");//Mostramos la imagen.
                    } else if (arrayTipoArchivo[1].equals("mp3") || arrayTipoArchivo[1].equals("ogg")) {//Verifcamos si es un archivo de audio
                        out.println("<div align='center' style='margin-bottom:20px;'> ");
                        out.println("<audio controls> ");
                        out.println("  <source src='" + tipoArchivo + "'>");//Mostramos el reproductor de audio
                        out.println("  Tu navegador no soporta el elemento <code>audio</code>.  ");
                        out.println("</audio>");
                        out.println("</div> ");
                    } else {
                        out.println("<div align='center' style='margin-bottom:20px;'> ");
                        out.println("<video src='" + tipoArchivo + "' width='300' height='150'  controls></video>");//Mostramos el video
                        out.println("</div> ");
                    }
                }
                for (int i = 0; i < lista.size(); i++) {//Imprimimos los valores de las preguntas 
                    String nombre = elemento[i].getText();
                    out.println("<label for='" + nombre + "'>" + nombre + "</label>");
                    out.println("<input type='checkbox' name='" + nombre + "' id='" + nombre + "'>");
                    out.println("<br><br>");
                }

                out.println("</div>");

                out.println("<br>");
                out.println("<br>");

            }

        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.println("<button id='button'>Regresar</button>");
        out.println("</div>");
        out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>");
        out.println("<script type='text/javascript' src='https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js'></script>");
        out.println("<script src='http://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js'></script>");
        out.println("<script>");
        out.println("$('input[type=checkbox]').checkboxradio();");
        out.println("$( '#button' ).button();");
        out.println("$( '#button' ).click(function URL(){");
        if(request.getParameter("vista").compareTo("profe")==0){
            out.println("	document.location.href = 'BienvenidoProfe'; ");
            out.println("});");
        }else{
           out.println("	document.location.href = 'NuevoExamen'; ");
            out.println("});"); 
        }
        out.println("$('.radio').click(function () {               ");
        out.println("                var $thisRadio = $(this), ");
        out.println("                        $thisImage = $thisRadio.next('.image'); ");
        out.println("                if ($thisRadio.is(':checked')) {");
        out.println("                    $thisImage.css('opacity', '0.5');");
        out.println("                } else {");
        out.println("                    $thisImage.css('opacity', '1');");
        out.println("                }");
        out.println("            });");
        out.println("</script>");
        out.println("</body>");
        out.println("</html>");
    }
}
