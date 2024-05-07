package Canvas2;

import javax.swing.JFrame;


import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

 
public class Canvas22 extends JFrame implements MouseListener{

    Container contenedor;
    ArrayList<Integer> vectorX;
    ArrayList<Integer> vectorY;
    int nodos = 0;
    
    boolean reinicio = false;

    public Canvas22(){
        contenedor = getContentPane();
        addMouseListener(this);

        setSize(500,300);
        setTitle("Canvas 2-2");
        setLocationRelativeTo(null);
    }

    public void paint(Graphics g){
        for(int i = 0; i < (nodos-1);i++){
            //pinta cada linea teniendo los valores de los puntos de los vectores
            g.drawLine(vectorX.get(i), vectorY.get(i),vectorX.get(i+1), vectorY.get(i+1));
        }
        if(reinicio){
            g.clearRect(0, 0, getWidth(), getHeight());
            reinicio = false;
        }
    }





    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
    }
    @Override
    public void mousePressed(MouseEvent e) {
        //Valores de los puntos en X y Y
        int x = e.getX();
        int y = e.getY();
        //Valores adicionados a los puntos
        vectorX.add(x);
        vectorY.add(y);

        nodos++; //adicion a la cantidad de puntos/nodos
        repaint();
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        //reinicio a los valores por defecto de las variables
        vectorX = new ArrayList<>();
        vectorY = new ArrayList<>();
        nodos = 0;
    }
    @Override
    public void mouseExited(MouseEvent e) {
        //reinicia el canvas cuando el mouse sale de la pantalla
        reinicio = true;
        repaint();
    }
}
