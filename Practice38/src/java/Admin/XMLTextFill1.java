package Admin;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.jdom.JDOMException;


public class XMLTextFill1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession sesion = request.getSession();
        String[] user = (String [])sesion.getAttribute("id"); 
        String ruta = request.getServletContext().getRealPath("/")+user[0]+".xml";
        ruta = ruta.replace("\\", "/"); 
        ruta = ruta.replaceAll("/build", "");
        boolean flag = true; String[] datos = new String[6];
        datos[0] = request.getParameter("Q1"); datos[1] = request.getParameter("Q2");
        datos[2] = request.getParameter("Q3"); datos[3] = request.getParameter("Q4");
        datos[4] = request.getParameter("Q5"); datos[5] = request.getParameter("T1");
        String sensitive = "";String exact = "";String [] state = new String[4];
        if(user[6].compareTo("Correct1")==0){
            state[0]="Correct";state[1]="Incorrect";state[2]="Incorrect";state[3]="Incorrect";
        }else{
            if(user[6].compareTo("Correct2")==0){
                state[1]="Correct";state[0]="Incorrect";state[2]="Incorrect";state[3]="Incorrect";
            }else{
                if(user[6].compareTo("Correct3")==0){
                    state[2]="Correct";state[0]="Incorrect";state[1]="Incorrect";state[3]="Incorrect";
                }else{
                    state[3]="Correct";state[0]="Incorrect";state[1]="Incorrect";state[2]="Incorrect";
                } 
            }
        }
        String texto = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<!DOCTYPE pregunta SYSTEM \"FillInBlank.dtd\">\n"
            +"<pregunta texto=\""+user[1]+"\" intentos=\""+datos[5]+"\" tipo=\"texto\">\n"
            +"<opcion estado=\""+state[0]+"\">"+user[2]+"</opcion>\n<opcion estado=\""+state[1]+"\">"+user[3]+"</opcion>\n"
            +"<opcion estado=\""+state[2]+"\">"+user[4]+"</opcion>\n<opcion estado=\""+state[3]+"\">"+user[5]+"</opcion>\n"
            +"</pregunta>";
        try{
            File archivo = new File(ruta);
            try (FileWriter escritura = new FileWriter(archivo)) {
                escritura.write(texto);
            }
        }catch(IOException e){
            out.println("Error al guardar el archivo");
        }
        JDOMValidador validador = new JDOMValidador();
        try{
            try{
                validador.checkConforme(ruta);
            }catch(JDOMException e){
                flag = false;
            }
            if(flag){
                response.sendRedirect("Administrador");
            }
        }catch(IOException e){
           response.sendRedirect("FillInBlankText");
        }
    }
}
