import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Canvas1.Canvas1;
import Canvas2.Canvas2;
import Canvas2.Canvas22;
import Canvas3.Canvas3;

public class Menu extends JFrame implements ActionListener{
    Container contenedor;
    JLabel especificacion;
    JLabel canvas1,canvas2,canvas22,canvas3;
    JButton botcanvas1,botcanvas2,botcanvas22,botcanvas3;


    public Menu(){
        contenedor = getContentPane();
        FlowLayout layout = new FlowLayout();
        contenedor.setLayout(layout);

        especificacion = new JLabel("Para borrar, sacar el mouse de la GUI");
        contenedor.add(especificacion);

        //canvas1
        canvas1 = new JLabel("Dibujar Lineas negras");
        contenedor.add(canvas1);
        botcanvas1 = new JButton("Ingresar");
        botcanvas1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Canvas1 GUI = new Canvas1();
                GUI.setVisible(true);
            }
        });
        contenedor.add(botcanvas1);

        //canvas2
        canvas2 = new JLabel("Dibujar poligono con puntos");
        contenedor.add(canvas2);
        botcanvas2 = new JButton("Ingresar");
        botcanvas2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Canvas2 GUI = new Canvas2();
                GUI.setVisible(true);
            }
        });
        contenedor.add(botcanvas2);

        //canvas22
        canvas22 = new JLabel("Dibujar poligono rayas");
        contenedor.add(canvas22);
        botcanvas22 = new JButton("Ingresar");
        botcanvas22.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Canvas22 GUI = new Canvas22();
                GUI.setVisible(true);
            }
        });
        contenedor.add(botcanvas22);

        //canvas3
        canvas3 = new JLabel("Dibujar lineas de colores");
        contenedor.add(canvas3);
        botcanvas3 = new JButton("Ingresar");
        botcanvas3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Canvas3 GUI = new Canvas3();
                GUI.setVisible(true);
            }
        });
        contenedor.add(botcanvas3);

        setSize(300,300);
        setTitle("Menu");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
