package Canvas2;

import javax.swing.JFrame;


import java.awt.Container;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

 
public class Canvas2 extends JFrame implements MouseListener{

    Container contenedor;
    
    Polygon poligono_visible = new Polygon();
    Polygon poligono_data = new Polygon();

    public Canvas2(){
        contenedor = getContentPane();
        addMouseListener(this);

        setSize(500,300);
        setTitle("Canvas 3");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void paint(Graphics g){
        g.clearRect(0, 0, getWidth(), getHeight());
        g.drawPolygon(poligono_visible);
    }





    @Override
    public void mouseClicked(MouseEvent e) {
        
    }
    @Override
    public void mousePressed(MouseEvent e) {
        
        int x = e.getX();
        int y = e.getY();
        poligono_data.addPoint(x, y);
        poligono_visible = poligono_data;
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
        poligono_visible.reset();
        repaint();

    }
}
