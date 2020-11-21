package paquete;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8"); 
        HttpSession session = request.getSession();
        String numeroLineas = (String)session.getAttribute("clavenumeroLineas");
        int numeroLineasi = Integer.parseInt(numeroLineas);
        PrintWriter out = response.getWriter(); 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Lineas a Dibujar</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<canvas id='myCanvas' width='1000' height='1000'></canvas>");
            /*
             * Definimos la dimensión de lo que vamos a dibujar
             */
            out.println("<script>");
            out.println("var canvas = document.getElementById('myCanvas');");
            /*
             * Declaramos la variable en Javascript, después mapeamos
             * Mapear es usar una variable de script a partir de html
             * el id documento objeto implícito de la página html
             */
            out.println("var context = canvas.getContext('2d');");
            for(int i=0;i<numeroLineasi;i++)
            {
                out.println("context.beginPath();");
                out.println("context.ellipse("+request.getParameter("xi_"+i)+", "+request.getParameter("yi_"+i)+", "+request.getParameter("r1_"+i)+", "+request.getParameter("r2_"+i)+", "+Double.parseDouble(request.getParameter("rot_"+i)) * Math.PI/180  +" , "+request.getParameter("a1_"+i)+", "+Double.parseDouble(request.getParameter("a2_"+i)) * Math.PI +");");
                out.println("context.stroke();");
                out.println("context.fillStyle='"+request.getParameter("Color_"+i)+"';");
                out.println("context.fill();");
            }
            out.println("</script>");
            out.println("</body>");
            out.println("</html>");
    }
}




    
      
      

      
      
    