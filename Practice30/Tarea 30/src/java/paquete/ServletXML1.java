package paquete;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;


public class ServletXML1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    try{
        Element raiz = new Element("ROOT");//nombre del elemento
        Element hoja = new Element("hoja");//nombre del elemento
        hoja.setAttribute("numerodehojas","4");//nombre y valor del atributo
        hoja.setText("VALORDELNODO");//valor del nodo entre etiqueta de apertura y etiqueta de cierre
        raiz.addContent(hoja);//anidamos jerarquicamente la hoja a la raiz
        
        Document newdoc = new Document(raiz);//generamos un documento con esa estructura en memoria
        XMLOutputter fmt = new XMLOutputter();
        FileWriter writer = new FileWriter("/Users/Alejandro ZF10/Desktop/Proyecto web/Tareas/31/pregunta2.xml");
        fmt.output(newdoc,writer);
        
        writer.flush();
        writer.close();
    }catch(Exception e){
        e.printStackTrace();
    }
    }
}

