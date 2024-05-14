package Canvas1;
import javax.swing.JFrame;

import java.awt.Container;
import java.awt.Graphics;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Canvas1 extends JFrame implements MouseListener{

    //Variables globales
    Container contenedor;
    int Ex = 0;  //posicion de entrada en x
    int Ey = 0;  //posicion de entrada en y
    int Sx = 0;  //posicion de salida en x
    int Sy = 0;  //posicion de salida en y

    boolean reinicio = false;

    //INTERFAZ GRAFICA
    public Canvas1(){
        contenedor = getContentPane();

        addMouseListener(this);

        setSize(500,300);
        setTitle("Pintar Lineas Negras");
        setLocationRelativeTo(null);
    }

    //medoto de pintado
    public void paint(Graphics g){
        //si los valores de entrada son diferentes de 0 pinta
        if(!(Ex == 0 || Ey == 0 || Sx == 0 || Sy ==0 )){
            g.drawLine(Ex, Ey, Sx, Sy);
        }
        //clear the interfaz
        if(reinicio){
            g.clearRect(0, 0, getWidth(), getHeight());
            reinicio = false;
        }
    }
    
    

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseEntered'");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //valores de entrada al presionar el click
        Ex = e.getX();
        Ey = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //valores de salida al soltar el click
        Sx = e.getX();
        Sy = e.getY();
        repaint();//repinta con los valores establecidos
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseEntered'");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //reinicia el canvas cuando el mouse sale de la pantalla
        reinicio = true;
        repaint();
    }
}