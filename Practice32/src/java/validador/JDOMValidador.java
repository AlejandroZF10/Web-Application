package validador;

import java.io.IOException;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class JDOMValidador {
    
    //METODO QUE CHECA LA CONFORMIDAD CON XML
    public void checkConforme (String sURL) throws JDOMException, IOException {
            SAXBuilder builder = new SAXBuilder();
            builder.build(sURL);
        }
    
    //METODO QUE COMPRUEBA LA VALIDEZ CON UN DTD
    public void checkValido (String sURL) throws JDOMException, IOException{
        SAXBuilder builder = new SAXBuilder();
        builder.setValidation(true);
        builder.build(sURL);
    }
    
}
