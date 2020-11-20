package Paquete;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
            String filas1 = request.getParameter("filas");
            String columnas1 = request.getParameter("columnas");
            int filasint = Integer.parseInt(filas1);
            int columnasint = Integer.parseInt(columnas1);
            int contador = 0;
            String [][] arreglo = new String[filasint][columnasint];
            PrintWriter out = response.getWriter();
            out.println("<DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> Servlet Servlet 1</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<table border = '1'>");
             for(int i=0;i<arreglo.length;i++){
                out.println("<tr>");
                for(int j=0;j<arreglo[i].length;j++){
                    contador = contador + 1;
                    arreglo[i][j] = request.getParameter("palabra"+contador);
                    out.println("<td>"+arreglo[i][j]+"</td>");
                }
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
    }
}