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
    int Ex = 0;  //posicion de entrada en x
    int Ey = 0;  //posicion de entrada en y
    int Sx = 0;  //posicion de salida en x
    int Sy = 0;  //posicion de salida en y

    int set1, set2, set3; //valores del rgb

    boolean reinicio = false; //valor de reinicio del canvas

    //Interfaz grafica
    public Canvas3(){
        contenedor = getContentPane();

        addMouseListener(this);

        setSize(500,300);
        setTitle("Pintar lineas de colores aleatorios");
        setLocationRelativeTo(null);
    }

    //Metodo que pinta el canvas
    public void paint(Graphics g){
        //si los valores de entrada son diferentes de 0 pinta
        if(!(Ex == 0 || Ey == 0 || Sx == 0 || Sy ==0 )){
            setRandomColor(); //Establece un color al azar
            g.setColor(new Color(set1, set2, set3));
            g.drawLine(Ex, Ey, Sx, Sy); //Pinta la linea
        }
        if(reinicio){
            g.clearRect(0, 0, getWidth(), getHeight());
            reinicio = false;
        }
    }
    
    //Establece un color al azar
    public void setRandomColor(){
        Random random = new Random();
        set1 = random.nextInt(256);
        set2 = random.nextInt(256);
        set3 = random.nextInt(256);
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
        repaint();
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