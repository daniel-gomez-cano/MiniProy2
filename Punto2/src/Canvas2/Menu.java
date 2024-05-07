package Canvas2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    public Menu() {
        // Configurar la ventana
        setTitle("MENU");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear un contenedor
        Container container = getContentPane();
        container.setLayout(new FlowLayout());

        // Crear botón canvas 2
        JButton boton1 = new JButton("Canvas 2");
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Canvas2 GUI = new Canvas2();
                GUI.setVisible(true);
            }
        });
        container.add(boton1);

        // Crear botón canvas 2-2
        JButton boton2 = new JButton("Canvas 2-2");
        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Canvas22 GUI = new Canvas22();
                GUI.setVisible(true);
            }
        });
        container.add(boton2);

        // Mostrar la ventana
        setVisible(true);
    }
}
