package paquete;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {  
            response.setContentType("text/html;charset=UTF-8");
            String p1 = request.getParameter("1");
            String p2 = request.getParameter("2");
            String p3 = request.getParameter("3");
            String p4 = request.getParameter("4");
            String p5 = request.getParameter("5");
            String p6 = request.getParameter("6");
            String p7 = request.getParameter("7");
            String p8 = request.getParameter("8");
                  
            PrintWriter out = response.getWriter();
            out.println("<DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> Modelo de cajas</title>");
            out.println("<style>");
                out.println(".centro ");
                out.println("{");
                out.println("display:inline-block;");
                out.println("width :"+p1+";");
                out.println("height :"+p2+";");
                out.println("background :"+p3+";");
                out.println("line-height :"+p4+";");
                out.println("border-style:solid;");
                out.println("border-color:"+p5+";");
                out.println("padding :"+p6+";");
                out.println("border-width:"+p7+";");
                out.println("margin :"+p8+";");
                out.println("}");
                out.println("body {line-height:0;}");
                out.println("img { vertical-align:top; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<img src='bordes.jpg'><img src='bordes.jpg'><img src='bordes.jpg'><br>");
            out.println("<img src='bordes.jpg'><div class='centro'>RUBEN</div><img src='bordes.jpg'><br>");
            out.println("<img src='bordes.jpg'><img src='bordes.jpg'><img src='bordes.jpg'>");
            out.println("</body>");
            out.println("</html>");
        }
}