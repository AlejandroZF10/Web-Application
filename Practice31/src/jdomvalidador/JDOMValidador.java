package jdomvalidador;

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
            
    public static void main(String[] args) {
        if(args.length==0){//VERIFICA QUE SE ESTE RECIBIENDO UN DOCUMENTO
            System.out.println("Utilizacion: java JDOMValidador URL");
        }else{
            JDOMValidador validador=new JDOMValidador();
            try{
                try{
                    //DOCUMENTO CONFORME??
                    validador.checkConforme(args[0]);
                }catch(JDOMException e){
                    System.out.println(args[0]+" No esta bien conformado");
                    System.out.println(e.getMessage());
                    System.exit(0);
                }
                //SI EL FICHERO ESTA BIEN COONFORMADO, SIN ERRORES
                System.out.println(args[0]+" Esta bien conformado");
                try{
                    //DOCUMENTO VALIDO??
                    validador.checkValido(args[0]);
                }catch(JDOMException e){
                    //INDICACION DE UN FICHERO NO VALIDO
                    System.out.println(args[0]+" NO es valido");
                    System.out.println(e.getMessage());
                    System.exit(0);
                }
                //SI EL FICHERO ES VALIDO
                System.out.println(args[0]+" ES valido");
            }catch(IOException e){
                //INDICACION DE QUE EL FICHERO NO ES ACCESIBLE
                System.out.println("NO se puede chequear "+args[0]);
                System.out.println("porque: "+e.getMessage());
            }
        }
        
    }
    
}
