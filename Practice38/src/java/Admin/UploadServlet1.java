package Admin;

import java.io.*;
import java.util.*;
import javax.servlet.ServletContext;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadServlet1 extends HttpServlet {
   
   private boolean isMultipart;
   private String filePath;
   private int maxFileSize = 50*1024*1024;
   private int maxMemSize = 4 * 1024;
   private File file ;

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, java.io.IOException {
        // Check that we have a file upload request
        //filePath = request.getRealPath("/"); 
        ServletContext application = this.getServletContext();
        filePath = application.getRealPath("/");
        isMultipart = ServletFileUpload.isMultipartContent(request);
        response.setContentType("text/html");
        java.io.PrintWriter out = response.getWriter( );
      
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Administrador</title>");
        out.println("<link rel=\"stylesheet\" href=\"https://unpkg.com/material-components-web@latest/dist/material-components-web.min.css\">");
        out.println("</head>");
        out.println("<style>");
        //Body
        out.println("body{align-items:center;text-align:center;background:url('Fondo-Login.jpg') no-repeat;");
        out.println("background-attachment:scroll;-webkit-background-size:cover;-moz-background-size:cover;");
        out.println("-o-background-size:cover;background-size:cover;width:100%;display:table;text-align:center;}");
        //Divisor
        out.println(".divisor{width:35%;position:relative;margin:2%auto;border-style:solid;border-radius:10px;");
        out.println("padding:10px 40px 10px 40px;background-color:#eaeded;display:inline-block;}");
        //Fuente
        out.println(".fuente{font-family:Gill Sans,Gill Sans MT,Myriad Pro,DejaVu Sans Condensed,Helvetica,Arial,sans-serif;}");
        out.println("</style>");
        out.println("<body>");
        out.println("<div class='divisor' >");
        if( !isMultipart ) {
            out.println("<h1 class='fuente' align='left'>Error al intentar subir el archivo</h1>");
            response.sendRedirect("FillInBlankAudio");
        }
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // maximum size that will be stored in memory
        factory.setSizeThreshold(maxMemSize);
        // Location to save data that is larger than maxMemSize.
        factory.setRepository(new File(filePath));
        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);
        // maximum file size to be uploaded.
        upload.setSizeMax( maxFileSize );

        try { 
            // Parse the request to get file items.
            List fileItems = upload.parseRequest(request);

            // Process the uploaded file items
            Iterator i = fileItems.iterator();
            while ( i.hasNext () ) {
                FileItem fi = (FileItem)i.next();
                if ( !fi.isFormField () ) {
                    // Get the uploaded file parameters
                    String fieldName = fi.getFieldName();
                    String fileName = fi.getName();
                    String contentType = fi.getContentType();
                    boolean isInMemory = fi.isInMemory();
                    long sizeInBytes = fi.getSize();

                    // Write the file
                    if( fileName.lastIndexOf("\\") >= 0 ) {
                       file = new File( filePath + fileName.substring( fileName.lastIndexOf("\\"))) ;
                    } else {
                       file = new File( filePath + fileName.substring(fileName.lastIndexOf("\\")+1)) ;
                    }
                    fi.write( file ) ;
                    File ruta = new File(filePath);
                    File[] archivo = ruta.listFiles();
                    HttpSession session1 = request.getSession();
                    session1.setAttribute("fileName",fileName);
                    HttpSession session2 = request.getSession();
                    session2.setAttribute("fileName2",filePath);
                    if (fileName.endsWith(".jpg")||fileName.endsWith(".jpeg")||fileName.endsWith(".png")){
                        response.sendRedirect("FillInBlankImage2");
                    }else{
                        if (fileName.endsWith(".mp4")){
                            response.sendRedirect("FillInBlankVideo2");
                        }else{
                            if (fileName.endsWith(".mp3")){
                                response.sendRedirect("FillInBlankAudio2");
                            }
                        }
                    }
                }
            }
            out.println("</body>");
            out.println("</html>");
            } catch(Exception ex) {
                System.out.println(ex);
            }
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
}