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
            String audio1 = request.getParameter("audio");
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet1</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<audio controls autoplay>");
            out.println("<source src = "+audio1+".mp3 type = audio/mp3>");
            out.println("I'm sorry, your browser doesn´t support this audio");
            out.println("</audio>");
            out.println("</body>");
            out.println("</html>");
        }
    }