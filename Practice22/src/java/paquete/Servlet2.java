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
            out.println("<canvas id=\"myCanvas\" width=\"1000\" height=\"1000\" style=\"border:1px solid #d3d3d3;\">\n" +
                        "Your browser does not support the HTML5 canvas tag.</canvas>");
            out.println("<script>");
            out.println("var canvas = document.getElementById(\"myCanvas\");");
            out.println("var context = canvas.getContext(\"2d\");");
            for(int i=0;i<numeroLineasi;i++){
                out.println("context.beginPath();");
                out.println("context.arc("+request.getParameter("xi_"+i)+","+request.getParameter("yi_"+i)+","+request.getParameter("ri_"+i)+",0,"+(2*Math.PI)+");");         
                out.println("context.stroke();");
            }
            out.println("</script>");
            out.println("</body>");
            out.println("</html>");
    }
}




    
      
      

      
      
    