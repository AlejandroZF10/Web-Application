package paquete;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletIntermedio extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String opcion = request.getParameter("opcion");
        
        final File carpeta = new File(request.getServletContext().getRealPath("/"));
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Datos</title>");
        out.println("</head>");
        out.println("<body>");
        if(opcion.compareTo("nuevo")==0){
            out.println("<form action='ServletCrear' method='post'>");
            out.println("<h1>Crear archivo</h1><div id='titulo'>Introduce un nombre de archivo, debes incluir la extension (xml, xsd, dtd)</div><br/>");
            out.println("<input type='text' name='nombre'/>");
            out.println("<input type='submit' value='Aceptar'/>");
            out.println("</form>");
        }
        
        if(opcion.compareTo("editar")==0){
            out.println("<form action='ServletEditar' method='post'>");
            out.println("<h1>Modificar archivo</h1><div id='titulo'>Elige el archivo que quieres modificar</div>");
            for (final File ficheroEntrada : carpeta.listFiles()) {
                if (ficheroEntrada.isDirectory()==false) {
                    if((ficheroEntrada.getName().contains(".xml")) || (ficheroEntrada.getName().contains(".xsd")) || (ficheroEntrada.getName().contains(".dtd"))){
                        out.println("<button class='button' name='archivo' type='submit' value='"+ficheroEntrada.getName()+"'>"+ficheroEntrada.getName()+"</button>");
                    }
                } 
            }
            out.println("</form>");
        }
        
        if(opcion.compareTo("borrar")==0){
            out.println("<form action='ServletBorrar' method='post'>");
            out.println("<div id='titulo'>Elige el archivo que quieres eliminar</div>");
            for (final File ficheroEntrada : carpeta.listFiles()) {
                if (ficheroEntrada.isDirectory()==false) {
                    if((ficheroEntrada.getName().contains(".xml")) || (ficheroEntrada.getName().contains(".xsd")) || (ficheroEntrada.getName().contains(".dtd"))){
                        out.println("<button class='button' name='archivo' type='submit' value='"+ficheroEntrada.getName()+"'>"+ficheroEntrada.getName()+"</button>");
                    }
                } 
            }
            out.println("</form>");
        }
        
        if(opcion.compareTo("subir")==0){
            out.println("<form action='ServletSubir' method='post' enctype='multipart/form-data'>");
            out.println("<div id='titulo'>Selecciona el archivo que deseas subir:</div><br/>");
            out.println("<input type='file' name='archivo'/><br/>");
            out.println("<input type='submit' value='Subir Archivo'/>");
            out.println("</form>");
        }
        out.println("</body>");
        out.println("</html>");
    }
}
