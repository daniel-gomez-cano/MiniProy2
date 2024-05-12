package Canvas2;

import javax.swing.JFrame;


import java.awt.Container;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

 
public class Canvas2 extends JFrame implements MouseListener{

    Container contenedor;
    //Creacion de poligono a mostrar
    Polygon poligono_visible = new Polygon();

    //GUI
    public Canvas2(){
        contenedor = getContentPane();
        addMouseListener(this);

        setSize(500,300);
        setTitle("Poligono con puntos");
        setLocationRelativeTo(null);
    }

    //Metodo que pinta el canvas
    public void paint(Graphics g){
        //Primero limpia el canvas
        g.clearRect(0, 0, getWidth(), getHeight());
        //Luego pinta el poligono visible
        g.drawPolygon(poligono_visible);
    }





    @Override
    public void mouseClicked(MouseEvent e) {
        
    }
    @Override
    public void mousePressed(MouseEvent e) {
        //puntos donde se da click
        int x = e.getX();
        int y = e.getY();
        //se agregan al poligono
        poligono_visible.addPoint(x, y);
        repaint();
        
        
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
    }
    @Override
    public void mouseExited(MouseEvent e) {
        //reinicia el valor del poligono
        poligono_visible.reset();
        repaint();
    }
}
