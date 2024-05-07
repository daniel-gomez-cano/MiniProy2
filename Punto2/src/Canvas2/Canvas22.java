package Canvas2;

import javax.swing.JFrame;


import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

 
public class Canvas22 extends JFrame implements MouseListener{

    Container contenedor;
    ArrayList<Integer> vectorX = new ArrayList<>();
    ArrayList<Integer> vectorY = new ArrayList<>();
    int nodos = 0;
    

    public Canvas22(){
        contenedor = getContentPane();
        addMouseListener(this);

        setSize(500,300);
        setTitle("Canvas 3");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void paint(Graphics g){
        for(int i = 0; i < (nodos-1);i++){
            g.drawLine(vectorX.get(i), vectorY.get(i),vectorX.get(i+1), vectorY.get(i+1));
        }

    }





    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
    }
    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        vectorX.add(x);
        int y = e.getY();
        vectorY.add(y);
        nodos++;
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
    }
}
