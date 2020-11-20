package Paquete;

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
            String filas1 = request.getParameter("filas");
            String columnas1 = request.getParameter("columnas");
            int contador = 0;
            int filasint = Integer.parseInt(filas1);
            int columnasint = Integer.parseInt(columnas1);
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet1</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<form action = 'Servlet2' method = 'get'>");
            for(int i=0;i<filasint;i++){
                for(int j=0;j<columnasint;j++){
                    contador = contador + 1;
                    out.println("Campo "+(i+1)+(j+1)+":");
                    out.println("<input type = 'text' name = 'palabra"+contador+"'/>");
                    out.println("<br/>");
                }
            }
            out.println("<input type='text' name='filas' value='"+filas1+"' style='display:none'/>");out.println("<br/>");
            out.println("<input type='text' name='columnas' value='"+columnas1+"'style='display:none'/>");
            out.println("<input type = 'submit'/>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>"); 
    }
}