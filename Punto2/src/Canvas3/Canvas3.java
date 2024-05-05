package Canvas3;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class Canvas3 extends JFrame implements MouseListener{

    Container contenedor;
    int Ex = 0;
    int Ey = 0;
    int Sx = 0;
    int Sy = 0;
    int set1, set2, set3;

    public Canvas3(){
        contenedor = getContentPane();

        addMouseListener(this);

        setSize(500,300);
        setTitle("INTERFACES 2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void paint(Graphics g){
        if(!(Ex == 0 || Ey == 0 || Sx == 0 || Sy ==0 )){
            setRandomColor();
            g.setColor(new Color(set1, set2, set3));
            g.drawLine(Ex, Ey, Sx, Sy);
        }
    }
    
    public void setRandomColor(){
        Random random = new Random();
        set1 = random.nextInt(256);
        set2 = random.nextInt(256);
        set3 = random.nextInt(256);
        System.out.println(set1 + "----" + set2 + "----" + set3);
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