package alumno;

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
import javax.servlet.http.HttpServletResponse;            // librerias necesarias para ejecutar el programa 
import javax.servlet.http.HttpSession;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class RealizarExamen extends HttpServlet { //Public es un modificador de clase, no es modificador de acceso

    @Override //Es una notación 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)//Protected en este caso si es un modificador de acceso, HTTPServelet son parámetros de entrada: request es de lado clienteservidor, response, el servidor WEB es el que proporciona los objetos request y response
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8"); //indica que se esta trabajando con una página html
        PrintWriter out = response.getWriter(); // se recupera el objeto out que nos permite establecer el canal de comunicación con el cliente, indicamos que enviaremos un flujo de salida de texto
       
        String id = request.getParameter("id");   // recuoeramos el parametro id y lo almacenamos en una cadena llamda id
        HttpSession session = request.getSession();  // obtenemos la session del navegador
        int x=Integer.parseInt(request.getParameter("cont"));   // recuperamos el parametro de cont y lo transformamos en entero y lo guardamos en x
        int aciertos=1,preguntas=x;   // variables necesarias para mandarse como parametros


        session.setAttribute("id", id);   //  subimos a session el id
        //session.setAttribute("cont", x);  // subimos a session el contador

        String rutaAbsoluta = request.getSession().getServletContext().getRealPath("/");  //primero obtenemos la session y hacemos comunicacion con el registro de servlets y esa ruta la transforma a una ruta del S.O.
        rutaAbsoluta = rutaAbsoluta.replace("\\", "/");  // reemplaza los caracteres \\ por /
        rutaAbsoluta = rutaAbsoluta.replaceAll("/build", "");   
        rutaAbsoluta = rutaAbsoluta + "/examen" + id + ".xml";  // a la ruta anterior le anexamos el id para que sepa que xml es 

        //aquí ya se manda a imprimir lo que la página 
        out.println("<!DOCTYPE html>");   // definimos el documento html
        out.println("<html>");  // abrimos la etiqueta de html
        out.println("<head>");  // abrimos la etiqueta del encabezado de html
        out.println("<title>dinamica</title>");  //  el titulo de la lagina en el url relativo
        out.println("<link type='text/css' rel='stylesheet' href='http://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/hot-sneaks/jquery-ui.css' />");  // establecemos que usamos un tema de hot-sneaks para css en jquery
        out.println("<link rel='stylesheet' type='text/css' href='https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css'/>"); // hacemos uso de jquery par las tablas
        out.println("<link rel='stylesheet' href='fondoYletra.css'>");   // establecemos cual es el fondo de la pagina
        out.println("<style>");  // abrimos la etiqueta donde daremos estilo la la pagina
        out.println("#preguntas{");   // a las preguntas les daremos el siguiente estilo
        out.println("  padding-left: 20px;");
        out.println("  padding-right: 0px;");
        out.println("  }");
        out.println(".hotobject{");   // determinamos el estilo para el hotObject
        out.println("  padding: 50px;");
        out.println("  margin: 10px;");
        out.println("  }");
        out.println("</style>");   // cerramo la etiqueta de estilo
        out.println("</head>");   // cerramo la etiueta del encabezado
        out.println("<body>");    // abrimo etiqueta del cuerpo de la pagina
        out.println("<div id= 'main'>");   //  abrimos etiqueta div para el main

        try {   // generamos un try para este codigo que es propenso a tener fallas
            SAXBuilder builder = new SAXBuilder();    // creamos un onjeto que haga conexion xonlos archivos xml
            //File archivoXML = new File(url);
            Document documento = builder.build(rutaAbsoluta);    // creamos un documento que tendra la ruta del xml
            Element raiz = documento.getRootElement();  // recuperamos la etiueta raiz del xml
            List lista = raiz.getChildren("pregunta");  // obtenemos la etiqueta hija que se llama pregunta del la etiqueta raiza del xml
            Element[] elemento = new Element[lista.size()];  // creamos un arreglo del tamaño de las etiquetas de pregunta

            for (int j = 0; j < lista.size(); j++) {
                elemento[j] = (Element) lista.get(j);   // guardamos las etiquetas en un arreglo  
                
            }
            preguntas=lista.size();
            //session.setAttribute("count", lista.size());

        String rutaPregunta = request.getSession().getServletContext().getRealPath("/");  //primero obtenemos la session y hacemos comunicacion con el registro de servlets y esa ruta la transforma a una ruta del S.O.
        rutaPregunta = rutaPregunta.replace("\\", "/");  // reemplazamos todos los caracteres \\ por /
        rutaPregunta = rutaPregunta.replaceAll("/build", "");
        rutaPregunta = "file:/"+rutaPregunta+elemento[x].getText();   // a la ruta generada le concatenamos el texto que contiene la etiqueta pregunta
        //out.println(rutaPregunta);
             
                
            Document documento1 = builder.build(rutaPregunta); // creamos otro documento y le asignamos la ruta donde se almacena las preguntas
            Element raizP = documento1.getRootElement();  // las preguntas seran la etiqueta raiz ya que este es xml de preguntas
            List lista1 = raizP.getChildren("opcion");    // obtenemos la etiqueta hija que se llama opciones 
            Element[] elementoP =new Element[lista1.size()];  // creamos un arreglo del tamaño de las opciones del xml
            
            for(int j=0; j<lista1.size();j++){
                elementoP[j]=(Element) lista1.get(j);   // guardamos las opciones en una arreglo
               
            }
            
            
            
            if (elemento[x].getText().startsWith("preguntaH") == true) {   // checamos si el texto de la etique de examen empieza con preguntaH
                out.println("<h2 class='demoHeaders'>Hot Object</h2>");          //  cramos la vista de hot object con una clase
                out.println("<h1>" + raizP.getAttribute("texto").getValue() + "</h1>");  // obtenemos el atributo de la session y y su valor y lo metemos en la etiqueta h1 
                out.println("<div style='text-align:center; padding:20px;'>");   // creamos una devision de la pagina y lo alineamos al centro 
                out.println("<br>");  // salnto de linea

                for (int i = 0; i < lista1.size(); i++) {  // recorremos el arreglo de opciones
                    String nombre = elementoP[i].getText();    // obtemenos el texto de elemento y lo guardamos en nombre 
                    String multimedia = elementoP[i].getAttribute("multimedia").getValue();  // obetemenos el valor del atributo de multimedia y lo metemos en una cadena 
                    if (multimedia.equals("")) { // checamos si la cadena esta vacia
                        out.println("<label for='" + nombre + "' class='hotobject'>" + nombre + "</label>");  
                        out.println("<input class='che' type='checkbox' name='" + nombre + "' id='" + nombre + "'>"); //  creamos un checkbox con el nomre recuperado
                    } else {  // si si tiene multimedia 
                        out.println("<label>");
                        out.println("                <input type='checkbox' name='radio0' class='radio'>");
                        out.println("                <img src='"+multimedia+"' width='150' height='150' class='image'/>");  // muestra el multimedia que se haya recuperado
                        out.println("</label>");

                    }

                }

                out.println("</div>");   // cerramos la etiueta de div

                out.println("<br>");    // saltos de linea
                out.println("<br>");

            }

            if (elemento[x].getText().startsWith("preguntaM") == true)  {          // si la etiqueta comienza con preguntaM para Muñtiple choise
                out.println("<h2 class=preguntas'>Multiple Choice</h2>");    //   escribimos multiple choise

                out.println("<h1>" + raizP.getAttribute("texto").getValue() + "</h1>");    // obtenemos el atributo de la session y y su valor y lo metemos en la etiqueta h1
                out.println("<div id='preguntas'>");  // abrimos etiquea diva para poner las preguntas
                out.println("<br>");   // salto de linea

                if (!raiz.getAttribute("multimedia").getValue().equals("no")) {    //  checa si la raiz tiene multimedia
                    String tipoArchivo = raizP.getAttribute("multimedia").getValue();   // guarda en una cadena el nombre del archivo multimedia
                    String[] arrayTipoArchivo = tipoArchivo.split("\\.");   // creamos un arreglo para almacenar el tipo de archivo multimedia

                    if (arrayTipoArchivo[1].equals("jpg") || arrayTipoArchivo[1].equals("png") || arrayTipoArchivo[1].equals("gif") || arrayTipoArchivo[1].equals("svg")) { // checamos si el archivo es de un tipo de formato
                        out.println("<img src='" + tipoArchivo + "' width='300' height='150' align='right'>");  // mostramos la imagen alineada a la derecha
                    } else if (arrayTipoArchivo[1].equals("mp3") || arrayTipoArchivo[1].equals("ogg")) { // checa si el archivo es de audio
                        out.println("<div align='center' style='margin-bottom:20px;'> ");  // definimos el estilo para mostrar el audio
                        out.println("<audio controls> ");   // abre etiueta de audio
                        out.println("  <source src='" + tipoArchivo + "'>");
                        out.println("  Tu navegador no soporta el elemento <code>audio</code>.  ");  // si el navegador no puede poner audios muestra esto
                        out.println("</audio>");  // cierra etiueta de audio
                        out.println("</div> ");  // cierra etiqueta de div
                    } else {
                        out.println("<div align='center' style='margin-bottom:20px;'> ");  // abre etiqueta de div
                        out.println("<video src='" + tipoArchivo + "' width='300' height='150'  controls></video>");   //  muestra el video 
                        out.println("</div> ");  // cierra etiqueta de div
                    }
                }
                for (int i = 0; i < lista.size(); i++) {        // recorremos el arreglo
                    String nombre = elementoP[i].getText();  // obtenemos el texto de las etiquetas del xml
                    out.println("<label for='" + nombre + "'>" + nombre + "</label>");
                    out.println("<input type='checkbox' name='" + nombre + "' id='" + nombre + "'>");  // ponemos checkbox junto con el texto del xml
                    out.println("<br><br>"); 
                }

                
                
                out.println("</div>");

                out.println("<br>");
                out.println("<br>");

            }

        } catch (JDOMException e) {  // cachamos algun error generado por JDOM
            e.printStackTrace();
        } catch (IOException e) {   // cachamos un error generado por entradas y salidas
            e.printStackTrace();
        }
        out.println("<button id='dialog-link1' class='ui-button ui-corner-all ui-widget'>");                 // creamos boton de siguiente
        out.println("		<span class='ui-icon ui-icon-circle-arrow-e'></span> Siguiente");
        out.println("	</button>");
         out.println("<button id='dialog-link2' class='ui-button ui-corner-all ui-widget'>");                // creamos boton de regresar
        out.println("		<span class='ui-icon ui-icon-circle-arrow-w'></span> Regresar");
        out.println("	</button>");
        out.println("<button id='dialog-link3' class='ui-button ui-corner-all ui-widget'>");                  // creamos boton para ir a la calificacion del examen
        out.println("		<span class='ui-icon ui-icon-calculator'></span>Calificacion del Examen");
        out.println("	</button>");
        
        
        out.println("</div>");
        out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>");
        out.println("<script type='text/javascript' src='https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js'></script>");  // llamamos a las tablas de jquery para css
        out.println("<script src='http://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js'></script>");   // llama la api por medio de google para su uso
        out.println("<script>");
        out.println("$('input[type=checkbox]').checkboxradio();");  // creamos un checkbox
        out.println("$( '#dialog-link1' ).click(function URL(){");   // cuando se de click en el boton realizara lo siguiente
        if(request.getParameter("vista").compareTo("alumno")==0){   // checa de donde viene la vista en este caso viene de alumno
            out.println("	document.location.href = 'RealizarExamen?id="+id+"&cont="+(x+1)+"&vista=alumno&preguntas="+preguntas+" '; ");  // al dar click en el boton llevara a refrescar la pagina con los parametros indicados
            out.println("});");
        }
            
            
            out.println("$( '#dialog-link3' ).click(function URL(){");
           out.println("	document.location.href = 'Calificacion?id="+id+"&aciertos="+aciertos+"&preguntas="+preguntas+"'; ");  // llevara a ver la calificacion del examen
            out.println("});"); 
        
        
        
        
        
        
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
