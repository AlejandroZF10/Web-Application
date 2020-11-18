package paquete;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8"); 
        PrintWriter out = response.getWriter(); 
        String texto = request.getParameter("texto");
        String tam = request.getParameter("tam");
        String seleccion = request.getParameter("Seleccion");
        
        if(seleccion.compareTo("negro")==0)
        {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> </title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("Texto normal : '"+ texto +"'<br/>");
            out.println("Texto modificado : <basefont size='"+ tam +"' color='#000000'>"+ texto);
            out.println("</body>");
            out.println("</html>"); 
        }
        if(seleccion.compareTo("plateado")==0)
        {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> </title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("Texto normal : '"+ texto +"'<br/>");
            out.println("Texto modificado : <basefont size='"+ tam +"' color='#C0C0C0'>"+ texto);
            out.println("</body>");
            out.println("</html>"); 
        } 
        if(seleccion.compareTo("gris")==0)
        {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> </title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("Texto normal : '"+ texto +"'<br/>");
            out.println("Texto modificado : <basefont size='"+ tam +"' color='#808080'>"+ texto);
            out.println("</body>");
            out.println("</html>"); 
        }
        if(seleccion.compareTo("blanco")==0)
        {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> </title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("Texto normal : '"+ texto +"'<br/>");
            out.println("Texto modificado : <basefont size='"+ tam +"' color='#FFFFFF'>"+ texto);
            out.println("</body>");
            out.println("</html>"); 
        }
        if(seleccion.compareTo("marron")==0)
        {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> </title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("Texto normal : '"+ texto +"'<br/>");
            out.println("Texto modificado : <basefont size='"+ tam +"' color='#800000'>"+ texto);
            out.println("</body>");
            out.println("</html>"); 
        }
        if(seleccion.compareTo("rojo")==0)
        {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> </title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("Texto normal : '"+ texto +"'<br/>");
            out.println("Texto modificado : <basefont size='"+ tam +"' color='#FF0000'>"+ texto);
            out.println("</body>");
            out.println("</html>"); 
        }
        if(seleccion.compareTo("purp")==0)
        {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> </title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("Texto normal : '"+ texto +"'<br/>");
            out.println("Texto modificado : <basefont size='"+ tam +"' color='#800080'>"+ texto);
            out.println("</body>");
            out.println("</html>"); 
        }
        if(seleccion.compareTo("fuc")==0)
        {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> </title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("Texto normal : '"+ texto +"'<br/>");
            out.println("Texto modificado : <basefont size='"+ tam +"' color='#FF00FF'>"+ texto);
            out.println("</body>");
            out.println("</html>"); 
        }
        if(seleccion.compareTo("verde")==0)
        {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> </title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("Texto normal : '"+ texto +"'<br/>");
            out.println("Texto modificado : <basefont size='"+ tam +"' color='#008000'>"+ texto);
            out.println("</body>");
            out.println("</html>"); 
        }
        if(seleccion.compareTo("lima")==0)
        {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> </title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("Texto normal : '"+ texto +"'<br/>");
            out.println("Texto modificado : <basefont size='"+ tam +"' color='#00FF00'>"+ texto);
            out.println("</body>");
            out.println("</html>"); 
        }
        if(seleccion.compareTo("amar")==0)
        {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> </title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("Texto normal : '"+ texto +"'<br/>");
            out.println("Texto modificado : <basefont size='"+ tam +"' color='#FFFF00'>"+ texto);
            out.println("</body>");
            out.println("</html>"); 
        }
        if(seleccion.compareTo("azulMar")==0)
        {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> </title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("Texto normal : '"+ texto +"'<br/>");
            out.println("Texto modificado : <basefont size='"+ tam +"' color='#000080'>"+ texto);
            out.println("</body>");
            out.println("</html>"); 
        }
        if(seleccion.compareTo("azul")==0)
        {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> </title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("Texto normal : '"+ texto +"'<br/>");
            out.println("Texto modificado : <basefont size='"+ tam +"' color='#0000FF'>"+ texto);
            out.println("</body>");
            out.println("</html>"); 
        }
        if(seleccion.compareTo("azulVer")==0)
        {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> </title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("Texto normal : '"+ texto +"'<br/>");
            out.println("Texto modificado : <basefont size='"+ tam +"' color='#008080'>"+ texto);
            out.println("</body>");
            out.println("</html>"); 
        }
        if(seleccion.compareTo("celeste")==0)
        {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> </title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("Texto normal : '"+ texto +"'<br/>");
            out.println("Texto modificado : <basefont size='"+ tam +"' color='#00FFFF'>"+ texto);
            out.println("</body>");
            out.println("</html>"); 
        }
    }
}