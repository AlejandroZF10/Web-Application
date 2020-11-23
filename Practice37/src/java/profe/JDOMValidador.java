
package profe;

import java.io.IOException;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class JDOMValidador {
    
    public JDOMValidador(){
        
    }
    //Metodo que comprueba la conformidad con XML.
    public void checkConforme(String sURL)
    throws JDOMException, IOException{
        SAXBuilder builder = new SAXBuilder();
        builder.build(sURL);
    }
    
    //Metodo que comprueba la validez con el DTD.
    public void checkValido(String sURL)
    throws JDOMException, IOException{
        SAXBuilder builder = new SAXBuilder();
        builder.setValidation(true);
        builder.build(sURL);
    }
}
