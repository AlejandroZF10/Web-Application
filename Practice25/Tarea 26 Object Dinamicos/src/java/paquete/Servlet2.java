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
        
        HttpSession session=request.getSession();//recordar
        String objeto1=(String)session.getAttribute("ClavePdf");
        int PDFi = Integer.parseInt(objeto1);
        
        PrintWriter out = response.getWriter(); 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> </title>");            
            out.println("</head>");
            out.println("<body>");
            for(int i=0;i<PDFi;i++)
                {
                    out.println("<object data='"+request.getParameter("Datos"+i)+"' type=\"application/pdf\" width=\"800\" height=\"600\">     ");
                    out.println("</object>");
                }
            out.println("</body>");
            out.println("</html>");
    }
}