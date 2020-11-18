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
            int x = 0, y = 0, z = 0;
            int numeros[]; numeros = new int[6];
            String parametros[]; parametros = new String[6];
            for(int i = 0; i<parametros.length ;i++){
                parametros[i] = request.getParameter("N"+(i+1));
                numeros[i] = Integer.parseInt(parametros[i]);
            }
            z  = ((numeros[0]*numeros[4])-(numeros[1]*numeros[3]));
            x = ((numeros[4]*numeros[2])-(numeros[1]*numeros[5]));
            y = ((numeros[0]*numeros[5])-(numeros[3]*numeros[2]));
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet1</title>");            
            out.println("</head>");
            out.println("<body>");
            if((x == 0 || y == 0) && z == 0){//Soluciones infinitas
                out.println("<h1>Sistema con soluciones infinitas</h1>");
                /*out.println("<h1>Solucion para x: "+x+"</h1>");
                out.println("<h1>Solucion para y: "+y+"</h1>");*/
            }
            else{
                if((x != 0 || y != 0) && z == 0){//Sistema indeterminado
                    out.println("<h1>Sistema sin solucion</h1>");
                    /*out.println("<h1>Solucion para x: "+x+"</h1>");
                    out.println("<h1>Solucion para y: "+y+"</h1>");*/
                }
                else{
                    x = x/z; y = y/z;
                    out.println("<h1>Solucion para x: "+x+"</h1>");
                    out.println("<h1>Solucion para y: "+y+"</h1>");                     
                }
            }
            out.println("</body>");
            out.println("</html>");
    }
}