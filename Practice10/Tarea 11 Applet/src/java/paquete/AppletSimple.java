package paquete;

import java.applet.Applet;
import java.awt.Graphics;

public class AppletSimple extends Applet{
    @Override
    public void paint(Graphics g){
        g.drawString("Hola Mundo en Java", 50, 25);
    }
}