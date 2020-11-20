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
        String seleccion = request.getParameter("seleccion");
        
        PrintWriter out = response.getWriter();
            if(seleccion.equals("fizquierdo"))
            {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Hola Mundo</title>");            
                out.println("</head>");
                out.println("<frameset cols=\"80,*\" frameborder=\"yes\" border=\"2\" framespacing=\"0\">");
                out.println("<frame src=\"paginaizquierda.html\"/>");
                out.println("<frame src=\"paginaderecha.html\"/>");
                out.println("<frameset/>");
                out.println("<noframes>");
                out.println("<body>");
                out.println("</body>");
                out.println("</noframes>");
                out.println("</html>");
            }
            if(seleccion.equals("fderecho"))
            {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Frames</title>");
                out.println("</head>");
                out.println("<frameset cols=\"*,80\" frameborder=\"yes\" border=\"2\" framespacing=\"0\">");
                out.println("<frame src=\"paginaizquierda.html\"/>");
                out.println("<frame src=\"paginaderecha.html\"/>");
                out.println("<frameset/>");
                out.println("<noframes>");
                out.println("<noframes>");
                out.println("<body>");
                out.println("</body>");
                out.println("</noframes>");
                out.println("</html>");
            }
            if(seleccion.equals("farriba"))
            {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Frames</title>");
                out.println("</head>");
                out.println("<frameset rows='80,*' frameborder='yes' border='1' framespacing='0'>");
                out.println("<frame src='paginaarriba.html' />");
                out.println("<frame src='paginaabajo.html' />");
                out.println("</frameset>");
                out.println("<noframes>");
                out.println("<body>");
                out.println("</body>");
                out.println("</noframes>");
                out.println("</html>");
            }
            if(seleccion.equals("fabajo"))
            {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Frames</title>");
                out.println("</head>");
                out.println("<frameset rows='*,80' frameborder='yes' border='1' framespacing='0'>");
                out.println("<frame src='paginaarriba.html' />");
                out.println("<frame src='paginaabajo.html' />");
                out.println("</frameset>");
                out.println("<noframes>");
                out.println("<body>");
                out.println("</body>");
                out.println("</noframes>");
                out.println("</html>");
            }
            if(seleccion.equals("faderecho"))
            {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Frames</title>");
                out.println("</head>");
                out.println("<frameset rows='*,80' cols='*' frameborder='yes' border='1' framespacing='0'>");
                out.println("<frameset cols='80,*' frameborder='yes' border='1' framespacing='0'>");
                out.println("<frame src='paginaizquierda.html' name='leftFrame' scrolling='no' noresize='noresize' id='leftFrame' title='leftFrame' />");
                out.println("<frame src='paginaderecha.html' name='mainFrame' id='mainFrame' title='mainFrame' />");
                out.println("</frameset>");
                out.println("<frame src='paginaabajo.html' name='bottomFrame' scrolling='no' noresize='noresize' id='bottomFrame' title='bottomFrame' />");
                out.println("</frameset>");
                out.println("<noframes>");
                out.println("<body>");
                out.println("</body>");
                out.println("</noframes>");
                out.println("</html>");
            }
            if(seleccion.equals("faizquierdo"))
            {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Frames</title>");
                out.println("</head>");
                out.println("<frameset rows='*,80' cols='*' frameborder='yes' border='1' framespacing='0'>");
                out.println("<frameset cols='*,80' frameborder='yes' border='1' framespacing='0'>");
                out.println("<frame src='paginaizquierda.html' name='leftFrame' scrolling='no' noresize='noresize' id='leftFrame' title='leftFrame' />");
                out.println("<frame src='paginaderecha.html' name='mainFrame' id='mainFrame' title='mainFrame' />");
                out.println("</frameset>");
                out.println("<frame src='paginaabajo.html' name='bottomFrame' scrolling='no' noresize='noresize' id='bottomFrame' title='bottomFrame' />");
                out.println("</frameset>");
                out.println("<noframes>");
                out.println("<body>");
                out.println("</body>");
                out.println("</noframes>");
                out.println("</html>");
            }
            if(seleccion.equals("fanidadosup"))
            {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Frames</title>");
                out.println("</head>");
                out.println("<frameset rows='*' cols='80,*' frameborder='yes' border='1' framespacing='0'>");
                out.println("<frame src='paginaizquierda.html' name='leftFrame' scrolling='no' noresize='noresize' id='leftFrame' title='leftFrame' />");
                out.println("<frameset rows='80,*' frameborder='yes' border='1' framespacing='0'>");
                out.println("<frame src='paginaderecha.html' name='mainFrame' id='mainFrame' title='mainFrame' />");
                out.println("</frameset>");
                out.println("<frame src='paginaabajo.html' name='bottomFrame' scrolling='no' noresize='noresize' id='bottomFrame' title='bottomFrame' />");
                out.println("</frameset>");
                out.println("<noframes>");
                out.println("<body>");
                out.println("</body>");
                out.println("</noframes>");
                out.println("</html>");
            }
            if(seleccion.equals("fanidadoinf"))
            {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Frames</title>");
                out.println("</head>");
                out.println("<frameset rows='*' cols='80,*' frameborder='yes' border='1' framespacing='0'>");
                out.println("<frame src='paginaizquierda.html' name='leftFrame' scrolling='no' noresize='noresize' id='leftFrame' title='leftFrame' />");
                out.println("<frameset rows='*,80' frameborder='yes' border='1' framespacing='0'>");
                out.println("<frame src='paginaderecha.html' name='mainFrame' id='mainFrame' title='mainFrame' />");
                out.println("</frameset>");
                out.println("<frame src='paginaabajo.html' name='bottomFrame' scrolling='no' noresize='noresize' id='bottomFrame' title='bottomFrame' />");
                out.println("</frameset>");
                out.println("<noframes>");
                out.println("<body>");
                out.println("</body>");
                out.println("</noframes>");
                out.println("</html>");
            }
            if(seleccion.equals("izqanisup"))
            {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Frames</title>");
                out.println("</head>");
                out.println("<frameset cols='*,80' frameborder='yes' border='1' framespacing='0'>");
                out.println("<frameset rows='*,80' frameborder='yes' border='1' framespacing='0'>");
                out.println("<frame src='paginaizquierda.html' name='leftFrame' scrolling='no' noresize='noresize' id='leftFrame' title='leftFrame' />");
                out.println("<frame src='paginaderecha.html' name='mainFrame' id='mainFrame' title='mainFrame' />");
                out.println("</frameset>");
                out.println("<frame src='paginaabajo.html' name='bottomFrame' scrolling='no' noresize='noresize' id='bottomFrame' title='bottomFrame' />");
                out.println("</frameset>");
                out.println("<noframes>");
                out.println("<body>");
                out.println("</body>");
                out.println("</noframes>");
                out.println("</html>");
                
            }
            if(seleccion.equals("izqaniinf"))
            {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Frames</title>");
                out.println("</head>");
                out.println("<frameset rows='*' cols='80,*' frameborder='yes' border='1' framespacing='0'>");
                out.println("<frame src='paginaizquierda.html' name='leftFrame' scrolling='no' noresize='noresize' id='leftFrame' title='leftFrame' />");
                out.println("<frameset rows='*,80' frameborder='yes' border='1' framespacing='0'>");
                out.println("<frame src='paginaderecha.html' name='mainFrame' id='mainFrame' title='mainFrame' />");
                out.println("</frameset>");
                out.println("<frame src='paginaabajo.html' name='bottomFrame' scrolling='no' noresize='noresize' id='bottomFrame' title='bottomFrame' />");
                out.println("</frameset>");
                out.println("<noframes>");
                out.println("<body>");
                out.println("</body>");
                out.println("</noframes>");
                out.println("</html>");
                
            }
            if(seleccion.equals("dereaniinf"))
            {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Frames</title>");
                out.println("</head>");
                out.println("<frameset  cols='80,*' frameborder='yes' border='1' framespacing='0'>");
                out.println("<frameset rows='*,80' frameborder='yes' border='1' framespacing='0'>");
                out.println("<frame src='paginaizquierda.html' name='leftFrame' scrolling='no' noresize='noresize' id='leftFrame' title='leftFrame' />");
                out.println("<frame src='paginaabajo.html' name='mainFrame' id='mainFrame' title='mainFrame' />");
                out.println("</frameset>");
                out.println("<frame src='paginaderecha.html' name='bottomFrame' scrolling='no' noresize='noresize' id='bottomFrame' title='bottomFrame' />");
                out.println("</frameset>");
                out.println("<noframes>");
                out.println("<body>");
                out.println("</body>");
                out.println("</noframes>");
                out.println("</html>");
            }
            if(seleccion.equals("dereanisup"))
            {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Frames</title>");
                out.println("</head>");
                out.println("<frameset cols='*,80' frameborder='yes' border='1' framespacing='0'>");
                out.println("<frameset rows='80,*' frameborder='yes' border='1' framespacing='0'>");
                out.println("<frame src='paginaarriba.html' name='leftFrame' scrolling='no' noresize='noresize' id='leftFrame' title='leftFrame' />");
                out.println("<frame src='paginaabajo.html' name='mainFrame' id='mainFrame' title='mainFrame' />");
                out.println("</frameset>");
                out.println("<frame src='paginaderecha.html' name='bottomFrame' scrolling='no' noresize='noresize' id='bottomFrame' title='bottomFrame' />");
                out.println("</frameset>");
                out.println("<noframes>");
                out.println("<body>");
                out.println("</body>");
                out.println("</noframes>");
                out.println("</html>");
            }
            if(seleccion.equals("supeinf"))
            {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Frames</title>");
                out.println("</head>");
                out.println("<frameset  rows='80,*,80' frameborder='yes' border='1' framespacing='0'>");
                out.println("<frame src='paginaizquierda.html' name='leftFrame' scrolling='no' noresize='noresize' id='leftFrame' title='leftFrame' />");
                out.println("<frame src='paginaabajo.html' name='mainFrame' id='mainFrame' title='mainFrame' />");
                out.println("<frame src='paginaderecha.html' name='bottomFrame' scrolling='no' noresize='noresize' id='bottomFrame' title='bottomFrame' />");
                out.println("</frameset>");
                out.println("<noframes>");
                out.println("<body>");
                out.println("</body>");
                out.println("</noframes>");
                out.println("</html>");
            }
            if(seleccion.equals("supaniizq"))
            {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Frames</title>");
                out.println("</head>");
                out.println("<frameset rows='80,*' cols='*' frameborder='no' border='0' framespacing='0'>");
                out.println("<frame src='paginaarriba' name='topFrame' scrolling='no' noresize='noresize' id='topFrame' title='topFrame' />");
                out.println("<frameset cols='80,*' frameborder='no' border='0' framespacing='0'>");
                out.println("<frame src='paginaizquierda.html' scrolling='no' noresize='noresize' id='leftFrame' title='leftFrame' />");
                out.println("<frame src='pagniaabajo.html' name='mainFrame' id='mainFrame' title='mainFrame' />");
                out.println("</frameset>");
                out.println("</frameset>");
                out.println("<noframes>");
                out.println("<body>");
                out.println("</body>");
                out.println("</noframes>");
                out.println("</html>");
            }
            if(seleccion.equals("supanider"))
            {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Frames</title>");
                out.println("</head>");
                out.println("<frameset rows='80,*' cols='*' frameborder='no' border='0' framespacing='0'>");
                out.println("<frame src='paginaarriba' name='topFrame' scrolling='no' noresize='noresize' id='topFrame' title='topFrame' />");
                out.println("<frameset cols='*,80' frameborder='no' border='0' framespacing='0'>");
                out.println("<frame src='paginaabajo.html' scrolling='no' noresize='noresize' id='leftFrame' title='leftFrame' />");
                out.println("<frame src='pagniaderecha.html' name='mainFrame' id='mainFrame' title='mainFrame' />");
                out.println("</frameset>");
                out.println("</frameset>");
                out.println("<noframes>");
                out.println("<body>");
                out.println("</body>");
                out.println("</noframes>");
                out.println("</html>");
            }
    }

}
