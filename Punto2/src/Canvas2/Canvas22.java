package Canvas2;

import javax.swing.JFrame;


import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

 
public class Canvas22 extends JFrame implements MouseListener{

    Container contenedor;
    //Se crean los vectores para guardar las cords en X y Y
    ArrayList<Integer> vectorX = new ArrayList<>();
    ArrayList<Integer> vectorY = new ArrayList<>();
    //cantidad de puntos(nodos)
    int nodos = 0;
    //Valor que reinicia el canvas
    boolean reinicio = false;
    
    //GUI
    public Canvas22(){
        contenedor = getContentPane();
        addMouseListener(this);

        setSize(500,300);
        setTitle("Poligono con lineas");
        setLocationRelativeTo(null);
    }

    //Metodo para pintar
    public void paint(Graphics g){
        //Bucle que pinta una linea entre cada par de puntos en los vectores
        for(int i = 0; i < (nodos-1);i++){
            g.drawLine(vectorX.get(i), vectorY.get(i),vectorX.get(i+1), vectorY.get(i+1));
        }
        //Borra el canvas
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
        //valores en X y Y
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
        vectorX = new ArrayList<>();
        vectorY = new ArrayList<>();
        nodos = 0;
    }
    @Override
    public void mouseExited(MouseEvent e) {
        reinicio = true;
        repaint();
    }
}
