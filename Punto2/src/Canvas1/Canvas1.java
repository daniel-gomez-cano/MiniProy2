package Canvas1;
import javax.swing.JFrame;

import java.awt.Container;
import java.awt.Graphics;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Canvas1 extends JFrame implements MouseListener{

    Container contenedor;
    int Ex = 0;
    int Ey = 0;
    int Sx = 0;
    int Sy = 0;

    public Canvas1(){
        contenedor = getContentPane();

        addMouseListener(this);

        setSize(500,300);
        setTitle("INTERFACES 2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void paint(Graphics g){
        if(!(Ex == 0 || Ey == 0 || Sx == 0 || Sy ==0 )){
            g.drawLine(Ex, Ey, Sx, Sy);
        }
    }
    
    

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseEntered'");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Ex = e.getX();
        Ey = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Sx = e.getX();
        Sy = e.getY();
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseEntered'");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseExited'");
    }
}