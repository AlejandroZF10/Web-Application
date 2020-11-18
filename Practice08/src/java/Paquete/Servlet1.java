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
            float resultado1 = 0, resultado2, raiz;
            int numeros[] = new int[3];
            String parametros[] = new String[3];
            PrintWriter out = response.getWriter();
            for(int i = 0; i<parametros.length ;i++){
                parametros[i] = request.getParameter("N"+(i+1));
                numeros[i] = Integer.parseInt(parametros[i]);
            }
            raiz = ((numeros[1]*numeros[1])-(4*(numeros[0]*numeros[2])));
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet1</title>");            
            out.println("</head>");
            out.println("<body>");
            if(raiz<0)
                out.println("<h1>Ecuacion sin soluciones reales</h1>");
            else if(raiz == 0){
                resultado1 = (((numeros[1])*(-1)))/(2*numeros[0]);
                out.println("<h1>La solucion es X1 = X2 "+resultado1+"</h1>");
            }
                else{
                    resultado1 = (float)(((-numeros[1])+Math.sqrt(raiz))/(2*numeros[0]));
                    out.println("<h1>La solucion X1 = "+resultado1+"</h1>");
                    resultado1 = (float)(((-numeros[1])-Math.sqrt(raiz))/(2*numeros[0]));
                    out.println("<h1>La solucion X2 = "+resultado1+"</h1>");
                }
            out.println("</body>");
            out.println("</html>");
    }
}